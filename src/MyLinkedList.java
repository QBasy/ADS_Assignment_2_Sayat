public class MyLinkedList<E> implements MyList<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(E element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            addToEnd(head, newNode);
        }
        size++;
    }

    @Override
    public void add(E item, int index) {

    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    private void addToEnd(Node current, Node newNode) {
        if (current.next == null) {
            current.next = newNode;
            newNode.next = null;
            tail = newNode;
        } else {
            addToEnd(current.next, newNode);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeAtIndex(head, index).data;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    private Node getNodeAtIndex(Node current, int index) {
        if (index == 0) {
            return current;
        }
        return getNodeAtIndex(current.next, index - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            E removedData = head.data;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return removedData;
        } else {
            return removeAtIndex(head, index - 1);
        }
    }

    @Override
    public void clear() {

    }

    private E removeAtIndex(Node current, int index) {
        if (index == 0) {
            E removedData = current.next.data;
            current.next = current.next.next;
            size--;
            if (current.next == null) {
                tail = current;
            }
            return removedData;
        }
        return removeAtIndex(current.next, index - 1);
    }

    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    // Implement any other methods specified by the List interface.
}
