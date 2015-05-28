package course.examples.helloworldwithlogin;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        //On r�cup�re les r�f�rences vers les EditText et le Button du layout
        final EditText uname = (EditText) findViewById(R.id.username_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);

        final Button loginButton = (Button) findViewById(R.id.login_button);

        //On d�fini un Listener qui va d�crire le comportement de l'appli quand on clique sur le bouton
        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                //Si le login et le mdp rentr�s sont OK
                if (checkPassword(uname.getText(), passwd.getText())) {

                    // Create an explicit Intent for starting the HelloAndroid
                    // Activity
                    //Cr�ation d'un Intent explicite qui part de l'activit� courante et � destination de l'activit� HelloAndroid
                    Intent helloAndroidIntent = new Intent(LoginScreen.this, HelloAndroid.class);

                    // Use the Intent to start the HelloAndroid Activity
                    //On d�marre l'activit� cible gr�ce � startActivity
                    startActivity(helloAndroidIntent);
                } else {
                    //Sinon on reste dans l'activit� initiale et on r�initialise les champs du login et mdp � vide
                    uname.setText("");
                    passwd.setText("");
                }
            }
        });
    }

    private boolean checkPassword(Editable uname, Editable passwd) {
        // Just pretending to extract text and check password
        return new Random().nextBoolean();
    }
}
