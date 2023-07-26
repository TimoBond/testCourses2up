package view;

import com.home.controller.business.service.UserService;
import com.home.model.Student;
import com.home.model.Teacher;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@WebServlet (name = "UploadController", value = "/UploadController")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("picture");
        byte[] photo = IOUtils.toByteArray(filePart.getInputStream());
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("selectedUser");
        user.setPhoto(photo);
        String path = request.getServletContext().getRealPath("/resources/images/"+ user.getId() +".jpg");
        OpenOption[] openOption = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        Files.write(Path.of(path),photo,openOption);
        ConfigManager configManager = (ConfigManager) request.getServletContext().getAttribute("ConfigManager");
        user.setPhoto(photo);
        UserService userService = (UserService) request.getServletContext().getAttribute("UserService");
       boolean p =  userService.updatePhoto(user);
        System.out.println(p + " фото удалось?");
        httpSession.setAttribute("selectedUser",user);
        if(user instanceof Teacher){
            getServletContext().getRequestDispatcher("/" + configManager.getProperties("updateTeacher"))
                    .forward(request,response); // передача управление другому сервлету
        }if(user instanceof Student){
            configManager.getProperties("updateStudent");
        }
    }



}
