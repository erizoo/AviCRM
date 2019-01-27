package ru.specaviagroup.lk.aviacrm.ui.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.request.RequestBirdsActive;
import ru.specaviagroup.lk.aviacrm.ui.adapters.HandBookAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.RequestBirdsAdapter;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.utils.PopupDetailInsect;
import ru.specaviagroup.lk.aviacrm.utils.PopupFlyControlActive;
import ru.specaviagroup.lk.aviacrm.utils.PopupHandBook;
import ru.specaviagroup.lk.aviacrm.utils.PopupVscActive;

public class ProfileActivity extends BaseActivity implements ProfileMvpView, PopupDetailInsect.Callback, PopupHandBook.Callback,
        PopupVscActive.Callback, PopupFlyControlActive.CallbackPopupFlyControl {

    @BindView(R.id.title_first)
    Button titleFirst;
    @BindView(R.id.first_layout_value)
    ConstraintLayout firstLayoutValue;
    @BindView(R.id.street_layout)
    ConstraintLayout streetAreaLayout;
    @BindView(R.id.title_editText_link_active)
    TextView valueFlyActive;
    @BindView(R.id.title_editText_link)
    TextView preparationValue;
    @BindView(R.id.value_bait_replacement)
    TextView baitReplacementValue;
    @BindView(R.id.value_vcs_control_replacement_glue)
    TextView vcsControlReplacementGlueValue;
    @BindView(R.id.value_vcs_control_replacement_feramon)
    TextView vcsControlReplacementFeramonValue;
    @BindView(R.id.vcs_control_active_value)
    TextView vcsControlActiveValue;
    @BindView(R.id.checkbox_active_yes)
    CheckBox checkBoxActiveYes;
    @BindView(R.id.checkbox_active_no)
    CheckBox checkBoxActiveNo;
    @BindView(R.id.checkbox_preparation_yes)
    CheckBox checkBoxPreparationYes;
    @BindView(R.id.checkbox_preparation_no)
    CheckBox checkBoxPreparationNo;
    @BindView(R.id.checkbox_bites_yes)
    CheckBox checkBoxBitesYes;
    @BindView(R.id.checkbox_bites_no)
    CheckBox checkBoxBitesNo;
    @BindView(R.id.checkbox_bait_replacement_yes)
    CheckBox checkBoxBaitReplacementYes;
    @BindView(R.id.checkbox_bait_replacement_no)
    CheckBox checkBoxBaitReplacementNo;

    @BindView(R.id.checkbox_vcs_control_active_yes)
    CheckBox checkBoxVcsControlActiveYes;
    @BindView(R.id.checkbox_vcs_control_active_no)
    CheckBox checkBoxVcsControlActiveNo;
    @BindView(R.id.checkbox_vcs_control_replacement_glue_yes)
    CheckBox checkBoxVcsControlReplacementGlueYes;
    @BindView(R.id.checkbox_vcs_control_replacement_glue_no)
    CheckBox checkBoxVcsControlReplacementGlueNo;
    @BindView(R.id.checkbox_vcs_control_replacement_feramon_yes)
    CheckBox checkBoxVcsControlReplacementFeramonYes;
    @BindView(R.id.checkbox_vcs_control_replacement_feramon_no)
    CheckBox checkBoxVcsControlReplacementFeramonNo;

    @BindView(R.id.checkbox_fly_control_active_yes)
    CheckBox checkBoxFlyControlActiveYes;
    @BindView(R.id.checkbox_fly_control_active_no)
    CheckBox checkBoxFlyControlActiveNo;
    @BindView(R.id.checkbox_fly_control_catching_birds_yes)
    CheckBox checkBoxFlyControlCatchingBirdsYes;
    @BindView(R.id.checkbox_fly_control_catching_birds_no)
    CheckBox checkBoxFlyControlCatchingBirdsNo;

    @BindView(R.id.plus_fly_control_active)
    ImageView plusFlyControlActive;
    @BindView(R.id.recycler_view_fly_control_active)
    RecyclerView recyclerViewFlyControlActive;

    @Inject
    ProfilePresenter<ProfileMvpView> presenter;

    private Integer objectId;
    private boolean isStreetArea = false;
    private boolean isVscControlReplacementGlue = false;
    private boolean isVscControlReplacementFeramon = false;
    private boolean isVscControlActive = false;
    private RequestBirdsAdapter requestBirdsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenComponent().inject(this);
        presenter.onAttach(this);
//        objectId = Objects.requireNonNull(getIntent().getExtras()).getInt("OBJECT_ID");
        presenter.getView(1);
        requestBirdsAdapter = new RequestBirdsAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFlyControlActive.setLayoutManager(layoutManager);
        recyclerViewFlyControlActive.setAdapter(requestBirdsAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.profile_point_activity;
    }

    public void showPopupDetailInsect(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_detail_insects, null);
        PopupDetailInsect popupWindow = new PopupDetailInsect(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView);
    }

    public void showPopupVscActive(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_vsc_active, null);
        PopupVscActive popupWindow = new PopupVscActive(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView);
    }

    public void showPopupFlyControlActive(View contentView, List<ResponseHandBook> responseHandBooks) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_fly_active, null);
        PopupFlyControlActive popupWindow = new PopupFlyControlActive(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView, responseHandBooks);
    }

    public void showPopupHandBook(View contentView, List<ResponseHandBook> responseHandBook) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_handbook, null);
        PopupHandBook popupWindow = new PopupHandBook(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView, responseHandBook);
    }

    @OnClick(R.id.title_first)
    public void showFirstLayout() {
        if (firstLayoutValue.getVisibility() == View.VISIBLE) {
            firstLayoutValue.setVisibility(View.GONE);
        } else {
            firstLayoutValue.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getData(List<String> responseView) {
        for (String items : responseView) {
            if (items.equals("flyActive,glutRepTrap,flyNeedRep")) {
                titleFirst.setVisibility(View.VISIBLE);
                firstLayoutValue.setVisibility(View.VISIBLE);
            }
            if (items.equals("havePog,beReaload")) {
                streetAreaLayout.setVisibility(View.VISIBLE);
            }
        }
        System.out.println();
    }


    @Override
    public void error(Throwable throwable) {
        System.out.println();
    }

    @Override
    public void getPoint(List<ResponsePoint> responsePoint) {
        showPopupDetailInsect(firstLayoutValue);
    }

    @Override
    public void saveFlyActive(boolean responseSaveFlyActiveResponse) {
        System.out.println();
    }

    @Override
    public void errorSave() {
        Snackbar.make(firstLayoutValue, "Ошибка сохранения", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void getPreparation(List<ResponseHandBook> responseHandBook) {
        showPopupHandBook(firstLayoutValue, responseHandBook);

    }

    @Override
    public void getObjects(List<ResponseHandBook> responseHandBooks) {
        showPopupFlyControlActive(firstLayoutValue, responseHandBooks);
    }

    @Override
    public void saveFlyActive(String requestFlyActive) {
        valueFlyActive.setText(requestFlyActive);
    }

    @Override
    public void savePreparation(ResponseHandBook responseHandBook) {
        if (isStreetArea) {
            baitReplacementValue.setText(responseHandBook.getPoint());
            isStreetArea = false;
        }
        if (isVscControlReplacementGlue) {
            vcsControlReplacementGlueValue.setText(responseHandBook.getPoint());
            isVscControlReplacementGlue = false;
        }
        if (isVscControlReplacementFeramon) {
            vcsControlReplacementFeramonValue.setText(responseHandBook.getPoint());
            isVscControlReplacementFeramon = false;
        }
        if (isVscControlActive) {
            vcsControlActiveValue.setText(responseHandBook.getPoint());
            isVscControlActive = false;
        }

        preparationValue.setText(responseHandBook.getPoint());

    }

    @OnClick(R.id.plus_fly_control_active)
    public void clickPlusFlyControlActive(){
        presenter.getObjects(1);
    }

    @OnClick(R.id.checkbox_active_yes)
    public void clickCheckboxActiveYes() {
        showPopupDetailInsect(firstLayoutValue);
        checkBoxActiveNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_active_no)
    public void clickCheckboxActiveNo() {
        valueFlyActive.setText("");
        checkBoxActiveYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_preparation_yes)
    public void clickCheckboxPreparationYes() {
        presenter.getPreparation(5);
        checkBoxPreparationNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_preparation_no)
    public void clickCheckboxPreparationNo() {
        preparationValue.setText("");
        checkBoxPreparationYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_bites_yes)
    public void clickCheckboxBitesYes() {
        checkBoxBitesNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_bites_no)
    public void clickCheckboxBitesNo() {
        checkBoxBitesYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_bait_replacement_yes)
    public void clickCheckboxBaitReplacementYes() {
        isStreetArea = true;
        presenter.getPreparation(5);
        checkBoxBaitReplacementNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_bait_replacement_no)
    public void clickCheckboxBaitReplacementNo() {
        baitReplacementValue.setText("");
        checkBoxBaitReplacementYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_vcs_control_active_yes)
    public void clickCheckboxVcsControlActiveYes() {
        isVscControlActive = true;
        showPopupVscActive(firstLayoutValue);
        checkBoxVcsControlActiveNo.setChecked(false);
        isVscControlActive = false;
    }

    @OnClick(R.id.checkbox_vcs_control_active_no)
    public void clickCheckboxVcsControlActiveNo() {
        vcsControlActiveValue.setText("");
        checkBoxVcsControlActiveYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_vcs_control_replacement_glue_yes)
    public void clickCheckboxVcsControlReplacementGlueYes() {
        isVscControlReplacementGlue = true;
        presenter.getPreparation(5);
        checkBoxVcsControlReplacementGlueNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_vcs_control_replacement_glue_no)
    public void clickCheckboxVcsControlReplacementGlueNo() {
        vcsControlReplacementGlueValue.setText("");
        checkBoxVcsControlReplacementGlueYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_vcs_control_replacement_feramon_yes)
    public void clickCheckboxVcsControlReplacementFeramonYes() {
        isVscControlReplacementFeramon = true;
        presenter.getPreparation(5);
        checkBoxVcsControlReplacementFeramonNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_vcs_control_replacement_feramon_no)
    public void clickCheckboxVcsControlReplacementFeramonNo() {
        vcsControlReplacementFeramonValue.setText("");
        checkBoxVcsControlReplacementFeramonYes.setChecked(false);
    }


    @OnClick(R.id.checkbox_fly_control_active_yes)
    public void clickCheckboxFlyControlActiveYes() {
        plusFlyControlActive.setVisibility(View.VISIBLE);
        recyclerViewFlyControlActive.setVisibility(View.VISIBLE);
        checkBoxFlyControlActiveNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_fly_control_active_no)
    public void clickCheckboxFlyControlActiveNo() {
        plusFlyControlActive.setVisibility(View.GONE);
        recyclerViewFlyControlActive.setVisibility(View.GONE);
        checkBoxFlyControlActiveYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_fly_control_catching_birds_yes)
    public void clickCheckboxFlyControlCatchingBirdsYes() {
        checkBoxFlyControlCatchingBirdsNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_fly_control_catching_birds_no)
    public void clickCheckboxFlyControlCatchingBirdsNo() {
        checkBoxFlyControlCatchingBirdsYes.setChecked(false);
    }

    @Override
    public void saveVscActive(String requestVscActive) {
        vcsControlActiveValue.setText(requestVscActive);
    }

    @Override
    public void saveBirdsActive(RequestBirdsActive requestBirdsActive) {
        requestBirdsAdapter.setItems(requestBirdsActive);
    }
}
