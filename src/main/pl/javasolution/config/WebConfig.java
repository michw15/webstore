package main.pl.javasolution.config;

import main.pl.javasolution.view.ProductJsonViewResolver;
import main.pl.javasolution.view.ProductPdfViewResolver;
import main.pl.javasolution.view.ProductXmlViewResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.util.UrlPathHelper;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan("main.pl.javasolution")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/pdf/**").addResourceLocations("/WEB-INF/pdf/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML)
                .favorPathExtension(true)
                .favorParameter(false)
                .ignoreAcceptHeader(true);
    }
    @Bean
    public ContentNegotiatingViewResolver viewResolver(ContentNegotiationManager contentNegotiationManager){
        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManager);

        ProductXmlViewResolver xmlViewResolver = new ProductXmlViewResolver();
        ProductJsonViewResolver jsonViewResolver = new ProductJsonViewResolver();
        ProductPdfViewResolver pdfView = new ProductPdfViewResolver();

        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(xmlViewResolver);
        resolvers.add(jsonViewResolver);
        resolvers.add(pdfView);

        contentNegotiatingViewResolver.setViewResolvers(resolvers);
        return contentNegotiatingViewResolver;
    }
}
