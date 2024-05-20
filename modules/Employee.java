package modules;

import java.util.Scanner;

public abstract class Employee {

    protected String name;
    protected String icNo;

    public Employee() {
    }

    public Employee(String name, String icNo) {
        this.name = name;
        this.icNo = icNo;
    }

    public abstract void keyinInfo(Scanner sc);

    public String getName() {
        return name;
    }

    public String getIcNo() {
        return icNo;
    }

    public abstract void setDepartment(Department department);

    public abstract Department getDepartment();

    public abstract int getContractMonth();
}
