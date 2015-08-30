package com.accel.mConn.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

import com.cts.bpi.mconn.constants.Constants;



public class mConnXMLParser {
	
	 static Marshaller jobMarshaller =null;
	 static JAXBContext jobContext = null;
	static Unmarshaller jobUnmarshaller = null;
	static String dataXMLFolder ="/Users/girishreddy/Documents/workspace/Data/xml/";
	static {
		try {
			jobContext = JAXBContext.newInstance(Job.class);
			jobMarshaller = jobContext.createMarshaller();
			jobUnmarshaller	= jobContext.createUnmarshaller();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static  Actvities newActivity(String name){
		
		
		Actvities activity = new Actvities();
		Date date = new Date();
		activity.setActivityTime(date );
		activity.setNeedToPerform(true);
		activity.setName(name);
		
		return activity;
		
	}
	
	public static String createJob( String jobId,List<String> acts) throws JAXBException, IOException{
		
		
		Job job= new Job();
		
		List<Actvities> activites= new ArrayList<Actvities>();
		
	
		for (String act : acts) {
			
			
			
			if(act.equalsIgnoreCase(Constants.codeReview)){
				activites.add(newActivity(Constants.codeReview));
				job.setActivites(activites);
			}
			else if (act.equalsIgnoreCase(Constants.codeTestBuild)){
				activites.add(newActivity(Constants.codeTestBuild));
				job.setActivites(activites);
			
			}else if (act.equalsIgnoreCase(Constants.codedeploy)){
				activites.add(newActivity(Constants.codedeploy));
				job.setActivites(activites);
			}
		}
		return 	writeJobData(job,jobId);
		}
	
	public static Job readJob( String jobId) throws JAXBException{
		
		return (Job)jobUnmarshaller.unmarshal(getFile(jobId));
	
	
	}
	
	private static File getFile(String jobId) {
		// TODO Auto-generated method stub
		return new File(dataXMLFolder+jobId+".xml");
	}

	public static boolean doesJobIdExist(String jobId) throws IOException, JAXBException{
	
		
		if (!getFile(jobId).exists()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	public static String writeJobData( Job job, String jobId) throws IOException, JAXBException{
	
		File file = getFile(jobId);
		if (!file.exists()) {
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());	
			jobMarshaller.marshal(job,fw);
			return "success";
		}else {
			return Constants.filePresent;
		}
	
	}
	public static void main(String[] args) {
		
		Date actDate= new Date();
		
		Job job= new Job();
		
		
		job.setId("1244");

		job.setJobTime(actDate);
		
		job.setPerformApps("myApp:master,myApp2:branch");
		List<Actvities> activites= new ArrayList<Actvities>();
		
		Actvities activity = new Actvities();
		activity.setActivityTime(actDate);
		activity.setNeedToPerform(false);
		activity.setMessage("Success_Message");
		activity.setStatus("Success_Status");
		activity.setFailedApps("myApp:master+error test");
		activity.setSuccessApps("myApp_2:branch+Success");
		activites.add(activity);
		job.setActivites(activites);
		
		
		//job.setCodeReleaseJob(codeReleaseJob);
		try {
			System.out.println("Start");
			System.out.println(writeJobData(job, "12346"));
			
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
