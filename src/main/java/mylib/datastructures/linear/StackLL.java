
package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;


public class StackLL extends SLL{

    public StackLL(){
        super();
    }

    public StackLL(DNode head){
        super(head);
    }

    @Override
    public void InsertTail(DNode node){
        super.InsertTail(node);
    }

    @Override
    public void Insert(DNode node, int position){
        if (position > size+1) {
            InsertTail(node);
            return;
        }
        super.Insert(node, position);
    }

    @Override
    public void SortedInsert(DNode node){
        if (node == null) {
            return;
        }
        super.SortedInsert(node);
    }

    @Override
    public void DeleteTail(){
        super.DeleteTail();
    }

    @Override
    public void Delete(DNode node){
        if (node == null) {
            return;
        }
        super.Delete(node);
    }

    @Override
    public void Sort(){
        super.Sort();
    }

    public void push(DNode node){
        super.InsertHead(node);
    }

    public DNode pop(){
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

        System.out.println("\nlength: " + size);

        if (isSorted()) {
            System.out.println("Sorted: Yes");
        } else {
            System.out.println("Sorted: No");
        }
    }

    public static void main(String[] args) {
        
      
        StackLL contents = new StackLL();

        contents.push(new DNode(5));
        contents.push(new DNode(4));
        contents.push(new DNode(3));
        contents.push(new DNode(2));
        contents.push(new DNode(1));

        System.out.print("\ncontents: ");
        contents.Print();

     
        DNode poppedNode = contents.pop();

     
        System.out.println("\nPopped Node: " + poppedNode.getData());
        
        System.out.print("\nUpdated contents: ");
        contents.Print();

        DNode peekedNode = contents.peek();

      
        System.out.println("\nPeeked Node: " + peekedNode.getData());
        System.out.print("\ncontents: ");
        contents.Print();

       
        DNode nodeToSearch = new DNode(2);
        int position = contents.search(nodeToSearch);

        if (position != -1) {
            System.out.print("\nNode 2 found at position: " + position);
        } else {
            System.out.print("\nNode not found in the contents ");
        }
       
    }

}