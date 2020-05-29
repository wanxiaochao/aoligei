package com.alg.common.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "caocao_product")
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 5072015133741004100L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//主键
    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存

}
