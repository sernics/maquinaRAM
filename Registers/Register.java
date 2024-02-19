package Registers;
import java.util.ArrayList;

public interface Register {
  public default Integer getValue() {
    throw new UnsupportedOperationException();
  }
  public default Integer getValue(Integer address) {
    throw new UnsupportedOperationException();
  }
  public void setValue(int value);
  public void print();
  public default Boolean isArray() {
    return false;
  }
  public default ArrayList<Integer> getValues() {
    throw new UnsupportedOperationException();
  }
}