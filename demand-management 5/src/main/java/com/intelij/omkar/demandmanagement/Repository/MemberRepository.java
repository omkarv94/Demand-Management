package com.intelij.omkar.demandmanagement.Repository;

import com.intelij.omkar.demandmanagement.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    @Query("SELECT m FROM Member m WHERE :skill MEMBER OF m.skills")
//    List<Member> findBySkill(@Param("skill") String skill);
}
