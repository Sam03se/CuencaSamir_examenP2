import java.util.ArrayList;

public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    // a) Agregar al inicio si no existe
    public boolean agregarHeroe(SpiderverseHero heroe) {
        if (buscarPorCodigo(heroe.getCodigo()) != null) return false;

        Nodo nuevo = new Nodo(heroe);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
        return true;
    }

    // b) Buscar por código
    public SpiderverseHero buscarPorCodigo(int codigo) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getCodigo() == codigo) return aux.getDato();
            aux = aux.getSiguiente();
        }
        return null;
    }

    // c) Filtrar por poder usando recursividad
    public void filtrarPorPoderRecursivo(Nodo nodo, String poder, ArrayList<SpiderverseHero> resultado) {
        if (nodo == null) return;
        if (nodo.getDato().getPoderEspecial().equalsIgnoreCase(poder)) {
            resultado.add(nodo.getDato());
        }
        filtrarPorPoderRecursivo(nodo.getSiguiente(), poder, resultado);
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    // d) Método para obtener la lista como ArrayList (para JTable)
    public ArrayList<SpiderverseHero> obtenerTodos() {
        ArrayList<SpiderverseHero> lista = new ArrayList<>();
        Nodo aux = cabeza;
        while (aux != null) {
            lista.add(aux.getDato());
            aux = aux.getSiguiente();
        }
        return lista;
    }

    // e) Burbuja por nivel de experiencia
    public ArrayList<SpiderverseHero> filtrarSinPoderYOrdenar(String poder) {
        ArrayList<SpiderverseHero> filtrada = new ArrayList<>();

        Nodo aux = cabeza;
        while (aux != null) {
            if (!aux.getDato().getPoderEspecial().equalsIgnoreCase(poder)) {
                filtrada.add(aux.getDato());
            }
            aux = aux.getSiguiente();
        }

        // Ordenamiento burbuja
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
}
