package org.mahesha.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieOps {

    private TrieNode root;

    public TrieOps(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;

        for(char c: word.toLowerCase().toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endWord = true;
    }

    public boolean search(String word){
        TrieNode curr = root;

        for(char c: word.toLowerCase().toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.endWord;
    }

    public boolean startsWith(String word){
        TrieNode curr = root;

        for(char c: word.toLowerCase().toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }

        return true;
    }

    public List<String> getAll(){

        List<String> all = new ArrayList<>();

        dfs(root, all, new StringBuilder());

        return all;
    }

    private static void dfs(TrieNode curr, List<String> all, StringBuilder sb) {


        if(curr.children.isEmpty()){
            all.add(sb.toString());
            return;
        }

        for(char c: curr.children.keySet()){

            sb.append(c);
            dfs(curr.children.get(c), all, sb);
            //all.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);

        }


    }
}
