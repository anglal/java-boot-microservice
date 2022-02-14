package org.pims.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer empployeeId;
    private String fName;
    private String lName;
    private String address;
    @Transient
    private List<Work> workList = new ArrayList<>();

    public User() {
    }

    public User(Integer empployeeId, String fName, String lName, String address, List<Work> workList) {
        this.empployeeId = empployeeId;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.workList = workList;
    }

    public Integer getEmpployeeId() {
        return empployeeId;
    }

    public void setEmpployeeId(Integer empployeeId) {
        this.empployeeId = empployeeId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }
}
