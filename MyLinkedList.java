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
            start = new Node(value);
            start.setNext(end);
        }
        else if (size == 1) {
            end = new Node(value);
            end.setData(value);
            end.setPrev(start);
        }
        else{
            Node oldEnd = new Node(end.getData());
            end.getPrev().setNext(oldEnd);

            end.setPrev(oldEnd);
            end.setData(value);
            end.getPrev().setNext(end);
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
        else if(size == 1 && index == 0){
            String oldStartData = start.getData();
            start.setData(value);

            end = new Node(oldStartData);
            end.setPrev(start);
            size++;

        }
        else{
            Node current = start;
            for(int i = 0; i < index;i++){
                current = current.getNext();
            }
            Node copyCurrent = new Node(current);

            current.setData(value);
            current.setPrev(copyCurrent.getPrev());
            current.setNext(copyCurrent);
            
            copyCurrent.setPrev(current);
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

}
