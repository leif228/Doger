package com.dog.doger;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * 
 *************************************************
 * 	功能描述:  应用程序主入口                  
 * @author Mr.Chen
 * @version 1.0                
 * @date    2018年10月19日 创建文件                                 
 * @see                        
 *************************************************
 */

@SpringBootApplication(
		scanBasePackages = {"com.dog.doger"},
		exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.dog.doger.app.business.repository")
public class AppServiceApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AppServiceApplication.class, args);
//		applicationContext.getBean(WebsocketDanmuServer.class).run();
	}

}
