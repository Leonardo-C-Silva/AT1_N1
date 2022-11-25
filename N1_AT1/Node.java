package N1_AT1;

import java.util.HashMap;

public class Node {
	public String nomeNode;
    public HashMap<Node, Distancia> direcao = new HashMap<Node, Distancia>();
	public boolean visitado = false;

    public Node(String nomeNode) {
		this.nomeNode = nomeNode;
	}

    public String getNomeNode() {
		return this.nomeNode;
	}

	public HashMap<Node, Distancia> getDirecao() {
		return direcao;
	}

	public void adicionaDistancia(Distancia Distancia, Node destino) {
		this.direcao.put(destino, Distancia);
	}

	public void setVisitado(boolean visitado){
		this.visitado = visitado;
	}

    public String toString() {
		return nomeNode;
	}
}
