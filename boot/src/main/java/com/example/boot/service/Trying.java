package com.example.boot.service;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Trying {

    // Method to process Freemarker template
    public StringWriter ftlMethods(String XMLContent, String ftlContent) {
        StringWriter writer = new StringWriter();
        try {
            Configuration msd = new Configuration(Configuration.VERSION_2_3_31);
            Template tem = new Template("template", new StringReader(ftlContent), msd);
//System.out.println(tem);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> dataModel = objectMapper.readValue(XMLContent, Map.class);
            System.out.println(dataModel);
            // Process the template with the data model
            tem.process(dataModel, writer);
            

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return writer;
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/templates/Learn.xml"; 
        String ftlFilePath = "src/main/resources/templates/Learn.ftl"; 
//        String xmlFilePath = "src/main/resources/templates/file.xml"; 
//        String ftlFilePath = "src/main/resources/templates/Ffile.ftl"; 
        String xmlContent = null;
        String ftlContent = null;

        try {
            xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));
           // System.out.println("XML Content:\n" + xmlContent);

            ftlContent = new String(Files.readAllBytes(Paths.get(ftlFilePath)));
            //System.out.println("FTL Content:\n" + ftlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XmlMapper xmlMapper = new XmlMapper();
            Map<String, Object> data = xmlMapper.readValue(xmlContent, Map.class);
            ObjectMapper objectMapper = new ObjectMapper();
            String XMLContent1 = objectMapper.writeValueAsString(data);
            //System.out.println("Converted JSON Content:\n" + XMLContent1);

            Trying obj = new Trying();
            StringWriter writer = obj.ftlMethods(XMLContent1, ftlContent);
//System.out.println(writer);
            System.out.println("Generated Output:\n" + writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}