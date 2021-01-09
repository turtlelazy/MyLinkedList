public class MyLinkedList {
    private int size = 0;
    private Node start, end;

    public MyLinkedList() {
    }

    public int size(){
        return size;
    }



    public boolean add(String value){
        if(size==0){
            Node addedNode = new Node(value);
            start = addedNode;
            end = addedNode;
        }

        else{
            Node addedNode = new Node(value);
            end.setNext(addedNode);
            addedNode.setPrev(end);

            end = addedNode;

            /*
            Node oldEnd = end;
            oldEnd.setPrev(end.getPrev());
            if(size!=1){
                end.getPrev().setNext(oldEnd);
            }

            end = new Node(value);
            end.setPrev(oldEnd);
            oldEnd.setNext(end);
            */
        }

        size++;
        return true;
    }

    public void add(int index, String value){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        else if(index==size){
            add(value);
        }
        else if(index == 0){
            Node newNode = new Node(value);
            newNode.setNext(start);
            start.setPrev(newNode);

            start = newNode;
            size++;

        }
        else{
            Node current = getNodeForwards(index);
            Node newNode = new Node(value);

            newNode.setPrev(current.getPrev());
            newNode.getPrev().setNext(newNode);

            current.setPrev(newNode);
            newNode.setNext(current);

            size++;
            
        }
    }

    public String get(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node current = start;
        for(int i = 0;i<index;i++){
            current = current.getNext();
        }

        return current.getData();
    }

    public String set(int index, String value){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for(int i = 0; i < index;i++){
            current = current.getNext();
        }

        String oldData = current.getData();
        current.setData(value);
        return oldData;
    }

    public String toString(){
        Node current = start;
        String toString = "";

        while(current!= null){
            toString += current.getData();
            current = current.getNext();
            if(current!=null){
                toString+=", ";
            }
        }
        return "[" + toString + "]";
    }

    public String toStringReversed(){
        Node current = end;
        String toString = "";

        while (current != null) {
            toString += current.getData();
            current = current.getPrev();
            if (current != null) {
                toString += ", ";
            }
        }
        return "[" + toString + "]";
    }

    public String remove(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node toRemove = getNodeForwards(index);

        if (size == 1) {
            start = null;
            end = null;

        }

        else if (index == 0) {
            start = toRemove.getNext();
            start.setPrev(null);
        }
        
        else if(index == size-1) {
            end = toRemove.getPrev();
            end.setNext(null);
        }

        else {
            toRemove.getPrev().setNext(toRemove.getNext());
            toRemove.getNext().setPrev(toRemove.getPrev());
        }

        size --;
        return toRemove.getData();
    }

    private Node getNodeForwards(int index){
        Node current = start;
        for(int i = 0; i < index; i ++){
            current = current.getNext();
        }

        return current;
    }

    public void extend(MyLinkedList other){
        this.end.setNext(other.start);
        other.start.setPrev(this.end);

        this.end = other.end;
        other.start = null;
    }
}
