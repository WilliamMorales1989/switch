/**
 * 
 */
package com.ec.tvcable.switchaprov;

/**
 * @author pablo
 *
 */
public class Operation {
	
	public Operation(String system, String activityType) {
		super();
		this.system = system;
		this.activityType = activityType;
	}

	private String system;
	
	private String activityType;

	public String getSystem() {
		return system;
	}

	public void setSystem(String target) {
		this.system = target;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String function) {
		this.activityType = function;
	}

}
