package Container;

public class Node<T> {

    public Node<T> next = null;
    public T value;

    public Node(T elem) {
        this.value = elem;
    }
}
