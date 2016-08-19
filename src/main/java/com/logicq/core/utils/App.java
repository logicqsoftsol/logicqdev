package com.logicq.core.utils;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class App {

	private static final Logger logger = Logger.getLogger(App.class);
	static JSch jsch = new JSch();
	
	public static void main(String[] args) {
      if(null==args[0]){
    	  logger.error("Missing user name :"+args[0] );
	     System.exit(-1);
  }
      if(null==args[2]){
    	  logger.error("Missing Domain name :"+args[1] );
	   System.exit(-1);
  }
      if(null==args[1]){
    	  logger.error("Missing password for domain :"+args[2] );
	  System.exit(-1);
  }
      if(null==args[3]){
    	  logger.error("Missing File to be Transfer path:"+args[3] );
	  System.exit(-1);
  }
      if(null==args[4]){
    	  logger.error("Missing File path  where you want to Transfer :"+args[4] );
	  System.exit(-1);
  }
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		
		Session session = null;
		try {
			session = jsch.getSession(args[0], args[2], 22);
			session.setConfig(config);
			// session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(args[1]);
			session.connect();
			System.out.println("Open Session For Connection");
			Channel channel = session.openChannel("sftp");
			System.out.println("Open Channel using SFTP Protocol");
			channel.connect();
			System.out.println("Connectd chanel using sftp");
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.put(args[3], args[4]);
			//sftpChannel.put("F:/logicqsoftware-client/schollmangment.docx", "/home/docathouse/msacess/");
			sftpChannel.exit();
			System.out.println("File Transfer  using sftp File name :"+args[3]);
			session.disconnect();
		} catch (JSchException ex) {
			logger.error(" Unable to upload file :" + ex.getMessage(), ex);
		} catch (SftpException ex) {
			logger.error(" Unable to upload file :" + ex.getMessage(), ex);
		}finally{
			if(null!=session){
			session.disconnect();
			}
		}
	}
	   
	

}
