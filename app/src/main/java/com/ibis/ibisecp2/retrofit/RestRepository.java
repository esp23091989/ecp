package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.CityResponse;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.model.CurrentTime;
import com.ibis.ibisecp2.model.DiaryRecordsResponse;
import com.ibis.ibisecp2.model.DoctorResponse;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.model.MedicamentResponse;
import com.ibis.ibisecp2.model.RelativeResponse;
import com.ibis.ibisecp2.model.ResponseModel;
import com.ibis.ibisecp2.model.ScheduleResponse;
import com.ibis.ibisecp2.model.SvedMuResponse;
import com.ibis.ibisecp2.model.VisitResponse;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by danila on 08.11.15.
 */
public class RestRepository implements Repository {
    //    private static final String BASE_URL = "http://ecp.miacugra.ru/AndroidService.svc/";
    private static final String BASE_URL = "http://ecp.miacugra.ru:8008/AndroidService.svc/";
    EcpApi ecpApi;

    @Inject
    public RestRepository() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        hostSelectionInterceptor = new HostSelectionInterceptor();
//        hostSelectionInterceptor.setHost(BASE_URL);
        OkHttpClient client =
                new OkHttpClient.Builder().addInterceptor(interceptor)
                        .readTimeout(40, TimeUnit.SECONDS)
                        .writeTimeout(40, TimeUnit.SECONDS)
                        .connectTimeout(40, TimeUnit.SECONDS)
                        .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ecpApi = retrofit.create(EcpApi.class);

    }

    @Override
    public Observable<AuthResponse> doAuthorize(String login, String password, String idType) {
        return ecpApi.doAuthorize(login, password, idType);
    }

    @Override
    public Observable<ErrorResponse> doAuthorize(String login) {
        return ecpApi.doAuthorize(login);
    }

    @Override
    public Observable<AuthResponse> restorePassword(String email, String phone, String code) {
        return ecpApi.restorePassword(email, phone, code);
    }

    @Override
    public Observable<CityResponse> getCity() {
        return ecpApi.getCity();
    }

    @Override
    public Observable<ClinicResponse> getClinicByCity(String cityid) {
        return ecpApi.getClinicByCity(cityid);
    }

    @Override
    public Observable<DoctorResponse> getDoctorSpecMonth(String clinicid) {
        return ecpApi.getDoctorSpecMonth(clinicid);
    }

    @Override
    public Observable<RelativeResponse> getRelatives(String parentid) {
        return ecpApi.getRelatives(parentid);
    }

    @Override
    public Observable<ResponseModel> registerPacient(String patientid, String parentid, String login,
                                                     String password, String lastname, String firstname,
                                                     String middlename, String birthday, String insurancenumber,
                                                     String mobilephone, String email, String house, String kladrid) {
        return ecpApi.registerPacient(patientid, parentid, login, password, lastname, firstname,
                middlename, birthday, insurancenumber, mobilephone, email, house, kladrid);
    }

    @Override
    public Observable<MedicamentResponse> findMedicament(String name) {
        return ecpApi.findMedicament(name);
    }

    @Override
    public Observable<DiaryRecordsResponse> getDiaryRecords(String login, String period) {
        return ecpApi.getDiaryRecords(login, period);
    }

    @Override
    public Observable<VisitResponse> getTickets(String login, String password) {
        return ecpApi.getTickets(login, password);
    }

    @Override
    public Observable<ResponseModel> saveDiary(String login, String password, String note, String date) {
        return ecpApi.saveDiary(login, password, note, date);
    }

    @Override
    public Observable<ResponseModel> cancelVisit(String scheduleid, String login, String password) {
        return ecpApi.cancelVisit(scheduleid, login, password);
    }

    @Override
    public Observable<DoctorResponse> getDoctors(String clinicid, String specialityid,
                                                 String specialityname, String date) {
        return ecpApi.getDoctors(clinicid, specialityid, specialityname, date);
    }

    //    @Override
//    public Observable<DoctorByClinicResponse> getDoctorsByClinic(String clinicid, String date) {
//        return ecpApi.getDoctorsByClinic(clinicid,date);
//    }
    @Override
    public Observable<ScheduleResponse> getScheduleForDoctor(String clinicid, String specialityid,
                                                             String doctorid) {
        return ecpApi.getScheduleForDoctor(clinicid, specialityid, doctorid);
    }

    @Override
    public Observable<ResponseModel> enroll(String scheduleid, String clinicid, String specialityid, String doctorid,
                                            String date, String login, String password) {
        return ecpApi.enroll(scheduleid, clinicid, specialityid, doctorid, date, login, password);
    }

    @Override
    public Observable<CurrentTime> getTime() {
        return ecpApi.getTime();
    }

    @Override
    public Observable<SvedMuResponse> getSvedMu(String login, String password, String fromDate, String toDate) {
        return ecpApi.getSvedMu(login, password, fromDate, toDate);
    }


}
