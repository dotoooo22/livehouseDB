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
	public static void command2() {
		try {
			rs=stmt.executeQuery("SELECT * FROM artists");
			System.out.println("AId /Name /Phone");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3));
			}
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command3() {
		try {
			rs=stmt.executeQuery("SELECT * FROM customer");
			System.out.println("CId /Name /Phone /EId");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command4() {
		try {
			rs=stmt.executeQuery("SELECT * FROM events");
			System.out.println("EId /Date /Time /Price /LId");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getDate(2) + " " + rs.getTime(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
			}
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command5() {
		try {
			rs=stmt.executeQuery("SELECT * FROM livehouse");
			System.out.println("LId /Name /Location /Capacity");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command6() {
		try {
			rs=stmt.executeQuery("SELECT * FROM participate");
			System.out.println("AId /EId");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2));
			}
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command7() {
		Scanner in = new Scanner(System.in);
		System.out.print("아티스트를 알고 싶은 이벤트의 EId: ");
		int eid = in.nextInt();
		try {
			rs=stmt.executeQuery("SELECT artists.Name AS ArtistName FROM artists JOIN participate ON artists.AId = participate.AId WHERE participate.EId = " + eid);
			System.out.print(eid + "에 참여하는 아티스트는 ");
			while(rs.next()) {
				System.out.print(rs.getString(1) + ", ");
			}
			System.out.println("입니다.");
		}catch(Exception e) { System.out.println(e);}
		
	}
	public static void command8() {
		Scanner in = new Scanner(System.in);
		System.out.print("query를 입력하세요 : ");
		String q = in.nextLine();
		//System.out.println(q);
		try {
			stmt.executeUpdate(q);
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command9() {
		Scanner in = new Scanner(System.in);
		System.out.print("날짜를 입력하세요(xxxx-xx-xx): ");
		String d = in.nextLine();
		try {
			rs=stmt.executeQuery("SELECT artists.Name AS ArtistName\r\n"
					+ "FROM artists\r\n"
					+ "JOIN events ON events.EId\r\n"
					+ "WHERE events.Date = " + "'" + d + "'" + ";");
			System.out.print(d + "에 공연하는 아티스트는 ");
			while(rs.next()) {
				System.out.print(rs.getString("ArtistName") + ", ");
			}
			System.out.println("입니다.");
		}catch(Exception e) { System.out.println(e);}
	}
	public static void command10() {
		Scanner in = new Scanner(System.in);
		System.out.print("event의 아이디를 입력하세요: ");
		int num = in.nextInt();
		try {
			rs=stmt.executeQuery("SELECT COUNT(*) AS Cuscount FROM customer WHERE EId = " + num + ";");
			System.out.print("Eid=" + num + "의 관람객은 ");
			while(rs.next()) {
				System.out.println(rs.getInt("Cuscount")+"명입니다.");
			}
			
		}catch(Exception e) { System.out.println(e);}
	}
	public static void menu() {
		System.out.println("====================");
		System.out.println("1. connection");
		System.out.println("2. 아티스트 목록 보기");
		System.out.println("3. 고객 목록 보기");
		System.out.println("4. 이벤트 목록 보기");
		System.out.println("5. 라이브하우스 목록 보기");
		System.out.println("6. participate table 보기");
		System.out.println("7. 어떤 아티스트가 참여하는지 보기");
		System.out.println("8. 직접 삽입/삭제 쿼리 입력하기");
		System.out.println("9. 특정 날짜에 공연하는 아티스트보기");
		System.out.println("10. 관객이 몇명인지 보기");
		System.out.println("99. quit");
		System.out.println("====================");
		System.out.print("번호를 입력해주세요: ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = -1;
		while(n!=99) {
			menu();
			n = sc.nextInt();
			
			switch(n) {
				case 1:
					command1();
					break;
				case 2:
					command2();
					break;
				case 3:
					command3();
					break;
				case 4:
					command4();
					break;
				case 5:
					command5();
					break;
				case 6:
					command6();
					break;
				case 7:
					command7();
					break;
				case 8:
					command8();
					break;
				case 9:
					command9();
					break;
				case 10:
					command10();
					break;
				case 99:
					try {
						con.close();
					}catch(Exception e) {System.out.println(e);}
					break;
				default:
					System.out.println("1~99까지 명령 중 선택해주세요.");
					break;
			}
			
		}
		try {
			con.close();
		}catch(Exception e) {System.out.println(e);}
		System.out.println("종료");
		
	}

}
