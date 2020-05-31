package com.zhaopengLiu.abstractFactoryPattern;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * data: 2020年05月10日
 * author: zhaopengLiu
 * description: 客户调用方
 */
public class FactoryClient {

    public static void main(String[] args) {
        AbstractFactory factory = getFactory();
        AbstractProduct product = factory.getProduct();
        product.tel();
        product.box();
    }

    public static AbstractFactory getFactory() {
        AbstractFactory factory = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/com/zhaopengLiu/abstractFactoryPattern/factory.xml");
            NodeList nodeList = document.getElementsByTagName("Factory");
            Node factoryNode = nodeList.item(0).getFirstChild();
            String className = factoryNode.getNodeValue();
            System.out.println("noveValue:" + className);
            Class<?> factoryClass = Class.forName(className);
            factory = (AbstractFactory) factoryClass.newInstance();
        } catch (SAXException | ParserConfigurationException | IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
