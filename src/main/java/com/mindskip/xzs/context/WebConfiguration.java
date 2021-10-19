package com.mindskip.xzs.context;

import java.nio.charset.Charset;

import java.util.List;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.converter.HttpMessageConverter;

import org.springframework.http.converter.StringHttpMessageConverter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.pattern.MessageConverter;

/**

 * 解决页面返回的中文乱码。

 * 自定义消息转换器：自定义WebConfiguration继承WebMvcConfigurationSupport类

 * @author Administrator

 * @date 2018年10月18日上午12:34:22

 */

@Configuration

public class WebConfiguration extends WebMvcConfigurationSupport{
//1.这个为解决中文乱码

    @Bean

    public HttpMessageConverter responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));

        return converter;

    }

//2.1：解决中文乱码后，返回json时可能会出现No converter found for return value of type: xxxx

//或这个：Could not find acceptable representation

//解决此问题以下

    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();

    }

//2.2：解决No converter found for return value of type: xxxx

    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter=new MappingJackson2HttpMessageConverter();

        converter.setObjectMapper(getObjectMapper());

        return converter;

    }

    @Override

    public void configureMessageConverters(List converters) {
        super.configureMessageConverters(converters);

//解决中文乱码

        converters.add(responseBodyConverter());

//解决： 添加解决中文乱码后的配置以后，返回json数据直接报错 500：no convertter for return value of type

//或这个：Could not find acceptable representation

        converters.add(messageConverter());

    }

}