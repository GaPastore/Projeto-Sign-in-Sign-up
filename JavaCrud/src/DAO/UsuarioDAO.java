
package DAO;

import java.sql.SQLException;
import DTO.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticarUsuario(UsuarioDTO objUsuarioDTO){
        
        conn = (Connection) new DAOConnection().BDConnection();
        
        try {
            
            String sql = "Select * from usuario where emailUsuario = ? and senhaUsuario = ?";
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDTO.getEmailUsuario());
            pstm.setString(2, objUsuarioDTO.getSenhaUsuario());
            
            ResultSet result = pstm.executeQuery();
            return result;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "usuario DAO: " + e);
            return null;
        }
        
        
    }
    
    public int cadastrarUsuario(UsuarioDTO objUsuarioDTO){
        
        conn = (Connection) new DAOConnection().BDConnection();
        if(objUsuarioDTO.getEmailUsuario() != null){ 
        try {
            
            String sql = "insert into usuario (nomeUsuario, emailUsuario, senhaUsuario) values (?, ?, ?)";
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDTO.getNomeUsuario());
            pstm.setString(2, objUsuarioDTO.getEmailUsuario());
            pstm.setString(3, objUsuarioDTO.getSenhaUsuario());
            
            int result = pstm.executeUpdate();
            return result;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cadastro usuario DAO: " + e);
            return 0;
        }
        } else{
            JOptionPane.showMessageDialog(null, "Preencha corretamente o campo de email!");
        }
        return 0;
    }
    
}
