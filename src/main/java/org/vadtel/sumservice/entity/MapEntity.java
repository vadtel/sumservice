package org.vadtel.sumservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@ToString
@NoArgsConstructor
@Table(name = "map")
public class MapEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

}
