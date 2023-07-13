package DataStructure;

public class AVLTree {

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public void delete(int key) {
        root = deleteNode(root, key);
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public boolean search(int key) {
        return searchNode(root, key);
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public int minimum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        AVLNode ptr = root;
        while (ptr.left != null)
            ptr = ptr.left;
        return ptr.value;
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    public int maximum() {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty.");
        AVLNode ptr = root;
        while (ptr.right != null)
            ptr = ptr.right;
        return ptr.value;
    }
    /*
    O.D.: porównanie wartości
    R.D.: ilość węzłów w drzewie
    W(n) = O(log(n))
    A(n) = O(log(n))
    S(n) = O(1)
    */

    private AVLNode insertNode(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.value) {
            node.left = insertNode(node.left, key);
        } else if (key > node.value) {
            node.right = insertNode(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.value) {
            return rotateRight(node);
        }

        if (balance < -1 && key > node.right.value) {
            return rotateLeft(node);
        }

        if (balance > 1 && key > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode deleteNode(AVLNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.value) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.value) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                return (node.left != null) ? node.left : node.right;
            } else {
                AVLNode successor = findSuccessor(node);
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.value);
            }
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private boolean searchNode(AVLNode node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.value) {
            return true;
        } else if (key < node.value) {
            return searchNode(node.left, key);
        } else {
            return searchNode(node.right, key);
        }
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode leftChild = node.left;
        AVLNode leftRightChild = leftChild.right;

        leftChild.right = node;
        node.left = leftRightChild;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        leftChild.height = 1 + Math.max(getHeight(leftChild.left), getHeight(leftChild.right));

        return leftChild;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rightChild = node.right;
        AVLNode rightLeftChild = rightChild.left;

        rightChild.left = node;
        node.right = rightLeftChild;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        rightChild.height = 1 + Math.max(getHeight(rightChild.left), getHeight(rightChild.right));

        return rightChild;
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode findSuccessor(AVLNode node) {
        if (node.right != null) {
            AVLNode ptr = node.right;
            while (ptr.left != null) {
                ptr = ptr.left;
            }
            return ptr;
        } else {
            AVLNode parent = node.parent;
            while (parent != null && node == parent.right) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public void print() {
        printTree(root, "", false);
    }

    private void printTree(AVLNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
