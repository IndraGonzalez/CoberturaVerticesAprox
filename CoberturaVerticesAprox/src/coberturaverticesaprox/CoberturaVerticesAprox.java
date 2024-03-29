
package coberturaverticesaprox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CoberturaVerticesAprox {
    private Grafo grafo;
    private List<Vertice> vertices;
    private List<Arista> aristas;
    private Set<Arista> aristasIncidentes;

    public CoberturaVerticesAprox(Grafo grafo) {
        if(!grafo.esConexo()) {
            throw new IllegalArgumentException("El grafo introducido no es conexo. No se puede "
                + "realizar el algoritmo de Cobertura de Vértices.");
        } else {
            this.grafo = grafo;
            this.vertices = new ArrayList<Vertice>();
            this.aristasIncidentes = new HashSet<Arista>();
            this.aristas = new ArrayList<Arista>();
            List<Arista> aristasGrafo = grafo.getConjuntoAristas();
            Iterator<Arista> iter = aristasGrafo.iterator();
            while(iter.hasNext()){
                aristas.add(iter.next());
            }
        }
    }
    
    public List<Vertice> ejecutar(){
        while(!aristas.isEmpty()){
            Arista aristaActual = seleccionarArista();
            Vertice u = aristaActual.getVerticeA();
            Vertice v = aristaActual.getVerticeB();
            aristasIncidentes.clear();
            obtenerIncidentes(u,v);
            vertices.add(u);
            vertices.add(v);
            eliminarAristasInicidentes();
        }
        return vertices;
    }

    private Arista seleccionarArista() {
        int posicion = (int) Math.floor(Math.random()*(aristas.size()));
        return aristas.get(posicion);
    }
    
    private void obtenerIncidentes(Vertice u, Vertice v) {
        Set<Arista> incidentes = new HashSet<Arista>();
        for (Arista arista : aristas) {
            if((arista.getVerticeA().getId() == u.getId()) || (arista.getVerticeA().getId() == v.getId()) ||
              (arista.getVerticeB().getId() == u.getId()) || (arista.getVerticeB().getId() == v.getId())){              
                aristasIncidentes.add(arista);
            }
        }
    }

    private void eliminarAristasInicidentes() {
        Iterator<Arista> iter = aristasIncidentes.iterator();
        while(iter.hasNext()){
            aristas.remove(iter.next());
        }
    }
}

