package DSA.linkedlist;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache
public class L146LRUCache {

//⭐In an LRU (Least Recently Used) cache, both get() and put() operations count as "uses" for the key.
//  When a key is accessed (via get()) or inserted/updated (via put()),
//  it is moved to the head of the list to mark it as recently used.
//  Conversely, when the cache exceeds its capacity, the key at the end of the list (just before the tail dummy node)
//  is removed because it's the least recently used key.
    Map<Integer, Node> keyToNodeMap;
    Node tail;
    Node head;
    int capacity;
    public L146LRUCache(int capacity) {
        keyToNodeMap = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = keyToNodeMap.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node); //In an LRU (Least Recently Used) cache, both get() and put() operations count as "uses" for the key.
        insertAsHead(node);
        return node.value;
    }

    private void insertAsHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

//  In an LRU (Least Recently Used) cache, both get() and put() operations count as "uses" for the key.
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            node.value = value;
            removeNode(node);
            insertAsHead(node);
        } else {
            if (capacity == keyToNodeMap.size()) {
                keyToNodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node node = new Node(key, value);
            keyToNodeMap.put(key, node);
            insertAsHead(node);
        }
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
