package org.umss.SIS_UMSS.Repositories;

import org.springframework.stereotype.Component;
import org.umss.SIS_UMSS.Models.University;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class UniversityRepository {
    private static List<University> universityList = new ArrayList<>();
    private static int idCounter;

    static {
        idCounter = 4;
        universityList.add(new University(1, UUID.randomUUID().toString(), "Universidad Mayor De San Simon", "UMSS", new Date()));
        universityList.add(new University(2, UUID.randomUUID().toString(), "Universidad Privada Del Valle", "Univalle", new Date()));
        universityList.add(new University(3, UUID.randomUUID().toString(), "Universidad Catolica De Bolivia", "UCB", new Date()));
    }

    public List<University> findAll() {
        return universityList;
    }

    public University save(University university) {
        university.setId(idCounter);
        university.setUuid(UUID.randomUUID().toString());
        universityList.add(university);
        idCounter++;
        return university;
    }
    public University findByUuid(String uuid) {
        return universityList
                .stream()
                .filter(university -> university.getUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }
}
