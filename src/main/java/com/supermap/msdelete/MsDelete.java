package com.supermap.msdelete;

import org.json.JSONArray;
import org.json.JSONObject;

import com.supermap.msdelete.config.Config;
import com.supermap.msdelete.config.Config.Settings;
import com.supermap.msdelete.data.SphDataManage;
import com.supermap.msdelete.service.SphService;
import com.supermap.msdelete.utils.SphFileInfo;
import com.supermap.msdelete.utils.SphMDItem;
import com.supermap.msdelete.utils.SphUtil;

public class MsDelete {

	private static Settings config = null;
	private String fileItemListStr;
	private String token = null;
	
	private SphDataManage manage = null;
	private SphService service;
	private SphMDItem mdItem = null;
	
	private static String fileDefaultLocation = "/data/workspaces/";
//	private static String fileDefaultLocation = "D:/download/";
	private static String ext = "smwu";
	
	public MsDelete() {
	    config = new Config().settings;
	}
	
	public MsDelete(String fileItemListStr) {
		this.fileItemListStr = fileItemListStr;
		this.service = new SphService();
		
		this.mdItem = new SphMDItem();
		this.mdItem.setItemListarr(SphUtil.getJsonArrayList(this.fileItemListStr));
		
		String iServerUserName = config.getIServer().getUser();
		String iServerPassword = config.getIServer().getPassword();
		
		token = service.getToken(iServerUserName, iServerPassword);
		if(!token.equals("")) {
			this.mdItem.setToken(token);
		}
		
		manage = new SphDataManage();
	}
	
	public String executeMdDelete() {
		try {
			
			JSONArray array = this.mdItem.getItemListarr();
			System.out.println(array);
			for ( Object item : array) {
				JSONObject objItem = (JSONObject)item;
				String fileName = objItem.getString(SphFileInfo.FILENAME.toString());
				// 1. Workspace Service Delete
				service.deleteService(this.mdItem.getToken(), fileDefaultLocation + fileName + "." + ext);
				// 2. Delete File 
				manage.removeFile(fileDefaultLocation + fileName);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return "";
	}
	

}
