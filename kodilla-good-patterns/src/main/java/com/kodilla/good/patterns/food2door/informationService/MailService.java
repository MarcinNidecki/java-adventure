package com.kodilla.good.patterns.food2door.informationService;


import com.kodilla.good.patterns.food2door.orderService.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Email with order confirmation has been send to client: " + user.getUserMail()+"\n");
    }

}
