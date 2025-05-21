/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.util.ResultSetUtil;
import views.frmclientes;
import models.Cliente;
import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Erick
 */
public class ClienteDAO {
   
    private Connection con;
            
    public ClienteDAO(){
    // Conectar no Banco de Dados
    this.con = new ConnectionFactory().getConnection();
    }
    
    //Método cadastrarCliente
    public void cadastrarCliente(Cliente obj)
    
    {
        try {
            //1° Criar o comando SQL
            
            String sql = "INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            //2° Organizar e execurar comando SQL
           PreparedStatement stmt = con.prepareStatement(sql);
           
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());  
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getTelefone());
           stmt.setString(6, obj.getCelular());
           stmt.setString(7, obj.getCep());
           stmt.setString(8, obj.getEndereco());
           stmt.setInt(9, obj.getNumero());
           stmt.setString(10, obj.getComplemento());
           stmt.setString(11, obj.getBairro());
           stmt.setString(12, obj.getCidade());
           stmt.setString(13, obj.getUf());
           
           //3° executar o comando       
           stmt.execute();
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
  
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
           
        }
    
    
    }
    //Método listar todos os clientes
    public List<Cliente> listarclientes(){
    
        try   {   
            //1° Passo Cadastrar o comando SQL
            String sql = "select * from tb_clientes";
            
            //2°Criar lista 
            List<Cliente> lista = new ArrayList<>();
            
            //3° organizar e executar comando SQL 
           PreparedStatement stmt = con.prepareStatement(sql);
           
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente obj = new Cliente();
                
                //Montar Objeto
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                
                //Adicionar objeto com o dados na lista
                lista.add(obj);
            }
            return lista;
       
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null; 
        }
    }    
    
   //Método alterar cliente
    public void alterarCliente(Cliente obj){
    
    
        try {
            //1° Criar o comando SQL
            
            String sql = "UPDATE tb_clientes SET nome =?, rg =?, cpf =?, email =?, telefone =?, celular =?, cep =?, endereco =?, "
            + "numero =?, complemento =?, bairro =?, cidade =?, estado =? where id = ?"; 
                    
            
            //2° Organizar e execurar comando SQL
           PreparedStatement stmt = con.prepareStatement(sql);
           
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());  
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getTelefone());
           stmt.setString(6, obj.getCelular());
           stmt.setString(7, obj.getCep());
           stmt.setString(8, obj.getEndereco());
           stmt.setInt(9, obj.getNumero());
           stmt.setString(10, obj.getComplemento());
           stmt.setString(11, obj.getBairro());
           stmt.setString(12, obj.getCidade());
           stmt.setString(13, obj.getUf());
           stmt.setInt(14, obj.getId());
           
           
           //3° executar o comando       
           stmt.execute();
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
            
  
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
           
        }
    }
    
  //Método excluir cliente 
    public void excluirCliente(int id){
        try {
            //1° Criar o comando SQL
            
            String sql = "delete from tb_clientes where id = ?" ; 
                    
            
            //2° Organizar e execurar comando SQL
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1,id);  
           
           
           //3° executar o comando       
           stmt.execute();
           stmt.close();
           
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            
  
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
           
        }
        
    }
    
}
