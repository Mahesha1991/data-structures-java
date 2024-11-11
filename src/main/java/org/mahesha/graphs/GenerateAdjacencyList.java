package org.mahesha.graphs;

import org.mahesha.RandomGenerator;

import java.util.*;

public class GenerateAdjacencyList {


    /*
    Other way to represent graph is adjacency list
    Here either we can have custom data structure just like in trees (instead of left and right subtree); we will have
    int data:
    LinkedList of Nodes;
    But this would be more complex; instead we will have a Map where the Keys are vertices in the graph and Values are
    list of other Vertices that the key vertex connects to
     */
    public static Map<String, Set<String>> getList(int noOfVertex, int noOfEdgesPerVertex){

        Map<String, Set<String>> adjacencyMap = new HashMap<>();
        if(noOfEdgesPerVertex > noOfVertex){
            noOfEdgesPerVertex = noOfVertex;
        }

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        int v = RandomGenerator.generateNumber(1, noOfVertex);

        for(int i = 0; i < v; i++){

            char alpha = characters.charAt(RandomGenerator.generateNumber(0, characters.length()));
            char num = numbers.charAt((RandomGenerator.generateNumber(0, numbers.length())));
            adjacencyMap.put("" + alpha + num, new HashSet<>());
        }


        ArrayList<String> vertexKey = new ArrayList<>(adjacencyMap.keySet());

        for(String vertex : vertexKey){
            Set<String> edges = adjacencyMap.get(vertex);
            for(int j = 0; j < noOfEdgesPerVertex; j++){
                int index = RandomGenerator.generateNumber(0, vertexKey.size());
                edges.add(vertexKey.get(index));
            }
        }

        System.out.println(adjacencyMap);

        return adjacencyMap;

    }
}
