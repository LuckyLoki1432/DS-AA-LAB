import java.util.Scanner;
class DNode {
    int data;
    DNode prev, next;
    DNode(int data) {
        this.data = data;
    }
}
public class DoublyLinkedList {
    DNode head;
    // 1. Insert at Start
    void insertAtStart(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Element inserted at start.");
    }
    // 2. Insert at End
    void insertAtEnd(int data) {
        DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
        } else {
            DNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Element inserted at end.");
    }
    // 3. Insert at Particular Position
    void insertAtPosition(int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid Position.");
            return;
        }
        if (pos == 1) {
            insertAtStart(data);
            return;
        }
        DNode temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position.");
            return;
        }

        DNode newNode = new DNode(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        System.out.println("Element inserted successfully.");
    }

    // 4. Delete at Start
    void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted element: " + head.data);

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // 5. Delete at End
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        DNode temp = head;

        if (temp.next == null) {
            System.out.println("Deleted element: " + temp.data);
            head = null;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("Deleted element: " + temp.data);

        temp.prev.next = null;
    }

    // 6. Delete by Value
    void delete(int key) {
        DNode temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        System.out.println("Element deleted successfully.");
    }

    // 7. Delete at Particular Position
    void deleteAtPosition(int pos) {
        if (head == null || pos < 1) {
            System.out.println("Invalid Position or Empty List.");
            return;
        }

        DNode temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        System.out.println("Deleted element: " + temp.data);
    }

    // 8. Search an Element
    void search(int key) {
        DNode temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println(
                    "Element found at position: " + position
                );
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Element not found.");
    }

    // 9. Display Forward
    void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        DNode temp = head;

        System.out.print("List: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // 10. Display Backward
    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        DNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Reverse List: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLinkedList list = new DoublyLinkedList();

        int choice;

        do {
            System.out.println("\n===== DOUBLY LINKED LIST MENU =====");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Particular Position");
            System.out.println("4. Delete at Start");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Delete at Particular Position");
            System.out.println("8. Search an Element");
            System.out.println("9. Display Forward");
            System.out.println("10. Display Backward");
            System.out.println("11. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    list.insertAtStart(sc.nextInt());
                    list.displayForward();
                    break;

                case 2:
                    System.out.print("Enter element: ");
                    list.insertAtEnd(sc.nextInt());
                    list.displayForward();
                    break;

                case 3:
                    System.out.print("Enter element: ");
                    int element = sc.nextInt();

                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    list.insertAtPosition(element, pos);
                    list.displayForward();
                    break;

                case 4:
                    list.deleteAtStart();
                    list.displayForward();
                    break;

                case 5:
                    list.deleteAtEnd();
                    list.displayForward();
                    break;

                case 6:
                    System.out.print("Enter element to delete: ");
                    list.delete(sc.nextInt());
                    list.displayForward();
                    break;

                case 7:
                    System.out.print("Enter position to delete: ");
                    int position = sc.nextInt();

                    list.deleteAtPosition(position);
                    list.displayForward();
                    break;

                case 8:
                    System.out.print("Enter element to search: ");
                    list.search(sc.nextInt());
                    break;

                case 9:
                    list.displayForward();
                    break;

                case 10:
                    list.displayBackward();
                    break;

                case 11:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 11);

        sc.close();
    }
}
