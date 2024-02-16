package Tapes;
import java.util.ArrayList;

public interface Tape {
  public default void write(int value) {
    throw new UnsupportedOperationException();
  }
  public default Integer read() {
    throw new UnsupportedOperationException();
  }
  public Integer getHead();
  public ArrayList<Integer> getTape();
}