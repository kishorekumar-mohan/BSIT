package com.example.boot.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.service.DatabaseService;
import com.example.boot.service.TemplateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import freemarker.template.TemplateException;

import java.util.logging.Logger;

@RestController
@RequestMapping("/ftlCheck")
@Component
public class FileController {

	private final TemplateService jjService;

	private final DatabaseService databaseService;
	
	 public FileController(TemplateService jjService, DatabaseService databaseService) {
		super();
		this.jjService = jjService;
		this.databaseService = databaseService;
	}


	Logger logger = Logger.getLogger(getClass().getName());

	public List<String> fetchMasterRefId() {
		return databaseService.fetchMasterRefIdList();
	}

	public String dataForMasterID() {
		List<String> masterRefId = fetchMasterRefId();
		String data = masterRefId.get(0);
		logger.info(data);
		return data;
	}
	

	@PostMapping(value = "/JtoJ", consumes = "application/json", produces = "application/json")
	public String generateXml(@RequestBody String jsonContent) throws IOException, TemplateException {
	

			String ftlContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\Kishore kumar\\eclipse-workspace\\boot\\src\\main\\resources\\templates\\jsontoxml.ftl")));

			String xmlOutput = jjService.processTemplate(jsonContent, ftlContent);
			logger.info(xmlOutput);
			String mockUrl = "http://bsit-srv04:8003/tiplus2-deploy2/hello";
			
			XmlMapper xmlMapper = new XmlMapper();

			JsonNode jsonNode = xmlMapper.readTree(xmlOutput);

			ObjectMapper objectMapper = new ObjectMapper();

			String jsonData = objectMapper.writeValueAsString(jsonNode);

			JsonNode rootNode = objectMapper.readTree(jsonData);

			String theirReference = rootNode.path("TFCPCCRT").path("Context").path("TheirReference").asText();

			String dataMasterID = dataForMasterID();
			logger.info(theirReference);
			
			String ftlFilePath = new String(Files.readAllBytes(Paths.get("C:\\Users\\Kishore kumar\\eclipse-workspace\\boot\\src\\main\\resources\\templates\\xmltojson.ftl")));

			return TemplateService.processMockApi(mockUrl, xmlOutput, ftlFilePath, theirReference, dataMasterID);

					
	

}
}