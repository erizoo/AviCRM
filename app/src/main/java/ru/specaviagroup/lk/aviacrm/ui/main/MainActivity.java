package ru.specaviagroup.lk.aviacrm.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseFacility;
import ru.specaviagroup.lk.aviacrm.ui.adapters.FacilityAdapter;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.ui.login.LoginActivity;
import ru.specaviagroup.lk.aviacrm.ui.qr.QrCodeScannerActivity;

public class MainActivity extends BaseActivity implements MainMvpView, FacilityAdapter.Callback{

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    MainPresenter<MainMvpView> presenter;

    private FacilityAdapter facilityAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);

        presenter.getFacility();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        facilityAdapter = new FacilityAdapter();
        facilityAdapter.setCallback(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(facilityAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.main_activity;
    }

    @Override
    public void getData(List<ResponseFacility> responseFacilities) {
        facilityAdapter.setItems(responseFacilities);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void error() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openQrScanner(Integer objectId) {
        Intent intent = new Intent(this, QrCodeScannerActivity.class);
        intent.putExtra("OBJECT_ID", objectId);
        startActivity(intent);
    }
}
