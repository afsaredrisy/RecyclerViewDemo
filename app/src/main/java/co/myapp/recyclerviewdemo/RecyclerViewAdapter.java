package co.myapp.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;

    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.setItemClickListner(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }




    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

        public void setItemClickListner(View.OnClickListener clickListner){
            textView.setOnClickListener(clickListner);
        }

    }
}
