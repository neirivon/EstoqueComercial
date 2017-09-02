package neirivon.com.br.estoquecomercial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Context contexto = this;
    Spinner spinner;
    String texto;
    private EditText edtProduto;
    private EditText edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtProduto = (EditText) findViewById(R.id.edtProduto);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);

        spinner = findViewById(R.id.spinnerUnidade);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.unidadeMedida, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spinnerSelecionado);
    }
    private final AdapterView.OnItemSelectedListener spinnerSelecionado = new AdapterView.OnItemSelectedListener(){
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id){
            String item = (String) parent.getItemAtPosition(position);
            Toast.makeText(contexto, item, Toast.LENGTH_SHORT).show();
            texto = "Unidade: " + item + "\n";
        }
        public void onNothingSelected(AdapterView<?> parent){}
    };

    public void radioClick(View view){

        RadioButton controle = (RadioButton)view;
        boolean checado = controle.isChecked();

        switch (controle.getId()){
            case R.id.rNão:
                if(checado)
                    Toast.makeText(this,"Não", Toast.LENGTH_SHORT).show();
                    texto = texto + "Perecível: Não" + "\n";
                break;
            case R.id.rSim:
                if(checado)
                    Toast.makeText(this,"Sim", Toast.LENGTH_SHORT).show();
                    texto = texto + "Perecível: Sim" + "\n";
                break;
        }
    }

    public void checkClick(View view) {
        CheckBox ctrl = (CheckBox)view;
        boolean chkd = ctrl.isChecked();
        switch (ctrl.getId()){
            case R.id.chkPromocao:
                if(chkd)
                    Toast.makeText(this,"Sim", Toast.LENGTH_SHORT).show();
                    texto = texto + "Promoção: Sim" + "\n";
                break;
            case R.id.chkLimite:
                if(chkd)
                    Toast.makeText(this,"Sim", Toast.LENGTH_SHORT).show();
                    texto = texto + "Limite de estoque: Sim" + "\n";
                break;
            case R.id.chkEstoque:
                if(chkd)
                    Toast.makeText(this,"Sim", Toast.LENGTH_SHORT).show();
                    texto = texto + "Estoque Refrigerado: Sim" + "\n";
                break;
        }
    }

    public void gravarTexto(View view) {
        Toast.makeText(contexto,"Produto: "+edtProduto.getText()+"\n"+"Descrição: "+edtDescricao.getText()+"\n"+texto, Toast.LENGTH_LONG).show();
    }
}
