package br.com.api.doacoes.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtos")
public class ProdutoModel {

	// Converter Data e hora para fuso horário local
	public String converteFuso() {
		Calendar agora = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a z");
		System.out.println(sdf.format(agora.getTime()));
		return "";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "codigo")
	private long codigo;


	@Column(name = "nome")
	@NotEmpty
	@Size(min = 3, max = 20)
	private String nome;

	@Column(name = "medida")
	@NotEmpty
	@Size(min = 1, max = 2)
	private String medida;

	@Column(name = "formaEntrega")
	@NotEmpty
	@Size(min = 3, max = 10)
	private String formaEntrega;

	@Column(name = "tipo")
	@NotEmpty
	@Size(min = 3, max = 20)
	private String tipo;

	@Column(name = "quantidade")
	@Size(min = 1, max = 10)
	private int quantidade = 0;

	@Column(name = "ativo")
	private boolean ativo = true;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	/*
	 * 
	 * 
	 * 
	 * Getters and Setters
	 * 
	 * 
	 * 
	 * 
	 */
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getFormaEntrega() {
		return formaEntrega;
	}

	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
