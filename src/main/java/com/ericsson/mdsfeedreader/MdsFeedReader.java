package com.ericsson.mdsfeedreader;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.mdsfeedreader.enums.Brand;
import com.ericsson.mdsfeedreader.enums.Premium;
import com.ericsson.mdsfeedreader.util.MailSender;
import com.ericsson.mdsfeedreader.util.MdsProperties;


public class MdsFeedReader 
{
	private static final Logger logger = Logger.getLogger(MdsFeedReader.class);
	
    public static void main( String[] args )
    {
    	logger.info("*** MDS Feed Reader started ***");
        MdsReader mdsReader = new MdsReader();
        
        List<MdsRecord> recordsList = null;
        
        if (args.length == 0) {
        	recordsList = mdsReader.getMdsRecords(null, null);
        }
        else {
        	recordsList = mdsReader.getMdsRecords(args[0], null);
        }
        
        for (MdsRecord mdsRecord : recordsList) {
        	
        	String externalId = mdsRecord.getItemId();
        	
        	String mds_vubrand = MdsProperties.getDefinition("mds_vubrand").trim();
			String mds_vueqp = MdsProperties.getDefinition("mds_vueqp").trim();
			String mds_awpremium = MdsProperties.getDefinition("mds_awpremium").trim();
			String mds_msrp = MdsProperties.getDefinition("mds_msrp").trim();
			String mds_vueffdate = MdsProperties.getDefinition("mds_vueffdate").trim();
        	
        	if ("UPDATE".equalsIgnoreCase(mdsRecord.getSysNcType())) {
        		String updateColumns = mdsRecord.getUpdateColumns();
        		String[] columns = updateColumns.trim().split(",");
        		
        		if (columns.length == 0) {
        			logger.info("No fields to update");
        		}
        		
        		boolean assetUpdated = true;
        		
        		for (String col : columns) {
        			
					String column = col.trim();
					
					try {
						if (column.equalsIgnoreCase(mds_vubrand)) {
							String vuBrand = mdsRecord.getVuBrand();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: BrandId - metaValue: " + vuBrand);
							
							MediaMgmtApi.updateAssetDiscountMeta(externalId, "brandId", Brand.valueOf(vuBrand).toString());
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_vueqp)) {
							String vuEqp = mdsRecord.getVuEqp();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: EQP - metaValue: " + vuEqp);
							
							MediaMgmtApi.updateAssetDiscountMeta(externalId, "EQP", vuEqp);
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_awpremium)) {
							String extId = mdsRecord.getVuBrand().toLowerCase() +"_"+ externalId;
							String aqPremium = mdsRecord.getAwPremium();
							logger.info("Updating asset [externalId:" + extId + "]: metaKey: isPremium - metaValue: " + Premium.valueOf(aqPremium).toString());
							
							MediaMgmtApi.updateAssetPhoneMeta(extId, "isPremium", Premium.valueOf(aqPremium).toString());
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_msrp)) {
							String extId = mdsRecord.getVuBrand().toLowerCase() +"_"+ externalId;
							String msrp = mdsRecord.getMsrp();
							logger.info("Updating asset [externalId:" + extId + "]: metaKey: MSRP - metaValue: " + msrp);
							
							MediaMgmtApi.updateAssetPhoneMeta(extId, "MSRP", msrp);
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_vueffdate)) {
							String vuEffDate = mdsRecord.getVuEffDate();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: dateLaunch - metaValue: " + vuEffDate);
							
							MediaMgmtApi.updateMetaStartTime(externalId, vuEffDate);
							logger.info("Asset updated");
						}
	        		} catch (Exception e) {
	        			assetUpdated = false;
						logger.error("Execution failed. Asset not updated");
						MailSender.sendEmail("MDS action UPDATE error", "MDS synchronizer action UPDATE error. Please find error folder to process the file manually");
						logger.debug(e, e);
					}
        		}
        		
        		if (assetUpdated == true) {
        			mdsReader.getMdsFileRecords().remove(externalId);
        		}
        	}
        	else if ("INSERT".equalsIgnoreCase(mdsRecord.getSysNcType())) {
        		logger.info("Creating asset [externalId:" + externalId + "]");
        		boolean assetInsert = true;
        		
        		try {
        			
	    			assetInsert = MediaMgmtApi.createNewAsset(
	        				mdsRecord.getItemId(), 
	        				mdsRecord.getItemId(), 
	        				Brand.valueOf(mdsRecord.getVuBrand()), 
	        				"Promotional Discount", 
	        				mdsRecord.getVuEffDate(), 
	        				mdsRecord.getVuEqp(), 
	        				mdsRecord.getProductSet(),
	        				"discount");
	    			
	    			logger.info("Asset created");
    			
				} catch (Exception e) {
					assetInsert = false;
					logger.error("Execution failed. Asset not inserted");
					MailSender.sendEmail("MDS action INSERT error", "MDS synchronizer action INSERT error. Please find error folder to process the file manually");
					logger.debug(e, e);
				}
        		
        		if (assetInsert == true) {
        			mdsReader.getMdsFileRecords().remove(externalId);
        		}
        	}
        	else if ("DELETE".equalsIgnoreCase(mdsRecord.getSysNcType())) {
        		logger.info("Deleting asset [externalId:" + externalId + "]");
        		boolean assetDelete = true;
        		
        		try {
					MediaMgmtApi.updateMetaValidUntil(externalId, mdsRecord.getVuEffDate());
					
					logger.info("Asset deleted");
				} catch (Exception e) {
					assetDelete = false;
					logger.error("Execution failed. Asset not deleted");
					MailSender.sendEmail("MDS action DELETE error", "MDS synchronizer action DELETE error. Please find error folder to process the file manually");
					logger.debug(e, e);
				} 
        		
        		if (assetDelete == true) {
        			mdsReader.getMdsFileRecords().remove(externalId);
        		}
        	}
        }
        
        if (mdsReader.getMdsFile() != null && mdsReader.getMdsFile().isFile()) {
        	logger.info("Processed file: " + mdsReader.getProcessedMdsFileName());
        }
        
        try {
        	mdsReader.createMdsErrorFile();
        } catch(IOException e) {
        	logger.error("Impossible to create error file");
        	logger.debug(e, e);
        }
        
        try {
        	mdsReader.moveProcessedMdsFile();
        } catch(IOException e) {
        	logger.error("Impossible to move processed file");
        	logger.debug(e, e);
        }
        
        logger.info("*** MDS Feed Reader completed ***");
    }
}
