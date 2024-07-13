
/*
Problem Statement :
Design and implement a data structure for a Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key): Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value): Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting a new item.

Constraints
The number of get and put operations will be in the range [1, 10^5].
The capacity of the cache is between 1 and 10^5.
 */

//Nodes used for string the key and value of the LRU;
class cacheNode {
    int key;
    int value;
    cacheNode prev;
    cacheNode next;

    cacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRU {
    private final int max_Capacity;
    private int current_Size;
    private cacheNode head, tail;
    private cacheNode[] node_Map;

    //Constructor to initialize the LRU cache capacity and Array of object node where key acts as the array index;
    public LRU(int capacity) {
        this.max_Capacity = capacity;
        this.current_Size = 0;
        this.node_Map = new cacheNode[100001]; //As per constraints 1 to 10^5

        head = new cacheNode(0, 0);
        tail = new cacheNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(cacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(cacheNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /*
    Required get function that checks if the LRU key is in the cache or not,
            True: Removes the node from the linked list and adds to the front of the list, returns value.
            False: return -1.
     */
    public int get(int key) {
        if (node_Map[key] != null) {
            cacheNode node = node_Map[key];
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    /*
    Checks if the key is there or not
            true: uses the get function for the process of adding to start
            else: Checks if the size of the capacity is reached or not,
                    if not : adds the new key and value to the front of linked list
                    if reached : removes the node prev of tail and add the new_node to the front
     */
    public void put(int key, int value) {
        if (node_Map[key] != null) {
            get(key);
        } else {
            cacheNode new_Node = new cacheNode(key, value);
            node_Map[key] = new_Node;
            if (current_Size < max_Capacity) {
                current_Size++;
                addToFront(new_Node);
            } else {
                node_Map[tail.prev.key] = null;
                removeNode(tail.prev);
                addToFront(new_Node);
            }
        }
    }

    public void displayCache() {
        cacheNode current = head.next;
        while (current != tail) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LRU obj = new LRU(3);

        obj.put(1, 10);
        obj.put(2, 20);
        obj.put(3, 30);

        obj.displayCache();

        obj.put(4, 40);
        System.out.println("After adding 4:");
        obj.displayCache();

        obj.put(5, 50);
        System.out.println("After adding 5:");
        obj.displayCache();
    }
}
