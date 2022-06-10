package com.conversor.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotacao {
    int id;
    String code;
    String codein;
    String name;
    Float high;
    Float low;
    Float varBid;
    Float pctChange;
    Float bid;
    Float ask;
    int timestamp;
    String create_date;

    public Cotacao() {
    }

    public Cotacao(String code, String codein, String name, Float high, Float low, Float varBid,
            Float pctChange, Float bid, Float ask, int timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Cotacao{" + "code=" + code + ", codein=" + codein + ", name=" + name + ", high" + high
                + ", low" + low + ", varBid" + varBid + ", pctChange" + pctChange + ", bid" + bid + ", ask" + ask
                + ", timestamp" + timestamp + ", create_date" + create_date + "}";
    }

}