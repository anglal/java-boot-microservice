package com.zlimbu.jnt;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EligibilityCalculatorTest {

	 EmployeeInfo employeeInfo = null;
	 EligibilityCalculator eligibilityCalculator = new EligibilityCalculator();

	 @BeforeEach
	 public void setUp() throws Exception {
	   employeeInfo = new EmployeeInfo();
	 }

	 @AfterEach
	 public void tearDown() throws Exception {
	   employeeInfo = null;
	 }

	 @Test
	 public void testEligibleForHike_ValidDesignation() {
	   employeeInfo.age = 35;
	   employeeInfo.designation = "Manager";
	   employeeInfo.EmployeeName = "Niket";
	   employeeInfo.salary = 49000.00;
	   employeeInfo.EmployeeId = 526234;
	   assertTrue(eligibilityCalculator.eligibleForHike(employeeInfo));
	 }

	 @Test
	 public void testEligibleForHike_BlankDesignation() throws IllegalArgumentException {
	   employeeInfo.age = 35;
	   employeeInfo.designation = " ";
	   employeeInfo.EmployeeName = "Niket";
	   employeeInfo.salary = 49000.00;
	   employeeInfo.EmployeeId = 526234;
	   assertThrows(IllegalArgumentException.class, () -> {
		eligibilityCalculator.eligibleForHike(employeeInfo);
	   });
	 }

	 @Test
	 public void testEligibleForHike_InvalidEmpID() throws IllegalArgumentException {
	   employeeInfo.age = 35;
	   employeeInfo.designation = " ";
	   employeeInfo.EmployeeName = "Niket";
	   employeeInfo.salary = 49000.00;
	   employeeInfo.EmployeeId = 0;
	   assertThrows(IllegalArgumentException.class, () -> {
	       eligibilityCalculator.eligibleForHike(employeeInfo);
	     });
	 }
}
