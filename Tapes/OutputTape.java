package Tapes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputTape implements Tape {
  public OutputTape(String filename) {
    tape = new ArrayList<Integer>();
    this.filename = filename;
  }
  public void write(int value) {
    tape.add(value);
    try {
      FileWriter writer = new FileWriter(this.filename);
      System.out.println("Writing to file: " + value);
      for (int i = 0; i < tape.size(); i++) {
        writer.write(tape.get(i) + " ");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public ArrayList<Integer> getTape() {
    return tape;
  }
  private ArrayList<Integer> tape;
  private String filename;
}
