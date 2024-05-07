package com.Alphaware.CrudWithMongoDM.Repository;

import com.Alphaware.CrudWithMongoDM.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student , Integer> {

    Optional<Student> findByName(String name);
}
