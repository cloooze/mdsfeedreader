package com.ericsson.mdsfeedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;

import com.ericsson.mdsfeedreader.util.MdsProperties;

public class MdsReader {
	private static final Logger logger = Logger.getLogger(MdsReader.class);
	
	//if null is passed, it will fetch MDS file with today date
	public List<MdsRecord> getMdsRecords(Date date) {
		
		List<MdsRecord> recordsList = new ArrayList<MdsRecord>();
		
		File file = getMdsFile(date);
		
		if (file == null) {
			logger.info("No MDS file found");
			return recordsList;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    String[] temp;
		    while ((line = br.readLine()) != null) {
		    	if (!line.startsWith("#") && !line.isEmpty()) {
					
					MdsRecord mdsRecord = new MdsRecord();
					temp = line.split(MdsRecord.DELIMITER);

					mdsRecord.setItemId(temp[0]);
					mdsRecord.setVuBrand(temp[1]);
					mdsRecord.setVuEffDate(temp[2]);
					mdsRecord.setVuEqp(temp[3]);
					mdsRecord.setAwPremium(temp[4]);
					mdsRecord.setMsrp(temp[5]);
					mdsRecord.setProductSet(temp[6]);
					mdsRecord.setUpdateColumns(temp[7]);
					mdsRecord.setSysNcType(temp[8]);

					if (logger.isDebugEnabled()) {
						logger.debug("Objet: " + mdsRecord);
					}
					
					recordsList.add(mdsRecord);
				}
		    }
		} catch (IOException e) {
			logger.error(e, e);
		}
		
		return recordsList;
	}
	
	private static File getMdsFile(Date date) {
		String filesPath = MdsProperties.getDefinition("mds.feed.file.path");
		String filePrefix = MdsProperties.getDefinition("mds.feed.file.prefix");
		String fileExt = MdsProperties.getDefinition("mds.feed.file.ext");
		String dateFormat = MdsProperties.getDefinition("mds.feed.file.dateformat");
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		String dateString = sdf.format(date==null?new Date():date);
		
		File dir = new File(filesPath);
		FileFilter filter = new WildcardFileFilter(filePrefix + dateString + "*" + fileExt);
		
		return dir.listFiles(filter).length>0? dir.listFiles(filter)[0]:null;	
	}
}
