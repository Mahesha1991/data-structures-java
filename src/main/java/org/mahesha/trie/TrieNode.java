package org.mahesha.trie;

import java.util.HashMap;

public class TrieNode {

    public HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endWord = false;
}
