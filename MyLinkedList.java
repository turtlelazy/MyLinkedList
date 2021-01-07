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

        return true;
    }

    public void add(int index, String value);

    public String get(int index);

    public String set(int index, String value);

    public String toString();
    // Any helper method that returns a Node object MUST BE PRIVATE!
}
