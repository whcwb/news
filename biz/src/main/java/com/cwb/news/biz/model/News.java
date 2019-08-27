package com.cwb.news.biz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BIZ_NEWS")
@Getter
@Setter
public class News {


    @Id
    private String id;

    @Column(name = "cjsj")
    private String cjsj;

    @Column(name = "cjr")
    private String cjr;
    /**
     * 新闻标题
     */
    @Column(name = "title")
    private String title;
    /**
     * 新闻副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 新闻内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 新闻类型
     */
    @Column(name = "type")
    private String type;

    private String bz;

    private String bz1;

    private String bz2;

    private String bz3;


    public enum  InnerColumn{
        id("ID"),
        cjsj("CJSJ"),
        cjr("CJR"),
        title("TITLE"),
        subTitle("SUB_TITLE"),
        content("CONTENT"),
        type("TYPE"),
        bz("BZ"),
        bz1("BZ1"),
        bz2("BZ2"),
        bz3("BZ3");


        private final String column;

        public String value(){
            return this.column;
        }

        public String getValue(){
            return this.column;
        }

        InnerColumn(String column){
            this.column = column;
        }

        public String desc(){
            return this.column + " desc";
        }

        public String asc(){
            return this.column + " asc";
        }



    }



}
