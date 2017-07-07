package com.example.administrator.retrofit.config;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/**
 * Created by wyf on 2016/7/18.
 */
public class ResBody extends ResponseBody {

    Response originalResponse;

    public ResBody(Response originalResponse) {
        this.originalResponse = originalResponse;
    }

    @Override
    public MediaType contentType() {
        return originalResponse.body().contentType();
    }

    /**
     * Returns the number of bytes in that will returned by {@link #bytes}, or {@link #byteStream}, or
     * -1 if unknown.
     */
    @Override
    public long contentLength() {
        return originalResponse.body().contentLength();
    }

    @Override
    public BufferedSource source() {
        return Okio.buffer(new ForwardingSource(originalResponse.body().source()) {
            long bytesReaded = 0;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                bytesReaded += bytesRead == -1 ? 0 : bytesRead;
                // 通过RxBus发布进度信息
                //RxBus.getDefault().post(new FileLoadingBean(contentLength(), bytesReaded));
                return bytesRead;
            }
        });
    }
}
