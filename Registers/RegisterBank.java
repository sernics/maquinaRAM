package Registers;
import java.util.HashMap;
import java.util.ArrayList;

public class RegisterBank {
  public RegisterBank() {
    memory = new HashMap<Integer, Register>();
    memory.put(0, new IntegerRegister());
  }

  public Register getRegister(int address) {
    return memory.get(address);
  }

  public Integer getRegisterValue(Integer address, Integer index) {
    if (index == null) {
      return memory.get(address).getValue();
    } else {
      return memory.get(address).getValue(index);
    }
  }

  public void putArrayValue(Integer address, Integer value) {
    // Obtener el array
    ArrayList<Integer> array = memory.get(1).getValues();
    // Modificar el array
    array.set(address, value);
    // Poner en el registro 1 el array modificado
    memory.put(1, new ArrayIntegerRegister(array));
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
