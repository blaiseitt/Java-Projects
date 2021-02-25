package pl.dmcs.buarzej.service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import pl.dmcs.buarzej.domain.Order;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.DocumentException;

@Service
public class PdfServiceImpl implements PdfService {

    public void generatePdf(Order order, HttpServletResponse response) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + order.getCarOwned().getCarBrand() + "-" + order.getCarOwned().getCarModel() + "-" + order.getAppUser().getLastName() + ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("Order number:" + order.getId() + " details."));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table1 = new PdfPTable(2);
            table1.addCell("Ordered car");
            table1.addCell(order.getCarOwned().getCarBrand() + " " + order.getCarOwned().getCarModel());
            table1.addCell("Car cost per day");
            table1.addCell(order.getCarOwned().getCarCostPerDay());
            table1.addCell("Order period");
            table1.addCell(Integer.toString(order.getDays()));
            table1.addCell("Total cost");
            int totalCost = order.getDays() * Integer.parseInt(order.getCarOwned().getCarCostPerDay());
            table1.addCell(Integer.toString(totalCost));
            pdf.add(table1);
            pdf.add(new Paragraph("User details:"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table2 = new PdfPTable(2);
            table2.addCell("FirsName");
            table2.addCell(order.getAppUser().getFirstName());
            table2.addCell("LastName");
            table2.addCell(order.getAppUser().getLastName());
            table2.addCell("Email");
            table2.addCell(order.getAppUser().getEmail());
            table2.addCell("PESEL");
            table2.addCell(order.getAppUser().getAppUserDocuments().getPESEL());
            table2.addCell("Driving licence number");
            table2.addCell(order.getAppUser().getAppUserDocuments().getDrivingLicenceNumber());
            pdf.add(table2);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
