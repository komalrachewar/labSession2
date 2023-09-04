package com.service;

import com.model.Employee;
import com.support.AdminSupport;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CredentialService implements AdminSupport {
    Employee employee = new Employee();

    public void setSelectedDepartment(String dept) {
        employee.setDepartment(dept);
    }
    @Override
    public void generatePassword() {
        int len = 8;
        Random rnd = new Random();
        String password = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()<>";
        for (int i = 0; i < len; i++)
        {
            int randomIndex = rnd.nextInt(chars.length());
            password += chars.charAt(randomIndex);
        }
        employee.setPassword(password.toString());
    }

    @Override
    public void generateEmailAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name");
        String firstName = sc.nextLine();
        employee.setFirstName(firstName);
        if(!Pattern.matches("[a-zA-Z.]+", firstName)){
            System.out.println("Invalid Data name can not contain special characters");
            System.out.println("Enter first name");
            firstName = sc.nextLine();
            employee.setFirstName(firstName);
        }
        System.out.println("Enter the last name");
        String lastName = sc.nextLine();
        employee.setLastName(lastName);
        if(!Pattern.matches("[a-zA-Z.]+", lastName)){
            System.out.println("Invalid Data name can not contain special characters");
            System.out.println("Enter first name");
            lastName = sc.nextLine();
            employee.setFirstName(lastName);
        }
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + '@' +employee.getDepartment() + "." + employee.getCompany();
        employee.setEmail(email);
        sc.close();
    }

    @Override
    public void showCredentials() {
        System.out.println("Dear" +employee.getFirstName()+ "your generated credentials are as follows");
        System.out.println("Email = "+ employee.getEmail());
        System.out.println("Password = "+ employee.getPassword());
    }
}
