package Materia.controllers;

import Materia.models.Node;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValor()) {
            padre.setIzquierda(insertRec(padre.getIzquierda(), value));
        } else if (value > padre.getValor()) {
            padre.setDerecha(insertRec(padre.getDerecha(), value));
        }
        return padre;
    }

    public void imprimirPreOrden() {
        printPreOrdenRec(root);
        System.out.println();
    }

    private void printPreOrdenRec(Node node) {
        if (node != null) {
            System.out.print(node.getValor() + ",");
            printPreOrdenRec(node.getIzquierda());
            printPreOrdenRec(node.getDerecha());
        }
    }

    public void imprimirPosOrden() {
        printPosOrdenRec(root);
        System.out.println();
    }

    private void printPosOrdenRec(Node node) {
        if (node != null) {
            printPosOrdenRec(node.getIzquierda());
            System.out.print(node.getValor() + "(h=" + getHeightRec(node) + "),");
            printPosOrdenRec(node.getDerecha());
        }
    }

    public void imprimirInOrden() {
        printInOrdenRec(root);
        System.out.println();
    }

    private void printInOrdenRec(Node node) {
        if (node != null) {
            printInOrdenRec(node.getIzquierda());
            System.out.print(node.getValor() + ",");
            printInOrdenRec(node.getDerecha());
        }
    }

    public void imprimirInOrdenAlturas() {
        printInOrdenAlturasRec(root);
        System.out.println();
    }

    private void printInOrdenAlturasRec(Node node) {
        if (node != null) {
            printInOrdenAlturasRec(node.getIzquierda());
            System.out.print(node.getValor() + "(h=" + getHeightRec(node) + "),");
            printInOrdenAlturasRec(node.getDerecha());
        }
    }

    public void imprimirInOrdenBalance() {
        printInOrdenBalanceRec(root);
        System.out.println();
    }

    private void printInOrdenBalanceRec(Node node) {
        if (node != null) {
            printInOrdenBalanceRec(node.getIzquierda());
            System.out.print(node.getValor() + "(bf=" + getBalanceFactor(node) + "),");
            printInOrdenBalanceRec(node.getDerecha());
        }
    }

    public boolean findeValue(int value) {
        return buscarValor(root, value);
    }

    private boolean buscarValor(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValor() == value) {
            return true;
        }
        if (value < node.getValor()) {
            return buscarValor(node.getIzquierda(), value);
        } else {
            return buscarValor(node.getDerecha(), value);
        }
    }

    public int getHeightTree() {
        return getHeightRec(root);
    }

    public int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int izquierdaHeight = getHeightRec(node.getIzquierda());
        int derechaHeight = getHeightRec(node.getDerecha());
        return Math.max(izquierdaHeight, derechaHeight) + 1;
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getIzquierda()) - getHeightRec(node.getDerecha());
    }

    public int getSize() {
        return getSizeRec(root);
    }

    private int getSizeRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeRec(node.getIzquierda()) + getSizeRec(node.getDerecha());
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }
        int bf = getBalanceFactor(node);
        if (bf > 1 || bf < -1) {
            return false;
        }
        return isBalancedRec(node.getIzquierda()) && isBalancedRec(node.getDerecha());
    }

    public void imprimirInOrdenBalanceYDesequilibrio() {
        printInOrdenBalanceYDesequilibrioRec(root);
        System.out.println();
    }

    private void printInOrdenBalanceYDesequilibrioRec(Node node) {
        if (node != null) {
            printInOrdenBalanceYDesequilibrioRec(node.getIzquierda());
            int bf = getBalanceFactor(node);
            System.out.print(node.getValor() + "(bf=" + bf + ")");
            if (bf > 1 || bf < -1) {
                System.out.print("[desequilibrado] ");
            } else {
                System.out.print(", ");
            }
            printInOrdenBalanceYDesequilibrioRec(node.getDerecha());
        }
    }
}
