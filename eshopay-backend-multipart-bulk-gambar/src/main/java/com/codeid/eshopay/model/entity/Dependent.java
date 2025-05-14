package com.codeid.eshopay.model.entity;

import com.codeid.eshopay.model.enumeration.EnumRelationship;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="dependents",schema = "hr")
public class Dependent extends AbstractEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="dependent_id")
    private Integer dependentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lasttName;

    @Enumerated(EnumType.STRING)
    @Column(name="relationship")
    private EnumRelationship relationship;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}