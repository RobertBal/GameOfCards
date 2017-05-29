package com.sda.balys.robert.gameofcards.model;

import java.util.PriorityQueue;

/**
 * Created by RENT on 2017-05-29.
 */

public class Card
{
    private String img;
   private int rank;
    private String sult;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSult() {
        return sult;
    }

    public void setSult(String sult) {
        this.sult = sult;
    }


}
