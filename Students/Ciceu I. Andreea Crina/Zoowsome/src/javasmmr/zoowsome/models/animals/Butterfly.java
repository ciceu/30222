package javasmmr.zoowsome.models.animals;

import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import avasmmr.zoowsome.services.factories.Constants;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

public class Butterfly extends Insects {

	public Butterfly(int nrOfLegs, String name, boolean canFly, boolean isDangerous) {
		super(0.1, 0.0);
		setNrOfLegs(nrOfLegs);
		setName(name);
		setCanFly(canFly);
		setIsDangerous(isDangerous);
	}

	public Butterfly() {
		this(3, "Fluturas", true, false);
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
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Butterfly);
	}
}
