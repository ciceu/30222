package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import avasmmr.zoowsome.services.factories.Constants;

public class Spider extends Insects {

	public Spider(int nrOfLegs, String name, boolean canFly, boolean isDangerous) {
		super(0.8, 5.0);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setCanFly(canFly);
		setIsDangerous(isDangerous);
	}

	public Spider() {
		this(10, "Paianjen", false, false);

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
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Spider);
	}
}
