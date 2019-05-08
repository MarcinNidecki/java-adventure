package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.orderService.User;

public class OrderDto {


    public User user;
    boolean isOrdered;

    OrderDto(User user, boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
