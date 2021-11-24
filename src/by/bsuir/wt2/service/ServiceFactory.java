package by.bsuir.wt2.service;

import by.bsuir.wt2.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();
	
	private ServiceFactory() {}

	public ApplianceService getApplianceService() {
		return applianceService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}