package Business;

public class Recorrente extends Despesa
{
	private String tipo;

	public Recorrente()
    {
        super();
        this.tipo="";
    }
    
    public Recorrente(int idDespesa, float montante, String tipo,float pago, String data, String data2, String actor)
    {
        super(idDespesa,montante, pago, data, data2, actor);
        this.tipo=tipo;
    }
    
    public Recorrente(Recorrente r2)
    {
        super(r2);
        this.tipo=r2.getTipo();
    }
	
	public String getTipo()
	{
		return this.tipo;
	}

	public void setTipo(String newTipo)
	{
		this.tipo = newTipo;
	}
	
	public Recorrente clone()
    {
        return new Recorrente(this);
    }
    
    public boolean equals(Object o)
    {
       if (this == o) return true;
       if ((o==null)||(o.getClass()!=this.getClass())) return false;
       else
       {
           Recorrente r = (Recorrente) o;
           return (super.equals(r) &&
                   this.tipo.equals(r.getTipo()));
       }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append(". Tipo: ");
        s.append(this.tipo+".");
        return s.toString();
    }
}