package com.yannyao.blog;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yannyao.web.dubbo.impl.CityDubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class DemoApplication extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ObjectMapper objectMapper = new ObjectMapper();
		// 蛇皮走位
//        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		// 忽略无法识别字段
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 忽略空值
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// long以String表达
		/*
		 * SimpleModule simpleModule = new SimpleModule();
		 * simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		 * simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		 * objectMapper.registerModule(simpleModule);
		 */
		//设置时区
		objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
		converters.add(converter);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
//		CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//		cityService.printCity();
	}
}
