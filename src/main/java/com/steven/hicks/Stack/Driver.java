package com.steven.hicks.Stack;

public class Driver
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.size);
    }
}
