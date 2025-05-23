public class Queue<T> extends LinkedList<T>{

    public Queue() {}

    // Method to add data at the end of the list (enqueue). 
    public void enqueue(T data) {
        insertAtBack(data);
    }

    // Method to Removes data at the beginning of a list (dequeue). 
    public T dequeue() {
        return removeFromFirst();
    }

    // Method to Determine size of the list. 
    public int Size() {
        return getSize();
    }

    // Method to Determine whether the list is empty. 
    public boolean EmptyQueue() {
        return isEmpty();
    } 

    // Display all elements in the queue
    public void displayAll() {
        displayList();
    }
    
}