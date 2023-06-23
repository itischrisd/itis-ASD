package org.s25692.asd;

import Container.Node;

import java.util.EmptyStackException;

public class StackList<T> {
    Node<T> top;

    void push(T val) {
        Node<T> newTop = new Node<>(val);
        newTop.next = top;
        top = newTop;
    }

    T top() {
        if (top == null)
            throw new EmptyStackException();
        return top.value;
    }

    T pop() {
        if (top == null)
            throw new EmptyStackException();
        Node<T> toRet = top;
        top = top.next;
        return toRet.value;
    }
}