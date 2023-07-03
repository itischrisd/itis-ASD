package DataStructure;

public class TreeNode<T> {
    public TreeNode<T> parent = null;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;
    public T value;

    public TreeNode(T elem) {
        this.value = elem;
    }
}
