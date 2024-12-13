package com.example.boot.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.service.TemplateService;

@RestController
@RequestMapping("/ftl111")
public class MarkerController {
	
	@Autowired 
	TemplateService ftlp;
//	
//	@PostMapping(value="/Transfer-xml",consumes = "application/json", produces = "application/xml")
//    public ResponseEntity<String> generateXml(@RequestBody String jsonContent) {
//        try {
//            String ftlContent = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/Students.ftl")));
//
//            
//            String xmlOutput = ftlp.processTemplate(jsonContent, ftlContent);
//
//            return ResponseEntity.ok(xmlOutput); 
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error processing template: " + e.getMessage());
//        }
//    }
//	@GetMapping("/xml")
//	public ResponseEntity<String> getuser() {
//		 String xmlOutput = ftlp.getxml();
//		 return ResponseEntity.ok(xmlOutput); 
//	}
//}


@PostMapping(value = "/xml", consumes = "application/json")
public String generateXml(@RequestBody String jsonContent) {
    try {
        String ftlContent = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/Students.ftl")));
        

        
        String xmlOutput = ftlp.processTemplate(jsonContent, ftlContent);
         
        String mockUrl = "https://kishore.free.beeceptor.com/xml"; 
       // String xmlOutput = ftlp.processTemplate(jsonContent, ftlContent);
        String ftlFilePath = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/xmltojson.ftl"))); 
        
            String result = ftlp.TemplateService(mockUrl, xmlOutput, ftlFilePath);
            System.out.println("Final Output: " + result);
         


        return result;
        //return result;
        //return "view data in get method";
    } catch (Exception e) {
        e.printStackTrace();
        return "Error processing template: " + e.getMessage();
    }
}
}
