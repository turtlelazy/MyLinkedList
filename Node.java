public class Node {
    private String data;
    private Node next, prev;
    public Node(String value) {
        data = value;
    }

    public Node(Node copyNode){
        this.data = copyNode.data;
        this.next = copyNode.next;
        this.prev = copyNode.prev;
    }
    
    public Node getNext(){
        return next;
    }

    public Node getPrev(){
        return prev;
    }

    public String getData(){
        return data;
    }

    public Node setNext(Node next){
        Node old = this.next;
        this.next = next;
        return old;
    }

    public Node setPrev(Node prev) {
        Node old = this.prev;
        this.prev = prev;
        return old;
    }

    public String setData(String data){
        String old = this.data;
        this.data = data;
        return old;
    }

}