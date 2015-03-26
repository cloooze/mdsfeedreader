package com.ericsson.mdsfeedreader.util;

import java.util.Vector;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpClient {
	
	private static final String MDS_REMOTE_IP= MdsProperties.getDefinition("mds.system.remote.ip");
	private static final String MDS_REMOTE_PATH= MdsProperties.getDefinition("mds.system.remote.path");
	private static final String MDS_LOCAL_PATH= MdsProperties.getDefinition("mds.feed.file.path");
	private static final String MDS_USERNAME= MdsProperties.getDefinition("mds.system.username");
	private static final String MDS_PASSWORD= MdsProperties.getDefinition("mds.system.password");
	
	private static final Logger logger = Logger.getLogger(SftpClient.class);
	
	public static String getRemoteFile(String fileName) {
		
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(MDS_USERNAME, MDS_REMOTE_IP, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(MDS_PASSWORD);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            
            logger.info("Fetching remote MDS file (matching reg expr): " + MDS_REMOTE_IP + ":" + MDS_REMOTE_PATH + fileName);
            
            //fetch all files from remote directory
            Vector<ChannelSftp.LsEntry> lsResult = sftpChannel.ls(fileName);
            
            if (lsResult.size() == 0) {
            	return null;
            }
            
            sftpChannel.get(MDS_REMOTE_PATH + fileName, MDS_LOCAL_PATH + lsResult.get(0).getFilename());
            logger.info("MDS file succesfully downloaded to location: " + MDS_LOCAL_PATH + lsResult.get(0).getFilename());
            
            sftpChannel.exit();
            
            return lsResult.get(0).getFilename();
        } catch (Exception e) {
            logger.debug(e, e);  
        } finally {
        	if (session.isConnected())
        		session.disconnect();
        }
        return null;
    }
}
