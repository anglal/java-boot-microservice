package com.zlimbu.jnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DummyController {
 @RequestMapping(value="/message",produces = "text/plain;Charset=UTF-8", method = RequestMethod.GET)
 @ResponseBody
 public String retreiveMessage() {
   return String.valueOf("This is a message!");
 }
}
