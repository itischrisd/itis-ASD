package DataStructure;

public class BinarySearchTree {

    TreeNode<Integer> root;

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
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

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
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public void delete(int key) {
        root = deleteNode(root, key);
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    private TreeNode<Integer> deleteNode(TreeNode<Integer> node, int key) {
        if (node == null)
            return null;

        if (key < node.value) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.value) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode<Integer> successor = findSuccessor(node);
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.value);
            }
        }

        return node;
    }

    public int minimum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        TreeNode<Integer> ptr = root;
        while (ptr.left != null)
            ptr = ptr.left;
        return ptr.value;
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public int maximum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        TreeNode<Integer> ptr = root;
        while (ptr.right != null)
            ptr = ptr.right;
        return ptr.value;
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public TreeNode<Integer> findSuccessor(TreeNode<Integer> node) {
        if (node.right != null) {
            TreeNode<Integer> ptr = node.right;
            while (ptr.left != null)
                ptr = ptr.left;
            return ptr;
        } else {
            TreeNode<Integer> parent = node.parent;
            while (parent != null && node == parent.right) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public TreeNode<Integer> findPredecessor(TreeNode<Integer> node) {
        if (node.left != null) {
            TreeNode<Integer> ptr = node.left;
            while (ptr.right != null)
                ptr = ptr.right;
            return ptr;
        } else {
            TreeNode<Integer> parent = node.parent;
            while (parent != null && node == parent.left) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(n)
    A(n) = O(log(n))
    S(n) = O(1)
    */

    private TreeNode<Integer> findNode(int key) {
        TreeNode<Integer> ptr = root;
        while (ptr != null) {
            if (key == ptr.value)
                return ptr;
            if (key < ptr.value)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        return null;
    }

    public void print() {
        printTree(root, "", false);
    }

    private void printTree(TreeNode<Integer> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
