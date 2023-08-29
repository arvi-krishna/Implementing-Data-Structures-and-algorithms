//package main.java.mylib.datastuctures.linear;

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class SLL {

    protected DNode head;
    protected DNode tail;
    public int size;
    protected boolean sorted;

    public SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(DNode head) {
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
            //tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
        sorted = false;
    }

    public void InsertTail(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
        sorted = false;
    }

    public void Insert(DNode node, int position) {
        if (position > size+3) {
            System.out.println("Position out of bounds");
            return;
            // position out of list bounds
        }
        if (position == 1) {
            // essentially setting a new head
            InsertHead(node);
            return;
        }
        if (position == (size + 2)) {
            // essentially setting a new tail
            //System.out.println(size+"this is size");
            InsertTail(node);
            return;
        }
        
        DNode current = this.head;
        for (int i = 2; i < position; i++) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;


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
        head = head.next;
        size--;
    }

    public void DeleteTail() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            DNode current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void Delete(DNode node) {
        if (head == null) {
            return; // list is empty, nothing to delete
        }
        if (head.getData() == node.getData()) {
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
            // empty or single-node list is considered sorted
            return true;
        }

        DNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                // found unsorted pair
                return false;
            }
            current = current.getNext();
        }

        // entire list is sorted
        return true;
    }

   
    public void Sort() {
        
        if (head == null) {
            return;
        }
        DNode newHead = null;
        DNode current = head;
        while (current != null) {
            DNode next = current.getNext();
            if (newHead == null || current.getData() < newHead.getData()) {
                current.setNext(newHead);
                newHead = current;
            } else {
                DNode temp = newHead;
                while (temp.getNext() != null && current.getData() > temp.getNext().getData()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }
        head = newHead;
        DNode tail = newHead;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        this.tail = tail;
        size = 0;
        current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        
        
    }
    public void SortedInsert(DNode node) {
 
        if (!isSorted()){
            Sort();
        }
        if (head == null || node.data < head.data) {
            InsertHead(node);
            return;
        }
        if (node.data >= tail.data) {
            InsertTail(node);
            return;
        }
        DNode current = head;
        while (current.next != null && current.next.data < node.data) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        
        
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

    public DNode getHead() {
        return head;
    }


    public DNode getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

  
    public static void main(String[] args) {


        SLL contents = new SLL();
        

        contents.InsertTail(new DNode(1));
        contents.InsertHead(new DNode(2));
        contents.Insert(new DNode(3), 2);
        contents.Insert(new DNode(4), 3);
        contents.InsertHead(new DNode(9));

        System.out.print("List before sorting: ");
        contents.Print();


        DNode searchResult = contents.Search(new DNode(1));
        System.out.print("\nSearch result: ");
        System.out.println(searchResult != null ? searchResult.getData() : "Node not found");

        contents.Delete(new DNode(2));
        System.out.print("Deleted list after deleting node 1: ");
        contents.Print();
        contents.SortedInsert(new DNode(2));
        System.out.print("\nsortinsert() for 2: ");
        contents.Print();

        
        

        // Sort the list
        contents.Sort();
        System.out.print("\nSorted List: ");
        contents.Print();

        // Delete the head and tail of the list
        contents.DeleteHead();
        contents.DeleteTail();
        System.out.print("\nDeleted List after deleting head and tail: ");
        contents.Print();

        // Add a node at pos 1
        contents.Insert(new DNode(5), 2);
        System.out.print("\nAdded List after adding node 5 at pos 2: ");
        contents.Print();

        // Get the size of the list
        System.out.print("\nSize of the list:  " +contents.size);

        // Clearing the list
        contents.Clear();
        System.out.print("\nCleared List after everything: ");
        contents.Print();
    }

    

}