package DataStructure;

public class AVLNode {

    int value;
    int height;
    AVLNode parent;
    AVLNode left;
    AVLNode right;

    AVLNode(int value) {
        this.value = value;
        height = 1;
        left = null;
        right = null;
    }
}
