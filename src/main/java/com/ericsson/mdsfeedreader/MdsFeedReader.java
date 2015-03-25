package com.ericsson.mdsfeedreader;

import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.mdsfeedreader.enums.Brand;
import com.ericsson.mdsfeedreader.enums.Premium;
import com.ericsson.mdsfeedreader.util.MdsProperties;
import com.ericsson.mdsfeedreader.util.MsdpProperties;


public class MdsFeedReader 
{
	
	private static final Logger logger = Logger.getLogger(MdsFeedReader.class);
	
	private static final String providerId = MsdpProperties.getDefinition("mdsp.media.providerid");
	
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
        		
        		for (String col : columns) {
        			
					String column = col.trim();
					
					try {
						if (column.equalsIgnoreCase(mds_vubrand)) {
							String vuBrand = mdsRecord.getVuBrand();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: BrandId - metaValue: " + vuBrand);
							
							MediaMgmtApi.updateAssetMeta(externalId, "brandId", Brand.valueOf(vuBrand).toString());
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_vueqp)) {
							String vuEqp = mdsRecord.getVuEqp();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: EQP - metaValue: " + vuEqp);
							
							MediaMgmtApi.updateAssetMeta(externalId, "EQP", vuEqp);
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_awpremium)) {
							String aqPremium = mdsRecord.getAwPremium();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: isPremium - metaValue: " + Premium.valueOf(aqPremium).toString());
							
							MediaMgmtApi.updateAssetMeta(externalId, "isPremium", Premium.valueOf(aqPremium).toString());
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_msrp)) {
							String msrp = mdsRecord.getMsrp();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: MSRP - metaValue: " + msrp);
							
							MediaMgmtApi.updateAssetMeta(externalId, "MSRP", msrp);
							logger.info("Asset updated");
						}
						if (column.equalsIgnoreCase(mds_vueffdate)) {
							String vuEffDate = mdsRecord.getVuEffDate();
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: dateLaunch - metaValue: " + vuEffDate);
							
							MediaMgmtApi.updateAssetMeta(externalId, "dateLaunch", vuEffDate);
							logger.info("Asset updated");
						}
	        		} catch (Exception e) {
						logger.error("Asset not updated");
						logger.debug(e, e);
					}
        		}
        	}
        	else if ("INSERT".equalsIgnoreCase(mdsRecord.getSysNcType())) {
        		logger.info("Operation INSERT skipped...");
        	}
        	else if ("DELETE".equalsIgnoreCase(mdsRecord.getSysNcType())) {
        		logger.info("Operation DELETE skipped...");
        	}
        }
        
        logger.info("*** MDS Feed Reader completed ***");
    }
}
