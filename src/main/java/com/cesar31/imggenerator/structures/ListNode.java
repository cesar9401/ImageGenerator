package com.cesar31.imggenerator.structures;

/**
 *
 * @author cesar31
 */
public class ListNode {
    
    private int id;
    private Object object;
    private ListNode next;
    private ListNode previous;

    public ListNode() {
    }

    public ListNode(int id, Object object) {
        this.id = id;
        this.object = object;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }
}
