
package ControllerNovo;

import DAO.Conexao;
import DAO.UsuarioDAO;
import ModelNovo.Usuario;
import ViewNovo.FormCadastroView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucca
 */
public class FormCadastroController {
    
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }
    
    
    public void salvarUsuario(){
                
        
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSEnha().getText();
       
        Usuario usuarioXande = new Usuario(usuario, senha);
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuariodao = new UsuarioDAO(conexao);
            usuariodao.insert(usuarioXande);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
