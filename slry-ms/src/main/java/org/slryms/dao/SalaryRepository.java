package org.slryms.dao;

import org.slryms.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {
}
