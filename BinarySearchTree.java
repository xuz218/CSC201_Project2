/**
 * This is Problem 4 of the project. This class constructs an sorted array into
 * a BST.
 * It can be called by the method call_BST() inside the main of coder_runner
 * class.
 */
public class BinarySearchTree {
    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int num;

        public TreeNode(int num) {
            this.left = null;
            this.right = null;
            this.num = num;
        }

        public TreeNode() {
            this.left = null;
            this.right = null;
            this.num = -999;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public void setRight(TreeNode node) {
            this.right = node;
        }

        public TreeNode getRight() {
            return this.right;
        }

        public int getItem() {
            return this.num;
        }

    }

    private TreeNode root = null;

    public TreeNode getRoot() {
        return this.root;
    }

    public void BSThelper(int[] array) {
        root = ArrayToTree(array, 0, array.length - 1);
    }

    /**
     * @brief: this function converts a sorted array into a balanced binary search
     *         tree, and return the root
     *         Error conditions: 1. constructing null or empty array into tree, 2.
     *         invalid low and high value entered
     * @param array
     * @param low
     * @param high
     * @return TreeNode - return the root of the constructed binary search tree
     */
    public TreeNode ArrayToTree(int array[], int low, int high) {
        // Error of constructing null array into tree
        if (array == null) {
            System.out.println("Error: constructing null array into tree");
            return null;
        }

        // Error of invalid low and high number
        if (low < 0 || high > array.length) {
            System.out.println("Error: invalid position index");
            return null;
        }

        // Error of constructing empty array into tree
        if (array.length == 0) {
            System.out.println("Error: constructing empty array into tree");
            return null;
        }
        // this is the base case
        if (low > high) {
            return null;
        }

        else {
            int mid = (low + high) / 2;
            TreeNode temp = new TreeNode(array[mid]);
            temp.setLeft(ArrayToTree(array, low, mid - 1)); // construct the left side recursively
            temp.setRight(ArrayToTree(array, mid + 1, high)); // construct the right side recursively
            return temp;
        }
    }

    /**
     * @brief: choose traverse method by entered index
     *         Error conditions: traversing null binary search tree
     * @param idx
     */
    public void traverse(int idx) {
        // Error of traversing a null tree
        if (root == null) {
            System.out.println("Error: traversing null BST");
            return;
        }
        if (idx == 0) {
            preorder(root);
        } else if (idx == 1) {
            inorder(root);
        } else if (idx == 2) {
            postorder(root);
        }
    }

    /**
     * @brief: traverse the BST and print the int variables stored in the tree nodes
     *         in preorder
     * @param root
     */
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getItem() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    /**
     * @brief: traverse the BST and print the int variables stored in the tree nodes
     *         in postorder
     * @param root
     */
    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getItem() + " ");
    }

    /**
     * @brief: traverse the BST and print the int variables stored in the tree nodes
     *         in inorder
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getItem() + " ");
        inorder(root.getRight());
    }
}
