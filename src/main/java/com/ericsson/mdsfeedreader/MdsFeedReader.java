package com.ericsson.mdsfeedreader;

import java.util.List;

import org.apache.log4j.Logger;

import com.drutt.ws.msdp.media.management.v3.WSException_Exception;
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
        
        List<MdsRecord> recordsList = mdsReader.getMdsRecords(null);
        
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
							logger.info("Updating asset [externalId:" + externalId + "]: metaKey: GeneralAvailabilityDate - metaValue: " + vuEffDate);
							
							MediaMgmtApi.updateAssetMeta(externalId, "GeneralAvailabilityDate", vuEffDate);
							logger.info("Asset updated");
						}
	        		} catch (WSException_Exception e) {
						logger.error("Asset not updated");
						logger.debug(e, e);
					}
        		}
        	}
        }
        
        logger.info("*** MDS Feed Reader completed ***");
    }
}
