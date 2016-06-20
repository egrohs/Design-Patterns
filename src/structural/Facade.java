package structural;

/**
 * This is an abstract example of how a client interacts with a facade (the
 * "computer") to a complex system (internal computer parts, like CPU and
 * HardDrive).
 */
class CPU {
	// Complex parts
	public void freeze() {
	}

	public void jump(long position) {
	}

	public void execute() {
	}
}

class Memory {
	public void load(long position, byte[] data) {

	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		return new byte[10];
	}
}

/* Facade */

class Computer {
	private CPU cpu = null;
	private Memory memory = null;
	private HardDrive hardDrive = null;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void startComputer() {
		cpu.freeze();
		long BOOT_ADDRESS = 1;
		long BOOT_SECTOR = 2;
		int SECTOR_SIZE = 3;
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}

/** Client */
class Facade {
	public static void main(String[] args) {
		Computer facade = new Computer();
		facade.startComputer();
	}
}
