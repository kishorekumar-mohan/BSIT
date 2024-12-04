package free;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

public class Marker2 {

    public void generateXmlFromJson(String jsonFilePath, String templateFilePath) {
        try {
            // Step 1: Parse JSON file into a Map
            Map<String, Object> jsonData = new ObjectMapper().readValue(new File(jsonFilePath), Map.class);

            // Step 2: Configure Freemarker and load the template
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File(new File(templateFilePath).getParent()));
            Template template = cfg.getTemplate(new File(templateFilePath).getName());

            // Step 3: Process the template and output the result to the console
            StringWriter stringWriter = new StringWriter();
            template.process(jsonData, stringWriter);

            // Print XML to console
            System.out.println("Generated XML Output:\n");
            System.out.println(stringWriter.toString());
            
//            System.out.println("Json");
//            System.out.println(jsonData);
//            System.out.println("FTL");
//            System.out.println(templateFilePath);

        } catch (Exception e) {
            System.err.println("Error generating XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example paths (update these based on your actual file locations)
        String jsonFilePath = "D:/Free Marker/Untitled-1.json";
        String templateFilePath = "D:/Free Marker/Students.ftl";

        // Create Marker instance and generate XML
        new Marker2().generateXmlFromJson(jsonFilePath, templateFilePath);
        
        
    }
}
