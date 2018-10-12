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

import rx.Observable;

/**
 * Created by danila on 08.11.15.
 */
public interface Repository {
    Observable<AuthResponse> doAuthorize(String login, String password, String idType);

    Observable<ErrorResponse> doAuthorize(String login);

    Observable<AuthResponse> restorePassword(String email, String phone, String code);

    Observable<CityResponse> getCity();

    Observable<ClinicResponse> getClinicByCity(String cityid);

    Observable<DoctorResponse> getDoctorSpecMonth(String clinicid);

    Observable<RelativeResponse> getRelatives(String parentid);

    Observable<ResponseModel> registerPacient(String patientid, String parentid, String login,
                                              String password, String lastname, String firstname,
                                              String middlename, String birthday, String insurancenumber,
                                              String mobilephone, String email, String house,
                                              String kladrid);

    Observable<MedicamentResponse> findMedicament(String name);

    Observable<DiaryRecordsResponse> getDiaryRecords(String login, String period);

    Observable<VisitResponse> getTickets(String login, String password);

    Observable<ResponseModel> saveDiary(String login, String password, String note, String date);

    Observable<ResponseModel> cancelVisit(String scheduleid, String login, String password);

    Observable<DoctorResponse> getDoctors(String clinicid, String specialityid, String specialityname,
                                          String date);

    //    Observable<DoctorByClinicResponse> getDoctorsByClinic(String clinicid, String date);
    Observable<ScheduleResponse> getScheduleForDoctor(String clinicid, String specialityid,
                                                      String doctorid);

    Observable<ResponseModel> enroll(String scheduleid, String clinicid, String specialityid,
                                     String doctorid, String date, String login, String password);

    Observable<CurrentTime> getTime();

    Observable<SvedMuResponse> getSvedMu(String login, String password, String fromDate, String toDate);
}
