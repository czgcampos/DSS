/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.Actor;
import Business.Despesa;
import Business.Extraordinaria;
import Business.Recorrente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 */
public class DespesaDAO{

    public static boolean containsKey(Integer o) {
        Connection con=null;
        Set<Integer> res= DespesaDAO.keySet();
        return (res.contains(o));
    }

    public static boolean containsValue(Object o) {
        Collection<Despesa> con=null;
        Boolean res = false;
        con = DespesaDAO.values();
        for(Despesa a : con){
            if(a.equals((Despesa) o))
                res=true;
        }
        return res;
    }

    public static Despesa get(Object o) {
        Connection con=null;
        Despesa res = (Despesa) o;
        Despesa d = null;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from Despesa where idDespesa = ?");
            ps.setInt(1,(Integer) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("Tipo")==null)
                    res = new Extraordinaria(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("descricao"), rs.getFloat("pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
                else
                    res = new Recorrente(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("tipo"), rs.getFloat("pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return res;
    }
    
    public static Float getPrecoDespesa(Integer id) {
        Connection con=null;
        Float res =0f;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from Despesa where idDespesa = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res=rs.getFloat("montante")-rs.getFloat("pago");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return res;
    }
    
    public static float getDivida(Actor a){
        float r=0;
        List<Despesa> lista = DespesaDAO.getDespesasActor(a.getEmail());
        for(Despesa d : lista){
            r+=d.getMontante()-d.getPago();
        }
        return r;
    }

    public static Despesa criaDespesa(Despesa v) {
        Connection con=null;
        int i=0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Despesa (idDespesa,montante, descricao, tipo, pago, ator, dataDeEmissao, dataDeVencimento) VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, v.getIdDespesa());
            ps.setFloat(2, v.getMontante());
            ps.setFloat(5, v.getPago());
            ps.setString(6,v.getActor());
            ps.setString(7,v.getDataDeEmissao());
            ps.setString(8,v.getDataDeVencimento());
            if(v instanceof Extraordinaria){
                Extraordinaria d = (Extraordinaria) v;
                ps.setString(3, d.getDescricao());
                ps.setString(4,null);
                ps.setFloat(5, 0);
            }
            else{
                Recorrente d = (Recorrente) v;
                ps.setString(3, null);
                ps.setString(4, d.getTipo());
            }
            i = ps.executeUpdate(); 
        }
        catch(SQLException e){
            return null;
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(i==0) return null;
        return v;
    }

    public static boolean remDespesa(Integer id) {
        Connection con=null;
        int rs=0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE from Despesa where idDespesa = ?");
            ps.setInt(1,id);
            rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(rs==0) return false;
        return true;
    }

    public static void clear() {
        Connection con=null;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT idDespesa from Despesa");
            ResultSet rs = ps.executeQuery();
            PreparedStatement pst;
            while(rs.next()){
                pst = con.prepareStatement("DELETE from Despesa where idDespesa = ?");
                pst.setInt(1,rs.getInt(1));
                pst.executeUpdate();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Set<Integer> keySet() {
        Connection con=null;
        Set<Integer> res = new HashSet<Integer>();
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT idDespesa from Despesa");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getInt(1));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return res;
    }

    public static Collection<Despesa> values() {
        Connection con=null;
        Collection<Despesa> lista = new ArrayList<Despesa>();
        Recorrente r;
        Extraordinaria ex;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from Despesa");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("Descricao")==null){
                    r = new Recorrente(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("tipo"), rs.getFloat("pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
                    lista.add(r);
                }
                else{
                    ex= new Extraordinaria(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("Descricao"), rs.getFloat("Pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
                    lista.add(ex);
                }
            }   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return lista;
    }
    
    public static List<Despesa> getDespesasActor(String actor){
        Connection con=null;
        List<Despesa> lista = new ArrayList<Despesa>();
        Recorrente r;
        Extraordinaria ex;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from Despesa where ator = ?");
            ps.setString(1,actor);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("Descricao")==null){
                    r = new Recorrente(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("tipo"), rs.getFloat("pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
                    lista.add(r);
                }
                else{
                    ex= new Extraordinaria(rs.getInt("idDespesa"), rs.getFloat("montante"), rs.getString("Descricao"), rs.getFloat("Pago"), rs.getString("dataDeEmissao"), rs.getString("dataDeVencimento"), rs.getString("ator"));
                    lista.add(ex);
                }
            }   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return lista;
    }
    
    public static String[] getDespesas(){
        Connection con=null;
        Collection<Despesa> lista = DespesaDAO.values();
        String[] listafinal = new String[lista.size()];
        int i=0;
        for(Despesa d : lista){
            listafinal[i]=d.toString();
            i++;
        }
        return listafinal;
    }
    
    
    
    public static String[] getDespesasID(){
        Connection con=null;
        List<String> lista = new ArrayList<String>();
        Recorrente r;
        String res;
        Extraordinaria ex;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT idDespesa from Despesa");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                    res = (""+rs.getInt("idDespesa"));
                    lista.add(res);
            }   
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        String[] listafinal = new String[lista.size()];
        return lista.toArray(listafinal);
    }
}
