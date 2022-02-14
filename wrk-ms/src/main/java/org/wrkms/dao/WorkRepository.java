package org.wrkms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wrkms.model.Work;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work,Integer> {

    @Query(value= "select * from work w where w.employee_id =:empId", nativeQuery = true)
    List<Work> findByEmpId(@Param("empId") Integer empId);
}
