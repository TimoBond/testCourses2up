package com.home.controller.business;

import com.home.controller.business.service.UserService;
import com.home.model.Teacher;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FindUsersByTypeCommand implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        System.out.println("popalo v f user");
        String userType =  httpServletRequest.getParameter("userType");
        UserService userService  =(UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        List<User> userList = userService.findUsers(userType);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getId());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        if(userType.equals("teacher")){
//            Files.delete(Path.of(httpServletRequest.getServletContext().getRealPath("resources/images")));
//            Files.createDirectory(Path.of(httpServletRequest.getServletContext().getRealPath("resources/images")));
            File file = new File(httpServletRequest.getServletContext().getRealPath("/resources/images"));
//            FileUtils.cleanDirectory(file);
//            FileUtils.deleteDirectory(file);
//            for(File file1:file.listFiles()){
//                System.out.println(file1.getName() + " file in images");
////                boolean f = file.delete();
////                System.out.println(f + "delete file in images");
//            }
//            boolean del = file.delete();
//            System.out.println(del + "delete file>?");
            FileUtils.forceMkdir(file);
//            file.mkdir();
            for (int i = 0; i < userList.size(); i++) {
                Teacher teacher = (Teacher) userList.get(i);
               byte[] photo = teacher.getPhoto();
               String path = httpServletRequest.getServletContext().getRealPath("resources/images/"+teacher.getId()+".jpg");
                teacher.setPhotoFileName(teacher.getId()+".jpg");
                System.out.println(teacher.getPhotoFileName() + " webi info");
               OpenOption[] openOptions ={StandardOpenOption.CREATE,StandardOpenOption.WRITE};
                Files.write(Path.of(path), photo, openOptions);
            }
        }
        httpSession.setAttribute("Users",userList);
        System.out.println("popalo v find user");
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        if(userType.equals("student")){
            System.out.println("stud");
          return   configManager.getProperties("student_Management");
        }if(userType.equals("teacher")){
            return configManager.getProperties("teacher_Management");
        }
        return null;
    }
}
