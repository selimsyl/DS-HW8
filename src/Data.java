public class Data implements Weightable<Data> {
  public Data(double weight) {this.weight = weight;}
  @Override
  public double getWeight() {
    return weight;
  }
  private double weight;
}