package com.zlimbu.jnt;

public class EligibilityCalculator {

	EmployeeInfo employeeInfo = new EmployeeInfo();

	public boolean eligibleForHike(EmployeeInfo empInfo) {
		if (empInfo.employeeInfoValidator()) {
			if (empInfo.salary > 24000 && empInfo.designation.equals("Manager")) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new IllegalArgumentException("Incorrect Employee Info passed");
		}
	}
}