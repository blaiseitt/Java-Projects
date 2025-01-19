package pl.dmcs.buarzej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.buarzej.service.OrderService;
import pl.dmcs.buarzej.service.PdfService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    private PdfService pdfService;
    private OrderService orderService;

    @Autowired
    public PdfController(PdfService pdfService, OrderService orderService) {
        this.orderService = orderService;
        this.pdfService = pdfService;
    }

    @RequestMapping(value = "/generatePdf-{orderId}", method = RequestMethod.GET)
    public void generatePdf(@PathVariable Long orderId, HttpServletResponse response) {
        pdfService.generatePdf(orderService.getOrder(orderId), response);
    }
}
