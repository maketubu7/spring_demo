package com.make.model;

import net.bytebuddy.implementation.bind.annotation.Super;

public class heroDAO extends heroDAOKey {

    private String q;

    private String w;

    private String e;

    private String r;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q == null ? null : q.trim();
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w == null ? null : w.trim();
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e == null ? null : e.trim();
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r == null ? null : r.trim();
    }
}