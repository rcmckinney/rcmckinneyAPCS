import java.util.Scanner;

class Functions{
    // public static void main(String args[]) {
    //     System.out.print("Enter a string: ");
    //     Scanner scan = new Scanner(System.in);
    //     if(isValidString(scan)) {
    //         System.out.println("String Success!");
    //     }     
        
    //     else {
    //         System.out.println("String failure!" );
    //     }

    // }
    // public static Boolean isValidString(Scanner scan) {
    //     try {
    //         String s = scan.nextLine();
    //     }
    //     catch(Exception e) {
    //         return false;
    //     }
    //     return true;
    // }

    //     public static void main(String args[]) {
    //     System.out.print("Enter an int: ");
    //     Scanner scan = new Scanner(System.in);
    //     if(isValidInt(scan)) {
    //         System.out.println("Int Success!");
    //     }     
        
    //     else {
    //         System.out.println("Int failure!" );
    //     }

    // }
    // public static Boolean isValidInt(Scanner scan) {
    //     try {
    //         String s = scan.nextLine();
    //     }
    //     catch(Exception e) {
    //         return false;
    //     }
    //     return true;
    // }

        public static void main(String args[]) {
        System.out.print("Enter a double: ");
        Scanner scan = new Scanner(System.in);
        if(isValidDouble(scan)) {
            System.out.println("Double Success!");
        }     
        
        else {
            System.out.println("Double failure!" );
        }

    }
    public static Boolean isValidDouble(Scanner scan) {
        try {
            String s = scan.nextLine();
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }
}