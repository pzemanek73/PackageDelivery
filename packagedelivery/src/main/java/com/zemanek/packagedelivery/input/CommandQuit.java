package com.zemanek.packagedelivery.input;

import com.zemanek.packagedelivery.storage.PackageStorage;
import com.zemanek.packagedelivery.util.SystemStop;

/**
 * Class for the system quit command
 * 
 * @author Petr Zemanek
 *
 */
public class CommandQuit extends Command {

	public CommandQuit() {
		super();
	}
	
	@Override
	public void performAction(PackageStorage store) {
		SystemStop.stop();
	};

}
