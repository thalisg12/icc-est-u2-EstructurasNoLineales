package Materia.models;

public class Node {

    private int valor;
    private Node derecha;
    private Node izquierda;
    private int height;

    public Node(int valor) {
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getDerecha() {
        return derecha;
    }

    public void setDerecha(Node derecha) {
        this.derecha = derecha;
    }

    public Node getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Node izquierda) {
        this.izquierda = izquierda;
    }

    @Override
    public String toString() {
        return "Node [valor=" + valor + "]";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
