package com.jetbrains.omkar.demandmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import net.javaguides.postgresql.exception.ResourceNotFoundException;
import net.javaguides.postgresql.model.Members;
import net.javaguides.postgresql.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MembersController {
    @Autowired
    private MembersRepository MembersRepository;

    @GetMapping("/Memberss")
    public List<> getAllMemberss() {
        return MembersRepository.findAll();
    }

    @GetMapping("/Memberss/{id}")
    public ResponseEntity<Members> getMembersById(@PathVariable(value = "id") Long MembersId)
             {
        Members Members = MembersRepository.findById(MembersId)
                .orElseThrow(() -> new ResourceNotFoundException("Members not found for this id :: " + MembersId));
        return ResponseEntity.ok().body(Members);
    }

    @PostMapping("/Memberss")
    public Members createMembers(Members Members) {
        return MembersRepository.save(Members);
    }

    @PutMapping("/Memberss/{id}")
    public ResponseEntity<Members> updateMembers(@PathVariable(value = "id") Long MembersId,
                                                   Members MembersDetails) throws ResourceNotFoundException {
        Members Members = MembersRepository.findById(MembersId)
                .orElseThrow(() -> new ResourceNotFoundException("Members not found for this id :: " + MembersId));

        Members.setEmailId(MembersDetails.getEmailId());
        Members.setLastName(MembersDetails.getLastName());
        Members.setFirstName(MembersDetails.getFirstName());
        final Members updatedMembers = MembersRepository.save(Members);
        return ResponseEntity.ok(updatedMembers);
    }

    @DeleteMapping("/Memberss/{id}")
    public Map<String, Boolean> deleteMembers(@PathVariable(value = "id") Long MembersId)
            throws ResourceNotFoundException {
        Members Members = MembersRepository.findById(MembersId)
                .orElseThrow(() -> new ResourceNotFoundException("Members not found for this id :: " + MembersId));

        MembersRepository.delete(Members);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
