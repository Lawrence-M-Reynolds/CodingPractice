package com.reynolds.lawrence.codingPractice.sandbox;

import com.reynolds.lawrence.musicxml.generatedModel.*;
import com.reynolds.lawrence.musicxml.nbf.NoteOrBackupOrForwardProcessor;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.lang.String;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Sandbox tests for music XML with ProxyMusic library investigation.
 *
 * @see
 *      <ul>
 *      	<li><a href="https://www.musicxml.com/for-developers/">musicxml</a></li>
 *      	<li><a href="https://www.w3.org/2017/12/musicxml31/">MusicXML</a></li>
 *      </ul>
 *
 * @author lawrencereynolds
 *
 */
public class TestingMusicXml {
	private static final String OUTPUT_DIRECTORY_PATH = "./output/musicXml";

//	@Test
	public void loadFromFileAndSaveDirectlyBackAgain() throws JAXBException, SAXException, IOException {
		final String testInputFilePath = "musicXml/testForMidiKeyChange.xml";
		final String outputFileName = "testXmlDirectFileOut.xml";

		/*
		Set the logging level of the internal library to investigate the dtd fetching issue.

		Logger logger = Logger.getLogger("");
		logger.addHandler(new FileHandler("%t/JAVA_CUSTOM_DEBUGGING.log"));
		logger.setLevel(Level.ALL);

		Log file was outputted to the temp directory:
		C:\Users\{user dir}\AppData\Local\Temp\JAVA_CUSTOM_DEBUGGING.log

		It turned out that it was being blocked due to the user agent header. So setting
		the value as it was when requesting with chrome.

		(Disabling the external fetching of the DTD didn't work.)

	    */
		System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");

		JAXBContext jc = JAXBContext.newInstance("com.reynolds.lawrence.musicxml.generatedModel");
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		final URL fileURL = this.getClass().getClassLoader().getResource(testInputFilePath);

		final File testInputFile = new File(fileURL.getFile());
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");

		/* XSD's aren't available online so they weren't included via the URL's specified. So
		 * including them as separate sources. */
		URL xmlXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/xml.xsd");
		String xmlXsdResourceFileString = xmlXsdResourceURL.getFile();
		File xmlXsdResourceFile = new File(xmlXsdResourceFileString);
		InputStream xmlXsdResourceFileStream = new FileInputStream(xmlXsdResourceFile);

		URL musicXmlXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/musicxml.xsd");
		String musicXmlXsdResourceFileString = musicXmlXsdResourceURL.getFile();
		File musicXmlXsdResourceFile = new File(musicXmlXsdResourceFileString);
		InputStream musicXmlXsdResourceFileStream = new FileInputStream(musicXmlXsdResourceFile);

		URL xLinkXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/xlink.xsd");
		String xLinkXsdResourceFileString = xLinkXsdResourceURL.getFile();
		File xLinkXsdResourceFile = new File(xLinkXsdResourceFileString);
		InputStream xLinkXsdResourceFileStream = new FileInputStream(xLinkXsdResourceFile);

		Schema schema = schemaFactory.newSchema(new Source[]{
				new SAXSource(new InputSource(xmlXsdResourceFileStream)),
				new SAXSource(new InputSource(xLinkXsdResourceFileStream)),
				new SAXSource(new InputSource(musicXmlXsdResourceFileStream))
		});

		/* The below didn't work. */
//		schema.newValidator().setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "file");
//		schema.newValidator().setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);

		unmarshaller.setSchema(schema);
		ScorePartwise scorePartwise =
				(ScorePartwise) unmarshaller.unmarshal(testInputFile);

		// marshal to file
		final Path outputDirectoryPath = Paths.get(OUTPUT_DIRECTORY_PATH);
		Files.createDirectories(outputDirectoryPath);

		final Path outputFilePath = Paths.get(OUTPUT_DIRECTORY_PATH, outputFileName);


		BufferedWriter os = Files.newBufferedWriter(outputFilePath);

		Marshaller marshaller = jc.createMarshaller();
		marshaller.marshal( scorePartwise, os );
	}

