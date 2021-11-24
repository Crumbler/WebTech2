package by.bsuir.wt2.entity.criteria;

public class Criterion {
	private Class<?> applianceClass;
	private Enum<?> searchCriterion;
	
	/**
	 * Constructs a new criterion
	 * 
	 * @param applianceClass   Type of appliance to search for, not null
	 * @param searchCriterion  Criterion to sort by, may be null
	 */
	public Criterion(Class<?> applianceClass, Enum<?> searchCriterion)
	{
		this.applianceClass = applianceClass;
		this.searchCriterion = searchCriterion;
	}
	
	public Class<?> getApplianceClass()
	{
		return applianceClass;
	}
	
	public Enum<?> getSearchCriterion()
	{
		return searchCriterion;
	}
}
