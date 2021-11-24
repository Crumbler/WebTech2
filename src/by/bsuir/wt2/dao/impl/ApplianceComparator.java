package by.bsuir.wt2.dao.impl;

import java.util.Comparator;

import by.bsuir.wt2.entity.Appliance;

/**
 * Compares appliances of a specific type by a specific property.
 */
public class ApplianceComparator implements Comparator<Appliance> {
	private Enum<?> property;
	
	/**
	 * Constructs a comparator to compare appliances by a specific property.
	 * @param property  The property to compare by
	 * @see  by.bsuir.wt2.entity.criteria.SearchCriteria
	 */
	public ApplianceComparator(Enum<?> property)
	{
		this.property = property;
	}
	
	@Override
	public int compare(Appliance o1, Appliance o2) {
		if (o1 == null || o2 == null)
		{
			throw new NullPointerException();
		}
		
		Comparable property1 = (Comparable)o1.getProperty(property);
		Object property2 = o2.getProperty(property);
		
		return property1.compareTo(property2);
	}

}
