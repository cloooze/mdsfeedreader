package com.ericsson.mdsfeedreader;

import java.util.List;

import org.apache.log4j.Logger;


public class App 
{
	
	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        MdsReader mdsReader = new MdsReader();
        
        List<MdsRecord> recordsList = mdsReader.getMdsRecords(null);
        
        logger.info("RECORD LIST: " + recordsList);
    }
}
