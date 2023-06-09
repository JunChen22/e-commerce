package com.itsthatjun.ecommerce.dto.UMS;

import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.Orders;
import com.itsthatjun.ecommerce.mbg.model.Review;

import java.util.List;

public class MemberDetail {

    Member member;
    List<Review> commentList;
    List<Orders> ordersList;
}
