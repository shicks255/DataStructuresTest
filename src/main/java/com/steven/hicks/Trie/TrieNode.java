package com.steven.hicks.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
    public String character = "";
    public Map<String, TrieNode> map;
    public boolean isLeaf;

    public TrieNode(String letter)
    {
        this.character = letter;
        this.isLeaf = false;
        this.map = new HashMap<>();
    }

}
