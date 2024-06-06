package org.umss.SIS_UMSS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.SIS_UMSS.Models.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Query("SELECT u FROM University u WHERE u.uuid = ?1")
    University findByUuid(String uuid);


//    private static List<University> universityList = new ArrayList<>();
//    private static int idCounter;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    static {
//        idCounter = 4;
//        universityList.add(new University(1, UUID.randomUUID().toString(), "Universidad Mayor De San Simon", "UMSS", new Date()));
//        universityList.add(new University(2, UUID.randomUUID().toString(), "Universidad Privada Del Valle", "Univalle", new Date()));
//        universityList.add(new University(3, UUID.randomUUID().toString(), "Universidad Catolica De Bolivia", "UCB", new Date()));
//    }
//
//    public List<University> findAll() {
//        return entityManager.find;
//    }
//
//    public University save(University university) {
//        entityManager.persist(university);
//        return university;
//    }
//
//    public University findByUuid(String uuid) {
//        return universityList
//                .stream()
//                .filter(university -> university.getUuid().equals(uuid))
//                .findAny()
//                .orElse(null);
//    }


}
