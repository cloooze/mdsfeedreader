package com.ericsson.mdsfeedreader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil {
	
	public static XMLGregorianCalendar getXMLGregorianCalendar(String date) throws DatatypeConfigurationException, ParseException {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d = simpleDateFormat.parse(date); 
        
        GregorianCalendar gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
        gregorianCalendar.setTime(d);
        
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
	}

}
