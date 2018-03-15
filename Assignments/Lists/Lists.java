import java.util.*;

class Lists {
    public static final int Add = 1;
    public static final int Remove = 2;
    public static final int Quit = 3;
    public static void main(String[] args) {
        ArrayList<Integer> todoList = new ArrayList<Integer>();
        printStatement();
        if(scan.hasNextInt()) {
            mode = scan.NextInt();
            if(mode == Add) {
                Add();
            }
            else if(mode == Remove) {
                Remove();
            }
            else if(mode == Quit) {
                System.out.println("Goodbye");
                break;
            }
            else {
                continue;
            }
        }
    }
    public static void printStatement() {
        System.out.print(
            "What would you like to do?\n"
            +"\t(1)Add something to the list\n"
            +"\t(2)Remove something from the list\n"
            +"\t(3)Quit\n"
        );
    }
    public static void Add() {
        
    }
}