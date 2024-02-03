package Registers;

public interface Register {
  public default int getValue() {
    throw new UnsupportedOperationException();
  }
  public default void setValue(int value) {
    throw new UnsupportedOperationException();
  }
}