package herick.info.caduser;

import android.view.View;
import android.widget.Button;


public class TelaPrincipal {
    MainActivity act;
    Button btCad2;
    Button btn2;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuario tela_listagem;
    public TelaPrincipal(MainActivity act){
        this.act = act;
    }
    public void CarregarTela(){
        act.setContentView(R.layout.activity_main);
        btCad2 = (Button) act.findViewById(R.id.btnCadP);
        btn2 = (Button)
                act.findViewById(R.id.btn2);

        btCad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tela_cadastro.CarregarTela();
            }
        });


    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tela_listagem.CarregarTela();
        }
    });


    }
    public void setTelaCadastro(TelaCadastroUsuario tela2activity)
    {
        this.tela_cadastro = tela2activity;
    }
    public void setTelaListagem(TelaListagemUsuario tela3activity) {
        this.tela_listagem = tela3activity;
    }

   };

