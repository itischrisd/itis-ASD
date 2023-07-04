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
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T front() {
        if (front == null)
            throw new RuntimeException("Queue is empty!");
        return front.value;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    T out() {
        if (front == null)
            throw new RuntimeException("Queue is empty!");
        T to_ret = front.value;
        front = front.next;
        return to_ret;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    void reverse() {
        Node<T> prev = null;
        Node<T> curr = front;
        Node<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = front;
        front = prev;
    }
    /*
    O.D.: pobranie wskaźnika do elementu
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */
}
