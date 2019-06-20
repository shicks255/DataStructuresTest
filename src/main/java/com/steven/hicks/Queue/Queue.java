package com.steven.hicks.Queue;

import com.steven.hicks.Stack.Stack;

public class Queue<T>
{
    Node<T> front;

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        Node front = this.front;
        while (front != null)
        {
            string.append(front.data + " <- ");
            front = front.next;
        }

        return string.toString();
    }

    public void queue(T data)
    {
        if (front == null)
            front = new Node(data);
        else
        {
            Node<T> temp = front;
            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node(data);
        }
    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public Node deque()
    {
        if (front == null)
            return null;

        Node temp = front;
        front = front.next;
        return temp;
    }

    static class Node<T>
    {
        T data;
        Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
}
