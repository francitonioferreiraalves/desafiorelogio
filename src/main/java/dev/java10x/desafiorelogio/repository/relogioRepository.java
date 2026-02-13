package dev.java10x.desafiorelogio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.java10x.desafiorelogio.entity.Relogio;

public interface relogioRepository extends JpaRepository<Relogio, UUID>{

}
