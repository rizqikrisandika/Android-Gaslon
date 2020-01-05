package com.example.gaslon;

public class userDB {
    public String prfName;
    public String prfEmail;
    public String prfPhone;

    public userDB(String prfName, String prfEmail, String prfPhone) {
        this.prfName = prfName;
        this.prfEmail = prfEmail;
        this.prfPhone = prfPhone;
    }

    public String getPrfName() {
        return prfName;
    }

    public String getPrfEmail() {
        return prfEmail;
    }

    public String getPrfPhone() {
        return prfPhone;
    }



    public userDB() {
    }

}
