package com.zemanek.packagedelivery.model;

import java.math.BigDecimal;

/**
 * Class representing a package
 * 
 * @author Petr Zemanek
 *
 */
public class Package {

	private BigDecimal weight;
	private String zipCode;

	/**
	 * Constructor
	 * 
	 * @param weight
	 * @param zipCode
	 */
	public Package(BigDecimal weight, String zipCode) {
		this.weight = weight;
		this.zipCode = zipCode;
	}

	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Package [weight=" + weight + ", zipCode=" + zipCode + "]";
	}

}
