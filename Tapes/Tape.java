package Tapes;

public interface Tape {
  public int read();
  public boolean hasNext();
  public default void write(int value) {
    throw new UnsupportedOperationException();
  }
}