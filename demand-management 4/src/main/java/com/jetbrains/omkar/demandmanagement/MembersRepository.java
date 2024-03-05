package com.jetbrains.omkar.demandmanagement;

//import net.javaguides.postgresql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long>{

}