import java.util.Scanner;

public class Calculator{
    public static int mode = -1; 
    public static double loanAmt = -1;
    public static int loanTerm = -1;
    public static double interestRate = -1;

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
        else {
            System.out.println("Other modes not yet supported."); //Replace this with calls to your appropriate functions            
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
           scan = new Scaneer(System.in);
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
        interest = (loanAmt*loanTerm*interestRate)/100;
        
    }

    public static void printModeStatement() {
        System.out.print(
            "Select an interest calculation mode:\n"
            + "(1) Flat Interest\n"
            + "(2) Compounding Interest Without Monthly Payments\n"
            + "(3) Compounding Interest With Monthly Payments\n"
        );
    }
}