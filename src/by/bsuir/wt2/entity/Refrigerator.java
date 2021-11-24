package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class Refrigerator extends Appliance {
	private int powerConsumption, weight, freezerCapacity;
	private float overallCapacity, height, width;
	
	public Refrigerator(int powerConsumption, int weight, int freezerCapacity,
						float overallCapacity, float height, float width) {
		this.powerConsumption = powerConsumption;
		this.weight = weight;
		this.freezerCapacity = freezerCapacity;
		this.overallCapacity = overallCapacity;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.Refrigerator propertyType = (SearchCriteria.Refrigerator)property;
		
		switch (propertyType)
		{
		case POWER_CONSUMPTION:
			return this.powerConsumption;
			
		case WEIGHT:
			return this.weight;
			
		case FREEZER_CAPACITY:
			return this.freezerCapacity;
			
		case OVERALL_CAPACITY:
			return this.overallCapacity;
			
		case HEIGHT:
			return this.height;
			
		case WIDTH:
			return this.width;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Refrigerator; PowerConsumption: %d, Weight: %d, " +
							 "FreezerCapacity: %d, OverallCapacity: %.1f, " +
							 "Height: %.1f, Width: %.1f", 
							 powerConsumption, weight, freezerCapacity,
							 overallCapacity, height, width);
	}
}
