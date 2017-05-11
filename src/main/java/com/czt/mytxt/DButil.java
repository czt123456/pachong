package com.czt.mytxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButil {
	
	private Connection conn =null;
	
	public void addRcorder(Question question) throws SQLException{
		if(conn==null){
			conn=SqlConnection.getConnection();
		}
		String sql="insert into test(question,ans1,ans2,ans3,ans4) values(?,?,?,?,?)";
		
		PreparedStatement preparedStatement =conn.prepareStatement(sql);
		preparedStatement.setString(1, question.getQuestion());
		preparedStatement.setString(2, question.getAns1());
		preparedStatement.setString(3, question.getAns2());
		preparedStatement.setString(4, question.getAns3());
		preparedStatement.setString(5, question.getAns4());
		
		preparedStatement.executeUpdate();
		
	}

}
