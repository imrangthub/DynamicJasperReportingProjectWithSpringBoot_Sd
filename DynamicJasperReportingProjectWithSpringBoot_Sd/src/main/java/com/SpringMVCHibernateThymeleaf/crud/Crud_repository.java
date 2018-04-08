package com.SpringMVCHibernateThymeleaf.crud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Crud_repository extends JpaRepository<Crud_user, Integer> {

}
