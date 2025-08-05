package org.mahesha.trie;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TrieMain {

    public static void main(String[] args) {
        Faker faker = new Faker();
        TrieOps trieOps = new TrieOps();
        List<String> all = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            String country = faker.country().name();
            all.add(country);
            trieOps.insert(country);
        }

        System.out.println(trieOps);

        all.sort(String::compareTo);
        System.out.println(all);
        System.out.println(trieOps.startsWith("d"));
        System.out.println(trieOps.getAll());
    }
}
