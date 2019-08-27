package com.cwb.news.biz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "biz_video")
@Getter
@Setter
public class Video implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 视频路径
     */
    @Column(name = "VI_PATH")
    private String viPath;

    /**
     * 视频封面图
     */
    @Column(name = "VI_IMG")
    private String viImg;

    /**
     * 视频语言类型
     */
    @Column(name = "VI_LANG")
    private String viLang;

    /**
     * 视频内容类型  宣传片  景区
     */
    @Column(name = "VI_TYPE")
    private String viType;

    @Column(name = "CJSJ")
    private String cjsj;

    @Column(name = "CJR")
    private String cjr;

    private static final long serialVersionUID = 1L;



    public enum InnerColumn {
        id("ID"),
        viPath("VI_PATH"),
        viImg("VI_IMG"),
        viLang("VI_LANG"),
        viType("VI_TYPE"),
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