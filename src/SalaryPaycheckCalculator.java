    /*
         @author: SmartGuy
         @description: calculates an employee's net salary after
                       tax deduction based on a progressive scale,
                       pension deduction and insurance deduction.
    */

import java.util.Scanner;

// Encapsulating tax calculation logic.
public class SalaryPaycheckCalculator {

    // Method for calculating tax based on the gross wage
    public static double TaxCalculator(double gross) {
        double tax;

        // Tax scale (based on France's progressive scale).
        if (gross <= 11294) {
            tax = 0; // No tax on gross wages up to 11294 €
        } else if (gross <= 28795) {
            tax = (gross - 11294) * 0.11; // 11% for gross wages in the range [11295 €, 28795 €]
        } else if (gross <= 82341) {
            tax = (gross - 28795) * 0.30 + TaxCalculator(28795); // 30% for gross wages in the range [28796 €, 82341 €]
        } else if (gross <= 177106) {
            tax = (gross - 82341) * 0.41 + TaxCalculator(82341); // 41% for gross wages in the range [82342 €, 177106 €]
        } else {
            tax = (gross - 177106) * 0.45 + TaxCalculator(177106); // 45% for gross wages over 177106 €
        }
        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // User provides gross wage amount
            System.out.print("Enter your gross amount (or type '0' to quit): ");
            double input = scanner.nextDouble();

            // Allow user to exit the loop
            if (input == 0) {
                break;
            }

            // Checking for additional deductions
            System.out.print("""
                    Do you have additional deductions ?\s
                    1. Yes\s
                    2. No
                    """);

            // Getting input from user
            double checkAdditionalDeductions = scanner.nextDouble();

            System.out.println(); // Add a blank line for better readability

            // Default values of additional deductions
            double pension = 0;
            double insurance = 0;

            // If there is additional deductions
            if (checkAdditionalDeductions == 1) {

                // User provides amount of pension deduction
                System.out.print("Enter your pension deduction amount : ");
                pension = scanner.nextDouble();

                // User provides amount of insurance deduction
                System.out.print("Enter your insurance deduction amount : ");
                insurance = scanner.nextDouble();

            // Avoiding exception
            } else if (!(checkAdditionalDeductions == 2)) {
                System.out.println("Invalid choice, please choose '1' or '2'.");
                continue; // Restart the loop
            }

            // Tax calculation
            double tax = TaxCalculator(input);

            // Net wage calculation
            double netWage = input - tax - pension - insurance;

            // Add a blank line for better readability
            if (pension > 0 && insurance > 0) {
                System.out.println();
            }

            // Display results
            System.out.println("Gross wage : " + input + " €");
            System.out.println("Tax : " + tax + " €");

                // Result when no additional deductions
                if (pension != 0) {
                    System.out.println("Pension deduction : " + pension + " €");
                }
                if (insurance != 0) {
                    System.out.println("Insurance deduction : " + insurance + " €");
                }

            System.out.println("Net wage : " + netWage + " €");

            System.out.println(); // Add a blank line for better readability

        }
        // Closing the scanner
        scanner.close();
    }
}