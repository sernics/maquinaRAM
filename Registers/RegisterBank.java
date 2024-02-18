package Registers;
import java.util.HashMap;

public class RegisterBank {
  public RegisterBank() {
    memory = new HashMap<Integer, Register>();
    memory.put(0, new IntegerRegister());
  }

  public Register getRegister(int address) {
    return memory.get(address);
  }

  public int getRegisterValue(int address) {
    return memory.get(address).getValue();
  }

  public void putRegister(int address, Register register) {
    if (getRegister(address) != null && getRegister(address).isArray()) {
      Register values = memory.get(address);
      values.setValue(register.getValue());
      memory.put(address, values);
    } else {
      memory.put(address, register);
    }
  }

  public boolean containsRegister(int address) {
    return memory.containsKey(address);
  }

  public HashMap<Integer, Register> getMemory() {
    return memory;
  }

  public void print() {
    for (Integer key : memory.keySet()) {
      System.out.print("Register " + key + ": ");
      memory.get(key).print();
      System.out.println();
    }
  }
  private HashMap<Integer, Register> memory;
}
