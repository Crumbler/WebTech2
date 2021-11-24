package by.bsuir.wt2.main;

import java.util.List;

import by.bsuir.wt2.entity.Appliance;
import by.bsuir.wt2.entity.criteria.Criterion;
import by.bsuir.wt2.entity.criteria.SearchCriteria.*;

import by.bsuir.wt2.service.*;

public class Main {

	/**
	 *  Prints the laptops sorted by battery capacity and all the ovens.
	 *  
	 *  @param args  The command line arguments.
	 */
	public static void main(String[] args) {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();
		
		System.out.println("Laptops sorted by battery capacity:");
		
		List<Appliance> appliances = 
				service.find(new Criterion(Laptop.class, Laptop.BATTERY_CAPACITY));
		
		for (Appliance appliance : appliances)
		{
			System.out.println(appliance.toString());
		}
		
		System.out.println("All the ovens:");
		
		appliances = service.find(new Criterion(Oven.class, null));
		
		for (Appliance appliance : appliances)
		{
			System.out.println(appliance.toString());
		}
	}

}
