package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid = "NOTICE";
	private String pwd = "NOTICE";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10; // 1page 1, 2page 11, 3page 21... 등차수열 a1 + (n-1)*d
		int end = 10 * page; // 1page 10, 2page 20, 3page 30...

		String sql = "SELECT * FROM NOTICE WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String regDate = rs.getString("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writerId, null, content, hit, files);

			list.add(notice);
		}

		st.close();
		con.close();
		rs.close();

		return list;

	}

}