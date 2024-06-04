package org.umss.SIS_UMSS.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.umss.SIS_UMSS.DTOs.UniversityDTO;
import org.umss.SIS_UMSS.DTOs.UniversityMapper;
import org.umss.SIS_UMSS.Exceptions.NotFoundException;
import org.umss.SIS_UMSS.Models.University;
import org.umss.SIS_UMSS.Repositories.UniversityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityMapper universityMapper;

    public List<UniversityDTO> getAllUniversities() {
        return universityRepository.findAll()
                .stream()
                .map(university ->  universityMapper.UniversityToDTO(university))
                .collect(Collectors.toList());
    }

    public UniversityDTO getUniversity(String uuid) {
        University university = universityRepository.findByUuid(uuid);

        if(university == null) {
             throw new NotFoundException("University", uuid) ;
        }

        return  universityMapper.UniversityToDTO(university);
    }

    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        University university= universityMapper.DTOToUniversity(universityDTO);
        return universityMapper.UniversityToDTO(universityRepository.save(university));
    }
}
