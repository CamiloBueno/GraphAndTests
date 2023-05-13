import model.graph.Graph;
import org.junit.Test;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {


    @Test
    public void testBFS() {
        // Create a new graph
        Graph g = new Graph(5);
        addVertex();
        g.connectVertex(0, 1);
        g.connectVertex(0, 2);
        g.connectVertex(1, 3);
        g.connectVertex(2, 4);

        // Perform a BFS starting from vertex 0
        List<Integer> bfsOrder = g.bfs(0);

        // Verify that the BFS order is correct
        List<Integer> expectedOrder = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expectedOrder, bfsOrder);
    }
   }