package com.ericsson.mdsfeedreader;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class MdsReader {
	//test
	private static final Logger logger = Logger.getLogger(MdsReader.class);

	public List<MDSRecord> getMdsfileRecords(String... path) throws FileNotFoundException {
		
		logger.info("MdsReader.getMdsfileRecords");
		
		List<MDSRecord> recordsList = new ArrayList<MDSRecord>();
		
		Scanner sc;

		// file name was sent via parameter
		if (path.length > 0) {
			logger.info("Recived file name: " + path[0]);
			sc = new Scanner(getMdsPathFile(path[0]));
		}
		// if file name was not sent via parameter.
		else {
			sc = new Scanner(getMdsPathFile());
		}

		String aux;
		String[] temp;

		while (sc.hasNextLine()) {

			aux = sc.nextLine();
			
			if (logger.isDebugEnabled()) {
				logger.debug("Line read: " + aux);
			}

			if (!aux.startsWith("#")) {
				
				
				MDSRecord mdsRecord = new MDSRecord();
				temp = aux.split(MDSRecord.DELIMITER);

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

		return recordsList;
	}

	/**
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	private FileInputStream getMdsPathFile(String... path) throws FileNotFoundException {
		
		File mdsFile = null;
		String mdsFilePath = Iceproperties.getDefinition("mdsfile_path");
		String mdsFileName = Iceproperties.getDefinition("mdsfile_name");
		String nameformat;
		
		logger.info("MdsReader.getMdsPathFile mdsfile_path " + mdsFilePath);
		logger.info("MdsReader.getMdsPathFile mdsfile_name " + mdsFileName);
		
		// read the file indicated wit a parameter.
		if (path.length > 0) {
			logger.info("Recived file name: " + path[0]);
			nameformat = path[0];
		}
		// if filename not provided, make it up for todays date
		else {
			// make file name
			Date date = new Date();
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
			nameformat = mdsFileName + dt1.format(date) + "*.dat";
		}

		logger.info("Reading file " + nameformat);

		File dir = new File(mdsFilePath);
		FileFilter fileFilter = new WildcardFileFilter(nameformat);

		File[] files = dir.listFiles(fileFilter);

		if (files != null && files.length > 0) {
			logger.debug(files[0].getName());
			mdsFile = files[0];
		}

		logger.info("Openning File: " + mdsFile.getAbsolutePath());
		return new FileInputStream(mdsFile);
	}
}
