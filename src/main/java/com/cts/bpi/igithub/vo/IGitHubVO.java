package com.cts.bpi.igithub.vo;

public class IGitHubVO {
	
	private String remoteUrl;
	private String localProjectPath;
	private String branch;
	private String branchId;
	private String userID;
	private String password;
	private String projectName;
	
	public String getRemoteUrl() {
		return remoteUrl;
	}
	
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}
	
	public String getLocalProjectPath() {
		return localProjectPath;
	}
	
	public void setLocalProjectPath(String localProjectPath) {
		this.localProjectPath = localProjectPath;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
			
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Details: remoteUrl : " + this.remoteUrl 
				+", localProjectPath : " + this.localProjectPath 
				+", branchId : " + this.branchId 
				+", branch : " + this.branch 
				+ ", projectName : " + this.projectName 
				+ ", userID : " + this.userID 
				+ ", password : " + this.password;  
	}
}
