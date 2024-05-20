package modules;

import java.util.Scanner;

public class Staff extends Employee {

    private String post;
    private Department department;

    public Staff() {
    }

    public Staff(String name, String icNo, String post) {
        super(name, icNo);
        this.post = post;
    }

    public void keyinInfo(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter IC No: ");
        icNo = sc.nextLine();
        System.out.print("Enter post: ");
        post = sc.nextLine();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public int getContractMonth() {
        return -1;
    }
}
