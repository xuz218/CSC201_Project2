
/**
 * This is Problem 3 of the project. This class combines two stacks from Mystack
 * class into a queue.
 * It can be called by the method call_wQueue2() inside the coder_runner class.
 */
public class weirdQueue2 {
    private Mystack box1;
    private Mystack box2;

    public weirdQueue2() {
        this.box1 = new Mystack();
        this.box2 = new Mystack();
    }

    /*
     * worst case running times of enqueue is θ(1) inside the linkedlist based type
     * Error conditions: 1. enqueue null items, 2. queue overflow (when CPU out of
     * memory)
     * 
     * @param item
     */
    public void enqueue(Object item) {
        // error of enqueue null items
        if (item == null) {
            System.out.println("Error: Null item used. Please check.");
        }
        box1.push(item);
    }

    /*
     * worst case of running times of dequeue is θ(N), which happens when the box2
     * is empty and box1 is not empty.
     * Error conditions: 1. queue underflow when dequeue an empty queue
     */
    public Object dequeue() {
        // error of dequeue an empty weird queue
        if (box2.isEmpty() && box1.isEmpty()) {
            System.out.println("Error: weird queue underflow");
            return null;
        }
        // fill out all the Input if output stack is empty
        if (box2.isEmpty()) {
            while (!box1.isEmpty()) {
                box2.push(box1.pop());
            }
        }
        Object temp = null;
        if (!box2.isEmpty()) {
            temp = box2.pop();
        }
        return temp;
    }
}
