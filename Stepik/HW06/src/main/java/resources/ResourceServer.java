package resources;

import org.xml.sax.SAXException;
import xmlparser.SaxHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ResourceServer implements ResourceServerMBean {
    private TestResource testResource;

    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    public ResourceServer() {
    }

    public void setTestResource(TestResource ts){
        this.testResource = ts;
    }

    public void setInstanceFromXml(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        saxParser.parse(xmlFile, handler);


        this.testResource = (TestResource) handler.getObject();
    }


    public int getAge() {
        return testResource.getAge();
    }

    public String getName() {
        return testResource.getName();
    }
}
