package Tapes;
import java.util.ArrayList;

public class OutputTape implements Tape {
  public OutputTape() {
    head = 0;
    tape = new ArrayList<Integer>();
  }
  public void write(int value) {
    tape.add(value);
  }
  public int read() {
    int value = tape.get(head);
    head++;
    return value;
  }
  public boolean hasNext() {
    return head < tape.size();
  }
  int head;
  private ArrayList<Integer> tape;
}
