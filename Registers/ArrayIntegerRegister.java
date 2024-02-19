package Registers;

import java.util.ArrayList;

public class ArrayIntegerRegister implements Register {
  public ArrayIntegerRegister() {
    values = new ArrayList<Integer>();
  }
  public ArrayIntegerRegister(ArrayList<Integer> values) {
    this.values = values;
  }
  public void setValue(int value) {
    values.add(value);
  }
  public void setIndexValue(int index, int value) {
    values.set(index, value);
  }
  public void print() {
    System.out.print("[");
    for (int i = 0; i < values.size(); i++) {
      System.out.print(values.get(i));
      if (i < values.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.print("]");
  }
  public Integer getValue(Integer address) {
    return values.get(address);
  }
  public ArrayList<Integer> getValues() {
    return values;
  }
  public Boolean isArray() {
    return true;
  }
  private ArrayList<Integer> values;
}
