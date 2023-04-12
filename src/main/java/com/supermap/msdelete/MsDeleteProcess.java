package com.supermap.msdelete;

import javax.imageio.IIOException;

import com.supermap.sps.impl.annotated.annotation.InputDef;
import com.supermap.sps.impl.annotated.annotation.OutputDef;
import com.supermap.sps.impl.annotated.annotation.ProcessDef;

@ProcessDef(name ="MsDelete", caption ="MapService & File Delete", description ="MapService & File Delete")
public class MsDeleteProcess extends SphProcess{
	@OutputDef(name="MapService URL", caption="MapService URL", description="Created MapService URL")
	public String execute(
			@InputDef(name="fileItemListStr", caption ="fileItemListStr", defaultValue="", description="itemList JSON Object Item")
			String fileItemListStr,
			@InputDef(name="prjCoordsys", caption ="prjCoordsys", defaultValue="4326", description = "Map prjCoordsys")
			String prjCoordsys
			) throws IIOException{
		
		MsDelete msdelete = new MsDelete(fileItemListStr);
		msdelete.executeMdDelete();
		
		return "";
	}
}
