package N1_AT1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App_N1 {

	
	public static void main(String[] args) throws Exception {

        List<Node> Nodes = new ArrayList<Node>();
        boolean direcionado = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\safha\\file.txt"));
        
            String line = reader.readLine();
            System.out.println("Direcionado? " + line);
            String isDirecionado = line;

            if(isDirecionado.toLowerCase().equals("s")){
                direcionado = true;
            }

            line = reader.readLine();

            int numeroDeNodes = Integer.parseInt(line);
            line = reader.readLine();

            for(int i = 0; i < numeroDeNodes; i++){
                Node Node = new Node(line.trim());
                Nodes.add(Node);
                line = reader.readLine();
            }

            Graph Graph = new Graph(direcionado);
            for(Node v : Nodes){
                Graph.adicionaNode(v);
            }

            while(line != null){
                line = line.replaceAll(" ", "");
                System.out.println(line);
                String s1 = line.split(",")[0].toString();
                String s2 = line.split(",")[1].toString();

                int peso = Integer.parseInt(line.split(",")[2]);

                boolean foundV1 = false;
                boolean foundV2 = false;
                int indexOfV1 = -1;
                int indexOfV2 = -1;
                for(Node v : Nodes){
                    if(v.nomeNode.equals(s1)){
                        foundV1 = true;
                        indexOfV1 = Nodes.indexOf(v);

                    } else if(v.nomeNode.equals(s2)){
                        foundV2 = true;
                        indexOfV2 = Nodes.indexOf(v);
                    }

                    if(foundV1 && foundV2){
                        System.out.println("______");

                        Graph.conecta(Nodes.get(indexOfV1), Nodes.get(indexOfV2), new Distancia(peso));
                        foundV1 = false;
                        foundV2 = false;
                    }
                }

                line = reader.readLine();
            }
            reader.close();

            //System.out.println(Nodes);
            
            System.out.println(Graph.getGraph());

            //Dijkstra
            Dijkstra dijkstra = new Dijkstra(Graph);
            System.out.println(dijkstra.getCustoMinimo(Nodes.get(0), Nodes.get(Nodes.size() - 1)));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
