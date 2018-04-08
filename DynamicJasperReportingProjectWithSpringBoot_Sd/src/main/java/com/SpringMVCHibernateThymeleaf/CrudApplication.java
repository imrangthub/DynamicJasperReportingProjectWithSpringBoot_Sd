package com.SpringMVCHibernateThymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringMVCHibernateThymeleaf.jesperReport.App;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		/*App app=new App();
		 try {
	            app.generateReport();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
	}
}
