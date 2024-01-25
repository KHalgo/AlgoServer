package com.algo.mvc.company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

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
	
	public List<Company> findAll(Connection connection, PageInfo pageInfo){
		List<Company> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM ( "
				+ "SELECT ROWNUM AS RNUM, INDUSTRY_ID, INDUSTRY_NAME, INDUSTRY_LOCATION, INDUSTRY_TYPE, IN_READCOUNT, INDUSTRY_DATE, BASE_RATE, COUNT "
				+ "    FROM ( "
				+ "         SELECT I.INDUSTRY_ID AS INDUSTRY_ID, "
				+ "          MAX(I.INDUSTRY_NAME    )   AS  INDUSTRY_NAME, "
				+ "          MAX(I.INDUSTRY_LOCATION)   AS  INDUSTRY_LOCATION, "
				+ "          MAX(I.INDUSTRY_TYPE    )   AS  INDUSTRY_TYPE, "
				+ "          MAX(I.IN_READCOUNT     )   AS  IN_READCOUNT, "
				+ "          MAX(I.INDUSTRY_DATE    )   AS  INDUSTRY_DATE, "
				+ "          ROUND(AVG(NVL(R.BASE_RATE,0)),1) AS BASE_RATE, "
				+ "          COUNT(R.BASE_RATE) AS COUNT "
				+ "      FROM INDUSTRY I "
				+ "      LEFT OUTER JOIN "
				+ "           INDUSTRY_REVIEW R "
				+ "        ON R.INDUSTRY_ID = I.INDUSTRY_ID "
				+ "     GROUP BY "
				+ "           I.INDUSTRY_ID "
				+ "     ORDER BY "
				+ "		BASE_RATE DESC "
				+ "    ) "
				+ ") "
				+ "WHERE RNUM BETWEEN ? and ?";	
		
		// if (value="score") {
		//	query += "BASE_RATE DESC ";
		// }
		
		// query += "    ) "
		//		+ ") "
		//		+ "WHERE RNUM BETWEEN ? and ?";	
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Company company = new Company();
				
				company.setIndustryID(rs.getInt("INDUSTRY_ID"));
				company.setInRowNum(rs.getInt("RNUM"));
				company.setIndustryName(rs.getString("INDUSTRY_NAME"));
				company.setIndustryLc(rs.getString("INDUSTRY_LOCATION"));
				company.setIndustryType(rs.getString("INDUSTRY_TYPE"));
				company.setReadCount(rs.getInt("IN_READCOUNT"));
				company.setIndustryDate(rs.getDate("INDUSTRY_DATE"));
				company.setBaseRate(rs.getDouble("BASE_RATE"));
				company.setCount(rs.getInt("COUNT"));
				
				list.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public Company findCompanyById(Connection connection, int industryID) {
		Company company = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query="SELECT I.INDUSTRY_ID AS INDUSTRY_ID "
				+ "     , MAX(I.INDUSTRY_NAME    )   AS  INDUSTRY_NAME "
				+ "     , MAX(I.INDUSTRY_LOCATION)   AS  INDUSTRY_LOCATION "
				+ "     , MAX(I.INDUSTRY_TYPE    )   AS  INDUSTRY_TYPE "
				+ "     , MAX(I.INDUSTRY_HOME    )   AS  INDUSTRY_HOME "
				+ "     , MAX(I.IN_READCOUNT     )   AS  IN_READCOUNT "
				+ "     , MAX(I.INDUSTRY_DATE    )   AS  INDUSTRY_DATE "
				+ "     , ROUND(AVG(NVL(R.BASE_RATE,0)),1) AS BASE_RATE "
				+ "     , COUNT(R.BASE_RATE) AS COUNT "
				+ "     , MAX(R.POST_COMMENT) AS POST_COMMENT "
				+ "     , ROUND(AVG(NVL(R.DETAIL_RATE1,0)),1) AS DETAIL_RATE1 "
				+ "     , ROUND(AVG(NVL(R.DETAIL_RATE2,0)),1) AS DETAIL_RATE2 "
				+ "     , ROUND(AVG(NVL(R.DETAIL_RATE3,0)),1) AS DETAIL_RATE3 "
				+ "     , ROUND(AVG(NVL(R.DETAIL_RATE4,0)),1) AS DETAIL_RATE4 "
				+ "  FROM INDUSTRY I "
				+ "  LEFT OUTER JOIN "
				+ "       INDUSTRY_REVIEW R "
				+ "    ON R.INDUSTRY_ID = I.INDUSTRY_ID "
				+ "  WHERE I.INDUSTRY_ID = ? "
				+ "  GROUP BY "
				+ "       I.INDUSTRY_ID ";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, industryID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				company = new Company();
				
				company.setIndustryID(rs.getInt("INDUSTRY_ID"));
				company.setIndustryName(rs.getString("INDUSTRY_NAME"));
				company.setIndustryLc(rs.getString("INDUSTRY_LOCATION"));
				company.setIndustryType(rs.getString("INDUSTRY_TYPE"));
				company.setIndustryHp(rs.getString("INDUSTRY_HOME"));
				company.setReadCount(rs.getInt("IN_READCOUNT"));
				company.setIndustryDate(rs.getDate("INDUSTRY_DATE"));
				company.setBaseRate(rs.getDouble("BASE_RATE"));
				company.setCount(rs.getInt("COUNT"));
				company.setBestComment(rs.getString("POST_COMMENT"));
				company.setDetailRate1(rs.getDouble("DETAIL_RATE1"));
				company.setDetailRate2(rs.getDouble("DETAIL_RATE2"));
				company.setDetailRate3(rs.getDouble("DETAIL_RATE3"));
				company.setDetailRate4(rs.getDouble("DETAIL_RATE4"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return company;
	}

	public int insertComment(Connection connection, CompanyComment comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO INDUSTRY_REVIEW VALUES (SEQ_INDUSTRY_REVIEW_NO.NEXTVAL, ?, ?, ?, DEFAULT, ?, ?, ?, ?, ?, DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1 , comment.getIndustryID());
			pstmt.setDouble(2, comment.getBaseRate());
			pstmt.setString(3, comment.getPostComment());
			pstmt.setDouble(4, comment.getDetailRate1());
			pstmt.setDouble(5, comment.getDetailRate2());
			pstmt.setDouble(6, comment.getDetailRate3());
			pstmt.setDouble(7, comment.getDetailRate4());
			pstmt.setString(8, comment.getUserID());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public List<Company> findLocal(Connection connection, PageInfo pageInfo, Users loginMember){
		List<Company> list2 = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM ( "
				+ "SELECT ROWNUM AS RNUM, INDUSTRY_ID, INDUSTRY_NAME, INDUSTRY_LOCATION, INDUSTRY_TYPE, IN_READCOUNT, BASE_RATE, COUNT "
				+ "    FROM ( "
				+ "         SELECT I.INDUSTRY_ID AS INDUSTRY_ID, "
				+ "          MAX(I.INDUSTRY_NAME    )   AS  INDUSTRY_NAME, "
				+ "          MAX(I.INDUSTRY_LOCATION)   AS  INDUSTRY_LOCATION, "
				+ "          MAX(I.INDUSTRY_TYPE    )   AS  INDUSTRY_TYPE, "
				+ "          MAX(I.IN_READCOUNT     )   AS  IN_READCOUNT, "
				+ "          ROUND(AVG(NVL(R.BASE_RATE,0)),1) AS BASE_RATE, "
		        + "          COUNT(R.INDUSTRY_ID) AS COUNT "
				+ "      FROM INDUSTRY I "
				+ "      LEFT OUTER JOIN "
				+ "           INDUSTRY_REVIEW R "
				+ "        ON R.INDUSTRY_ID = I.INDUSTRY_ID "
				+ "		 WHERE I.INDUSTRY_LOCATION LIKE ? "
				+ "     GROUP BY "
				+ "           I.INDUSTRY_ID "
				+ "     ORDER BY "
				+ "			BASE_RATE DESC "
				+ "    ) "
				+ ") "
				+ "WHERE RNUM BETWEEN ? and ?";	
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, "%" + loginMember.getSigungu());
			pstmt.setInt(2, pageInfo.getStartList());
			pstmt.setInt(3, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Company company = new Company();
				
				company.setIndustryID(rs.getInt("INDUSTRY_ID"));
				company.setInRowNum(rs.getInt("RNUM"));
				company.setIndustryName(rs.getString("INDUSTRY_NAME"));
				company.setIndustryLc(rs.getString("INDUSTRY_LOCATION"));
				company.setIndustryType(rs.getString("INDUSTRY_TYPE"));
				company.setReadCount(rs.getInt("IN_READCOUNT"));
				company.setBaseRate(rs.getDouble("BASE_RATE"));
				company.setCount(rs.getInt("COUNT"));
				
				list2.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list2;
	}


}
