package org.wrkms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wrkms.dto.WorkDto;
import org.wrkms.service.WorkService;

@RestController                         //It's a convenient annotation that combines @Controller and @ResponseBody
@RequestMapping("/account-services")    //maps HTTP requests
public class WorkController {
    @Autowired
    private WorkService workService;
    @PostMapping("/works")
    public void saveWork(@RequestBody WorkDto workDto){
        workService.saveWork(workDto);
    }

}
