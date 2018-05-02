package com.imangazaliev.notelin.mvp.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIInterface {

    @GET(value = "/user/{userID}/notes")
    Observable<List<Note>> getAll(@Path("userID") String userId);

    @GET(value = "/user/{userID}/notes/{noteID}")
    Observable<Note> getById(@Path("userID") String userId, @Path("noteID") String id);

    @DELETE(value = "/user/{userID}/notes")
    Observable<Response<Void>> removeAll(@Path("userID") String userId);

    @DELETE(value = "/user/{userID}/notes/{noteID}")
    Observable<Response<Void>> remove(@Path("userID") String userId, @Path("noteID") String id);

    @POST(value = "/user/{userID}/notes")
    Observable<Note> create(@Path("userID") String userId, @Body Note noteDTO);

    @PUT(value = "/user/{userID}/notes/{noteID}")
    Observable<Response<Void>> update(@Path("userID") String userId, @Path("noteID") String id, @Body Note noteDTO);

}
