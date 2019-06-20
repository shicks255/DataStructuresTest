package com.steven.hicks.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable>
{
    Node<T> root;

    public void add(T data)
    {
        if (root == null)
            root = new Node<>(data);
        else
            add(root, data);
    }

    public void add(Node root, T data)
    {
        if (root == null)
            return;
        if (data.compareTo(root.data) >= 0)
        {
            if (root.right == null)
                root.right = new Node(data);
            else
                add(root.right, data);
        }
        else
        {
            if (root.left == null)
                root.left = new Node(data);
            else
                add(root.left, data);
        }
    }

    public boolean contains(T value)
    {
        return contains(root, value);
    }

    public boolean contains(Node root, T value)
    {
        if (root == null)
            return false;

        if (root.data.compareTo(value) == 0)
            return true;

        if (value.compareTo(root.data) > 0)
            return contains(root.right, value);
        return contains(root.left, value);
    }

    public void remove(T data)
    {
        remove(root, data);
    }

    public Node remove(Node root, T data)
    {
        if (root == null)
            return null;

        if (data.compareTo(root.data) > 0)
        {
            root.right = remove(root.right, data);
            return root;
        }
        if (data.compareTo(root.data) < 0)
        {
            root.left = remove(root.left, data);
            return root;
        }
        else
        {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null && root.right != null)
                return root.right;
            if (root.left != null && root.right == null)
                return root.left;
            else
            {
                if (root.right != null)
                {
                    Node tempSmallest = root.right;
                    while (tempSmallest != null)
                    {
                        if (tempSmallest.left == null)
                        {
                            root.data = tempSmallest.data;
                            root.right = remove(root.right, (T)tempSmallest.data);
                            return root;
                        }
                        tempSmallest = tempSmallest.left;
                    }
                }
            }
        }

        return null;
    }

    public void rebalance()
    {
        root = rebalance(root);
    }

    public Node rebalance(Node root)
    {
        List<Node> list = preOrderList(new ArrayList<>(), root);

        root = rebalance(0, list.size()-1, list);
        return root;
    }

    public Node rebalance(int start, int end, List<Node> list)
    {
        if (start > end)
            return null;
        int middle = (start + end) / 2;
        Node middleNode = list.get(middle);
        middleNode.left = rebalance(start, middle-1, list);
        middleNode.right = rebalance(middle+1, end, list);

        return middleNode;
    }

    private List<Node> preOrderList(List<Node> list, Node root)
    {
        if (root == null)
            return list;

        list = preOrderList(list, root.left);
        list.add(root);
        list = preOrderList(list, root.right);

        return list;
    }

    public void printPreOrder()
    {
        String preOrder = printPreOrder(root);
        System.out.println(preOrder);
    }
    private String printPreOrder(Node root)
    {
        if (root == null)
            return "";

        String soFar = " " + root.data + " ";
        soFar += printPreOrder(root.left);
        soFar += printPreOrder(root.right);

        return soFar;
    }

    public void printPostOrder()
    {
        String postOrder = printPostOrder(root);
        System.out.println(postOrder);
    }
    private String printPostOrder(Node root)
    {
        if (root == null)
            return "";

        String soFar = printPostOrder(root.left);
        soFar += printPostOrder(root.right);
        soFar += " " + root.data + " ";

        return soFar;
    }

    public void printInOrder()
    {
        String inOrder = printInOrder(root);
        System.out.println(inOrder);
    }
    private String printInOrder(Node root)
    {
        if (root == null)
            return "";

        String soFar = printInOrder(root.left);
        soFar += " " + root.data + " ";
        soFar += printInOrder(root.right);

        return soFar;
    }

    static class Node<T extends Comparable>
    {
        T data;
        Node left;
        Node right;

        public Node(T data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString()
        {
            return data.toString();
        }
    }
}
