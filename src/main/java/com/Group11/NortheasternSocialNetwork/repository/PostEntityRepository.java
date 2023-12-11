package com.Group11.NortheasternSocialNetwork.repository;

import com.Group11.NortheasternSocialNetwork.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Indicates that this interface is a Spring bean and should be automatically discovered by component scanning
public interface PostEntityRepository extends JpaRepository<PostEntity, String> {

    // This interface extends JpaRepository, providing CRUD (Create, Read, Update, Delete) operations for the PostEntity entity

    // No additional methods are declared here because JpaRepository already provides basic CRUD functionality
    // Custom query methods can be added here if specific queries are needed beyond the basic CRUD operations

    // The first type parameter of JpaRepository is the entity type (PostEntity), and the second type parameter
    // is the type of the entity's primary key (String in this case, which is the type of the 'id' field in PostEntity)

    // Spring Data JPA automatically generates the implementation of this interface at runtime
    // based on the naming conventions of the methods declared in JpaRepository
}
