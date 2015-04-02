package com.ericsson.mdsfeedreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ericsson.mdsfeedreader.util.MdsProperties;
import com.ericsson.mdsfeedreader.util.SftpClient;

public class MdsReader {
	private static final Logger logger = Logger.getLogger(MdsReader.class);
	
	private File mdsFile = null;
	private Map<String, String> mdsFileRecords = new HashMap<String, String>();
	
	//if null is passed, it will fetch MDS file with today date
	public List<MdsRecord> getMdsRecords(String fileName, Date date) {
		
		List<MdsRecord> recordsList = new ArrayList<MdsRecord>();
		
		if (fileName == null) {
			this.mdsFile = getMdsFile(date);
		}
		else {
			this.mdsFile = getMdsFile(fileName);
		}
		
		if (this.mdsFile == null || !this.mdsFile.isFile()) {
			logger.error("No valid MDS file found with [today] date");
			return recordsList;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.mdsFile))) {
			logger.info("Parsing MDS file " + this.mdsFile);
			
		    String line;
		    String[] temp;
		    while ((line = br.readLine()) != null) {
		    	if (!line.startsWith("#") && !line.isEmpty()) {
					MdsRecord mdsRecord = new MdsRecord();
					temp = line.split(MdsRecord.DELIMITER);
					
					this.mdsFileRecords.put(temp[0], line);

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
	
	public File getMdsFile() {
		return this.mdsFile;
	}
	
	public Map<String, String> getMdsFileRecords() {
		return mdsFileRecords;
	}

	public void setMdsFileRecords(Map<String, String> mdsFileRecords) {
		this.mdsFileRecords = mdsFileRecords;
	}

	public void moveProcessedMdsFile() throws IOException {
		if (mdsFile != null && mdsFile.isFile()) {
			String processedFilePath = MdsProperties.getDefinition("mds.feed.file.processed.path");
			
			Path sourcePath = this.mdsFile.toPath();
			Path destPath = Paths.get(processedFilePath);
			
			if (!Files.exists(destPath)) {
				Files.createDirectory(destPath);
			}
			
			Files.move(sourcePath, Paths.get(destPath + File.separator + this.mdsFile.getName()), StandardCopyOption.REPLACE_EXISTING);
			
			logger.info("Processed file moved to: " + MdsProperties.getDefinition("mds.feed.file.processed.path"));
		}
	}
	
	public void createMdsErrorFile() throws IOException {
		if (this.mdsFile != null && this.mdsFile.isFile() && this.getMdsFileRecords().size() > 0) {
			String header = MdsProperties.getDefinition("mds.feed.file.error.header");
			String errorFilePath = MdsProperties.getDefinition("mds.feed.file.error.path");
			String errorFileName = MdsProperties.getDefinition("mds.feed.file.error.fileName");
			
			BufferedWriter writer = null;
			
	        String timeLog = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	        String fileNameNew = String.format(errorFileName, timeLog, this.mdsFile.getName());
	        File file = new File(errorFilePath + fileNameNew);
	        
	        if (!Files.exists(Paths.get(errorFilePath))) {
				Files.createDirectory(Paths.get(errorFilePath));
			}
	
	        writer = new BufferedWriter(new FileWriter(file));
	        
	        writer.write(header);
	        
	        
	        for (String externalId : this.getMdsFileRecords().keySet()) {
	        	writer.newLine();
	        	writer.write(this.getMdsFileRecords().get(externalId));
	        }
	        
	        writer.close();
	        
	        logger.info("Error file created in: " + MdsProperties.getDefinition("mds.feed.file.error.path"));
		}
	}
	
	public String getProcessedMdsFileName() {
		if (this.mdsFile != null && this.mdsFile.isFile())
			return this.mdsFile.getName();
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
