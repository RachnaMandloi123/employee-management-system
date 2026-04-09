package com.rachna.employee_management.dto;

public class LoginResponse {

    private int id;
    private String name;
    private String email;
    private String city;

    
    public LoginResponse(int id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
}
