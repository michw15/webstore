package main.pl.javasolution.view;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import main.pl.javasolution.domain.Product;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ProductPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Product product = (Product) map.get("product");

        //column widths
        float[] columnWidths = { 1.5f, 2f};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(90f);

        //Table header
        PdfPCell cell = null;
        cell = new PdfPCell(new Phrase("ID"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getProductId()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("NAME"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getName()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("CATEGORY"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getCategory()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("MANUFACTURER"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getManufacturer()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("DESCRIPTON"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getDescription()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("CONDITION"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getCondition()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("PRICE"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(product.getUnitPrice().toString()));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("UNIT_IN_STOCK"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Long.toString(product.getUnitsInStock())));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("UNIT_IN_ORDER"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Long.toString(product.getUnitsInOrder())));
        table.addCell(cell);


        document.add(table);
    }
}
