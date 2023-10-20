package herick.info.caduser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<Registro> aRegistro;
    TelaPrincipal tela_principal;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuario tela_listagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main);
        aRegistro = new ArrayList<Registro>();
        tela_principal = new TelaPrincipal(this);
        tela_cadastro = new TelaCadastroUsuario(this, tela_principal);
        tela_listagem = new TelaListagemUsuario(this, tela_principal);
        tela_principal.setTelaCadastro(tela_cadastro);
        tela_principal.setTelaListagem(tela_listagem);
        tela_principal.CarregarTela();
    }
   public ArrayList<Registro>getaRegistro(){
        return aRegistro;
   }
   public void ExibirMensagem(String msg){
       AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
       d.setTitle("Aviso");
       d.setMessage(msg);
       d.setNeutralButton("OK", null); d.show();
   }
}

