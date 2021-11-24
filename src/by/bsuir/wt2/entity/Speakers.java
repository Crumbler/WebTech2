package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class Speakers extends Appliance {
	private int powerConsumption, numberOfSpeakers, cordLength;
	private String frequencyRange;
	
	public Speakers(int powerConsumption, int numberOfSpeakers,
					String frequencyRange, int cordLength) {
		this.powerConsumption = powerConsumption;
		this.numberOfSpeakers = numberOfSpeakers;
		this.frequencyRange = frequencyRange;
		this.cordLength = cordLength;
	}
	
	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.Speakers propertyType = (SearchCriteria.Speakers)property;
		
		switch (propertyType)
		{
		case POWER_CONSUMPTION:
			return this.powerConsumption;
			
		case NUMBER_OF_SPEAKERS:
			return this.numberOfSpeakers;
			
		case FREQUENCY_RANGE:
			return this.frequencyRange;
			
		case CORD_LENGTH:
			return this.cordLength;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Speakers: PowerConsumption: %d, NumberOfSpeakers: %d, " +
							 "FrequencyRange: %s, CordLength: %d", 
							 powerConsumption, numberOfSpeakers,
							 frequencyRange, cordLength);
	}
}
