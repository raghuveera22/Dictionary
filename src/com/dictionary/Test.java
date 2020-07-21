package com.dictionary;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Dictionary trie = new Dictionary();

        List<String> initialDictionaryList = Arrays.asList("Toyota", "Honda", "any", "Bmw", "Audi", "Chevy", "Volks", "Ford");

        for (int i = 0; i < initialDictionaryList.size(); i++)
            trie.addToDictionary(initialDictionaryList.get(i).toLowerCase());

        System.out.println("Toyota is available in Dictionary ? " + trie.searchInDictionary(("Toyota")));

        System.out.println("Honda is available in Dictionary ? " + trie.searchInDictionary("Honda"));

        System.out.println("Bmw is available in Dictionary ? " + trie.searchInDictionary("Bmw"));

        System.out.println("Ford is available in Dictionary ? " + trie.searchInDictionary("Ford"));
        
        System.out.println("---------------------------Delete -------------------------");        
        System.out.println("deleting Ford from Dictionary ? " + trie.deleteFromDictionary("Ford"));
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ford is available in Dictionary ? " + trie.searchInDictionary(("Ford")));
        
        System.out.println("---------------------------Update -------------------------");
        System.out.println("updating Bmw to Audi in Dictionary ? " + trie.update("Bmw", "Audi"));
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bmw is available in Dictionary ? " + trie.searchInDictionary("Bmw"));

        System.out.println("Audi is available in Dictionary ? " + trie.searchInDictionary("Audi"));
    }
}