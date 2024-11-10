package org.mahesha.bst.problems;

import org.mahesha.RandomGenerator;
import org.mahesha.bst.BSTNode;
import org.mahesha.bst.BSTOps;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        BSTOps tree = new BSTOps();

        for (int i = 0; i < 10; i++) {
            tree.insert(RandomGenerator.generateNumber(100, 150));
        }
        System.out.print("InOrder : ");

        tree.inOrder(tree.getRoot());

        
    }
}
