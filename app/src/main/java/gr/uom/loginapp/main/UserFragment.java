package gr.uom.loginapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import gr.uom.loginapp.R;
import gr.uom.loginapp.ui.login.LoginActivity;

public class UserFragment extends Fragment {

    private FirebaseAuth mAuth;


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mAuth =  FirebaseAuth.getInstance();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,   MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logoutMenuOption:
                doLogout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void doLogout() {
        Toast.makeText(getContext(),"Logging out...",Toast.LENGTH_LONG).show();
        mAuth.signOut();
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }
}