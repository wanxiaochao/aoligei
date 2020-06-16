package com.aoligei.es_learn.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1203863506150516797L;

    private Long uid;
    private String nickname;
    private String address;
    private String desc;
    private Long birthday;

}
