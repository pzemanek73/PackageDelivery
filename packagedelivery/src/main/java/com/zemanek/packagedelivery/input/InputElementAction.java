package com.zemanek.packagedelivery.input;

import com.zemanek.packagedelivery.storage.PackageStorage;

public interface InputElementAction {
	
	public void performAction(PackageStorage store);

}
