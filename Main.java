package com.mycompany.graph2;
import java.util.*;

public class Main {
     public static void main(String[] args) {
         
         Graph graph = new Graph();
         
          // Adiciona vértices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Adiciona arestas
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        // Realiza a busca em largura
        List<Vertex> result = graph.bfs("A");
    }
}
