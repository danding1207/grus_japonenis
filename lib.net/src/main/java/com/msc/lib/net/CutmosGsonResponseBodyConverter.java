package com.msc.lib.net;


import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit.Converter;

final class CutmosGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    CutmosGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Logger.e(response);
        return gson.fromJson(response, type);
    }
}
