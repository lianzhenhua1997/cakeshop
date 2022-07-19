package com.lzh.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lzh.model.Type;
import com.lzh.service.TypeService;


@WebListener
public class ApplicationListener implements ServletContextListener {
	private TypeService tService = new TypeService();
    
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         List<Type> list = tService.selectAll();
         sce.getServletContext().setAttribute("typeList", list);
    }
	
}
