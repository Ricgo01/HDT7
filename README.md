Diccionario Inglés-Español

Este proyecto es una implementación de un diccionario Inglés-Español

Carga de un diccionario a partir de un archivo de texto con asociaciones en inglés y español.
Capacidad para traducir texto en inglés a español, palabra por palabra.
Manejo de palabras no encontradas en el diccionario, mostrándolas en inglés encerradas en asteriscos.
Interfaz de usuario a través de la consola con opciones para traducir frases introducidas manualmente o desde un archivo.

El proyecto consta de tres clases principales:

Association<K, V>: Representa una pareja de palabras asociadas entre inglés y español.
BinaryTree: Implementa el árbol binario de búsqueda para organizar las asociaciones.
Main: Contiene la lógica de interacción con el usuario y la funcionalidad de traducción.

Se incluyen pruebas unitarias para las funcionalidades clave del árbol binario de búsqueda (BinaryTreeTest.java) utilizando JUnit. Estas pruebas aseguran que la inserción y búsqueda de palabras funcionen correctamente.
