package Business;

import java.util.List;


/**
 * Escreva a descrição da classe Morador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Morador extends Actor
{
    public Morador()
    {
        super();
    }
    
    public Morador(String moradaCasa, int telemovel, String mail, String nome, String password, String cargo)
    {
        super(moradaCasa,telemovel,mail,nome,password, cargo);
    }
    
    public Morador(Morador m2)
    {
        super(m2);
    }
    
    public Morador clone()
    {
        return new Morador(this);
    }  
    public boolean equals(Object o)
    {
       if (this == o) return true;
       if ((o==null)||(o.getClass()!=this.getClass())) return false;
       else
       {
           Morador m = (Morador) o;
           return (super.equals(m));
       }
    }
}
