package DataStructure;

public class TreeNode<T> {
    public Node<T> parent = null;
    public Node<T> left = null;
    public Node<T> right = null;
    public T value;

    public TreeNode(T elem) {
        this.value = elem;
    }
}
