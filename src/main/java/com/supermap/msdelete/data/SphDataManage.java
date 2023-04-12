package com.supermap.msdelete.data;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.supermap.data.ColorSpaceType;
import com.supermap.data.DatasetImage;
import com.supermap.data.DatasetType;
import com.supermap.data.DatasetVector;
import com.supermap.data.Datasource;
import com.supermap.data.DatasourceConnectionInfo;
import com.supermap.data.Datasources;
import com.supermap.data.EngineType;
import com.supermap.data.GeoStyle;
import com.supermap.data.PixelFormat;
import com.supermap.data.PrjCoordSys;
import com.supermap.data.Size2D;
import com.supermap.data.Workspace;
import com.supermap.data.WorkspaceConnectionInfo;
import com.supermap.data.WorkspaceType;
import com.supermap.mapping.ImageStretchOption;
import com.supermap.mapping.ImageStretchType;
import com.supermap.mapping.Layer;
import com.supermap.mapping.LayerSettingImage;
import com.supermap.mapping.LayerSettingVector;
import com.supermap.mapping.Map;
import com.supermap.msdelete.utils.SphMDItem;
import com.supermap.msdelete.utils.SphUtil;

public class SphDataManage {
	
	
	private static String ext = ".smwu";
	
	private SphMDItem mdItem;
	
	public SphDataManage() {
		init();
	}

	public SphDataManage(SphMDItem mdItem) {
		this.mdItem = mdItem;
		init();
	}

	public void init() {
		
	}
	
	public void removeFile(String filePath) {
		try {
//			File file = new File("D:/download/testWorkspace.smwu");
			File file = new File(filePath + ext);
			if (file.exists()) {
				if (file.delete())
					System.out.println(filePath + " File Remove");
			} else {
				System.out.println("Not Found File");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// iObject instance release
	public void ReleaseInstance() {
		try {
			/*
			if (target_DS.isOpened()) {
				target_DS.updateDataset();
				target_DS.close();
			}*/
			//temp_WS.dispose();
			System.out.println("release Instance");
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		 * finally { target_DS.close(); temp_WS.dispose();
		 * 
		 * }
		 */
	}
}
