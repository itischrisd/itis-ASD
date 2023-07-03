package DataStructure;

public class QueueList<T> {

    Node<T> front;
    Node<T> tail;

    void inject(T val) {
        if (front == null)
            front = new Node<>(val);
        Node<T> curr = front;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new Node<>(val);
    }

    T front() throws Exception {
        if (front == null)
            throw new Exception("List is empty!");
        return front.value;
    }

    T out() throws Exception {
        if (front == null)
            throw new Exception("List is empty!");
        T to_ret = front.value;
        front = front.next;
        return to_ret;
    }
}
