package com.zlimbu.jnt;

import java.util.Map;

public class StudentPortal {
	private DatabaseInterface calcService;

	public int saveStudentInfo(int stdID, String stdName) {
		return calcService.saveToDB(stdID, stdName);
	}

	public String getStudentName(int stdID) {
		return calcService.fetchStudentName(stdID);
	}

	public Map<Integer, String> getSavedStudentInfo() {
		return calcService.getSavedStudentDetails();
	}
}
