package com.tyss.mobileapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tyss.mobileapp.dto.MobileBean;

public class MobileDAOImpl implements MobileDAO {

	public List<MobileBean> getAllContacts() {
		String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
		String sql = "select * from Contact";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			ArrayList<MobileBean> result = new ArrayList<MobileBean>();
			while (rs.next()) {
				MobileBean bean = new MobileBean();

				String name = rs.getString("name");
				bean.setName(name);
				int number = rs.getInt("number");
				bean.setNumber(number);
				String group = rs.getString("group_name");
				bean.setGroup(group);

				result.add(bean);
			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end of try-catch-finally

	} // end of getAllContacts
	// **********************************************************************************

	public MobileBean showOneDetail(String name) {
		
	
 
		String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
		String sql = "select * from Contact where name =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "name");
			rs = pstmt.executeQuery();

			if(rs.next()) {
				MobileBean bean = new MobileBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setGroup(rs.getString("group_name"));
				return bean;
			}else {
				return null;
			}


		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}if(pstmt!=null) {
					pstmt.close();
				}if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}//end of try-catch-finally
		}
	}//end of showOneDetail


	}// end of MobileDAOImpl



// =================================================================


