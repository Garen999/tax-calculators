#inputting gross salary
while True:
    try:
        gross_salary = float(input("Enter Your Gross Salary: £"))
        break
    except ValueError:
        print("Please enter a numeric value")

#calculating tax free salary
if gross_salary > 125140:
    tax_free_salary = 0
elif gross_salary > 100000:
    tax_free_salary = 12570 - ((gross_salary-100000)/2)
else:
    tax_free_salary = 12570

#calculating taxable salary
if gross_salary > 12570:
    taxable_salary = gross_salary - tax_free_salary
else:
    taxable_salary = gross_salary

#calculating income tax
if gross_salary > 12570:
    if taxable_salary > 125140:
        income_tax = (taxable_salary - 125140)*0.45 + 42516
    elif taxable_salary > 37701:
        income_tax = (taxable_salary - 37700)*0.4 + 7540
    else:
        income_tax = taxable_salary*0.2
else:
    income_tax = 0

#calculating national insurance
if gross_salary > 50268:
    national_insurance = (gross_salary - 50268)*0.02 + 3015.3504
elif gross_salary > 12576.12:
    national_insurance = (gross_salary - 12576.12)*0.08
else:
    national_insurance = 0

#calculating student loans
if gross_salary > 25000:
    student_loans = (gross_salary - 25000)*0.09
else:
    student_loans = 0

#calculating take home salary
take_home_salary_without_student_loans = gross_salary - income_tax - national_insurance
take_home_salary = gross_salary - income_tax - national_insurance - student_loans

#converting annual salaries into monthly salaries
def monthly_conversion(annual_salary):
    monthly_salary = int(annual_salary / 12)
    return monthly_salary

#printing salaries/taxes
print("\n")

print("Yearly Salaries/Taxes: ")
print("Your Yearly Tax Free Salary is: £" + str(int(tax_free_salary)))
print("Your Yearly Taxable Salary is: £" + str(int(taxable_salary)))
print("Your Yearly Income Tax is: £" + str(int(income_tax)))
print("Your Yearly National Insurance is: £" + str(int(national_insurance)))
print("Your Yearly Take Home Salary Without Student Loans is: £" + str(int(take_home_salary_without_student_loans)))
print("Your Yearly Student Loans are: £" + str(int(student_loans)))
print("Your Yearly Take Home Salary is: £" + str(int(take_home_salary)))

print("\n")

print("Monthly Salaries/Taxes: ")
print("Your Monthly Tax Free Salary is: £" + str(monthly_conversion(tax_free_salary)))
print("Your Monthly Taxable Salary is: £" + str(monthly_conversion(taxable_salary)))
print("Your Monthly Income Tax is: £" + str(monthly_conversion(income_tax)))
print("Your Monthly National Insurance is: £" + str(monthly_conversion(national_insurance)))
print("Your Monthly Take Home Salary Without Student Loans is: £" + str(monthly_conversion(take_home_salary_without_student_loans)))
print("Your Monthly Student Loans are: £" + str(monthly_conversion(student_loans)))
print("Your Monthly Take Home Salary is: £" + str(monthly_conversion(take_home_salary)))