import java.util.Iterator;
import java.util.Random;

public class Main {

  public class Data implements Weightable<Data> {
    Data() {}

    @Override
    public double getWeight() {
      Random r = new Random();
      return r.nextInt(100);
    }
  }
  public static void main(String[] args) {
    Graph<Data> graph = AbstractGraph.createGraph(false, "list");
    for (int i = 0; i < graph.getNumV(); ++i) {
      Iterator<Edge<Data>> iter = graph.edgeIterator(i);
      while(iter.hasNext()) {
        var item = iter.next();
        System.out.println(item.getSource()+"->"+item.getDest());
      }
    }
  }
}
