class LFUCache {

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyNodeMap;
    private Map<Integer, DoublyLinkedList> freqListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        if (keyNodeMap.size() == capacity) {
            DoublyLinkedList minFreqBucket = freqListMap.get(minFreq);
            Node nodeToRemove = minFreqBucket.removeFirst();
            keyNodeMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);
        minFreq = 1;
        DoublyLinkedList list = freqListMap.getOrDefault(1, new DoublyLinkedList());
        list.addFirst(newNode);
        freqListMap.put(1, list);
        keyNodeMap.put(key, newNode);
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldFreqBucket = freqListMap.get(oldFreq);
        oldFreqBucket.remove(node);

        if (oldFreq == minFreq && oldFreqBucket.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedList newFreqBucket =
                freqListMap.getOrDefault(node.freq, new DoublyLinkedList());
        newFreqBucket.addFirst(node);
        freqListMap.put(node.freq, newFreqBucket);
    }

    private class Node {
        int key, val, freq;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private class DoublyLinkedList {
        Node head, tail;
        int size;

        public DoublyLinkedList() {
            this.tail = new Node(0, 0);
            this.head = new Node(0, 0);
            head.prev = tail;
            tail.next = head;
            size = 0;
        }

        public void addFirst(Node node) {
            Node prev = head.prev;
            prev.next = node;
            node.prev = prev;
            node.next = head;
            head.prev = node;
            size++;
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node after = node.next;
            prev.next = after;
            after.prev = prev;
            size--;
        }

        public Node removeFirst() {
            if (size == 0) return null;

            Node last = tail.next;
            remove(last);
            return last;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */