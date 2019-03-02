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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;
import ru.specaviagroup.lk.aviacrm.R;
import ru.specaviagroup.lk.aviacrm.data.ResponseModel.ResponsePoint;
import ru.specaviagroup.lk.aviacrm.data.models.RequestAll;
import ru.specaviagroup.lk.aviacrm.data.models.RequestPreventiveActions;
import ru.specaviagroup.lk.aviacrm.data.models.RequestQuestPersonal;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasAlivePests;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasBrokenTrap;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasDis;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasDisableTrap;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasHolePest;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasRemoveTrap;
import ru.specaviagroup.lk.aviacrm.data.models.RequestWasTrashPests;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseHandBook;
import ru.specaviagroup.lk.aviacrm.data.models.ResponseSaveFlyActive;
import ru.specaviagroup.lk.aviacrm.data.request.RequestBirdsActive;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyActive;
import ru.specaviagroup.lk.aviacrm.data.request.RequestFlyNeedRep;
import ru.specaviagroup.lk.aviacrm.data.request.RequestGlutRepTrap;
import ru.specaviagroup.lk.aviacrm.ui.adapters.RequestBirdsAdapter;
import ru.specaviagroup.lk.aviacrm.ui.adapters.RequestBirdsCatching;
import ru.specaviagroup.lk.aviacrm.ui.base.BaseActivity;
import ru.specaviagroup.lk.aviacrm.utils.PopupActions;
import ru.specaviagroup.lk.aviacrm.utils.PopupAdditionalQuestions;
import ru.specaviagroup.lk.aviacrm.utils.PopupDetailInsect;
import ru.specaviagroup.lk.aviacrm.utils.PopupDisinsection;
import ru.specaviagroup.lk.aviacrm.utils.PopupFlyControlActive;
import ru.specaviagroup.lk.aviacrm.utils.PopupHandBook;
import ru.specaviagroup.lk.aviacrm.utils.PopupVscActive;

