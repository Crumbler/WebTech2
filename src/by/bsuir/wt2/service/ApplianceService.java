package by.bsuir.wt2.service;

import java.util.List;

import by.bsuir.wt2.entity.Appliance;
import by.bsuir.wt2.entity.criteria.Criterion;

public interface ApplianceService {
	/**
	 * Finds appliances based on the supplied criterion.
	 * 
	 * @param   criterion The criterion containing the appliance type and possibly a property to sort by.
	 * @return  A list of found appliances.
	 */
	List<Appliance> find(Criterion criterion);
}
