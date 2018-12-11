package Business;

import java.util.List;


/**
 * Escreva a descrição da classe Senhorio aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Senhorio extends Actor
{
    public Senhorio()
    {
        super();
    }
    
    public Senhorio(String moradaCasa, int telemovel, String mail, String nome, String password, String cargo)
    {
        super(moradaCasa,telemovel,mail,nome,password, cargo);
    }
    
    public Senhorio(Senhorio s2)
    {
        super(s2);
    }
    
    public Senhorio clone()
    {
        return new Senhorio(this);
    }  
    public boolean equals(Object o)
    {
       if (this == o) return true;
       if ((o==null)||(o.getClass()!=this.getClass())) return false;
       else
       {
           Senhorio s = (Senhorio) o;
           return (super.equals(s));
       }
    }
}
