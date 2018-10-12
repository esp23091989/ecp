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

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by danila on 08.11.15.
 */
public interface EcpApi {
    @GET("Test")
    Observable<ErrorResponse> doAuthorize(@Query("login") String login);

    @GET("Auth")
    Observable<AuthResponse> doAuthorize(@Query("login") String login,
                                         @Query("password") String password,
                                         @Query("idType") String idType);

    //    http://212.96.206.77/AndroidService.svc/RestorePassword?email={EMAIL}&phone={PHONE}&code={CODE}
    @GET("RestorePassword")
    Observable<AuthResponse> restorePassword(@Query("email") String email,
                                             @Query("phone") String phone,
                                             @Query("code") String code);

    @GET("City?")
    Observable<CityResponse> getCity();

    //    //Clinic?cityid=8600001300000&patientid=755d6ab1-333f-4e4a-9d32-8647c34d77e7
    @GET("Clinic")
    Observable<ClinicResponse> getClinicByCity(@Query("cityid") String cityid);

//    //    Служба в http://212.96.206.77/AndroidService.svc/Speciality?clinicid={CLINICID}
//    @GET("/Speciality")
//    Observable<SpecialitiesResponse> getSpecialities(@Query("clinicid") String clinicid);

    //     http://ecp.miacugra.ru/AndroidService.svc/DoctorSpecMonth?clinicid=21154
    @GET("Specialist")
    Observable<DoctorResponse> getDoctorSpecMonth(@Query("clinicId") String clinicId);

    //    /Relative?parentid={PARENTID}
    @GET("relative")
    Observable<RelativeResponse> getRelatives(@Query("parentid") String parentid);

    @GET("Register")
    Observable<ResponseModel> registerPacient(@Query("patientid") String patientid,
                                              @Query("parentid") String parentid,
                                              @Query("login") String login,
                                              @Query("password") String password,
                                              @Query("lastname") String lastname,
                                              @Query("firstname") String firstname,
                                              @Query("middlename") String middlename,
                                              @Query("birthday") String birthday,
                                              @Query("insurancenumber") String insurancenumber,
                                              @Query("mobilephone") String mobilephone,
                                              @Query("email") String email, @Query("house") String house,
                                              @Query("kladrid") String kladrid);


    //    http://212.96.206.77/AndroidService.svc/JNVLS?name=%D0%BF
    @GET("JNVLS")
    Observable<MedicamentResponse> findMedicament(@Query("name") String name);

    //    /Diary?patientid={PATIENTID}&fromdate={FROMDATE}&todate={TODATE}
    @GET("Diary")
    Observable<DiaryRecordsResponse> getDiaryRecords(@Query("login") String login,
                                                     @Query("period") String period);

    //    Visit?patientid={PATIENTID}&fromdate={FROMDATE}&todate={TODATE}
    @GET("Visit")
    Observable<VisitResponse> getTickets(@Query("login") String login,
                                         @Query("password") String password);

    //  /SaveDiary?patientid=755d6ab1-333f-4e4a-9d32-8647c34d77e7&date=27.11.2015&note=r
    @GET("SaveDiary")
    Observable<ResponseModel> saveDiary(@Query("login") String login,
                                        @Query("password") String password,
                                        @Query("note") String note,
                                        @Query("note_date") String date);

    //   /CancelVisit?scheduleid={SCHEDULEID}&patientid={PATIENTID}
    @GET("CancelVisit")
    Observable<ResponseModel> cancelVisit(@Query("scheduleid") String scheduleid,
                                          @Query("login") String login, @Query("password") String password);

///Doctor?clinicid={CLINICID}&specialityid={SPECIALITYID}&specialityname={SPECIALITYNAME}&date={VISITDATE}

    @GET("Doctor")
    Observable<DoctorResponse> getDoctors(@Query("clinicid") String clinicid,
                                          @Query("specialityid") String specialityid,
                                          @Query("specialityname") String specialityname,
                                          @Query("date") String date);

    @GET("Schedule")
    Observable<ScheduleResponse> getScheduleForDoctor(@Query("clinicid") String clinicid,
                                                      @Query("specialityid") String specialityid,
                                                      @Query("doctorid") String doctorid);

    ///Enroll?scheduleid={SCHEDULEID}&clinicid={CLINICID}
    // &specialityId={SPECIALITYID}&doctorid={DOCTORID}&date={DATE}
////    Enroll?scheduleid=123456&clinicid=19254&specialityId=123&doctorid=123123123&date=27.12.2015&login=12345678964&password=57292029
    @GET("Enroll")
    Observable<ResponseModel> enroll(@Query("scheduleid") String scheduleid,
                                     @Query("clinicid") String clinicid,
                                     @Query("specialityid") String specialityid,
                                     @Query("doctorid") String doctorid,
                                     @Query("date") String date,
                                     @Query("login") String login,
                                     @Query("password") String password);

    @GET("getTime")
    Observable<CurrentTime> getTime();

    @GET("GetOMSInfo")
    Observable<SvedMuResponse> getSvedMu(@Query("login") String login,
                                         @Query("password") String password,
                                         @Query("fromDate") String fromDate,
                                         @Query("toDate") String toDate);

}
