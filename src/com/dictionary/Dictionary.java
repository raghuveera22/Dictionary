package com.dictionary;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private DictionaryNode root;

    public Dictionary() {
        // root represents empty string i.e ""
        root = new DictionaryNode(true);
    }


    public boolean addToDictionary(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        DictionaryNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            DictionaryNode child = parent.children.get(cur);
            if (child == null) {
                child = new DictionaryNode(false);
                parent.children.put(cur, child);
            }

            parent = child;
        }

        parent.isEndOfWord = true;
        return true;
    }

    public boolean searchInDictionary(String word) {
        if (word == null) {
            return false;
        }

        DictionaryNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            DictionaryNode child = parent.children.get(cur);
            if (child == null) {
                return false;
            }

            parent = child;
        }

        return parent.isEndOfWord;
    }

    public boolean deleteFromDictionary(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        // All nodes below 'deleteBelow' and on the path starting with 'deleteChar' (including itself) will be deleted if needed
        DictionaryNode deleteBelow = null;
        char deleteChar = '\0';

        // Search to ensure word is present
        DictionaryNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            DictionaryNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'word' is way too long or its prefix doesn't appear in the Trie
                return false;
            }

            if (parent.children.size() > 1 || parent.isEndOfWord) { // Update 'deleteBelow' and 'deleteChar'
                deleteBelow = parent;
                deleteChar = cur;
            }

            parent = child;
        }

        if (!parent.isEndOfWord) { // word isn't in trie
            return false;
        }

        if (parent.children.isEmpty()) {
            deleteBelow.children.remove(deleteChar);
        } else {
            parent.isEndOfWord = false; // Delete word by mark it as not the end of a word
        }

        return true;
    }

    public boolean update(String oldWord, String newWord) {
        return addToDictionary(newWord) && deleteFromDictionary(oldWord);
    }
}

class DictionaryNode {
    boolean isEndOfWord;
    Map<Character, DictionaryNode> children;

    DictionaryNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
        this.children = new HashMap<>();
    }
}