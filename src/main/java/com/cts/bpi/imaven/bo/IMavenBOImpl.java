package com.cts.bpi.imaven.bo;

import java.io.File;
import java.io.PrintStream;
import java.util.Collections;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationOutputHandler;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.InvokerLogger;
import org.apache.maven.shared.invoker.PrintStreamHandler;
import org.codehaus.plexus.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.bpi.imaven.exception.IMavenException;
import com.cts.bpi.imaven.vo.IMavenVO;

public class IMavenBOImpl implements IMavenBO {

	private static Logger log = LoggerFactory.getLogger(IMavenBOImpl.class);

	public void mavenInstall(IMavenVO iMavenVO) {

		try {

			InvocationRequest request = new DefaultInvocationRequest();
			
			request.setPomFile(new File(iMavenVO.getMavenProjectPath()+"/pom.xml"));
			request.setGoals(Collections.singletonList("package"));
			PrintStream out = new PrintStream(iMavenVO.getMavenLogPath()+"/"+iMavenVO.getLogFileName());
			InvocationOutputHandler outputHandler = new PrintStreamHandler(out, true);
			request.setOutputHandler(outputHandler);

			Invoker invoker = new DefaultInvoker();
			File mvnhome = new File(iMavenVO.getMavenPath());
			invoker.setMavenHome(mvnhome);

			invoker.setOutputHandler(outputHandler);
			InvokerLogger log = invoker.getLogger();
			log.setThreshold(4);
			invoker.setLogger(log);

			InvocationResult result = invoker.execute(request);

			log.info(result.getExitCode()+"");

			moveToFolder(iMavenVO);
			
		} catch (Exception e) {
			log.info(e.getMessage(), e);
			throw new IMavenException(e.getMessage(), e);
		} finally {

		}

	}
	
	public void moveToFolder(IMavenVO iMavenVO)
    {	
    	try{
 
    	   File movefile =new File(iMavenVO.getMavenProjectPath()+"/target/"+iMavenVO.getWarFileName());
    	   File destfile = new File(iMavenVO.getMoveWarFileTo() +"/"+ movefile.getName());
    	   FileUtils.copyFile(movefile, destfile);
    	   log.info("File is moved successful!");
 
    	}catch(Exception e){
    		 log.info("File is failed to move!");
    		log.info(e.getMessage(), e);
			throw new IMavenException(e.getMessage(), e);
    	}
    }

	@Override
	public String validateURL(String appName, String branchID) {
		// TODO Auto-generated method stub
		return null;
	}

}
