package com.cwb.news.biz.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "BIZ_IMG")
public class Img {

    @Id
    private String id;

    private String type;

    private String path;

    private String cjsj;

    private String cjr;

    public enum  InnerColumn{

        id("ID"),
        type("TYPE"),
        path("PATH"),
        cjsj("CJSJ"),
        cjr("CJR");

        public final String column;

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
