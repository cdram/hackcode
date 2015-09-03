class Node{
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}

public class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }
    
    private void remove(Node node){
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }
        
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            tail = node.pre;
        }
    }
    
    private void setHead(Node node){
        if(head == null){
            head = node;
            node.pre = null;
            node.next = null;
            tail = node;
        }else{
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;
        }
    }
    
    public void set(int key, int value) {
        Node node = null;
        if(map.containsKey(key)){
            node=  map.get(key);
            node.value = value;
            remove(node);
        }else{
            node = new Node(key,value);
            if(map.size()==capacity) {
                map.remove(tail.key);
                remove(tail);}
        }
        setHead(node);
        map.put(key, node);
    }
}