package persistencia.aplicacao.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String modelo;
	private Integer id_marca;
	private Integer id_categoria;
	private int exe_disponiveis;

	public Veiculo() {

	}

	public Veiculo(Integer id, String modelo, Integer id_marca, Integer id_categoria, int exe_disponiveis) {
		this.id = id;
		this.modelo = modelo;
		this.id_marca = id_marca;
		this.id_categoria = id_categoria;
		this.exe_disponiveis = exe_disponiveis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getId_marca() {
		return id_marca;
	}

	public void setId_marca(Integer id_marca) {
		this.id_marca = id_marca;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getExe_disponiveis() {
		return exe_disponiveis;
	}

	public void setExe_disponiveis(int exe_disponiveis) {
		this.exe_disponiveis = exe_disponiveis;
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
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", id_marca=" + id_marca + ", id_categoria=" + id_categoria
				+ ", exe_disponiveis=" + exe_disponiveis + "]";
	}

}
