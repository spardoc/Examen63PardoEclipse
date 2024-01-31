package ec.edu.ups.ppw63.Examen63Pardoservices;

public class ErrorMessage 
{
	private int codigo;
	private String mensaje;
	
	public ErrorMessage(int i, String mensaje) {
		this.codigo = i;
		this.mensaje = mensaje;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
