package com.example.boot.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> fetchMasterRefIdList() {
	    String sql = "SELECT SUBSTR(GWY.ERR_TXT, INSTR(GWY.ERR_TXT, 'Master', -1, 1) + 7, 16) AS MASTER_REF " +
	                 "FROM GWYIN GWY " +
	                 "WHERE THEIR_REF = 'TR-001001' AND GWY.MESS_TYPE = 'TFCPCCRT'";
	    try {
	        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("MASTER_REF"));
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}
}