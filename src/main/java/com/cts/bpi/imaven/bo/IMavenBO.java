package com.cts.bpi.imaven.bo;

import com.cts.bpi.imaven.vo.IMavenVO;

public interface IMavenBO {

	void mavenInstall(IMavenVO iGitHubVO);

	String validateURL(String appName, String branchID);
	
}
