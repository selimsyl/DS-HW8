/**
 * Example data structure to be stored by graph edges
 */
public class Data implements Weightable<Data> {
  /**
   * @param weight weight value for datas
   */
  public Data(double weight) {this.weight = weight;}

  /**
   * @return data weight
   */
  @Override
  public double getWeight() {
    return weight;
  }
  private double weight;
}