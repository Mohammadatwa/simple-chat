package com.example.coder_kun.simplechat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
    String [] emotions;
    Context context;
    int [] images;

    private static LayoutInflater inflater=null;
    public MyAdapter(Context context, String[] osNameList) {
        // TODO Auto-generated constructor stub
        emotions=osNameList;
        this.context=context;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return emotions.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView emoname;
     //   ImageView emoimage;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.samble_grid, null);
        holder.emoname =(TextView) rowView.findViewById(R.id.emonameid);
     //   holder.emoimage =(ImageView) rowView.findViewById(R.id.emoimageid);

        holder.emoname.setText(emotions[position]);
      //  holder.emoimage.setImageResource(images[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context,
                       // "if "+emotions[position]+", then"
                        "m3lshy"
                        , Toast.LENGTH_LONG).show();


                Intent intent = new Intent(context, EmoActivity.class);
                //put extras adds another variable which is position and we named it index
                intent.putExtra("index",position);
                         context.startActivity(intent);

            }
        });

        return rowView;
    }

}
