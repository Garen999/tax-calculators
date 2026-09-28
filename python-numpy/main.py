#imports
import numpy as np

#inputting gross salary
while True:
    try:
        gross_salary = float(input("Enter Your Gross Salary: £"))
        gross_salaries = np.array([gross_salary])
        break
    except ValueError:
        print("Please enter a numeric value")

#calculating tax free salary
tax_free_salary_conditions = [gross_salaries > 125140, gross_salaries > 100000]
tax_free_salary_choices = [0, 12570 - ((gross_salaries-100000)/2)]
tax_free_salaries = np.select(tax_free_salary_conditions, tax_free_salary_choices, default = 12570)

#calculating taxable salary
taxable_salaries = np.where(gross_salaries > 12570, gross_salaries - tax_free_salaries, gross_salaries)

#calculating income tax
income_tax_conditions = [taxable_salaries > 125140, taxable_salaries > 37701]
income_tax_choices = [(taxable_salaries - 125140)*0.45 + 42516, (taxable_salaries - 37700)*0.4 + 7540]
income_taxes = np.where(gross_salaries > 12570, np.select(income_tax_conditions, income_tax_choices, default = taxable_salaries*0.2), 0)

#calculating national insurance
national_insurance_conditions = [gross_salaries > 50268, gross_salaries > 12576.12]
national_insurance_choices = [(gross_salary - 50268)*0.02 + 3015.3504, (gross_salary - 12576.12)*0.08]
national_insurances = np.select(national_insurance_conditions, national_insurance_choices, default = 0)

#calculating student loans
student_loans = np.where(gross_salaries > 25000, (gross_salaries - 25000)*0.09, 0)

#calculating take home salary
take_home_salary_without_student_loans = gross_salary - income_taxes - national_insurances
take_home_salary = take_home_salary_without_student_loans - student_loans

#converting annual salaries into monthly salaries
def monthly_conversion(annual_salary):  
    monthly_salary = int(annual_salary / 12)
    return monthly_salary

#printing salaries/taxes
print("\n")

print("Yearly Salaries/Taxes: ")
print("Your Yearly Tax Free Salary is: £" + str(int(tax_free_salaries)))
print("Your Yearly Taxable Salary is: £" + str(int(taxable_salaries)))
print("Your Yearly Income Tax is: £" + str(int(income_taxes)))
print("Your Yearly National Insurance is: £" + str(int(national_insurances)))
print("Your Yearly Take Home Salary Without Student Loans is: £" + str(int(take_home_salary_without_student_loans)))
print("Your Yearly Student Loans are: £" + str(int(student_loans)))
print("Your Yearly Take Home Salary is: £" + str(int(take_home_salary)))

print("\n")

print("Monthly Salaries/Taxes: ")
print("Your Monthly Tax Free Salary is: £" + str(monthly_conversion(tax_free_salaries)))
print("Your Monthly Taxable Salary is: £" + str(monthly_conversion(taxable_salaries)))
print("Your Monthly Income Tax is: £" + str(monthly_conversion(income_taxes)))
print("Your Monthly National Insurance is: £" + str(monthly_conversion(national_insurances)))
print("Your Monthly Take Home Salary Without Student Loans is: £" + str(monthly_conversion(take_home_salary_without_student_loans)))
print("Your Monthly Student Loans are: £" + str(monthly_conversion(student_loans)))
print("Your Monthly Take Home Salary is: £" + str(monthly_conversion(take_home_salary)))