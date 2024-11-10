package org.mahesha.graphs.problems;


import org.mahesha.RandomGenerator;
import org.mahesha.graphs.GenerateMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given a matrix with 0s and 1s, find all the unique paths from top left corner to the right bottom consisting of 0s in the path
 */
public class MatrixUniquePath {

    public static void main(String[] args) {

        MatrixUniquePath matrixUniquePath = new MatrixUniquePath();
        int rows = 5;
        int column = 5;

        int [][] matrix = GenerateMatrix.generateMatrix(rows, column);
        //HashSet<int[]> visit = new HashSet<>();
        // The above cannot be used as when we add elements to this set (like new int[]{1,3}) new instance object is
        // created and will have different equals() and hashcode() return values even though the array values itself are same

        HashSet<List<Integer>> visit = new HashSet<>();

//        visit.add(new ArrayList<>(List.of(10, 15)));
//        System.out.println(visit.add(new ArrayList<>(List.of(10, 15))));
//        System.out.println(visit.contains(new ArrayList<>(List.of(10, 15))));


        System.out.println("Unique path count: " + matrixUniquePath.dfsBacktracking(matrix, 0, 0, visit, rows - 1, column - 1));



    }

    private int dfsBacktracking(int[][] matrix, int r, int c, HashSet<List<Integer>> visit, int ROWS, int COLUMN) {

        if(Math.min(r, c) < 0 || r > ROWS || c > COLUMN || visit.contains(new ArrayList<>(List.of(r, c))) || matrix[r][c] == 1){
            return 0;
        }
        if(r == ROWS && c == COLUMN){
            return 1;
        }

        visit.add(new ArrayList<>(List.of(r, c)));
        int count = 0;
        count += dfsBacktracking(matrix, r + 1, c, visit, ROWS, COLUMN);
        count += dfsBacktracking(matrix, r - 1, c, visit, ROWS, COLUMN);
        count += dfsBacktracking(matrix, r, c + 1, visit, ROWS, COLUMN);
        count += dfsBacktracking(matrix, r, c - 1, visit, ROWS, COLUMN);

        visit.remove(new ArrayList<>(List.of(r, c)));
        return count;

    }
}
