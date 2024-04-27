package com.example.lab4_asyncdataloader.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DataParser {
    public static String getCurrencyRatesBaseUsd(InputStream stream) throws IOException{
        String result = "";

        try{
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName("Cube");
            for (int i = 0; i < rateNodes.getLength(); ++i){
                Element rateNode = (Element) rateNodes.item(i);

                if (!rateNode.hasAttribute("currency") || !rateNode.hasAttribute("rate"))
                {
                    continue;
                }

                String currencyName = rateNode.getAttribute("currency");
                String currencyRate = rateNode.getAttribute("rate");
                result += (String.format("%s - %s \n", currencyName, currencyRate));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return result;
    }
}
