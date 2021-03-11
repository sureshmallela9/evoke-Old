package com.evoke.evoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evoke.evoke.entitys.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
