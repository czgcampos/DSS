package Business;

public class Extraordinaria extends Despesa
{
	private String descricao;

	public Extraordinaria()
    {
        super();
        this.descricao="";
    }
    
    public Extraordinaria(int idDespesa, float montante, String descricao, float pago, String data, String data2, String actor)
    {
        super(idDespesa,montante,pago,data,data2, actor);
        this.descricao=descricao;
    }
    
    public Extraordinaria(Extraordinaria e2)
    {
        super(e2);
        this.descricao=e2.getDescricao();
    }
	
	public String getDescricao()
	{
		return this.descricao;
	}

	public void setDescricao(String newDescricao)
	{
		this.descricao = newDescricao;
	}
	
	public Extraordinaria clone()
    {
        return new Extraordinaria(this);
    }
    
    public boolean equals(Object o)
    {
       if (this == o) return true;
       if ((o==null)||(o.getClass()!=this.getClass())) return false;
       else
       {
           Extraordinaria e = (Extraordinaria) o;
           return (super.equals(e) &&
                   this.descricao.equals(e.getDescricao()));
       }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append(". Descrição: ");
        s.append(this.descricao+".");
        return s.toString();
    }
}
