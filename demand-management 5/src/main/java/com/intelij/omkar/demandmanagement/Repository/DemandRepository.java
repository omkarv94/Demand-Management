package com.intelij.omkar.demandmanagement.Repository;

import com.intelij.omkar.demandmanagement.Model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {

    List<Demand> findByLocation(String location);

    List<Demand> findByManagerName(String managerName);

    List<Demand> findByProjectName(String projectName);

    List<Demand> findByStatus(Demand.StatusChoice status);

    List<Demand> findByLocationIgnoreCase(String location);

    List<Demand> findByProjectNameAndLocation(String projectName, String location);

    List<Demand> findByProjectNameAndLocationAndStatus(String projectName, String location, Demand.StatusChoice status);
}