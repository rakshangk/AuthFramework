package com.techmust;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages= "com.techmust")
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer 
{

	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory oHibernateEntityFactory)
	{  
	    return oHibernateEntityFactory.getSessionFactory();  
	}   
	
    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
}