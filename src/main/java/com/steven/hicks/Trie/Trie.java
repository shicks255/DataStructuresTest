package com.steven.hicks.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie
{
    Map<String, TrieNode> start = new HashMap<>();

    public void add(String word)
    {
        Map<String, TrieNode> s = start;
        for (int i = 0; i < word.length(); i++)
        {
            String charr = word.substring(i,i+1).toLowerCase();
            TrieNode node = s.getOrDefault(charr, new TrieNode(charr));
            if (i == word.length()-1)
                node.isLeaf = true;
            s.put(charr, node);
            s = node.map;
        }
    }

    public void addSentence(String sentence)
    {
        String[] words = sentence.split(" ");
        for (String word : words)
            add(word);
    }

    public boolean contains(String word)
    {
        Map<String, TrieNode> s = start;
        for (int i = 0; i < word.length(); i++)
        {
            String charr = word.substring(i,i+1).toLowerCase();
            TrieNode node = s.get(charr);

            if (i == word.length()-1)
                return node == null ? false : node.isLeaf;

            if (node == null)
                return false;
            s = node.map;
        }

        return false;
    }

}
