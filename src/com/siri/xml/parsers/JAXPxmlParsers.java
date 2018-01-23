package com.siri.xml.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JAXPxmlParsers {

    public static void main(String[] args){
        //JAXP (Java API for XML Processing) is a rather outdated umbrella
        // term covering the various low-level XML APIs in JavaSE, such as
        // DOM - DOM reads XML files and stores in tree format
        // , SAX - reads in even based format
        // and StAX.
        //JAXP is used to validate, parse xml to java objects

        //let's do DOM parsing using Apache in build implememtation xcer

        //step1: create DocumentBuilderFactory
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();

        //step2: create DocumentBuilder class
        try{
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            //step3:  parse the DOM
            File myXMLfile=new File("sample.xml");

            //read file sequentially and store in dom
            Document document=documentBuilder.parse(myXMLfile);

            //get root element from document
            Element element = document.getDocumentElement();
            //System.out.println(element.getNodeName());

            //get all child elements
            NodeList childElements = element.getChildNodes();

            //loop through child elements and print them
            for(int i=0;i<childElements.getLength();i++){
                Node child=childElements.item(i);
                //this check is required to remove space node and will only print document node
                if(child.getNodeType()==Node.ELEMENT_NODE){
                    //will print space node as #text in output(to avoid this check the node type)
                    System.out.println(child.getNodeName()+": "+child.getTextContent());
                }


            }
        }
        catch(ParserConfigurationException | IOException | SAXException e )
        {
            System.out.println(e.getStackTrace());
        }

    }

}
