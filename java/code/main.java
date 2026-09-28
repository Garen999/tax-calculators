package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TaxCalculator {

    public static void main(String[] args) {

        SpringApplication.run(TaxCalculator.class, args);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Gross Salary: £");
        double gross_salary = scanner.nextDouble();
        scanner.close();

        TaxCalculator calculator = new TaxCalculator();
        double tax_free_salary = calculator.CalculateTaxFreeSalary(gross_salary);
        double taxable_salary = calculator.CalculateTaxableSalary(gross_salary, tax_free_salary);
        double income_tax = calculator.CalculateIncomeTax(gross_salary, taxable_salary);
        double national_insurance = calculator.CalculateNationalInsurance(gross_salary);
        double student_loans = calculator.CalculateStudentLoans(gross_salary);
        double take_home_salary = calculator.CalculateTakeHomeSalary(gross_salary, income_tax, national_insurance, student_loans);

        calculator.TaxReport(tax_free_salary, taxable_salary, income_tax, national_insurance, student_loans, take_home_salary);
    }

    public double CalculateTaxFreeSalary(double gross_salary) {

        double tax_free_salary;

        if (gross_salary > 125140) {
            tax_free_salary = 0;
        } else if (gross_salary > 100000) {
            tax_free_salary = 12570 - ((gross_salary - 100000) / 2);
        } else {
            tax_free_salary = 12570;
        }
        return tax_free_salary;

    }

    public double CalculateTaxableSalary(double gross_salary, double tax_free_salary) {

        double taxable_salary;

        if (gross_salary > 12570) {
            taxable_salary = gross_salary - tax_free_salary;
        } else {
            taxable_salary = gross_salary;
        }
        return taxable_salary;
    }

    public double CalculateIncomeTax(double gross_salary, double taxable_salary) {

        double income_tax;

        if (gross_salary > 12570) {
            if (taxable_salary > 125140) {
                income_tax = (taxable_salary - 125140) * 0.45 + 42516;
            } else if (taxable_salary > 37701) {
                income_tax = (taxable_salary - 37700) * 0.4 + 7540;
            } else {
                income_tax = taxable_salary * 0.2;
            }
        } else {
            income_tax = 0;
        }
        return income_tax;
    }

    public double CalculateNationalInsurance(double gross_salary) {

        double national_insurance;

        if (gross_salary > 50268) {
            national_insurance = (gross_salary - 50268) * 0.02 + 3015.3504;
        } else if (gross_salary > 12576.12) {
            national_insurance = (gross_salary - 12576.12) * 0.08;
        } else {
            national_insurance = 0;
        }
        return national_insurance;
    }

    public double CalculateStudentLoans(double gross_salary) {

        double student_loans;

        if (gross_salary > 25000) {
            student_loans = (gross_salary - 25000) * 0.09;
        } else {
            student_loans = 0;
        }
        return student_loans;
    }

    public double CalculateTakeHomeSalary(double gross_salary, double income_tax, double national_insurance, double student_loans) {

        double take_home_salary;
        take_home_salary = gross_salary - income_tax - national_insurance - student_loans;
        return take_home_salary;
    }

    public double MonthlyConverter(double yearly_value) {

        double monthly_value;
        monthly_value = yearly_value / 12;
        return monthly_value;
    }

    public void TaxReport(double taxFreeSalary, double taxableSalary, double incomeTax, double nationalInsurance, double studentLoans, double takeHomeSalary) {
        System.out.println("Your Yearly Tax Free Salary is: £" + taxFreeSalary);
        System.out.println("Your Yearly Taxable Salary is: £" + taxableSalary);
        System.out.println("Your Yearly Income Tax is: £" + incomeTax);
        System.out.println("Your Yearly National Insurance is: £" + nationalInsurance);
        System.out.println("Your Yearly Student Loans are: £" + studentLoans);
        System.out.println("Your Yearly Take Home Salary is: £" + takeHomeSalary);

        System.out.println("Your Monthly Tax Free Salary is: £" + taxFreeSalary);
        System.out.println("Your Monthly Taxable Salary is: £" + taxableSalary);
        System.out.println("Your Monthly Income Tax is: £" + incomeTax);
        System.out.println("Your Monthly National Insurance is: £" + nationalInsurance);
        System.out.println("Your Monthly Student Loans are: £" + studentLoans);
        System.out.println("Your Monthly Take Home Salary is: £" + takeHomeSalary);
    }
}
