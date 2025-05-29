public class Nodo {
    SpiderverseHero dato;
    Nodo siguiente;

    public Nodo(SpiderverseHero dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public SpiderverseHero getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
