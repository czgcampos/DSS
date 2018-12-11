/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.Actor;
import Business.Administrador;
import Business.Morador;
import Business.Senhorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 */
public class ActorDAO{
    
    public static boolean contains(Object o) {
        Connection con=null;
        Set<String> res= ActorDAO.keySet();
        return (res.contains((String) o));
    }
    
    public static boolean containsValue(Object o) {
        Collection<Actor> con=null;
        Boolean res = false;
        con = ActorDAO.values();
        for(Actor a : con){
            if(a.equals((Actor) o))
                res=true;
        }
        return res;
    }
    
    
    
    public static boolean iniciaSessao(String email, String password){
        Connection con=null;
        int size = 0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("Select count(*) from Actor where (email=? && password = ?)");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt(1);
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
        if(size==0) return false;
        return true;
    }
    
    public static Actor get(Object o) {
        Connection con=null;
        Actor res = null;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from actor where email = ?");
            ps.setString(1,(String) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("cargo").equals("Administrador"))
                    res = new Administrador(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
                else
                    if(rs.getString("cargo").equals("Morador"))
                        res = new Morador(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
                    else
                        res = new Senhorio(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
            }
        }
        catch(SQLException e){
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
    
    public static String[] getActores(){
        Collection<Actor> col = ActorDAO.values();
        int iter =0;
        String[] lista = new String[col.size()];
        for(Actor a : col){
            lista[iter]=a.toString();
            iter++;
        }
        return lista;
    }
    
    public static int remActor(String o) {
        Connection con=null;
        int rs=0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE from actor where email = ?");
            ps.setString(1,o);
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
        return rs;
    }
    
    public static void clear() {
        Connection con=null;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT Email from actor");
            ResultSet rs = ps.executeQuery();
            PreparedStatement pst;
            while(rs.next()){
                pst = con.prepareStatement("DELETE from Actor where Email = ?");
                pst.setString(1,rs.getString(1));
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
    
    public static Set<String> keySet() {
        Connection con=null;
        Set<String> res = new HashSet<String>();
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT Email from actor");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString(1));
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
    
    public static Collection<Actor> values() {
        Connection con=null;
        Actor res = null;
        Collection<Actor> col = new ArrayList<Actor>();
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * from actor");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("cargo").equals("Administrador"))
                    res = new Administrador(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
                else
                    if(rs.getString("cargo").equals("Morador"))
                        res = new Morador(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
                    else
                        res = new Senhorio(rs.getString("moradaCasa"), rs.getInt("telemovel"), rs.getString("email"), rs.getString("nome"), rs.getString("password"), rs.getString("cargo"));
                col.add(res);
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
        return col;
    }
    
    public static Actor addMorador(Actor ator){
        Connection con=null;
        int i=0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Actor (email,moradaCasa, telemovel, nome, password, cargo) VALUES (?,?,?,?,?,?)");
            ps.setString(1, ator.getEmail());
            ps.setString(2, ator.getMoradaCasa());
            ps.setInt(3, ator.getTelemovel());
            ps.setString(4, ator.getNome());
            ps.setString(5, ator.getPassword());
            ps.setString(6, ator.getCargo());
            i = ps.executeUpdate();               
        }
        catch(SQLException e){
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
        return ator;
    }

    public static int size() {
        Connection con=null;
        int size = -1;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT count(email) from actor");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt(1);
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
        return size;
    }

    public static boolean isEmpty() {
        Connection con=null;
        int size = 0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT count(email) from actor");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt(1);
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
        return (size==0);
    }
}
