package org.pims.dto;

import org.pims.model.Work;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer empployeeId;
    private String fName;
    private String lName;
    private String address;
    private List<WorkDto> workList = new ArrayList<>(); // Work info is obtained from wrk-ms microservice
    public UserDTO() {
    }

    public UserDTO(Integer empployeeId, String fName, String lName, String address, List<WorkDto> workList) {
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

    public List<WorkDto> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkDto> workList) {
        this.workList = workList;
    }
}
