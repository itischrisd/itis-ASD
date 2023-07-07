package DataStructure;

public class BinarySearchTree {

    private TreeNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    public int search(int key) {
        TreeNode<Integer> ptr = root;
        while (ptr != null) {
            if (key == ptr.value)
                return ptr.value;
            if (key < ptr.value)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        throw new IllegalArgumentException("Key not found.");
    }

    public void insert(int key) {
        TreeNode<Integer> newNode = new TreeNode<>();
        newNode.value = key;

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode<Integer> ptr = root;
        TreeNode<Integer> parent = null;
        while (ptr != null) {
            parent = ptr;
            if (key < ptr.value)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }

        if (key < parent.value)
            parent.left = newNode;
        else
            parent.right = newNode;
        newNode.parent = parent;
    }

    public void delete(int key) {
        TreeNode<Integer> ptr = root;
        TreeNode<Integer> parent = null;
        while (ptr != null) {
            if (key == ptr.value)
                break;
            parent = ptr;
            if (key < ptr.value)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }

        if (ptr == null)
            throw new IllegalArgumentException("Key not found.");

        if (ptr.left == null && ptr.right == null) {
            // Node to be deleted has no children
            if (parent == null) {
                // Deleting root node
                root = null;
            } else if (ptr == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (ptr.left != null && ptr.right == null) {
            // Node to be deleted has only left child
            if (parent == null) {
                // Deleting root node
                root = ptr.left;
            } else if (ptr == parent.left) {
                parent.left = ptr.left;
            } else {
                parent.right = ptr.left;
            }
        } else if (ptr.left == null && ptr.right != null) {
            // Node to be deleted has only right child
            if (parent == null) {
                // Deleting root node
                root = ptr.right;
            } else if (ptr == parent.left) {
                parent.left = ptr.right;
            } else {
                parent.right = ptr.right;
            }
        }
    }

    public int minimum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        TreeNode<Integer> ptr = root;
        while (ptr.left != null)
            ptr = ptr.left;
        return ptr.value;
    }

    public int maximum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        TreeNode<Integer> ptr = root;
        while (ptr.right != null)
            ptr = ptr.right;
        return ptr.value;
    }
}
