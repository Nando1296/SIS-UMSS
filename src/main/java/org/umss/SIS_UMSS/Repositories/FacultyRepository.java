package org.umss.SIS_UMSS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.umss.SIS_UMSS.DTOs.FacultyDTO;
import org.umss.SIS_UMSS.Models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("SELECT f FROM Faculty f WHERE f.uuid = ?1")
    Faculty findByUuid(String facultyUuid);


//    private static List<Faculty> facultyList = new ArrayList<Faculty>();
//    private static int idCounter;
//
//    static{
//        idCounter = 4;
//        facultyList.add(new Faculty(100, 1, UUID.randomUUID().toString(), "Facultad de Ciencias y Tecnología", "FCYT", new Date()));
//        facultyList.add(new Faculty(200, 2, UUID.randomUUID().toString(), "Facultad de Medicina", "FM", new Date()));
//        facultyList.add(new Faculty(300, 1, UUID.randomUUID().toString(), "Facultad de Ciencias Económicas", "FCE", new Date()));
//    }
//
//    public List<Faculty> getByUniversityId(Integer universityId) {
//        return facultyList
//                .stream()
//                .filter(faculty -> faculty.getUniversityId() == universityId)
//                .collect(Collectors.toList());
//    }
}
