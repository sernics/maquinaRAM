package Registers;

public interface Register {
  public default int getValue() {
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
}