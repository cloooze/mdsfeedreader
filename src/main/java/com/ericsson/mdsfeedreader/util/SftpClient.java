package com.ericsson.mdsfeedreader.util;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpClient {
	
	private static final String MDS_REMOTE_IP= MdsProperties.getDefinition("mds.system.remote.ip");
	private static final String MDS_REMOTE_PATH= MdsProperties.getDefinition("mds.system.remote.path");
	private static final String MDS_LOCAL_PATH= MdsProperties.getDefinition("mds.feed.file.path");
	private static final String MDS_USERNAME= MdsProperties.getDefinition("mds.system.username");
	private static final String MDS_PASSWORD= MdsProperties.getDefinition("mds.system.password");
	
	public static void getRemoteFile(String fileName) {
		
//		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		
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
            sftpChannel.get(MDS_REMOTE_PATH + fileName, MDS_LOCAL_PATH + fileName);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }

}
