package herick.info.caduser;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

public class TelaCadastroUsuario {
    MainActivity act;
    EditText txtNomep, txtEnderecop, txtTelefonep;
    Button btnCadastrar, btnCancelar;
    TelaPrincipal telaPrincipal;

    public TelaCadastroUsuario(MainActivity act, TelaPrincipal telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.tela2activity);
        txtNomep = (EditText) act.findViewById(R.id.txtNomep);
        txtEnderecop = (EditText) act.findViewById(R.id.txtEnderecop);
        txtTelefonep = (EditText) act.findViewById(R.id.txtTelefonep);
        btnCancelar = (Button) act.findViewById(R.id.btnCancelar);
        btnCadastrar = (Button)act.findViewById(R.id.btnCadastrar) ;
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuario?");
                dialogo.setNegativeButton("Não",
                        null);
                dialogo.setPositiveButton("Sim",
                        new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String nome =
                                                txtNomep.getText().toString();
                                        String telefone =
                                                txtTelefonep.getText().toString();
                                        String endereco =
                                                txtEnderecop.getText().toString();
                                        act.getaRegistro().add(new
                                                Registro(nome, endereco, telefone));
                                        act.ExibirMensagem("Cadastro efetuado com sucesso.");
                                        telaPrincipal.CarregarTela();
                                    }
                                });
                dialogo.show();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                telaPrincipal.CarregarTela();
                            }
                        });
                dialogo.show();
            }
        });
    }
}



