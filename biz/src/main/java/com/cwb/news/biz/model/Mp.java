package com.cwb.news.biz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "BIZ_MP")
@Data
public class Mp {

    private String id;

    private String img;

    private String title;

    @Column(name = "SUB_TITLE")
    private String subTitle;

    private String booking;

    private String price;

    private String content;

    private String cjsj;

    public enum InnerColumn{

        id("ID"),
        img("IMG"),
        title("TITLE"),
        subTitle("SUB_TITLE"),
        booking("BOOKING"),
        price("PRICE"),
        content("CONTENT"),
        cjsj("CJSJ");

        private final String column;

        InnerColumn(String column) {
            this.column = column;
        }

        public String getValue(){
            return this.column;
        }

        public String value(){
            return this.column;
        }

        public String desc(){
            return this.column + " desc";
        }

        public String asc(){
            return this.column + " asc";
        }

    }

}
