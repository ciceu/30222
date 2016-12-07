package javasmmr.zoowsome.controllers;

import java.util.ArrayList;
import java.util.Random;

import avasmmr.zoowsome.services.factories.AnimalFactory;
import avasmmr.zoowsome.services.factories.Constants;
import avasmmr.zoowsome.services.factories.SpeciesFactory;
import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.repositories.AnimalRepository;

public class MainController {

	public static void main(String[] args) throws Exception {

		AnimalFactory abstractFactory = new AnimalFactory();
		SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
		Animal a1 = speciesFactory1.getAnimal(Constants.Animals.Mammals.Monkey);
		System.out.printf("We have an animal with %s name!\n", a1.getName());

		SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		Animal a2 = speciesFactory2.getAnimal(Constants.Animals.Aquatics.Fish);
		System.out.printf("We have an animal with %d legs!\n", a2.getNrOfLegs());

		SpeciesFactory speciesFactory3 = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
		Animal a3 = speciesFactory3.getAnimal(Constants.Animals.Birds.Parrot);
		System.out.printf("We have an animal with %s name!\n", a3.getName());

		SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
		SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
		SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
		SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);

		Animal animal[] = new Animal[20];
		Random random = new Random();

		for (int i = 0; i < animal.length; i++) {
			int randomAnimal = random.nextInt(15);
			switch (randomAnimal) {
			case 0:
				animal[i] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Monkey);
				break;
			case 1:
				animal[i] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Tiger);
				break;
			case 2:
				animal[i] = speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Cow);
				break;
			case 3:
				animal[i] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Fish);
				break;
			case 4:
				animal[i] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.SeaHorse);
				break;
			case 5:
				animal[i] = speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Delphin);
				break;
			case 6:
				animal[i] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Cockroach);
				break;
			case 7:
				animal[i] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Butterfly);
				break;
			case 8:
				animal[i] = speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Spider);
				break;
			case 9:
				animal[i] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Crocodile);
				break;
			case 10:
				animal[i] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Snake);
				break;
			case 11:
				animal[i] = speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Chameleon);
				break;
			case 12:
				animal[i] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Parrot);
				break;
			case 13:
				animal[i] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Swallow);
				break;
			case 14:
				animal[i] = speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Crow);
				break;
			}

		}
		Employee[] angajat = new Employee[10];

		for (Employee caretaker : angajat) {
			for (Animal animals : animal)
				if (caretaker.isDead || animals.getTakenCareOf()) {
					String result = ((Caretaker) caretaker).takeCareOf(animals);
					if (result.equals(Constants.Employees.Caretakers.TCO_KILLED)) {
						caretaker.setIsDead(true);
					} else if (result.equals(Constants.Employees.Caretakers.TCO_NO_TIME)) {
						continue;
					} else {
						animals.setTakenCareOf(true);
					}
				}
			int i = 0;
			for (Animal animals : animal) {
				System.out.println("Animal " + i++ + " " + animals.getName() + "maintenance cost: "
						+ animals.getMaintenanceCost() + "taken care of:" + animals.getTakenCareOf());

			}
		}
		// zoo part 3
		AnimalRepository animalRepository = new AnimalRepository();
		ArrayList<Animal> animals = new ArrayList<Animal>();

		for (int i = 0; i < 20; i++) {
			animals.add(animal[i]);
		}
		animalRepository.save(animals);
		animals = animalRepository.load();
		System.out.println("My animals loaded from the XML: ");
		for (int i = 0; i < 20; i++) {
			System.out.println(animals.get(i).getName());
		}

	}

}
