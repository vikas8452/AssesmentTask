package com.vikas.assesmenttask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sudha on 18-Aug-18.
 */

public class AdapterOfBillList extends BaseAdapter {

    private final List<Bill_Detail> bill_lists;
    private final Context context;

    AdapterOfBillList(Context context, List<Bill_Detail> bill_lists) {
        this.bill_lists = bill_lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bill_lists.size();
    }

    @Override
    public Object getItem(int position) {
        return bill_lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        if(view==null)
            view= LayoutInflater.from(context).inflate(R.layout.bill_list_lay,parent,false);

        TextView tvtime = view.findViewById(R.id.time);
        TextView tvbill_no = view.findViewById(R.id.billno);
        TextView tvtype = view.findViewById(R.id.type);
        TextView tvname = view.findViewById(R.id.name);
        TextView tvstatus = view.findViewById(R.id.status);
        TextView tvtotal = view.findViewById(R.id.total);
        TextView tvrupee = view.findViewById(R.id.rupee);

        LinearLayout linearLayout = view.findViewById(R.id.vlinearlayout);
        final RelativeLayout rl = view.findViewById(R.id.loadingdata);
        rl.setVisibility(View.VISIBLE);

        final Bill_Detail bill_detail = (Bill_Detail) getItem(position);

        final String time = bill_detail.getTime();
        final String billno = bill_detail.getBillno();
        final String type = bill_detail.getType();
        final String name = bill_detail.getName();
        final String status = bill_detail.getStatus();
        final String total = bill_detail.getTotal();
        final String day = bill_detail.getDay();
        final String month = bill_detail.getMonth();
        final String date = bill_detail.getDate();

        if(status.equalsIgnoreCase("Completed")){
            tvrupee.setVisibility(View.VISIBLE);
            tvtotal.setVisibility(View.VISIBLE);
        }
        if(status.equalsIgnoreCase("Pending"))
            tvname.setVisibility(View.GONE);

        tvtime.setText(day+", "+month+" "+date+", "+time);
        tvbill_no.setText(billno);
        tvtype.setText(type);
        tvname.setText(name);
        tvstatus.setText(status);
        tvtotal.setText(total);



        rl.setVisibility(View.GONE);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(context,AllDetailsOfBill.class);
                in.putExtra("time",day+", "+month+" "+date+", "+time);
                in.putExtra("billno",billno);
                in.putExtra("type",type);
                in.putExtra("name",name);
                in.putExtra("status",status);
                in.putExtra("total",total);
                in.putExtra("day",day);
                in.putExtra("month",month);
                in.putExtra("date",date);
                in.putExtra("rate",bill_detail.getRate());
                in.putExtra("tax",bill_detail.getTax());
                in.putExtra("jobstatus",bill_detail.getJobstatus());
                in.putExtra("address",bill_detail.getAddress());
                in.putExtra("ofwhat",bill_detail.getOfwhat());
                in.putExtra("whereto",bill_detail.getWhereto());
                in.putExtra("jobstatus",bill_detail.getJobstatus());
                in.putExtra("stime",bill_detail.getStarttime());
                in.putExtra("etime",bill_detail.getEndtime());
                in.putExtra("discount",bill_detail.getDiscount());
                context.startActivity(in);
            }
        });

        return view;
    }

}
