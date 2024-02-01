package Tapes;
import java.util.ArrayList;

public class OutputTape implements Tape {
  public OutputTape() {
    tape = new ArrayList<Integer>();
  }
  public void write(int value) {
    tape.add(value);
  }
  public ArrayList<Integer> getTape() {
    return tape;
  }
  private ArrayList<Integer> tape;
}
