package com.ericsson.mdsfeedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ericsson.mdsfeedreader.util.MdsProperties;
import com.ericsson.mdsfeedreader.util.SftpClient;

public class MdsReader {
	private static final Logger logger = Logger.getLogger(MdsReader.class);
	
	private File file = null;
	
	//if null is passed, it will fetch MDS file with today date
	public List<MdsRecord> getMdsRecords(String fileName, Date date) {
		
		List<MdsRecord> recordsList = new ArrayList<MdsRecord>();
		
		if (fileName == null) {
			this.file = getMdsFile(date);
		}
		else {
			this.file = getMdsFile(fileName);
		}
		
		if (this.file == null) {
			logger.error("No MDS file found with [today] date");
			return recordsList;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			logger.info("Parsing MDS file " + this.file);
			
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
			logger.error("Error retrieving MDS file");
			logger.debug(e, e);
		}
		
		return recordsList;
	}
	
	public void moveProcessedFile() throws IOException {
		String processedFilePath = MdsProperties.getDefinition("mds.feed.file.processed.path");
		
		Path sourcePath = this.file.toPath();
		Path destPath = Paths.get(processedFilePath);
		
		if (!Files.exists(destPath)) {
			Files.createDirectory(destPath);
		}
		
		Files.move(sourcePath, Paths.get(destPath + File.separator + this.file.getName()), StandardCopyOption.REPLACE_EXISTING);

	}
	
	public String getProcessedFileName() {
		if (this.file != null)
			return this.file.getName();
		else 
			return null;
	}
	
	private static File getMdsFile(String fileName) {
		try {
//			String filePath = MdsProperties.getDefinition("mds.feed.file.path") + fileName;
			return new File(fileName);
		}catch (Exception e) {
			return null;
		}
	}
	
	private static File getMdsFile(Date date) {
		String filesPath = MdsProperties.getDefinition("mds.feed.file.path");
		
		String fetchedRemoteFileName = getMdsRemoteFile(date);
		
		if (fetchedRemoteFileName == null) {
			return null;
		}
		
		return new File(filesPath + fetchedRemoteFileName);
	}
	
	private static String getMdsRemoteFile(Date date) {
		return SftpClient.getRemoteFile(buildFileName(date));
	}
	
	private static String buildFileName(Date date) {
		String filePrefix = MdsProperties.getDefinition("mds.feed.file.prefix");
		String fileExt = MdsProperties.getDefinition("mds.feed.file.ext");
		String dateFormat = MdsProperties.getDefinition("mds.feed.file.dateformat");
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		String dateString = sdf.format(date==null?new Date():date);
		
		return filePrefix + dateString + "*" + fileExt;
	}
}
