package org.vadtel.sumservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MapRepository extends JpaRepository<String, Integer> {

}
