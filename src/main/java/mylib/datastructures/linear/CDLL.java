package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;


public class CDLL extends DLL{
    private DNode head;
    private DNode tail;
    public int size;

    public CDLL(){
      
        super();
    }

    public CDLL(DNode head){
        this.head = head;
        tail = null;
        size = 1;
        DNode current = head;
        if(current.getNext() != null) {
            while (current.getNext().getData() != head.getData()) {
                current = current.getNext();
                size++;
            }
        }
        current.setNext(this.head);
        tail = current;
    }

    @Override
    public void InsertHead(DNode node){
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
            head.setPrev(head);
        }else{
            node.setNext(head);
            tail.setNext(node);
            node.setPrev(tail);
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
            head.setPrev(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void Insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 1) {
            InsertHead(node);
        } else if (position == size + 1) {
            InsertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.getNext().setPrev(node);
            node.setPrev(current);
            current.setNext(node);
            size++;
        }
    }

    @Override
    public void SortedInsert(DNode node){
        
       
        if(head == null){
            head = node;
            tail = node;
            head.setNext(head);
        } else {
            if(!isSorted()){
                Sort();
            }
            DNode current = head;
            while(current.getNext() != head && current.getNext().getData() <= node.getData()){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            if(current == tail){
                tail = node;
            }
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
            head.getNext().setPrev(tail);
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
            head.setPrev(tail);
            size--;
        }
    }

    @Override
    public boolean isSorted(){
        if (head == null) {
            return true;
        } else {
            DNode current = head;
            while (current.getNext() != head) {
                if (current.getData() > current.getNext().getData()) {
                    return false;
                }
                current = current.getNext();
            }
            return true;
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
            System.out.println();
        }

        System.out.println("length: " + size);

        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }

    }

    @Override
    public void Clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
    	CDLL list = new CDLL();

        // Testing insertHead
        list.InsertHead(new DNode(11));
        System.out.println("\nTesting InsertHead: ");
        list.Print(); // Should print "List content: 11"

        // Testing insertTail
        list.InsertTail(new DNode(22));
        System.out.println("\nTesting InsertTail: ");
        list.Print(); // Should print "List content: 11 -> 22"

        // Testing insert
        list.Insert(new DNode(16), 1);
        System.out.println("\nTesting Insertion position 1: ");
        
        list.Print();

        // Testing Search
        DNode node = list.Search(new DNode(16));
        System.out.println("\nSearching 16: ");
        System.out.println(node.getData()); // Should print "16"

        // Testing deleteHead
        list.DeleteHead();
        System.out.println("\nDeleting Head: ");
        list.Print();

        // Testing deleteTail
        list.DeleteTail();
        System.out.println("\nDeleting Tail: ");
        list.Print(); 

        // Testing isSorted and Sort
        list.InsertHead(new DNode(33));
        System.out.println("\nDel: ");
        list.Print(); // Should print "List content: 33 -> 11"

        list.Delete(new DNode(11));
        System.out.println("\nDeleting Head: ");
        list.Print();

        //System.out.println("" + list.isSorted()); // Should print "false"
        list.Sort();
        System.out.println("\nTesting Sort: ");
        list.Print(); // Should print "List content: 11 -> 33"
        //System.out.println(list.isSorted()); // Should print "true"

        // Testing Clear
        list.Clear();
        System.out.println("\nClearing everything: ");

        list.Print(); // Should print "List content: empty"

        
    }
}