package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception {
		//B1: Xac dinh he quan tri CSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//B2: Ket noi
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-39FGVIL\\SQLEXPRESS:1433;databaseName=QlSach;user=sa; password=123");
		System.out.println("Đã kết nối");
	}
}
