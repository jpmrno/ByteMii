package ar.edu.itba.poo.bytemii.emulator.instructions.registers.memory;

import ar.edu.itba.poo.bytemii.emulator.hardware.cpu.CPU;
import ar.edu.itba.poo.bytemii.emulator.hardware.memory.MemoryType;
import ar.edu.itba.poo.bytemii.emulator.instructions.OpCode;
import ar.edu.itba.poo.bytemii.emulator.instructions.PositionInstruction;

/**
 * Fx55 - LD [I], Vx
 * Store registers V0 through Vx in memory starting at location I.
 * The interpreter copies the values of registers V0 through Vx into memory, starting at the address in I.
 */

public class SetRAMFromRegistry extends PositionInstruction {
	public void execute(CPU cpu) {
		for(int i=0; i <= position; i++) {
			cpu.getMemoryMap().getMemory(MemoryType.RAM).set(cpu.getRegisterI().get() + i, cpu.getRegistry(i).get());
		}
		//cpu.getRegisterI().add(position + 1);
		cpu.getInstPointer().add(STEP);
	}
	public boolean validate(OpCode opCode) {
		if(opCode.getNibble(0) == 0x0F && opCode.getByte(1) == 0x55) {
			setValues(opCode);
			return true;
		}
		return false;
	}
}
