package avasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.*;

public class InsectFactory extends SpeciesFactory {
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Insects.Spider.equals(type)) {
			return new Spider();
		} else if (Constants.Animals.Insects.Butterfly.equals(type)) {
			return new Butterfly();
		} else {
			throw new Exception("Invalid animal exception!");
		}
	}

}
