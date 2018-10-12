package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
import com.ibis.ibisecp2.model.Sluch;
import com.ibis.ibisecp2.model.SvedMu;
import com.ibis.ibisecp2.model.UslList;
import com.ibis.ibisecp2.presenters.ServiceRenderedPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by danila on 08.08.16.
 */
public class ServiceRenderedPresenterImpl extends ServiceRenderedPresenter {

    private ServiceRenderedLoaderHelper loaderHelper;
    private SharedPreferencesUtils preferencesUtils;
    private DialogsHelper dialogsHelper;
    private List<Sluch> headerList = new ArrayList<>();
    private HashMap<Sluch, List<UslList>> listDataChild = new HashMap<>();

    @Inject
    public ServiceRenderedPresenterImpl(ServiceRenderedLoaderHelper loaderHelper,
                                        SharedPreferencesUtils preferencesUtils,
                                        DialogsHelper dialogsHelper) {
        this.loaderHelper = loaderHelper;
        this.preferencesUtils = preferencesUtils;
        this.dialogsHelper = dialogsHelper;
    }

    @Override
    public void getServiceRendered(String fromDate, String toDate) {
        if (subscription != null) subscription.unsubscribe();
        subscription =
                loaderHelper.getSvedMu(fromDate, toDate)
                        .subscribe(new Observer<SvedMu>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                if (isViewAttached()) {
                                    dialogsHelper.alertDialogError(e);
                                    view.showError();
                                }
                            }

                            @Override
                            public void onNext(SvedMu response) {
                                if (isViewAttached()) {
                                    onSvedMuSuccess(response);
                                }
                            }
                        });

       /* Gson gson = new Gson();
        SvedMu svedMu = gson.fromJson("{\"Items\":[{\"DateBgn\":\"15.07.2015 00:00:00\",\"DateEnd\":\"15.07.2015 00:00:00\",\"LpuName\":\"БУ \\\"ХАНТЫ-МАНСИЙСКАЯ КЛИНИЧЕСКАЯ СТОМАТОЛОГИЧЕСКАЯ ПОЛИКЛИНИКА\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"783.42\",\"UslList\":[{\"DateBgn\":\"15.07.2015 00:00:00\",\"DateEnd\":\"15.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение в стоматологии (для оплаты по ОМС)\"},{\"DateBgn\":\"15.07.2015 00:00:00\",\"DateEnd\":\"15.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Ортопантомограмма челюстей (один снимок)\"}]},{\"DateBgn\":\"16.07.2015 00:00:00\",\"DateEnd\":\"16.07.2015 00:00:00\",\"LpuName\":\"БУ \\\"ХАНТЫ-МАНСИЙСКАЯ КЛИНИЧЕСКАЯ СТОМАТОЛОГИЧЕСКАЯ ПОЛИКЛИНИКА\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"1153.97\",\"UslList\":[{\"DateBgn\":\"16.07.2015 00:00:00\",\"DateEnd\":\"16.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение в стоматологии (для оплаты по ОМС)\"},{\"DateBgn\":\"16.07.2015 00:00:00\",\"DateEnd\":\"16.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Сложное удаление зуба с разъединением корней\"}]},{\"DateBgn\":\"16.07.2015 00:00:00\",\"DateEnd\":\"20.07.2015 00:00:00\",\"LpuName\":\"БУ \\\"ХАНТЫ-МАНСИЙСКАЯ КЛИНИЧЕСКАЯ СТОМАТОЛОГИЧЕСКАЯ ПОЛИКЛИНИКА\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"2286.56\",\"UslList\":[{\"DateBgn\":\"17.07.2015 00:00:00\",\"DateEnd\":\"17.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение в стоматологии (для оплаты по ОМС)\"},{\"DateBgn\":\"20.07.2015 00:00:00\",\"DateEnd\":\"20.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение в стоматологии (для оплаты по ОМС)\"},{\"DateBgn\":\"16.07.2015 00:00:00\",\"DateEnd\":\"16.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Операция цистэктомии в области  одного моляра без удаления зуба\"},{\"DateBgn\":\"17.07.2015 00:00:00\",\"DateEnd\":\"17.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Прием (осмотр, консультация пациента с заболеваниями челюстно-лицевой области при повторных посещениях) врача стоматолога хирурга\"},{\"DateBgn\":\"20.07.2015 00:00:00\",\"DateEnd\":\"20.07.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Прием (осмотр, консультация пациента с заболеваниями челюстно-лицевой области при повторных посещениях) врача стоматолога хирурга\"}]},{\"DateBgn\":\"10.09.2015 00:00:00\",\"DateEnd\":\"10.09.2015 00:00:00\",\"LpuName\":\"АУ \\\"ЮГОРСКИЙ ЦЕНТР ПРОФЕССИОНАЛЬНОЙ ПАТОЛОГИИ\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"421.53\",\"UslList\":[{\"DateBgn\":\"10.09.2015 00:00:00\",\"DateEnd\":\"10.09.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение хирурга (хирург и прочие специалисты хирургичекого профиля, не указанных в других разделах)\"}]},{\"DateBgn\":\"21.09.2015 00:00:00\",\"DateEnd\":\"01.10.2015 00:00:00\",\"LpuName\":\"БУ \\\"ОКРУЖНАЯ КЛИНИЧЕСКАЯ БОЛЬНИЦА\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"2515.36\",\"UslList\":[{\"DateBgn\":\"01.10.2015 00:00:00\",\"DateEnd\":\"01.10.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Общий анализ крови (5 показателей: hb, лейкоциты,соэ,эритроциты,лейкоцитарная формула)\"},{\"DateBgn\":\"21.09.2015 00:00:00\",\"DateEnd\":\"21.09.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"},{\"DateBgn\":\"22.09.2015 00:00:00\",\"DateEnd\":\"22.09.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"},{\"DateBgn\":\"25.09.2015 00:00:00\",\"DateEnd\":\"25.09.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"},{\"DateBgn\":\"28.09.2015 00:00:00\",\"DateEnd\":\"28.09.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"},{\"DateBgn\":\"01.10.2015 00:00:00\",\"DateEnd\":\"01.10.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"}]},{\"DateBgn\":\"26.10.2015 00:00:00\",\"DateEnd\":\"09.11.2015 00:00:00\",\"LpuName\":\"БУ \\\"ОКРУЖНАЯ КЛИНИЧЕСКАЯ БОЛЬНИЦА\\\"\",\"LpuType\":\"Поликлиника\",\"SluchSum\":\"5915.29\",\"UslList\":[{\"DateBgn\":\"26.10.2015 00:00:00\",\"DateEnd\":\"26.10.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Ультразвуковое исследование мягких тканей с цветным допплеровским картированием\"},{\"DateBgn\":\"09.11.2015 00:00:00\",\"DateEnd\":\"09.11.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Общий анализ крови (5 показателей: hb, лейкоциты,соэ,эритроциты,лейкоцитарная формула)\"},{\"DateBgn\":\"07.11.2015 00:00:00\",\"DateEnd\":\"07.11.2015 00:00:00\",\"UslCount\":\"1\",\"UslName\":\"Бактериологическое исследование гнойного отделяемого\"},{\"DateBgn\":\"26.10.2015 00:00:00\",\"DateEnd\":\"26.10.2015 00:00:00\",\"UslCount\":\"2\",\"UslName\":\"Посещение челюстно-лицевого хирурга\"}]}]}",
                SvedMu.class);*/


    }


    private void onSvedMuSuccess(SvedMu svedMu) {
        headerList.clear();
        listDataChild.clear();
        if (svedMu != null && svedMu.getItems() != null &&
                svedMu.getItems().size() != 0) {
            view.showParamMu("svedMu.getPatientOmc().getLpuPrik()", "svedMu.getPatientOmc().getSmo()",
                    "svedMu.getParameters().getENP()");
            for (Sluch sluch : svedMu.getItems()) {
                headerList.add(sluch);
                listDataChild.put(sluch, sluch.getUslList());
            }
        }
        view.showService(headerList, listDataChild);
    }
}