public class ProfileActivity extends BaseActivity implements ProfileMvpView, PopupDetailInsect.Callback, PopupHandBook.Callback,
        PopupVscActive.Callback, PopupFlyControlActive.CallbackPopupFlyControl, PopupActions.Callback, PopupAdditionalQuestions.Callback {

    @BindView(R.id.title_first)
    Button titleFirst;
    @BindView(R.id.first_layout)
    ConstraintLayout firstLayoutValue;
    @BindView(R.id.layout)
    ConstraintLayout layout;
    @BindView(R.id.street_layout)
    ConstraintLayout streetAreaLayout;
    @BindView(R.id.rodents_and_crawling_layout)
    ConstraintLayout rodentsAndCrawlingLayout;
    @BindView(R.id.title_editText_link_active)
    TextView valueFlyActive;
    @BindView(R.id.title_editText_link)
    TextView preparationValue;
    @BindView(R.id.comments_fly_active)
    TextView flyActiveComments;
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
    @BindView(R.id.plus_fly_control_catching)
    ImageView plusFlyControlCatching;
    @BindView(R.id.recycler_view_fly_control_active)
    RecyclerView recyclerViewFlyControlActive;
    @BindView(R.id.recycler_view_fly_control_catching)
    RecyclerView recyclerViewFlyControlCatching;

    @BindView(R.id.checkbox_rodents_and_crawling_catching_yes)
    CheckBox checkBoxRodentsAndCrawlingCatchingYes;
    @BindView(R.id.checkbox_rodents_and_crawling_catching_no)
    CheckBox checkBoxRodentsAndCrawlingCatchingNo;
    @BindView(R.id.checkbox_rodents_and_crawling_replacement_glue_yes)
    CheckBox checkBoxRodentsAndCrawlingReplacementGlueYes;
    @BindView(R.id.checkbox_rodents_and_crawling_replacement_glue_no)
    CheckBox checkBoxRodentsAndCrawlingReplacementGlueNo;

    @BindView(R.id.checkbox_preventive_actions_yes)
    CheckBox checkBoxPreventiveActionsYes;
    @BindView(R.id.checkbox_preventive_actions_no)
    CheckBox checkBoxPreventiveActionsNo;
    @BindView(R.id.preventive_actions_value)
    TextView preventiveActionsValue;

    @BindView(R.id.checkbox_clean_trap_yes)
    CheckBox checkBoxCleanTrapYes;
    @BindView(R.id.checkbox_clean_trap_no)
    CheckBox checkBoxCleanTrapNo;
    @BindView(R.id.checkbox_complaints_yes)
    CheckBox checkBoxComplaintsYes;
    @BindView(R.id.checkbox_complaints_no)
    CheckBox checkBoxComplaintsNo;
    @BindView(R.id.checkbox_broken_trap_yes)
    CheckBox checkBoxBrokenTrapYes;
    @BindView(R.id.checkbox_broken_trap_no)
    CheckBox checkBoxBrokenTrapNo;

    @BindView(R.id.checkbox_unavailable_trap_yes)
    CheckBox checkBoxUnavailableTrapYes;
    @BindView(R.id.checkbox_unavailable_trap_no)
    CheckBox checkBoxUnavailableTrapNo;
    @BindView(R.id.checkbox_dead_pests_trap_yes)
    CheckBox checkBoxDeadPestsTrapYes;
    @BindView(R.id.checkbox_dead_pests_trap_no)
    CheckBox checkBoxDeadPestsTrapNo;
    @BindView(R.id.checkbox_live_pests_trap_yes)
    CheckBox checkLivePestsTrapYes;
    @BindView(R.id.checkbox_live_pests_trap_no)
    CheckBox checkLivePestsTrapNo;
    @BindView(R.id.checkbox_life_activity_trap_yes)
    CheckBox checkBoxLifeActivityTrapYes;
    @BindView(R.id.checkbox_life_activity_trap_no)
    CheckBox checkBoxLifeActivityTrapNo;
    @BindView(R.id.checkbox_fresh_holes_trap_yes)
    CheckBox checkBoxFreshHolesTrapYes;
    @BindView(R.id.checkbox_fresh_holes_trap_no)
    CheckBox checkBoxFreshHolesTrapNo;
    @BindView(R.id.checkbox_disinsection_trap_yes)
    CheckBox checkBoxDisinsectionTrapYes;
    @BindView(R.id.checkbox_disinsection_trap_no)
    CheckBox checkBoxDisinsectionTrapNo;

    @BindView(R.id.dead_pests_value)
    TextView deadPestsValue;
    @BindView(R.id.dead_pests_comments)
    TextView deadPestsComments;
    @BindView(R.id.live_pests_value)
    TextView livePestsValue;
    @BindView(R.id.live_pests_comments)
    TextView livePestsComments;
    @BindView(R.id.life_activity_trap_value)
    TextView lifeActivityValue;
    @BindView(R.id.life_activity_comments)
    TextView lifeActivityComments;
    @BindView(R.id.fresh_holes_value)
    TextView freshHolesValue;
    @BindView(R.id.fresh_holes_comments)
    TextView freshHolesComments;
    @BindView(R.id.complaints_value)
    TextView complaintsValue;
    @BindView(R.id.complaints_comments)
    TextView complaintsComments;
    @BindView(R.id.disinsection_trap_value)
    TextView disinsectionValue;

    @BindView(R.id.area_relative)
    RelativeLayout areaRelative;
    @BindView(R.id.preparation_relative)
    RelativeLayout preparationRelative;
    @BindView(R.id.preparation_editText_link)
    TextView preparationValueDisinsaction;
    @BindView(R.id.area_editText_link)
    TextView areaValueDisinsaction;
    @BindView(R.id.disinsection_trap_comments)
    EditText disinsectionTrapComments;


    @Inject
    ProfilePresenter<ProfileMvpView> presenter;

    private Integer objectId;
    private String trapId;
    private boolean isStreetArea = false;
    private boolean isVscControlReplacementGlue = false;
    private boolean isVscControlReplacementFeramon = false;
    private boolean isVscControlActive = false;
    private RequestBirdsAdapter requestBirdsAdapter;
    private RequestBirdsCatching requestBirdsCatching;
    private boolean isFlyActive = false;
    private String type = "";

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

        requestBirdsCatching = new RequestBirdsCatching();
        LinearLayoutManager layoutManagerCatching = new LinearLayoutManager(this);
        layoutManagerCatching.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFlyControlCatching.setLayoutManager(layoutManagerCatching);
        recyclerViewFlyControlCatching.setAdapter(requestBirdsCatching);
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

    public void showPopupAdditionalQuestions(View contentView, List<ResponseHandBook> responseHandBooks, String type) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_handbook, null);
        PopupAdditionalQuestions popupWindow = new PopupAdditionalQuestions(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setCallback(this);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        popupWindow.setUp(contentView, responseHandBooks, type);
    }

    public void showPopupVscActive(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_vsc_active, null);
        PopupVscActive popupWindow = new PopupVscActive(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setCallback(this);
        popupWindow.setFocusable(true);
        popupWindow.setUp(contentView);
    }

    public void showPopupFlyControlActive(View contentView, List<ResponseHandBook> responseHandBooks, boolean b) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_fly_active, null);
        PopupFlyControlActive popupWindow = new PopupFlyControlActive(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView, responseHandBooks, b);
    }

    public void showPopupDisinsection(View contentView) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_disinsection, null);
        PopupDisinsection popupWindow = new PopupDisinsection(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setUp(contentView, ProfileActivity.this);
    }

    public void showPopupHandBook(View contentView, List<ResponseHandBook> responseHandBook) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_handbook, null);
        PopupHandBook popupWindow = new PopupHandBook(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
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
                isFlyActive = true;
                titleFirst.setVisibility(View.VISIBLE);
                firstLayoutValue.setVisibility(View.VISIBLE);
                checkBoxActiveNo.setChecked(true);
                checkBoxPreparationNo.setChecked(true);
            }
            if (items.equals("trappedPestPoint,glutRepTrap,problemBox")) {
                rodentsAndCrawlingLayout.setVisibility(View.VISIBLE);
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
        showPopupFlyControlActive(firstLayoutValue, responseHandBooks, true);
    }

    @Override
    public void getObjectsCatching(List<ResponseHandBook> responseHandBooks) {
        showPopupFlyControlActive(firstLayoutValue, responseHandBooks, false);
    }

    @Override
    public void getActions(List<ResponseHandBook> responseActions) {
        showPopupHandBookActions(layout, responseActions, type);
    }

    @Override
    public void getAllPets(List<ResponseHandBook> responseHandBooks) {
        showPopupAdditionalQuestions(layout, responseHandBooks, type);
    }

    @Override
    public void getPreparationForAdditiional(List<ResponseHandBook> responseHandBooks) {
        showPopupAdditionalQuestions(layout, responseHandBooks, type);
    }

    @Override
    public void getAreas(List<ResponseHandBook> responseHandBooks) {
        showPopupAdditionalQuestions(layout, responseHandBooks, type);
    }

    @Override
    public void getSavedAll(Response<ResponseSaveFlyActive> responseSaveFlyActiveResponse) {

    }

    private void showPopupHandBookActions(View contentView, List<ResponseHandBook> responseActions, String type) {
        @SuppressLint("InflateParams") View popupView = getLayoutInflater().inflate(R.layout.popup_handbook, null);
        PopupActions popupWindow = new PopupActions(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                contentView.getHeight());
        popupWindow.setCallback(this);
        popupWindow.setUp(contentView, responseActions, type);
    }

    @Override
    public void saveFlyActive(String requestFlyActive) {
        valueFlyActive.setText(requestFlyActive);
    }

    @Override
    public void abort() {
        checkBoxActiveNo.setChecked(true);
        checkBoxActiveYes.setChecked(false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void savePreparation(ResponseHandBook responseHandBook) {
        if (isStreetArea) {
            baitReplacementValue.setText(responseHandBook.getPoint() + "=" + responseHandBook.getId());
            isStreetArea = false;
        }
        if (isVscControlReplacementGlue) {
            vcsControlReplacementGlueValue.setText(responseHandBook.getPoint() + "=" + responseHandBook.getId());
            isVscControlReplacementGlue = false;
        }
        if (isVscControlReplacementFeramon) {
            vcsControlReplacementFeramonValue.setText(responseHandBook.getPoint() + "=" + responseHandBook.getId());
            isVscControlReplacementFeramon = false;
        }
        if (isVscControlActive) {
            vcsControlActiveValue.setText(responseHandBook.getPoint() + "=" + responseHandBook.getId());
            isVscControlActive = false;
        }

        try {
            preparationValue.setText(responseHandBook.getPoint() + "=" + responseHandBook.getId());
        } catch (NullPointerException e) {
            Snackbar.make(firstLayoutValue, "Выберете значение", Snackbar.LENGTH_LONG).show();
        }


    }

    @OnClick(R.id.plus_fly_control_active)
    public void clickPlusFlyControlActive(){
        presenter.getObjects(1);
    }

    @OnClick(R.id.checkbox_active_yes)
    public void clickCheckboxActiveYes() {
        showPopupDetailInsect(firstLayoutValue);
        if (checkBoxActiveNo.isChecked()) {
            checkBoxActiveNo.setChecked(false);
        } else {
            checkBoxActiveYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_active_no)
    public void clickCheckboxActiveNo() {
        valueFlyActive.setText("");
        if (checkBoxActiveYes.isChecked()) {
            checkBoxActiveYes.setChecked(false);
        } else {
            checkBoxActiveNo.setChecked(true);
        }

    }

    @OnClick(R.id.checkbox_preparation_yes)
    public void clickCheckboxPreparationYes() {
        presenter.getPreparation(5);
        if (checkBoxPreparationNo.isChecked()) {
            checkBoxPreparationNo.setChecked(false);
        } else {
            checkBoxPreparationYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_preparation_no)
    public void clickCheckboxPreparationNo() {
        preparationValue.setText("");
        if (checkBoxPreparationYes.isChecked()) {
            checkBoxPreparationYes.setChecked(false);
        } else {
            checkBoxPreparationNo.setChecked(true);
        }
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
        requestBirdsAdapter.clear();
        checkBoxFlyControlActiveYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_fly_control_catching_birds_yes)
    public void clickCheckboxFlyControlCatchingBirdsYes() {
        plusFlyControlCatching.setVisibility(View.VISIBLE);
        checkBoxFlyControlCatchingBirdsNo.setChecked(false);
    }

    @OnClick(R.id.plus_fly_control_catching)
    public void plusFlyControlCatchingClick() {
        presenter.getObjectsCatching(1);
    }

    @OnClick(R.id.checkbox_fly_control_catching_birds_no)
    public void clickCheckboxFlyControlCatchingBirdsNo() {
        plusFlyControlCatching.setVisibility(View.GONE);
        recyclerViewFlyControlCatching.setVisibility(View.GONE);
        checkBoxFlyControlCatchingBirdsYes.setChecked(false);
        requestBirdsCatching.clear();
    }

    @OnClick(R.id.checkbox_rodents_and_crawling_catching_yes)
    public void clickCheckboxRodentsAndCrawlingCatchingYes() {
        checkBoxRodentsAndCrawlingCatchingNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_rodents_and_crawling_catching_no)
    public void clickCheckboxRodentsAndCrawlingCatchingNo() {
        checkBoxRodentsAndCrawlingCatchingYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_rodents_and_crawling_replacement_glue_yes)
    public void clickCheckboxRodentsAndCrawlingReplacementGlueYes() {
        checkBoxRodentsAndCrawlingReplacementGlueNo.setChecked(false);
    }

    @OnClick(R.id.checkbox_rodents_and_crawling_replacement_glue_no)
    public void clickCheckboxRodentsAndCrawlingReplacementGlueNo() {
        checkBoxRodentsAndCrawlingReplacementGlueYes.setChecked(false);
    }

    @OnClick(R.id.checkbox_fresh_holes_trap_yes)
    public void clickCheckBoxFreshHolesTrapYes() {
        type = "FRESH_HOLES";
        presenter.getAllPets();
        if (checkBoxFreshHolesTrapNo.isChecked()) {
            checkBoxFreshHolesTrapNo.setChecked(false);
        } else {
            checkBoxFreshHolesTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_fresh_holes_trap_no)
    public void clickCheckBoxFreshHolesTrapNo() {
        freshHolesValue.setText("");
        if (checkBoxFreshHolesTrapYes.isChecked()) {
            checkBoxFreshHolesTrapYes.setChecked(false);
        } else {
            checkBoxFreshHolesTrapNo.setChecked(true);
        }
    }


    @OnClick(R.id.checkbox_clean_trap_yes)
    public void clickCheckBoxCleanTrapYes() {
        if (checkBoxCleanTrapNo.isChecked()) {
            checkBoxCleanTrapNo.setChecked(false);
        } else {
            checkBoxCleanTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_clean_trap_no)
    public void clickCheckBoxCleanTrapNo() {
        if (checkBoxCleanTrapYes.isChecked()) {
            checkBoxCleanTrapYes.setChecked(false);
        } else {
            checkBoxCleanTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_complaints_yes)
    public void checkBoxComplaintsYes() {
        type = "COMPLAINTS";
        presenter.getAllPets();
        if (checkBoxComplaintsNo.isChecked()) {
            checkBoxComplaintsNo.setChecked(false);
        } else {
            checkBoxComplaintsYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_complaints_no)
    public void checkBoxComplaintsNo() {
        complaintsValue.setText("");
        complaintsComments.setText("");
        if (checkBoxComplaintsYes.isChecked()) {
            checkBoxComplaintsYes.setChecked(false);
        } else {
            checkBoxComplaintsNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_broken_trap_yes)
    public void clickCheckBoxBrokenTrapYes() {
        if (checkBoxBrokenTrapNo.isChecked()) {
            checkBoxBrokenTrapNo.setChecked(false);
        } else {
            checkBoxBrokenTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_broken_trap_no)
    public void clickCheckBoxBrokenTrapNo() {
        if (checkBoxBrokenTrapYes.isChecked()) {
            checkBoxBrokenTrapYes.setChecked(false);
        } else {
            checkBoxBrokenTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_unavailable_trap_yes)
    public void clickCheckBoxUnavailableTrapYes() {
        if (checkBoxUnavailableTrapNo.isChecked()) {
            checkBoxUnavailableTrapNo.setChecked(false);
        } else {
            checkBoxUnavailableTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_unavailable_trap_no)
    public void clickCheckBoxUnavailableTrapNo() {
        if (checkBoxUnavailableTrapYes.isChecked()) {
            checkBoxUnavailableTrapYes.setChecked(false);
        } else {
            checkBoxUnavailableTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_dead_pests_trap_yes)
    public void clickCheckDeadPestsTrapYes() {
        type = "DEAD_PESTS";
        presenter.getAllPets();
        if (checkBoxDeadPestsTrapNo.isChecked()) {
            checkBoxDeadPestsTrapNo.setChecked(false);
        } else {
            checkBoxDeadPestsTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_dead_pests_trap_no)
    public void clickCheckDeadPestsTrapNo() {
        deadPestsValue.setText("");
        if (checkBoxDeadPestsTrapYes.isChecked()) {
            checkBoxDeadPestsTrapYes.setChecked(false);
        } else {
            checkBoxDeadPestsTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_live_pests_trap_yes)
    public void clickCheckLivePestsTrapYes() {
        type = "LIVE_PESTS";
        presenter.getAllPets();
        if (checkLivePestsTrapNo.isChecked()) {
            checkLivePestsTrapNo.setChecked(false);
        } else {
            checkLivePestsTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_live_pests_trap_no)
    public void clickCheckLivePestsTrapNo() {
        livePestsValue.setText("");
        if (checkLivePestsTrapYes.isChecked()) {
            checkLivePestsTrapYes.setChecked(false);
        } else {
            checkLivePestsTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_life_activity_trap_yes)
    public void clickCheckBoxLifeActivityTrapYes() {
        type = "LIFE_PESTS";
        presenter.getAllPets();
        if (checkBoxLifeActivityTrapNo.isChecked()) {
            checkBoxLifeActivityTrapNo.setChecked(false);
        } else {
            checkBoxLifeActivityTrapYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_life_activity_trap_no)
    public void clickCheckBoxLifeActivityTrapNo() {
        lifeActivityValue.setText("");
        if (checkBoxLifeActivityTrapYes.isChecked()) {
            checkBoxLifeActivityTrapYes.setChecked(false);
        } else {
            checkBoxLifeActivityTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_preventive_actions_yes)
    public void clickCheckBoxPreventiveActionsYes() {
        type = "PREVENTIVE_ACTIONS";
        presenter.getActions();
        if (checkBoxPreventiveActionsNo.isChecked()) {
            checkBoxPreventiveActionsNo.setChecked(false);
        } else {
            checkBoxPreventiveActionsYes.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_preventive_actions_no)
    public void clickCheckBoxreventiveActionsNo() {
        preventiveActionsValue.setText("");
        if (checkBoxPreventiveActionsYes.isChecked()) {
            checkBoxPreventiveActionsYes.setChecked(false);
        } else {
            checkBoxPreventiveActionsNo.setChecked(true);
        }
    }

    @OnClick(R.id.checkbox_disinsection_trap_yes)
    public void clickCheckBoxDisinsectionTrapYes() {
        areaRelative.setVisibility(View.VISIBLE);
        preparationRelative.setVisibility(View.VISIBLE);
        disinsectionTrapComments.setVisibility(View.VISIBLE);
        if (checkBoxDisinsectionTrapNo.isChecked()) {
            checkBoxDisinsectionTrapNo.setChecked(false);
        } else {
            checkBoxDisinsectionTrapYes.setChecked(true);
        }
    }


    @OnClick(R.id.checkbox_disinsection_trap_no)
    public void clickCheckBoxDisinsectionTrapNo() {
        areaRelative.setVisibility(View.GONE);
        preparationRelative.setVisibility(View.GONE);
        disinsectionTrapComments.setVisibility(View.GONE);
        if (checkBoxDisinsectionTrapYes.isChecked()) {
            checkBoxDisinsectionTrapYes.setChecked(false);
        } else {
            checkBoxDisinsectionTrapNo.setChecked(true);
        }
    }

    @OnClick(R.id.area_relative)
    public void areaRelativeHandBook() {
        type = "DISINSECTION_AREA";
        presenter.getAreas(1);
    }

    @OnClick(R.id.preparation_relative)
    public void preparationRelativeHandBook() {
        type = "DISINSECTION";
        presenter.getPreparationForAdditiional(1);
    }

    @Override
    public void saveVscActive(String requestVscActive) {
        vcsControlActiveValue.setText(requestVscActive);
    }

    @Override
    public void saveBirdsActive(RequestBirdsActive requestBirdsActive, boolean isActive) {
        if (isActive) {
            requestBirdsAdapter.setItems(requestBirdsActive);
        } else {
            requestBirdsCatching.setItems(requestBirdsActive);
        }
        recyclerViewFlyControlCatching.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.save_all)
    public void saveAll() {
        RequestAll requestAll = new RequestAll();
        if (isFlyActive) {
            if (checkBoxActiveYes.isChecked()) {
                RequestFlyActive requestFlyActive = new RequestFlyActive();
                requestFlyActive.setId("1");
                requestFlyActive.setAmount(valueFlyActive.getText().toString());
                requestAll.setRequestFlyActive(requestFlyActive);
            }
            if (checkBoxPreparationYes.isChecked()) {
                RequestGlutRepTrap requestGlutRepTrap = new RequestGlutRepTrap();
                requestGlutRepTrap.setTraps("1");
                String[] strings = preparationValue.getText().toString().split("=");
                requestGlutRepTrap.setPesticideId(strings[1]);
                requestAll.setRequestGlutRepTrap(requestGlutRepTrap);
            }
            if (!flyActiveComments.getText().toString().equals("")) {
                RequestFlyNeedRep requestFlyNeedRep = new RequestFlyNeedRep();
                requestFlyNeedRep.setTraps("1");
                requestFlyNeedRep.setComment(flyActiveComments.getText().toString());
                requestAll.setRequestFlyNeedRep(requestFlyNeedRep);
            }
        }
        if (checkBoxPreventiveActionsYes.isChecked()) {
            RequestPreventiveActions requestPreventiveActions = new RequestPreventiveActions();
            String result = preventiveActionsValue.getText().toString();
            if (result.endsWith(",")) {
                requestPreventiveActions.setId(result.substring(0, result.length() - 1));
            } else {
                requestPreventiveActions.setId(result);
            }
            requestAll.setRequestPreventiveAction(requestPreventiveActions);
        }
        if (checkBoxCleanTrapYes.isChecked()) {
            RequestWasRemoveTrap requestWasRemoveTrap = new RequestWasRemoveTrap();
            requestWasRemoveTrap.setTraps("1");
            requestAll.setRequestWasRemoveTrap(requestWasRemoveTrap);
        }
        if (checkBoxBrokenTrapYes.isChecked()) {
            RequestWasBrokenTrap requestWasBrokenTrap = new RequestWasBrokenTrap();
            requestWasBrokenTrap.setTraps("1");
            requestAll.setRequestWasBrokenTrap(requestWasBrokenTrap);
        }
        if (checkBoxUnavailableTrapYes.isChecked()) {
            RequestWasDisableTrap requestWasDisableTrap = new RequestWasDisableTrap();
            requestWasDisableTrap.setTraps("1");
            requestAll.setRequestWasDisableTrap(requestWasDisableTrap);
        }
        if (checkBoxComplaintsYes.isChecked()) {
            RequestQuestPersonal requestQuestPersonal = new RequestQuestPersonal();
            requestQuestPersonal.setId("1");
            requestQuestPersonal.setPestId(complaintsValue.getText().toString());
            requestQuestPersonal.setComment(complaintsComments.getText().toString());
            requestAll.setRequestQuestPersonal(requestQuestPersonal);
        }
//        if (checkBoxDeadPestsTrapYes.isChecked()) {
//            RequestQuestPersonal requestQuestPersonal = new RequestQuestPersonal();
//            requestQuestPersonal.setId(trapId);
//            requestQuestPersonal.setPestId(complaintsValue.getText().toString());
//            requestQuestPersonal.setComment(complaintsComments.getText().toString());
//        }
        if (checkLivePestsTrapYes.isChecked()) {
            RequestWasAlivePests requestWasAlivePests = new RequestWasAlivePests();
            requestWasAlivePests.setId("1");
            requestWasAlivePests.setPestId(livePestsValue.getText().toString());
            requestWasAlivePests.setComment(livePestsComments.getText().toString());
            requestAll.setRequestWasAlivePests(requestWasAlivePests);
        }
        if (checkBoxLifeActivityTrapYes.isChecked()) {
            RequestWasTrashPests requestWasTrashPests = new RequestWasTrashPests();
            requestWasTrashPests.setId("1");
            requestWasTrashPests.setPestId(lifeActivityValue.getText().toString());
            requestWasTrashPests.setComment(lifeActivityComments.getText().toString());
            requestAll.setRequestWasTrashPests(requestWasTrashPests);
        }
        if (checkBoxFreshHolesTrapYes.isChecked()) {
            RequestWasHolePest requestWasHolePest = new RequestWasHolePest();
            requestWasHolePest.setId("1");
            requestWasHolePest.setPestId(freshHolesValue.getText().toString());
            requestWasHolePest.setComment(freshHolesComments.getText().toString());
            requestAll.setRequestWasHolePest(requestWasHolePest);
        }
        if (checkBoxDisinsectionTrapYes.isChecked()) {
            RequestWasDis requestWasDis = new RequestWasDis();
            requestWasDis.setBoxId(areaValueDisinsaction.getText().toString());
            requestWasDis.setPesticideId(preparationValueDisinsaction.getText().toString());
            requestWasDis.setCount(disinsectionTrapComments.getText().toString());
            requestAll.setRequestWasDis(requestWasDis);
        }
        presenter.saveAll(requestAll, 1);
        System.out.println(requestAll);
    }

    @Override
    public void saveActions(List<ResponseHandBook> responseHandBook) {
        StringBuilder sb = new StringBuilder();
        for (ResponseHandBook items : responseHandBook) {
            sb.append(items.getId().toString()).append(",");
        }
        preventiveActionsValue.setText(sb.toString());
    }

    @Override
    public void saveAdditionalQuestions(List<ResponseHandBook> responseHandBooks, String type, String comments) {
        StringBuilder sb = new StringBuilder();
        if (type.equals("DEAD_PESTS")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            deadPestsValue.setText(sb.toString());
            deadPestsComments.setText(comments);
        } else if (type.equals("LIVE_PESTS")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            livePestsValue.setText(sb.toString());
            livePestsComments.setText(comments);
        } else if (type.equals("LIFE_PESTS")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            lifeActivityValue.setText(sb.toString());
            lifeActivityComments.setText(comments);
        } else if (type.equals("FRESH_HOLES")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            freshHolesValue.setText(sb.toString());
            freshHolesComments.setText(comments);
        } else if (type.equals("COMPLAINTS")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            complaintsValue.setText(sb.toString());
            complaintsComments.setText(comments);
        } else if (type.equals("DISINSECTION")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            preparationValueDisinsaction.setText(sb.toString());
        } else if (type.equals("DISINSECTION_AREA")) {
            for (ResponseHandBook items : responseHandBooks) {
                sb.append(items.getId()).append(",");
            }
            areaValueDisinsaction.setText(sb.toString());
        }
    }
}
