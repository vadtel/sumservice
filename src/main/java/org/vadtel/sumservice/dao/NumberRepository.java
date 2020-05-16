package org.vadtel.sumservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vadtel.sumservice.entity.NumberEntity;

import java.util.Optional;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Integer> {

    @Query(value = "select value from map where name=:name", nativeQuery = true)
    Optional<Integer> findValueByName(String name);

    Optional<NumberEntity> findByName(String name);


}
