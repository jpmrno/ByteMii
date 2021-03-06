package ar.edu.itba.poo.bytemii.emulator.instructions.registers.math;

import ar.edu.itba.poo.bytemii.emulator.hardware.cpu.CPU;
import ar.edu.itba.poo.bytemii.emulator.instructions.OpCode;
import ar.edu.itba.poo.bytemii.emulator.instructions.PositionDataInstruction;

/**
 * 7xkk - ADD Vx, byte
 * Set Vx = Vx + kk.
 * Adds the value kk to the value of register Vx, then stores the result in Vx.
 */

public class AddData extends PositionDataInstruction {

	@Override
	public void execute( CPU cpu ) {
		cpu.getRegistry(position).add(data);
		cpu.getInstPointer().add(STEP);
	}

	@Override
	public boolean validate( OpCode opCode ) {
		if(opCode.getNibble(0) == 0x7) {
			setValues(opCode);
			return true;
		}
		return false;
	}
}
