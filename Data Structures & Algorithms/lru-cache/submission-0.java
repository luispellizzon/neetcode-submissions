class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value, Node next, Node prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}


class LRUCache {
    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            put(key, node.value);
            return node.value;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(!this.map.containsKey(key)){
            if(this.size == this.capacity){
                this.map.remove(this.tail.key);
                if (this.tail.prev != null) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    this.head = this.tail = null;
                }
                this.size--;
            }
            Node newNode = new Node(key, value, this.head, null);
            if(this.head != null) this.head.prev = newNode;
            this.head = newNode;
            if(this.tail == null) this.tail = newNode;
            this.map.put(key, newNode);
            this.size++;
        } else{
            Node existingNode = this.map.get(key);
            existingNode.value = value;
            if (existingNode == head) return;
            
            if (existingNode.prev != null) existingNode.prev.next = existingNode.next;
            if (existingNode.next != null) existingNode.next.prev = existingNode.prev;
            if (existingNode == tail) tail = existingNode.prev;

            existingNode.next = this.head;
            existingNode.prev = null;
            this.head.prev = existingNode;
            this.head = existingNode;
        }
    }
}