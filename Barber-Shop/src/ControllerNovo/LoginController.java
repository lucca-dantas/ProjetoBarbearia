
package ControllerNovo;

import DAO.Conexao;
import DAO.UsuarioDAO;
import ModelNovo.Usuario;
import ViewNovo.LoginView;
import ViewNovo.MenuView;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucca
 */
public class LoginController {
    
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Buscar um usuario da view
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        
        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        //Verificar se existe no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        //Se existir, direciona pro menu
        if(existe){
        MenuView telaMenu = new MenuView();
        telaMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos.");
        }
        
        

    }
    
    
    
    
    
    
    
    
}
