package by.bsuir.wt2.dao.impl;

import java.util.ArrayList;

import java.util.List;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

import by.bsuir.wt2.dao.ApplianceDAO;
import by.bsuir.wt2.entity.*;
import by.bsuir.wt2.entity.criteria.Criterion;

public class ApplianceDAOimpl implements ApplianceDAO {
	private List<Appliance> appliances;
	
	/**
	 * Constructs a DAO that gets its appliances from an xml file.
	 * @param fileName  The xml file's name.
	 */
	public ApplianceDAOimpl(String fileName)
	{
		appliances = new ArrayList<Appliance>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		Document doc = null;
		
		try {
			doc = builder.parse(new File(fileName));
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			return;
		}
		
		Element root = doc.getDocumentElement();
		
		NodeList childNodes = root.getChildNodes();
		
		for (int i = 0; i < childNodes.getLength(); ++i)
		{
			Node node = childNodes.item(i);
			
			if (node.getNodeType() != Node.ELEMENT_NODE)
			{
				continue;
			}
			
			Element element = (Element)node;
			
			Appliance appliance = parseAppliance(element);
			
			appliances.add(appliance);
		}
	}
	
	private static String getSubnodeValue(Element element, String name)
	{
		return element.getElementsByTagName(name).item(0).getTextContent();
	}
	
	private static Appliance parseAppliance(Element element)
	{
		String applianceType = element.getNodeName();
		
		String powerConsumptionString, weightString, capacityString,
			   depthString, heightString, widthString,
			   batteryCapacityString, os, memoryRomString,
			   systemMemoryString, cpuString, displayInchesString,
			   freezerCapacityString, overallCapacityString,
			   filterType, bagType, wandType, motorSpeedRegulationString,
			   cleaningWidthString, flashMemoryCapacityString, color,
			   numberOfSpeakersString, frequencyRange, cordLengthString;
		
		int powerConsumption, weight, capacity, depth, memoryRom,
			systemMemory, displayInches, freezerCapacity,
			motorSpeedRegulation, cleaningWidth, flashMemoryCapacity,
			numberOfSpeakers, cordLength;
		
		float height, width, batteryCapacity, cpu, overallCapacity;
		
		switch (applianceType)
		{
		case "Oven":
			powerConsumptionString = getSubnodeValue(element, "PowerConsumption");
			weightString = getSubnodeValue(element, "Weight");
			capacityString = getSubnodeValue(element, "Capacity");
			depthString = getSubnodeValue(element, "Depth");
			heightString = getSubnodeValue(element, "Height");
			widthString = getSubnodeValue(element, "Width");
			
			powerConsumption = Integer.parseInt(powerConsumptionString);
			weight = Integer.parseInt(weightString);
			capacity = Integer.parseInt(capacityString);
			depth = Integer.parseInt(depthString);
			height = Float.parseFloat(heightString);
			width = Float.parseFloat(widthString);
			
			return new Oven(powerConsumption, weight, capacity,
							depth, height, width);
			
		case "Laptop":
			batteryCapacityString = getSubnodeValue(element, "BatteryCapacity");
			os = getSubnodeValue(element, "OS");
			memoryRomString = getSubnodeValue(element, "MemoryROM");
			systemMemoryString = getSubnodeValue(element, "SystemMemory");
			cpuString = getSubnodeValue(element, "CPU");
			displayInchesString = getSubnodeValue(element, "DisplayInches");
			
			batteryCapacity = Float.parseFloat(batteryCapacityString);
			memoryRom = Integer.parseInt(memoryRomString);
			systemMemory = Integer.parseInt(systemMemoryString);
			cpu = Float.parseFloat(cpuString);
			displayInches = Integer.parseInt(displayInchesString);
			
			return new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
			
		case "Refrigerator":
			powerConsumptionString = getSubnodeValue(element, "PowerConsumption");
		   	weightString = getSubnodeValue(element, "Weight");
		   	freezerCapacityString = getSubnodeValue(element, "FreezerCapacity");
		   	overallCapacityString = getSubnodeValue(element, "OverallCapacity");
		   	heightString = getSubnodeValue(element, "Height");
		   	widthString = getSubnodeValue(element, "Width");
		
			powerConsumption = Integer.parseInt(powerConsumptionString);
			weight = Integer.parseInt(weightString);
			freezerCapacity = Integer.parseInt(freezerCapacityString);
			overallCapacity = Float.parseFloat(overallCapacityString);
			height = Float.parseFloat(heightString);
			width = Float.parseFloat(widthString);
		
			return new Refrigerator(powerConsumption, weight, freezerCapacity,
									overallCapacity, height, width);
			
		case "VacuumCleaner":
			powerConsumptionString = getSubnodeValue(element, "PowerConsumption");
			filterType = getSubnodeValue(element, "FilterType");
			bagType = getSubnodeValue(element, "BagType");
			wandType = getSubnodeValue(element, "WandType");
			motorSpeedRegulationString = getSubnodeValue(element, "MotorSpeedRegulation");
			cleaningWidthString = getSubnodeValue(element, "CleaningWidth");
			
			powerConsumption = Integer.parseInt(powerConsumptionString);
			motorSpeedRegulation = Integer.parseInt(motorSpeedRegulationString);
			cleaningWidth = Integer.parseInt(cleaningWidthString);
			
			return new VacuumCleaner(powerConsumption, filterType, bagType,
									 wandType, motorSpeedRegulation, cleaningWidth);
			
		case "TabletPC":
			batteryCapacityString = getSubnodeValue(element, "BatteryCapacity");
			displayInchesString = getSubnodeValue(element, "DisplayInches");
			memoryRomString = getSubnodeValue(element, "MemoryROM");
			flashMemoryCapacityString = getSubnodeValue(element, "FlashMemoryCapacity");
			color = getSubnodeValue(element, "Color");
			
			batteryCapacity = Float.parseFloat(batteryCapacityString);
			displayInches = Integer.parseInt(displayInchesString);
			memoryRom = Integer.parseInt(memoryRomString);
			flashMemoryCapacity = Integer.parseInt(flashMemoryCapacityString);
			
			return new TabletPC(batteryCapacity, displayInches, memoryRom,
								flashMemoryCapacity, color);
			
		case "Speakers":
			powerConsumptionString = getSubnodeValue(element, "PowerConsumption");
			numberOfSpeakersString = getSubnodeValue(element, "NumberOfSpeakers");
			frequencyRange = getSubnodeValue(element, "FrequencyRange");
			cordLengthString = getSubnodeValue(element, "CordLength");
			
			powerConsumption = Integer.parseInt(powerConsumptionString);
			numberOfSpeakers = Integer.parseInt(numberOfSpeakersString);
			cordLength = Integer.parseInt(cordLengthString);
			
			return new Speakers(powerConsumption, numberOfSpeakers,
								frequencyRange, cordLength);
		}
		
		return null;
	}
	
	@Override
	public List<Appliance> find(Criterion criterion) {
		List<Appliance> foundAppliances = new ArrayList<Appliance>();
		
		String soughtClassName = criterion.getApplianceClass().getSimpleName();
		
		for (Appliance appliance : appliances)
		{
			if (appliance.getClass().getSimpleName().equals(soughtClassName))
			{
				foundAppliances.add(appliance);
			}
		}
		
		Enum<?> searchCriterion = criterion.getSearchCriterion();
		
		ApplianceComparator comparator = new ApplianceComparator(searchCriterion);
		
		if (searchCriterion != null)
		{
			foundAppliances.sort(comparator);
		}
		
		return foundAppliances;
	}
}
