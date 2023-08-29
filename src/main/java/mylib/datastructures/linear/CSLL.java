//package main.java.mylib.datastuctures.linear;

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;


public class CSLL extends SLL{

    public CSLL(){
        
        super();
    }

    public CSLL(DNode head){
       
        super(head);
        head.setNext(head);
    }

    @Override
    public void InsertHead(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            node.setNext(head);
            tail.setNext(node);
            head = node;
        }
        size++;
    }

    @Override
    public void InsertTail(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        }else{
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }
        size++;
    }

    @Override
    public void Insert(DNode node, int position){
        if(position < 1 || position > size + 1){
            throw new IndexOutOfBoundsException();
        }
        if(position == 1){
            InsertHead(node);
        }else if(position == size + 1){
            InsertTail(node);
        }else{
            DNode current = head;
            for(int i = 1; i < position - 1; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    @Override
    public void SortedInsert(DNode node){
        if (head == null) {
        head = node;
        tail = node;
        head.setNext(head);
    } else {
        if (!isSorted()) {
            Sort();
        }
        DNode current = head;
        while (current.getNext() != head && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        if (current.getNext() == head) { 
            tail = node;
        }
        node.setNext(current.getNext());
        current.setNext(node);
    }
    size++;

    }

    @Override
    public DNode Search(DNode node){
        if(head == null){
            return null;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getData() != node.getData()){
                current = current.getNext();
            }
            if(current.getData() == node.getData()){
                return current;
            }else{
                return null;
            }
        }
    }

    @Override
    public void DeleteHead(){
        if(head == null){
            return;
        }else{
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
    }

    @Override
    public void DeleteTail(){
        if(head == null){
            return;
        }else{
            DNode current = head;
            while(current.getNext() != tail){
                current = current.getNext();
            }
            current.setNext(head);
            tail = current;
            size--;
        }
    }

    

    @Override
    public boolean isSorted(){
        if(head == null){
            return true;
        }else{
            DNode current = head;
            while(current.getNext() != head && current.getData() <= current.getNext().getData()){
                current = current.getNext();
            }
            if(current.getNext() == head){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public void Sort(){
        if(head == null){
            return;
        }else{
            DNode current = head;
            DNode next = null;
            int temp;
            while(current.getNext() != head){
                next = current.getNext();
                while(next != head){
                    if(current.getData() > next.getData()){
                        temp = current.getData();
                        current.setData(next.getData());
                        next.setData(temp);
                    }
                    next = next.getNext();
                }
                current = current.getNext();
            }
        }

    }

    @Override
    public void Print() {
        

            if (head == null) {
                System.out.println("empty");
            } else {
                DNode current = head;
                System.out.print(current.getData());
                current = current.getNext();
                while (current.getData() != head.getData()) {
                    System.out.print(" " + current.getData());
                    current = current.getNext();
                    
                }

                System.out.println("\nlength: " + size);

                if (isSorted()) {
                    System.out.println("Sorted: Yes");
                } else {
                    System.out.println("Sorted: No");
                }

            }
    }

    @Override
    public void Clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        CSLL list = new CSLL();

        // Testing insertHead
        list.InsertHead(new DNode(11));
        list.InsertHead(new DNode(12));
        System.out.print("\nTesting InsertHead: ");
        list.Print(); // Should print "List content: 11"

        // Testing insertTail
        list.InsertTail(new DNode(22));
        System.out.print("\nTesting InsertTail: ");
        list.Print(); // Should print "List content: 11 -> 22"

        // Testing insert
        list.Insert(new DNode(16), 1);
        System.out.print("\nTesting Insertion position 1: ");
        
        list.Print(); 

        
        // Testing Search
        DNode node = list.Search(new DNode(16));
        System.out.print("\nSearching 16: ");
        System.out.print(node.getData()); // Should print "16"

        // Testing deleteHead
        list.DeleteHead();
        System.out.print("\nDeleting Head: ");
        list.Print(); 

        // Testing deleteTail
        list.DeleteTail();
        System.out.print("\nDeleting Tail: ");
        list.Print(); 

        list.Delete(new DNode(11));
        System.out.print("\nDeleting 11: ");
        list.Print(); 

        
        // Testing isSorted and Sort
        list.InsertHead(new DNode(33));
        System.out.print("\nInserting 33 in head: ");
        list.Print(); 
        list.Sort();
        System.out.print("\nTesting Sort: ");
        list.Print(); 

        // Testing Clear
        list.Clear();
        System.out.print("\nClearing everything: ");

        list.Print(); // Should print "List content: empty"
    }
}