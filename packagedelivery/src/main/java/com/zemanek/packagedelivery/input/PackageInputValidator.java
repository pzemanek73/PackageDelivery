package com.zemanek.packagedelivery.input;

import java.math.BigDecimal;

import com.zemanek.packagedelivery.model.Package;
import com.zemanek.packagedelivery.storage.PackageStorage;

/**
 * Class for validating the package input values
 * 
 * @author Petr Zemanek
 *
 */
public class PackageInputValidator implements InputElementAction {

	private String inStr;
	private Package pckg;

	public PackageInputValidator(String inStr) {
		this.inStr = inStr;
	}

	@Override
	public void performAction(PackageStorage store) {
		String[] parts = inStr.split(" ");
		
		// Check weight
		BigDecimal w = null;
		try {
			w = new BigDecimal(parts[0]);
		} catch (Exception e) {
		}
		if (w.doubleValue() < 0 || w.scale() > 3) {
			throw new IllegalArgumentException("Invalid weight format [9.999]");
		}
		
		// Check ZIP
		String zip = parts[1];
		if (!zip.matches("[0-9]+") || zip.length() != 5) {
			throw new IllegalArgumentException("Invalid ZIP format [99999]");
		}

		// Add to storage
		pckg = new Package(w, zip);
		store.addPackage(pckg);
	}

	public Package getPackage() {
		return pckg;
	}

}
