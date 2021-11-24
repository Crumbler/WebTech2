package by.bsuir.wt2.entity;

public abstract class Appliance {
	/**
	 * Gets the property value based on the enum that corresponds the the specific class.
	 * 
	 * @param property The enum of the property to get
	 * @return 		   The value of the property
	 * @see 		   by.bsuir.wt2.entity.criteria.SearchCriteria
	 */
	public abstract Object getProperty(Enum<?> property);
}
