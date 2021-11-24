package by.bsuir.wt2.dao;

import by.bsuir.wt2.dao.impl.*;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ApplianceDAO applianceDAO = 
			new ApplianceDAOimpl("src/main/resources/appliance_db.xml");
	
	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
