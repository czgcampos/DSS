package Business;

import java.util.List;


/**
 * Escreva a descrição da classe Administrador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Administrador extends Morador
{
    public Administrador()
    {
        super();
    }
    
    public Administrador(String moradaCasa, int telemovel, String mail, String nome, String password, String cargo)
    {
        super(moradaCasa,telemovel,mail,nome,password,cargo);
    }
    
    public Administrador(Administrador a2)
    {
        super(a2);
    }
    
    public Administrador clone()
    {
        return new Administrador(this);
    }  
    public boolean equals(Object o)
    {
       if (this == o) return true;
       if ((o==null)||(o.getClass()!=this.getClass())) return false;
       else
       {
           Administrador a = (Administrador) o;
           return (super.equals(a));
       }
    }
}
