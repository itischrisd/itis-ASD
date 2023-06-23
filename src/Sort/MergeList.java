package Sort;

import Container.Node;

public class MergeList {

    public static Node<Integer> sort(Node<Integer> list) {
        if (list == null || list.next == null)
            return list;

        Node<Integer> left, right;
        left = list;
        Node<Integer> slow = list;
        Node<Integer> fast = list.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        right = slow.next;
        slow.next = null;

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node<Integer> merged;
        if (left.value <= right.value) {
            merged = left;
            merged.next = merge(left.next, right);
        } else {
            merged = right;
            merged.next = merge(left, right.next);
        }
        return merged;
    }

    public static void printList(Node<Integer> list) {
        Node<Integer> current = list;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
