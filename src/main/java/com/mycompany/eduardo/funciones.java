/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eduardo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GaelCM
 */
public class funciones {
    Vector datos=new Vector();
    
    public void escribirArchivo(Eduardo info){
        datos.addElement(info);
    }    
    
    public void guardarArchivo(Eduardo data){
        try{
            FileWriter fw=new FileWriter("Reos.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.print(","+data.getNombre());
            pw.print(","+data.getApellidos());
            pw.print(","+data.getFecha());
            pw.print(","+data.getPeso());
            pw.print(","+data.getAltura());
            pw.println(","+data.getCargos());       
            pw.close();
        }catch(Exception a){
         JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    
    public DefaultTableModel ListaGenerada(){
        
        Vector array=new Vector();
        
        array.addElement("Nombre");
        array.addElement("Apellidos");
        array.addElement("Fecha");
        array.addElement("Peso");
        array.addElement("Altura");
        array.addElement("Cargos");
        
        DefaultTableModel lista=new DefaultTableModel(array,0);
        
        try{
            FileReader fw=new FileReader("Reos.txt");
            BufferedReader br=new BufferedReader(fw);
            String c;
            while((c=br.readLine())!= null){
                StringTokenizer dato= new StringTokenizer(c,",");
                Vector t=new Vector();
                while(dato.hasMoreTokens()){
                    t.addElement(dato.nextToken());
                }
                lista.addRow(t);
            }
        }catch(Exception z){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return lista;
    }
}
