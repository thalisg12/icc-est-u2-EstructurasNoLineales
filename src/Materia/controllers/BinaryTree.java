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
            Node newNode = insertRec(padre.getIzquierda(), value);
            padre.setIzquierda(newNode);
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

    // PosOrden
    public void imprimirPosOrden() {
        printPosOrdenRec(root);
        System.out.println();
    }

    private void printPosOrdenRec(Node node) {
        if (node != null) {
            printPosOrdenRec(node.getIzquierda());
            System.out.print(node.getValor() + ",");
            printPosOrdenRec(node.getDerecha());
        }

    }

    // InOrden
    public void imprimirInOrden() {
        printInOrdenRec(root);
        System.out.println();
    }

    private void printInOrdenRec(Node node) {
        if (node != null) {
            printInOrdenRec(node.getIzquierda());
            printInOrdenRec(node.getDerecha());
            System.out.print(node.getValor() + ",");

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

}
