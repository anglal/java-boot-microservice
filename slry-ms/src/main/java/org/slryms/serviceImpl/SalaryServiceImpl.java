package org.slryms.serviceImpl;

import org.slryms.dao.SalaryRepository;
import org.slryms.dto.SalaryDto;
import org.slryms.entity.Salary;
import org.slryms.service.SalaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public void saveSalary(SalaryDto salaryDto){
        Salary salary = new Salary();
        BeanUtils.copyProperties(salaryDto,salary);
        salaryRepository.save(salary);
    }

}
