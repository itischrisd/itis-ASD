package DataStructure;

public class StackArray<T> {

    int top = -1;
    T[] arr;

    void push(T val) {
        if (top == arr.length - 1)
            throw new ArrayIndexOutOfBoundsException();
        arr[++top] = val;
    }

    T top() {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return arr[top];
    }

    T pop() {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return arr[top--];
    }
}
