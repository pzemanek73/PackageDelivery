package com.zemanek.packagedelivery.file;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.zemanek.packagedelivery.input.PackageInputValidator;
import com.zemanek.packagedelivery.storage.PackageStorage;

/**
 * Class to load Package items from a file
 * 
 * @author Petr Zemanek
 *
 */
public class FileLoader {

	private PackageStorage store;
	private String file;

	public FileLoader(PackageStorage store, String file) {
		this.store = store;
		this.file = file;
	}

	/**
	 * Loads items from a file
	 */
	public void load() {

		System.out.println("Attempting to load file");
		try (Stream<String> stream = Files.lines(Paths.get(file))) {

			stream.forEach(s -> {
				try {
					PackageInputValidator pckgIn = new PackageInputValidator(s);
					pckgIn.performAction(store);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
