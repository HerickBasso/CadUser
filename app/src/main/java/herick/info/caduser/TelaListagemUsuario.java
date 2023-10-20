package herick.info.caduser;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaListagemUsuario {

    MainActivity act;
    TelaPrincipal telaPrincipal;
    Button btnAnterior, btnProx, btnFechar;
    TextView txtNome2, txtTelefone, txtEndereco2, txtStatus;
    int index;
    public TelaListagemUsuario(
            MainActivity act,
            TelaPrincipal telaPrincipal){
        this.act =act;
        this.telaPrincipal = telaPrincipal;
            index = 0;
}
public void CarregarTela(){
        if(act.getaRegistro().size()==0){
            (new AlertDialog.Builder(act))  .setTitle("Aviso")
                    .setMessage("Não existe enhum registro cadastrado.")
                    .setNeutralButton("Ok", null);
            return;
        }
        act.setContentView(R.layout.tela3activity);
        btnAnterior = (Button)act.findViewById(R.id.btnAnterior);
        btnProx = (Button) act.findViewById(R.id.btnProx);
        btnFechar = (Button) act.findViewById(R.id.btnFechar);
        txtNome2 = (TextView) act.findViewById(R.id.txtNome2);
        txtEndereco2 = (TextView) act.findViewById(R.id.txtEndereco2);
        txtTelefone = (TextView) act.findViewById(R.id.txtTelefone);
        txtStatus = (TextView) act.findViewById(R.id.txtStatus);
        PreencheCampos(index);
        AtualizaStatus(index);
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index >0){
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                } } } ) ;
        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index < act.getaRegistro().size()-1){
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            } } ) ;
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaPrincipal.CarregarTela();
            } } ) ; }
    private void PreencheCampos(int idx){
        txtNome2.setText(act.getaRegistro().get(idx).getNome());
        txtTelefone.setText(act.getaRegistro().get(idx).getTelefone());
        txtEndereco2.setText(act.getaRegistro().get(idx).getEndereco());
    }
    private void AtualizaStatus(int idx){
        int total = act.getaRegistro().size();
        txtStatus.setText("Registros :" +(idx+1)+"/"+total);
    }
}
