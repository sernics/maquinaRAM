package Tapes;
import java.util.ArrayList;
import java.io.File;

public class InputTape implements Tape {
  public InputTape(String filename) {
    head = 0;
    tape = new ArrayList<Integer>();
    try {
      java.util.Scanner scanner = new java.util.Scanner(new File(filename));
      while (scanner.hasNextInt()) {
        this.tape.add(scanner.nextInt());
      }
      scanner.close();
    } catch (java.io.FileNotFoundException e) {
      System.out.println("File not found: " + filename);
    }
  }
  public int read() {
    int value = tape.get(head);
    head++;
    return value;
  }
  public boolean hasNext() {
    return head < tape.size();
  }
  private int head;
  private ArrayList<Integer> tape;
}