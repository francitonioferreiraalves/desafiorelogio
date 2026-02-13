package dev.java10x.desafiorelogio.entity;

import java.time.Instant;
import java.util.UUID;

import dev.java10x.desafiorelogio.entity.enums.MaterialCaixa;
import dev.java10x.desafiorelogio.entity.enums.TipoMovimento;
import dev.java10x.desafiorelogio.entity.enums.TipoVidro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "relogio", indexes = {
		@Index(name = "IDX_RELOGIO_MARCA", columnList = "marca"),
		@Index(name = "IDX_RELOGIO_CRIADO_EM", columnList = "criadoEm"),	
		@Index(name = "IDX_RELOGIO_PRECO", columnList = "precoEmCentavos")				
})	

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Relogio {
	
	@Id
	
	@Column(nullable = false, updatable = false)
	private UUID id;
	
	@Column(nullable = false, length = 80)
	private String marca;
	
	@Column(nullable = false, length = 125)
	private String modelo;
	
	@Column(nullable = false, length = 80)
	private String referencia;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoMovimento tipoMovimento;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private MaterialCaixa materialCaixa;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoVidro tipoVidro;
	
	
	@Column(nullable = false)
	private int resistenciaAgua;
	
	@Column(nullable = false)
	private int diametroMn;
	
	@Column(nullable = false)
	private int espessuraMn;
	
	@Column(nullable = false)
	private int larguraLugMn;
	
	@Column(nullable = false)
	private Long precoEmCentavos;
	
	@Column(nullable = false, length = 6600)
	private String  urlImagem;
	
	@Column(nullable = false)
	private Instant criadoEm;
	
	@PrePersist
	void prePersist() {
		if(id == null) id =UUID.randomUUID();
		if(criadoEm == null) criadoEm = Instant.now();
		normalizar();
	}
	
	@PreUpdate
	void preUpdate() {
		normalizar();
	}

	private void normalizar() {
		if(marca != null) marca = marca.trim();
		if(modelo != null) modelo = modelo.trim();
		if(referencia != null) referencia = referencia.trim();
		if(urlImagem != null) urlImagem = urlImagem.trim();
		
	}
	
	
}
