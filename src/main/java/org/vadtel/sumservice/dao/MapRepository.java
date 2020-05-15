package org.vadtel.sumservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vadtel.sumservice.entity.MapEntity;

import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<MapEntity, Integer> {

    @Query(
            value = "SELECT value FROM map WHERE name = :name",
            nativeQuery = true
    )
    Integer getByName(String name);
}
