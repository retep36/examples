package sk.tuke.rusyn.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.User;
import sk.tuke.rusyn.helpers.UserDbHelper;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 1;

    UserDbHelper userDbHelper = new UserDbHelper(this);

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);
    }

//    private void updateUI(GoogleSignInAccount account) {
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //IS USER LOGGED? - IF YES, OPEN NEXT ACTIVITY
        //Log.e("LOGIN", "PRVE");
        boolean userLogged = userDbHelper.isUserLogged();
        //Log.e("LOGIN", String.valueOf(userLogged));
        if(userLogged){
            Intent intent = new Intent(Login.this,ListOfLessons.class);
            startActivity(intent);
            this.finishActivity(0);
        }

        findViewById(R.id.sign_in_button).setOnClickListener(this);


//        TextView userName = findViewById(R.id.textView412);
//        List<User> lessonInfoList = userDbHelper.getAllUsers();
//        StringBuilder sb = new StringBuilder();
//        assert lessonInfoList != null;
//        for (User user : lessonInfoList) {
//            sb.append(user.getEmail()).append(" ").append(user.getIsLogged()).append("\n");
//            //Log.e("LESSON ACTIVITY", String.valueOf(sb));
//        }
//
//        userName.setText(sb);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sign_in_button:
                    signIn();
                    break;
                // ...
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            //Toast.makeText(this, "Vitaj: " + account.getEmail() + " " + account.getId(), Toast.LENGTH_LONG).show();
            //Log.e("SIGN OK", String.valueOf(account.getEmail()) + String.valueOf(account.getId()));
            userDbHelper.addOrUpdateUser(new User(account.getId(), account.getEmail(),1));
            Intent mainActivity = new Intent(Login.this, ListOfLessons.class);
            startActivity(mainActivity);
        } catch (ApiException e) {
            //Log.e("SIGN ER", String.valueOf(e.getStatusCode()));
            Toast.makeText(this, "Pre prihlásenie musíš byť online", Toast.LENGTH_LONG).show();
        }
    }
}
