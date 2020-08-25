package com.ylean.yb.student.activity.user.bank;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.ylean.yb.student.R;
import com.ylean.yb.student.adapter.user.bank.HistoryBankAdapter;
import com.ylean.yb.student.adapter.user.bank.MyBankAdapter;
import com.ylean.yb.student.base.BaseActivity;
import com.ylean.yb.student.persenter.user.MyBankP;
import com.zxdc.utils.library.bean.BankBaseBean;
import com.zxdc.utils.library.bean.CollMoneyBean;
import com.zxdc.utils.library.view.MeasureListView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的银行卡
 */
public class MyBankActivity extends BaseActivity implements MyBankP.Face {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.listView)
    ListView listView;
    private MeasureListView historyList;
    /**
     * 头部view
     */
    private View headView;
    /**
     * 银行卡基本信息与历史信息
     */
    private List<BankBaseBean.BankBase> bankList = new ArrayList<>();
    private MyBankP myBankP = new MyBankP(this, this);

    /**
     * 加载布局
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mybank;
    }


    /**
     * 初始化
     */
    @Override
    protected void initData() {
        super.initData();
        tvTitle.setText("我的银行卡");

        //获取头部view
        headView = LayoutInflater.from(this).inflate(R.layout.view_bank_head, null);
        historyList = headView.findViewById(R.id.listView);
        listView.addHeaderView(headView);

        //获取银行卡基本信息
        myBankP.getbankinfo();

        //获取银行卡历史信息
        myBankP.getBankHistory();

        //收款信息
        myBankP.getCollMoneyList();

    }


    /**
     * 获取银行卡基本信息
     * @param bankBase
     */
    @Override
    public void getbankinfo(BankBaseBean.BankBase bankBase) {
        if(bankBase==null){
            return;
        }
        bankList.add(0, bankBase);
        historyList.setAdapter(new HistoryBankAdapter(this, bankList));
    }


    /**
     * 获取历史银行卡
     *
     * @param bankBase
     */
    @Override
    public void getBankHistory(BankBaseBean.BankBase bankBase) {
        if(bankBase==null){
            return;
        }
        bankList.add(bankBase);
        historyList.setAdapter(new HistoryBankAdapter(this, bankList));
    }


    /**
     * 获取收款明细
     * @param list
     */
    @Override
    public void getCollMoneyList(List<CollMoneyBean.CollMoney> list) {
        listView.setAdapter(new MyBankAdapter(this,list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setClass(MoneyIssueActivity.class);
            }
        });
    }



    @OnClick(R.id.lin_back)
    public void onViewClicked() {
        finish();
    }
}
