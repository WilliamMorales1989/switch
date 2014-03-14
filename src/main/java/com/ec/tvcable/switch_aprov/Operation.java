/**
 * 
 */
package com.ec.tvcable.switch_aprov;

/**
 * @author pablo
 *
 */
public class Operation {
	
	public Operation(String target, String function) {
		super();
		this.target = target;
		this.function = function;
	}

	private String target;
	
	private String function;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}
