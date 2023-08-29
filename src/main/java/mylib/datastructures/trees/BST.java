package mylib.datastructures.trees;

import java.util.*;
import mylib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        TNode node = new TNode();
        node.setData(val);
        this.root = node;
    }

    public BST (TNode obj) {
        this.root = obj;
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public void insert(TNode node){
        if (this.root == null) {
            this.root = node;
        } else {
            TNode current = this.root;
            TNode parent = null;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        return;
                    }
                }
            }
        }
    }

    public void insert(int val) {
        TNode node = new TNode();
        node.setData(val);
        insert(node);
    }

    public void delete(int val) {
        TNode parent = null;
        TNode current = this.root;
        boolean isLeftChild = false;
    
        while (current != null && current.getData() != val) {
            parent = current;
            if (val < current.getData()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }
    
        if (current == null) {
            System.out.println("Value not found in the tree.");
            return;
        }
    
        // Case 1: The node to be deleted has no children.
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // Case 2: The node to be deleted has one child.
        else if (current.getRight() == null) {
            if (current == this.root) {
                this.root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == this.root) {
                this.root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        // Case 3: The node to be deleted has two children.
        else {
            TNode successor = getSuccessor(current);
    
            if (current == this.root) {
                this.root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
    
            successor.setLeft(current.getLeft());
        }
    }
    
    private TNode getSuccessor(TNode deleteNode) {
        TNode successor = null;
        TNode successorParent = null;
        TNode current = deleteNode.getRight();
    
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
    
        if (successor != deleteNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
    
        return successor;
    }

    public TNode search(int val){
        TNode current = this.root;
        while (current != null) {
            if (current.getData() == val) {
                return current;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public void printInOrder() {
        printInOrder(this.root);
    }
    
    private void printInOrder(TNode node) {
        if (node == null) {
            return;
        }
    
        printInOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInOrder(node.getRight());
    }
    
    public void printBF() {
        if (this.root == null) {
            return;
        }
    
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(this.root);
    
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
    
            for (int i = 0; i < levelSize; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
    
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
    
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();
        
        // insert some nodes
        bst.insert(40);
        bst.insert(30);
        bst.insert(70);
        bst.insert(50);
        bst.insert(80);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(90);
        bst.insert(100);
        
        // print the tree in order
        System.out.println("In order:");
        bst.printInOrder();
        
        // print the tree in breadth-first order
        System.out.println("\nBreadth-first:");
        bst.printBF();
        
        // search for a node
        TNode node = bst.search(50);
        System.out.println("\nSearched for 50, found " + node.getData());
        
        // delete a node
        bst.delete(70);
        System.out.println("\nDeleted 70:");
        bst.printBF();
    }

    
    
}