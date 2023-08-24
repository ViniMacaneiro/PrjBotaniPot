package prototipobotani;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Componentes {
    private int idComponentes;
    private String modelo;
    private Boolean funcionando;
    private String marca;
    private static final String TABLE_NAME = "componentes";
    private static final String COLUMN_ID = "idComponentes";
    private static final String COLUMN_MODELO = "Modelo";
    private static final String COLUMN_MARCA = "Marca";

    public boolean incluirComponente() {
        String sql = "INSERT INTO hortaprototipo." + TABLE_NAME + " (" + COLUMN_MODELO + ", " + COLUMN_MARCA + ") "
                + "VALUES (?, ?);";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.modelo);
            stm.setString(2, this.marca);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Insert: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public boolean alterarComponente() {
        String sql = "UPDATE hortaprototipo." + TABLE_NAME + " "
                + "SET " + COLUMN_MODELO + " =?, " + COLUMN_MARCA + " =? "
                + "WHERE " + COLUMN_ID + " =?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.modelo);
            stm.setString(2, this.marca);
            stm.setInt(3, this.idComponentes);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public boolean excluirComponente() {
        String sql = "DELETE FROM hortaprototipo." + TABLE_NAME + " "
                + "WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idComponentes);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Delete: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public Componentes consultarComponente() {
        Componentes componente = null;
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_MODELO + ", " + COLUMN_MARCA
                + " FROM hortaprototipo." + TABLE_NAME
                + " WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idComponentes);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                componente = new Componentes();
                componente.setIdComponentes(rs.getInt(COLUMN_ID));
                componente.setModelo(rs.getString(COLUMN_MODELO));
                componente.setMarca(rs.getString(COLUMN_MARCA));
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return componente;
    }

    public List<Componentes> listarComponentes() {
        List<Componentes> listaComponentes = new ArrayList<>();
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_MODELO + ", " + COLUMN_MARCA
                + " FROM hortaprototipo." + TABLE_NAME;

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Componentes componente = new Componentes();
                componente.setIdComponentes(rs.getInt(COLUMN_ID));
                componente.setModelo(rs.getString(COLUMN_MODELO));
                componente.setMarca(rs.getString(COLUMN_MARCA));
                listaComponentes.add(componente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return listaComponentes;
    }
    
    // Getters e Setters

    public int getIdComponentes() {
        return idComponentes;
    }

    public void setIdComponentes(int idComponentes) {
        this.idComponentes = idComponentes;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
