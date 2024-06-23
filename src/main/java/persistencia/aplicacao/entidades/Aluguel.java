package persistencia.aplicacao.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluguel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private double preco;
	private Integer id_veiculo;
	private Integer id_cliente;

	public Aluguel() {

	}

	public Aluguel(Integer id, LocalDate dataInicio, LocalDate dataFinal, double preco, Integer id_veiculo,
			Integer id_cliente) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.preco = preco;
		this.id_veiculo = id_cliente;
		this.id_cliente = id_cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", preco=" + preco
				+ ", id_veiculo=" + id_veiculo + ", id_cliente=" + id_cliente + "]";
	}

}
