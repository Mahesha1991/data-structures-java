package org.mahesha.graphs.problems;

import org.mahesha.graphs.GenerateMatrix;

import java.util.*;

/*
You are given a 2-D matrix grid. Each cell can have one of three possible values:

0 representing an empty cell
1 representing a fresh fruit
2 representing a rotten fruit
Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit, then the fresh fruit also becomes rotten.

Return the minimum number of minutes that must elapse until there are zero fresh fruits remaining. If this state is impossible within the grid, return -1.
 */
public class RottingFruit {

    private static final int ROWS = 10;
    private static final int COLUMN = 10;

    public static void main(String[] args) {
        RottingFruit rottingFruit = new RottingFruit();

        int [][] matrix = GenerateMatrix.generateMatrix(ROWS, COLUMN, 0, 3);
        HashSet<ArrayList<Integer>> visit = new HashSet<>();

        System.out.println("Minutes Taken = " + rottingFruit.findMinutesBFS(matrix, visit));

    }

    private int findMinutesBFS(int[][] matrix, HashSet<ArrayList<Integer>> visit) {

        int minute = 0;
        int freshFruit = 0;
        Queue<ArrayList<Integer>> bfsQueue = new LinkedList<>();
        HashSet<ArrayList<Integer>> neighbour = new HashSet<>();
        neighbour.add(new ArrayList<>(List.of(0, 1)));
        neighbour.add(new ArrayList<>(List.of(1, 0)));
        neighbour.add(new ArrayList<>(List.of(-1, 0)));
        neighbour.add(new ArrayList<>(List.of(0, -1)));



        //Loop through the metrics and find the 2 (rotten fruit) location and add it to the queue.
        //Then with BFS, start exploring all neighbours of all the elements in the queue as first level.
        //Whenever we find 1 (while BFS), add it to the queue, so that in next level (of queue), its neighbours
        //will be considered. Here, ideall levels are the minutes passed.
        //We can also keep track of the proper fruits count (i.e # of 1s). So that if the matrix is big then, this also
        //helps to reduce the time complexity


        for(int i = 0; i < ROWS; i++){

            for(int j = 0; j < COLUMN; j++){

                if(matrix[i][j] == 1){
                    freshFruit++;
                }

                if(matrix[i][j] == 2){
                    bfsQueue.add(new ArrayList<>(List.of(i, j)));
                }

            }
        }

        //Loop through until the queue is empty or freshFruit is zero
        while(freshFruit > 0 && !bfsQueue.isEmpty()){

            int queueSize = bfsQueue.size();
            for(int i = 0; i < queueSize; i++){
                ArrayList<Integer> eachQueue = bfsQueue.poll();
                int r = eachQueue.getFirst();
                int c = eachQueue.getLast();

                for(ArrayList<Integer> n : neighbour){
                    int rN = r + n.get(0);
                    int cN = c + n.get(1);

                    if(Math.min(rN, cN) < 0 || rN == ROWS || cN == COLUMN ||
                            visit.contains(new ArrayList<>(List.of(rN, cN))) || matrix[rN][cN] == 0 ||  matrix[rN][cN] == 2){
                        continue;
                    }

                    visit.add(new ArrayList<>(List.of(rN, cN)));
                    bfsQueue.add(new ArrayList<>(List.of(rN, cN)));
                    freshFruit--;

                }
            }

            minute++;

        }

        if(freshFruit > 0){
            return -1;
        } else {
            return minute;
        }

    }
}
