package livehouse_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class livehouse_mysql {
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	public static void command1() {
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con=DriverManager.getConnection(
			"jdbc:mysql://ip:port/livehouse_db","user","password"); 
			
			stmt=con.createStatement(); 
			//삽입
			//stmt.executeUpdate("INSERT INTO Book(bookid, bookname, publisher) VALUES(30, '추가된책', 'gminj');");
			//삭제
			//stmt.executeUpdate("DELETE FROM Book WHERE bookid = '30';");
			//rs=stmt.executeQuery("SELECT * FROM artists"); 
			//while(rs.next()) 
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+
			//" "+rs.getString(3)); 
			//con.close();
			System.out.println("연결되었습니다.");
			}catch(Exception e){ System.out.println(e);} 
	}
	public static void menu() {
		System.out.println("====================");
		System.out.println("1. connection");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. ");
		System.out.println("7. ");
		System.out.println("8. ");
		System.out.println("9. quit");
		System.out.println("====================");
		System.out.print("번호를 입력해주세요: ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = -1;
		while(n!=9) {
			menu();
			n = sc.nextInt();
			
			switch(n) {
				case 1:
					command1();
					break;
				case 9:
					try {
						con.close();
					}catch(Exception e) {System.out.println(e);}
					break;
				default:
					System.out.println("1~9까지 명령 중 선택해주세요.");
					break;
			}
				
				
		}
		System.out.println("종료");
		
	}

}
