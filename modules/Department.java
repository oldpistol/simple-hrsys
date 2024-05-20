package modules;

import java.util.ArrayList;

public class Department {

    private String name;
    private Company company;
    private ArrayList<Employee> staffs;

    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
        staffs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }
}
