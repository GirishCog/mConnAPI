package com.accel.mConn.Parser;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

public class Job {
	
	
	private String id;
	
	private String type;
	
	private String name;
	
	private String performApps;
	
	
	

	private Date jobTime;
	
	

	private List<Actvities> activites;

	@XmlElement


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	@XmlElement


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	@XmlElement

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@XmlElement

	public String getPerformApps() {
		return performApps;
	}



	public void setPerformApps(String performApps) {
		this.performApps = performApps;
	}

	@XmlElement


	public Date getJobTime() {
		return jobTime;
	}



	public void setJobTime(Date jobTime) {
		this.jobTime = jobTime;
	}

	@XmlElement

	public List<Actvities> getActivites() {
		return activites;
	}



	public void setActivites(List<Actvities> activites) {
		this.activites = activites;
	}


	

	



	
	
	
	

}
