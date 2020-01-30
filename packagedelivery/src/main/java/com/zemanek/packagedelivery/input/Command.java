package com.zemanek.packagedelivery.input;

import com.zemanek.packagedelivery.storage.PackageStorage;

/**
 * Base command class
 * @author Petr Zemanek
 *
 */
public abstract class Command implements InputElementAction {
	
	public Command() {
	}

	@Override
	public abstract void performAction(PackageStorage store);
}

