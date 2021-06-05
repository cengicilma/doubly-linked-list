package doubly.linked.list;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addToRear(4);
        list.addToFront(5);
        list.addToFront(6);

        list.removeFromRear();
        list.removeFromFront();

        for (Integer i: list) {
            System.out.println(i);
        }

        System.out.println("list size: " + list.count());
    }
}
