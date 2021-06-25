/**
 * @param <E> Data to bo stored inside a edge
 *           it needs to be Weightable<E> for user to select
 *           weigth type
 */
public class Edge<E extends Weightable<E>> {
  private int source;

  private int dest;

  private E data;

  public Edge(int source, int dest) {
    this.source = source;
    this.dest = dest;
    this.data = null;
  }

  public Edge(int source, int dest,E data) {
    this.source = source;
    this.dest = dest;
    this.data = data;
  }

  public int getDest() {
    return dest;
  }

  public int getSource() {
    return source;
  }

  public E getData() {
    return data;
  }

  public void setSource(int source) {
    this.source = source;
  }

  public void setDest(int dest) {
    this.dest = dest;
  }

  public void setData(E data) {
    this.data = data;
  }

  public int hashCode() {
    return (int) (source * Math.pow(31, 3) + dest * Math.pow(31, 2));
  }

  public boolean equals(Object o) {
    Edge<E> rhs = (Edge<E>) o;
    return rhs.source == this.source &&
            rhs.dest == this.dest;
  }
}
