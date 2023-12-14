package com.itsthatjun.ecommerce.dto.UMS;

import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.MemberIcon;
import com.itsthatjun.ecommerce.mbg.model.MemberLoginLog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MemberDetail implements Serializable {
    Member member;
    Address address;
    MemberIcon icon;
    List<MemberLoginLog> loginLogList;
}
