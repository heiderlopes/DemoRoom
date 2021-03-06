package br.com.heiderlopes.demoroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

import java.util.List;

import br.com.heiderlopes.demoroom.persistencia.AppDatabase;
import br.com.heiderlopes.demoroom.persistencia.entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        tvResultado = (TextView) findViewById(R.id.tvResultado);

        db = AppDatabase.getDatabase(this);

        List<Usuario> usuarios = db.usuarioDAO().buscarTodos();
        if(usuarios == null || usuarios.size() == 0) {
            Usuario usuario = new Usuario();
            usuario.setLevel(1);
            usuario.setNome("Heider Lopes");
            usuario.setPontos(1000);

            db.usuarioDAO().adicionarUsuario(usuario);
            StringBuilder sb = new StringBuilder();
            sb.append(usuario.getNome());
            sb.append(" Pontos: ");
            sb.append(usuario.getPontos());

            tvResultado.setText(sb.toString());

        } else {
            Usuario usuario = new Usuario();
            usuario.setId(1);
            usuario.setLevel(1);
            usuario.setNome("Subzero");
            usuario.setPontos(1000);

            db.usuarioDAO().adicionarUsuario(usuario);

            StringBuilder sb = new StringBuilder();
            for(Usuario user : usuarios) {
                sb.append(user.getNome());
                sb.append(" Pontos: ");
                sb.append(user.getPontos());
                sb.append(System.getProperty("line.separator"));
            }
            tvResultado.setText(sb.toString());
        }
    }
}
