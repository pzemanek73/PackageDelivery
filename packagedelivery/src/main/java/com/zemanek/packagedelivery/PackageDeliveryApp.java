package com.zemanek.packagedelivery;

import com.zemanek.packagedelivery.background.BackgroundLister;
import com.zemanek.packagedelivery.file.FileLoader;
import com.zemanek.packagedelivery.input.InputElementAction;
import com.zemanek.packagedelivery.input.KeyboardMonitor;
import com.zemanek.packagedelivery.storage.PackageStorage;
import com.zemanek.packagedelivery.util.SystemStop;

/**
 * The main class of the Package Delivery Application
 *
 */
public class PackageDeliveryApp {
	public static void main(String[] args) {

		PackageStorage store = new PackageStorage();

		// Check for file load argument
		if (args.length == 1) {
			FileLoader fl = new FileLoader(store, args[0]);
			fl.load();
		}

		// Initialize the background lister
		BackgroundLister bl = new BackgroundLister(store);
		bl.start();

		SystemStop.addStopListener(bl);

		// Initialize the keyboard monitor
		KeyboardMonitor km = new KeyboardMonitor();

		// React to input
		while (!SystemStop.isStop()) {
			try {
				InputElementAction ie = km.monitor();

				if (ie != null) {
					ie.performAction(store);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("App stop");

	}
}
