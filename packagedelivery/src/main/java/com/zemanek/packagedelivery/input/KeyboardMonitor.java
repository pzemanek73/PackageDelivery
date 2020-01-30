package com.zemanek.packagedelivery.input;

import java.util.Scanner;

/**
 * Class for monitoring the keyboard input. When input is made an input element
 * is returned
 * 
 * @author Petr Zemanek
 *
 */
public class KeyboardMonitor {

	private Scanner keyboard = new Scanner(System.in);

	public KeyboardMonitor() {
	}

	/**
	 * Monitors keyboard input, one line at a time
	 * @return Input element
	 */
	public InputElementAction monitor() {
		InputElementAction ret = null;
		String inStr = null;

		System.out.println("Enter package weight and ZIP or a command:");

		// Read keyboard input
		if (keyboard.hasNextLine()) {
			inStr = keyboard.nextLine();

			String[] parts = inStr.split(" ");

			if (parts.length == 1) {
				// Command
				String cmd = parts[0].toLowerCase();
				if ("quit".equals(cmd)) {
					ret = new CommandQuit();
				} else {
					throw new IllegalArgumentException("Unknown command");
				}

			} else if (parts.length == 2) {
				// Package info
				ret = new PackageInputValidator(inStr);

			} else {
				throw new IllegalArgumentException("Wrong number of parameters");
			}

		}

		return ret;
	}

}
