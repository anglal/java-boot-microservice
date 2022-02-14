package org.slryms.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="user_salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="slry_id")
    private Integer slryId;

    @Column(name="salary")
    private BigInteger salary;

    @Column(name="advance_paid")
    private BigInteger advancePaid;

    @Column(name="emp_id", unique=true)
    private Integer employeeId;

    public Salary() {
    }

    public Integer getSlryId() {
        return slryId;
    }

    public void setSlryId(Integer slryId) {
        this.slryId = slryId;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public BigInteger getAdvancePaid() {
        return advancePaid;
    }

    public void setAdvancePaid(BigInteger advancePaid) {
        this.advancePaid = advancePaid;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
