package org.example;
/**
 * Clase que representa una asociación entre una palabra en inglés y su equivalente en español.
 * Utilizada como unidad básica de almacenamiento en un árbol binario de búsqueda (BST) para un diccionario Inglés-Español.
 *
 * @param <K> Tipo de dato para la palabra en inglés.
 * @param <V> Tipo de dato para la palabra en español.
 */

public class Asociacion <K, V> {
    private K key;
    private V value;

    /**
     * Constructor para crear una asociación.
     *
     * @param key   La palabra en inglés.
     * @param value La palabra en español correspondiente.
     */
    public Asociacion(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la palabra en inglés de esta asociación.
     *
     * @return La palabra en inglés.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene la palabra en español de esta asociación.
     *
     * @return La palabra en español.
     */
    public V getValue() {
        return value;
    }
}
