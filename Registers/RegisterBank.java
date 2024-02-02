package RegisterBank;
import java.util.HashMap;

public class DataMemory {
  public DataMemory() {
    memory = new HashMap<Integer, Register>();
    memory.put(0, new IntegerRegister());
  }
  public Register getRegister(int address) {
    return memory.get(address);
  }
  public void putRegister(int address, Register register) {
    memory.put(address, register);
  }
  public boolean containsRegister(int address) {
    return memory.containsKey(address);
  }
  private HashMap<Integer, Register> memory;
}
