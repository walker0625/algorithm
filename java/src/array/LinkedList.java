
package array;

class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

}

class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void append(int value) {

        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int get(int idx) {

        Node current = this.head;

        for (int i = 0; i < idx; i++) {
            current = current.next;
        }

        return current.value;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);

        System.out.println(ll.get(3));
    }

}
