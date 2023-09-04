package com.main;

import com.service.CredentialService;

import java.util.Scanner;

public class SupportDriver {
    public static void main(String[] args) {
        CredentialService support = new CredentialService();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Welcome to mobisy \n");
        System.out.println("---------------------");
        System.out.println("Please enter the department from the following");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.println("---------------------");
        int option;
        option = sc.nextInt();
        switch(option) {
            case 1: {
                support.setSelectedDepartment("tech");
                break;
            }
            case 2: {
                support.setSelectedDepartment("admin");
                break;
            }
            case 3: {
                support.setSelectedDepartment("hr");
                break;
            }
            case 4: {
                support.setSelectedDepartment("legal");
                break;
            }
            default: {
                System.out.println("Enter valid option");
            }
        }
        if(option > 0 && option <=4) {
            support.generateEmailAddress();
            support.generatePassword();
            support.showCredentials();
        }
        sc.close();
    }
}
