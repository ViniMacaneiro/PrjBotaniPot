/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipobotani;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vinicius_g_macaneiro
 */
public class Coleta {

    private int indiceUmidade;
    private int indiceSolar;
    private Date dataColeta;
    private static final String TABLE_NAME = "Coleta";
    private static final String COLUMN_ID1 = "Horta_idHorta";
    private static final String COLUMN_ID2 = "Cliente_idCliente";
    private static final String COLUMN_UMIDADE = "Umidade";
    private static final String COLUMN_SOLAR = "Solar";
    private static final String COLUMN_DATACOLETA = "DATACOLETA";
    
    //Coleta os dados do Arduino
    public boolean coletaArduino() {
        return true;
    }
    
    public boolean inserirArduino() {
        return true;
    }
    
    //Consulta os dados de uma coleta específica
    public Coleta consultarColeta() {
        Coleta coleta = null;
        return coleta;
    }
    
    //Consulta todas as coletas do sistema
    public List<Coleta> listarColetas() {
        List<Coleta> listaColeta = new ArrayList<>();
        return listaColeta;
    }
    
    //Consulta todas as coletas do sistema por data
    public List<Coleta> listarColetasPorData() {
        List<Coleta> listaColetaData = new ArrayList<>();
        return listaColetaData;
    }

    
}
