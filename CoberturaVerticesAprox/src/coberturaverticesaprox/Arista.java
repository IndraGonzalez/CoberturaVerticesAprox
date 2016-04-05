
package coberturaverticesaprox;

public class Arista {
    private final Vertice verticeA;
    private final Vertice verticeB;

    public Arista(Vertice verticeA, Vertice verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public Vertice getVerticeA() {
        return verticeA;
    }

    public Vertice getVerticeB() {
        return verticeB;
    }
    
    @Override 
    public int hashCode(){
        int result = 17;
        result = 31 * result + verticeA.getId();
        result = 31 * result + verticeB.getId();
        return result;
    }
    
}

