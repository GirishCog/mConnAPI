package com.accel.mConn.Parser;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Actvities {
	
	private String status;
	private String name;
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getSuccessApps() {
		return successApps;
	}

	public void setSuccessApps(String successApps) {
		this.successApps = successApps;
	}
	@XmlElement
	public String getFailedApps() {
		return failedApps;
	}

	public void setFailedApps(String failedApps) {
		this.failedApps = failedApps;
	}

	private boolean needToPerform;
	private String message;
	private String error;
	
	private Date activityTime;
	
	private String  successApps;
	private String failedApps;
	
	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement
	public boolean isNeedToPerform() {
		return needToPerform;
	}

	public void setNeedToPerform(boolean needToPerform) {
		this.needToPerform = needToPerform;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	@XmlElement
	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	
	

}
