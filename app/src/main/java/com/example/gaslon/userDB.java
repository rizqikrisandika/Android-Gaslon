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

    public userDB() {
    }

    public String getPrfName() {
        return prfName;
    }

    public void setPrfName(String prfName) {
        this.prfName = prfName;
    }

    public String getPrfEmail() {
        return prfEmail;
    }

    public void setPrfEmail(String prfEmail) {
        this.prfEmail = prfEmail;
    }

    public String getPrfPhone() {
        return prfPhone;
    }

    public void setPrfPhone(String prfPhone) {
        this.prfPhone = prfPhone;
    }
}
