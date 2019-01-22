package ru.specaviagroup.lk.aviacrm.ui.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.utils.PopupDetailInsect;

public class ProfileActivity extends BaseActivity implements ProfileMvpView {

    @BindView(R.id.layout_detail_insects)
    RelativeLayout layoutDetailInsects;
    @BindView(R.id.first_layout)
    ConstraintLayout firstLayout;
    @BindView(R.id.second_layout)
    ConstraintLayout secondLayout;
    @BindView(R.id.third_layout)
    ConstraintLayout thirdLayout;
    @BindView(R.id.layout_fourth)
    ConstraintLayout fourthLayout;
    @BindView(R.id.layout_five)
    ConstraintLayout fiveLayout;

    @Inject
    ProfilePresenter<ProfileMvpView> presenter;

    private Integer objectId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);

//        objectId = Objects.requireNonNull(getIntent().getExtras()).getInt("OBJECT_ID");
        presenter.getView(1);
    }

    @Override
    protected int getContentView() {
        return R.layout.profile_point_activity;
    }

    @OnCheckedChanged({R.id.yes_pest_activity, R.id.no_pest_activity, R.id.yes_replacement_glue, R.id.no_replacement_glue,
            R.id.yes_needs_repair, R.id.no_needs_repair, R.id.yes_captured_pests, R.id.no_captured_pests, R.id.yes_replacement,
            R.id.no_replacement, R.id.yes_product_damage, R.id.no_product_damage, R.id.yes_pest_active,
            R.id.no_pest_active, R.id.yes_replacement_glue_have, R.id.no_replacement_glue_have, R.id.yes_replacement_feramon, R.id.no_replacement_feramon})
    public void onRadioButtonCheckChanged(RadioButton button, boolean checked) {
        if (checked) {
            switch (button.getId()) {
                case R.id.yes_pest_activity:
                    button = findViewById(R.id.no_pest_activity);
                    button.setChecked(false);
                    showPopupDetailInsect(layoutDetailInsects);
                    break;
                case R.id.no_pest_activity:
                    button = findViewById(R.id.yes_pest_activity);
                    button.setChecked(false);
                    break;
                case R.id.yes_replacement_glue:
                    button = findViewById(R.id.no_replacement_glue);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_replacement_glue:
                    button = findViewById(R.id.yes_replacement_glue);
                    button.setChecked(false);
                    break;
                case R.id.yes_needs_repair:
                    button = findViewById(R.id.no_needs_repair);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_needs_repair:
                    button = findViewById(R.id.yes_needs_repair);
                    button.setChecked(false);
                    break;
                case R.id.yes_captured_pests:
                    button = findViewById(R.id.no_captured_pests);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_captured_pests:
                    button = findViewById(R.id.yes_captured_pests);
                    button.setChecked(false);
                    break;
                case R.id.yes_replacement:
                    button = findViewById(R.id.no_replacement);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_replacement:
                    button = findViewById(R.id.yes_replacement);
                    button.setChecked(false);
                    break;
                case R.id.yes_product_damage:
                    button = findViewById(R.id.no_product_damage);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_product_damage:
                    button = findViewById(R.id.yes_product_damage);
                    button.setChecked(false);
                    break;
                case R.id.yes_pest_active:
                    button = findViewById(R.id.no_pest_active);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_pest_active:
                    button = findViewById(R.id.yes_pest_active);
                    button.setChecked(false);
                    break;
                case R.id.yes_replacement_glue_have:
                    button = findViewById(R.id.no_replacement_glue_have);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_replacement_glue_have:
                    button = findViewById(R.id.yes_replacement_glue_have);
                    button.setChecked(false);
                    break;
                case R.id.yes_replacement_feramon:
                    button = findViewById(R.id.no_replacement_feramon);
                    button.setChecked(false);
                    showPopupTwoFields(layoutDetailInsects);
                    break;
                case R.id.no_replacement_feramon:
                    button = findViewById(R.id.yes_replacement_feramon);
                    button.setChecked(false);
                    break;
            }
        }
    }

    public void showPopupDetailInsect(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_detail_insects, null);
        PopupDetailInsect popupWindow = new PopupDetailInsect(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        final Spinner spinner = popupView.findViewById(R.id.spinner);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.animals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        popupWindow.setUp(contentView);
    }

    public void showPopupTwoFields(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_two_fields, null);
        PopupDetailInsect popupWindow = new PopupDetailInsect(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        final Spinner spinnerDrugs = popupView.findViewById(R.id.spinner_drugs);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.animals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDrugs.setAdapter(adapter);
        final Spinner spinnerPoints = popupView.findViewById(R.id.spinner_points);
        ArrayAdapter<?> adapterPoint =
                ArrayAdapter.createFromResource(this, R.array.animals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPoints.setAdapter(adapterPoint);
        popupWindow.setUp(contentView);
    }

    @Override
    public void getData(List<String> responseView) {
        for (String items : responseView) {
            if (items.equals("flyActive,glutRepTrap,flyNeedRep")) {
                firstLayout.setVisibility(View.VISIBLE);
            }
            if (items.equals("trappedPestPoint,glutRepTrap,problemBox")) {
                secondLayout.setVisibility(View.VISIBLE);
            }
            if (items.equals("flyControlActive,flyControlTrapp")) {
                thirdLayout.setVisibility(View.VISIBLE);
            }
            if (items.equals("vxActive,vxGluReload,vxFerReload")) {
                fourthLayout.setVisibility(View.VISIBLE);
            }
            if (items.equals("havePog,beReaload")) {
                fiveLayout.setVisibility(View.VISIBLE);
            }
        }
        System.out.println();
    }

    @Override
    public void error(Throwable throwable) {
        System.out.println();
    }
}
