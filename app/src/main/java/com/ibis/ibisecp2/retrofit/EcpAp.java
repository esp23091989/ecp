package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.CityResponse;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.model.CurrentTime;
import com.ibis.ibisecp2.model.DiaryRecordsResponse;
import com.ibis.ibisecp2.model.DoctorResponse;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.MedicamentResponse;
import com.ibis.ibisecp2.model.Protocol;
import com.ibis.ibisecp2.model.ScheduleResponse;
import com.ibis.ibisecp2.model.SvedMu;
import com.ibis.ibisecp2.model.Tasks;
import com.ibis.ibisecp2.model.VisitHistoryResponse;
import com.ibis.ibisecp2.model.VisitResponse;
import com.ibis.ibisecp2.model.auth.dto.UserInfoDTO;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import rx.Single;

/**
 * Created by danila on 27.10.16.
 */

public interface EcpAp {
    //    @FormUrlEncoded
    @POST("Auth")
    Single<AuthResponse> auth(@Body EsiaTokenMarker esiaTokenMarker);

    @POST("GetTime")
    Observable<CurrentTime> getTime();

    @POST("City")
    Observable<CityResponse> getCity();

    @POST("Clinic")
    Observable<ClinicResponse> getClinic(@Query("cityId") String cityId);

    @POST("Specialist")
    Observable<DoctorResponse> getSpecialist(@Query("clinicId") String clinicId);

    @POST("JNVLS")
    Observable<MedicamentResponse> findMedicament(@Query("name") String name);

    @POST("Visits")
    Observable<VisitResponse> getVisits(@Query("token") String token);

    @POST("LastVisits")
    Observable<VisitHistoryResponse> getHistory(@Query("token") String token);

    @POST("SpecSchedule")
    Observable<ScheduleResponse> getSchedule(@Query("clinicId") String clinicId,
                                             @Query("depCode") String depCode,
                                             @Query("doctorId") String doctorId,
                                             @Query("profCode") String profCode,
                                             @Query("positionCode") String positionCode,
                                             @Query("beginDate") String beginDate);

    @POST("Diary")
    Observable<DiaryRecordsResponse> getDiaryRecords(@Query("token") String login,
                                                     @Query("offset") String period);

    @POST("ChangeVisit")
    Observable<ItemResponse> changeVisit(@Query("scheduleid") String scheduleId,
                                         @Query("code") int code,
                                         @Query("token") String token);

    @POST("ChangeDiary")
    Observable<ErrorResponse> changeDiary(@Query("token") String token,
                                          @Query("note") String note,
                                          @Query("note_date") String date);

    @POST("GetOMSInfo")
    Observable<SvedMu> getSvedMu(@Query("token") String token,
                                 @Query("fromDate") String fromDate,
                                 @Query("toDate") String toDate);

    @POST("AddProtocol")
    Observable<ResponseBody> testPost(@Body Protocol protocol);

    @POST("Tasks")
    Observable<Tasks> getTasks(@Query("token") String token);

    @POST("Nearest")
    Observable<ClinicResponse> getClinicNearMe(@Query("latitude") String latitude,
                                               @Query("longitude") String longitude);
}
