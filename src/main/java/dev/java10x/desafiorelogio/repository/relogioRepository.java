package dev.java10x.desafiorelogio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dev.java10x.desafiorelogio.entity.Relogio;

public interface relogioRepository extends JpaRepository<Relogio, UUID>, JpaSpecificationExecutor<Relogio>{

}
