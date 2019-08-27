package com.cwb.news.biz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BIZ_BANNER")
@Getter
@Setter
public class Banner {

    @Id
    private String id;

    @Column(name = "BAN_NAME")
    private String banName;

    @Column(name = "BAN_TYPE")
    private String banType;

    @Column(name = "BAN_IMG")
    private String banImg;

    @Column(name = "BAN_SIZE")
    private String banSize;

    @Column(name = "BAN_SORT")
    private int banSort;

    private String cjsj;

    private String cjr;

    public enum  InnerColumn{

        id("ID"),
        banName("BAN_NAME"),
        banType("BAN_TYPE"),
        banImg("BAN_IMG"),
        banSize("BAN_SIZE"),
        banSort("BAN_SORT"),
        cjsj("CJSJ"),
        cjr("CJR");


        private final String  column;

        InnerColumn(String column){
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
