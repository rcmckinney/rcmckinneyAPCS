import java.util.Scanner;

class Plinko {

    
    public static final int SINGLE_DISC = 1;
    public static final int MULTI_DISC = 2;
    public static final int TERMINATE = 3;

    public static final int[] VALUES = {1, 3, 2, 0, 5, 0, 2, 3, 1};
    public static int[] results = {0,0,0,0,0,0,0,0,0};

    public static int mode = -1;
    public static int vPosition = -1;
    public static int hPosition = -1;
    public static int numOfDisks = -1;
    public static int totalPointsReal = -1;
    public static int totalPoints = -1;

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
                System.out.println("You landed in position: " + hPosition/2);
                System.out.println("You scored: " + VALUES[hPosition/2] + " points!");
                }
                else if(mode == MULTI_DISC) {
                    System.out.println("How many disks would you like to drop?: ");
                    if(scan.hasNextInt()) {
                        numOfDisks = scan.nextInt();
                    }
                    System.out.println("Where would you like to drop the disk? (0-8): ");
                    if(scan.hasNextInt()) {
                        hPosition = scan.nextInt();
                        hPosition = hPosition * 2;
                    }
                    for(int x = 1; x <= numOfDisks; x++) {
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
                        }
                        results[hPosition / 2]++;
                    }
              
                    for(int x = 0; x <= 8; x++) {
                        totalPoints= VALUES[x] * results[x];
                        totalPointsReal = totalPoints + totalPointsReal;
                    }
                    totalPointsReal = totalPointsReal + 1;

                    System.out.println("You landed in position 1: " + results[0] + " times.");
                    System.out.println("You landed in position 2: " + results[1] + " times.");
                    System.out.println("You landed in position 3: " + results[2] + " times.");
                    System.out.println("You landed in position 4: " + results[3] + " times.");
                    System.out.println("You landed in position 5: " + results[4] + " times.");
                    System.out.println("You landed in position 6: " + results[5] + " times.");
                    System.out.println("You landed in position 7: " + results[6] + " times.");
                    System.out.println("You landed in position 8: " + results[7] + " times.");
                    System.out.println("You landed in position 9: " + results[8] + " times.");
                    System.out.println("You scored: " + totalPointsReal +" points!");
                    results[0] = 0;
                    results[1] = 0;
                    results[2] = 0;
                    results[3] = 0;
                    results[4] = 0;
                    results[5] = 0;
                    results[6] = 0;
                    results[7] = 0;
                    results[8] = 0;
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