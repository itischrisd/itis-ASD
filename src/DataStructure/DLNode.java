package DataStructure;

public class DLNode<T> {

    public DLNode<T> next = null;
    public DLNode<T> prev = null;
    public T value;

    public DLNode(T elem) {
        this.value = elem;
    }
}
