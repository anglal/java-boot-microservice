package org.slryms.dto;


import java.math.BigInteger;

public class SalaryDto {
    private Integer slryId;
    private BigInteger salary;
    private BigInteger advancePaid;
    private Integer employeeId;

    public SalaryDto() {
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
