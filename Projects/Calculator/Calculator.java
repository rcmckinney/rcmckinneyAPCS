import java.util.Scanner;

public class Calculator{
    public static int mode = -1; 
    public static double loanAmt = -1;
    public static int loanTerm = -1;
    public static double interestRate = -1;
    public static double interest = 0;
    public static int monthsRemaining = -1;

    public static void main(String[] args) {
        //Read in the loan calculation mode
        Scanner scan;
        while(true) { //Loop the mode selection menu until a valid input is provided
            scan = new Scanner(System.in);
            printModeStatement(); //Call a function to print our mode selection statement
            if(scan.hasNextInt()) { //Check if input provided is a valid integer
                mode = scan.nextInt();
                if(0 < mode && mode < 4) { //Check if input provided is 1, 2, or 3
                    break; //Valid input has been provided. Break out of the while loop
                }
            }
            //If it reaches here, the input was invalid. Loop again.
        }
        System.out.println("You selected mode " + mode);

        if(mode == 1) {
            flatInterest();
        }
        if(mode == 2) {
            compoundNoPay();
        }
        if(mode == 3){
            compoundWithPay();
        }
    }

    public static void flatInterest() {
       while(true){
           System.out.print("Enter the Amount of the Loan: ");
           Scanner scan;
           scan = new Scanner(System.in);
           if(scan.hasNextDouble()){
               loanAmt = scan.nextDouble();
               if(loanAmt > 0) {
                   break;
               }
           }
       }
       while(true){
           System.out.print("Enter the term of your loan (years): ");
           Scanner scan;
           scan = new Scanner(System.in);
           if(scan.hasNextInt()){
               loanTerm = scan.nextInt();
               if(loanTerm > 0){
                   break;
               }
           }
       }
       while(true){
           System.out.print("Enter interest rate (%): ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextDouble()){
                interestRate = scan.nextDouble();
                if(interestRate > 0){
                    break;
                }
            }
       }
        double interest = (loanAmt * loanTerm * interestRate)/100;
        double totalPayment = (interest + loanAmt);
        System.out.println(
            "Original loan amount: $" + loanAmt);
        System.out.println(
            "Loan Term: " + loanTerm + " years");
        System.out.println(
            "Interest Rate: " + interestRate + " %");
        System.out.println(
            "Interest to be paid: $" + interest);
        System.out.println(
            "Total amount of loan: $" + totalPayment);

        
    }

    public static void printModeStatement() {
        System.out.print(
            "Select an interest calculation mode:\n"
            + "(1) Flat Interest\n"
            + "(2) Compounding Interest Without Monthly Payments\n"
            + "(3) Compounding Interest With Monthly Payments\n"
        );
    }

    public static void compoundNoPay() {
        while(true){
            System.out.print("Enter the amount of your loan: ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextDouble()){
                loanAmt = scan.nextDouble();
                if(loanAmt > 0){
                    break;
                }
            }
        }
         while(true){
            System.out.print("Enter the term of your loan (years): ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextInt()){
                loanTerm = scan.nextInt();
                if(loanTerm > 0){
                    break;
                }
            }
        }
         while(true){
            System.out.print("Enter the interest on your loan (%): ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextDouble()){
                interestRate = scan.nextDouble();
                if(interestRate > 0){
                    break;
                }
            }
        }
        monthsRemaining = loanTerm * 12;
        while(monthsRemaining > 0){
            interest = interest + (loanAmt + interest) * (interestRate/1200);
            monthsRemaining -= 1;
        }
        double totalPayment = interest + loanAmt;
             System.out.println(
            "Original loan amount: $" + loanAmt);
        System.out.println(
            "Loan Term: " + loanTerm + " years");
        System.out.println(
            "Interest Rate: " + interestRate + " %");
        System.out.println(
            "Interest to be paid: $" + interest);
        System.out.println(
            "Total amount of loan: $" + totalPayment);
    }
    public static void compoundWithPay() {
        while(true) {
            System.out.print("Enter the amount of your loan: ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextDouble()) {
                loanAmt = scan.nextDouble();
                if (loanAmt > 0) {
                    break;
                }
            }
        }
               while(true) {
            System.out.print("Enter the term of your loan (years): ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextInt()) {
                loanTerm = scan.nextInt();
                if (loanTerm > 0) {
                    break;
                }
            }
        }
                 while(true){
            System.out.print("Enter the interest on your loan (%): ");
            Scanner scan;
            scan = new Scanner(System.in);
            if(scan.hasNextDouble()){
                interestRate = scan.nextDouble();
                if(interestRate > 0){
                    break;
                }
            }
        } 
        double ratePerMonth = interestRate / 1200;
        double monthlyPayment = loanAmt * (ratePerMonth / (1 - Math.pow((1 + ratePerMonth), (loanTerm * -12))));
        double moneyOwed = loanAmt;
        double interestTwo = 0;
        while(moneyOwed > 0) {
            interest = moneyOwed * ratePerMonth;
            moneyOwed = interest + moneyOwed - monthlyPayment;
            interestTwo = interestTwo + interest;
        }
        double totalAmountToBePaid = interestTwo + loanAmt;
        double finalMonthPayment = monthlyPayment + totalAmountToBePaid - (monthlyPayment * 12 * loanTerm);
        System.out.println("Original loan amount: $" + loanAmt);
        System.out.println("Interst rate: " + interestRate + "%");
        System.out.println("Loan Term: " + loanTerm + " years");
        System.out.println("Monthly payment: $" + monthlyPayment);
        System.out.println("Final monthly payment: $" + finalMonthPayment);
        System.out.println("Total amount paid: $" + totalAmountToBePaid);
        System.out.println("Interest paid: $" + interestTwo);
        
    }
}