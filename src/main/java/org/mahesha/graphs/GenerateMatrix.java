package org.mahesha.graphs;

import org.mahesha.RandomGenerator;

public class GenerateMatrix {

    public static int[][] generateMatrix(int rows, int column) {

        int[][] matrix = new int[rows][column];

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = RandomGenerator.generateNumber(0, 2);
            }
        }

        matrix[0][0] = 0;
        matrix[rows - 1][column - 1] = 0;


        for(int [] rs: matrix){
            System.out.println();
            for(int c : rs){
                System.out.print(c + " ");
            }
        }
        System.out.println();


        return matrix;
    }

}
