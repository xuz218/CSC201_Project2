/**
 * This is Problem 2 of the project. This class overrides the methods inside Mylist class.
 * It can be called by the method callNode() inside the coder_runner class.
*/
public class DLinkedList implements MyList {
    public class Node {
        private Object item;
        private Node prev;
        private Node next;

        private Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        private Node(Object item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    private int length;
    private Node head = null;
    private Node tail = null;

    /* Default constructor */
    public DLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * @brief insert 'item' at 'index'
     *        worst case running time: O(n)
     *        error: 1. insert element at non-zero index of an empty list 2. the
     *        index is out of bound (index < 0 or index > length)
     * @param index
     * @param item
     * @return boolean - return true when successful, false otherwise
     */
    public boolean insert(int index, Object item) {

        // Error of inserting element at the non-zero index of an empty list
        if (head == null && index != 0) {
            System.out.println("Error: Insert element at the non-zero index of an empty list");
            return false;
        }

        // Error of index out of bound
        if (index < 0 || index > length) {
            System.out.println("Error: Index out of bound");
            return false;
        }

        Node newNode = new Node(item);
        // Insert newNode as head here
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }else{
                tail = newNode;
            }
            head = newNode;
            length++;
            return true;
        }
        // Insert newNode as tail here
        else if (index == length) {
            if (tail != null) {
                tail.next = newNode;
            }

            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
            length++;
            return true;
        }
        // handle all other conditions
        else {
            Node temp = new Node();
            temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next = newNode;
                if (newNode.next != null) {
                    newNode.next.prev = newNode;
                }
            } 
            length++;
        }
        return true;
    }

    /**
     * @brief this function inserts 'item' at the end of the list
     *        worst case running time: O(1) with the tail
     *        error: no errors
     * @param item
     * @return boolean - return true when successful, false otherwise
     */
    public boolean append(Object item) {
        Node newNode = new Node(item);
        // condition of appending to a empty list.
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
        return true;
    }

    /**
     * @brief this function clears the entire list
     *        worst case running time: O(n)
     *        error: no errors
     */
    public void clear() {
        Node temp = new Node();
        while (head != null) {
            temp = head;
            head = head.next;
            temp = null;
        }
        length = 0;
    }

    /**
     * @brief this function checks if the list is empty
     *        worst case running time: O(1)
     *        error: no errors
     * @return boolean - return true if list is empty or false otherwise.
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * @brief this function returns the size of the list
     *        worst case running time: O(1)
     *        error: no errors
     * @return int - return the size of the list, else -1.
     */
    public int size() {
        if (head == null) {
            return -1;
        } else {
            return length;
        }
    }

    /**
     * @brief this function replaces the element at 'index' with 'item'
     *        worst case running time: O(n)
     *        error: 1. want to replace inside an empty list 2. the index is out of
     *        bound
     * @param index
     * @param item
     * @return boolean - return true when replace successfully, false otherwise
     */
    public boolean replace(int index, Object item) {
        Node newNode = new Node(item);
        // Error of replacing inside an empty list
        if (head == null) {
            System.out.println("Error: replacing inside an empty list");
            return false;
        }

        // Error of Index out of bound
        if (index < 0 || index > length - 1) {
            System.out.println("Error: Index out of bound.");
            return false;
        }

        // replace the head with newNode
        if (index == 0) {
            if (length == 1) {
                head = newNode;
                tail = newNode;
                return true;
            }
            newNode.next = head.next;
            head.next.prev = newNode;
            head = newNode;
            return true;
        }

        // handel all other conditions
        Node temp = new Node();
        temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        return true;
    }

    /**
     * @brief this function removes the element at 'index'.
     *        worst case running time: O(n)
     *        error: 1. want to remove inside an empty list 2. the index is out of
     *        bound
     * @param index
     * @return boolean - return true when remove successfully, false otherwise
     */
    public boolean remove(int index) {
        // Error of removing inside an empty list
        if (head == null) {
            System.out.println("Error: replacing inside an empty list");
            return false;
        }

        // Error of Index out of bound
        if (index < 0 || index > length - 1) {
            System.out.println("Error: Index out of bound.");
            return false;
        }

        // remove the head of the linkedlist
        if (index == 0) {
            // condition of only 1 element inside the list
            if (length == 1) {
                head = null;
                tail = null;
                length--;
                return true;
            }
            head = head.next;
            head.prev = null;
            length--;
            return true;
        }
        Node temp = new Node();
        temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                return false;
            } else {
                temp = temp.next;
            }
        }
        // condition of removing the tail
        if (temp.next == null) {
            temp.prev.next = null;
            length--;
        }
        // handle all other conditions
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            length--;
        }
        return true;
    }

    /**
     * @brief this function returns the element at 'index', but doesn't remove the
     *        item.
     *        worst case running time: O(n)
     *        error: 1. want to get value inside an empty list 2. the index is out
     *        of bound
     * @param index
     * @return boolean - return true when successfully obtain the value, false
     *         otherwise
     */
    public Object get(int index) {
        // Error of geting value inside an empty list
        if (head == null) {
            System.out.println("Error: getting value inside an empty list");
            return false;
        }

        // Error of Index out of bound
        if (index < 0 || index > length - 1) {
            System.out.println("Error: Index out of bound.");
            return false;
        }

        // getting the value of an item with an valid index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                return null;
            } else {
                temp = temp.next;
            }
        }
        return temp.item;
    }

    /**
     * @brief: a helper method for print out the nodes inside linkeslist,
     *  which is not included in MyList class
     */
    public void printNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("\nDoubly linked list is empty.");
            return;
        }
        System.out.println("\nNodes of doubly linked list: ");
        while (current != null) {
            // Print each node and then go to next.
            System.out.print(current.item + " ");
            current = current.next;
        }
    }
}
