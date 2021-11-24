package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class TabletPC extends Appliance {
	private float batteryCapacity;
	private int displayInches, memoryRom,
				flashMemoryCapacity;
	private String color;
	
	public TabletPC(float batteryCapacity, int displayInches, int memoryRom,
					int flashMemoryCapacity, String color) {
		this.batteryCapacity = batteryCapacity;
		this.displayInches = displayInches;
		this.memoryRom = memoryRom;
		this.flashMemoryCapacity = flashMemoryCapacity;
		this.color = color;
	}
	
	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.TabletPC propertyType = (SearchCriteria.TabletPC)property;
		
		switch (propertyType)
		{
		case BATTERY_CAPACITY:
			return this.batteryCapacity;
			
		case DISPLAY_INCHES:
			return this.displayInches;
			
		case MEMORY_ROM:
			return this.memoryRom;
			
		case FLASH_MEMORY_CAPACITY:
			return this.flashMemoryCapacity;
			
		case COLOR:
			return this.color;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Tablet PC; BatteryCapacity: %.1f, DisplayInches: %d, " +
							 "MemoryROM: %d, FlashMemoryCapacity: %d, Color: %s", 
							 batteryCapacity, displayInches, memoryRom,
							 flashMemoryCapacity, color);
	}
}
