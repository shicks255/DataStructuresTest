package com.steven.hicks.Trie;

public class Driver
{
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("hell");
        trie.add("help");
        trie.addSentence("The quick brown fox");

        System.out.println(trie.contains("hell"));
        System.out.println(trie.contains("hell2"));
        System.out.println(trie.contains("the"));
        System.out.println(trie.contains("quick"));
        System.out.println(trie.contains("white"));

    }
}
