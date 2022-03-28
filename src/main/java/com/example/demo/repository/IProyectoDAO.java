package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Proyecto;

@Repository
public interface IProyectoDAO extends JpaRepository<Proyecto, Long> {

}
