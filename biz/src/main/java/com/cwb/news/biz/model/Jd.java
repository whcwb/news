package com.cwb.news.biz.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BIZ_JD")
@Data
public class Jd {

    @Id
    private String id;

    private String title;

    private String img;

    private String content;

    private String cjsj;

    private String cjr;

    private String text;

    private String kfsj;

    private String type;

    public enum InnerColumn{
        id("ID"),
        title("TITLE"),
        img("IMG"),
        content("CONTENT"),
        cjsj("CJSJ"),
        cjr("CJR"),
        type("TYPE");

        private final String column;

        InnerColumn(String column) {
            this.column = column;
        }
        public String value(){
            return this.column;
        }
        public String getValue(){
            return  this.column;
        }
        public String asc(){
            return  this.column  + " asc";
        }
        public String desc(){
            return this.column + " desc";
        }






    }





}
