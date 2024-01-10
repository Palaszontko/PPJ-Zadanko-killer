class Node {
    Student data;
    Node next;
    Node prev;

    public Node(Student data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class SortedDoublyLinkedList {
    Node head;
    Node tail;

    public Boolean reversed = false;

    public SortedDoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Student student) {
        Node temp = new Node(student);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            Node current = head;

            Boolean array[] = new Boolean[this.length()];

            int i = 0;
            // set true for node that need swap and false for those that doesn't
            while (current != null) {
                array[i] = Student.compare(current.data, temp.data);
                i += 1;
                current = current.next;
            }

            int true_count = 0, false_count = 0;

            for (Boolean sta : array) {
                if (sta)
                    true_count++;
                else
                    false_count++;
            }
            // all true means -> all others are "bigger"
            if (false_count == 0) {
                // reversed checked if list is reversed or not
                // if reversed then insert at the end of the list
                if (reversed) {
                    insertAtIndex(student, length());
                } else {
                    insertAtIndex(student, 0);
                }
                // all false means -> all others are "bigger"
            } else if (true_count == 0) {

                // reversed checked if list is reversed or not
                // if reversed then insert at the front of the list
                if (reversed) {
                    insertAtIndex(student, 0);
                } else {
                    insertAtIndex(student, length());
                }

            } else {

                if (reversed) {
                    int index_insert = 0;
                    // find first false and insert before it
                    for (int j = 0; j < array.length; j++) {
                        if (!array[j]) {
                            index_insert = j;
                            break;
                        }
                    }

                    insertAtIndex(student, index_insert);

                } else {
                    int index_insert = 0;
                    // find first true and insert before it
                    for (int j = 0; j < array.length; j++) {
                        if (array[j]) {
                            index_insert = j;
                            break;
                        }
                    }

                    insertAtIndex(student, index_insert);
                }

            }

        }
    }

    public void insertAtIndex(Student student, int index) {

        Node temp = new Node(student);

        // if index is 0 insert at the front of the list
        if (index == 0) {
            temp.next = head;
            head.prev = temp;
            head = temp;
            // if index is the last one insert at the end of the list
        } else if (index == this.length()) {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;

        } else {
            int i = 0;

            Node current = head;

            while (i < index - 1) {
                current = current.next;
                i += 1;
            }

            temp.next = current.next;
            temp.prev = current;

            current.next.prev = temp;
            current.next = temp;
        }

    }

    public void reverse() {
        System.out.println("Wywołanie reverse");
        reverse_struc(head, tail);

        if (reversed) {
            reversed = false;
        } else {
            reversed = true;
        }
    }

    // swaping first and last and then move first and last to next and prev
    // and repeat until first and last are the same or next to each other
    // if next to each other then swap them and return
    public void reverse_struc(Node first, Node last) {

        if (first == last) {
            return;
        } else if (first.next == last && last.prev == first) {
            swap(first, last);
            // System.out.println("Wywołanie reverse_struc " + first.data + " " +
            // last.data);
            return;
        }

        swap(first, last);

        reverse_struc(first.next, last.prev);
    }

    protected void swap(Node node1, Node node2) {
        Student tmp = node1.data;
        node1.data = node2.data;
        node2.data = tmp;
    }

    public void size() {
        System.out.println("Size of the DLL: " + length());
    }

    public int length() {

        Node current = head;
        int i = 0;

        while (current != null) {
            i += 1;
            current = current.next;
        }

        return i;
    }

    public void removeAt(int index) throws IndexOutOfBoundsException {

        try {
            // empty list
            if (head == null) {
                throw new RemovalFromEmptyListException("Can't remove node from empty list");

                // remove smth out of bound
            } else if (index < 0 || index > this.length()) {
                String str_error = String.format("Index %d is out of bounds for list of size %d", index, this.length());
                throw new IndexOutOfBoundsException(str_error);

                // remove index 0
            } else if (index == 0) {
                removeFirst();

                // remove last index
            } else if (index == length() - 1) {
                removeLast();

                // remove any other index
            } else {

                Node current = head;

                int i = 0;

                while (i != index) {
                    current = current.next;
                    i += 1;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;

            }

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (RemovalFromEmptyListException e) {
            e.printStackTrace();
        }

    }

    public void removeFirst() throws RemovalFromEmptyListException {
        try {
            if (head == null) {
                throw new RemovalFromEmptyListException("Can't remove node from empty list");
            } else {
                if (head == tail) {
                    tail = null;
                    head = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            }
        } catch (RemovalFromEmptyListException e) {
            e.printStackTrace();
        }

    }

    public void removeLast() throws RemovalFromEmptyListException {
        try {
            if (head == null) {
                throw new RemovalFromEmptyListException("Can't remove node from empty list");
            } else {
                if (head == tail) {
                    tail = null;
                    head = null;
                } else {
                    tail = tail.prev;
                    tail.next = null;
                }
            }
        } catch (RemovalFromEmptyListException e) {
            e.printStackTrace();
        }

    }

    public void supplyTo(Consumer consumer) {
        Node current = head;

        while (current != null) {
            consumer.accept(current.data);
            current = current.next;
        }
    }

    @Override
    public String toString() {

        String str = "";

        Node current = head;

        while (current != null) {
            str += "(";
            str += current.data;
            str += current.next != null ? ") -> " : ")";
            current = current.next;
        }

        return str;
    }

}