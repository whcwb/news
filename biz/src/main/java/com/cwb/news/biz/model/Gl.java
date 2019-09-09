package com.cwb.news.biz.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BIZ_GL")
@Data
public class Gl {
    @Id
    private String id;

    private String type;

    private String title;

    private String img;

    private String content;

    private String cjsj;

    private String cjr;

    public enum InnerColumn{
        id("ID"),
        type("TYPE"),
        title("TITLE"),
        img("IMG"),
        content("CONTENT"),
        cjsj("CJSJ"),
        cjr("CJR");
        public  final String column;

        InnerColumn(String column) {
            this.column = column;
        }

        public String value(){
            return this.column;
        }
        public String getValue(){
            return this.column;
        }
        public String asc(){
            return this.column + " asc";
        }

        public String desc(){
            return this.column + " desc";
        }





    }


}
