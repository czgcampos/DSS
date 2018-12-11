package Business;

import java.util.Observable;


public abstract class Despesa extends Observable
{
    private int idDespesa;
    private float montante;
    private float pago;
    private String dataDeEmissao;
    private String dataDeVencimento;
    private String actor;
    
    public Despesa()
	{
	    this.montante=0;
	    this.idDespesa=0;
            this.pago=0;
            this.dataDeEmissao="";
            this.dataDeVencimento="";
            this.actor="";
	}
	
	public Despesa(int idDespesa, float montante, float pago, String data, String data2, String actor)
	{
	    this.montante=montante;
	    this.idDespesa=idDespesa;
            this.pago=pago;
            this.dataDeEmissao=data;
            this.dataDeVencimento=data2;
            this.actor=actor;
	}
	
	public Despesa(Despesa d2)
	{
	    this(d2.getIdDespesa(),d2.getMontante(), d2.getPago(), d2.getDataDeEmissao(), d2.getDataDeVencimento(), d2.getActor());
	}
        
        public String getActor(){
            return this.actor;
        }
        
        public void setActor(String a){
            this.actor=a;
        }
        
        public String getDataDeEmissao(){
            return this.dataDeEmissao;
        }
        
        public void setDataDeEmissao(String data){
            this.dataDeEmissao=data;
        }
        
        public String getDataDeVencimento(){
            return this.dataDeVencimento;
        }
        
        public void setDataDeVencimento(String data){
            this.dataDeVencimento=data;
        }
        
    public float getPago(){
        return this.pago;
    }
    
    public void setPago(Float pago){
        this.pago=pago;
    }

    public float getMontante()
    {
        return this.montante;
    }

    public void setMontante(float newPreco)
    {
        this.montante = newPreco;
    }

    public int getIdDespesa() 
    {
        return this.idDespesa;
    }

    public void setIdDespesa(int newId)
    {
        this.idDespesa = newId;
    }

	public abstract Despesa clone();
	
	public boolean equals(Object o)
    {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        else
        {
            Despesa d = (Despesa) o;
            return (this.idDespesa==d.getIdDespesa() &&
                    this.montante==d.getMontante() &&
                    this.pago==d.getPago());
        }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(this.idDespesa);
        s.append(" . Montante: ")    ;
        s.append(this.montante); 
        s.append(". Pago: ");
        s.append(this.pago);
        s.append(". Data de Emissao: ");
        s.append(this.dataDeEmissao);
        s.append(". Data de Vencimento: ");
        s.append(this.dataDeVencimento);
        s.append(". Morador :");
        s.append(this.actor);
        return s.toString();
    }
}