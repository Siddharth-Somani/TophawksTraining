package somani.siddharth.tophawkstraining;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {
    String childl;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    public static Firebase mDatabase;
    //private ProgressDialog progressDialog;
    private List<UploadPojo> uploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Bundle extras=getIntent().getExtras();
        childl= extras.getString("child");
        Firebase.setAndroidContext(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       /* progressDialog = new ProgressDialog(this);*/

        uploads = new ArrayList<>();

        //displaying progress dialog while fetching images
       /* progressDialog.setMessage("Please wait...");
        progressDialog.show();*/
        //Toast.makeText(CardActivity.this,childl,Toast.LENGTH_LONG).show();
        mDatabase = new Firebase("https://occupation-fc1fb.firebaseio.com/Modules").child(childl).child("SubModules");
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
               // progressDialog.dismiss();
                String name = dataSnapshot.child("name").getValue(String.class);
                String url = dataSnapshot.child("url").getValue(String.class);
                UploadPojo uploadPojo=new UploadPojo(name,url);
                uploads.add(uploadPojo);
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        //creating adapter
        adapter = new CardAdapter(getApplicationContext(), uploads);
        //adding adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

}
