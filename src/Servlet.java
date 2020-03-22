

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// セッションスコープの保存領域を確保
		HttpSession session = request.getSession();

		String str = new String();

		// セッションスコープに保存(Servlet -> jsp に値を設定するときに使用)
//		session.setAttribute("visited", "1");

		// セッションスコープからインスタンスを取得
		String year = request.getParameter("year");
//		String year = (String) session.getAttribute("year");

		// TODO DB connect
		try {
			connect();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("year", year);

		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/Kintai.jsp");
		rd.forward(request, response);


//		//リセッションスコープにセット
//		session.setAttribute("year", year);
//		//リダイレクト
//		response.sendRedirect("/KintaiKanri/Kintai.jsp");


//		doGet(request, response);
	}

	public void connect () throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "root";

		try{
			Class.forName("org.postgresql.Driver");

		  conn = DriverManager.getConnection(url, user, password);

		  // データベースに対する処理
		  Statement stmt = conn.createStatement();
		  String sql = "select yyyymm,last_day from m_lastday";
		  ResultSet rs = stmt.executeQuery(sql);
		  rs.next();
//		  String count = rs.getString("count");
		  String yyyymm = rs.getString("yyyymm");
		  String lastday = rs.getString("last_day");
//		  System.out.println(count);
		  System.out.println(yyyymm);
		  System.out.println(lastday);

		} catch (SQLException e) {
			// TODO ERROR
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// 例外処理
				e.printStackTrace();
			}
		}
	}

}
