package estructura;

import modelo.SpiderverseHero;
import java.util.ArrayList;

public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    // Agregar héroe al inicio si no existe
    public boolean agregarHeroe(SpiderverseHero h) {
        if (buscarPorCodigo(h.getCodigo()) != null) return false;
        Nodo nuevo = new Nodo(h);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
        return true;
    }

    // Buscar héroe por código
    public SpiderverseHero buscarPorCodigo(int codigo) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getCodigo() == codigo) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    // Obtener todos los héroes en una lista (para mostrar en tabla)
    public ArrayList<SpiderverseHero> obtenerTodos() {
        ArrayList<SpiderverseHero> lista = new ArrayList<>();
        Nodo aux = cabeza;
        while (aux != null) {
            lista.add(aux.getDato());
            aux = aux.getSiguiente();
        }
        return lista;
    }

    // Filtrar con recursividad los que SÍ tienen un poder específico
    public void filtrarPorPoderRecursivo(Nodo nodo, String poder, ArrayList<SpiderverseHero> resultado) {
        if (nodo == null) return;
        if (nodo.getDato().getPoderEspecial().equalsIgnoreCase(poder)) {
            resultado.add(nodo.getDato());
        }
        filtrarPorPoderRecursivo(nodo.getSiguiente(), poder, resultado);
    }

    // Obtener lista de los que NO tienen un poder, ordenada por experiencia (burbuja)
    public ArrayList<SpiderverseHero> filtrarSinPoderYOrdenar(String poder) {
        ArrayList<SpiderverseHero> filtrada = new ArrayList<>();
        Nodo aux = cabeza;
        while (aux != null) {
            if (!aux.getDato().getPoderEspecial().equalsIgnoreCase(poder)) {
                filtrada.add(aux.getDato());
            }
            aux = aux.getSiguiente();
        }

        // Ordenamiento por burbuja
        for (int i = 0; i < filtrada.size() - 1; i++) {
            for (int j = 0; j < filtrada.size() - i - 1; j++) {
                if (filtrada.get(j).getNivelExperiencia() > filtrada.get(j + 1).getNivelExperiencia()) {
                    SpiderverseHero temp = filtrada.get(j);
                    filtrada.set(j, filtrada.get(j + 1));
                    filtrada.set(j + 1, temp);
                }
            }
        }

        return filtrada;
    }

    // Obtener la cabeza para funciones recursivas
    public Nodo getCabeza() {
        return cabeza;
    }
}
