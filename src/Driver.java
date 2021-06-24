import java.util.Iterator;
import java.util.Random;

public class Driver {
    public void run() {
        Data[] graphData = createData();
        graph = AbstractGraph.createGraph(false, "list", graphData );
        printfGraph();
        findShortestPaths(0);
        findShortestPaths(100);
        findShortestPaths(311);
        findShortestPaths(425);
    }

    private Data[] createData() {
        Random r = new Random();
        Data[] dataArray = new Data[10000];
        for (int i = 0; i < dataArray.length; ++i)
            dataArray[i] = new Data((double) r.nextInt(500) + 1000);
        return dataArray;
    }

    private void printfGraph() {
        for (int i = 0; i < graph.getNumV(); ++i) {
            System.out.print("\nEdge list for vertice " + i);
            Iterator<Edge<Data>> iter = graph.edgeIterator(i);
            while(iter.hasNext()) {
                var item = iter.next();
                System.out.print("->["+item.getDest() + "," + item.getData().getWeight()+"]");
            }
        }
        System.out.println();
    }

    private void findShortestPaths(int start) {
        System.out.println("Find shortest paths starting from " + start + " vertice.");

        int[] pred = new int[graph.getNumV()];
        double[] dist = new double[graph.getNumV()];
        DijkstraSAlgorithm shortestPath = new DijkstraSAlgorithm(DijkstraSAlgorithm.PathWeightOperation.ADDITION);
        shortestPath.dijkstrasAlgorithm(graph, 100,pred,dist);
    }

    private Graph graph;
}
