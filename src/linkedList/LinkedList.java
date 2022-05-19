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
        this.size++;
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

    public void addFirst(T data) {
        // || -> || -> ||
        this.temp = this.head;
        this.head = new Data();
        this.head.item = data;
        this.head.next = this.temp;
        this.temp.previous = this.head;
        this.head.previous = null;
        this.size++;
    }

    public void addLast(T data) {
        this.temp = this.tail;
        this.tail = new Data();
        this.tail.item = data;
        this.tail.next = null;
        this.temp.next = this.tail;
        this.tail.previous = this.temp;
        this.size++;
    }

    public int indexOf(T data) {
        int index = 0;
        Data pointer = this.head;
        while (pointer != null) {
            if (pointer.item.equals(data)) {
                return index;
            }
            ++index;
            pointer = pointer.next;
        }
        return -1;
    }

    public void remove(int index) {
        int count = 0;
        Data pointer = this.head;
        while (pointer != null) {
            if (count == index) {
                if (pointer.previous == null) {
                    this.head = this.head.next;
                } else if (pointer.next == null) {
                    this.tail = this.tail.next;
                } else {
                    this.temp = pointer.previous;
                    this.temp.next = pointer.next;
                }
            }
            ++count;
            pointer = pointer.next;
        }
    }

    public void remove(T data) {

    }

    public int getSize() {
        return this.size;
    }
}
