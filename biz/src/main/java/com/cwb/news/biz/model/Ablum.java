package com.cwb.news.biz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "biz_ablum")
@Getter
@Setter
public class Ablum implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "CJSJ")
    private String cjsj;

    @Column(name = "CJR")
    private String cjr;

    /**
     * 相册名称
     */
    @Column(name = "AB_NAME")
    private String abName;

    @Transient
    private AblumImg ablumImg;

    private static final long serialVersionUID = 1L;


    public enum InnerColumn {
        id("ID"),
        cjsj("CJSJ"),
        cjr("CJR"),
        abName("AB_NAME");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        InnerColumn(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}