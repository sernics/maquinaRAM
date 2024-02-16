package Registers;

public interface Register {
  public default int getValue() {
    throw new UnsupportedOperationException();
  }
  public void setValue(int value);
  public void print();
}