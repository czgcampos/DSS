package Business;

import Data.DespesaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public abstract class Actor extends Observable
{
	private String moradaCasa;
	private int telemovel;
	private String email;
	private String nome;
	private String password;
        private String cargo;
        private DespesaDAO despesas;

	public Actor()
	{
	    this.moradaCasa="";
	    this.telemovel=123456789;
	    this.email="";
	    this.nome="";
	    this.password="";
            this.cargo="";
	}
	
	public Actor(String moradaCasa, int telemovel, String mail, String nome, String password, String cargo)
	{
	    this.moradaCasa=moradaCasa;
	    this.telemovel=telemovel;
	    this.email=mail;
	    this.nome=nome;
	    this.password=password;
            this.cargo=cargo;
	}
	
	public Actor(Actor a2)
	{
	    this(a2.getMoradaCasa(),a2.getTelemovel(),a2.getEmail(),a2.getNome(),a2.getPassword(), a2.getCargo());
	}
	
        public String getCargo(){
            return cargo;
        }
        
        public void setCargo(String cargo){
            this.cargo=cargo;
        }
        
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String newEmail)
	{
		this.email = newEmail;
	}

	public int getTelemovel()
	{
		return this.telemovel;
	}
	
	public void setTelemovel(int newTelemovel)
	{
		this.telemovel = newTelemovel;
	}

	public void setNome(String newNome)
	{
		this.nome = newNome;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setMoradaCasa(String newMorada)
	{
		this.moradaCasa = newMorada;
	}

	public String getMoradaCasa()
	{
		return this.moradaCasa;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String newPass)
	{
		this.password = newPass;
	}
	
	public abstract Actor clone();
	
	public boolean equals(Object o)
    {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        else
        {
            Actor a = (Actor) o;
            return (this.nome.equals(a.getNome()) &&
                    this.password.equals(a.getPassword()) &&
                    this.moradaCasa.equals(a.getMoradaCasa()) &&
                    this.telemovel==a.getTelemovel() &&
                    this.email.equals(a.getEmail()) &&
                    this.cargo.equals(a.getCargo()));
        }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Email: ")    ;
        s.append(this.email);
        s.append(" . Nome: ");
        s.append(this.nome);
        s.append(". Telemovel: ");
        s.append(this.telemovel);
        s.append(". Morada de Casa: ");
        s.append(this.moradaCasa);
        s.append(". Cargo: ");
        s.append(this.cargo);
        return s.toString();
    }
}
