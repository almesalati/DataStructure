package linkedList;

public class LinkedListSum {
    @SuppressWarnings("unused")
    private class Number {
        long number;
        Number next;
        Number previous;
    }

    private Number head;
    private Number tail;
    private Number temp;

    public void add(long value) {
        this.tail = new Number();
        this.tail.number = value;
        if (head == null) {
            this.head = this.temp = this.tail;
        } else {
            this.temp.next = this.tail;
            this.tail.previous = this.temp;
            this.temp = this.tail;
        }
    }

    public void print() {
        Number pointer = this.head;
        while (pointer != null) {
            System.out.print(pointer.number + "");
            pointer = pointer.next;
        }
    }

    public static LinkedListSum sum(LinkedListSum list1, LinkedListSum list2) {
        Number pointer1 = list1.head;
        Number pointer2 = list2.head;
        String listOneItems = "", listTwoItems = "", result = "";
        long listOneInt = 0, listTwoInt = 0, resultInt = 0;
        // get list one values
        while (pointer1 != null) {
            listOneItems += pointer1.number;
            pointer1 = pointer1.next;
        }
        // get list tow items
        while (pointer2 != null) {
            listTwoItems += pointer2.number;
            pointer2 = pointer2.next;
        }
        // System.out.println("list item: " + listOneItems);
        // add items
        listOneInt = Long.valueOf(listOneItems);
        listTwoInt = Long.valueOf(listTwoItems);
        resultInt = listOneInt + listTwoInt;
        result = String.valueOf(resultInt);
        // create new linked list
        LinkedListSum resultList = new LinkedListSum();
        for (int i = 0; i < result.length(); i++) {
            resultList.add(Integer.parseInt(result.charAt(i) + ""));
        }
        return resultList;
    }

    public static LinkedListSum sumOld(LinkedListSum list1, LinkedListSum list2) {
        Number list1Pointer = list1.head, list2Pointer = list2.head;
        long sum = 0, carry = 0;
        String tempString = "";
        LinkedListSum result = new LinkedListSum();
        while (list1Pointer != null && list2Pointer != null) {
            sum = list1Pointer.number + list2Pointer.number;
            if (sum > 9) {
                // 105
                // 5
                tempString += sum;
                carry = Long.valueOf(tempString.charAt(0) + "");
                sum = Long.valueOf(tempString.charAt(1) + "");
                result.add(sum);
                sum = 0;
                carry = 0;
                tempString = "";
            } else if (sum < 9) {
                result.add(sum + carry);
            }
            list1Pointer = list1Pointer.next;
            list2Pointer = list2Pointer.next;
        }
        return result;
    }
}
