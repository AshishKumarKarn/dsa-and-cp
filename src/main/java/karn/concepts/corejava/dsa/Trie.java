package karn.concepts.corejava.dsa;

import java.util.ArrayList;
import java.util.List;

class TrieDemo {
    static void main() {
        TrieDemo demo = new TrieDemo();
        String[] queries = {"node", "iarapqqk", "aokbrtmx", "yafmjorj", "larakqqk", "nliynmpm", "isikkcws", "laraeqqk"};
        String[] dictionary = {"joke", "larapqqk", "isukkcws", "siqqoacj", "nloynmpm"};
        System.out.println(demo.twoEditWords(queries, dictionary));
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie trie = new Trie();
        for (String d : dictionary) {
            trie.addWord(d);
        }
        List<String> result = new ArrayList<>();
        for (String q : queries) {
            if (trie.hasWordWithMatchingLetters(trie, q, 2)) {
                result.add(q);
            }
        }
        return result;
    }

}

class Trie {
    Trie[] children;
    boolean end;

    Trie() {
        children = new Trie[26];
    }

    public void addWord(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (trie.children[ind] == null) {
                trie.children[ind] = new Trie();
            }
            trie = trie.children[ind];
        }
        trie.end = true;
    }

    public boolean hasWord(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (trie.children[ind] == null) {
                return false;
            }
            trie = trie.children[ind];
        }
        return trie.end;
    }

    public boolean hasWordWithMatchingLetters(Trie t, String word, int count) {
        Trie trie = t;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (count > 0) {
                boolean result = false;
                for (int j = 0; j < 26; j++) {
                    if (trie.children[j] != null) {
                        if (ind == j) {
                            result |= hasWordWithMatchingLetters(trie.children[j], word.substring(i + 1), count);
                        } else {
                            result |= hasWordWithMatchingLetters(trie.children[j], word.substring(i + 1), count - 1);
                        }
                    }
                }
                return result;
            } else if (trie.children[ind] == null && count == 0) {
                return false;
            }
            trie = trie.children[ind];
        }
        return trie.end;
    }
}