package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clase principal que contiene el método main para ejecutar el programa del diccionario.
 * Permite al usuario cargar un diccionario Inglés-Español y realizar traducciones de texto.
 * Ricardo Arturo Godinez Sanchez
 * 23247
 * 21/03/2024
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        BinaryTree dictionary = new BinaryTree();
        loadDictionary(dictionary, "diccionario_comas.txt");

        System.out.println("Diccionario cargado. Traducciones:");
        dictionary.inOrder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una opción:");
        System.out.println("1. Ingresar frase para traducir");
        System.out.println("2. Traducir contenido de un archivo de texto");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        switch (opcion) {
            case 1:
                translateUserInput(dictionary, scanner);
                break;
            case 2:
                System.out.print("Ingresa el nombre del archivo de texto agrega .txt al final: ");
                String fileName = scanner.nextLine();
                translateText(dictionary, fileName);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }

    /**
     * Carga las asociaciones de palabras del archivo de diccionario al árbol binario de búsqueda.
     * Cada línea del archivo debe contener una asociación en el formato (palabra en inglés, palabra en español).
     *
     * @param dictionary El árbol binario de búsqueda en el que se cargarán las asociaciones.
     * @param fileName   El nombre del archivo que contiene las asociaciones de palabras.
     */

    private static void loadDictionary(BinaryTree dictionary, String fileName) {
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.substring(1, line.length() - 1).split(",");
                    dictionary.insert(parts[0].trim().toLowerCase(), parts[1].trim());
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Solicita al usuario que ingrese una frase en inglés y la traduce al español, palabra por palabra.
     * Las palabras no encontradas en el diccionario se devuelven en inglés y encerradas entre asteriscos.
     *
     * @param dictionary El árbol binario de búsqueda que se utiliza para la traducción.
     * @param scanner    El scanner que se utiliza para leer la entrada del usuario.
     */

    private static void translateUserInput(BinaryTree dictionary, Scanner scanner) {
        System.out.println("Por favor, ingresa una frase en inglés para traducir:");
        String inputLine = scanner.nextLine();

        String[] words = inputLine.split(" ");
        for (String word : words) {
            System.out.print(dictionary.find(word.toLowerCase()) + " ");
        }
        System.out.println(); // Nueva línea al final de la traducción
    }

    /**
     * Lee un archivo de texto en inglés y traduce su contenido al español, palabra por palabra.
     * Las palabras no encontradas en el diccionario se devuelven en inglés y encerradas entre asteriscos.
     *
     * @param dictionary El árbol binario de búsqueda que se utiliza para la traducción.
     * @param fileName   El nombre del archivo de texto en inglés para traducir.
     */
    private static void translateText(BinaryTree dictionary, String fileName) {
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    System.out.print(dictionary.find(word.toLowerCase()) + " ");
                }
                System.out.println(); // Nueva línea al final de la traducción
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fileName);
            e.printStackTrace();
        }
    }
}
