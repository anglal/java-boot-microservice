package org.wrkms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wrkms.dto.WorkDto;
import org.wrkms.service.WorkService;

import java.util.ArrayList;
import java.util.List;

@RestController                         //It's a convenient annotation that combines @Controller and @ResponseBody
@RequestMapping("/work-services")    //maps HTTP requests
public class WorkController {
    @Autowired
    private WorkService workService;
    @PostMapping("/works")
    public void saveWork(@RequestBody WorkDto workDto){
        this.workService.saveWork(workDto);
    }
    @GetMapping("/works/{empId}")
    public List<WorkDto> fetchWorksByEmpId(@PathVariable("empId") Integer empId){
        List<WorkDto> workList = new ArrayList<>();
        workList = this.workService.fetchWorksByEmpId(empId);
        return workList;
    }


}
