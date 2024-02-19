import java.util.ArrayList;
import Registers.RegisterBank;
import Operands.ArrayOperand;
import Operands.BasicOperand;
import Operands.DirectOperand;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> aleatoryNumbers = new ArrayList<Integer>();
    for (int i = 0; i < 9; i++) {
      // Generar 9 números aleatorios
      aleatoryNumbers.add((int) (Math.random() * 100) + 1);
    }
    RamMachine ramMachine = new RamMachine("test/insertion.ram", "inputs/input.txt", "outputs/output.txt");
    ramMachine.setArray(aleatoryNumbers);
    ramMachine.run(2);
    RegisterBank registerBank = ramMachine.getRegisterBank();
    BasicOperand operand = new ArrayOperand(1, new DirectOperand(0));
    System.out.println(operand.getValue(registerBank));
  }
}
