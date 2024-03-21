package org.example;

import org.example.Asociacion;

public class BinaryTree {
    private Node root;

    private class Node {
        Asociacion<String, String> association;
        Node left, right;

        public Node(Asociacion<String, String> assoc) {
            this.association = assoc;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(String key, String value) {
        root = insertRec(root, new Asociacion<>(key, value));
    }

    private Node insertRec(Node root, Asociacion<String, String> assoc) {
        if (root == null) {
            root = new Node(assoc);
            return root;
        }
        if (assoc.getKey().compareTo(root.association.getKey()) < 0) {
            root.left = insertRec(root.left, assoc);
        } else if (assoc.getKey().compareTo(root.association.getKey()) > 0) {
            root.right = insertRec(root.right, assoc);
        }
        return root;
    }

    public String find(String key) {
        return findRec(root, key.toLowerCase());
    }

    private String findRec(Node root, String key) {
        if (root == null) {
            return "*" + key + "*"; // No encontrada
        }
        if (key.compareTo(root.association.getKey().toLowerCase()) < 0) {
            return findRec(root.left, key);
        } else if (key.compareTo(root.association.getKey().toLowerCase()) > 0) {
            return findRec(root.right, key);
        } else {
            return root.association.getValue(); // Encontrada
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.association);
            inOrderRec(root.right);
        }
    }
}