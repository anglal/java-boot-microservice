package org.wrkms.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wrkms.dao.WorkRepository;
import org.wrkms.dto.WorkDto;
import org.wrkms.model.Work;
import org.wrkms.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;
    @Override
    public void saveWork(WorkDto workDto) {
        Work work = new Work();
        BeanUtils.copyProperties(workDto,work);
        workRepository.save(work);
    }
}
