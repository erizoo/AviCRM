package ru.specaviagroup.lk.aviacrm.data;

public interface ServicePrefs {

    String user_token = "user_token";

    void saveToken(String token);

    String getUserToken();

}
