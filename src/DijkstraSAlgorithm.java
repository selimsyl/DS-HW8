import java.util.HashSet;
import java.util.Iterator;

public class DijkstraSAlgorithm<E extends Weightable<E>> {
  /**
   *
   */
  public enum PathWeightOperation {
    ADDITION,
    MULTIPLY,
    STAR
  }

  /**
   *
   */
  private PathWeightOperation operationType;

  /**
   * @param operationType
   */
  public DijkstraSAlgorithm(PathWeightOperation operationType) {
    this.operationType = operationType;
  }
  /** Dijkstra's Shortest‐Path algorithm.
   @param graph The weighted graph to be searched
   @param start The start vertex
   @param pred Output array to contain the predecessors in the shortest path
   @param dist Output array to contain the distance in the shortest path
   */
  public void dijkstrasAlgorithm(Graph<E> graph, int start, int[] pred,
                                        double[] dist) {
    int numV = graph.getNumV();
    HashSet<Integer> vMinusS = new HashSet<>(numV);
    // Initialize V–S.
    for (int i = 0; i < numV; i++) {
      if (i != start) {
        vMinusS.add(i);
      }
    }
    // Initialize pred and dist.
    for (int v : vMinusS) {
      pred[v] = start;
      var edge = graph.getEdge(start, v);
      if (edge != null)
        dist[v] = edge.getData().getWeight();
    }
    // Main loop
    while (vMinusS.size() != 0) {
      // Find the value u in V–S with the smallest dist[u].
      double minDist = Double.POSITIVE_INFINITY;
      int u = -1;
      for (int v : vMinusS) {
        if (dist[v] < minDist) {
          minDist = dist[v];
          u = v;
        }
      }
      // Remove u from vMinusS.
      vMinusS.remove(u);

      // Update the distances.
      Iterator<Edge<E>> iter = graph.edgeIterator(u);
      while(iter.hasNext()) {
        Edge<E> edge = iter.next();
        double weight = edge.getData().getWeight();
        int dest = edge.getDest();
        if (vMinusS.contains(dest)) {
          var newWeight = calcWeight(dist[u], weight);
          if (newWeight < dist[dest]) {
            dist[dest] = newWeight;
            pred[dest] = u;
          }
        }
      }
    }
  }

  private double calcWeight(double weight1,double weight2) {
    double result = 0;
    switch (operationType) {
      case ADDITION :
        result = weight1 + weight2;
        break;
      case MULTIPLY :
        result = weight1 * weight2;
        break;
      case STAR :
        result = weight1 + weight2 - weight1*weight2;
        break;
      default:
        break;
    }
    return result;
  }
}
