package org.panda;

import org.panda.service.BookService;
import org.panda.utils.ReportHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        ReportHandler reportHandler = context.getBean(ReportHandler.class);
        reportHandler.generatePdfReport();
        context.close();
    }
}