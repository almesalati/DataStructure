package linkedList;

public class LinkedList<T> {

    @SuppressWarnings("unused")
    private class Data {
        T item;
        Data next;
        Data previous;
    }

    private int size = 0;
    //
    private Data head;
    private Data tail;
    private Data temp;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(T data) {
        // | | -> | null |
        if (head == null) {
            this.head = new Data();
            this.head.item = data;
            this.head.next = null;
            this.head.previous = null;
            this.size++;
        } else if (this.tail == null) {
            // | | -> | | -> | |
            this.tail = new Data();
            this.tail.item = data;
            this.tail.next = null;
            this.tail.previous = this.head;
            this.head.next = this.tail;
            this.size++;
        } else {
            // |head| -> | | -> |temp| -> |tail|
            this.temp = this.tail;
            this.tail = new Data();
            this.tail.item = data;
            this.tail.next = null;
            this.tail.previous = this.temp;
            temp.next = this.tail;
            this.size++;
        }
    }

    public void add(T data, int index) {
        int count = 0;
        Data pointer = this.head;
        while (pointer != null) {
            if (count == index) {
                break;
            }
            ++count;
            pointer = pointer.next;
        }
        Data newData = new Data();
        newData.item = data;
        this.temp = pointer.next;
        // sawp values
        newData.item = pointer.item;
        pointer.item = data;
        // set pointer
        pointer.next = newData;
        newData.next = this.temp;
    }

    public T get(int index) {
        Data pointer = this.head;
        int count = 0;
        while (pointer != null) {
            if (count == index)
                return pointer.item;
            count++;
            pointer = pointer.next;
        }
        return null;
    }

    public void print() {
        Data pointer = this.head;
        while (pointer != null) {
            System.out.println(pointer.item);
            pointer = pointer.next;
        }
    }

    public void printRevers() {
        Data pointer = this.tail;
        while (pointer != null) {
            System.out.println(pointer.item);
            pointer = pointer.previous;
        }
    }

    public int getSize() {
        return this.size;
    }
}
