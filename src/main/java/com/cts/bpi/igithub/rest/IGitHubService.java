package com.cts.bpi.igithub.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.bpi.igithub.bo.IGitHubBO;
import com.cts.bpi.igithub.bo.IGitHubBOImpl;
import com.cts.bpi.igithub.exception.IGitHubException;
import com.cts.bpi.igithub.vo.IGitHubVO;

@Path("/igithub")
public class IGitHubService {
	
	private static Logger log = LoggerFactory.getLogger(IGitHubBOImpl.class);
	private IGitHubVO iGitHubVO;
	private IGitHubBO iGitHubBO;

	@GET
	@Path("/verifyRemote")
	@Produces(MediaType.APPLICATION_JSON)
	public IGitHubVO getGitTest() {
		IGitHubVO iGitHubVO = new IGitHubVO();
		iGitHubVO.setBranch("master");
		iGitHubVO.setLocalProjectPath("setLocalProjectPath");
		iGitHubVO.setPassword("setPassword");
		iGitHubVO.setRemoteUrl("setRemoteUrl");
		iGitHubVO.setUserID("setUserID");
		return iGitHubVO;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGitTest(IGitHubVO iGitHubVO) {

		String result = iGitHubVO.toString();
		return Response.status(201).entity(result).build();

	}
	
	@POST
	@Path("/gitClone")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response gitClone(IGitHubVO iGitHubVO) {
		boolean ex = false;
		String message = "";
		try {
			
			if(iGitHubBO == null){
				init();
			}
			
			this.iGitHubVO = iGitHubVO;
			iGitHubBO.gitCloneToLocal(iGitHubVO);
			
			return Response.status(200).entity("Success").build();
			
		} catch (Exception e) {
			ex = true;
			log.info(e.getMessage(), e);
			message = e.getMessage();
			System.out.println(e.getMessage());
			throw new IGitHubException(e.getMessage(), e);
		}finally{
			if(ex){
				return Response.status(202).entity("Not able to checkout : "+ message).build();
			}
		}
	}
	
	@POST
	@Path("/gitValidateURL")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response gitValidateURL(String url) {
		try {
			
			if(iGitHubVO == null){
				init();
			}
			
			iGitHubBO.gitValidateURL(url);
			
			return Response.status(200).entity("Valid URL").build();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage(), e);
			return Response.status(203).entity("Not a Valid URL").build();
		}
		
	}
	
	public void gitValidateAuthentication(String url, String userID, String password) {
		// TODO Auto-generated method stub
		
	}
	
	private void init(){
		if(iGitHubVO == null){
			iGitHubVO = new IGitHubVO();
		}
		
		if(iGitHubBO == null){
			iGitHubBO =  new IGitHubBOImpl();
		}
	}
	
}
