package com.zlimbu.jnt;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentPortalTest {

 @InjectMocks
 StudentPortal mathApplication = new StudentPortal();
 
 @Mock
 DatabaseInterface databaseService;

 @Test
 public void testRetrieveStudentInfo() {
  //add the behavior to retrieve the 
  //name of student when student id is
  //given.
  	
  when(databaseService.fetchStudentName(12)).thenReturn("Niva Abel");
  assertEquals(mathApplication.getStudentName(12), "Niva Abel");
 }
 
 
 @Test(expected = IllegalStateException.class)
 public void testSaveStudentInfoWitException() {
  // add the behavior to show how we can mock exception being thrown.
  when(databaseService.saveToDB(ArgumentMatchers.anyInt(), ArgumentMatchers.contains("test")))
   .thenThrow(new IllegalStateException("Database failure"));
 
  mathApplication.saveStudentInfo(15, "test");
 }
}