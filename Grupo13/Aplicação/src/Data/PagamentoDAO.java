/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



/**
 *
 * @author user
 */
public class PagamentoDAO {

    public static int size() {
        Connection con=null;
        int size = -1;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT count(despesa) from Pagamento");
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
        boolean res = true;
        int size = 0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT count(despesa) from Pagamento");
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

    public static boolean efetuaPagamento(Pagamento p) {
        Connection con=null;
        int i=0;
        try{
            con=Connect.connect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Pagamento (idDespesa,ator, montante) VALUES (?,?,?)");
            ps.setInt(1, p.getDespesa());
            ps.setString(2, p.getActor());
            ps.setFloat(3, p.getMontante());
            i = ps.executeUpdate();
            ps = con.prepareStatement("UPDATE Despesa SET Pago=Pago+? WHERE idDespesa=?;" );
            ps.setFloat(1,p.getMontante());
            ps.setInt(2,p.getDespesa());
            ps.executeUpdate();
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
        if(i==0) return false;
        return true;
    }
}
