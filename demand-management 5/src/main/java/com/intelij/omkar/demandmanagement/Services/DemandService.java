package com.intelij.omkar.demandmanagement.Services;

import com.intelij.omkar.demandmanagement.Model.Demand;
import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Repository.DemandRepository;
import com.intelij.omkar.demandmanagement.Repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;


import java.util.List;
import java.util.Map;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private MemberService memberService;

    public Demand addDemand(Demand demand) {
        return demandRepository.save(demand);
    }

    public List<Demand> showDemand() {
        return demandRepository.findAll();
    }

    public List<Demand> getDemandsByLocation(String location) {
        return demandRepository.findByLocationIgnoreCase(location);
    }

    public List<Demand> getDemandsByManagerName(String managerName) {
        return demandRepository.findByManagerName(managerName);
    }

    public List<Demand> getDemandsByProjectName(String projectName) {
        return demandRepository.findByProjectName(projectName);
    }

    public List<Demand> getDemandsByStatus(Demand.StatusChoice status) {
        return demandRepository.findByStatus(status);
    }
    public List<Demand> getDemandsByProjectNameAndLocation(String projectName, String location) {
        return demandRepository.findByProjectNameAndLocation(projectName, location);
    }

    public List<Demand> getDemandsByProjectNameLocationAndStatus(String projectName, String location, Demand.StatusChoice status) {
        return demandRepository.findByProjectNameAndLocationAndStatus(projectName, location, status);
    }

}