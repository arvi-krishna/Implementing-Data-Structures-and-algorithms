//package main.java.mylib.datastuctures.linear;

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;


public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public DLL(DNode head) {
        this.head = head;
        tail = null;
        size = 1;
        DNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
            size++;
        }
        tail = current;
    }

    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
           
            node.setNext(head);
            node.getNext().setPrev(node);
            head = node;
        }
        size++;
    }

    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    public void Insert(DNode node, int position) {
        if (node == null) {
            return;
        }
        System.out.println(size);

        if (position > size+2) {
            System.out.println("Position out of bounds");
            return;
            
        }
        if (position == 1) {
           
            InsertHead(node);
            return;
        }
        if (position == (size + 1)) {
          
            InsertTail(node);
            return;
        }
        DNode current = this.head;
        for (int i = 2; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        node.setNext(current.getNext());
        current.getNext().setPrev(node);
        current.setNext(node);
        node.setPrev(current);
        size++;
    }

    public void SortedInsert(DNode node) {
        if (head == null) {
            InsertHead(node);
            tail = head;
        } else {
            if (!isSorted()) {
                Sort();
            }
            boolean inserted = false;
            DNode current = head;
            DNode prev = null;

            while (current != null && !inserted) {
                if (node.getData() <= current.getData()) {
                    if (prev == null) {
                        InsertHead(node);
                    } else {
                        prev.setNext(node);
                        node.setPrev(prev);
                        node.setNext(current);
                        current.setPrev(node);
                    }
                    inserted = true;
                } else {
                    prev = current;
                    current = current.getNext();
                }
            }
            if (!inserted) {
                InsertTail(node);
            }
        }
    }

    public DNode Search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void DeleteHead() {
        if (head == null) {
            return;
        }
        head.getNext().setPrev(null);
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void DeleteTail() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            DNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(null);
        }
        size--;
    }

    public void Delete(DNode node) {
        if (head == null) {
            return; 
        }
        if (head.getData() == node.getData()) {
            head.getNext().setPrev(null);
            head = head.getNext();
            size--;
            if (head == null) {
                tail = null;
            }
            return;
        }
        DNode current = head.getNext();
        DNode prev = head;

        while (current != null) {
            if (current.getData() == node.getData()) {
                prev.setNext(current.getNext());
                current.getNext().setPrev(prev);
                size--;
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            
            return true;
        }

        DNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
               
                return false;
            }
            current = current.getNext();
        }

       
        return true;
    }

    public void Sort() {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }
        DNode current = this.head.getNext();
        while(current != null) {
           
            DNode next = current.getNext();
         
            while(current.getPrev() != null && current.getPrev().getData() > current.getData()){
             
                swapNodes(current.getPrev(), current);
            }
            current = next;
        }
        
    }

    private void swapNodes(DNode node1, DNode node2) {
        DNode tempPrev = node1.getPrev();
        DNode tempNext = node2.getNext();

        if (tempPrev != null) {
            tempPrev.setNext(node2);
        } else {
            head = node2;
        }

        if (tempNext != null) {
            tempNext.setPrev(node1);
        } else {
            tail = node1;
        }

        node1.setNext(tempNext);
        node2.setPrev(tempPrev);

        node2.setNext(node1);
        node1.setPrev(node2);
    }

    public void Clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Print() {
        

        if (head == null) {
            System.out.println("empty");
        } else {
            DNode current = head;
            System.out.print(current.getData());
            current = current.getNext();
            while (current != null) {
                System.out.print(" " + current.getData());
                current = current.getNext();
            }
            System.out.println();
        }
        System.out.println("length: " + size);

        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }
    }

    public static void main(String[] args) {


        DLL contents = new DLL();

        System.out.println("\nDLL Tests:\n");

        // Insert some nodes at the head of the list
        contents.InsertHead(new DNode(2));
        contents.InsertHead(new DNode(4));
        contents.InsertHead(new DNode(6));
        
        System.out.print("\nInserthead of the list: ");
        contents.Print();
        
        // Insert some nodes at the tail of the list
        contents.InsertTail(new DNode(3));
        contents.InsertTail(new DNode(1));
        contents.InsertTail(new DNode(5));
        
        System.out.print("\nInsertTail of the list: ");
        contents.Print();
        
        
        contents.Insert(new DNode(9), 5);
        
        // Print the contents of the list
        System.out.print("\nCurrent list: ");
        
        contents.Print();

        // Delete the head node
        contents.DeleteHead();
        
        // Delete the tail node
        contents.DeleteTail();
        System.out.print("\nHead and tail gone: ");
        contents.Print();
        
        contents.Delete(new DNode(3));
        System.out.print("\ndeleting 15: ");
        contents.Print();
        contents.Sort();
        
        // Print the contents of the modified list
        System.out.print("\nModified list: ");
        contents.Print();
        
        // Sort the list Print the sorted list
        contents.Sort();
        System.out.print("\nSorted list: ");
        contents.Print();
        
        contents.SortedInsert(new DNode(1));
        System.out.print("\nAfter Sorted Insert: ");
        contents.Print();
        // Clear the list
        contents.Clear();
        
        // Print the contents of the empty list
        System.out.print("\nCleared list: ");
        contents.Print();
    }
}
    