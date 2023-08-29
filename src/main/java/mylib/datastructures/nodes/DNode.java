package mylib.datastructures.nodes;

public class DNode {
    public int data;
    private DNode prev;
    public DNode next;

    public DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public DNode getNext() {
        return this.next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}