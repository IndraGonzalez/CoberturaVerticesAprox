
package coberturaverticesaprox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
            this.aristasIncidentes = new TreeSet<Arista>();
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
            aristasIncidentes = obtenerIncidentes(u,v);
            vertices.add(u);
            vertices.add(v);
            eliminarAristasInicidentes();
        }
        return vertices;
    }

    private Arista seleccionarArista() {
        int posicion = (int) Math.floor(Math.random()*(aristas.size() + 1));
        return aristas.get(posicion);
    }
    
    private Set<Arista> obtenerIncidentes(Vertice u, Vertice v) {
        Set<Arista> incidentes = new TreeSet<>();
        for (Arista incidente : incidentes) {
            if((incidente.getVerticeA().getId() == u.getId()) || (incidente.getVerticeA().getId() == v.getId()) ||
              (incidente.getVerticeB().getId() == u.getId()) || (incidente.getVerticeB().getId() == v.getId())){
                
                incidentes.add(incidente);
            }
        }
        return incidentes;
    }

    private void eliminarAristasInicidentes() {
        Iterator<Arista> iter = aristasIncidentes.iterator();
        while(iter.hasNext()){
            aristas.remove(iter.next());
        }
    }
}

