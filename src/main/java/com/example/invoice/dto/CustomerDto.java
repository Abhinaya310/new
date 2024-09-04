package com.example.invoice.dto;

public class CustomerDto {
    public static Long id;

    private String name;

    private String phoneNo;

    private String email;

    private String plans;

    @Override
    public String toString() {
        return "CustomerDto [name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", plans=" + plans + "]";
    }

    public CustomerDto(String name, String phoneNo, String email, String plans) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.plans = plans;
    }

    public CustomerDto() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        CustomerDto.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    

}
