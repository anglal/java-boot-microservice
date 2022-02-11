package org.wrkms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wrkms.model.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work,Integer> {

}
