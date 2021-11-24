package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class Oven extends Appliance {
	private int powerConsumption, weight, capacity, depth;
	private float height, width;
	
	public Oven(int powerConsumption, int weight, int capacity,
				int depth, float height, float width) {
		this.powerConsumption = powerConsumption;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.Oven propertyType = (SearchCriteria.Oven)property;
		
		switch (propertyType)
		{
		case POWER_CONSUMPTION:
			return this.powerConsumption;
			
		case WEIGHT:
			return this.weight;
			
		case CAPACITY:
			return this.capacity;
			
		case DEPTH:
			return this.depth;
			
		case HEIGHT:
			return this.height;
			
		case WIDTH:
			return this.width;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Oven; PowerConsumption: %d, Weight: %d, Capacity: %d, " +
							 "Depth: %d, Height: %.1f, Width: %.1f", 
							 powerConsumption, weight, capacity,
							 depth, height, width);
	}
}
