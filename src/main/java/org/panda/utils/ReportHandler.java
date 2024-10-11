package org.panda.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.panda.entity.Book;
import org.panda.service.BookService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReportHandler {

    private BookService bookService;
    public ReportHandler(BookService bookService) {
        this.bookService = bookService;
    }
//    public void generatePdfReport() {
//        bookService.getAllBooks().forEach(System.out::println);
//    }
    public void generatePdfReport() {
        String jasperFilePath = "./src/main/resources/jasper/tza_jasper.jasper";
        String outputPdfFilePath = "./src/main/resources/pdf/tza_jasper.pdf";
        List<Book> bookList = bookService.getAllBooks();
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(bookList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title",bookList.get(0).getTitle());
            parameters.put("author",bookList.get(0).getAuthor());
            parameters.put("releaseYear",bookList.get(0).getReleaseYear());
            parameters.put("titleTranslate",bookList.get(0).getTitleTranslate());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPdfFilePath);
            System.out.println("Report generated successfully...");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }
}
