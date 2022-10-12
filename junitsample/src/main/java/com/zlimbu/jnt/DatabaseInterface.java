package com.zlimbu.jnt;

import java.util.Map;

public interface DatabaseInterface {

	public int saveToDB(int StdID, String stdName);

	public String fetchStudentName(int stdID);

	public Map<Integer, String> getSavedStudentDetails();
}
