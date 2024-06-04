package org.umss.SIS_UMSS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umss.SIS_UMSS.DTOs.UniversityDTO;
import org.umss.SIS_UMSS.Services.UniversityService;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<UniversityDTO> getAll(){
        return universityService.getAllUniversities();
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> create(@RequestBody UniversityDTO universityDTO){
        UniversityDTO university = universityService.saveUniversity(universityDTO);
        return ResponseEntity.ok().body(university);
    }

    @PutMapping("/{uuid}")
    public UniversityDTO update(@PathVariable String uuid, @RequestBody UniversityDTO universityDTO){
        return new UniversityDTO(uuid,"umss","universidad mayor de san simon");
    }

    @GetMapping("/{uuid}")
    public UniversityDTO getUniversityById(@PathVariable String uuid){
        return universityService.getUniversity(uuid);
    }

    @DeleteMapping("/{uuid}")
    public UniversityDTO deleteUniversity(@PathVariable String uuid){
        UniversityDTO universityDTO = new UniversityDTO(uuid,"UMSS", "Universidad Mayor De San Simón");
        return universityDTO;
    }
}
