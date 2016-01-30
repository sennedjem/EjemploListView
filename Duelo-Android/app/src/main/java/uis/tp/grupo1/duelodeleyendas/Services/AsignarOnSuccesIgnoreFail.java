package uis.tp.grupo1.duelodeleyendas.Services;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sebastian on 02/12/15.
 */
public class AsignarOnSuccesIgnoreFail<T> implements Callback<T> {

    private DataCointainer container;

    public AsignarOnSuccesIgnoreFail(DataCointainer container){
        this.container = container;
    }

    @Override
    public void success(T t, Response response) {
        container.asignar(t);
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
