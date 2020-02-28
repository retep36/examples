package sk.tuke.rusyn.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.User;
import sk.tuke.rusyn.helpers.UserDbHelper;

public class UserInfo extends AppCompatActivity implements View.OnClickListener {
    UserDbHelper userDbHelper = new UserDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        setTitle("Rusínsky jazyk");

        final TextView userName = findViewById(R.id.user_userName);
        Button logOut = findViewById(R.id.userInfo_logout);
        Button spat = findViewById(R.id.btn_spat2);

        StringBuilder sb = new StringBuilder();
        User user = userDbHelper.selectActiveUser(1);
        assert user != null;
        sb.append(user.getEmail());
        userName.setText(sb);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDbHelper.logOut(1);
                Intent logout = new Intent(UserInfo.this, Login.class);
                startActivity(logout);
            }
        });

        spat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfo.this, ListOfLessons.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
