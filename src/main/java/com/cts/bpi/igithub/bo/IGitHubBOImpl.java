package com.cts.bpi.igithub.bo;

import java.io.File;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cts.bpi.igithub.vo.IGitHubVO;
import com.cts.bpi.igithub.exception.IGitHubException;


public class IGitHubBOImpl implements IGitHubBO {
	
	private static Logger log = LoggerFactory.getLogger(IGitHubBOImpl.class);
	
	private File localPath;
	private Git result;

	@Override
	public void gitCloneToLocal(IGitHubVO iGitHubVO) {
		try {
			String path = iGitHubVO.getLocalProjectPath();
			
			getLocalPath((iGitHubVO.getBranchId() == null ? path : path+"/"+iGitHubVO.getBranchId()) +"/"+iGitHubVO.getProjectName());

			CredentialsProvider credentialsProvider = getCredentialsProvider(iGitHubVO.getUserID(), iGitHubVO.getPassword());

			CloneCommand cloneCommand = new CloneCommand()
					.setCredentialsProvider(credentialsProvider)
					.setDirectory(localPath).setURI(iGitHubVO.getRemoteUrl()).setBranch(iGitHubVO.getBranch());
			
			result = cloneCommand.call();
			//result.getRepository().getDirectory();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IGitHubException(e.getMessage(), e);
		} finally{
			if(result != null){
				result.close();
			}
		}
		
	}
	
	@Override
	public void gitValidateURL(String url) {
		try {
			CloneCommand cloneCommand = new CloneCommand();
			cloneCommand.setRemote(url);
			result = cloneCommand.call();
		 } catch (Exception  e) {
			log.error(e.getMessage(), e);
			throw new IGitHubException(e.getMessage(), e);
		} finally{
			if(result != null){
				result.close();
			}
		}
	}

	@Override
	public void gitValidateLocalPath(String path) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gitValidateAuthentication(String url, String userID, String password) {
		// TODO Auto-generated method stub
	}
	
	private void getLocalPath(String path){
		try{
			localPath = new File(path);
			localPath.deleteOnExit();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IGitHubException(e.getMessage(), e);
		}
	}
	
	private CredentialsProvider getCredentialsProvider(String userID, String password){
		return new UsernamePasswordCredentialsProvider(userID, password);
	}

}
