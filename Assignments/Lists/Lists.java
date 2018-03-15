import java.util.*;

class Lists {
    public static void main(String[] args) {
            ArrayList<Integer> numList = new ArrayList<Integer>();

    numList.add(1);
    numList.add(2);
    numList.add(3);
    numList.add(4);
    numList.add(5);

    for(int i = 0; i < numList.size(); i++) {
        System.out.println(numList.get(i));
    }
    }
}