package com.alg.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "caocao_txlog")
public class TxLog {
    @Id
    private String txLogId;
    private String content;
    private Date date;

    public String getTxLogId() {
        return txLogId;
    }

    public void setTxLogId(String txLogId) {
        this.txLogId = txLogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
