package Registers;

import java.util.ArrayList;

public class ArrayIntegerRegister implements Register {
  public ArrayIntegerRegister() {
    values = new ArrayList<Integer>();
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
  private ArrayList<Integer> values;
}
