package com.intelij.omkar.demandmanagement.Controller;

import com.intelij.omkar.demandmanagement.Model.Demand;
import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Services.DemandService;
import com.intelij.omkar.demandmanagement.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping("/add")
    public Demand addDemand(@RequestBody Demand demand) {
        return demandService.addDemand(demand);
    }

    @GetMapping("/showall")
    public List<Demand> showDemand() {
        return demandService.showDemand();
    }

    @GetMapping("/byLocation/{location}")
    public ResponseEntity<List<Demand>> getDemandsByLocation(@PathVariable String location) {
        List<Demand> demands = demandService.getDemandsByLocation( location);
        return ResponseEntity.ok(demands);
    }

    @GetMapping("/byManagerName/{managerName}")
    public ResponseEntity<List<Demand>> getDemandsByManagerName(@PathVariable String managerName) {
        List<Demand> demands = demandService.getDemandsByManagerName( managerName);
        return ResponseEntity.ok(demands);
    }

    @GetMapping("/byProjectName")
    public ResponseEntity<List<Demand>> getDemandsByProjectName(@PathVariable String projectName) {
        List<Demand> demands = demandService.getDemandsByProjectName(projectName);
        return ResponseEntity.ok(demands);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<List<Demand>> getDemandsByStatus(@RequestParam Demand.StatusChoice status) {
        List<Demand> demands = demandService.getDemandsByStatus(status);
        return ResponseEntity.ok(demands);
    }
    @GetMapping("/byProjectNameAndLocation")
    public List<Demand> getDemandsByProjectNameAndLocation(@RequestParam String projectName, @RequestParam String location) {
        return demandService.getDemandsByProjectNameAndLocation(projectName, location);
    }

    @GetMapping("/byProjectNameLocationAndStatus")
    public List<Demand> getDemandsByProjectNameLocationAndStatus(
            @RequestParam String projectName,
            @RequestParam String location,
            @RequestParam Demand.StatusChoice status) {
        return demandService.getDemandsByProjectNameLocationAndStatus(projectName, location, status);
    }

}