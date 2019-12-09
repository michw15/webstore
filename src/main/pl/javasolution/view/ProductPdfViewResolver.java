package main.pl.javasolution.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class ProductPdfViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        ProductPdfView pdfView = new ProductPdfView();
        return pdfView;
    }
}
