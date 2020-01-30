package com.zemanek.packagedelivery.util;

import java.util.ArrayList;

/**
 * Utility class for system stop handling
 * 
 * @author Petr Zemanek
 *
 */
public class SystemStop {

	private static boolean stop = false;
	private static ArrayList<StopListener> li = new ArrayList<StopListener>();

	/**
	 * Whether the app stop is requested
	 * @return
	 */
	public static synchronized boolean isStop() {
		return stop;
	}

	/**
	 * Requests the app stop
	 */
	public static synchronized void stop() {
		stop = true;

		notifyListeners();
	}

	public static void addStopListener(StopListener l) {
		li.add(l);
	}

	private static void notifyListeners() {
		for (StopListener l : li) {
			l.stopRequested();
		}
	}
}
