/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DadosGeraisDAO {
    
    public static int getIdDespesa(){
        Connection con=null;
        int size = 0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT idDespesa from DadosGerais");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt(1);
                size++;
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
    
    public static void updateIdDespesa(){
        Connection con=null;
        int size = -1;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT idDespesa from DadosGerais");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt("idDespesa");
            }
            ps = con.prepareStatement("Insert INTO DadosGerais (idDespesa) Values(?)");
            ps.setInt(1, size+1);
            ps.executeUpdate();
            ps = con.prepareStatement("Delete FROM DADOSGERAIS WHERE idDespesa=?");
            ps.setInt(1,size);
            ps.executeUpdate();
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
    
    public static int getRegisto(){
        Connection con=null;
        int size = 0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT registo from DadosGerais");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt(1);
                size++;
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
    
    public static void updateRegisto(){
        Connection con=null;
        int size = -1;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT registo from DadosGerais");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size=rs.getInt("registo");
            }
            ps = con.prepareStatement("Insert INTO DadosGerais (registo) Values(?)");
            ps.setInt(1, size+1);
            ps.executeUpdate();
            ps = con.prepareStatement("Delete FROM DADOSGERAIS WHERE registo=?");
            ps.setInt(1,size);
            ps.executeUpdate();
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
}
