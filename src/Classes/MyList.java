package Classes;

public class MyList<T> {
    MyListNode<T> First;

    private int Count = 0;

    public void AddBefore(T element, int index) throws Exception {
        if (index < Count && index >= 0) {
            int outIndex = 0;
            MyListNode<T> helper = First;
            while (outIndex != index) {
                outIndex++;
                helper = helper.getNext();
            }
            MyListNode<T> tmp = new MyListNode<>(helper, helper.getPrev(), element);
            helper.getPrev().setNext(tmp);
            helper.setPrev(tmp);
            Count++;
        }
        else {
            throw new Exception("index out of range");
        }
    }

    public void AddBegin(T element) {
        if (First == null) {
            First = new MyListNode<>(null, null, element);
        }
        else {
            MyListNode<T> helper = First;
            First = new MyListNode<>(helper, null, element);
            helper.setPrev(First);
        }
        Count++;
    }

    public void AddEnd(T element) {
        if (First != null) {
            MyListNode<T> helper = First;
            while (helper.getNext() != null) {
                helper = helper.getNext();
            }
            helper.setNext(new MyListNode<T>(null, helper, element));
        }
        else {
            First = new MyListNode<>(null, null, element);
        }
        Count++;
    }

    public void Clear() {
        First = null;
        Count = 0;
    }

    public T GetByIndex(int index) throws Exception {
        if (index < Count && index >= 0) {
            int outIndex = 0;
            MyListNode<T> helper = First;
            while (outIndex != index) {
                outIndex++;
                helper = helper.getNext();
            }
            return helper.getValue();
        }
        else {
            throw new Exception("index out of range");
        }
    }

    public void RemoveByIndex(int index) throws Exception {
        if (index < Count && index >= 0) {
            int outIndex = 0;
            MyListNode<T> helper = First;
            while (outIndex != index) {
                outIndex++;
                helper = helper.getNext();
            }
            MyListNode<T> tmp = helper.getPrev();
            tmp.setNext(helper.getNext());
            helper.getNext().setPrev(tmp);
            helper.setPrev(null);
            helper.setNext(null);
            Count--;
        }
        else {
            throw new Exception("index out of range");
        }
    }

    public void RemoveByValue(T value) throws Exception {
        if (Count > 0) {
            int outIndex = 0;
            MyListNode<T> helper = First;
            while (!helper.getValue().equals(value)) {
                if (helper.getNext() == null) {
                    throw new Exception("The value is not in the list");
                }
                helper = helper.getNext();
            }
            MyListNode<T> tmp = helper.getPrev();
            tmp.setNext(helper.getNext());
            helper.getNext().setPrev(tmp);
            helper.setPrev(null);
            helper.setNext(null);
            Count--;
        }
        else {
            throw new Exception("List empty");
        }
    }

    @Override
    public String toString() {
        if (Count > 1) {
            MyListNode<T> helper = First.getNext();
            String out = "{" + First.getValue() + ", ";
            while (helper.getNext() != null) {
                out += helper.getValue() + ", ";
                helper = helper.getNext();
            }
            out += helper.getValue() + "}";
            return out;
        }
        else if (Count == 1) {
            return "{" + First.getValue() + "}";
        }
        else {
            return "List empty";
        }
    }
}
