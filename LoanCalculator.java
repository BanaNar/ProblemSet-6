import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args){
        Scanner frodo = new Scanner(System.in);
        double principal, monthlyRate;
        int annualRate, annualRate2, years, numPayments, numPayments2, numPayments3;
        double saveTotalInterest, totalInterest;
        double monthlyPayment, monthlyPayment2, monthlyPayment3;

        System.out.print("loan amount: ");
        principal = frodo.nextDouble();
        System.out.print("Annual rate: ");
        annualRate = frodo.nextInt();
        System.out.print("Term in years: ");
        years = frodo.nextInt();

        monthlyRate = annualRate / 12.0 / 100;
        numPayments = years * 12;
        monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, numPayments)) / (Math.pow(1 + monthlyRate, numPayments) - 1);
        totalInterest = monthlyPayment * numPayments - principal;

        System.out.printf("Monthly payment: $ %.2f\n", monthlyPayment);
        System.out.printf("Total interest paid: $ %.2f\n", totalInterest);
        System.out.println("");

        System.out.println("Just a tip: ");

        numPayments2 = (years - 1) * 12;
        monthlyPayment2 = principal * (monthlyRate * Math.pow(1 + monthlyRate, numPayments2)) / (Math.pow(1 + monthlyRate, numPayments2) - 1);
        saveTotalInterest = monthlyPayment2 * numPayments2 - principal;

        System.out.printf("Paying off the loan in %d years could save you $ %.2f in interest with a monthly payment of %.2f\n", years - 1, totalInterest - saveTotalInterest, monthlyPayment2);

        annualRate2 = annualRate - 1;
        monthlyRate = annualRate2 / 12.0 / 100;
        numPayments3 = years * 12;
        monthlyPayment3 = principal * (monthlyRate * Math.pow(1 + monthlyRate, numPayments3)) / (Math.pow(1 + monthlyRate, numPayments3) - 1);
        saveTotalInterest = monthlyPayment3 * numPayments - principal;

        System.out.printf("Dropping your rate to %d percent could save you $ %.2f in interest with a monthly payment of %.2f\n", annualRate2, totalInterest - saveTotalInterest, monthlyPayment3);

    }
    /*
    method getMonthlyRate()
    input: double
    output: return a double
    purpose: calculate the monthly rate given annual rate
    */
    public static double getMonthlyRate(double an){
        double mr;
        mr = an / 12;
        return mr;
    }
}