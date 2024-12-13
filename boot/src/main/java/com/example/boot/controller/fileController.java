package com.example.boot.controller;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.service.SqlService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.example.boot.service.DatabaseService;

@RestController
@RequestMapping("/ftl")

public class fileController {

	@Autowired
	private DatabaseService DatabaseService;

	public List<String> fetchMasterRefId() {
		return DatabaseService.fetchMasterRefIdList();
	}

	@Autowired
	SqlService ftlp;

	public String data() {
		List<String> masterRefId = fetchMasterRefId();
		String data = masterRefId.get(0);
		return data;
	}

	@PostMapping(value = "/xml", consumes = "application/json", produces = "application/json")
	public String generateXml(@RequestBody String jsonContent) {
		try {

			 String ftlContent = new
			 String(Files.readAllBytes(Paths.get("src/main/resources/templates/jsontoxml.ftl")));
//			 String ftlContent = new
//			 String(Files.readAllBytes(Paths.get("src/main/resources/templates/jsontoxmllist.ftl")));
//			String ftlContent = new String(
//					Files.readAllBytes(Paths.get("src/main/resources/templates/jsontoxmldetails.ftl")));
			String xmlOutput = ftlp.processTemplate(jsonContent, ftlContent);
			String mockUrl = "http://bsit-srv04:8003/tiplus2-deploy2/hello";

			XmlMapper xmlMapper = new XmlMapper();

			JsonNode jsonNode = xmlMapper.readTree(xmlOutput);

			ObjectMapper objectMapper = new ObjectMapper();

			String jsonData = objectMapper.writeValueAsString(jsonNode);

			JsonNode rootNode = objectMapper.readTree(jsonData);
			String theirReference = null;

			theirReference = rootNode.path("TFCPCCRT").path("Context").path("TheirReference").asText();

			System.out.println("TheirReference: " + theirReference);

			String data = data();

			 String ftlFilePath = new String(
			 Files.readAllBytes(Paths.get("src/main/resources/templates/xmltojson.ftl")));
//			String ftlFilePath = new
//			String(Files.readAllBytes(Paths.get("src/main/resources/templates/xmltojsonlist.ftl")));
//			String ftlFilePath = new String(
//					Files.readAllBytes(Paths.get("src/main/resources/templates/xmltojsondetails.ftl")));

			String result = ftlp.processMockApi(mockUrl, xmlOutput, ftlFilePath, theirReference, data);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return "Error processing template: " + e.getMessage();
		}
	}

}

