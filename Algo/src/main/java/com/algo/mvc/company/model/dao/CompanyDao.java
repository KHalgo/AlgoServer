package com.algo.mvc.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.vo.Company;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

public class CompanyDao {
	public int getCompanyCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM INDUSTRY";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	public List<Company> findAll(Connection connecton, PageInfo pageInfo){
		List<Company> list = new ArrayList<>();
		
		Company company = new Company();
		
		return list;
	}
}
