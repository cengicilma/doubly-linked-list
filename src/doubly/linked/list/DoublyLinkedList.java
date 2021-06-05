package doubly.linked.list;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    Node<Item> head;
    Node<Item> tail;
    int size = 0;

    //Add a new item to the beginning of the list
    public void addToFront(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        size++;
    }

    //Remove an item from the beginning of the list
    public void removeFromFront() {
        if(head == null) {
            throw new IndexOutOfBoundsException("The linked list is empty.");
        }
        head.next.previous = null;
        head = head.next;
        size--;
    }

    //Add a new item to the end of the list
    public void addToRear(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;

        if(head == null) {
            head = newNode;
        }
        else {
            Node<Item> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
            newNode = tail;
        }
        size++;
    }

    //Remove an item from the end of the list
    public void removeFromRear() {
        if (head == null) {
            throw new IndexOutOfBoundsException("The link list is empty.");
        } else if (size == 1) {
            head = null;
        } else {
            Node<Item> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = tail;
            current.next = null;
        }
        size--;
    }

    //Return the size of the linked list
    public int count() { return size; }

    //Return an Iterator Object
    public Iterator<Item> iterator() { return new DoublyLinkedListIterator(); }

    //Define the Iterator class, and hasNext() and next() methods
    private class DoublyLinkedListIterator implements Iterator<Item> {
        Node<Item> current = head;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item = current.data;
            current = current.next;
            return item;
        }
    }
}
