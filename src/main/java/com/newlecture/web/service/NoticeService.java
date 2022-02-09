package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.newlecture.web.entity.Notice;

@Service
public class NoticeService {
	/*
	 * private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; private String
	 * uid = "NOTICE"; private String pwd = "NOTICE"; private String driver =
	 * "oracle.jdbc.driver.OracleDriver";
	 */
	
	@Autowired
	private DataSource dataSource;

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10; // 1page 1, 2page 11, 3page 21... 등차수열 a1 + (n-1)*d
		int end = 10 * page; // 1page 10, 2page 20, 3page 30...

		String sql = "SELECT * FROM NOTICE";

		/*
		 * Class.forName(driver); 
		 * Connection con = DriverManager.getConnection(url, uid, pwd);
		 */
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			int no = rs.getInt("NO");
			String title=rs.getString("TITLE");
			String writerId=rs.getString("WRITER_ID");
			Date regDate=rs.getDate("REGDATE");
			String content=rs.getString("CONTENT");
			int hit= rs.getInt("HIT");
			String files = rs.getString("FILES");

			Notice notice = new Notice(no, title, writerId, regDate, content, hit, files);

			list.add(notice);
		}
		st.close();
		con.close();
		rs.close();

		return list;
	}
	
	public int getCount() throws ClassNotFoundException, SQLException{
		int count = 0;
		String sql = "SELECT COUNT(no) COUNT FROM NOTICE";
		
		/*
		 * Class.forName(driver); 
		 * Connection con = DriverManager.getConnection(url, uid, pwd);
		 */
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			count = rs.getInt("COUNT");
		}
		rs.close();
		st.close();
		con.close();

		return count;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException{
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "INSERT INTO NOTICE ( "+" title," + " writer_id," + "content," + "files" + ") VALUES(?,?,?,?)" ;
		
		/*
		 * Class.forName(driver); 
		 * Connection con = DriverManager.getConnection(url, uid, pwd);
		 */
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}