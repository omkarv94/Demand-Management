package com.intelij.omkar.demandmanagement.Repository;

import com.intelij.omkar.demandmanagement.Model.Demand;
import com.intelij.omkar.demandmanagement.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEid(String eid);

    List<Member> findByFirstNameAndLastName(String firstName, String lastName);

    List<Member> findByLocation(String location);

    List<Member> findByStatus(Member.StatusChoice status);

}
