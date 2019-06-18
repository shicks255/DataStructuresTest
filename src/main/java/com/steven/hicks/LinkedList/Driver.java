package com.steven.hicks.LinkedList;

public class Driver
{
    public static void main(String[] args)
    {
        LinkedList<Comparable> list = new LinkedList<>();
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(7);

        System.out.println(list);
//        System.out.println(list.contains(33));
//        System.out.println(list.length());
//        System.out.println("Middle elemtent is " + list.middleElement());
//
//        System.out.println("Lets partition the list around 3");
        System.out.println(list.partitionAround(3));

        System.out.println("Reversing list...");
        list.reverse();
        System.out.println(list);

        System.out.println("The 5th node from the end is");
        System.out.println(list.kFromEnd(5));

    }
}
