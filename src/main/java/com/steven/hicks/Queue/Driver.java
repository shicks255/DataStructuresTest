package com.steven.hicks.Queue;

public class Driver
{
    public static void main(String[] args)
    {
        Queue<Integer> que = new Queue<>();
        que.queue(1);
        que.queue(2);
        que.queue(3);
        que.queue(4);

        System.out.println(que);

        que.deque();

        System.out.println(que);
    }

    public static void makeQueueFrom2Stacks()
    {

    }
}
