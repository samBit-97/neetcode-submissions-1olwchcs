class MyCircularQueue {

    ListNode front;
    ListNode rear;
    int size;
    int length;

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }
    }

    public MyCircularQueue(int size) {
        this.size = size;
        this.length = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = front;
            rear.next = newNode;
            rear = newNode;
        }
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (length == 1) {
            front = null;
            rear = null;
        } else {
            ListNode temp = front;
            front = front.next;
            rear.next = temp.next;
            temp.next = null;
        }
        length--;
        return true;
    }

    public int Front() {
        return front == null ? -1 : front.val;
    }

    public int Rear() {
        return rear == null ? -1 : rear.val;
    }


    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */