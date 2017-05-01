package somani.siddharth.tophawkstraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<UploadPojo> uploads;
    private Firebase mDatabase;
    String child;
    public MyAdapter(Context context, List<UploadPojo> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        Firebase.setAndroidContext(context);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        UploadPojo upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());
        holder.textViewModules.setText(upload.getModules());
        holder.textViewMinutes.setText(upload.getMinutes());
        holder.textViewName.setText(upload.getName());

        Glide.with(context).load(upload.getUrl()).into(holder.imageView);
        mDatabase = new Firebase("https://occupation-fc1fb.firebaseio.com/").child("Modules");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                mDatabase.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                       /* Toast.makeText(context, dataSnapshot.getKey(), Toast.LENGTH_LONG).show();*/

                        if(holder.textViewName.getText().toString().equals(dataSnapshot.child("name").getValue(String.class))) {
                            child = dataSnapshot.getKey();
                            //Toast.makeText(context, child, Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(view.getContext(),CardActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("child",child);
                            context.startActivity(intent);

                        }
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewModules;
        public TextView textViewMinutes;
        public ImageView imageView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewMinutes=(TextView)itemView.findViewById(R.id.time);
            textViewModules=(TextView)itemView.findViewById(R.id.module);
        }
    }
}
