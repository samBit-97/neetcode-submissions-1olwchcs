class LRUCache {
    public class CacheNode {

        int key, value;
        CacheNode next, prev;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private Map<Integer, CacheNode> cache;
    private int capacity;
    private CacheNode tail, head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        tail = new CacheNode(0, 0);
        head = new CacheNode(0, 0);
        tail.next = head;
        head.prev = tail;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        CacheNode node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        
        CacheNode newNode = new CacheNode(key, value);
        insert(newNode);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            CacheNode lru = tail.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }

    private void insert(CacheNode node) {
        CacheNode prev = head.prev;
        prev.next = node;
        node.prev = prev;
        node.next = head;
        head.prev = node;
    }

    private void remove(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode after = node.next;
        prev.next = after;
        after.prev = prev;
    }
}
