package Materia.controllers;

import Materia.models.Node;

public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertrec(root, value);
    }

    public int getHeightTree() {
        return getHeight(root);
        
    }
    private int getHeightRec(Node node) {
        return node == null ? 0 : node.getHeight();
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.getIzquierda()) - getHeight(node.getDerecha());
    }

    private Node insertrec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo Insertado: " + value + " Con Balance " + getBalance(node));
            return newNode;
        }

        if (value < node.getValor()) {
            node.setIzquierda(insertrec(node.getIzquierda(), value));
        }else if (value > node.getValor()){
            node.setDerecha(insertrec(node.getDerecha(), value));
        }else{
            return node;
        }
        int leftheight = getHeightRec(node.getIzquierda());
        int rightheight = getHeightRec(node.getDerecha());

        int altura = Math.max(leftheight, rightheight) + 1;
        System.out.println("Nodo Actual -> " + node.getValor());
        node.setHeight(altura);
        System.out.println("\tAltura -> " + altura);
        int balance = getBalance(node);
        System.out.println("\tBalance -> " + balance);
    
    


        
        

        if (balance > 1 && value < node.getIzquierda().getValor()) {
            System.out.println("Rotacion simple derecha");
            return rotateLeft(node);
        }

        if (balance < -1 && value > node.getDerecha().getValor()) {
            System.out.println("Rotacion Simple Izquierda");
            return rotateRight(node);
        }
        if (balance > 1 && value > node.getIzquierda().getValor()) {
            System.out.println("Cambio");
            node.setIzquierda(rotateLeft(node.getIzquierda()));
            System.out.println("Rotacion simple derecha");
            return rotateRight(node);
        }
        if (balance < -1 && value < node.getDerecha().getValor()) {
            System.out.println("Cambio");
            node.setDerecha(rotateRight(node.getDerecha()));
            System.out.println("Rotacion simple izquierda");
            return rotateLeft(node);
            
        }

        return node;
    }
    private Node rotateLeft(Node x) {
        Node y = x.getDerecha();
        Node T2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(T2);

        x.setHeight(1 + Math.max(getHeight(x.getIzquierda()), getHeight(x.getDerecha())));
        y.setHeight(1 + Math.max(getHeight(y.getIzquierda()), getHeight(y.getDerecha())));

        return y;
    }

    private Node rotateRight(Node y) {
        Node x = y.getIzquierda();
        Node T2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(T2);

        y.setHeight(1 + Math.max(getHeight(y.getIzquierda()), getHeight(y.getDerecha())));
        x.setHeight(1 + Math.max(getHeight(x.getIzquierda()), getHeight(x.getDerecha())));

        return x;

        

    }
    

    
}

    