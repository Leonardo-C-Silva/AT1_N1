package N1_AT1;

import java.util.ArrayList;


public class Graph {
    public ArrayList<Node> Nodes;
    public ArrayList<Node> visitados;
    public boolean direcionado;

    public Graph(boolean direcionado) {
      Nodes = new ArrayList<Node>();
      this.direcionado = direcionado;
    }

    public void adicionaNode(Node Node) {
      Nodes.add(Node);
    }
  
    public void conecta(Node Node1, Node Node2, Distancia Distancia) {
      Node1.adicionaDistancia(Distancia, Node2);
      if(!direcionado) Node2.adicionaDistancia(Distancia, Node1);
    }
  
    public String getGraph() {
      String Graph = "";

      for (Node v : Nodes) {
        Graph += v.nomeNode + " -> " + v.direcao.toString() + "\n";
      }

      return Graph;
    }

    public int getSize() {
      return Nodes.size();
    }

    public ArrayList<Node> getNodes() {
      return Nodes;
    }
}
