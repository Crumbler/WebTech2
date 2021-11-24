package by.bsuir.wt2.service.impl;

import java.util.List;

import by.bsuir.wt2.dao.*;
import by.bsuir.wt2.entity.Appliance;
import by.bsuir.wt2.entity.criteria.Criterion;
import by.bsuir.wt2.service.ApplianceService;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public List<Appliance> find(Criterion criterion) {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO dao = factory.getApplianceDAO();
		
		return dao.find(criterion);
	}

}
