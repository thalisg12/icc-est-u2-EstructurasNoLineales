import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        // System.out.println("Arbol Binario PreOrden:");
        // ab.imprimirPreOrden();

        // System.out.println("Arbol Binario PosOrden:");
        // ab.imprimirPosOrden();

        // System.out.println("Arbol Binario InOrden:");
        // ab.imprimirInOrden();

        // Deber
        // booleano: imprimir si encontro o no

        // if (ab.findeValue(23)) {
        // System.out.println("Encontro el valor 23");
        // } else {
        // System.out.println("Encontro el valor 23");
        // }
        // if (ab.findeValue(77)) {
        // System.out.println("Encontro e valor 77");
        // } else {
        // System.out.println("Encontro el valor 77");
        // }

        // Peso del arbol = 8
        // Altura del arbol = 4
        // Arbol InOrder
        // 9,14,17,19,23,50,54,76
        // Arbol Binario InOrder con Alturas:
        // 9(h=2),14(h=1),17(h=3),19(h=1),23(h=2),50(h=4),54(h=1),76(h=2)
        // Arbol Binario InOrder con factor de equilibrio:
        // 9(bf=-1),14(bf=0),17(bf=0),19(bf=0),23(bf=1),50(bf=1),54(bf=0),76(bf=1)

        // Arbol esta equilibrado = TRUE
        // Existe el nodo 15 = FALSE
        // Agregamos valor = 15
        // Arbol esta equilibrado = False

        System.out.println("Peso del árbol = " + ab.getSize());

        System.out.println("\nArbol InOrden:");
        ab.imprimirInOrden();

        System.out.println("\nArbol Binario InOrden con Alturas:");
        ab.imprimirInOrdenAlturas();

        System.out.println("\nArbol Binario InOrden con factor de equilibrio:");
        ab.imprimirInOrdenBalance();

        System.out.println("\nArbol esta equilibrado = " + ab.isBalanced());

        System.out.println("\nExiste el nodo 15= " + ab.findeValue(15));

        System.out.println("\nAgregamos valor = 15");
        ab.insert(15);

        System.out.println("\nArbol esta equilibrado = " + ab.isBalanced());

        System.out.println("\nArbol InOrder con factor de equilibrio");
        ab.imprimirInOrdenBalanceYDesequilibrio();
    }

}
