package free;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

import org.json.JSONObject;

public class Marker3 {
	
    public StringWriter ftlMethods(String jsonContent, String ftlContent) {
        StringWriter writer = new StringWriter();
        try {
            // Configure Freemarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
             cfg.setDefaultEncoding("UTF-8");

            // Load template from content
            Template template = new Template("hospitalTemplate", new StringReader(ftlContent), cfg);

            // Convert JSON string to Map
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> dataModel = objectMapper.readValue(jsonContent, Map.class);

            // Process template with data model
            template.process(dataModel, writer);

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return writer;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:/Free Marker/Untitled-1.json";
        String filePath2 = "D:/Free Marker/Students.ftl";
        String jsonContent = null;
        String ftlContent = null;

        try {
            // Read JSON file
            jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);
            System.out.println("JSON Content: " + jsonContent);

            // Read FTL template
            ftlContent = new String(Files.readAllBytes(Paths.get(filePath2)));
            System.out.println("FTL Content: " + ftlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Process template
        Marker3 hdp = new Marker3();
        StringWriter writer = hdp.ftlMethods(jsonContent, ftlContent);

        // Write the output to a file
//        try (FileWriter fileWriter = new FileWriter("D:/Free Marker/marker.xml")) {
//            fileWriter.write(writer.toString());
            System.out.println(writer);
//            System.out.println("Output generated in xml");
//        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
