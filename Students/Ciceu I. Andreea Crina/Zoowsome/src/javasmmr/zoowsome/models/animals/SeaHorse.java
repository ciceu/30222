package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import avasmmr.zoowsome.services.factories.Constants;

public class SeaHorse extends Aquatic {
	public SeaHorse(int nrOfLegs, String name, int avgSwimDepth, waterType water) {
		super(0.1, 0.0);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setAvgSwimDepth(avgSwimDepth);
		setWater(water);
	}

	public SeaHorse() {
		this(0, "SeaHorse", 200, waterType.freshWater);
	}

	public boolean kill() {
		Random random = new Random();
		int ran = random.nextInt(10);
		if ((ran / 10) < dangerPerc) {
			return true;
		} else {
			return false;
		}
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.SeaHorse);
	}

}
