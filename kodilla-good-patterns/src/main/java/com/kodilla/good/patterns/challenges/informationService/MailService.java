package com.kodilla.good.patterns.challenges.informationService;

import com.kodilla.good.patterns.challenges.orderService.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Email has been sent to : " + user.getUserMail() +".");
    }
}
