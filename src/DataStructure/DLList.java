package DataStructure;

public class DLList<T> {

    public int size = 0;
    private DLNode<T> head = null;
    private DLNode<T> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public T first() {
        if (head == null)
            throw new IllegalStateException("List is empty");
        return head.value;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public T last() {
        if (tail == null)
            throw new IllegalStateException("List is empty");
        return tail.value;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public void insertAfter(T value, T after) {
        DLNode<T> temp = getPtr(after);
        DLNode<T> toInsert = new DLNode<>(value);

        toInsert.next = temp.next;

        if (temp.next != null)
            temp.next.prev = toInsert;
        else
            tail = toInsert;
        toInsert.prev = temp;
        temp.next = toInsert;

        size++;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void insertBefore(T value, T before) {
        DLNode<T> temp = getPtr(before);
        DLNode<T> toInsert = new DLNode<>(value);


        toInsert.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = toInsert;
        else
            head = toInsert;
        toInsert.next = temp;
        temp.prev = toInsert;

        size++;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void moveAfter(T value, T after) {
        DLNode<T> temp = getPtr(after);
        DLNode<T> toMove = getPtr(value);

        if (toMove.prev != null)
            toMove.prev.next = toMove.next;
        else
            head = toMove.next;
        if (toMove.next != null)
            toMove.next.prev = toMove.prev;
        else
            tail = toMove.prev;

        toMove.next = temp.next;
        if (temp.next != null)
            temp.next.prev = toMove;
        temp.next = toMove;
        toMove.prev = temp;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void moveBefore(T value, T before) {
        DLNode<T> temp = getPtr(before);
        DLNode<T> toMove = getPtr(value);

        if (toMove.prev != null)
            toMove.prev.next = toMove.next;
        else
            head = toMove.next;
        if (toMove.next != null)
            toMove.next.prev = toMove.prev;
        else
            tail = toMove.prev;

        if (temp.prev != null)
            temp.prev.next = toMove;
        else
            head = toMove;
        toMove.prev = temp.prev;
        toMove.next = temp;
        temp.prev = toMove;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void removeAfter(T value) {
        DLNode<T> temp = getPtr(value);
        DLNode<T> toRemove = temp.next;

        if (toRemove != null) {
            temp.next = toRemove.next;
            if (toRemove.next != null)
                toRemove.next.prev = temp;
            else
                tail = temp;
            size--;
        }
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void removeBefore(T value) {
        DLNode<T> temp = getPtr(value);
        DLNode<T> toRemove = temp.prev;

        if (toRemove != null) {
            temp.prev = toRemove.prev;
            if (toRemove.prev != null)
                toRemove.prev.next = temp;
            else
                head = temp;
            size--;
        }
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void pushBack(T value) {
        DLNode<T> temp = new DLNode<>(value);

        if (size == 0) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;

        size++;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public void pushFront(T value) {
        DLNode<T> temp = new DLNode<>(value);

        if (size == 0) {
            tail = temp;
        } else {
            head.prev = temp;
            temp.next = head;
        }
        head = temp;

        size++;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public T popBack() {
        if (tail == null)
            throw new IllegalStateException("List is empty");

        T toRet = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;

        return toRet;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public T popFront() {
        if (head == null)
            throw new IllegalStateException("List is empty");

        T toRet = head.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;

        return toRet;
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public void concat(DLList<T> toConcat) {
        if (toConcat.head != null) {
            if (tail != null)
                tail.next = toConcat.head;
            else
                head = toConcat.head;
            toConcat.head.prev = tail;
            tail = toConcat.tail;
            size += toConcat.size;
        }
    }
    /*
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public void splice(DLNode<T> a, DLNode<T> b, DLNode<T> t) {
        DLNode<T> aPrev = a.prev;
        DLNode<T> bNext = b.next;
        DLNode<T> tNext = t.next;

        if (aPrev != null)
            aPrev.next = bNext;
        else
            head = bNext;
        if (bNext != null)
            bNext.prev = aPrev;
        else
            tail = aPrev;

        t.next = a;
        a.prev = t;
        b.next = tNext;
        if (tNext != null)
            tNext.prev = b;

        updateSize();
    }
    /*
    TYLKO JEŚLI POSIADAMY WSKAŹNIKI
    W(n) = O(1)
    A(n) = O(1)
    S(n) = O(1)
    */

    public T findNext(T value) {
        DLNode<T> temp = getPtr(value);

        if (temp.next == null)
            throw new IllegalArgumentException("Value does not exist in the list or is the last element");

        return temp.next.value;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public T findPrev(T value) {
        DLNode<T> temp = getPtr(value);

        if (temp.prev == null)
            throw new IllegalArgumentException("Value does not exist in the list or is the first element");

        return temp.prev.value;
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    public void display() {
        DLNode<T> node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    private DLNode<T> getPtr(T value) {
        DLNode<T> temp = head;
        while (temp != null) {
            if (temp.value.equals(value))
                return temp;
            temp = temp.next;
        }
        throw new IllegalArgumentException("Value does not exist in the list");
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */

    private void updateSize() {
        size = 0;
        DLNode<T> temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
    }
    /*
    O.D.: pobieranie wskaźnika do węzła
    R.D.: długość ciągu
    W(n) = O(n)
    A(n) = O(n)
    S(n) = O(1)
    */
}