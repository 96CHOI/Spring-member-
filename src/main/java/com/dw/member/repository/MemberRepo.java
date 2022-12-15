package com.dw.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.member.model.Member;

//JPA를 상속받는다.
//@Mapper라는 어노테이션을 사용 X
public interface MemberRepo extends JpaRepository<Member, Long> {

    // select * from dw_501.dw_member WHERE user_id = "dw";
    Member findByuserId(String userId);

    // select * from dw_501.dw_member WHERE user_id = "dw" AND user_password ='123';
    Member findByuserIdAndUserPassword(String userId, String password);

    // SELECT * FROM dw_member WHERE name = "홍길동";
    Member findByname(String name);
}
