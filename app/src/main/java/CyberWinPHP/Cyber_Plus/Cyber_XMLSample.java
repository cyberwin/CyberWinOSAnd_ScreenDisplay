package CyberWinPHP.Cyber_Plus;


import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Cyber_XMLSample {

    public    HashMap<String, String>  splitS(String xml) {
        return  split(xml);
    }
    public HashMap split(String xml){

        LogToFile.d("xml", "aa23xm开始解析= " + xml);


        HashMap hm_ret=new HashMap();
        //hm.put("11","");
        //hm.g
        // step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        System.out.println("class name: " + dbf.getClass().getName());
        // step 2:获得具体的dom解析器
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            //   e.printStackTrace();
        }

//  System.out.println("class name: " + db.getClass().getName());

// step3: 解析一个xml文档，获得Document对象（根结点）
        Document document = null;
        try {
            InputStream   in_withcode   =   new   ByteArrayInputStream(xml.getBytes("UTF-8"));

            document = db.parse(in_withcode);//new File("candidate.xml"));

            //e.printStackTrace();
        } catch (SAXException e) {
            return hm_ret;
        } catch (IOException e) {
            // e.printStackTrace();
            return hm_ret;
        }

        //  NodeList list = document.getElementsByTagName("PERSON");

        //Element element_root = (Element)document.getElementsByTagName("root");

        NodeList root_list = document.getChildNodes();

        Node root_node =  root_list.item(0);

        LogToFile.d("xml",root_node.getNodeName()+"="+root_node.toString());
        //  Node root_node=document.get

        NodeList cwpd_node_list = root_node.getChildNodes();

        for(int i = 0; i < cwpd_node_list.getLength(); i++) {
            Element element = (Element) cwpd_node_list.item(i);


            //String content = element.getElementsByTagName("NAME").item(0).getFirstChild().getNodeValue();
            //System.out.println("name:" + content);
            //   LogToFile.d("xml",element.getTagName()+element.getTextContent());

            hm_ret.put(element.getTagName(),element.getTextContent());
        }

        return hm_ret;
    }
}
