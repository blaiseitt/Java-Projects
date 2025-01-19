package pl.dmcs.buarzej.service;

import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.buarzej.domain.Order;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_MANAGER') OR (#order.appUser.login == authentication.principal.username)")
    void generatePdf(Order order, HttpServletResponse response);
}
