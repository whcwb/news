package com.cwb.news.biz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "biz_ablum_img")
@Getter
@Setter
public class AblumImg implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 相册ID
     */
    @Column(name = "AB_ID")
    private String abId;

    /**
     * 图片路径
     */
    @Column(name = "AB_IMG")
    private String abImg;

    @Column(name = "CJSJ")
    private String cjsj;

    @Column(name = "CJR")
    private String cjr;


    private static final long serialVersionUID = 1L;



    public enum InnerColumn {
        id("ID"),
        abId("AB_ID"),
        abImg("AB_IMG"),
        cjsj("CJSJ"),
        cjr("CJR");

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