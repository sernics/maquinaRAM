package Instructions;
import RegisterBank.DataMemory;

public interface Instruction {
  public void execute(DataMemory dataMemory);
}
