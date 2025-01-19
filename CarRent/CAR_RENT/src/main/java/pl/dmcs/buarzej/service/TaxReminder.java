package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TaxReminder {

    /*private EmailService emailService;

    @Autowired
    public TaxReminder(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(initialDelay = 180000L, fixedDelay = 420000L)
    public void RemindAboutTax() {
        *//*Date dt = new Date();
        LocalDateTime.from(dt.toInstant()).plusDays(7);
        String date = dt.toString();*//*
        emailService.sendMail("201817@edu.p.lodz.pl", "Niedługo rozliczenie podatkowe", "Niedługo rozliczenie podatkowe");
    }*/
}
