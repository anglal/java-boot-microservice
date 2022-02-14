package org.wrkms.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wrkms.dao.WorkRepository;
import org.wrkms.dto.WorkDto;
import org.wrkms.model.Work;
import org.wrkms.service.WorkService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;
    @Override
    public void saveWork(WorkDto workDto) {
        Work work = new Work();
        BeanUtils.copyProperties(workDto,work);
        this.workRepository.save(work);
    }

    @Override
    public List<WorkDto> fetchWorksByEmpId(Integer empId) {
        List<Work> workList = new ArrayList<>();
        workList = this.workRepository.findByEmpId(empId);
        List<WorkDto> workDtoList = new ArrayList<>();
        return workList.stream().map(work -> mapToWorkDto(work)).collect(Collectors.toList());
    }

    // private method for type conversion
    WorkDto mapToWorkDto(Work work){
        WorkDto workDto = new WorkDto();
        BeanUtils.copyProperties(work,workDto);
        return workDto;
    }
}
