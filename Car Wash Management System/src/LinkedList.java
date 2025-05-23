import java.io.BufferedWriter;
import java.io.IOException;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    //insertAtFront()
    public void insertAtFront(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            current = head;
            head = newNode;
            newNode.next = current;
        }
        size++;
    }
    //insertAtBack()
    public void insertAtBack(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    //removeFromFirst()
    public T removeFromFirst(){
        if (head == null) {
            return null;
        }else{
            current = head;
            head = head.next;
            T data = current.data;
            if(head == null){
                tail = null;
            }
            current.next = null;
            current = null;
            size--;
            return data;
        }
    }

    //getHead()
    public T getHead() {
        current = head;
        if (current != null) {
            return current.data;
        }
        return null;
    }

    //getNext()
    public T getNext() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.data;
        }
        return null;
    }

    //isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // Determine the size of the list
    public int getSize() {
        return size;
    }

    // SearchCustomer() by Car License Plate/Customer ID 
    public T searchCustomer(String search) {
        current = head;
        while (current != null) {
            if (((CarWash) current.data).getCarLicensePlate().equals(search)) {
                return current.data;
            }else if(((CarWash) current.data).getCustId().equals(search)){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    //displayList()
    public void displayList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
    
        // Print table header
        System.out.printf("%-5s %-20s %-20s %-27s %-10s %-15s %-15s %-20s %-15s %-15s%n",
                "ID","Customer Name", "Customer Phone", "Customer Email", "Membership", "Car Brand", "Car Model", "Car License Plate", "Car Category", "Wash Package");
        System.out.println("=".repeat(170));
        
        //Print table Content
        Node<T> temp = head;
        while (temp != null) {
            CarWash cw = (CarWash) temp.data; // Cast to the appropriate data type
            System.out.printf("%-5s %-20s %-20s %-27s %-10s %-15s %-15s %-20s %-15s %-15s%n",
                    cw.getCustId(),        
                    cw.getCustName(),
                    cw.getCustPhone(),
                    cw.getCustEmail(),
                    cw.getMembership(),
                    cw.getCarBrand(),
                    cw.getCarModel(),
                    cw.getCarLicensePlate(),
                    cw.getCarCategory(),
                    cw.getWashPackage());
            temp = temp.next;
        }
    }

    //selectionSort
    public void selectionSort(int choice) {
        if (head == null || head.next == null) {
            return; // List is already sorted
        }
    
        current = head;
        for (int i = 0; i < size - 1; i++) {
            Node<T> minNode = current;
            Node<T> tempNode = current.next;
            for (int j = 0; j < size - i - 1; j++) {
                if (choice == 1) { // Sort by membership
                    if (!((CarWash) tempNode.data).getMembership() && ((CarWash) minNode.data).getMembership()) {
                        minNode = tempNode;
                    }
                } else if (choice == 2) { // Sort by package
                    if (((CarWash) tempNode.data).getWashPackage().compareTo(((CarWash) minNode.data).getWashPackage()) < 0) {
                        minNode = tempNode;
                    }
                }
                tempNode = tempNode.next;
            }
    
            // Swap the elements
            T temp = minNode.data;
            minNode.data = current.data;
            current.data = temp;
    
            // Update the current node
            current = current.next;
        }
    }

    //writeToFile
    public void writeToFile(BufferedWriter writer) throws IOException {
        current = head;
        while (current != null) {
            writer.write(current.data.toString() + "\n");
            current = current.next;
        }
    }
}

