import java.util.Iterator;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    Random r = new Random();
    Data[] dataArray = new Data[10000];
    for (int i = 0; i < dataArray.length; ++i)
      dataArray[i] = new Data((double) r.nextInt(500) + 1000);

    Graph<Data> graph = AbstractGraph.createGraph(false, "list", dataArray);
    for (int i = 0; i < graph.getNumV(); ++i) {
      Iterator<Edge<Data>> iter = graph.edgeIterator(i);
      while(iter.hasNext()) {
        var item = iter.next();
        System.out.println(item.getSource()+"->"+item.getDest() + " = " + item.getData().getWeight());
      }
    }
    System.out.println("algortihm starts...");

    int[] pred = new int[graph.getNumV()];
    double[] dist = new double[graph.getNumV()];
    DijkstraSAlgorithm shortestPath = new DijkstraSAlgorithm(DijkstraSAlgorithm.PathWeightOperation.ADDITION);
    shortestPath.dijkstrasAlgorithm(graph, 0,pred,dist);
  }
}
