public class code_runner {
    // uncomment function calls to work on different questions
    public static void main(String[] args) {
        // call_quicksort();
        // callNode();
        // call_wQueue();
        // call_wQueue2();
        call_BST();
    }

    /**
     * @brief this function creates an instance of the Q1_quicksort class and sort
     *        the specified array with quicksort
     */
    public static void call_quicksort() {
        int[] arr = { 11, 2, 3, 4, 7, 9, 25 }; // array should be modified here.
        Q1_quicksort q1 = new Q1_quicksort();
        q1.my_quicksort(arr);
    }

    /**
     * @brief this function creates an instance of DLinkedList class and the methods
     *        inside can be used to establish and modify an doubly linked list.
     */
    public static void callNode() {
        DLinkedList d_List = new DLinkedList();
        d_List.append(9);
        d_List.replace(0, 10);
        d_List.insert(0, 3);
        d_List.insert(1, 5);
        d_List.append(9);
        d_List.insert(3, 6);
        d_List.printNodes();
        d_List.remove(0);
        d_List.printNodes();
        System.out.println("\n" + d_List.get(2));
        System.out.println(d_List.size());
        d_List.printNodes();
        d_List.clear();
        d_List.printNodes();
    }

    /**
     * @brief this function creates an instance of Class weirdQueue,
     *        you can create and modify the queue you created
     */
    public static void call_wQueue() {
        weirdQueue q1 = new weirdQueue();
        q1.enqueue('a');
        q1.enqueue('c');
        q1.enqueue(3);
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
    }

    /**
     * @brief this function creates an instance of Class weirdQueue2,
     *        you can create and modify the queue you created
     */
    public static void call_wQueue2() {
        weirdQueue2 q2 = new weirdQueue2();
        q2.enqueue('a');
        q2.enqueue('1');
        q2.enqueue('c');
        q2.enqueue('d');
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
    }

    /**
     * @brief this function creates an instance of Class BinarySearchTree
     *        for tree.traverse(idx), idx can be 0,1,2
     *        0: preorder 1: inorder 2: postorder
     */
    public static void call_BST() {
        BinarySearchTree tree = new BinarySearchTree();
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 }; // modify the array here
        tree.BSThelper(arr);
        System.out.println("\nPreorder:");
        tree.traverse(0);
        System.out.println("\nInorder");
        tree.traverse(1);
        System.out.println("\nPostorder:");
        tree.traverse(2);

    }
}
