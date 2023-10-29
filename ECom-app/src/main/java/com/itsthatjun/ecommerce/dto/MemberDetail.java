package com.itsthatjun.ecommerce.dto;

import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.MemberIcon;
import com.itsthatjun.ecommerce.mbg.model.MemberLoginLog;
import lombok.Data;

import java.util.List;

@Data
public class MemberDetail {
    Member member;
    Address address;
    MemberIcon icon;
    List<MemberLoginLog> loginLogList;
}
