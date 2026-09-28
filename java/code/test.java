package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculatorTests {

    @Test
    void TestBasicRateIncomeTax() {

       TaxCalculator calculator = new TaxCalculator();
       double gross_salary = 35000;

       double expected_tax_free_salary = 12570;
       double expected_taxable_salary = 22430;
       double expected_income_tax = 4486;
       double expected_national_insurance = 1793;
       double expected_student_loans = 900;
       double expected_take_home_salary = 27819.6;

       double actual_tax_free_salary = calculator.CalculateTaxFreeSalary(gross_salary);
       double actual_taxable_salary = calculator.CalculateTaxableSalary(gross_salary, actual_tax_free_salary);
       double actual_income_tax = calculator.CalculateIncomeTax(gross_salary, actual_taxable_salary);
       double actual_national_insurance = calculator.CalculateNationalInsurance(gross_salary);
       double actual_student_loans = calculator.CalculateStudentLoans(gross_salary);
       double actual_take_home_salary = calculator.CalculateTakeHomeSalary(gross_salary, actual_income_tax, actual_national_insurance, actual_student_loans);

       assertEquals(expected_tax_free_salary, actual_tax_free_salary, 1);
       assertEquals(expected_taxable_salary, actual_taxable_salary, 1);
       assertEquals(expected_income_tax, actual_income_tax, 1);
       assertEquals(expected_national_insurance, actual_national_insurance, 1);
       assertEquals(expected_student_loans, actual_student_loans, 1);
       assertEquals(expected_take_home_salary, actual_take_home_salary, 1);
    }

    @Test
    void TestHigherRateIncomeTax() {

       TaxCalculator Calculator = new TaxCalculator();
       double gross_salary = 85000;

       double expected_tax_free_salary = 12570;
       double expected_taxable_salary = 72430;
       double expected_income_tax = 21432;
       double expected_national_insurance = 3710;
       double expected_student_loans = 5400;
       double expected_take_home_salary = 54457.4;

       double actual_tax_free_salary = Calculator.CalculateTaxFreeSalary(gross_salary);
       double actual_taxable_salary = Calculator.CalculateTaxableSalary(gross_salary, actual_tax_free_salary);
       double actual_income_tax = Calculator.CalculateIncomeTax(gross_salary, actual_taxable_salary);
       double actual_national_insurance = Calculator.CalculateNationalInsurance(gross_salary);
       double actual_student_loans = Calculator.CalculateStudentLoans(gross_salary);
       double actual_take_home_salary = Calculator.CalculateTakeHomeSalary(gross_salary, actual_income_tax, actual_national_insurance, actual_student_loans);

       assertEquals(expected_tax_free_salary, actual_tax_free_salary, 1);
       assertEquals(expected_taxable_salary, actual_taxable_salary, 1);
       assertEquals(expected_income_tax, actual_income_tax, 1);
       assertEquals(expected_national_insurance, actual_national_insurance, 1);
       assertEquals(expected_student_loans, actual_student_loans, 1);
       assertEquals(expected_take_home_salary, actual_take_home_salary, 1);
    }

    @Test
    void TestAdditionalRateIncomeTax() {

       TaxCalculator Calculator = new TaxCalculator();
       double gross_salary = 150000;

       double expected_tax_free_salary = 0;
       double expected_taxable_salary = 150000;
       double expected_income_tax = 53703;
       double expected_national_insurance = 5010;
       double expected_student_loans = 11244;
       double expected_take_home_salary = 80042.4;

       double actual_tax_free_salary = Calculator.CalculateTaxFreeSalary(gross_salary);
       double actual_taxable_salary = Calculator.CalculateTaxableSalary(gross_salary, actual_tax_free_salary);
       double actual_income_tax = Calculator.CalculateIncomeTax(gross_salary, actual_taxable_salary);
       double actual_national_insurance = Calculator.CalculateNationalInsurance(gross_salary);
       double actual_student_loans = Calculator.CalculateStudentLoans(gross_salary);
       double actual_take_home_salary = Calculator.CalculateTakeHomeSalary(gross_salary, actual_income_tax, actual_national_insurance, actual_student_loans);

       assertEquals(expected_tax_free_salary, actual_tax_free_salary, 1);
       assertEquals(expected_taxable_salary, actual_taxable_salary, 1);
       assertEquals(expected_income_tax, actual_income_tax, 1);
       assertEquals(expected_national_insurance, actual_national_insurance, 1);
       assertEquals(expected_student_loans, actual_student_loans, 1);
       assertEquals(expected_take_home_salary, actual_take_home_salary, 1);
    }

}
