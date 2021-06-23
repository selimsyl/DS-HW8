import java.util.Iterator;
import java.util.Random;

public class Main {

  public static class Data implements Weightable<Data> {
    Data() {}

    @Override
    public double getWeight() {
      Random r = new Random();
      return r.nextInt(100);
    }
  }
  public static void main(String[] args) {
    Graph<Data> graph = AbstractGraph.createGraph(false, "list", new Data());
    for (int i = 0; i < graph.getNumV(); ++i) {
      Iterator<Edge<Data>> iter = graph.edgeIterator(i);
      while(iter.hasNext()) {
        var item = iter.next();
        System.out.println(item.getSource()+"->"+item.getDest());
      }
    }
    System.out.println("algortihm starts...");

    int[] pred = new int[graph.getNumV()];
    double[] dist = new double[graph.getNumV()];
    DijkstraSAlgorithm shortestPath = new DijkstraSAlgorithm(DijkstraSAlgorithm.PathWeightOperation.ADDITION);
    shortestPath.dijkstrasAlgorithm(graph, 0,pred,dist);
  }
}
