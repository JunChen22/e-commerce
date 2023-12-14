package com.itsthatjun.ecommerce.service.UMS;

import com.itsthatjun.ecommerce.mbg.model.Member;

public interface MemberService {

    Member getUserDetail(String username);

    Member deactivateMember(String username);

    Member activateMember(String username);

}
