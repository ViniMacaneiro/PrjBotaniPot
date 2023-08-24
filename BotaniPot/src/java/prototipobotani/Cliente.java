package prototipobotani;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.Conexao;

public class Cliente {

    private static final String TABLE_NAME = "cliente";
    private static final String COLUMN_ID = "cliente.idCliente";
    private static final String COLUMN_NAME = "cliente.Nome";
    private static final String COLUMN_PASSWORD = "cliente.Senha";
    private static final String COLUMN_EMAIL = "cliente.Email";

    private int idCliente;
    private String nome;
    private String senha;
    private String email;

    public boolean incluirCliente() {
        String sql = "INSERT INTO hortaprototipo." + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_EMAIL + ") "
                + "VALUES (?, ?, ?);";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.nome);
            stm.setString(2, this.senha);
            stm.setString(3, this.email);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Insert: " + ex.getMessage() + " \nComando SQL : " + sql);
            
            return false;
        }
    }

    public boolean alterarCliente() {
        String sql = "UPDATE hortaprototipo." + TABLE_NAME + " "
                + "SET " + COLUMN_NAME + " =?, " + COLUMN_PASSWORD + " =?, " + COLUMN_EMAIL + " =? "
                + "WHERE " + COLUMN_ID + " =?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.nome);
            stm.setString(2, this.senha);
            stm.setString(3, this.email);
            stm.setInt(4, this.idCliente);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public boolean excluirCliente() {
        String sql = "DELETE FROM hortaprototipo." + TABLE_NAME + " "
                + "WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idCliente);
            stm.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Delete: " + ex.getMessage() + " \nComando SQL : " + sql);
            return false;
        }
    }

    public Cliente loginCliente(){
    String sql = "SELECT NOME, SENHA, EMAIL, IDCLIENTE "
               + "FROM hortaprototipo."+ TABLE_NAME +" WHERE "+ COLUMN_EMAIL +" = ? "
               + "AND "+ COLUMN_PASSWORD + " = ?;";
        Cliente cli = new Cliente();
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, senha);

            cli.setNome(null);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                setIdCliente(rs.getInt("IDCLIENTE"));
                setNome(rs.getString("NOME"));
            }
        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage() + " \nComando SQL : " + sql);
        }
        return cli;
    }
    
    public Cliente consultarClienteId() {
        Cliente cli = null;
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_EMAIL
                + " FROM hortaprototipo." + TABLE_NAME
                + " WHERE " + COLUMN_ID + " = ?";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, idCliente);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setIdCliente(rs.getInt(COLUMN_ID));
                cli.setNome(rs.getString(COLUMN_NAME));
                cli.setSenha(rs.getString(COLUMN_PASSWORD));
                    cli.setEmail(rs.getString(COLUMN_EMAIL));
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return cli;
}
    
    
    public Cliente consultarCliente() {
        Cliente cli = null;
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_EMAIL
                + " FROM hortaprototipo." + TABLE_NAME
                + " WHERE " + COLUMN_ID + " = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, idCliente);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setIdCliente(rs.getInt(COLUMN_ID));
                cli.setNome(rs.getString(COLUMN_NAME));
                cli.setSenha(rs.getString(COLUMN_PASSWORD));
                cli.setEmail(rs.getString(COLUMN_EMAIL));
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return cli;
    }

    public List<Cliente> listarCliente() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_EMAIL
                + " FROM " + TABLE_NAME;

        try (Connection con = Conexao.conectar();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(COLUMN_ID));
                cli.setNome(rs.getString(COLUMN_NAME));
                cli.setSenha(rs.getString(COLUMN_PASSWORD));
                cli.setEmail(rs.getString(COLUMN_EMAIL));
                listaClientes.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage() + " \nComando SQL : " + sql);
        }
        return listaClientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
