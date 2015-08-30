package com.cts.bpi.imaven.vo;

public class IMavenVO {
	
	private String mavenPath;
	private String mavenLogPath;
	private String logFileName;
	private String branchId;
	private String warFileName;
	private String mavenProjectPath;
	private String moveWarFileTo;
	
	
	public String getMavenPath() {
		return mavenPath;
	}

	public String getMavenProjectPath() {
		return mavenProjectPath;
	}

	public void setMavenProjectPath(String mavenProjectPath) {
		this.mavenProjectPath = mavenProjectPath;
	}

	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

	public String getMavenLogPath() {
		return mavenLogPath;
	}

	public void setMavenLogPath(String mavenLogPath) {
		this.mavenLogPath = mavenLogPath;
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getWarFileName() {
		return warFileName;
	}

	public void setWarFileName(String warFileName) {
		this.warFileName = warFileName;
	}

	public String getMoveWarFileTo() {
		return moveWarFileTo;
	}

	public void setMoveWarFileTo(String moveWarFileTo) {
		this.moveWarFileTo = moveWarFileTo;
	}

	@Override
	public String toString() {
		return "Details: logFileName : " + this.logFileName + ", mavenPath : " + this.mavenPath 
				+ ", warFileName : " + this.warFileName 
				+", mavenLogPath : " + this.mavenLogPath 
				+", branchId : " + this.branchId 
				+", moveWarFileTo : " + this.moveWarFileTo 				
				+", mavenProjectPath : " + this.mavenProjectPath ;
	}
	
}
