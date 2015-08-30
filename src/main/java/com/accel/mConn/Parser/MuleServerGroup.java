package com.accel.mConn.Parser;

import java.util.ArrayList;
import java.util.List;

public class MuleServerGroup {
	
	public String getServerGroup() {
		return serverGroup;
	}
	public void setServerGroup(String serverGroup) {
		this.serverGroup = serverGroup;
	}
	public List<String> getServerList() {
		return serverList;
	}
	public void setServerList(List<String> serverList) {
		this.serverList = serverList;
	}
	String serverGroup;
	List<String> serverList = new ArrayList<String>();

}
