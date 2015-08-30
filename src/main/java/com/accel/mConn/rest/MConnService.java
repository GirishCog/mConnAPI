package com.accel.mConn.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accel.mConn.Parser.MuleApp;
import com.accel.mConn.Parser.MuleApps;
import com.accel.mConn.Parser.MuleServerGroup;
import com.cts.bpi.imaven.bo.IMavenBO;
import com.cts.bpi.imaven.bo.IMavenBOImpl;
import com.cts.bpi.imaven.vo.IMavenVO;
import com.cts.bpi.mconn.constants.Constants;

@Path("/")
public class MConnService {

	private static Logger log = LoggerFactory.getLogger(IMavenService.class);
	private IMavenVO iMavenVO;
	private IMavenBO iMavenBO;

	@PUT
	@Path("/createNewJob/{jobID}")
	public Response createNewJob(
			@QueryParam("activity") List<String> activities,
			@PathParam("jobID") String jobID) {

		Integer code;

		String responseString = null;
		
		

		/*
		 * try { responseString= mConnXMLParser.createJob(jobID, activities); }
		 * catch (JAXBException e) { // TODO Auto-generated catch block code=
		 * 200; e.printStackTrace(); } catch (IOException e) { // TODO
		 * Auto-generated catch block code= 201; e.printStackTrace(); }
		 */

		return Response.status(200).entity(Constants.success).build();
	}

	@POST
	@Path("/coderelease/validate/{appName}/{branchID}")
	public Response validateURL(@PathParam("appName") String appName,
			@PathParam("branchID") String branchID) {

		Integer code;

		String responseString = null;

		/*
		 * try { responseString= IMavenBO.validateURL(appName, branchID); }
		 * catch (JAXBException e) { // TODO Auto-generated catch block code=
		 * 200; e.printStackTrace(); } catch (IOException e) { // TODO
		 * Auto-generated catch block code= 201; e.printStackTrace(); }
		 */

		return Response.status(200).entity(Constants.success).build();

	}

	@POST
	@Path("/coderelease/perform/{jobID}/{repository}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response performCodeRelease(
			@PathParam("repository") String repository,
			@PathParam("jobID") String jobID, List<MuleApp> muleApp) {

		return Response.status(200).entity(getSuccessApps()).build();

	}

	@POST
	@Path("/codebuild/perform/{jobID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response performCodeBuildTest(@PathParam("jobID") String jobID,
			List<MuleApp> muleApp) {

		return Response.status(200).entity(getSuccessApps()).build();

	}

	@POST
	@Path("/deploy/perform/{jobID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response performCodedeploy(@PathParam("jobID") String jobID,
			MuleServerGroup muleServerGroup) {

		return Response.status(200).entity(getSuccessApps()).build();

	}

	@GET
	@Path("/codebuild/list/{jobID}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getBuildList() {
		
		List<String> appList = new ArrayList<String>();
		
		appList.add("myapp1/masterBarnch");
		appList.add("myapp2/branch1");
		appList.add("myapp3/branch2");
		appList.add("myapp4/branch3");

		return Response.status(200).entity(appList).build();

	}

	@GET
	@Path("/deployapps/serverList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeployServerList() {

		return Response.status(200).entity(getServerList()).build();

	}
	
	@GET
	@Path("/appList/{repositoryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppList(@PathParam("repositoryName") String repositoryName) {
		
		List<String> appList = new ArrayList<String>();
		
		appList.add("myapp1");
		appList.add("myapp2");
		appList.add("myapp3");
		appList.add("myapp4");

		return Response.status(200).entity(appList).build();

	}

	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJSON() {

		return Response.status(200).entity(getSuccessApps()).build();

	}

	private List<MuleApp> getSuccessApps() {

		List<MuleApp> muleAppList = new ArrayList<MuleApp>();

		MuleApp e = new MuleApp();
		e.setAppName("myApp1");
		e.setBranchID("master");
		e.setStatus("Succeess");
		e.setMessage("Success Message");
		muleAppList.add(e);
		MuleApp e1 = new MuleApp();
		e1.setAppName("myApp2");
		e1.setBranchID("branchId");
		e1.setStatus("Fail");
		e1.setMessage("Failed - Error Message");
		muleAppList.add(e1);

		return muleAppList;
	}

	private List<MuleServerGroup> getServerList() {

		// List<MuleServerGroup> muleServerGroup = new
		// ArrayList<MuleServerGroup>();

		MuleServerGroup devGroups = new MuleServerGroup();
		devGroups.setServerGroup(Constants.devServerGroupName);

		MuleServerGroup qaGroups = new MuleServerGroup();
		qaGroups.setServerGroup(Constants.qaServerGroupName);

		MuleServerGroup intGroups = new MuleServerGroup();
		intGroups.setServerGroup(Constants.intServerGroupName);

		MuleServerGroup prodGroups = new MuleServerGroup();
		prodGroups.setServerGroup(Constants.prodServerGroupName);

		MuleServerGroup drGroups = new MuleServerGroup();
		drGroups.setServerGroup(Constants.drServerGroupName);
		
		List<String> serverList = new ArrayList<String>();
		serverList.add("127.0.0.1");
		serverList.add("devServer1");
		serverList.add("devServer3");
		serverList.add("127.0.0.4");
		serverList.add("127.0.0.5");
		serverList.add("127.0.0.6");

		devGroups.setServerList(serverList);
		qaGroups.setServerList(serverList);
		intGroups.setServerList(serverList);
		prodGroups.setServerList(serverList);
		drGroups.setServerList(serverList);

		List<MuleServerGroup> msgList = new ArrayList<MuleServerGroup>();
		msgList.add(devGroups);
		msgList.add(qaGroups);
		msgList.add(intGroups);
		msgList.add(prodGroups);
		msgList.add(drGroups);

		return msgList;
	}

	private void init() {

		if (iMavenVO == null) {
			iMavenVO = new IMavenVO();
		}

		if (iMavenBO == null) {
			iMavenBO = new IMavenBOImpl();
		}
	}

}
