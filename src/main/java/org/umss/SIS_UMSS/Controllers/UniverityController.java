package org.umss.SIS_UMSS.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.umss.SIS_UMSS.Models.University;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class UniverityController {
    @GetMapping("/universities")
    public List<University> getAll(){
        return Collections.singletonList(new University("UMSS", "Universidad Mayor De San Simón"));
    }

    @PostMapping("/universities")
    public University create(@RequestBody University university){
        university.setUuid(UUID.randomUUID().toString());
        return university;
    }

}
