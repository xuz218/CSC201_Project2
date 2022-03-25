/**
 * This is part of the Problem 3 of the project. This class establishes a
 * linkedlist based stack.
 */
public class Mystack {
    public class Node {

        private Object item;
        private Node next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head = null;
    private int size = 0;

    /**
     * @brief this function pushes the entered item into the stack
     * @param item
     */
    public void push(Object item) {
        Node newNode = new Node(item);
        // set newNOde as the head if head is null
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * @brief this function pops an item from the stack and return the value of the
     *        item
     * @return -return the Object popped
     */
    public Object pop() {
        Object temp = new Object();
        if (head == null) {
            return null;
        } else {
            temp = head.item;
            head = head.next;
            size--;
        }
        return temp;
    }

    /**
     * @brief this function returns the size of the stack
     * @return int
     */
    public int length() {
        return size;
    }

    /**
     * @brief this function checks if the stack is empty
     * @return boolean - return true if it is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
