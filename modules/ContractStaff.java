package modules;

import java.util.Scanner;

import interfaces.ContractJob;

public class ContractStaff extends Staff implements ContractJob {

    private int contractMonth;

    public ContractStaff() {
    }

    public ContractStaff(String name, String icNo, String post, int contractMonth) {
        super(name, icNo, post);
        this.contractMonth = contractMonth;
    }

    public int getContractMonth() {
        return contractMonth;
    }

    public void keyinInfo(Scanner sc) {
        super.keyinInfo(sc);
        System.out.print("Enter contract month: ");
        contractMonth = sc.nextInt();
    }
}
