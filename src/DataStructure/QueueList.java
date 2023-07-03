package DataStructure;

public class QueueList<T> {

    Node<T> front;
    Node<T> tail;

    void inject(T val) {
        if (front == null) {
            front = new Node<>(val);
            tail = front;
        } else {
            tail.next = new Node<>(val);
            tail = tail.next;
        }
    }

    T front() {
        if (front == null)
            throw new RuntimeException("Queue is empty!");
        return front.value;
    }

    T out() {
        if (front == null)
            throw new RuntimeException("Queue is empty!");
        T to_ret = front.value;
        front = front.next;
        return to_ret;
    }
}
