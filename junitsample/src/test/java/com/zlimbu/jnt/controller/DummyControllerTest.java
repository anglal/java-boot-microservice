package com.zlimbu.jnt.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class DummyControllerTest {
 @Autowired
 private WebApplicationContext ctx;
 private MockMvc mockMvc;

 @InjectMocks
 private DummyController DummyController;

 @Before
 public void setUp() {
  this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
 }

 @Test
 public void testRetrieiveMessage() throws Exception {
  mockMvc.perform(get("/message").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk()).andExpect(content().string("This is a message!"));
 }

 @Configuration
 public static class TestConfiguration {
  @Bean
  public DummyController dummyController() {
   return new DummyController();
  }
 }
}