package com.supermap.msdelete.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.supermap.msdelete.rest.Sender;

public class Sender {

//	private static String iServerUrl = "http://127.0.0.1:8090/iserver";
//	private static String iServerUrl = "http://demo.sphinfo.co.kr:8100/iserver";
	private static String iServerUrl = "http://localhost:8100/iserver";
	
	private static Sender sender = new Sender();
	public static Sender getInstance() {
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		//iServerUrl = new Config().settings.getSatellite().getiServerUrl();
		return sender;
	}
	
	/** 
	 * SuperMap iServer REST
	 * @param path REST URL
	 * @param method 
	 * @param message
	 * @return
	 * http://zetcode.com/java/getpostrequest/
	 */
	public String send(String path, String method, String message) throws Exception{
		String ret = null;
		URL url = null;
		HttpURLConnection conn = null;
		try{
			if(path.contains("/iserver/services"))
				url = new URL(path);
			else
				url = new URL(iServerUrl + path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn = (HttpURLConnection)url.openConnection();
			if(!"GET".equals(method)) {
				conn.setDoInput(true);
				conn.setDoOutput(true);				
			}
			conn.setRequestMethod(method);

			if(!"GET".equals(method)) {
				OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
				out.write(message);
				out.close();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String tmpStr = null;
			StringBuilder sb = new StringBuilder();
			while((tmpStr = in.readLine()) != null){
				sb.append(tmpStr).append(" ");
			}
			ret = sb.toString();
			in.close();
			conn.disconnect();
		}catch(Exception e){
			conn.disconnect();
			throw e;
		}
		return ret;
	}
}
