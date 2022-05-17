import linkedList.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.printRevers();
        list.print();

        /*
         * LinkedList<String> stringList = new LinkedList<String>();
         * stringList.add("first name");
         * stringList.add("last name");
         * stringList.add("phone number");
         * stringList.add("jhon", 0);
         * stringList.add("deer", 2);
         * stringList.printRevers();
         */
    }
}
