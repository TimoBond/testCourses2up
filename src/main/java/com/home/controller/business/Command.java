package com.home.controller.business;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface Command {

    String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException;

}
