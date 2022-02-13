package org.pims.model;

import javax.persistence.*;

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

    public User() {
    }

    public User(Integer empployeeId, String fName, String lName, String address) {
        this.empployeeId = empployeeId;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
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
}
