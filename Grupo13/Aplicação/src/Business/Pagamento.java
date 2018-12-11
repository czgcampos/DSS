/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author user
 */
public class Pagamento {
    private int despesa;
    private String actor;
    private float montante;
    
    public Pagamento(){
        this.montante=0;
        this.despesa=0;
        this.actor="";
    }
    
    public Pagamento(int d, String a, float f){
        this.despesa=d;
        this.actor=a;
        this.montante=f;
    }
    
    public Pagamento(Pagamento p2){
        this.despesa=p2.getDespesa();
        this.actor=p2.getActor();
        this.montante=p2.getMontante();
    }
    
    public int getDespesa(){
        return this.despesa;
    }
    
    public void setDespesa(int d){
        this.despesa=d;
    }
    
    public String getActor(){
        return this.actor;
    }
    
    public void setActor(String a){
        this.actor=a;
    }
    
    public float getMontante(){
        return this.montante;
    }
    
    public void setMontante(float m){
        this.montante=m;
    }
}
