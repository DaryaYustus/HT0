package com.epam.training.runner;

import com.epam.training.Building;
import com.epam.training.Room;
import com.epam.training.exceptions.IlluminanceTooMuchException;
import com.epam.training.exceptions.SpaceUsageTooMuchException;
import com.epam.training.furniture.Sofa;
import com.epam.training.furniture.Table;
import com.epam.training.furniture.TableType;
import com.epam.training.illumination.Lightbulb;

public class Runner {

	public static void main(String[] args) {
		//create building 
		Building building = new Building("Машерова 1");
		try {
			//create room
			Room room1 = new Room("гостинная", 100, 2);
			//add to the room furnitures and illuminations
			room1.addFurniture(new Sofa(20));
			room1.addFurniture(new Table(10, TableType.WRITING));
			room1.addIllumination(new Lightbulb(500));
			//add rooms to the building
			building.getRooms().add(room1);
			System.out.println(building);
		} catch (IlluminanceTooMuchException e) {
			e.printStackTrace();
		} catch (SpaceUsageTooMuchException e) {
			e.printStackTrace();
		}
	}

}
