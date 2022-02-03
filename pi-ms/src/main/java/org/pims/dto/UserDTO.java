package org.pims.dto;

public class UserDTO {
    private int id;
    private String fName;
    private String lName;
    private String address;

    public UserDTO() {
    }

    public UserDTO(int id, String fName, String lName, String address) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
