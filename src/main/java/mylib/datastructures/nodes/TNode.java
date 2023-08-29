
package mylib.datastructures.nodes;

public class TNode {
    int data;
    TNode left;
    TNode right;
    TNode parent;
    int balance;

    // Constructors
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public int getBalance() {
        return this.balance;
    }

    // Setters
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Print method
    public String print() {
        String result = "Data: " + this.data + ", Balance: " + this.balance;
        System.out.println(result);
        return result;
    }

    // toString method
    public String toString() {
        return Integer.toString(this.data);
    }
}