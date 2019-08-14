package EntradaySalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Archivo {
    private static String RUTA = "D:\\Proyecto\\";    
    public static void Escribir(String fileName, String texto) {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        
        try {
            file = new File(RUTA + fileName + ".txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);     
            
            bufferedWriter.write(texto);
            
            bufferedWriter.close();
            fileWriter.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }            
        }
    }
    
    public static String Leer(String fileName) {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String cadena = "";
        String texto = "";

        try {
            file = new File(RUTA + fileName + ".txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);     
            
            while(cadena != null) {
                texto = texto + cadena;
                cadena = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            if(fileReader != null) {
                try {
                    fileReader.close();
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }            
        }        
        
        return texto;
    }       
}