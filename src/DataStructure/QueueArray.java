package DataStructure;

public class QueueArray<T> {

    T[] arr;
    int head = -1;
    int tail = -1;

    void inject(T val) {
        if (head == tail + 1)
            throw new RuntimeException("Queue is full!");
        tail = (tail + 1) % arr.length;
        arr[tail] = val;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T front() {
        if (head == -1 || head == tail)
            throw new RuntimeException("Queue is empty!");
        return arr[head];
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T out() {
        if (head == -1 || head == tail)
            throw new RuntimeException("Queue is empty!");
        T toRet = arr[head];
        head = (head + 1) % arr.length;
        return toRet;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */
}
