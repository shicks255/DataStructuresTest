package com.steven.hicks.LinkedList;

public class LinkedList<T extends Comparable>
{
    Node root;

    @Override
    public String toString()
    {
        Node temp = root;
        StringBuilder toString = new StringBuilder();
        while (temp != null)
        {
            toString.append(temp.data + " -> ");
            temp = temp.next;
        }

        return toString.toString();
    }

    public void add(T data)
    {
        if (root == null)
            root = new Node(data);
        else
            add(root, data);
    }

    private void add(Node root, T data)
    {
        if (root.next == null)
            root.next = new Node(data);
        else
            add(root.next, data);
    }

    public void remove(T data)
    {
        if (root != null)
        {
            if (root.data.equals(data))
                root = root.next;
            else
                remove(root, data);
        }
    }

    private void remove(Node root, T data)
    {
        if (root.next != null)
        {
            if (root.next.data.equals(data))
                root.next = root.next.next;
            else
                remove(root.next, data);
        }
    }

    public boolean contains(T data)
    {
        return contains(root, data);
    }

    private boolean contains(Node root, T data)
    {
        if (root != null)
        {
            if (root.data.equals(data))
                return true;
            else
                return contains(root.next, data);
        }
        return false;
    }

    public int length()
    {
        if (root == null)
            return 0;
        return length(root, 0);
    }

    private int length(Node root, int soFar)
    {
        if (root != null)
            return length(root.next, soFar + 1);
        else
            return soFar;
    }

    public Node middleElement()
    {
        Node fast = root;
        Node slow = root;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public LinkedList partitionAround(T data)
    {
        LinkedList<T> one = new LinkedList<>();
        LinkedList<T> two = new LinkedList<>();

        Node temp = root;
        Node partition = null;
        while (temp != null)
        {
            if (data.compareTo(temp.data) > 0)
                one.add((T)temp.data);
            else if (data.compareTo(temp.data) < 0)
                two.add((T)temp.data);
            else
                partition = new Node(temp.data);
            temp = temp.next;
        }

        temp = one.root;
        while (true)
        {
            if (temp.next == null)
            {
                if (partition == null)
                {
                    temp.next = two.root;
                    break;
                }
                if (partition != null)
                {
                    temp.next = partition;
                    partition.next = two.root;
                    break;
                }
            }
            else
                temp = temp.next;
        }

        LinkedList<T> newList = new LinkedList();
        newList.root = one.root;
        return newList;
    }

    public Node kFromEnd(int k)
    {
        Node ahead = root;
        Node behind = root;

        while (k-- >  0 && ahead != null)
            ahead = ahead.next;

        while (ahead != null)
        {
            ahead = ahead.next;
            behind = behind.next;
        }

        return behind;
    }

    public void reverse()
    {
        Node prev = null;
        Node current = root;
        Node next = null;

        while (current != null)
        {
            root = current;

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    static class Node<T extends Comparable>
    {
        T data;
        Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString()
        {
            return "Node " + data;
        }
    }
}
