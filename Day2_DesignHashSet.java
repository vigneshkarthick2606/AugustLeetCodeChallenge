/*
Design HashSet

Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

	add(value): Insert a value into the HashSet. 
	contains(value) : Return whether the value exists in the HashSet or not.
	remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
	
Sample:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:
	All values will be in the range of [0, 1000000].
	The number of operations will be in the range of [1, 10000].
	Please do not use the built-in HashSet library.

*/
--------------------------------------------------------------------------------------------------------------------------

// This is naive approach
// Need to use seperate Chaining to handle hash collision
// List<Intger>
class MyHashSet {
    
    int[] bucket;

    /** Initialize your data structure here. */
    public MyHashSet() {
       bucket = new int[1000001];
       Arrays.fill(bucket, -1);
    }
    
    public void add(int key) {
       bucket[key] = key;
    }
    
    public void remove(int key) {
        if(bucket[key] == key){
            bucket[key] = -1;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(bucket[key] == key)
            return true;
        return false;
    }
}


----------------------------------------------------------------------------------------------

class MyHashSet {
    
    class Node {
        int value;
        Node next;
        
        public Node(int key){
            value = key;
            next = null;
        }
    }
    
    Node[] set;
    int capacity;
    int size;
    float load;
    

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new Node[10000];
        capacity = 10000;
        size = 0;
        load = size / capacity;
    }
    
    public void add(int key) {
        
        if (contains(key)) {
            return;
        };
        
        Node n = new Node(key);
        size++;
        load = size/capacity;
        
        if (load > .7) {
            expand();
        }
        
        int hash = key % capacity;
        
        if (set[hash] == null) set[hash] = n;
        else {
            Node temp = set[hash];
            n.next = temp;
            set[hash] = n;
        }
    }
    
    public void expand(){
        
        Node[] newset = new Node[capacity * 2 + 1];
        capacity = capacity * 2 + 1;
        for (int i = 0; i < set.length; i++){
            Node curr = set[i];
            
            while (curr != null){
                Node next = curr.next;
                int val = curr.value;
                int pos = val % capacity;
                if (newset[pos] == null) newset[pos] = curr;
                else {
                    Node temp = newset[pos];
                    curr.next = temp;
                    newset[pos] = curr;
                }
                curr = next;
            }
        }
        
        set = newset;
        load = size/capacity;
        
    }
    
    public void remove(int key) {
        
        int pos = key % capacity;
        Node n = set[pos];
        if (n == null) return;
        Node prev = n;
        
        if (n.value == key){   
            set[pos] = n.next;
        }
        n = n.next;
        
        while (n != null){
            if (n.value == key){
                prev.next = n.next;
            }
            n = n.next;
            prev = prev.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int pos = key % capacity;
        Node n = set[pos];
        
        while (n != null){
            if (n.value == key) return true;
            n = n.next;
        }
        
        return false;
    }
}

