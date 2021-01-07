public class MyLinkedList {
    private int size;
    private Node start, end;

    public MyLinkedList() {
    }

    public int size(){
        return size;
    }



    public boolean add(String value){
        Node oldEnd = end;

        end.setPrev(oldEnd);
        end.setData(value);

        oldEnd.setNext(end);
        size++;
        return true;
    }

    public void add(int index, String value){
        Node addNode = new Node(value);

        if(index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==size){
            add(value);
        }
        else{
            Node current = start;
            for(int i = 0; i < index;i++){
                current = current.getNext();
            }
            
            current.getPrev().setNext(addNode);
            addNode.setPrev(current.getPrev());
            addNode.setNext(current);
            current.setPrev(addNode);
            
        }
    }

    public String get(int index);

    public String set(int index, String value);

    public String toString();
    // Any helper method that returns a Node object MUST BE PRIVATE!
}
