//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();

        // --- isEmpty / getSize antes de agregar nada ---
        System.out.println("¿Vacía al inicio? " + lista.isEmpty()); // true
        System.out.println("Tamaño inicial: " + lista.getSize());   // 0

        // --- add / insertHead / insertTail ---
        lista.add(20);          // 20
        lista.add(30);          // 20 -> 30
        lista.insertHead(10);   // 10 -> 20 -> 30
        lista.insertTail(40);   // 10 -> 20 -> 30 -> 40

        System.out.println("\n--- Después de add / insertHead / insertTail ---");
        imprimir(lista);

        // --- getHead / getTail ---
        System.out.println("\nHead: " + lista.getHead()); // 10
        System.out.println("Tail: " + lista.getTail());   // 40

        // --- search / contains / get(node) ---
        DoubleNode nodo20 = lista.search(20);
        System.out.println("\n¿Contiene 20? " + lista.contains(20));   // true
        System.out.println("¿Contiene 99? " + lista.contains(99));     // false
        System.out.println("get(nodo20): " + lista.get(nodo20));       // 20

        // --- insert(DoubleNode, Object) ---
        lista.insert(nodo20, 25); // 10 -> 20 -> 25 -> 30 -> 40
        System.out.println("\n--- Después de insert(nodo20, 25) ---");
        imprimir(lista);

        // --- insert(Object, Object) ---
        lista.insert(30, 35); // 10 -> 20 -> 25 -> 30 -> 35 -> 40
        System.out.println("\n--- Después de insert(30, 35) ---");
        imprimir(lista);

        // --- set(node, object) ---
        DoubleNode nodo25 = lista.search(25);
        lista.set(nodo25, 99); // 10 -> 20 -> 99 -> 30 -> 35 -> 40
        System.out.println("\n--- Después de set(nodo25, 99) ---");
        imprimir(lista);

        // --- remove(node) ---
        lista.remove(lista.search(99)); // 10 -> 20 -> 30 -> 35 -> 40
        System.out.println("\n--- Después de remove(99) ---");
        imprimir(lista);

        // --- toArray() ---
        System.out.println("\ntoArray(): ");
        Object[] arreglo = lista.toArray();
        for (Object o : arreglo) {
            System.out.print(o + " ");
        }
        System.out.println();

        // --- toArray(Object[]) ---
        Object[] arregloGrande = lista.toArray(new Object[8]);
        System.out.println("\ntoArray(arreglo más grande): ");
        for (Object o : arregloGrande) {
            System.out.print(o + " ");
        }
        System.out.println();

        // --- subList(from, to) ---
        DoubleNode desde = lista.search(20);
        DoubleNode hasta = lista.search(35);
        MiListaDoble sub = lista.subList(desde, hasta);
        System.out.println("\nsubList(20, 35): ");
        imprimir(sub);

        // --- sortList() ---
        MiListaDoble desordenada = new MiListaDoble();
        desordenada.add(50);
        desordenada.add(10);
        desordenada.add(30);
        desordenada.add(20);
        desordenada.add(40);

        System.out.println("\n--- Lista desordenada ---");
        imprimir(desordenada);

        MiListaDoble ordenada = desordenada.sortList();
        System.out.println("\n--- Lista ordenada ---");
        imprimir(ordenada);

        // --- clear() ---
        lista.clear();
        System.out.println("\n¿Vacía después de clear()? " + lista.isEmpty()); // true
        System.out.println("Tamaño después de clear(): " + lista.getSize());   // 0
    }

    // Método auxiliar para imprimir cualquier lista usando toArray()
    private static void imprimir(MiListaDoble l) {
        Object[] datos = l.toArray();
        for (Object dato : datos) {
            System.out.print(dato + " ");
        }
        System.out.println();
    }
}