package com.dw.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.member.model.Member;

//JPA를 상속받는다.
//@Mapper라는 어노테이션을 사용 X
public interface MemberRepo extends JpaRepository<Member, Long>{

}
