package by.bsuir.wt2.entity;

import by.bsuir.wt2.entity.criteria.SearchCriteria;

public class VacuumCleaner extends Appliance {
	private int powerConsumption, motorSpeedRegulation,
				cleaningWidth;
	private String filterType, bagType, wandType;

	public VacuumCleaner(int powerConsumption, String filterType, String bagType,
						 String wandType, int motorSpeedRegulation, int cleaningWidth) {
		this.powerConsumption = powerConsumption;
		this.filterType = filterType;
		this.bagType = bagType;
		this.wandType = wandType;
		this.motorSpeedRegulation = motorSpeedRegulation;
		this.cleaningWidth = cleaningWidth;
	}

	@Override
	public Object getProperty(Enum<?> property) {
		SearchCriteria.VacuumCleaner propertyType = (SearchCriteria.VacuumCleaner)property;

		switch (propertyType)
		{
		case POWER_CONSUMPTION:
			return this.powerConsumption;

		case FILTER_TYPE:
			return this.filterType;

		case BAG_TYPE:
			return this.bagType;

		case WAND_TYPE:
			return this.wandType;

		case MOTOR_SPEED_REGULATION:
			return this.motorSpeedRegulation;
			
		case CLEANING_WIDTH:
			return this.cleaningWidth;
		}

		return null;
	}
	
	@Override
	public String toString() {
		return String.format("VacuumCleaner: PowerConsumption: %d, FilterType: %s, " +
							 "BagType: %s, WandType: %s, MotorSpeedRegulation: %d, " +
							 "CleaningWidth: %d", 
							 powerConsumption, filterType, bagType,
							 wandType, motorSpeedRegulation, cleaningWidth);
	}
}
