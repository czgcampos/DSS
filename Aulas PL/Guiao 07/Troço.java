import java.util.ArrayList;

public class Troço {
	private int _idTroço;
	public AutoEstrada _troços;
	public ArrayList<Registo> _troço = new ArrayList<Registo>();
	public PreçoTroço _preço;

	public int getIdTroço() {
		return this._idTroço;
	}

	public void setIdTroço(int aIdTroço) {
		this._idTroço = aIdTroço;
	}
}