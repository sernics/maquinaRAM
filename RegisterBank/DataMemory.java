package RegisterBank;
import java.util.HashMap;

public class DataMemory {
  public DataMemory() {
    memory = new HashMap<Integer, Register>();
    memory.put(0, new IntegerRegister());
  }
  private HashMap<Integer, Register> memory;
}
