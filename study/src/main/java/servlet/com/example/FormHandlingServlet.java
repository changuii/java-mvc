package servlet.com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormHandlingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("📝 폼 페이지 요청 (GET)");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>📝 폼 테스트</h1>");
        out.println("<form method='post' action='/form'>");
        out.println("  <p>이름: <input type='text' name='name' placeholder='이름을 입력하세요'></p>");
        out.println("  <p>메시지: <textarea name='message' placeholder='메시지를 입력하세요'></textarea></p>");
        out.println("  <p><button type='submit'>POST로 전송</button></p>");
        out.println("</form>");
        out.println("<hr>");
        out.println("<p><a href='/method'>HttpMethodServlet으로 GET 요청 보내기</a></p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("📮 폼 데이터 처리 (POST)");
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터 읽기
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        System.out.println("📋 받은 데이터 - 이름: " + name + ", 메시지: " + message);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>📮 POST 처리 결과</h1>");
        out.println("<p><strong>이름:</strong> " + (name != null ? name : "입력 없음") + "</p>");
        out.println("<p><strong>메시지:</strong> " + (message != null ? message : "입력 없음") + "</p>");
        out.println("<p><a href='/form'>다시 폼으로 돌아가기</a></p>");
        out.println("</body></html>");
    }
}

