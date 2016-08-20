import java.util.*;

public class LRUCache {
    
	class Node{
	    int key;
	    int val;
	    Node prev;
	    Node next;
	 
	    public Node(int key, int value){
	        this.key = key;
	        this.val = value;
	    }
	}
	int size;
	int capacity;
	Node head;
	Node tail;
	HashMap<Integer,Node> map;
	
    public LRUCache(int capacity) {
    	this.size=0;
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
    	if (!map.containsKey(key))
    		return -1;
    	Node node = map.get(key);
    	//delete node from current
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    	
    	//Replace node at front
    	insertFront(node);
        return node.val;
    }
    
    public void set(int key, int value) {
    	if (this.get(key)!=-1)
    	{
    		Node change = map.get(key);
    		change.val = value;
    		return;
    	}
        Node n = new Node(key, value);
        size++;
        if (this.size > capacity)
        {
        	Node toRemove = tail.prev;
        	toRemove.prev.next = tail;
        	tail.prev = toRemove.prev;
        	map.remove(toRemove.key);
        	size--;
        }
        insertFront(n);
        map.put(key, n);
    }
    
    private void insertFront(Node n)
    {
    	Node next = head.next;
    	n.next = next;
    	next.prev = n;
    	head.next = n;
    	n.prev = head;
    }
}