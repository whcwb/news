package com.cwb.news.biz.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Table(name = "BIZ_ADVICE")
@Data
public class Advice {
    @Id
    private String id;

    private String name;

    private String mail;

    private  String phone;

    private String advice;

    private String cjsj;

    private String cjr;


    public enum InnerColumn{
        id("ID"),
        mail("MAIL"),
        phone("PHONE"),
        advice("ADVICE"),
        name("NAME"),
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
            return this.column +  " desc";
        }





    }




}
