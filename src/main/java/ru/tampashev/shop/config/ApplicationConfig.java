package ru.tampashev.shop.config;

import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Import({DatabaseConfig.class, WebSecurityConfig.class, JmsConfig.class})
public class ApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // для ресурсов
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class, WebConfig.class};
    }

    // Тут добавляем конфигурацию, в которой инициализируем ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        MultipartFilter multipartFilter = new MultipartFilter();
        //multipartFilter.setMultipartResolverBeanName(MultipartFilter.DEFAULT_MULTIPART_RESOLVER_BEAN_NAME);

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam(HiddenHttpMethodFilter.DEFAULT_METHOD_PARAM);

        return new Filter[] {characterEncodingFilter, multipartFilter, hiddenHttpMethodFilter};
    }
}
