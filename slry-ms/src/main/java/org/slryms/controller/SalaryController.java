package org.slryms.controller;

import org.slryms.dto.SalaryDto;
import org.slryms.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary-services")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    @PostMapping("/salaries")
    public void saveSalary(@RequestBody SalaryDto salaryDto){
        salaryService.saveSalary(salaryDto);
    }
}
