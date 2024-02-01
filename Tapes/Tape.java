package Tapes;
import java.util.ArrayList;

public interface Tape {
  public default void write(int value) {
    throw new UnsupportedOperationException();
  }
  public default int read() {
    throw new UnsupportedOperationException();
  }
  public ArrayList<Integer> getTape();
}