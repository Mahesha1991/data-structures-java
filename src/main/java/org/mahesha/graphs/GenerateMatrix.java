package org.mahesha.graphs;

import org.mahesha.RandomGenerator;

public class GenerateMatrix {

    public static int[][] generateMatrix(int rows, int column) {

        return getMatrix(rows, column, 0, 2);
    }

    public static int[][] generateMatrix(int rows, int column, int start, int end) {

        return getMatrix(rows, column, start, end);
    }

    public static int[][] getMatrix(int rows, int column, int start, int end){

        int[][] matrix = new int[rows][column];

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = RandomGenerator.generateNumber(start, end);
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
