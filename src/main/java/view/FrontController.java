package view;

import com.home.controller.business.Command;
import com.home.controller.business.CommandFactory;
import com.home.controller.business.service.CourseService;
import com.home.controller.business.service.LectureService;
import com.home.controller.business.service.UserService;
import com.home.controller.storage.DAOFactory;
import com.home.controller.storage.dao.CourseDAO;
import com.home.controller.storage.dao.LectureDAO;
import com.home.controller.storage.dao.UserDAO;
import com.home.model.Course;
import com.home.model.Lecture;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

    @WebServlet(name = "FrontController", value = "/FrontController")
    public class FrontController extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            process(request, response);
        }

        public void init() {
            // тут храниться нужные все веши для общего пользовования
            // инит иницианилзируеться при создание сервлета, и уже сидит в нем
            ConfigManager configManager = ConfigManager.getConfigManager();
            getServletContext().setAttribute("ConfigManager", configManager);
            DAOFactory daoFactory = DAOFactory.getDaoFactory();
            System.out.println(daoFactory);
            getServletContext().setAttribute("Factory", daoFactory);
            UserDAO userDAO = (UserDAO) daoFactory.getDAO(User.class);
            UserService userService = new UserService(userDAO);
            getServletContext().setAttribute("UserService", userService);
            LectureDAO lectureDAO = (LectureDAO)  daoFactory.getDAO(Lecture.class);
            LectureService lectureService = new LectureService(lectureDAO);
            getServletContext().setAttribute("LectureService",lectureService);
            CourseDAO courseDAO =(CourseDAO) daoFactory.getDAO(Course.class);
            CourseService courseService=  new CourseService(courseDAO);
            getServletContext().setAttribute("CourseService",courseService);

        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            process(request, response);
        }

        private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Command command = CommandFactory.getCommand(request);
            String page = command.execute(request);
            if(page != null){
                request.getRequestDispatcher(page).forward(request,response);
            }

        }
    }


