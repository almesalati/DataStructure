//import java.util.ArrayList;

import linkedList.LinkedListSum;

//import linkedList.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedListSum numberList = new LinkedListSum();
        numberList.add(6);
        numberList.add(0);
        numberList.add(0);

        //
        LinkedListSum numberList2 = new LinkedListSum();
        numberList2.add(5);
        numberList2.add(0);
        //
        LinkedListSum sum = LinkedListSum.sum(numberList, numberList2);
        sum.print();

    }
}
