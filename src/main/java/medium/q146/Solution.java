//package javaLang.medium.q146;
//
//import java.util.*;
//
//public class Solution {}
//
//class LRUCache {
//
//    private int maxSize;
//    private int currSize;
//    private Map<Integer, Node> cacheMap = new HashMap<>();
//    private Node lruNode;
//    private Node mruNode;
//
//
//    public LRUCache(int capacity) {
//        this.maxSize = capacity;
//        this.currSize = 0;
//        lruNode = new Node(0,0);
//        mruNode = new Node(0,0);
//    }
//
//    public void put(int key, int value) {
//        if(cacheMap.containsKey(key)){
//            cacheMap.replace(key, new Node(key,value));
//            addNode(cacheMap.get(key));
//        } else {
//            cacheMap.put(key, new Node(key,value));
//            addNode(cacheMap.get(key));
//            currSize++;
//            if(currSize>maxSize){
//                removeNode();
//                currSize=maxSize;
//            }
//        }
//
//    }
//
//    public int get(int key) {
//    }
//}
//
//
//class Node {
//    private int val;
//    private int key;
//    private Node next;
//    private Node prev;
//
//    public Node(int val, int key) {
//        this.val = val;
//        this.key = key;
//    }
//
//    public int getKey() {
//        return key;
//    }
//
//    public void setKey(int key) {
//        this.key = key;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//
//    public Node getPrev() {
//        return prev;
//    }
//
//    public void setPrev(Node prev) {
//        this.prev = prev;
//    }
//}
//
