package org.mahesha.bst;

import org.mahesha.RandomGenerator;

public class BSTMain {

    public static void main(String[] args) {

        BSTOps tree = new BSTOps();

        for (int i = 0; i < 10; i++) {
            tree.insert(RandomGenerator.generateNumber(100, 150));
        }
        System.out.print("InOrder : ");

        tree.inOrder(tree.getRoot());
        System.out.println();
        System.out.print("PreOrder : ");

        tree.preOrder(tree.getRoot());

//        System.out.println("\nMin Value: ");
//        System.out.println(tree.minValueNode(tree.getRoot()).data);

        System.out.println();

        tree.setRoot(tree.remove(tree.getRoot(), 123));
        tree.inOrder(tree.getRoot());

    }
}
