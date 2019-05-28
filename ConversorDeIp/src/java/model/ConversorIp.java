/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Randolfo Machado
 */
public class ConversorIp {
    private String endereco;
    private String ipPadrao;
    private String cidrIp;
    private String classeIp;
    private String classeMascaraIp;
    String array[] = new String[2];
    
    public ConversorIp(String ipPadrao){
       this.endereco = ipPadrao;
       array = ipPadrao.split("/");
       this.ipPadrao = array[0];
       this.cidrIp = array[1];
    }
    
    public String ClasseIp(){
        int octeto = Integer.parseInt(this.ipPadrao.split("\\.")[0]);
        
        if(octeto>=0 && octeto<=127)
            this.classeIp = "A";
        else if(octeto>=128 && octeto<=191)
            this.classeIp = "B";
        else if(octeto>=192 && octeto<=223)
            this.classeIp = "C";
        else if(octeto>=224 && octeto<=239)
            this.classeIp = "D";
        else if(octeto>=240 && octeto<=255)
            this.classeIp = "E";
                    
        return this.classeIp;
    }
    
    public String ClasseMascaraIp(){
        int cidr = Integer.parseInt(this.cidrIp);
        
        if(cidr >= 0 && cidr < 9)
            this.classeMascaraIp = "A";
        else if(cidr < 17)
            this.classeMascaraIp = "B";
        else if(cidr < 25)
            this.classeMascaraIp = "C";
        else if(cidr < 33)
            this.classeMascaraIp = "D";
        return this.classeMascaraIp;
    }
    
    public String MascaraSubRede(){
        String classeMascara = ClasseMascaraIp();
        int cidr = Integer.parseInt(this.cidrIp);
        String subRede = null;
        
        if(classeMascara == "A"){
            switch(cidr){
                case 0:
                    subRede = "0.0.0.0";
                    break;
                case 1:
                    subRede = "128.0.0.0";
                    break;
                case 2:
                    subRede = "192.0.0.0";
                    break;
                case 3:
                    subRede = "224.0.0.0";
                    break;
                case 4:
                    subRede = "240.0.0.0";
                    break;
                case 5:
                    subRede = "248.0.0.0";
                    break;
                case 6:
                    subRede = "252.0.0.0";
                    break;
                case 7:
                    subRede = "254.0.0.0";
                    break;
                case 8:
                    subRede = "255.0.0.0";
                    break;
            }
        }else if(classeMascara == "B"){
            switch(cidr){
                case 9:
                    subRede = "255.128.0.0";
                    break;
                case 10:
                    subRede = "255.192.0.0";
                    break;
                case 11:
                    subRede = "255.224.0.0";
                    break;
                case 12:
                    subRede = "255.240.0.0";
                    break;
                case 13:
                    subRede = "255.248.0.0";
                    break;
                case 14:
                    subRede = "255.252.0.0";
                    break;
                case 15:
                    subRede = "255.254.0.0";
                    break;
                case 16:
                    subRede = "255.255.0.0";
                    break;
            }        
        }else if(classeMascara == "C"){
                        switch(cidr){
                case 17:
                    subRede = "255.255.128.0";
                    break;
                case 18:
                    subRede = "255.255.192.0";
                    break;
                case 19:
                    subRede = "255.255.224.0";
                    break;
                case 20:
                    subRede = "255.255.240.0";
                    break;
                case 21:
                    subRede = "255.255.248.0";
                    break;
                case 22:
                    subRede = "255.255.252.0";
                    break;
                case 23:
                    subRede = "255.255.254.0";
                    break;
                case 24:
                    subRede = "255.255.255.0";
                    break;
            }
        }else if(classeMascara == "D"){
            switch(cidr){
                case 25:
                    subRede = "255.255.255.128";
                    break;
                case 26:
                    subRede = "255.255.255.192";
                    break;
                case 27:
                    subRede = "255.255.255.224";
                    break;
                case 28:
                    subRede = "255.255.255.240";
                    break;
                case 29:
                    subRede = "255.255.255.248";
                    break;
                case 30:
                    subRede = "255.255.255.252";
                    break;
                case 31:
                    subRede = "255.255.255.254";
                    break;
                case 32:
                    subRede = "255.255.255.255";
                    break;
            }
        }
        return subRede;
    }
    
    @Override
    public String toString(){
        return "<fieldset><center>" +
               "<b>Endereço/Rede:</b> "+this.endereco+
               "<br /><b>Endereço:</b> "+this.ipPadrao+
               "<br /><b>Prefixo CIDR:</b> "+this.cidrIp+
               "<br /><b>Classe do ip:</b> "+ ClasseIp()+
               "<br /><b>Máscara de sub-rede:</b> "+ MascaraSubRede() +
               "</fieldset></center>";                
    }
}


