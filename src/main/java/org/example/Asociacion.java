package org.example;

public class Asociacion <K, V> {
    private K key; // La palabra en inglés
    private V value; // La traducción al español

    // Constructor que inicializa la asociación con su clave y valor
    public Asociacion(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Método para obtener la clave (palabra en inglés)
    public K getKey() {
        return key;
    }

    // Método para obtener el valor (traducción al español)
    public V getValue() {
        return value;
    }

    // Método para establecer la clave (palabra en inglés)
    public void setKey(K key) {
        this.key = key;
    }

    // Método para establecer el valor (traducción al español)
    public void setValue(V value) {
        this.value = value;
    }

    // Método toString para mostrar la asociación en un formato legible
    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }
}
