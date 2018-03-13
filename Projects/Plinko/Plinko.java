import java.util.Scanner;

class Plinko {

    
    public static final int SINGLE_DISC = 1;
    public static final int MULTI_DISC = 2;
    public static final int TERMINATE = 3;

    public static final int[] VALUES = {1, 3, 2, 0, 5, 0, 2, 3, 1};

    public static int mode = -1;
    public static int vPosition = -1;
    public static int hPosition = -1;

    public static void main(String[] args) {
        Scanner scan;
        while(true) {
            scan = new Scanner(System.in);
            printModeStatement();
            if(scan.hasNextInt()) {
                mode = scan.nextInt();
                if(mode == SINGLE_DISC) {
                    scan = new Scanner(System.in);
                    System.out.println("Where would you like to drop the disk? (0-8): ");
                    if(scan.hasNextInt()) {
                        hPosition = scan.nextInt();
                        hPosition = hPosition * 2;
                    }
                    for(vPosition = 12; vPosition >= 0; vPosition--) {
                        if(hPosition == 16) {
                            hPosition --;
                        }
                        else if(hPosition == 0){
                            hPosition ++ ;
                        }
                        else if(Math.random() > .5){
                            hPosition ++;
                        }
                        else{
                            hPosition --;
                        }
                        if(isEven(vPosition)) {
                            printOddRow();
                        }
                        else{
                            printEvenRow();
                        }
                    }
                }
                else if(mode == MULTI_DISC) {
                    System.out.println("Mode not yet implemented");
                }
                else if(mode == TERMINATE) {
                    System.out.println("Goodbye");
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    public static void printOddRow() {
        System.out.print("|");
       for(int i = 0; i <= 16; i++) {
            if(hPosition == i) {
                System.out.print("O");
            }
            else if(isEven(i)) {
                System.out.print(" ");
            }
            else {
                System.out.print(".");
            }
        }
        System.out.print("|");
        System.out.print("\n");    
    }

    public static void printEvenRow() {
        System.out.print("|");
        for(int i = 0; i <= 16; i++) {
            if(hPosition == i) {
                System.out.print("O");
            }
            else if(isEven(i)) {
                System.out.print(".");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.print("|");
        System.out.print("\n"); 
    }
    public static Boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static void printModeStatement() {
        System.out.print(
            "Select a mode:\n"
            + "\t(1) Single disc\n"
            + "\t(2) Multiple discs\n"
            + "\t(3) Quit\n"
        );
    }
}