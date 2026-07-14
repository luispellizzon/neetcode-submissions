
class Node{
    int val = -1;
    Node next = null;
    Node prev = null;
    public Node(int val){
        this.val = val;
    }
}

class MyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        Node curr = this.head;
        int counter = 0;
        while(counter < index){
            curr = curr.next;
            counter++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(size == 0){
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(size == 0){
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;
        Node prevNode = null;
        int counter = 0;
        while(counter < index){
            prevNode = curr;
            curr = curr.next;
            counter++;
        }
        curr.prev = newNode;
        newNode.next = curr;
        newNode.prev = prevNode;
        prevNode.next = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
            size--;
            return;
        }
        Node curr = head;
        Node prev = null;
        int counter = 0;
        while(counter < index){
            prev = curr;
            curr = curr.next;
            counter++;
        }
        prev.next = curr.next;
        if(curr.next.prev != null){
            curr.next.prev = prev;
        } 
        curr.next = null;
        curr.prev = null;
        curr = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */