package org.mahesha.graphs.problems;

import org.mahesha.graphs.GenerateMatrix;

import java.util.*;

/*
Find the shortest path from top left to right bottom of the matrix. Traverse through all 0's path
With Breadth First Search (BFS) it would be n * m complexity (n*m) is the size of matrix
With Depth First Search (DFS) it would be 4 to the power (n*m) complexity
 */
public class MatrixShortestPath {

    private static final int ROWS = 5;
    private static final int COLUMN = 5;


    public static void main(String[] args) {

        MatrixShortestPath matrixShortestPath = new MatrixShortestPath();

        int [][] matrix = GenerateMatrix.generateMatrix(ROWS, COLUMN);
        HashSet<ArrayList<Integer>> visit = new HashSet<>();

        //As we are randomly generating just be make more chances of the Path existence, making first and last
        //matrix value as 0s
        matrix[0][0] = 0;
        matrix[ROWS - 1][COLUMN - 1] = 0;

        System.out.println("Shortest Path Length : " + matrixShortestPath.BFSPath(matrix, visit));
    }

    private int BFSPath(int[][] matrix, HashSet<ArrayList<Integer>> visit) {

        // Keep the Queue Visit and initialize it to have (0,0) the top left matrix
        Queue<ArrayList<Integer>> bfsQueue = new LinkedList();
        bfsQueue.add(new ArrayList<>(List.of(0, 0)));

        // Keep track of all the visited nodes so that it need to be visited again.
        visit.add(new ArrayList<>(List.of(0, 0)));

        int shortLength = 0;

        // For bfs, we need to add the next neighbours
        HashSet<ArrayList<Integer>> neighbour = new HashSet<>();
        neighbour.add(new ArrayList<>(Arrays.asList(0, 1)));
        neighbour.add(new ArrayList<>(Arrays.asList(0, -1)));
        neighbour.add(new ArrayList<>(Arrays.asList(1, 0)));
        neighbour.add(new ArrayList<>(Arrays.asList(-1, 0)));

        while(!bfsQueue.isEmpty()){

            int queueSize = bfsQueue.size();
            for(int i = 0; i < queueSize; i++){

                ArrayList<Integer> eachQueue = bfsQueue.poll();
                int r = eachQueue.getFirst();
                int c = eachQueue.getLast();

                if(r == ROWS - 1 && c == COLUMN - 1){
                    return shortLength;
                }

                for(ArrayList<Integer> neighbourPar : neighbour){
                    int rN = neighbourPar.getFirst();
                    int cN = neighbourPar.getLast();

                    if( r + rN < 0 || c + cN < 0 || r + rN == ROWS || c + cN == COLUMN ||
                            visit.contains(new ArrayList<>(List.of(r + rN, c + cN))) || matrix[r + rN][c + cN] == 1){
                        continue;
                    }

                    visit.add(new ArrayList<>(List.of(r + rN, c + cN)));
                    bfsQueue.add(new ArrayList<>(List.of(r + rN, c + cN)));

                }

            }

            shortLength++;
        }

        // This means there is no path from top left to bottom right of the matrix
        return -1;
    }

}
