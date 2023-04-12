package com.supermap.msdelete;

import com.supermap.sps.impl.annotated.AbstractAnnotatedProcessFactory;

public class MsDeleteFactory  extends AbstractAnnotatedProcessFactory{
	
	public MsDeleteFactory() {
		super("msdelete", "DELETE MODEL", "SPH Delete MapService & File", SphProcess.class);
	}

	@Override
	protected String loadLocalizationString(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
