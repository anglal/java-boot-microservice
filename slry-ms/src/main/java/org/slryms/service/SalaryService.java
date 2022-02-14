package org.slryms.service;

import org.slryms.dto.SalaryDto;

import java.util.List;

public interface SalaryService {
    void saveSalary(SalaryDto salaryDto);
    List<SalaryDto> getAllSalaries();
}
