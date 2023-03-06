package Classes;

class MyListNode<T> {

    protected MyListNode(MyListNode<T> next, MyListNode<T> prev, T value) {
        Next = next;
        Prev = prev;
        Value = value;
    }

    private MyListNode<T> Next;
    private MyListNode<T> Prev;
    private T Value;

    public MyListNode<T> getNext() {
        return Next;
    }

    public void setNext(MyListNode<T> next) {
        Next = next;
    }

    public MyListNode<T> getPrev() {
        return Prev;
    }

    public void setPrev(MyListNode<T> prev) {
        Prev = prev;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }
}
