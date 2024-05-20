package modules;

import java.util.ArrayList;

public class Company {

    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}
