package com.example.demo.services;

import com.example.demo.POJO.SearchSuggestion;

import java.util.*;

public class SearchSuggestionService {
    Trie trie;
    public SearchSuggestionService(){
        this.trie = new Trie();

        this.trie.insert("temodal", 123, 0, "brand");
        this.trie.insert("temodar", 123, 0, "brand");
        this.trie.insert("terazosin", 456, 0, "main");
        this.trie.insert("tep II inhibitor", 324, 1, "main");
        this.trie.insert("tep I inhibitor", 323, 1, "main");
        this.trie.insert("inhibitor II", 324, 1, "secondary");
    }
    public List<SearchSuggestion> getSearchSuggestions(String searchq){

        List<SearchSuggestion> suggestions = this.trie.autocomplete(searchq);
        return suggestions;
    }
}

class TrieNode {
    char data;
    LinkedList<TrieNode> children;
    TrieNode parent;
    boolean isEnd;
    Set<SearchSuggestion> suggestions;

    public TrieNode(char c) {
        data = c;
        children = new LinkedList();
        suggestions = new HashSet<>();
        isEnd = false;
    }

    public TrieNode getChild(char c) {
        if (children != null)
            for (TrieNode eachChild : children)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }

    protected List getWords() {
        List<SearchSuggestion> list = new ArrayList();
        if (isEnd) {
            list.addAll(suggestions);
        }

        if (children != null) {
            for (int i=0; i< children.size(); i++) {
                if (children.get(i) != null) {
                    list.addAll(children.get(i).getWords());
                }
            }
        }
        return list;
    }

}


class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }



    public void insert(String word, int id, int type, String nameType) {

        TrieNode current = root;
        TrieNode pre ;
        for (char ch : word.toCharArray()) {
            pre = current;
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
            } else {
                current.children.add(new TrieNode(ch));
                current = current.getChild(ch);
            }
        }
        SearchSuggestion suggestion = new SearchSuggestion();
        suggestion.setId(id);
        suggestion.setName(word);
        suggestion.setType(type);
        suggestion.setNameType(nameType);
        current.suggestions.add(suggestion);
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else {
                current = current.getChild(ch);
            }
        }
        if (current.isEnd == true) {
            return true;
        }
        return false;
    }

    public List autocomplete(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i< prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null)
                return new ArrayList();
        }

        return lastNode.getWords();
    }
}

