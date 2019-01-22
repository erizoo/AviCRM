package ru.specaviagroup.lk.aviacrm.ui.trap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.ui.adapters.CheckAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.FacilityAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.PesticidesAdapter;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.ui.profile.ProfileActivity;
import ru.specaviagroup.lk.aviacrm.ui.qr.QrCodeScannerActivity;

public class TrapActivity extends BaseActivity implements TrapMvpView{

    @BindView(R.id.point_value)
    TextView pointInfo;
    @BindView(R.id.area_value)
    TextView areaInfo;
    @BindView(R.id.check_rv)
    RecyclerView recyclerViewCheck;
    @BindView(R.id.change_rv)
    RecyclerView recyclerViewChange;
    @BindView(R.id.progress_layout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    TrapPresenter<TrapMvpView> presenter;

    private CheckAdapter checkAdapter;
    private PesticidesAdapter pesticidesAdapter;
    private String trapId;
    private Integer objectId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
        trapId = Objects.requireNonNull(getIntent().getExtras()).getString("TRAP_ID", "");
        objectId = Objects.requireNonNull(getIntent().getExtras()).getInt("OBJECT_ID");
        System.out.println();
        if (!trapId.equals("")){
            presenter.getTrapInfo(trapId);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager layoutManagerTwo = new LinearLayoutManager(getContext());
        layoutManagerTwo.setOrientation(LinearLayoutManager.VERTICAL);

        checkAdapter = new CheckAdapter();
        recyclerViewCheck.setLayoutManager(layoutManager);
        recyclerViewCheck.setAdapter(checkAdapter);

        pesticidesAdapter = new PesticidesAdapter();
        recyclerViewChange.setLayoutManager(layoutManagerTwo);
        recyclerViewChange.setAdapter(pesticidesAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.trap_activity;
    }

    @OnClick(R.id.no_button)
    public void clickNoButton(){
        Intent intent = new Intent(this, QrCodeScannerActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.yes_button)
    public void clickYesButton(){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("OBJECT_ID", objectId);
        startActivity(intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getData(ResponseTrap responseTrap) {
        checkAdapter.setItems(responseTrap.getResponseRevizor());
        try {
            pesticidesAdapter.setItems(responseTrap.getPesticides());
        } catch (Exception e){ }
        String name;
        try {
            DecimalFormat format = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
            format.setMaximumFractionDigits(2);
            name = format.format(responseTrap.getName().get(0).getName());
        } catch (Exception e){
            name = "-";
        }
        pointInfo.setText(responseTrap.getResponseBox().get(0).getArticleName() + " " + name
                + " " + responseTrap.getResponseTypeTrap().get(0).getName());
        areaInfo.setText(responseTrap.getResponseBox().get(0).getName());
        progressBar.setVisibility(View.GONE);
        constraintLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void error(Throwable throwable) {
        pointInfo.setText("-");
        areaInfo.setText("-");
    }
}
