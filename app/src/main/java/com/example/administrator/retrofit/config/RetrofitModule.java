package com.example.administrator.retrofit.config;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wyf on 2016/7/18.
 */
public class RetrofitModule {
    private volatile static RetrofitModule instance;
    private OkHttpClient.Builder clientBuilder;
    private Retrofit.Builder retrofitBuilder;
    private RetrofitModule() {
        //initLog();
        initClientBuilder();
        initRetrofitBuilder();
    }

    /*private void initLog() {
        loggingInterceptor = new HttpLoggingInterceptor();
        if ("debug".equalsIgnoreCase(BuildConfig.BUILD_TYPE)) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
    }*/

    public static RetrofitModule getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (RetrofitModule.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new RetrofitModule();
                }
            }
        }
        return instance;
    }

    /**
     * 提供实例化的OkHttpClient.Builder对象
     */
    private void initClientBuilder() {
        // 构建OkHttpClient.Builder实例
        clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(RetrofitConst.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        clientBuilder.readTimeout(RetrofitConst.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        try {
            clientBuilder.sslSocketFactory(getSSLSocketFactory()).hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clientBuilder.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse
                        .newBuilder()
                        .body(new ResBody(originalResponse))
                        .build();
            }
        });
       // clientBuilder.addInterceptor(loggingInterceptor);
    }

    public SSLSocketFactory getSSLSocketFactory() throws Exception {
        //创建一个不验证证书链的证书信任管理器。
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts,
                new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext
                .getSocketFactory();
    }

    private void initRetrofitBuilder() {
        retrofitBuilder = new Retrofit.Builder()
                // 配置baseUrl
                .baseUrl(RetrofitConst.HOST_URL)
                // 配置OkHttpClient
                .client(clientBuilder.build())
                // 配置Gson解析
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create()));
    }

    /**
     * 根据interface创建Call类型对象
     */
    public <T> T create(Class<T> service) {
        return retrofitBuilder.build().create(service);
    }
}
