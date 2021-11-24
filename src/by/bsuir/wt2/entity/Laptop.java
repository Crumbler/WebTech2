package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class Laptop extends Appliance {
	private float batteryCapacity, cpu;
	private String os;
	private int memoryRom, systemMemory, displayInches;
	
	public Laptop(float batteryCapacity, String os, int memoryRom,
				  int systemMemory, float cpu, int displayInches) {
		this.batteryCapacity = batteryCapacity;
		this.os = os;
		this.memoryRom = memoryRom;
		this.systemMemory = systemMemory;
		this.cpu = cpu;
		this.displayInches = displayInches;
	}
	
	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.Laptop propertyType = (SearchCriteria.Laptop)property;
		
		switch (propertyType)
		{
		case BATTERY_CAPACITY:
			return this.batteryCapacity;
			
		case OS:
			return this.os;
			
		case MEMORY_ROM:
			return this.memoryRom;
			
		case SYSTEM_MEMORY:
			return this.systemMemory;
			
		case CPU:
			return this.cpu;
			
		case DISPLAY_INCHES:
			return this.displayInches;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Laptop; BatteryCapacity: %.1f, OS: %s, MemoryROM: %d" +
							 " SystemMemory: %d, CPU: %.1f, DisplayInches: %d", 
						      batteryCapacity, os, memoryRom, systemMemory, cpu,
						      displayInches);
	}
}
