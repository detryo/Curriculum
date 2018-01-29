package cristian_sedano.curriculum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setGitHub();
        setLinkedin();
        setSumarryExplication();
        setTextViewEduExplication();
        setTextViewRefExplication();
        setTextViewSkillsExplication();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav);
        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setSumarryExplication(){

        TextView textView = (TextView) findViewById(R.id.sum_explication);

        String[] stringArray = getResources().getStringArray(R.array.sum_array);
        String textOut = "";

        for(int i = 0; i < stringArray.length; i++){
            textOut += stringArray[i] + "\n";
        }
        textView.setText(textOut);
    }

    private void setTextViewEduExplication(){

        TextView textView = (TextView) findViewById(R.id.edu_explication);

        String[] stringArray = getResources().getStringArray(R.array.edu_array);
        String textOut = "";

        for(int i = 0; i < stringArray.length; i++){
            textOut += stringArray[i] + "\n";
        }
        textView.setText(textOut);
    }

    private void setTextViewRefExplication(){

        TextView textView = (TextView) findViewById(R.id.ref_explication);

        String[] stringArray = getResources().getStringArray(R.array.ref_array);
        String refOut = "";

        for (int i = 0; i < stringArray.length; i++){
            refOut += stringArray[i] + "\n";
        }
        textView.setText(refOut);
    }

    private void setTextViewSkillsExplication(){

        TextView skillsexpl = (TextView) findViewById(R.id.skills_explication);

        String[] stringArray = getResources().getStringArray(R.array.skills_array);
        String skillsOut = "";

        for (int i = 0; i < stringArray.length; i++){
            skillsOut += stringArray[i] + "\n";
        }
        skillsexpl.setText(skillsOut);
    }

    private void setGitHub(){
        Button buttonGit = (Button) findViewById(R.id.github);

        buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/detryo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void setLinkedin(){
        Button buttonLinkedin = (Button) findViewById(R.id.linkedin);

        buttonLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/cristian-sedano-9b5a47141/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment(new Fragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(android.support.v4.app.Fragment fragment, MenuItem item){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_mail:
                fragment = new EmailFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_phone:
                fragment = new PhoneFragment();
                fragmentTransaction = true;
                break;
                default:
        }
        if (fragmentTransaction){
            changeFragment(fragment, item);
            drawerLayout.closeDrawers();
        }

        return true;
    }


}
