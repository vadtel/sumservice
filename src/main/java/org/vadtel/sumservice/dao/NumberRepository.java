package org.vadtel.sumservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vadtel.sumservice.entity.NumberEntity;

import java.util.Optional;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Integer> {

    @Query(value = "SELECT value FROM map WHERE name = :name",
            nativeQuery = true)
    Optional<Integer> getNumberByName(@Param("name") String name);

    Optional<NumberEntity> getNumberEntitiesByName(String name);

    void deleteMapEntityByName(String name);
}
