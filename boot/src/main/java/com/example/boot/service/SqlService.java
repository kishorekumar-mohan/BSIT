package com.example.boot.service;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SqlService {
	
	@Autowired
	private DatabaseService DatabaseService;

	public List<String> fetchMasterRefId() {
		return DatabaseService.fetchMasterRefIdList();
	}

	public static String generateCorrelationId() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString();
	}

	public String processTemplate(String jsonContent, String ftlContent) {
		StringWriter writer = new StringWriter();
		try {
			Configuration confi = new Configuration(Configuration.VERSION_2_3_31);
			Template templ = new Template("template", new StringReader(ftlContent), confi);
			ObjectMapper objMapper = new ObjectMapper();
			Map<String, Object> dataModel = objMapper.readValue(jsonContent, Map.class);

			String CorrelationId = generateCorrelationId();
			dataModel.put("correlationId", CorrelationId);
			List<String> masterRefId = fetchMasterRefId();
			String data = masterRefId.get(0);
			dataModel.put("masterReferenceId", data);
			templ.process(dataModel, writer);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}

		return writer.toString();

	}

	public static String processMockApi(String url, String requestBody, String ftlFilePath, String theirReference,
			String data) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type", "application/xml");

		HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {

			String xmlResponse = response.getBody();

			XmlMapper xmlMapper = new XmlMapper();

			Map<String, Object> data1 = xmlMapper.readValue(xmlResponse, Map.class);

			ObjectMapper objectMapper = new ObjectMapper();

			String jsonContent = objectMapper.writeValueAsString(data1);

			StringWriter out = new StringWriter();

			try {
				Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
				Template template = new Template("template", new StringReader(ftlFilePath), cfg);
				Map<String, Object> dataModel = objectMapper.readValue(jsonContent, Map.class);
				dataModel.put("theirReference", theirReference);
				dataModel.put("masterId", data);
				System.out.println(dataModel);
				template.process(dataModel, out);
			} catch (IOException e) {
				e.printStackTrace();

			}
			return out.toString();
		} else {
			throw new Exception("Failed to fetch the mock URL response.");
		}
	}

}


