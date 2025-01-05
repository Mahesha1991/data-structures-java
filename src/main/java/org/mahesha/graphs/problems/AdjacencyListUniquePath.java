package org.mahesha.graphs.problems;

import org.mahesha.graphs.GenerateAdjacencyList;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjacencyListUniquePath {

    private static final int VERTEX = 20;
    private static final int EDGE = 2;

    public static void main(String[] args) {

        AdjacencyListUniquePath adjacencyListUniquePath = new AdjacencyListUniquePath();

        //{T7=[R0, Z9], X1=[F2, Z9], F2=[X1, Z9], R0=[T7, Z9], V4=[T7, F2], Z9=[X1]}
        Map<String, Set<String>> adjacencyList = GenerateAdjacencyList.getList(VERTEX, EDGE);
        //Here we simply take the first and the last key. Please note there is no guarantee that it would always pick
        //first and last element as it is a HashMap Key.

        String startVertex = (String) adjacencyList.keySet().toArray()[0];
        String endVertex = (String) adjacencyList.keySet().toArray()[adjacencyList.size() - 1];
        Set<String> visit = new HashSet<>();

        System.out.println("Total Number of Unique Length from " + startVertex + " to " + endVertex + ": " + adjacencyListUniquePath.dfs(startVertex, endVertex, adjacencyList, visit));
    }

    private int dfs(String currentVertex, String endVertex, Map<String, Set<String>> adjacencyList, Set<String> visit) {

        if(visit.contains(currentVertex)){
            return 0;
        }

        if(currentVertex.equals(endVertex)){
            return 1;
        }

        int count = 0;
        visit.add(currentVertex);

        for(String n : adjacencyList.get(currentVertex)){
            count += dfs(n, endVertex, adjacencyList, visit);
        }

        visit.remove(currentVertex);

        return count;
    }
}