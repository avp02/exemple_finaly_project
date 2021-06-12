package com.avp.example_finaly_project.bean;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cargo_id")
    private Integer id;

    @Column(name = "cargo_name", unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cargo", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Company> companies;

}
