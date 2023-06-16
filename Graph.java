package com.mycompany.graph2;
  import java.util.*;

public class Graph {
  
  private List<Vertex> vertices = new LinkedList<>();

  protected Vertex findVertex(String value) {
    for (Vertex vertex : vertices) {
      if (vertex.getLabel().equals(value)) {
        return vertex;
      }
    }
    return null;
  }

  public void addVertex(String value) {
    if (findVertex(value) == null) {
      vertices.add(new Vertex(value));
    }
  }

  public void addEdge(String valA, String valB) {
    Vertex vertexA = findVertex(valA);
    Vertex vertexB = findVertex(valB);
    if (vertexA != null && vertexB != null) {
      vertexA.addEdge(vertexB);
      vertexB.addEdge(vertexA);
    }
  }

  public List<Vertex> bfs(String startValue) {
    Vertex startVertex = findVertex(startValue);
    if (startVertex == null) {
      return null;
    }
    
    List<Vertex> result = new ArrayList<>();
    Queue<Vertex> queue = new LinkedList<>();
    Set<Vertex> visited = new HashSet<>();

    queue.add(startVertex);
    visited.add(startVertex);

    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.poll();
      result.add(currentVertex);

      for (Vertex neighbor : currentVertex.getNeighbors()) {
        if (!visited.contains(neighbor)) {
          queue.add(neighbor);
          visited.add(neighbor);
        }
      }
    }
    

    if (result != null) {
        System.out.println("Ordem de visita dos vértices:");

    for (Vertex vertex : result) {
        System.out.println(vertex.getLabel());
    }
    } else if(result == null){
        System.out.println("O vértice de partida não foi encontrado.");
    }

    return result;
  }
}

class Vertex {
  private String label;
  private List<Vertex> neighbors = new ArrayList<>();

  public Vertex(String label) {
    setLabel(label);
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public void addEdge(Vertex vertex) {
    this.neighbors.add(vertex);
  }

  public List<Vertex> getNeighbors() {
    return neighbors;
  }

  @Override
  public String toString() {
    return "Label: " + label;
  }
}

    
   

