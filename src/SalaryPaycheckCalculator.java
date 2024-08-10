import java.util.Scanner;

public class SalaryPaycheckCalculator {

    // Method for calculating tax based on the gross wage
    public static double TaxCalculator(double gross) {
        double tax = 0;

        // Tax scale (based on France's progressive scale).
        if (gross <= 11294) {
            tax = 0; // No tax on gross wages up to 11294
        }

        else if (gross <= 28795) {
            tax = (gross - 11000) * 0.11; // 11% for gross wages range [11295, 28797]
        }

        else if (gross <= 82341) {
            tax = (gross - 30000) * 0.30; // 30% for gross wages range [28798, 82341]
        }

        else if (gross <= 177106) {
            tax = (gross - 41000) * 0.41; // 41% for gross wages range [82342, 177106]
        }

        else if (gross > 177106) {
            tax = (gross - 45000) * 0.45; // 45% for gross wages over 117106
        }

        else {
            System.out.println("Your gross can't be null! Please, enter a valide value");
        }

        return tax;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User provides gross wage amount
        System.out.print("Enter your gross amount : ");
        double grossWage = scanner.nextDouble();

        // User provides amount of pension déduction
        System.out.print("Enter your pension deduction amount : ");
        double pension = scanner.nextDouble();

        // User provides amount of insurance déduction
        System.out.print("Enter your insurance deduction amount : ");
        double insurance = scanner.nextDouble();

        // Tax calculation
        double tax = TaxCalculator(grossWage);

        // Net wage calculation
        double NetWage = grossWage - tax - pension - insurance;

        // Display results
        System.out.println("Gross wage : " + grossWage + " €");
        System.out.println("Tax : " + tax + " €");
        System.out.println("Pension deduction : " + pension + " €");
        System.out.println("Insurance deduction : " + insurance + " €");
        System.out.println("Insurance deduction : " + NetWage + " €");

    }
}
