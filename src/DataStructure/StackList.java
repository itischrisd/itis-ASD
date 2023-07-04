package DataStructure;

import java.util.EmptyStackException;

public class StackList<T> {

    Node<T> top;

    void push(T val) {
        Node<T> newTop = new Node<>(val);
        newTop.next = top;
        top = newTop;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T top() {
        if (top == null)
            throw new EmptyStackException();
        return top.value;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T pop() {
        if (top == null)
            throw new EmptyStackException();
        Node<T> toRet = top;
        top = top.next;
        return toRet.value;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */
}