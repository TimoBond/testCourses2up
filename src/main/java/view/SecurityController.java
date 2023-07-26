package view;

import com.home.model.Admin;
import com.home.model.Student;
import com.home.model.Teacher;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/FrontController")

public class SecurityController implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        String comndString = httpServletRequest.getParameter("command");
        String loginPage = configManager.getProperties("login");
        System.out.println(comndString + " security12");
        if ( comndString == null || comndString.equals("")) {
            httpServletRequest.getRequestDispatcher(loginPage).forward(httpServletRequest, httpServletResponse);
            return;
        }if (comndString.equals("login")) {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("User");
        if (user == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getRequestURI());
            return;
        }
        comndString = comndString.toUpperCase();
        System.out.println(comndString + " UP?");
        if (user instanceof Admin) {
            List<String> commandList = Arrays.asList("FIND_USER_BY_TYPE", "DELETE_USER", "GO_UPDATE_USER_COMMAND");
            if (commandList.contains(comndString)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        if (user instanceof Student) {
            List<String> commandList = Arrays.asList("GRADE_COMMAND");
            if (commandList.contains(comndString)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        if (user instanceof Teacher) {
            System.out.println("teacher");
            List<String> commandList = Arrays.asList("GO_UPDATE_USER_COMMAND", "FIND_USER_BY_TYPE", "NEW_GRADE_COMMAND","STUDENTS_BY_LECTURE", "UP_GRADES_STUDENT");
            if (commandList.contains(comndString)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        httpServletRequest.getRequestDispatcher(loginPage).forward(httpServletRequest, httpServletResponse);

    }
}
