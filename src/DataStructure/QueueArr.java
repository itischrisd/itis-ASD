package DataStructure;

public class QueueArr<T> {

    T[] arr;
    int head = -1;
    int tail = -1;

    void inject(T val) {
        if (head == tail + 1)
            throw new RuntimeException();
        tail = (tail + 1) % arr.length;
        arr[tail] = val;
    }

    T front() {
        if (head == -1 || head == tail)
            throw new RuntimeException();
        return arr[head];
    }

    T out() {
        if (head == -1 || head == tail)
            throw new RuntimeException();
        T toRet = arr[head];
        head = (head + 1) % arr.length;
        return toRet;
    }
}
