import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.BinaryTree;

public class BinaryTreeTest {

    private BinaryTree dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new BinaryTree();
        dictionary.insert("house", "casa");
        dictionary.insert("dog", "perro");
        dictionary.insert("homework", "tarea");
        dictionary.insert("woman", "mujer");
    }

    @Test
    void testFindExistingWord() {
        assertEquals("casa", dictionary.find("house"));
        assertEquals("perro", dictionary.find("dog"));
    }

    @Test
    void testFindNonExistingWord() {
        assertTrue(dictionary.find("cat").startsWith("*"));
        assertTrue(dictionary.find("man").startsWith("*"));
    }

    @Test
    void testInsertAndFind() {
        String key = "tree";
        String value = "árbol";
        dictionary.insert(key, value);
        assertEquals(value, dictionary.find(key));
    }
}