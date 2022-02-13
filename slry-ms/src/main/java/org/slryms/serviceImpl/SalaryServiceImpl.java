package org.slryms.serviceImpl;

import org.slryms.dao.SalaryRepository;
import org.slryms.dto.SalaryDto;
import org.slryms.entity.Salary;
import org.slryms.service.SalaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public void saveSalary(SalaryDto salaryDto){
        Salary salary = new Salary();
        BeanUtils.copyProperties(salaryDto,salary);
        this.salaryRepository.save(salary);
    }

    @Override
    public List<SalaryDto> getAllSalaries() {

        List<Salary> salaries = this.salaryRepository.findAll();
        return salaries.stream().map(salary->{
            SalaryDto slryDto= new SalaryDto();
            BeanUtils.copyProperties(salary, slryDto);
            return slryDto;
        }).collect(Collectors.toList());
    }

}
