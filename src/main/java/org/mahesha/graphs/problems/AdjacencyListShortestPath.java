package org.mahesha.graphs.problems;

import org.mahesha.graphs.GenerateAdjacencyList;

import java.util.*;

public class AdjacencyListShortestPath {

    private static final int VERTEX = 20;
    private static final int EDGE = 2;

    public static void main(String[] args) {

        AdjacencyListShortestPath adjacencyListShortestPath = new AdjacencyListShortestPath();


        //{T7=[R0, Z9], X1=[F2, Z9], F2=[X1, Z9], R0=[T7, Z9], V4=[T7, F2], Z9=[X1]}
        Map<String, Set<String>> adjacencyList = GenerateAdjacencyList.getList(VERTEX, EDGE);
        //Here we simply take the first and the last key. Please note there is no guarantee that it would always pick
        //first and last element as it is a HashMap Key.

        String startVertex = (String) adjacencyList.keySet().toArray()[0];
        String endVertex = (String) adjacencyList.keySet().toArray()[adjacencyList.size() - 1];

        System.out.println("Shortest Length from " + startVertex + " to " + endVertex + ": " + adjacencyListShortestPath.bfs(startVertex, endVertex, adjacencyList));


    }

    private int bfs(String startVertex, String endVertex, Map<String, Set<String>> adjacencyList) {

        Set<String> visit = new HashSet<>();
        Queue<String> bfsQueue = new LinkedList<>();
        // Add all the adjacent vertices of the start vertices.
        int distance = 0;

        bfsQueue.add(startVertex);

        while(!bfsQueue.isEmpty()){

            int queueSize = bfsQueue.size();

            for(int i = 0; i < queueSize; i++){

                String currentVertex = bfsQueue.poll();

                if(currentVertex.equals(endVertex)){
                    return distance;
                }

                for(String n : adjacencyList.get(currentVertex)){
                    if(!visit.contains(n)){
                        visit.add(n);
                        bfsQueue.add(n);
                    }
                }
            }
            distance++;
        }

        // If the code has reached here, then there is no edge path from start to end vertex
        return -1;
    }
}
