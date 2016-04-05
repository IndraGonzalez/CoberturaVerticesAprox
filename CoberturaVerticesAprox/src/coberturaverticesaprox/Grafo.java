
package coberturaverticesaprox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Grafo {
    private float[][] matrizAdyacente;
    private List<Arista> conjuntoAristas;
    private List<Vertice> conjuntoVertices;
 
    public Grafo(int numeroVertices) {
        if(numeroVertices > 1) {
            matrizAdyacente = new float[numeroVertices][numeroVertices];
            conjuntoAristas = new LinkedList<>();
            conjuntoVertices = new ArrayList(numeroVertices);
        } else {
            throw new IllegalArgumentException("El número de vértices debe ser mayor que cero.");
        }
    }
    
    public void insertaArista(Arista arista){
        for (Vertice conjuntoVertice : conjuntoVertices) {
            if((arista.getVerticeA().getId() > matrizAdyacente.length) || (arista.getVerticeB().getId() > matrizAdyacente.length)){
                System.out.println("Los vértices que intenta conectar no pertecen al grafo.");
                return;
            }
        }
            
        if(arista.getVerticeA().getId() == arista.getVerticeB().getId()){
            System.out.println("No se puede conectar un vértice con si mismo. ");
            return;
        }
        
        if ((matrizAdyacente[arista.getVerticeA().getId()-1][arista.getVerticeB().getId()-1] == 0) && (matrizAdyacente[arista.getVerticeB().getId()-1][arista.getVerticeA().getId()-1] == 0)){
            matrizAdyacente[arista.getVerticeA().getId()-1][arista.getVerticeB().getId()-1]= 1;
            matrizAdyacente[arista.getVerticeB().getId()-1][arista.getVerticeA().getId()-1]= 1;
            conjuntoAristas.add(arista);
        } else {
            System.out.println("ERROR : No se ha insertado la arista.");
            System.out.println("Ya existe una arista entre los vértices " + arista.getVerticeA()
                + " y " + arista.getVerticeB());
        }
    }
    
    public void insertaVertice(Vertice vertice){
        if((vertice.getId() < 1) || (vertice.getId() > matrizAdyacente.length)){
            throw new IllegalArgumentException("El número del vertice no pertece al rango del grafo.");
        }
        for (Vertice conjuntoVertice : conjuntoVertices) {
            if (conjuntoVertice.getId() == vertice.getId()) {
                throw new IllegalArgumentException("Este vértice ya pertenece al grafo.");
            }
        }
        conjuntoVertices.add(vertice);
    }
    
    public float getPeso(Vertice verticeA, Vertice verticeB){
        return matrizAdyacente[verticeA.getId()-1][verticeB.getId()-1];
    }

    public int getNumeroAristas() {
        return conjuntoAristas.size();
    }

    public List<Arista> getConjuntoAristas() {
        return conjuntoAristas;
    }

    public List<Vertice> getConjuntoVertices() {
        return conjuntoVertices;
    }
    
    public float[][] getMatrizAdyacente() {
        return matrizAdyacente;
    }
    
    public int getNumeroNodos (){
        return matrizAdyacente.length;
    }
    
    public void printMatriz(){
        for (float[] matrizAdyacente1 : matrizAdyacente) {
            for (int j = 0; j < matrizAdyacente[1].length; j++) {
                System.out.print(matrizAdyacente1[j] + " ");
            }
            System.out.println("");
        }
    }
    
    public boolean esConexo(){
        Set<Integer> nodosVisitados = new TreeSet<>();
        Set<Integer> nodosAVisitar = new TreeSet<>();
        int count = 0;
        for (int i = 0; i < matrizAdyacente.length; i++) {
            for(int j = 0; j < matrizAdyacente[0].length; j++){
                if(i == 0){
                    if((j != 0) && (matrizAdyacente[i][j] != 0)){
                        nodosAVisitar.add(j);
                    } else {
                        count++;
                    } 
                } else {
                    if(matrizAdyacente[i][j] == 0 ){
                        count++;
                    }
                }
            }
            if(count == matrizAdyacente.length){
                return false;
            }
            count = 0;
        }
        nodosVisitados.add(0);
        recursivoAuxiliar(nodosVisitados,nodosAVisitar);
        return nodosVisitados.size() == matrizAdyacente.length-1;
    }
    
    private void recursivoAuxiliar (Set<Integer> nodosVisitados, Set<Integer> nodosAVisitar){
        
        if((nodosVisitados.size() == matrizAdyacente.length-1) || (nodosAVisitar.isEmpty())){
            return;
        }
            
        Iterator iter = nodosAVisitar.iterator();
        int i = (int) iter.next();

        for (int j = 0; j < matrizAdyacente[1].length; j++) {
            if(matrizAdyacente[i][j] != 0){
                if((!nodosVisitados.contains(j))){
                    nodosAVisitar.add(j);
                }
            }
        }
        nodosVisitados.add(i);
        nodosAVisitar.remove(i);
        recursivoAuxiliar(nodosVisitados,nodosAVisitar);
    }
    
}

