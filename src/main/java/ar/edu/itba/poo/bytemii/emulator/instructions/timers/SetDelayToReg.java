package ar.edu.itba.poo.bytemii.emulator.instructions.timers;

import ar.edu.itba.poo.bytemii.emulator.hardware.cpu.CPU;
import ar.edu.itba.poo.bytemii.emulator.instructions.OpCode;
import ar.edu.itba.poo.bytemii.emulator.instructions.PositionInstruction;

/**
 * Fx07 - LD Vx, DT
 * Set Vx = delay timer value.
 * The value of DT is placed into Vx.
 */

public class SetDelayToReg extends PositionInstruction {
	@Override
	public void execute( CPU cpu ) {
		cpu.getRegistry(position).set(cpu.getDelayTimer());
		cpu.getInstPointer().add(STEP);
	}

	@Override
	public boolean validate( OpCode opCode ) {
		if(opCode.getNibble(0) == 0xF && opCode.getByte(1) == 0x07) {
			setValues(opCode);
			return true;
		}
		return false;
	}
}