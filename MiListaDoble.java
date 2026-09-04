public class MiListaDoble implements ListInterface {

    private DoubleNode cabeza;
    private DoubleNode cola;
    private int tamano;

    @Override
    public Object getHead() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (cabeza == null) {
            return null;
        }
        return cola.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(object)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamano++;
        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }

        DoubleNode nuevo = new DoubleNode(object);

        nuevo.anterior = node;
        nuevo.siguiente = node.siguiente;

        if (node.siguiente != null) {
            node.siguiente.anterior = nuevo;
        } else {
            cola = nuevo;
        }

        node.siguiente = nuevo;

        tamano++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode nodoReferencia = search(objectRef);

        if (nodoReferencia == null) {
            return false;
        }

        DoubleNode nuevo = new DoubleNode(object);

        nuevo.anterior = nodoReferencia;
        nuevo.siguiente = nodoReferencia.siguiente;

        if (nodoReferencia.siguiente != null) {
            nodoReferencia.siguiente.anterior = nuevo;
        } else {
            cola = nuevo;
        }

        nodoReferencia.siguiente = nuevo;

        tamano++;
        return true;
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevo = new DoubleNode(object);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevo = new DoubleNode(object);

        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }

        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null) {
            return false;
        }

        if (node.anterior != null) {
            node.anterior.siguiente = node.siguiente;
        } else {
            // el nodo era la cabeza
            cabeza = node.siguiente;
        }

        if (node.siguiente != null) {
            node.siguiente.anterior = node.anterior;
        } else {
            // el nodo era la cola
            cola = node.anterior;
        }

        tamano--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        DoubleNode actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(object)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[tamano];

        DoubleNode actual = cabeza;
        int i = 0;

        while (actual != null) {
            arreglo[i] = actual.dato;
            actual = actual.siguiente;
            i++;
        }

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object.length < tamano) {
            object = new Object[tamano];
        }

        DoubleNode actual = cabeza;
        int i = 0;

        while (actual != null) {
            object[i] = actual.dato;
            actual = actual.siguiente;
            i++;
        }

        // si el arreglo recibido era más grande que la lista,
        // se marca el final con null
        if (object.length > tamano) {
            object[tamano] = null;
        }

        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sublista = new MiListaDoble();
        if (from == null || to == null) {
            return sublista;
        }

        DoubleNode actual = from;

        while (actual != null) {
            sublista.insertTail(actual.dato);

            if (actual == to) {
                break;
            }

            actual = actual.siguiente;
        }

        return sublista;
    }

    @Override
    public MiListaDoble sortList() {
        MiListaDoble listaOrdenada = new MiListaDoble();


        Object[] arreglo = this.toArray();

        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                Comparable actual = (Comparable) arreglo[j];
                Comparable siguiente = (Comparable) arreglo[j + 1];

                if (actual.compareTo(siguiente) > 0) {

                    Object temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }


        for (Object dato : arreglo) {
            listaOrdenada.insertTail(dato);
        }

        return listaOrdenada;
    }
}




