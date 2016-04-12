
package coberturaverticesaprox;


import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n############  Inicio de pruebas  ############");
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
        
        
        System.out.println("\nMatriz Adyacente del grafo\n");
        printMatriz(grafo1,grafo1.getMatrizAdyacente());
        
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(grafo1.getConjuntoAristas());
        
        System.out.println("\nEl conjunto de vértices de la solución ÓPTIMA será: [2 5]");
        
        CoberturaVerticesAprox algoritmo = new CoberturaVerticesAprox(grafo1);
        List<Vertice> solucion = algoritmo.ejecutar();
        printSolucion(solucion);
        
        System.out.println("Comprobación de que el tamaño de la solución está dentro del error: ");
        testSolucionSize(solucion.size(),2);
        
        System.out.println("Comprobación de la validez de la solución: ");
        testSolucion(solucion,grafo1);

        System.out.println("---------------------------------------------\n");
        
        System.out.println("---------------------------------------------");
        System.out.println("-2º CASO-");
        System.out.println("---------------------------------------------");
        
        Grafo grafo2 = new Grafo(7);
        
        Vertice vertice6 = new Vertice(6);
        Vertice vertice7 = new Vertice(7);
        
        grafo2.insertaVertice(vertice1);
        grafo2.insertaVertice(vertice2);
        grafo2.insertaVertice(vertice3);
        grafo2.insertaVertice(vertice4);
        grafo2.insertaVertice(vertice5);
        grafo2.insertaVertice(vertice6);
        grafo2.insertaVertice(vertice7);
        
        grafo2.insertaArista(new Arista(vertice6,vertice1));
        grafo2.insertaArista(new Arista(vertice2,vertice6));
        grafo2.insertaArista(new Arista(vertice6,vertice3));
        grafo2.insertaArista(new Arista(vertice4,vertice6));
        grafo2.insertaArista(new Arista(vertice6,vertice5));
        grafo2.insertaArista(new Arista(vertice7,vertice6));
        
        
        System.out.println("\nMatriz Adyacente del grafo\n");
        printMatriz(grafo2,grafo2.getMatrizAdyacente());
        
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(grafo2.getConjuntoAristas());
        
        System.out.println("\nEl conjunto de vértices de la solución ÓPTIMA será: [6]");
        
        CoberturaVerticesAprox algoritmo2 = new CoberturaVerticesAprox(grafo2);
        List<Vertice> solucion2 = algoritmo2.ejecutar();
        printSolucion(solucion2);
        
        System.out.println("Comprobación de que el tamaño de la solución está dentro del error: ");
        testSolucionSize(solucion2.size(),1);
        
        System.out.println("Comprobación de la validez de la solución: ");
        testSolucion(solucion2,grafo2);
        
        System.out.println("---------------------------------------------\n");
        
        System.out.println("---------------------------------------------");
        System.out.println("-3er CASO-");
        System.out.println("---------------------------------------------");
        
        Grafo grafo3 = new Grafo(6);
        
        grafo3.insertaVertice(vertice1);
        grafo3.insertaVertice(vertice2);
        grafo3.insertaVertice(vertice3);
        grafo3.insertaVertice(vertice4);
        grafo3.insertaVertice(vertice5);        
        grafo3.insertaVertice(vertice6);      
        
        grafo3.insertaArista(new Arista(vertice1,vertice2));
        grafo3.insertaArista(new Arista(vertice2,vertice3));
        grafo3.insertaArista(new Arista(vertice3,vertice4));
        grafo3.insertaArista(new Arista(vertice4,vertice5));
        grafo3.insertaArista(new Arista(vertice5,vertice6));
        
        System.out.println("\nMatriz Adyacente del grafo\n");
        printMatriz(grafo3,grafo3.getMatrizAdyacente());
        
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(grafo3.getConjuntoAristas());
        
        System.out.println("\nEl conjunto de vértices de la solución ÓPTIMA será: [2 4 6]");
        
        CoberturaVerticesAprox algoritmo3 = new CoberturaVerticesAprox(grafo3);
        List<Vertice> solucion3 = algoritmo3.ejecutar();
        printSolucion(solucion3);
        
        System.out.println("Comprobación de que el tamaño de la solución está dentro del error: ");
        testSolucionSize(solucion3.size(),3);
        
        System.out.println("Comprobación de la validez de la solución: ");
        testSolucion(solucion3,grafo3);
        
        System.out.println("---------------------------------------------\n");
        
        /* Para probar los casos en que se lanzan excepciones, habría
         * que descomentar una de la secciones y dejar las otras comentadas
         * para que se pueda ejecutar y se puedan lanzar las exepciones
         * sin problemas.
        */
       
        /*
        System.out.println("---------------------------------------------");
        System.out.println("-Excepción 1-");
        System.out.println("---------------------------------------------");
        
        System.out.println("");
        System.out.println("Grafo no conexo");
        Grafo grafo5 = new Grafo(2);
        CoberturaVerticesAprox noConexo = new CoberturaVerticesAprox(grafo5);
        noConexo.ejecutar();
      
        System.out.println("---------------------------------------------");
        System.out.println("-Excepción 2-");
        System.out.println("---------------------------------------------");
        
        System.out.println("");
        System.out.println("Grafo con número de nodos menor a 1");
        Grafo grafo6 = new Grafo(0);
        
        System.out.println("---------------------------------------------");
        System.out.println("-Excepción 3-");
        System.out.println("---------------------------------------------");
        
        System.out.println("");
        System.out.println("Añadir un vértice fuera del rango del grafo");
        grafo1.insertaVertice(new Vertice(80));
        
        System.out.println("---------------------------------------------");
        System.out.println("-Excepción 4-");
        System.out.println("---------------------------------------------");
        
        System.out.println("");
        System.out.println("Añadir un vértice dos veces");
        grafo1.insertaVertice(vertice1);
        
        */
       
        System.out.println("---------------------------------------------");
        System.out.println("-Errores-");
        System.out.println("---------------------------------------------");
        
        
        System.out.println("\nConectar un vértice a si mismo:");
        grafo1.insertaArista(new Arista(vertice1,vertice1));
        
        System.out.println("\nConectar un vértice que no pertenece al grafo:");
        Grafo grafo10 = new Grafo(10);
        grafo10.insertaVertice(vertice1);
        grafo1.insertaArista(new Arista(vertice1,new Vertice(10)));
        
        System.out.println("\nInsertar aristas repetidas:");
        grafo1.insertaArista(new Arista(vertice1,vertice2));
        
        
        
    }
    
    public static void printMatriz(Grafo grafo, float[][] matrizAdyacente){
        for (int i = 0; i < matrizAdyacente.length; i++) {
            for (int j = 0; j < matrizAdyacente[1].length; j++) {
                System.out.print(matrizAdyacente[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void printConjuntoAristas (List<Arista> conjuntoAristas){
        System.out.print("\n[ ");
        for (int i = 0; i < conjuntoAristas.size(); i++) {
            System.out.print("(" + conjuntoAristas.get(i).getVerticeA().getId() + "," + conjuntoAristas.get(i).getVerticeB().getId() + ") ");
        }
        System.out.println("]");
    }

    private static void printSolucion(List<Vertice> solucion) {
        System.out.print("\nEl conjunto de vértices solución usando un ALGORTIMO DE APROXIMACIÓN será: ");
        Iterator<Vertice> iter = solucion.iterator();
        String aristas = "[";
        while(iter.hasNext()){
            Vertice next = iter.next();
            aristas += next.getId() + " ";
        }
        aristas = aristas.substring(0, aristas.length()-1);
        aristas += "]";
        System.out.println(aristas + "\n");
    }

    private static void testSolucionSize(int size, int sizeOptima) {
        if(size <= 2*sizeOptima){
            System.out.println("El tamaño de la solución es CORRECTO, puesto que a lo sumo el doble del de la solución óptima.\n");
        } else {
            System.out.println("El tamaño de la solución es INCORRECTO, puesto que mayor al doble del de la solución óptima.\n");
        }
    }

    private static void testSolucion(List<Vertice> solucion, Grafo grafo) {
        float[][] matriz = grafo.getMatrizAdyacente();
        int[] test = new int[matriz.length];
        
        Iterator<Vertice> iter = solucion.iterator();
        while(iter.hasNext()){
            int next = iter.next().getId()-1;
            for (int i = 0; i < matriz.length; i++) {
                if(matriz[next][i] == 1){
                    test[i] = 1;
                } 
            }
        }
        int count = 0;
        for (int i = 0; i < test.length; i++) {
            if(test[i] == 1) count++;
        }
        if(count == test.length){
            System.out.println("LA SOLUCIÓN ES CORRECTA :) ");
        } else {
            System.out.println("LA SOLUCIÓN ES INCORRECTA :( ");
        }
        
    }
       
}


