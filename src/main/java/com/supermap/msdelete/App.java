
package com.supermap.msdelete;

import org.json.JSONArray;
import org.json.JSONObject;

import com.supermap.msdelete.config.Config.Settings;

import com.supermap.msdelete.config.Config;

public class App {

	private static Settings config = null;

   public static void main(String[] args) {
      // TODO Auto-generated method stub

	  config = new Config().settings;
	  System.out.println(config.getIServer().getUser());
	  System.out.println(config.getIServer().getPassword());
	  
      
      JSONObject obj = new JSONObject();
      obj.put("filePath", "/data/upload/20220808/UPLOADED_DATA/1659949585902.udbx");
      obj.put("fileName", "LAN_LC08__116034_20220808T020000_02_RT_ORIGN_RGB000102");
      obj.put("fileType", "tif");
      obj.put("bandIndexs", "00,01,02");
      
      JSONArray arr = new JSONArray();
      arr.put(obj);
      
      JSONObject itemObj = new JSONObject();
      itemObj.put("itemList", arr);
      
      JSONObject itemList = new JSONObject();
      itemList.put("fileItemListStr", itemObj);
      
      System.out.println(itemObj.toString());
      
//      MsDelete msdelete = new MsDelete(itemObj.toString());
//      msdelete.executeMdDelete();
   }

}