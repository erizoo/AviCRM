package ru.specaviagroup.lk.aviacrm.ui.trap;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Objects;

import javax.inject.Inject;

import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseTrap;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;

public class TrapActivity extends BaseActivity implements TrapMvpView{

    @Inject
    TrapPresenter<TrapMvpView> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
        String id = Objects.requireNonNull(getIntent().getExtras()).getString("TRAP_ID", "");
        System.out.println();
        if (!id.equals("")){
            presenter.getTrapInfo(id);
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.trap_activity;
    }

    @Override
    public void getData(ResponseTrap responseTrap) {
        System.out.println();
    }

    @Override
    public void error(Throwable throwable) {
        System.out.println();
    }
}
