package N1_AT1;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
	public HashMap<Node, Integer> Nodes = new HashMap<Node, Integer>();
    public Graph Graph;
	public ArrayList<Node> GraphVerts;

    public Dijkstra(Graph Graph) {
		this.Graph = Graph;
	}

    public int getCustoMinimo(Node init, Node end) {
        GraphVerts = Graph.getNodes();

        for (int i = 0; i < Graph.getSize(); i++) {
			Nodes.put(GraphVerts.get(i), Integer.MAX_VALUE);
		}

        Nodes.put(init, 0);
        int peso, pesoNode;
		Node vert = null;
        HashMap<Node, Distancia> Distancias = null;
		Object[] direcao;

        while(!graphEnded()){
            vert = getMenorNode();
			vert.setVisitado(true);
			Distancias = vert.getDirecao();
			direcao = Distancias.keySet().toArray();
            pesoNode = Nodes.get(vert);
            for (int i = 0; i < Distancias.size(); i++) {
				peso = Distancias.get(direcao[i]).getPeso();
				if ((pesoNode + peso) < Nodes.get((Node)direcao[i])) {
					Nodes.put((Node)direcao[i], pesoNode + peso);
				}
			}
        }

        return Nodes.get(end);
    }

    private Node getMenorNode() {
        Integer menor = Integer.MAX_VALUE;
		Integer aux;
		Node vertMenor = null;

		for (int i = 0; i < Graph.getSize(); i++) {
			aux = Nodes.get(GraphVerts.get(i));
			if (aux <= menor && !GraphVerts.get(i).visitado) {
				menor = aux;
				vertMenor = GraphVerts.get(i);
			}
		}

		return vertMenor;
    }

    private boolean graphEnded() {
        ArrayList<Node> visitados = new ArrayList<Node>();

		for (int i = 0; i < Graph.getSize(); i++) {
			if (!GraphVerts.get(i).visitado) {
				return false;
			}
		}
		return true;
	}
}
