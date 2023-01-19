
public class List {

    Node head;
    Node tail;

    /*
    // Для односвязного списка

    public void revert(){
        if (head != null && head.next != null){
            Node temp = head;
            revertPrivate(head.next,head);
            temp.next = null;
        }
    }

    private  void  revertPrivate(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        }else {
            revertPrivate(currentNode.next,currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
    */

    public  void printList(){ // O(n)
        Node currentNode = head;
        while (currentNode != null){
            System.out.printf(currentNode.value + ", ");
        }
    }

    public  void revert(){ // O(n)
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(previous == null){
                tail = currentNode;
            }
            if(next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public void add(int value){ // O(1)
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node){ // O(1)
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public static void main(String[] args) {
        List node;
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        node.printList();
        node.revert();
        node.printList();

    }

}