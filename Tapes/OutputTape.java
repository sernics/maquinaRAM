package Tapes;
import java.util.ArrayList;

public class OutputTape {
  public OutputTape() {
    tape = new ArrayList<Integer>();
  }
  public void write(int value) {
    tape.add(value);
  }
  private ArrayList<Integer> tape;
}
