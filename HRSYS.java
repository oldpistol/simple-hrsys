import java.util.*;

import modules.Company;
import modules.ContractStaff;
import modules.Department;
import modules.Employee;
import modules.Staff;

public class HRSYS {

    // ArrayList variables to store all new created Company and
    // Employee (Staff/ContractStaff) instances
    public static ArrayList<Company> companies = new ArrayList<Company>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        // Test case to quickly add company, department, and staff
        // Company com = new Company("Farmfresh");
        // companies.add(com);
        // companies.get(0).addDepartment("Admin");
        // Employee staff = new ContractStaff("AZMI", "A123", "CEO", 6);
        // staff.setDepartment(companies.get(0).getDepartments().get(0));
        // employees.add(staff);
        // End test case
        Scanner keyin = new Scanner(System.in);
        boolean exit = false;
        int operation = 0;
        while (!exit) {
            System.out.println();
            System.out.println("1. Add Company");
            System.out.println("2. Add Department");
            System.out.println("3. Add Staff");
            System.out.println("4. List Staff");
            System.out.println("5. Exit");
            while (operation < 1 || operation > 5) {
                System.out.print("Choose operation (1-5): ");
                operation = Integer.parseInt(keyin.nextLine());
            }
            if (operation == 1)
                addCompany(keyin);
            else if (operation == 2)
                addDepartment(keyin);
            else if (operation == 3)
                addStaff(keyin);
            else if (operation == 4)
                listStaff(keyin);
            else if (operation == 5)
                exit = true;

            operation = 0;
        }
    }

    public static void addCompany(Scanner keyin) {
        System.out.print("\nADD NEW COMPANY");
        System.out.print("\nEnter company name: ");
        String name = keyin.nextLine();
        Company com = new Company(name);
        companies.add(com);
    }

    public static void addDepartment(Scanner keyin) {
        System.out.print("\nADD NEW DEPARTMENT");
        System.out.print("\nDepartment name: ");
        String name = keyin.nextLine();

        // Choose company
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(i).getName());
        }

        System.out.print("\nChoose company to add department: ");
        int companyIndex = Integer.parseInt(keyin.nextLine()) - 1;
        Department department = new Department(name, companies.get(companyIndex));
        companies.get(companyIndex).addDepartment(department);
    }

    public static void addStaff(Scanner keyin) {
        System.out.print("\nADD NEW STAFF");
        System.out.print("\nContract staff? (y/n): ");
        String contract = keyin.nextLine();
        System.out.print("\nName: ");
        String name = keyin.nextLine();
        System.out.print("IC No.: ");
        String icNo = keyin.nextLine();
        System.out.print("Post: ");
        String post = keyin.nextLine();

        int contractMonth = 0;

        if (contract.equalsIgnoreCase("y")) {
            System.out.print("Month(s) of Contract: ");
            contractMonth = Integer.parseInt(keyin.nextLine());
        }

        System.out.println();

        // Choose company
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(i).getName());
        }

        System.out.print("Choose company to add staff: ");
        int companyIndex = Integer.parseInt(keyin.nextLine()) - 1;

        System.out.println();

        // Choose department
        for (int i = 0; i < companies.get(companyIndex).getDepartments().size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(companyIndex).getDepartments().get(i).getName());
        }

        System.out.print("Choose company's department to attach staff: ");
        int departmentIndex = Integer.parseInt(keyin.nextLine()) - 1;

        Employee staff;

        if (contract.equalsIgnoreCase("y")) {
            staff = new ContractStaff(name, icNo, post, contractMonth);
        } else {
            staff = new Staff(name, icNo, post);
        }

        staff.setDepartment(companies.get(companyIndex).getDepartments().get(departmentIndex));
        employees.add(staff);
    }

    public static void listStaff(Scanner keyin) {
        /**
         * 1. Add Company
         * 2. Add Department
         * 3. Add Staff
         * 4. List Staff
         * 5. Exit
         * Choose operation (1-5): 4
         * STAFF LIST RECORD
         * No. Name IC No. Post Company-Department
         * ----------------------------------------------------------
         * 1 AZMI A123 CEO Farmfresh-Admin (6 months contract)
         * 2 ROHAYA A456 Clerk Farmfresh-HR
         * 3 ADAM A789 Accountant Jalen-Finance
         * 4 OMAR B321 Programmer Jalen-IT (12 months contract)
         */

        System.out.println("\nSTAFF LIST RECORD");
        System.out.println("\nNo. \tName \t\tIC No. \t\tPost \t\tCompany-Department");

        System.out
                .println("-----------------------------------------------------------------------------");

        for (int i = 0; i < employees.size(); i++) {
            Employee staff = employees.get(i);
            String companyDepartment = staff.getDepartment().getCompany().getName() + "-"
                    + staff.getDepartment().getName();
            String contract = "";
            if (staff instanceof ContractStaff) {
                contract = " (" + ((ContractStaff) staff).getContractMonth() + " months contract)";
            }
            System.out.println((i + 1) + "\t" + staff.getName() + "\t\t" + staff.getIcNo() + "\t\t"
                    + staff.getDepartment().getCompany().getName() + "\t\t" + companyDepartment + contract);
        }
    }

    public static void pressEnter(Scanner keyin) {
        System.out.print("\nPress enter to continue... ");
        keyin.nextLine();
    }
}
