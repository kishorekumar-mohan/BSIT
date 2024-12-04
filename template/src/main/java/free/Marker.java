package free;


import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.*;
import java.util.Map;


public class Marker {

	
	public void ftlTOxml() throws StreamReadException, DatabindException, IOException {
		try {
            // Step 1: Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> data = objectMapper.readValue(new File("D:/Free Marker/Untitled-1.json"), Map.class);

            // Step 2: Configure Freemarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File("D:/Free Marker"));
            Template template = cfg.getTemplate("Students.ftl");

            // Step 3: Generate XML file
            File outputFile = new File("D:/Free Marker/output.xml");
            try (Writer fileWriter = new FileWriter(outputFile)) {
                template.process(data, fileWriter);
            }

            System.out.println("XML file generated successfully");

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

}
public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	Marker m = new Marker();
	m.ftlTOxml();
}
}