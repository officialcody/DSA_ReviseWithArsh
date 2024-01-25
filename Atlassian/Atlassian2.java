/**
 * QUES 2 -> LRU Cache (LEETCODE - 146)
 * 
 * Company - Atlassian
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class LRUCache {
    private class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)) {
            Node node = this.map.get(key);
            delete(node);
            insertToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)) {
            delete(this.map.get(key));
        }
        if(this.map.size() == this.capacity) {
            delete(tail.prev);
        }
        insertToHead(new Node(key, value));
    }

    public void delete(Node node) {
        this.map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertToHead(Node node) {
        this.map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */