package com.steven.hicks.BinarySearchTree;

public class Driver
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(9);

        tree.printPreOrder();
        tree.printInOrder();
        tree.printPostOrder();

        tree.remove(5);

        tree.printInOrder();
    }
}
