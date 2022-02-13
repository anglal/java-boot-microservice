package org.slryms.controller;

import org.slryms.dto.SalaryDto;
import org.slryms.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary-services")
public class SalaryController {
    @Autowired
    private KafkaTemplate<String, List<SalaryDto>> kafkaTemplate;
    private final String TOPIC = "topic_slry";
    @Autowired
    private SalaryService salaryService;
    @PostMapping("/salaries")
    public void saveSalary(@RequestBody SalaryDto salaryDto){
        this.salaryService.saveSalary(salaryDto);
    }

    @GetMapping("/salaries")
    public List<SalaryDto> getAllSalaries(){
        List<SalaryDto> salaryDtos = this.salaryService.getAllSalaries();
        this.kafkaTemplate.send(TOPIC,salaryDtos);
        return salaryDtos;
    }
}
