package DataStructure;

public class StackArray<T> {

    int top = -1;
    T[] arr;

    void push(T val) {
        if (top == arr.length - 1)
            throw new ArrayIndexOutOfBoundsException();
        arr[++top] = val;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T top() {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return arr[top];
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T pop() {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return arr[top--];
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */
}
