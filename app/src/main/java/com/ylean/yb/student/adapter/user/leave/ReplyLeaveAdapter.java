package com.ylean.yb.student.adapter.user.leave;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ylean.yb.student.R;
import com.zxdc.utils.library.bean.LeaveBean;
import com.zxdc.utils.library.bean.LeaveDetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReplyLeaveAdapter extends BaseAdapter {

    private Activity activity;
    private List<LeaveDetailsBean.ListBean> list;
    public ReplyLeaveAdapter(Activity activity, List<LeaveDetailsBean.ListBean> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder = null;

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.item_leave_reply, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final LeaveDetailsBean.ListBean listBean=list.get(position);
        if(listBean.getType()==0){
            holder.tvType.setText("学生回复：");
        }else{
            holder.tvType.setText("基金会回复：");
        }
        holder.tvTime.setText(listBean.getCreatetime());
        holder.tvContent.setText(listBean.getMessage());
        return view;
    }


    static
    class ViewHolder {
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
