package org.mahesha.graphs.problems;

import org.mahesha.graphs.GenerateMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given a Matrix with 1s and 0s . 1 represent land and 0 represent water. Find the largest Island
0 0 1 1 0
0 1 1 0 0
1 0 0 1 0
1 0 1 1 0
1 0 0 0 0

Largest Island = 4

0 0 1 1 1
0 0 0 0 1
1 1 0 0 1
0 0 1 1 0
1 1 0 1 0
Largest Island = 5

 */
public class MaxAreaOfIsland {

    private static final int ROWS = 5;
    private static final int COLUMN = 5;

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();


        int [][] matrix = GenerateMatrix.generateMatrix(ROWS, COLUMN);
        HashSet<ArrayList<Integer>> visit = new HashSet<>();

        System.out.println("Largest Island = " + maxAreaOfIsland.findMaxArea(matrix, visit));
    }

    private int findMaxArea(int[][] matrix, HashSet<ArrayList<Integer>> visit) {

        int maxArea = -1;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMN; j++){
                if(matrix[i][j] != 0){
                    int temp = dfs(matrix, visit, i, j);
                    maxArea = temp > maxArea ? temp : maxArea;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] matrix, HashSet<ArrayList<Integer>> visit, int r, int c) {

        if(Math.min(r, c) < 0 || r == ROWS || c == COLUMN || visit.contains(new ArrayList<>(List.of(r, c))) || matrix[r][c] == 0){
            return 0;
        }

        visit.add(new ArrayList<>(List.of(r, c)));
        return 1 + dfs(matrix, visit, r + 1, c)
                 + dfs(matrix, visit, r - 1, c)
                 + dfs(matrix, visit, r, c + 1)
                 + dfs(matrix, visit, r, c - 1);

    }

}
