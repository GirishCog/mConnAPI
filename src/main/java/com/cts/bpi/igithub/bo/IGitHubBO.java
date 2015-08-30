package com.cts.bpi.igithub.bo;


import com.cts.bpi.igithub.vo.IGitHubVO;

public interface IGitHubBO {

	void gitCloneToLocal(IGitHubVO iGitHubVO);
	void gitValidateURL(String url);
	void gitValidateLocalPath(String path);
	void gitValidateAuthentication(String url, String userID, String password);
	
}
