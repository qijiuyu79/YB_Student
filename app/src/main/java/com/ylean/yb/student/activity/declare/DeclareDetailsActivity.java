package com.ylean.yb.student.activity.declare;

import android.app.Dialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.ylean.yb.student.R;
import com.ylean.yb.student.base.BaseActivity;
import com.zxdc.utils.library.util.DialogUtil;
import com.zxdc.utils.library.util.ToastUtil;

import org.sufficientlysecure.htmltextview.HtmlTextView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 批次申报详情
 */
public class DeclareDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_valid_time)
    TextView tvValidTime;
    @BindView(R.id.tv_send_time)
    TextView tvSendTime;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_html)
    HtmlTextView tvHtml;

    /**
     * 加载布局
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_declare_details;
    }


    /**
     * 初始化
     */
    @Override
    protected void initData() {
        super.initData();
        tvTitle.setText("批次申报详情");
        tvDes.setText(Html.fromHtml("注：未能展示出符合实际申报的批次，请从个人档案中正确维护教育经历！<font color=\"#FA4D4F\">去维护></font>"));
    }


    @OnClick({R.id.lin_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_back:
                 finish();
                break;
            case R.id.tv_submit:
                showApplyDialog();
                break;
            default:
                break;
        }
    }


    /**
     * 去申请
     */
    private void showApplyDialog(){
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_apply_declare,null);
        final Dialog dialog= DialogUtil.getDialog(this,view);
        final EditText etCode=view.findViewById(R.id.et_code);
        view.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=etCode.getText().toString().trim();
                if(TextUtils.isEmpty(code)){
                    ToastUtil.showLong("请输入考号");
                    return;
                }
                setClass(AddDeclareActivity.class);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}