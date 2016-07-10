package com.javiernunez.puppies.restAPIFirebase;

import com.javiernunez.puppies.restAPIFirebase.model.UsrIDInstTokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Javier Núñez on 09/07/2016.
 */
public interface EndPointFirebase {

    @FormUrlEncoded
    @POST(ConstantesAPIFirebase.KEY_POST_ID_USR)
    Call<UsrIDInstTokenResponse> registrarTokenID(
            @Field("id_dispositivo") String id_dispositivo,
            @Field("id_usuario_instagram") String id_usuario_instagram,
            @Field("nombre_usuario_instagram") String nombre_usuario_instagram);
}
