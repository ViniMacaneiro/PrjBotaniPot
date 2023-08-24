package prototipobotani;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.Conexao;

public class Horta {
    private int idHorta;
    private int idCliente;
    private String nome;
    private int umidadePercentual;
    private int solarPercentual;
    private double aguaRecomendada;

    private static final String TABLE_NAME = "horta";
    private static final String COLUMN_ID = "idHorta";
    private static final String COLUMN_NAME = "Nome";
    private static final String COLUMN_UMIDADE = "Umidade_Percentual";
    private static final String COLUMN_SOLAR = "Solar_Percentual";
    private static final String COLUMN_AGUA = "Agua_Recomendada";
    private static final String COLUMN_ID_CLIENTE = "idCliente";

    public boolean incluirHorta() {
        String sql = "INSERT INTO hortaprototipo." + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_ID_CLIENTE + ", " + COLUMN_UMIDADE + ", " + COLUMN_SOLAR + ", " + COLUMN_AGUA + ") "
                + "VALUES (?, ?, ?, ?, ?);";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(2, this.idCliente);            
            stm.setString(1, this.nome);
            stm.setInt(3, this.umidadePercentual);
            stm.setInt(4, this.solarPercentual);
            stm.setDouble(5, this.aguaRecomendada);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Insert: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public boolean alterarHorta() {
        String sql = "UPDATE hortaprototipo." + TABLE_NAME + " "
                + "SET " + COLUMN_NAME + " =?, " + COLUMN_UMIDADE + " =?, " + COLUMN_SOLAR + " =?, " + COLUMN_AGUA + " =? "
                + "WHERE " + COLUMN_ID + " =?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.nome);
            stm.setInt(2, this.umidadePercentual);
            stm.setInt(3, this.solarPercentual);
            stm.setDouble(4, this.aguaRecomendada);
            stm.setInt(5, this.idHorta);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public boolean excluirHorta() {
        String sql = "DELETE FROM hortaprototipo." + TABLE_NAME + " "
                + "WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idHorta);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Delete: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public Horta consultarHorta() {
        Horta horta = null;
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_UMIDADE + ", " + COLUMN_SOLAR + ", " + COLUMN_AGUA
                + " FROM hortaprototipo." + TABLE_NAME
                + " WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idHorta);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                horta = new Horta();
                horta.setIdHorta(rs.getInt(COLUMN_ID));
                horta.setNome(rs.getString(COLUMN_NAME));
                horta.setUmidadePercentual(rs.getInt(COLUMN_UMIDADE));
                horta.setSolarPercentual(rs.getInt(COLUMN_SOLAR));
                horta.setAguaRecomendada(rs.getDouble(COLUMN_AGUA));
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return horta;
    }

    public List<Horta> listarHortas() {
        List<Horta> listaHortas = new ArrayList<>();
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_UMIDADE + ", " + COLUMN_SOLAR + ", " + COLUMN_AGUA
                + " FROM hortaprototipo." + TABLE_NAME;

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Horta horta = new Horta();
                horta.setIdHorta(rs.getInt(COLUMN_ID));
                horta.setNome(rs.getString(COLUMN_NAME));
                horta.setUmidadePercentual(rs.getInt(COLUMN_UMIDADE));
                horta.setSolarPercentual(rs.getInt(COLUMN_SOLAR));
                horta.setAguaRecomendada(rs.getDouble(COLUMN_AGUA));
                listaHortas.add(horta);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return listaHortas;
    }

    public int getIdCliente() {
        return idHorta;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdHorta() {
        return idHorta;
    }

    public void setIdHorta(int idHorta) {
        this.idHorta = idHorta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUmidadePercentual() {
        return umidadePercentual;
    }

    public void setUmidadePercentual(int umidadePercentual) {
        this.umidadePercentual = umidadePercentual;
    }

    public int getSolarPercentual() {
        return solarPercentual;
    }

    public void setSolarPercentual(int solarPercentual) {
        this.solarPercentual = solarPercentual;
    }

    public double getAguaRecomendada() {
        return aguaRecomendada;
    }

    public void setAguaRecomendada(double aguaRecomendada) {
        this.aguaRecomendada = aguaRecomendada;
    }
    
}