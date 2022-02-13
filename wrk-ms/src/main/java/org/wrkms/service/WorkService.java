package org.wrkms.service;

import org.wrkms.dto.WorkDto;


import java.util.List;

public interface WorkService {
    void saveWork(WorkDto workDto);

    List<WorkDto> fetchWorksByEmpId(Integer empId);
}