	private void persistPartwiseToXml(String outputFileName, JAXBContext jc, ScorePartwise scorePartwise) throws IOException, JAXBException {
		final Path outputDirectoryPath = Paths.get(OUTPUT_DIRECTORY_PATH);
		Files.createDirectories(outputDirectoryPath);

		final Path outputFilePath = Paths.get(OUTPUT_DIRECTORY_PATH, outputFileName);

		BufferedWriter os = Files.newBufferedWriter(outputFilePath);

		Marshaller marshaller = jc.createMarshaller();
		marshaller.marshal(scorePartwise, os);
	}

	private ScorePartwise loadScorePartwiseFromXML(String testInputFilePath, JAXBContext jc) throws JAXBException, FileNotFoundException, SAXException {
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		final URL fileURL = this.getClass().getClassLoader().getResource(testInputFilePath);

		final File testInputFile = new File(fileURL.getFile());
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		URL xmlXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/xml.xsd");
		String xmlXsdResourceFileString = xmlXsdResourceURL.getFile();
		File xmlXsdResourceFile = new File(xmlXsdResourceFileString);
		InputStream xmlXsdResourceFileStream = new FileInputStream(xmlXsdResourceFile);

		URL musicXmlXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/musicxml.xsd");
		String musicXmlXsdResourceFileString = musicXmlXsdResourceURL.getFile();
		File musicXmlXsdResourceFile = new File(musicXmlXsdResourceFileString);
		InputStream musicXmlXsdResourceFileStream = new FileInputStream(musicXmlXsdResourceFile);

		URL xLinkXsdResourceURL = this.getClass().getClassLoader().getResource("musicXml/musicxml-3.1/schema/xlink.xsd");
		String xLinkXsdResourceFileString = xLinkXsdResourceURL.getFile();
		File xLinkXsdResourceFile = new File(xLinkXsdResourceFileString);
		InputStream xLinkXsdResourceFileStream = new FileInputStream(xLinkXsdResourceFile);

		Schema schema = schemaFactory.newSchema(new Source[]{
				new SAXSource(new InputSource(xmlXsdResourceFileStream)),
				new SAXSource(new InputSource(xLinkXsdResourceFileStream)),
				new SAXSource(new InputSource(musicXmlXsdResourceFileStream))
		});

		unmarshaller.setSchema(schema);
		return (ScorePartwise) unmarshaller.unmarshal(testInputFile);
	}

	/**
	 * TODO - still working out how to manipulate the data so that the voices can be
	 * switched around.
	 * @throws JAXBException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void switchVoicesAround() throws JAXBException, SAXException, IOException {
		final String testInputFilePath = "musicXml/testForMidiKeyChange.xml";
		final String outputFileName = "testXmlVoiceSwitchedFileOut.xml";

		System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");

		JAXBContext jc = JAXBContext.newInstance("com.reynolds.lawrence.musicxml.generatedModel");

		ScorePartwise scorePartwise = loadScorePartwiseFromXML(testInputFilePath, jc);

		for(ScorePartwise.Part part : scorePartwise.getPart()) {
			System.out.println("************\n");
			System.out.println("\tProcessing Part: " + part.getId().getPartNameDisplay().getDisplayTextOrAccidentalText().get(0).getValue());
			for(ScorePartwise.Part.Measure measure : part.getMeasure()){
				System.out.println("\t\tProcessing measure: " + measure.getNumber());
				for(Object noteOrBackupOrForwardValue : measure.getNoteOrBackupOrForward()){
					NoteOrBackupOrForwardProcessor.process(noteOrBackupOrForwardValue);
				}
			}
		}

		persistPartwiseToXml(outputFileName, jc, scorePartwise);

	}

}
