
package coberturaverticesaprox;


import coberturaverticesaprox.Grafo;
import coberturaverticesaprox.Arista;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("-------Inicio de pruebas-------");
        System.out.println("");
        System.out.println("-1er CASO- Grafo con número mínimo de aristas");
        System.out.println("---------------------------------------------");
        
        Grafo grafo1 = new Grafo(7);
        grafo1.insertaArista(new Arista(1, 2, (float) 3.4));
        grafo1.insertaArista(new Arista(2, 4, (float) 1.1));
        grafo1.insertaArista(new Arista(2, 5, (float) 50));
        grafo1.insertaArista(new Arista(2, 7, (float) 55.4));
        grafo1.insertaArista(new Arista(3,7, (float) 22));
        grafo1.insertaArista(new Arista(3, 6,(float) 7));

        System.out.println("");
        float[][] matrizAdyacente1 = grafo1.getMatrizAdyacente();
        System.out.println("Matriz Adyacente del grafo");
        printMatriz(grafo1,matrizAdyacente1);
        
        System.out.println("");
        List<Arista> conjuntoAristas1 = grafo1.getConjuntoAristas();
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(conjuntoAristas1);
        
        System.out.println("");
        System.out.println("La suma de pesos del arbol mínimo de entrada es: " + 138.9);
        System.out.println("");
        
        System.out.println("N = " + matrizAdyacente1.length);
        System.out.println("");
        
        System.out.print("Comprobación grafo entrada : ");
        comprobacionConexo(grafo1);
        System.out.println("");
        
        Kruskal kruskal1 = new Kruskal(grafo1);
        List<Arista> solucion1 = kruskal1.ejecutar();
        printSolucion(solucion1);
        
        Grafo grafoSolucion1 = creacionGrafoSolucion(solucion1);
        System.out.println("");
        
        System.out.println("La suma de pesos del arbol mínimo de salida es: " + comprobacionPesos(solucion1));
        System.out.println("");
        
        System.out.println("El número de aristas es " + solucion1.size() + " que es igual a N - 1 (" + (matrizAdyacente1.length-1) + ")");
        System.out.println("");
        
        
        System.out.print("Comprobación grafo salida : ");
        comprobacionConexo(grafoSolucion1);
        System.out.println("");
        
        System.out.println("---------------------------------------------");
        
        System.out.println("-2do CASO- Grafo con número n^2 de aristas");
        System.out.println("---------------------------------------------");
        
        Grafo grafo2 = new Grafo(5);
        grafo2.insertaArista(new Arista(1, 2, (float) 55.1));
        grafo2.insertaArista(new Arista(1, 3, (float) 84));
        grafo2.insertaArista(new Arista(1, 4, (float) 66.0003));
        grafo2.insertaArista(new Arista(1, 5, (float) 1));
       
        grafo2.insertaArista(new Arista(2, 3, (float) 4.222222222222));
        grafo2.insertaArista(new Arista(2, 4, (float) 2));
        grafo2.insertaArista(new Arista(2, 5, (float) 5.15));
        
        grafo2.insertaArista(new Arista(3, 4, (float) 3));
        grafo2.insertaArista(new Arista(3, 5, (float) 4));
       
        grafo2.insertaArista(new Arista(4, 5, (float) 111.3));
       
        System.out.println("");
        float[][] matrizAdyacente2 = grafo2.getMatrizAdyacente();
        System.out.println("Matriz Adyacente del grafo");
        printMatriz(grafo2,matrizAdyacente1);
        
        System.out.println("");
        List<Arista> conjuntoAristas2 = grafo2.getConjuntoAristas();
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(conjuntoAristas2);
        
        System.out.println("");
        System.out.println("La suma de pesos del arbol mínimo de entrada es: " + 10);
        System.out.println("");
        
        System.out.println("N = " + matrizAdyacente2.length);
        System.out.println("");
        
        System.out.print("Comprobación grafo entrada : ");
        comprobacionConexo(grafo2);
        System.out.println("");
        
        Kruskal kruskal2 = new Kruskal(grafo2);
        List<Arista> solucion2 = kruskal2.ejecutar();
        printSolucion(solucion2);
        
        Grafo grafoSolucion2 = creacionGrafoSolucion(solucion2);
        System.out.println("");
        
        System.out.println("La suma de pesos del arbol mínimo de salida es: " + comprobacionPesos(solucion2));
        System.out.println("");
        
        System.out.println("El número de aristas es " + solucion2.size() + " que es igual a N - 1 (" + (matrizAdyacente2.length-1) + ")");
        System.out.println("");
        
        System.out.print("Comprobación grafo salida : ");
        comprobacionConexo(grafoSolucion2);
        System.out.println("");
        
        System.out.println("---------------------------------------------");
        
        System.out.println("-CASOS ESPECIALES-");
        System.out.println("---------------------------------------------");
        
        System.out.println("");
        System.out.print("Comprobación de conexidad de un grafo sin aristas : ");
        Grafo grafo4 = new Grafo(2);
        comprobacionConexo(grafo4);
        
        System.out.println("");
        System.out.println("Conectar un nodo con sí mismo");
        Grafo grafo5 = new Grafo(2);
        grafo5.insertaArista(new Arista(0, 0, 1));
        
        System.out.println("");
        System.out.println("Volver a añadir una arista");
        Grafo grafo6 = new Grafo(2);
        grafo6.insertaArista(new Arista(1, 2, 2));
        grafo6.insertaArista(new Arista(2, 1, 34));
        
        System.out.println("");
        System.out.println("Conectar nodos que no existen");
        Grafo grafo7 = new Grafo(2);
        grafo7.insertaArista(new Arista(3, 5, 24));
        
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
        Grafo grafo3 = new Grafo(0);
        
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
    
    public static void printConjuntoAristas (List<Arista> conjuntoAristas){
        for (int i = 0; i < conjuntoAristas.size(); i++) {
            System.out.println(conjuntoAristas.get(i).getNodoA() + "," + conjuntoAristas.get(i).getNodoB() + " con peso " + conjuntoAristas.get(i).getPeso());
        }
    }

    private static void printSolucion(List<Arista> solucion) {
        System.out.print("El conjunto de aristas solución será: ");
        Iterator<Arista> iter = solucion.iterator();
        while(iter.hasNext()){
            Arista next = iter.next();
            System.out.print("[" + next.getNodoA() + "," + next.getNodoB() + " --> " + next.getPeso() + "] ");
        }
        System.out.println("");
    }

    private static void comprobacionConexo(Grafo grafo) {
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
}


