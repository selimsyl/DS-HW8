import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {
  // Data Fields
  /** The number of vertices */
  private int numV;
  /** Flag to indicate whether this is a directed graph */
  private boolean directed;
// Constructor
  /** Construct a graph with the specified number of vertices and the directed
   flag. If the directed flag is true, this is a directed graph.
   @param numV The number of vertices
   @param directed The directed flag
   */
  public AbstractGraph(int numV, boolean directed) {
    this.numV = numV;
    this.directed = directed;
  }
// Accessor Methods
  /** Return the number of vertices.
   @return The number of vertices
   */
  public int getNumV() {
    return numV;
  }

  /** Return whether this is a directed graph.
   @return true if this is a directed graph
   */
  public boolean isDirected() {
    return directed;
  }

  public static Graph createGraph(boolean isDirected,
                                  String type) {
    int numV = 500;
    AbstractGraph returnValue = null;

    type = type.toLowerCase();
    switch (type) {
      case "matrix":
//        returnValue = new MatrixGraph(numV, isDirected);
        break;
      case "list":
        returnValue = new ListGraph(numV, isDirected);
        break;
      default:
        throw new IllegalArgumentException();
    }

    Random r = new Random();
    int low = 0;
    int high = 500;
    int vertice = r.nextInt(high-low) + low;

    for (int i = 0; i < numV; ++i) {
      returnValue.insert(new Edge(r.nextInt(high-low) + low,r.nextInt(high-low) + low ));
    }

    return returnValue;
  }
}
