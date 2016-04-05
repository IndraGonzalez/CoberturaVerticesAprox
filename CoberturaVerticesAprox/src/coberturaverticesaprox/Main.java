
package coberturaverticesaprox;


import coberturaverticesaprox.Grafo;
import coberturaverticesaprox.Arista;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------Inicio de pruebas-------");
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("-1er CASO-");
        System.out.println("---------------------------------------------");
        
        Grafo grafo1 = new Grafo(5);
        
        Vertice vertice1 = new Vertice(1);
        Vertice vertice2 = new Vertice(2);
        Vertice vertice3 = new Vertice(3);
        Vertice vertice4 = new Vertice(4);
        Vertice vertice5 = new Vertice(5);
        
        grafo1.insertaVertice(vertice1);
        grafo1.insertaVertice(vertice2);
        grafo1.insertaVertice(vertice3);
        grafo1.insertaVertice(vertice4);
        grafo1.insertaVertice(vertice5);
        
        grafo1.insertaArista(new Arista(vertice2,vertice1));
        grafo1.insertaArista(new Arista(vertice2,vertice5));
        grafo1.insertaArista(new Arista(vertice2,vertice4));
        grafo1.insertaArista(new Arista(vertice2,vertice3));
        grafo1.insertaArista(new Arista(vertice5,vertice1));
        grafo1.insertaArista(new Arista(vertice5,vertice4));
        
        
        System.out.println("");
        System.out.println("Matriz Adyacente del grafo");
        System.out.println("");
        grafo1.printMatriz();
        System.out.println("");
        
        CoberturaVerticesAprox algoritmo = new CoberturaVerticesAprox(grafo1);
        
        List<Vertice> solucion = algoritmo.ejecutar();
        System.out.println("");
        printSolucion(solucion);
        System.out.println("");
        
        /* Para probar los dos casos en que se lanzan excepciones, habría
         * que comentar una de la secciones y dejar la otra sin comentar
         * para que se pueda ejecutar y se puedan lanzar las dos exepciones
         * sin problemas. 
        */
        
        /*System.out.println("");
        System.out.println("Ejecutar Kruskal con un grafo no conexo");
        Grafo grafo8 = new Grafo(2);
        Kruskal kruskal3 = new Kruskal(grafo8);
        kruskal3.ejecutar();
        
        System.out.println("");
        System.out.println("Grafo con número de nodos menor a 1");
        Grafo grafo3 = new Grafo(0);*/
        
        System.out.println("---------------------------------------------");
        
    }
    
    public static void printMatriz(Grafo grafo, float[][] matrizAdyacente){
        for (int i = 0; i < matrizAdyacente.length; i++) {
            for (int j = 0; j < matrizAdyacente[1].length; j++) {
                System.out.print(matrizAdyacente[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    /*public static void printConjuntoAristas (List<Arista> conjuntoAristas){
        for (int i = 0; i < conjuntoAristas.size(); i++) {
            System.out.println(conjuntoAristas.get(i).getNodoA() + "," + conjuntoAristas.get(i).getNodoB() + " con peso " + conjuntoAristas.get(i).getPeso());
        }
    }*/

    private static void printSolucion(List<Vertice> solucion) {
        System.out.print("El conjunto de aristas solución será: ");
        Iterator<Vertice> iter = solucion.iterator();
        System.out.print("[");
        while(iter.hasNext()){
            Vertice next = iter.next();
            System.out.print(next.getId() + " ");
        }
        System.out.println("]");
    }

    /*private static void comprobacionConexo(Grafo grafo) {
        if(grafo.esConexo()) System.out.print("Es conexo.");
        else System.out.print("No es conexo.");
        System.out.println("");
    }

    private static Grafo creacionGrafoSolucion(List<Arista> solucion) {
        Grafo grafoSolucion = new Grafo(solucion.size() + 1); 
        Iterator<Arista> iter = solucion.iterator();
        while(iter.hasNext()){
            Arista next = iter.next();
            grafoSolucion.insertaArista(next);
        }
        return grafoSolucion;
    }

    private static float comprobacionPesos(List<Arista> solucion) {
        Iterator<Arista> iter = solucion.iterator();
        float pesos = 0;
        while(iter.hasNext()){
            pesos += iter.next().getPeso();
        }
        return pesos;
    }*/
       
}


