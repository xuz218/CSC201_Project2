public class Node {

    private Object item;
    private Node prev;
    private Node next;

    public Node(Object item){
        this.item = item;
        this.prev = null;
        this.next = null;
    }

}
