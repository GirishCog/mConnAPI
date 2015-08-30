package com.cts.bpi.imaven.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.bpi.imaven.bo.IMavenBO;
import com.cts.bpi.imaven.bo.IMavenBOImpl;
import com.cts.bpi.imaven.vo.IMavenVO;


@Path("/imaven")
public class IMavenService_Test {
	
	
	private static Logger log = LoggerFactory.getLogger(IMavenService_Test.class);
	private IMavenVO iMavenVO;
	private IMavenBO iMavenBO;

	@GET
	@Path("/verifyRemote")
	@Produces(MediaType.APPLICATION_JSON)
	public IMavenVO getMavenTest() {
		
		return null;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response mavenInstallTest(IMavenVO iMavenVO) {
	//	String result = iMavenVO.toString();
		return Response.status(201).entity(iMavenVO).build();

	}
	
	@POST
	@Path("/install")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response mavenInstall(IMavenVO newiMavenVO) {
		try {
			if(iMavenVO == null){
				init();
			}
			
			iMavenVO = newiMavenVO;
			
			if(iMavenBO == null){
				init();
			}
			
			iMavenBO.mavenInstall(iMavenVO);
			
			return Response.status(201).entity("done").build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return Response.status(202).entity("not able to checkout").build();
		}
	}	
	
	
	private void init(){
		
		if(iMavenVO == null){
			iMavenVO = new IMavenVO();
		}
		
		if(iMavenBO == null){
			iMavenBO =  new IMavenBOImpl();
		}
	}
	
}
