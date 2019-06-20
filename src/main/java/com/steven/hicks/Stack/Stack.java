package com.steven.hicks.Stack;

public class Stack<T>
{
    Node<T> top;
    int size = 0;

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        Node top = this.top;
        while (top != null)
        {
            string.append(top.data + " -> ");
            top = top.next;
        }

        return string.toString();
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void push(T data)
    {
        size++;
        if (top == null)
            top = new Node(data);
        else
        {
            Node temp = top;
            top = new Node(data);
            top.next = temp;
        }
    }

    public Node<T> pop()
    {
        if (top == null)
            return null;

        size--;
        Node temp = top;
        top = top.next;
        return temp;
    }

    static class Node<T>
    {
        T data;
        Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
}
