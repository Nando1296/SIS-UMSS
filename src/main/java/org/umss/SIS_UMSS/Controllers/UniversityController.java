package org.umss.SIS_UMSS.Controllers;

import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.umss.SIS_UMSS.DTOs.FacultyDTO;
import org.umss.SIS_UMSS.DTOs.UniversityDTO;
import org.umss.SIS_UMSS.Services.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<UniversityDTO> getAll(){
        return universityService.getAllUniversities();
    }

    @GetMapping("/{uuid}")
    public UniversityDTO getUniversityById(@PathVariable String uuid){
        return universityService.getUniversity(uuid);
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> create(@Valid @RequestBody UniversityDTO universityDTO){
        UniversityDTO university = universityService.saveUniversity(universityDTO);
        return ResponseEntity.ok().body(university);
    }

    @PutMapping("/{uuid}")
    public UniversityDTO update(@PathVariable String uuid, @RequestBody UniversityDTO universityDTO){
        return new UniversityDTO(uuid,"umss","universidad mayor de san simon");
    }



    @DeleteMapping("/{uuid}")
    public UniversityDTO deleteUniversity(@PathVariable String uuid){
        UniversityDTO universityDTO = new UniversityDTO(uuid,"UMSS", "Universidad Mayor De San Simón");
        return universityDTO;
    }

    @GetMapping("/{universityUuid}/faculties")
    public List<FacultyDTO> getFaculties(@PathVariable String universityUuid){
        List<FacultyDTO> facultiesDTOList = this.universityService.getFaculties(universityUuid);

        return facultiesDTOList;
    }
}
