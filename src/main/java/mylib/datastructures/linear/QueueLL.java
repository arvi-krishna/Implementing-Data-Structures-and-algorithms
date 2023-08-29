//package main.java.mylib.datastuctures.linear;

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class QueueLL extends SLL {

    public QueueLL(){
        super();
    }

    public QueueLL(DNode head){
        super(head);
    }

    @Override
    public void InsertHead(DNode node){
        super.InsertHead(node);
    }

    

    @Override
    public void Insert(DNode node, int position){
        //System.out.print(size);
        if (position == size+1) {
            super.InsertTail(node);
            return;
        }
        else{
            super.Insert(node, position);
        }
    }

    @Override
    public void DeleteTail(){
        super.DeleteTail();
    }

    @Override
    public void DeleteHead(){
        super.DeleteHead();
    }

    @Override
    public void Delete(DNode node){
        if (node == null) {
            return;
        }
        super.Delete(node);
    }

    @Override
    public void SortedInsert(DNode node){
        if (node == null) {
            return;
        }
        super.SortedInsert(node);
    }

    @Override
    public void Sort(){
        super.Sort();
    }

    public void enqueue(DNode node){
        super.InsertTail(node);
    }

    public DNode dequeue(){
        DNode node = super.getHead();
        super.DeleteHead();
        return node;
    }

    public DNode peek(){
        return super.getHead();
    }

    public int search(DNode node) {
        DNode current = super.getHead();
        int position = 0;
        while (current != null) {
            position++;
            if (current.getData() == node.getData()) {
                return position;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void Print() {
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
        System.out.println("length: " + size);

        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }
    }

    public static void main(String[] args) {
        // Create a new empty queue
        QueueLL queue = new QueueLL();
    
        // Enqueue some nodes
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(5));
        queue.enqueue(new DNode(4));
        queue.enqueue(new DNode(3));
        queue.enqueue(new DNode(2));
        System.out.print("Current List: ");
        queue.Print();
        

        
        // Peek the head of the queue without dequeuing
        System.out.println("Peek: " + queue.peek().getData());
    
        // Dequeue some nodes
        DNode node1 = queue.dequeue();
        DNode node2 = queue.dequeue();
        DNode node3 = queue.dequeue();
        DNode node4 = queue.dequeue();
    
        // Print the dequeued nodes
        System.out.println("Dequeued nodes: " + node1.getData() + ", " + node2.getData() + ", " + node3.getData() + ", " + node4.getData());
    
        // Enqueue some more nodes
        queue.enqueue(new DNode(5));
        queue.enqueue(new DNode(6));
        System.out.print("Enqueued nodes: ");
        DNode current = queue.getHead();
        current = current.getNext();
        while (current != null) {
            
            System.out.print(current.getData() + " ");
            current = current.getNext();
            
        }
        System.out.println();
        System.out.print("Current List:  ");
        queue.Print();
        //System.out.println();

        

        // Search for a node
        DNode searchNode = new DNode(5);
        int position = queue.search(searchNode);
        System.out.print("Found node " + searchNode.getData() + " at position " + position);
        System.out.println();
        System.out.println();
      
    }



}