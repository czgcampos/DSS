import java.util.ArrayList;

public class Cliente {
	private String _nome;
	private long _nCC;
	public ViaVerde _clientes;
	public ViaVerde _unnamed_ViaVerde_;
	public ArrayList<Viatura> _viaturas = new ArrayList<Viatura>();

	public long getNCC() {
		return this._nCC;
	}

	public String getNome() {
		return this._nome;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public long setNCC(long aNCC) {
		throw new UnsupportedOperationException();
	}

	public List<String> getIds() {
		throw new UnsupportedOperationException();
	}
}