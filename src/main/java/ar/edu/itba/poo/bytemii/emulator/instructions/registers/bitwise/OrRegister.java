package ar.edu.itba.poo.bytemii.emulator.instructions.registers.bitwise;

import ar.edu.itba.poo.bytemii.emulator.hardware.cpu.CPU;
import ar.edu.itba.poo.bytemii.emulator.instructions.OpCode;
import ar.edu.itba.poo.bytemii.emulator.instructions.DoublePositionInstruction;

/**
 * 8xy1 - OR Vx, Vy
 * Set Vx = Vx OR Vy.
 * Performs a bitwise OR on the values of Vx and Vy, then stores the result in Vx. A bitwise OR compares the
 * corrseponding bits from two values, and if either bit is 1, then the same bit in the result is also 1.
 * Otherwise, it is 0.
 */

public class OrRegister extends DoublePositionInstruction {
	@Override
	public void execute( CPU cpu ) {
		cpu.getRegistry(position1).or(cpu.getRegistry(position2));
		cpu.getInstPointer().add(STEP);
	}

	@Override
	public boolean validate( OpCode opCode ) {
		if(opCode.getNibble(0) == 0x8 && opCode.getNibble(3) == 0x1) {
			setValues(opCode);
			return true;
		}
		return false;
	}
}
