package estructura;

import modelo.SpiderverseHero;

public class Nodo {
    private SpiderverseHero dato;
    private Nodo siguiente;

    public Nodo(SpiderverseHero dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public SpiderverseHero getDato() {
        return dato;
    }

    public void setDato(SpiderverseHero dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
