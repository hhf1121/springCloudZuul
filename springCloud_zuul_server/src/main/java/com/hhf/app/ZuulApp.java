package com.hhf.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.hhf.filter.TokenFilter;

@SpringBootApplication
@EnableZuulProxy  //开启zuul网关代理
@EnableEurekaClient
public class ZuulApp {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}
	
	//启动filter器
	@Bean
	public TokenFilter TokenFilter() {
	 return new TokenFilter();
	}
}
