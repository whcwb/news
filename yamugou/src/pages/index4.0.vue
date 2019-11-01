<template>
  <div class="background" style="background-color:#F9F9F9;font-family:MicrosoftYaHei;height: 100%;position: relative;">
    <div class="box1" style="height: 100vh;">
      <full-page :options="options">
        <div class="section">
          <div style="height: 100vh">
            <b-carousel
              class="row yj d-none d-sm-flex"
              id="carousel-1"
              v-model="slide"
              :interval="4000"
              controls
              indicators
              background="#ababab"
              img-width="1024"
              img-height="480"
              style="text-shadow: 1px 1px 2px #333;margin: 0;"
            >
              <b-carousel-slide v-for="(item,index) in bannerList" style="padding-top: 70px">
                <img
                  slot="img"
                  class="d-block img-fluid w-100"
                  :interval="100000"
                  width="1024"
                  height="480"
                  :src="item.banImg"
                >
              </b-carousel-slide>

            </b-carousel>
          </div>
        </div>
        <div class="section">
          <div style="height: 100vh;padding-top: 80px">
            <div class="row">
              <div class="col-md-12 " style="padding: 0;position: relative">
                <!--<img src="../assets/img/index/jqjsbg.png" style="position: absolute;width: 60%">-->
                <div class="row" style="margin: 0">
                  <div class="col-md-1" style="padding: 0;position: relative"></div>
                  <div class="col-md-10" style="padding: 0;position: relative">
                    <div class="row" style="margin: 0">
                      <div class="titleBG" style="margin: 61px 0 50px 0;width: 35%">
                        <img src="../assets/img/index/logo.png"
                             style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                        <span @mouseenter="jqCSSchange(index)" v-for="(item,index) in jq"
                              style="position: static;z-index: 111;cursor: pointer;color: #CACACA "
                              :class="item.hovered?'hoverd':''">
                     {{$t(item.text)}}
                  </span>
                      </div>
                    </div>
                    <div class="row" style="margin: 0;height: 400px;position: relative">
                      <!--<img src="../assets/img/leftBtn.png" @click="moveImg('prev')"-->
                      <!--style="position: absolute;top: 50%;transform: translate(-120%,-50%);width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
                      <div class="col-md-8" style="overflow: hidden;padding: 0;height: 100%;">
                        <div class="row" style="transition: all 0.3s;width: 100%;flex-wrap: nowrap;">

                          <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                            <img :src="imgList[0].path" @click="toPage('jqjs',item)" class="photo1"
                                 style="width: 100%;height: 400px;cursor: pointer">
                            <div
                              style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                              <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">亚木沟的由来</p>
                            </div>
                          </div>

                          <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                            <img :src="imgList[1].path" @click="toPage('jqjs',item)" class="photo1"
                                 style="width: 100%;height: 400px;cursor: pointer">
                            <div
                              style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                              <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">玉带石</p>
                            </div>
                          </div>

                          <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                            <img :src="imgList[2].path" @click="toPage('jqjs',item)" class="photo1"
                                 style="width: 100%;height: 400px;cursor: pointer">
                            <div
                              style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                              <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">亚木沟的水</p>
                            </div>
                          </div>


                          <div class="col-md-4 imgAll" v-if="jqIndex===1"
                               style="padding: 0 5px;height: 100%;position: relative"
                               v-for="(item,index) in imgListAll">
                            <div>
                              <img :src="item.path" @click="toPage('jqjs',item)"
                                   style="cursor: pointer;width: 100%;height: 400px">
                            </div>

                            <img src="../assets/img/play.png" @click="toPage('Detail',item)"
                                 style="cursor: pointer;width: 50px;height: 50px;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%)">
                          </div>
                        </div>

                        <!--<div class="row" style="display: flex;justify-content: center;margin-top: 50px">-->
                        <!--<img src="../assets/img/leftBtn.png" @click="moveImg('prev')"-->
                        <!--style="width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
                        <!--<img src="../assets/img/rightBtn.png" @click="moveImg('next')"-->
                        <!--style="width: 50px;height: 50px;cursor: pointer">-->
                        <!--</div>-->


                        <!--<div v-for="item in imgListAll"-->
                        <!--style="border:1px solid rgba(100,74,35,1);;width: 32%;height: 582px;background-color: white">-->
                        <!--<img :src="item.path" style="width: 100%;height: 400px">-->
                        <!--&lt;!&ndash;<div&ndash;&gt;-->
                        <!--&lt;!&ndash;style="height: 15%;display: flex;justify-content: center;align-items: center;font-size:24px;font-family:MicrosoftYaHei;">&ndash;&gt;-->
                        <!--&lt;!&ndash;{{item.text}}&ndash;&gt;-->
                        <!--&lt;!&ndash;</div>&ndash;&gt;-->
                        <!--</div>-->
                      </div>
                      <div class="col-md-4" style="padding: 0 0 0 10px">
                        <div style="border:1px solid rgba(100,74,35,1);width: 100%;height: 400px;background-color: white">
                          <div
                            style="position: absolute;font-size:20px;color:rgba(100,74,35,1);top: -30px;">
                            {{$t('m.WBDT')}}
                          </div>
                          <iframe width="100%" height="54%" class="share_self" frameborder="0" scrolling="no"
                                  src="http://widget.weibo.com/weiboshow/index.php?language=&amp;width=0&amp;height=300&amp;fansRow=2&amp;ptype=1&amp;speed=0&amp;skin=1&amp;isTitle=1&amp;noborder=1&amp;isWeibo=1&amp;isFans=0&amp;uid=3087094555&amp;verifier=1a8431ad&amp;dpc=1"></iframe>

                          <div class="row"
                               style="margin: 0;padding: 7px;background-color: #644A23;height: 45.5%;">
                            <div class="col-md-12" style="padding: 2px;font-size: 17px;color: white">
                              {{date}}
                            </div>
                            <div class="col-md-12" style="padding: 0;height: 20%;color: white;display: flex;">
                              <div :class="item.clicked?'tabbutton tabbuttonClick':'tabbutton'"
                                   @click="LittletabChangeCSS(index)" v-for="(item,index) in littleTabList">
                                {{$t(item.text)}}
                              </div>
                              <div class="tabbutton"
                                   onclick="window.open('https://piao.ctrip.com/ticket/dest/t1408206.html')">
                                {{$t('m.WSGP')}}
                              </div>
                            </div>
                            <div class="col-md-12" v-if="littleTabIndex==0"
                                 style="padding: 0;margin-top: 5px;background-color: white">
                              <div class="row" style="margin: 0;">
                                <div class="col-md-3"
                                     style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                                  {{$t('m.CRP')}}
                                </div>
                                <div class="col-md-9"
                                     style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;border-bottom: 2px solid #B9B9B9">
                                  80{{$t('m.yuan')}}/{{$t('m.ren')}}
                                </div>
                              </div>
                              <div class="row" style="margin: 0;">
                                <div class="col-md-3"
                                     style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                                  {{$t('m.YDP')}}
                                </div>
                                <div class="col-md-9"
                                     style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;border-bottom: 2px solid #B9B9B9">
                                  65{{$t('m.yuan')}}/{{$t('m.ren')}}
                                </div>
                              </div>
                              <div class="row" style="margin: 0;">
                                <div class="col-md-3"
                                     style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;">
                                  {{$t('m.SRP')}}
                                </div>
                                <div class="col-md-9"
                                     style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;">
                                  160{{$t('m.yuan')}}/{{$t('m.ren')}}
                                </div>
                              </div>
                            </div>
                            <div class="col-md-12" v-if="littleTabIndex==1"
                                 style="padding: 0;margin-top: 5px;background-color: white;">
                              <div class="row" style="margin: 0;">
                                <div class="col-md-12"
                                     style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                                  {{$t('m.JQFWRX')}}：0856-6622222
                                </div>
                              </div>
                              <div class="row" style="margin: 0;">
                                <div class="col-md-12"
                                     style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                                  {{$t('m.JYDH')}}：0856-6627886
                                </div>
                              </div>
                              <div class="row" style="margin: 0;">
                                <div class="col-md-12"
                                     style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;text-overflow: ellipsis;overflow-x: hidden; white-space: nowrap;">
                                  {{$t('m.JTDZ')}}
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!--<img src="../assets/img/rightBtn.png" @click="moveImg('next')"-->
                      <!--style="z-index: 999;position: absolute;right: 0;top: 50%;transform: translate(200%,-50%);width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
                    </div>
                  </div>
                  <div class="col-md-1" style="padding: 0;position: relative"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="section">
          <div style="height: 100vh;padding-top: 80px">
            <div class="row">
              <div class="col-md-12" style="margin-top: 40px;text-align: center">
                <!--<img src="../assets/img/index/news.png" style="width: 30%">-->
                <div class="titleBG" style="width: 250px">
                  <img src="../assets/img/index/logo.png"
                       style="width:110px;height: 40px;padding: 0 15px;position: static;z-index: 100">
                  <span style="font-size: 21px;position: static;z-index: 110">{{$t('m.XWZW')}}</span>
                  <div class="titleBGBottom"></div>
                </div>
              </div>
            </div>

            <div class="row" style="margin-top:50px">
              <div class="col-md-1"></div>
              <div class="col-md-10" style="padding: 0" v-if="$i18n.locale === 'zh-CN'">
                <div class="row" style="margin: 0;display: flex;justify-content: space-between;width: 100%">

                  <div class="col-md-6 photo"
                       style="height: 400px;font-size: 14px;padding: 0;max-width: 40%;flex: 0 0 40%">
                    <div class="row" style="margin: 0;height: 50%;width: 100%;position: relative">
                      <img :src="newsList[0].bz" @click="toPage('Detail',newsList[0])" class="photo1"
                           style="width: 100%;height: 100%;cursor: pointer">
                      <div
                        style="width: 100%;position: absolute;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                        <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[0].title}}</p>
                      </div>
                    </div>
                    <div class="row" style="height: 50%;width: 100%;margin: 0">
                      <div class="col-md-6" style="padding: 0">
                        <img :src="newsList[1].bz" @click="toPage('Detail',newsList[1])" class="photo1"
                             style="width: 100%;height: 100%;cursor: pointer">
                        <div
                          style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                          <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[1].title}}</p>
                        </div>
                      </div>
                      <div class="col-md-6" style="padding: 0">
                        <img :src="newsList[2].bz" @click="toPage('Detail',newsList[2])" class="photo1"
                             style="width: 100%;height: 100%;cursor: pointer">
                        <div
                          style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                          <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[2].title}}</p>
                        </div>
                      </div>
                    </div>
                  </div>


                  <!--首页新闻的展示方式&#45;&#45;左竖一右横二-->
                  <!--<div class="col-md-6 photo"-->
                  <!--style="font-size: 14px;display: flex;padding: 0;max-width: 49%;flex: 0 0 49%">-->
                  <!--<div style="width: 50%;position: relative">-->
                  <!--<img :src="newsList[0].bz" @click="toPage('Detail',newsList[0])" class="photo1"-->
                  <!--style="width: 100%;height: 100%;cursor: pointer">-->
                  <!--<div-->
                  <!--style="width: 100%;position: absolute;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
                  <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[0].title}}</p>-->
                  <!--</div>-->
                  <!--</div>-->
                  <!--<div style="width: 50%;height: 100%;">-->
                  <!--<div style="height: 50%;position: relative">-->
                  <!--<img :src="newsList[1].bz" @click="toPage('Detail',newsList[1])" class="photo1"-->
                  <!--style="width: 100%;height: 100%;cursor: pointer">-->
                  <!--<div-->
                  <!--style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
                  <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[1].title}}</p>-->
                  <!--</div>-->
                  <!--</div>-->
                  <!--<div style="height: 50%;position: relative">-->
                  <!--<img :src="newsList[2].bz" @click="toPage('Detail',newsList[2])" class="photo1"-->
                  <!--style="width: 100%;height: 100%;cursor: pointer">-->
                  <!--<div-->
                  <!--style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
                  <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[2].title}}</p>-->
                  <!--</div>-->
                  <!--</div>-->
                  <!--</div>-->
                  <!--</div>-->


                  <div class="col-md-6 item"
                       style="max-width: 40%;flex: 0 0 40%;display: flex;flex-direction: column;justify-content: space-between;padding: 0;height: 400px;">
                    <div v-for="item in jkNews" @click="toPage('Detail',item)"
                         style="cursor: pointer;height:30%;border:solid 2px #644A23;display: flex">
                      <div style="width:85%;height: 100%;overflow-x: hidden;text-overflow:ellipsis;">
                        <div
                          style="margin-top: 15px;white-space: nowrap;overflow: hidden;text-overflow:ellipsis;text-align: center;height:40px;font-size:20px;color:#745D3A;line-height:40px;">
                          {{item.title}}
                        </div>
                        <div style="font-size:15px;width: 90%;margin: 3px auto 0;text-indent:48px;">
                          {{item.subTitle}}
                        </div>
                      </div>
                      <div
                        style="font-size:20px;width: 15%;height: 100%;background-color: #644A23;color: white;display: flex;justify-content: center;align-items: center">
                        {{item.month}}
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <!--英语模式下显示此新闻模块-->
              <div class="col-md-10" v-else>
                <div class="row" v-for="item in newsList"
                     style="margin-bottom: 20px;display: flex;justify-content: space-between;height: 400px;border:solid 2px #644A23;">
                  <div class="col-md-5" style="padding: 0">
                    <img :src="item.bz" style="width:100%;height: 100%">
                  </div>
                  <div class="col-md-6 newsText" style="height: 60%;overflow-x: hidden;text-overflow:ellipsis;">
                    <div
                      style="text-align: center;font-size:20px;color:#644A23;line-height:40px;">
                      {{item.title}}
                    </div>
                    <div v-html="item.content" style="font-size:15px;width: 90%;margin: 0 auto;text-indent:48px">
                      {{item.content}}
                    </div>
                  </div>
                  <div class="col-xs-2 col-md-1 newsMonth"
                       style="font-size:20px;height: unset;background-color: #644A23;color: white;display: flex;justify-content: center;align-items: center">
                    {{item.month}}
                  </div>
                </div>
              </div>
              <div class="col-md-1"></div>
            </div>

          </div>
        </div>
        <div class="section">
          <div style="height: 100vh">
            dsafsa
          </div>
        </div>
      </full-page>

    </div>


    <b-carousel
      class="row yj d-none d-sm-flex"
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;margin: 0"
    >
      <b-carousel-slide v-for="(item,index) in bannerList">
        <img
          slot="img"
          class="d-block img-fluid w-100"
          :interval="100000"
          width="1024"
          height="480"
          :src="item.banImg"
        >
      </b-carousel-slide>

    </b-carousel>


    <div class="navRight d-none d-sm-block">
      <img src="../assets/img/index/weixinshare.png" style="width: 50px;cursor: pointer" @mouseenter="weixinshare=true"
           @mouseleave="weixinshare=false">
      <img src="../assets/img/index/rightNav2.png" v-if="weixinshare"
           style="width: 100px;top: 0;position: absolute!important;right: 60px">
      <img src="../assets/img/index/weiboshare.png" @mouseenter="weiboshare=true" @mouseleave="weiboshare=false"
           style="margin: 5px 0;width: 50px">
      <iframe v-if="weiboshare" width="290px" height="320" style="position: absolute!important;right: 60px"
              class="share_self" frameborder="0" scrolling="no"
              src="http://widget.weibo.com/weiboshow/index.php?language=&amp;width=0&amp;height=290&amp;fansRow=2&amp;ptype=1&amp;speed=0&amp;skin=1&amp;isTitle=1&amp;noborder=1&amp;isWeibo=1&amp;isFans=0&amp;uid=3087094555&amp;verifier=1a8431ad&amp;dpc=1"></iframe>
    </div>

    <!--<b-carousel-->
    <!--id="carousel-1"-->
    <!--v-model="slide"-->
    <!--:interval="4000"-->
    <!--controls-->
    <!--indicators-->
    <!--background="#ababab"-->
    <!--img-width="1024"-->
    <!--img-height="480"-->
    <!--style="text-shadow: 1px 1px 2px #333;"-->
    <!--&gt;-->
    <!--<b-carousel-slide>-->
    <!--<img-->
    <!--slot="img"-->
    <!--class="d-block img-fluid w-100"-->
    <!--width="1024"-->
    <!--height="480"-->
    <!--src="../assets/img/index/banner.png"-->
    <!--&gt;-->
    <!--</b-carousel-slide>-->

    <!--<b-carousel-slide>-->
    <!--<img-->
    <!--slot="img"-->
    <!--class="d-block img-fluid w-100"-->
    <!--width="1024"-->
    <!--height="480"-->
    <!--src="../assets/img/index/banner.png"-->
    <!--&gt;-->
    <!--</b-carousel-slide>-->

    <!--<b-carousel-slide>-->
    <!--<img-->
    <!--slot="img"-->
    <!--class="d-block img-fluid w-100"-->
    <!--width="1024"-->
    <!--height="480"-->
    <!--src="../assets/img/index/banner.png"-->
    <!--&gt;-->
    <!--</b-carousel-slide>-->
    <!--&lt;!&ndash;<b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">&ndash;&gt;-->
    <!--&lt;!&ndash;</b-carousel-slide>&ndash;&gt;-->

    <!--&lt;!&ndash;<b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>&ndash;&gt;-->
    <!--</b-carousel>-->


    <!--PC端主页-->
    <div class="container-fluid d-none d-sm-block">
      <Modal
        v-model="videoModal"
        title="观看亚木沟视频"
        :closable="false"
        @on-cancel="closeModal">
        <div class="embed-responsive embed-responsive-16by9">
          <video :src="videoModalPath" style="width: 100%" controls="controls"></video>
        </div>
      </Modal>


      <div class="row" style="background-color: #E8E0C5;">
        <div class="col-md-12 " style="padding: 0;position: relative">
          <img src="../assets/img/index/jqjsbg.png" style="position: absolute;width: 60%">
          <div class="row" style="margin: 0">
            <div class="col-md-1" style="padding: 0;position: relative"></div>
            <div class="col-md-10" style="padding: 0;position: relative">

              <!--<div class="row"-->
              <!--style="padding: 15px 0;margin: 0;margin-top: 20px;display: flex;justify-content: center;">-->
              <!--<div class="col-md-1" style="z-index: 999;display: flex;justify-content: center;align-items: center">-->
              <!--<img src="../assets/img/index/left.png" @click="moveImg('prev')" style="width: 50%;cursor: pointer">-->
              <!--</div>-->
              <!--<div class="col-md-10" style="overflow: hidden;padding: 0;height: 100%;">-->
              <!--<div class="row" id="imgMove" style="transition: all 0.3s;width: 100%;flex-wrap: nowrap;">-->
              <!--<div class="col-md-3 imgAll" style="padding: 0 5px;height: 100%" v-for="(item,index) in imgListAll">-->
              <!--<img :src="item.path" style="width: 100%;height: 400px">-->
              <!--</div>-->
              <!--</div>-->
              <!--</div>-->
              <!--<div class="col-md-1" style="display: flex;justify-content: center;align-items: center">-->
              <!--<img src="../assets/img/index/right.png" @click="moveImg('next')" style="width: 50%;cursor: pointer">-->
              <!--</div>-->
              <!--</div>-->
              <!--</div>-->


              <div class="row" style="margin: 0">
                <div class="titleBG" style="margin: 61px 0 50px 0;width: 35%">
                  <img src="../assets/img/index/logo.png"
                       style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                  <span @mouseenter="jqCSSchange(index)" v-for="(item,index) in jq"
                        style="position: static;z-index: 111;cursor: pointer;color: #CACACA "
                        :class="item.hovered?'hoverd':''">
                     {{$t(item.text)}}
                  </span>
                </div>
              </div>
              <div class="row" style="margin: 0;height: 400px;position: relative">
                <!--<img src="../assets/img/leftBtn.png" @click="moveImg('prev')"-->
                <!--style="position: absolute;top: 50%;transform: translate(-120%,-50%);width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
                <div class="col-md-8" style="overflow: hidden;padding: 0;height: 100%;">
                  <div class="row" id="imgMove" style="transition: all 0.3s;width: 100%;flex-wrap: nowrap;">

                    <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                      <img :src="imgList[0].path" @click="toPage('jqjs',item)" class="photo1"
                           style="width: 100%;height: 400px;cursor: pointer">
                      <div
                        style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                        <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">亚木沟的由来</p>
                      </div>
                    </div>

                    <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                      <img :src="imgList[1].path" @click="toPage('jqjs',item)" class="photo1"
                           style="width: 100%;height: 400px;cursor: pointer">
                      <div
                        style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                        <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">玉带石</p>
                      </div>
                    </div>

                    <div class="col-md-4" v-if="jqIndex===0" style="width: 50%;position: relative;padding: 0 5px">
                      <img :src="imgList[2].path" @click="toPage('jqjs',item)" class="photo1"
                           style="width: 100%;height: 400px;cursor: pointer">
                      <div
                        style="transform: translateY(-100%);width: 100%;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                        <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">亚木沟的水</p>
                      </div>
                    </div>


                    <div class="col-md-4 imgAll" v-if="jqIndex===1"
                         style="padding: 0 5px;height: 100%;position: relative"
                         v-for="(item,index) in imgListAll">
                      <div>
                        <img :src="item.path" @click="toPage('jqjs',item)"
                             style="cursor: pointer;width: 100%;height: 400px">
                      </div>

                      <img src="../assets/img/play.png" @click="toPage('Detail',item)"
                           style="cursor: pointer;width: 50px;height: 50px;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%)">
                    </div>
                  </div>

                  <!--<div class="row" style="display: flex;justify-content: center;margin-top: 50px">-->
                  <!--<img src="../assets/img/leftBtn.png" @click="moveImg('prev')"-->
                  <!--style="width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
                  <!--<img src="../assets/img/rightBtn.png" @click="moveImg('next')"-->
                  <!--style="width: 50px;height: 50px;cursor: pointer">-->
                  <!--</div>-->


                  <!--<div v-for="item in imgListAll"-->
                  <!--style="border:1px solid rgba(100,74,35,1);;width: 32%;height: 582px;background-color: white">-->
                  <!--<img :src="item.path" style="width: 100%;height: 400px">-->
                  <!--&lt;!&ndash;<div&ndash;&gt;-->
                  <!--&lt;!&ndash;style="height: 15%;display: flex;justify-content: center;align-items: center;font-size:24px;font-family:MicrosoftYaHei;">&ndash;&gt;-->
                  <!--&lt;!&ndash;{{item.text}}&ndash;&gt;-->
                  <!--&lt;!&ndash;</div>&ndash;&gt;-->
                  <!--</div>-->
                </div>
                <div class="col-md-4" style="padding: 0 0 0 10px">
                  <div style="border:1px solid rgba(100,74,35,1);width: 100%;height: 400px;background-color: white">
                    <div
                      style="position: absolute;font-size:20px;color:rgba(100,74,35,1);top: -30px;">
                      {{$t('m.WBDT')}}
                    </div>
                    <iframe width="100%" height="54%" class="share_self" frameborder="0" scrolling="no"
                            src="http://widget.weibo.com/weiboshow/index.php?language=&amp;width=0&amp;height=300&amp;fansRow=2&amp;ptype=1&amp;speed=0&amp;skin=1&amp;isTitle=1&amp;noborder=1&amp;isWeibo=1&amp;isFans=0&amp;uid=3087094555&amp;verifier=1a8431ad&amp;dpc=1"></iframe>

                    <div class="row"
                         style="margin: 0;padding: 7px;background-color: #644A23;height: 45.5%;">
                      <div class="col-md-12" style="padding: 2px;font-size: 17px;color: white">
                        {{date}}
                      </div>
                      <div class="col-md-12" style="padding: 0;height: 20%;color: white;display: flex;">
                        <div :class="item.clicked?'tabbutton tabbuttonClick':'tabbutton'"
                             @click="LittletabChangeCSS(index)" v-for="(item,index) in littleTabList">
                          {{$t(item.text)}}
                        </div>
                        <div class="tabbutton"
                             onclick="window.open('https://piao.ctrip.com/ticket/dest/t1408206.html')">
                          {{$t('m.WSGP')}}
                        </div>
                      </div>
                      <div class="col-md-12" v-if="littleTabIndex==0"
                           style="padding: 0;margin-top: 5px;background-color: white">
                        <div class="row" style="margin: 0;">
                          <div class="col-md-3"
                               style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                            {{$t('m.CRP')}}
                          </div>
                          <div class="col-md-9"
                               style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;border-bottom: 2px solid #B9B9B9">
                            80{{$t('m.yuan')}}/{{$t('m.ren')}}
                          </div>
                        </div>
                        <div class="row" style="margin: 0;">
                          <div class="col-md-3"
                               style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                            {{$t('m.YDP')}}
                          </div>
                          <div class="col-md-9"
                               style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;border-bottom: 2px solid #B9B9B9">
                            65{{$t('m.yuan')}}/{{$t('m.ren')}}
                          </div>
                        </div>
                        <div class="row" style="margin: 0;">
                          <div class="col-md-3"
                               style="display: flex;justify-content: center;align-items: center;padding: 5px 0;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;">
                            {{$t('m.SRP')}}
                          </div>
                          <div class="col-md-9"
                               style="display: flex;align-items: center;padding: 5px 0 0 15px;font-size: 15px;">
                            160{{$t('m.yuan')}}/{{$t('m.ren')}}
                          </div>
                        </div>
                      </div>
                      <div class="col-md-12" v-if="littleTabIndex==1"
                           style="padding: 0;margin-top: 5px;background-color: white;">
                        <div class="row" style="margin: 0;">
                          <div class="col-md-12"
                               style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                            {{$t('m.JQFWRX')}}：0856-6622222
                          </div>
                        </div>
                        <div class="row" style="margin: 0;">
                          <div class="col-md-12"
                               style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;border-bottom: 2px solid #B9B9B9">
                            {{$t('m.JYDH')}}：0856-6627886
                          </div>
                        </div>
                        <div class="row" style="margin: 0;">
                          <div class="col-md-12"
                               style="display: flex;align-items: center;padding: 5px;color: #666666;font-size: 15px;border-right: 2px solid #B9B9B9;text-overflow: ellipsis;overflow-x: hidden; white-space: nowrap;">
                            {{$t('m.JTDZ')}}
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!--<img src="../assets/img/rightBtn.png" @click="moveImg('next')"-->
                <!--style="z-index: 999;position: absolute;right: 0;top: 50%;transform: translate(200%,-50%);width: 50px;height: 50px;cursor: pointer;margin-right: 30px">-->
              </div>
            </div>
            <div class="col-md-1" style="padding: 0;position: relative"></div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12" style="margin-top: 40px;text-align: center">
          <!--<img src="../assets/img/index/news.png" style="width: 30%">-->
          <div class="titleBG" style="width: 250px" id="news">
            <img src="../assets/img/index/logo.png"
                 style="width:110px;height: 40px;padding: 0 15px;position: static;z-index: 100">
            <span style="font-size: 21px;position: static;z-index: 110">{{$t('m.XWZW')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row" style="margin-top:50px">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="padding: 0" v-if="$i18n.locale === 'zh-CN'">
          <div class="row" style="margin: 0;display: flex;justify-content: space-between;width: 100%">

            <div class="col-md-6 photo"
                 style="height: 500px;font-size: 14px;padding: 0;max-width: 49%;flex: 0 0 49%">
              <div class="row" style="margin: 0;height: 50%;width: 100%;position: relative">
                <img :src="newsList[0].bz" @click="toPage('Detail',newsList[0])" class="photo1"
                     style="width: 100%;height: 100%;cursor: pointer">
                <div
                  style="width: 100%;position: absolute;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                  <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[0].title}}</p>
                </div>
              </div>
              <div class="row" style="height: 50%;width: 100%;margin: 0">
                <div class="col-md-6" style="padding: 0">
                  <img :src="newsList[1].bz" @click="toPage('Detail',newsList[1])" class="photo1"
                       style="width: 100%;height: 100%;cursor: pointer">
                  <div
                    style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                    <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[1].title}}</p>
                  </div>
                </div>
                <div class="col-md-6" style="padding: 0">
                  <img :src="newsList[2].bz" @click="toPage('Detail',newsList[2])" class="photo1"
                       style="width: 100%;height: 100%;cursor: pointer">
                  <div
                    style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">
                    <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[2].title}}</p>
                  </div>
                </div>
              </div>
            </div>


            <!--首页新闻的展示方式&#45;&#45;左竖一右横二-->
            <!--<div class="col-md-6 photo"-->
            <!--style="font-size: 14px;display: flex;padding: 0;max-width: 49%;flex: 0 0 49%">-->
            <!--<div style="width: 50%;position: relative">-->
            <!--<img :src="newsList[0].bz" @click="toPage('Detail',newsList[0])" class="photo1"-->
            <!--style="width: 100%;height: 100%;cursor: pointer">-->
            <!--<div-->
            <!--style="width: 100%;position: absolute;bottom:0;height: 7%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
            <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[0].title}}</p>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div style="width: 50%;height: 100%;">-->
            <!--<div style="height: 50%;position: relative">-->
            <!--<img :src="newsList[1].bz" @click="toPage('Detail',newsList[1])" class="photo1"-->
            <!--style="width: 100%;height: 100%;cursor: pointer">-->
            <!--<div-->
            <!--style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
            <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[1].title}}</p>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div style="height: 50%;position: relative">-->
            <!--<img :src="newsList[2].bz" @click="toPage('Detail',newsList[2])" class="photo1"-->
            <!--style="width: 100%;height: 100%;cursor: pointer">-->
            <!--<div-->
            <!--style="width: 100%;position: absolute;bottom:0;height: 14%;background-color: rgba(38,38,38,0.86);color: white;display: flex;justify-content: center;align-items: center;">-->
            <!--<p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">{{newsList[2].title}}</p>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->


            <div class="col-md-6 item"
                 style="max-width: 49%;flex: 0 0 49%;display: flex;flex-direction: column;justify-content: space-between;padding: 0;height: 500px;">
              <div v-for="item in jkNews" @click="toPage('Detail',item)"
                   style="cursor: pointer;height:30%;border:solid 2px #644A23;display: flex">
                <div style="width:85%;height: 100%;overflow-x: hidden;text-overflow:ellipsis;">
                  <div
                    style="margin-top: 15px;white-space: nowrap;overflow: hidden;text-overflow:ellipsis;text-align: center;height:40px;font-size:20px;color:#745D3A;line-height:40px;">
                    {{item.title}}
                  </div>
                  <div style="font-size:15px;width: 90%;margin: 3px auto 0;text-indent:48px;">
                    {{item.subTitle}}
                  </div>
                </div>
                <div
                  style="font-size:20px;width: 15%;height: 100%;background-color: #644A23;color: white;display: flex;justify-content: center;align-items: center">
                  {{item.month}}
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--英语模式下显示此新闻模块-->
        <div class="col-md-10" v-else>
          <div class="row" v-for="item in newsList"
               style="margin-bottom: 20px;display: flex;justify-content: space-between;height: 400px;border:solid 2px #644A23;">
            <div class="col-md-5" style="padding: 0">
              <img :src="item.bz" style="width:100%;height: 100%">
            </div>
            <div class="col-md-6 newsText" style="height: 60%;overflow-x: hidden;text-overflow:ellipsis;">
              <div
                style="text-align: center;font-size:20px;color:#644A23;line-height:40px;">
                {{item.title}}
              </div>
              <div v-html="item.content" style="font-size:15px;width: 90%;margin: 0 auto;text-indent:48px">
                {{item.content}}
              </div>
            </div>
            <div class="col-xs-2 col-md-1 newsMonth"
                 style="font-size:20px;height: unset;background-color: #644A23;color: white;display: flex;justify-content: center;align-items: center">
              {{item.month}}
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row">
        <div class="col-md-12 centerText" style="margin-top: 40px">
          <div @click="toPage('localNews')"
               style="cursor: pointer;font-size: 20px;width: 90px;display: flex;justify-content: center;align-items: center;color:white;padding: 5px;background-color: #745D3A">
            {{$t('m.GD')}}>
          </div>
        </div>
      </div>

      <!--<div class="row qyymg" style="margin: 170px 0 0 0">-->
      <!--<div class="col-md-12 centerText">-->
      <!--<img src="../assets/img/index/qyymg.png" style="width: 30%">-->
      <!--</div>-->
      <!--</div>-->
      <div class="row">
        <div class="col-md-12" style="margin-top: 100px;text-align: center">
          <!--<img src="../assets/img/index/news.png" style="width: 30%">-->
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width:110px;height: 40px;padding: 0 15px;position: static;z-index: 100">
            <span style="font-size: 25px;position: static;z-index: 110">{{$t('m.JQSP')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>


      <div class="row" style="margin-top:96px">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="padding: 0">
          <div class="embed-responsive embed-responsive-16by9">
            <!--<iframe height=498 width=510-->
            <!--:src='video.viPath'-->
            <!--frameborder="0" allowfullscreen></iframe>-->
            <video :src="video.viPath" style="width: 100%" controls="controls"></video>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <!--<div class="row" style="margin: 126px 0 33px 0">-->
      <!--<div class="col-md-12 centerText">-->
      <!--<img src="../assets/img/index/playYMG.png" style="width: 30%">-->
      <!--</div>-->
      <!--</div>-->

      <div class="row">
        <div class="col-md-12" style="margin-top: 96px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100;font-size: 25px">{{$t('m.JJYMG')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <!--<div class="row" style="margin-bottom: 22px">-->
      <!--<div class="col-md-4"></div>-->
      <!--<div class="col-md-4">-->
      <!--<div class="row" style="display: flex;padding: 0 15%;justify-content: space-around;align-items: center;">-->
      <!--<div class="col-md-3" v-for="(item,index) in PlayYMG"-->
      <!--style="display: flex;flex-direction: column;align-items: center;justify-content: space-between;padding: 0;height: 100px">-->
      <!--<img :src="item.imgSrc" style="width: 50px;height: 50px">-->
      <!--<div @click="tabChangeCSS(index)" :class="item.clicked?'btn btnClick':'btn'"> {{$t(item.name)}}</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-4"></div>-->
      <!--</div>-->

      <div class="row" style="margin-top: 50px">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="display: flex;justify-content: space-between;">
            <div class="col-md-4 pr" v-for="item in jdList"
                 style="padding: 0;max-width: 29%;flex: 0 0 29%">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px;border-radius: 8px 8px 0 0">
                </div>
                <div style="width: 100%;height: 340px">
                  <div
                    style="font-size:17px;color:#60C3B7;margin: 20px 0 10px 0">
                    亚木沟景点-{{item.title}}
                  </div>
                  <div
                    style="font-size:22px;color:rgba(51,51,51,1);margin-bottom: 20px">
                    {{item.title}}
                  </div>
                  <div
                    style="font-size:17px;height: 60%;margin-top: 10px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 8;overflow: hidden;text-overflow: ellipsis;">
                    {{item.text}}
                  </div>
                  <div @click="toPage('Detail',item)"
                       style="color:rgba(96,195,183,1);cursor: pointer;width:50px;margin: 10px 0 30px 0;font-size:15px;">
                    详情
                  </div>
                </div>
              </Card>
            </div>


            <!--<div class="col-md-4 pr" v-for="item in jdList"-->
            <!--style="padding: 0;max-width: 32%;flex: 0 0 32%">-->
            <!--<img :src="item.img" style="width: 100%;height: 230px">-->
            <!--<div style="border:1px solid rgba(151,151,151,1);height: 250px;">-->
            <!--<div-->
            <!--style="text-align: center;margin-top: 10px;padding-left: 15px;font-size:20px;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">-->
            <!--{{item.title}}-->
            <!--</div>-->
            <!--<div style="font-size:15px;margin-top: 10px;padding-left: 25px;height: 60%;overflow-x: hidden;text-overflow:ellipsis;">-->
            <!--{{item.text}}-->
            <!--</div>-->
            <!--&lt;!&ndash;<div class="btn"&ndash;&gt;-->
            <!--&lt;!&ndash;style="width:30%;border-radius:23px;border:1px solid rgba(255,102,0,1);color: #FF6600;margin: 10px 0 30px 25px">&ndash;&gt;-->
            <!--&lt;!&ndash;立即前往&ndash;&gt;-->
            <!--&lt;!&ndash;</div>&ndash;&gt;-->
            <!--</div>-->

            <!--</div>-->
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row">
        <div class="col-md-12" style="margin-top: 96px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100;font-size: 21px">{{$t('m.PlayInYMG')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row" style="margin-top:60px;padding: 0 0 180px 0">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="padding: 0">
          <div class="row">
            <div class="col-md-4" style="padding: 0">
              <img src="../assets/img/index/wsz.png" @click="toPage('wzymg')" style="width: 100%;cursor: pointer">
              <img src="../assets/img/index/sdty.png" @click="toPage('yzymg')" style="width: 100%;cursor: pointer">
            </div>
            <div class="col-md-4" style="padding: 0">
              <img src="../assets/img/index/ljymg.png" @click="toPage('aboutUS')" style="width: 100%;cursor: pointer">
            </div>
            <div class="col-md-4" style="padding: 0">
              <img src="../assets/img/index/zdlx.png" @click="toPage('LYGL')" style="width: 100%;cursor: pointer">
              <img src="../assets/img/index/jcbrcg.png" @click="toPage('localNews')"
                   style="width: 100%;cursor: pointer">
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>


      <!--<div class="row">-->
      <!--<div class="col-md-12 centerText" style="margin: 88px 0 14px 0">-->
      <!--<img src="../assets/img/index/slqj.png" style="width: 30%">-->
      <!--</div>-->
      <!--</div>-->

      <!--<div class="row">-->
      <!--<div class="col-md-12 centerText" style="font-size: 15px;margin-bottom:88px">-->
      <!--揭开亚木沟神秘面纱-->
      <!--</div>-->
      <!--</div>-->

      <!--<div class="row" style="margin-top:96px">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10">-->
      <!--<div class="row" style="display: flex;justify-content: space-between;align-items: center;">-->
      <!--<div class="col-md-4" style="padding: 0;">-->
      <!--<img src="../assets/img/index/img1.png" style="width: 100%">-->
      <!--<img src="../assets/img/index/img2.png" style="width: 100%">-->
      <!--</div>-->
      <!--<div class="col-md-4" style="padding: 0;">-->
      <!--<img src="../assets/img/index/img3.png" style="width: 100%">-->
      <!--</div>-->
      <!--<div class="col-md-4" style="padding: 0;">-->
      <!--<img src="../assets/img/index/img4.png" style="width: 100%">-->
      <!--<img src="../assets/img/index/img5.png" style="width: 100%">-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="row"-->
      <!--style="display: flex;align-items: center;justify-content: center;height: 70px;background-color:#60C3B7;color: white">-->
      <!--查看更多>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
      <!--</div>-->

    </div>


    <!--移动端主页-->
    <div class="container-fluid d-sm-none">
      <div class="row">
        <div class="col-12" style="padding: 0">
          <img src="../assets/img/index/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0 15px">

          <div class="row">
            <div class="col-12 topNav">
              <div class="row" style="height: 100%">
                <div v-for="item in topNavList" class="col-4" @click="toPage(item.pathName)"
                     style="padding:10px 15px ;height: 100%;display: flex;flex-direction: column;align-items: center">
                  <img :src="item.src" style="width:2.8rem;height: 2.8rem">
                  <div style="height: 45%;display: flex;justify-content: center;align-items: center;font-size: 1rem">
                    {{item.text}}
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin-bottom: 0.3rem">景区介绍</div>

          <div class="row">
            <div class="col-12" style="height: 9rem">
              <div class="row" style="height: 100%;display: flex;justify-content: space-between;">
                <div v-for="item in jqtjList" class="col-3 jqtjItem" style="max-width: 33%;flex: 0 0 33%;">
                  <img :src="item.path" @click="toPage('jqjs',item)" style="width: 100%;height: 100%">
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin-top: 1rem;margin-bottom: 0.3rem">精选美食</div>

          <div class="row">
            <div class="col-12">
              <div class="row"
                   style="background-color: white;height: 8rem;margin-bottom: 1rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
                   v-for="item in phoneFood">
                <div class="col-5" style="padding: 0">
                  <img class="imgHeight" :src="item.img" style="width: 100%;height: 100%">
                </div>
                <div class="col-7" style="padding: 0">
                  <div style="height: 100%;position: relative">
                    <div
                      style="font-weight:500;height: 20%;margin: 0.35rem 0 0.3rem 0;padding-left: 15px;font-size:1rem;color:rgba(51,51,51,1);white-space: nowrap;text-overflow: ellipsis;overflow-x: hidden">
                      {{item.title}}
                    </div>
                    <div
                      style="padding: 0 5px;color:rgba(153,153,153,1);font-size:0.8rem;margin-bottom: 0.2rem;text-indent:10px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;overflow: hidden;;">
                      {{item.content}}
                    </div>
                    <div @click="toDetail(item)"
                         style="position: absolute;bottom: 0.5rem;right:0.5rem;display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;color:rgba(255,255,255,1);height: 20%;width:59px;background:rgba(19,218,167,1);border-radius:10px;">
                      查看详情
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin-top: 1rem;margin-bottom: 0.3rem">特色商品</div>

          <div class="row">
            <div class="col-12">
              <div class="row"
                   style="background-color: white;height: 8rem;margin-bottom: 1rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
                   v-for="item in phoneGood">
                <div class="col-5" style="padding: 0">
                  <img class="imgHeight" :src="item.img" style="width: 100%;height: 100%">
                </div>
                <div class="col-7" style="padding: 0">
                  <div style="height: 100%;position: relative">
                    <div
                      style="font-weight:500;height: 20%;margin: 0.35rem 0 0.3rem 0;padding-left: 15px;font-size:1rem;color:rgba(51,51,51,1);white-space: nowrap;text-overflow: ellipsis;overflow-x: hidden">
                      {{item.title}}
                    </div>
                    <div
                      style="padding: 0 5px;color:rgba(153,153,153,1);font-size:0.8rem;margin-bottom: 0.2rem;text-indent:10px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;overflow: hidden;;">
                      {{item.content}}
                    </div>
                    <div @click="toDetail(item)"
                         style="position: absolute;bottom: 0.5rem;right:0.5rem;display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;color:rgba(255,255,255,1);height: 20%;width:59px;background:rgba(19,218,167,1);border-radius:10px;">
                      查看详情
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin-top: 1rem">景区视频</div>

          <div class="row embed-responsive embed-responsive-16by9" style="margin: 0.3rem 0 5rem 0">
            <!--<iframe height=498 width=510-->
            <!--:src='video.viPath'-->
            <!--frameborder="0" allowfullscreen></iframe>-->
            <video :src="video.viPath" style="width: 100%" controls="controls"></video>
          </div>


        </div>
      </div>

    </div>

  </div>
</template>


<script>
  var moment = require('moment')

  import {mixins} from "../common/util/mixins";

  export default {
    name: "index",
    mixins: [mixins],
    data() {
      return {
        options: {
          licenseKey: 'OPEN-SOURCE-GPLV3-LICENSE',
          onLeave: this.afterLoad,
          scrollOverflow: true,
          scrollBar: false,
          menu: false,
          // navigation: true,
          // anchors: ['page1', 'page2', 'page3'],
          // sectionsColor: ['#41b883', '#ff5f45', '#0798ec', '#fec401', '#1bcee6', '#ee1a59', '#2c3e4f', '#ba5be9', '#b4b8ab']
        },
        videoModal: false,
        slide: 0,
        weixinshare: false,
        weiboshare: false,
        jqjsList: [],
        PlayYMG: [
          {
            name: 'm.DMP',
            imgSrc: require('../assets/img/index/dmp.png'),
            clicked: true
          },
          {
            name: 'm.XMS',
            imgSrc: require('../assets/img/index/xms.png'),
            clicked: false
          },
          {
            name: 'm.ZJD',
            imgSrc: require('../assets/img/index/zjd.png'),
            clicked: false
          }
        ],
        tabYMGindex: 0,
        newsList: [],
        topNavList: [
          {
            src: require('../assets/img/index/phoneTab1.png'),
            pathName: 'onlineBooking',
            text: '在线预订'
          },
          {
            src: require('../assets/img/index/phoneTab2.png'),
            pathName: 'LYGL',
            text: '旅游攻略'
          },
          {
            src: require('../assets/img/index/phoneTab3.png'),
            pathName: 'localNews',
            text: '活动资讯'
          }
        ],
        jqtjList: [],
        // phoneNewsList: [
        //   {
        //     imgSrc: require('../assets/img/index/ymgdxg.png'),
        //     name: '亚木沟大峡谷',
        //     text: '亚木沟11亚沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟'
        //   },
        //   {
        //     imgSrc: require('../assets/img/index/ymgdxg.png'),
        //     name: '楠木馆',
        //     text: '亚木沟222亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟'
        //   },
        //   {
        //     imgSrc: require('../assets/img/index/ymgdxg.png'),
        //     name: '土王楼',
        //     text: '亚木沟3333亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟'
        //   },
        //   {
        //     imgSrc: require('../assets/img/index/ymgdxg.png'),
        //     name: '亚木沟大峡谷',
        //     text: '亚木沟11亚沟亚木沟亚木沟亚木沟亚沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟亚木沟'
        //   }
        // ],
        phoneFood: [],
        phoneGood: [],
        video: {},
        jdList: [],
        imgListAll: [],
        imgList: [
          {
            src: require('../assets/img/index/img3.png')
          },
          {
            src: require('../assets/img/index/img3.png')
          },
          {
            src: require('../assets/img/index/img3.png')
          }
        ],
        videoPhoto: [],
        num: 0,
        Date: '',
        jkNews: [],
        jqIndex: 0,
        jq: [
          {text: 'm.JQJS', hovered: true},
          {text: 'm.JQSP', hovered: false}
        ],
        littleTabIndex: 0,
        littleTabList: [
          {
            text: 'm.MPJG',
            clicked: true
          },
          {
            text: 'm.LXFS',
            clicked: false
          }
        ],
        videoModalPath: ''
      }
    },
    mounted() {
      var v = this
      var navHeight = 0;
      $(document).scroll(function () {
        navHeight = $("#carousel-1").outerHeight(true)
        if ($(this).scrollTop() > navHeight) {
          $('.navRight').css('visibility', 'visible')
        }
        else $('.navRight').css('visibility', 'hidden')
      })

      if (this.$route.params.listName) {
        this.toFixPosition('#' + this.$route.params.listName)
      }
    },
    created() {
      this.getBanner()
      this.getPhoto()
      this.getNews()
      this.getVideo()
      this.getJD()
      this.getFood()
      this.getGood()
      this.getVideoPhoto()
      this.getJKnews()
      this.date = moment().format('MM月DD日');
    },
    watch: {
      imgListAll: function () {
        this.$nextTick(function () {
          let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 10)
          $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
        })
      },
      '$i18n.locale': function () {
        this.getVideo()
        this.getPhoto()
        this.getNews()
      }
    },
    methods: {
      afterLoad(origin, destination, direction) {
        // 如果离开首页，导航就吸顶
        // console.log(destination.index)
        //如果目标是第三节，它将不会滚动
        if (destination.index == 0) {
          console.log('目标是第1节')
          $('#introduce').css('height', 'unset')
        } else {
          $('#introduce').css('height', '0')
        }
      },
      getBanner() {
        this.$http.post(this.apis.Banner.GETBANNER, this.params).then(res => {
          if (res.code === 200) {
            this.bannerList = res.page.list
          } else {

          }
        })
      },
      moveImg(dir) {
        if (this.jqIndex == 1) return
        let imgWidth = $('.imgAll').width() + 10          //这个是图片宽度+padding值=移动值
        let marginLeft = 0
        if (dir == 'next') {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) - imgWidth
        } else {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) + imgWidth
        }
        $('#imgMove').css('marginLeft', marginLeft + 'px')

        if (dir == 'next')
          this.num += 1
        else this.num -= 1
        if (this.num == 0) {
          let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 10)
          $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
        }

        if (this.num > this.imgList.length + (this.imgList.length - 3) && dir == 'next') {
          let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 10)
          $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
          this.num = 0
        }
        if (this.num < -this.imgList.length && dir != 'next') {
          let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 10)
          $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
          this.num = 0
        }

      },
      getJKnews() {
        this.$http.post(this.apis.NEWS.GETNEWS, {pageSize: '3', pageNum: '1', type: 3}).then(res => {
          if (res.code === 200) {
            this.jkNews = res.page.list

            this.jkNews.map((val, index, arr) => {
              var day = Number(moment(val.cjsj).month()) + 1;
              if (day === '13') day = 1
              switch (day) {
                case 1:
                  day = '一';
                  break;
                case 2:
                  day = '二';
                  break;
                case 3:
                  day = '三';
                  break;
                case 4:
                  day = '四';
                  break;
                case 5:
                  day = '五';
                  break;
                case 6:
                  day = '六';
                  break;
                case 7:
                  day = '七';
                  break;
                case 8:
                  day = '八';
                  break;
                case 9:
                  day = '九';
                  break;
                case 10:
                  day = '十';
                  break;
                case 11:
                  day = '十一';
                  break;
                case 12:
                  day = '十二';
                  break;
              }

              val.month = this.$i18n.locale === 'zh-CN' ? day + '月' : day
            })

          } else {

          }
        })
      },
      getNews() {
        let type = this.$i18n.locale === 'zh-CN' ? 1 : 2

        this.$http.post(this.apis.NEWS.GETNEWS, {pageSize: '3', pageNum: '1', type: type}).then(res => {
          if (res.code === 200) {
            this.newsList = res.page.list
          } else {

          }
        })
      },
      getVideo() {
        // viType: 1 是宣传片 2 是景区视频
        let lang = this.$i18n.locale === 'zh-CN' ? 'CN' : 'EN'
        this.$http.post(this.apis.Video.GETVIDEO, {viLang: lang, viType: 1}).then(res => {
          if (res.code === 200) {
            this.video = res.page.list[0]
          } else {

          }
        })
      },
      getPhoto() {
        // let type = this.$i18n.locale === 'zh-CN' ? '0' : '1'
        // this.$http.post('/api/img/pager', {type: type}).then(res => {
        //   if (res.code === 200) {
        //     this.imgList = res.page.list
        //     this.jqtjList = res.page.list
        //     this.imgListAll = this.imgList.concat(this.imgList).concat(this.imgList)
        //   } else {
        //
        //   }
        // })
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 6, type: 1}).then(res => {
          if (res.code === 200) {
            this.imgList[0] = res.page.list[0]
            this.imgList[1] = res.page.list[1]
            this.imgList[2] = res.page.list[2]
            this.jqtjList[0] = res.page.list[0]
            this.jqtjList[1] = res.page.list[1]
            this.jqtjList[2] = res.page.list[2]

            this.imgList[0].path = res.page.list[0].photo
            this.imgList[1].path = res.page.list[1].photo
            this.imgList[2].path = res.page.list[2].photo
            // this.imgListAll = this.imgList.concat(this.imgList).concat(this.imgList)
          } else {

          }
        })
      },
      getVideoPhoto() {
        this.$http.post(this.apis.Video.GETVIDEO, {viLang: 'CN'}).then(res => {
          if (res.code === 200) {
            this.videoPhoto[0] = res.page.list[0]
            this.videoPhoto[1] = res.page.list[1]
            this.videoPhoto[2] = res.page.list[2]

            this.videoPhoto[0].path = res.page.list[0].viImg
            this.videoPhoto[1].path = res.page.list[1].viImg
            this.videoPhoto[2].path = res.page.list[2].viImg
            this.imgListAll = this.videoPhoto
          } else {

          }
        })
      },
      getJD() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 1}).then(res => {
          if (res.code === 200) {
            this.jdList = res.page.list
          } else {

          }
        })
      },
      getFood() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 2}).then(res => {
          if (res.code === 200) {
            this.phoneFood = res.page.list
          } else {

          }
        })
      },
      getGood() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 5}).then(res => {
          if (res.code === 200) {
            this.phoneGood = res.page.list
          } else {

          }
        })
      },
      tabChangeCSS(index) {
        this.tabYMGindex = index;
        this.PlayYMG.map((val, index, arr) => {
          val.clicked = false
        })
        this.PlayYMG[index].clicked = true
      },
      LittletabChangeCSS(index) {
        this.littleTabIndex = index;
        this.littleTabList.map((val, index, arr) => {
          val.clicked = false
        })
        this.littleTabList[index].clicked = true
      },
      jqCSSchange(index) {
        this.jqIndex = index;
        this.jq.map((val, index, arr) => {
          val.hovered = false
        })
        this.jq[index].hovered = true
        // if (index == 0) {
        //   this.imgListAll = this.imgList.concat(this.imgList).concat(this.imgList)
        // }
        // else {
        //   this.imgListAll = this.videoPhoto.concat(this.videoPhoto).concat(this.videoPhoto)
        // }
      },
      closeModal() {
        this.videoModalPath = ''
      },
      toTop() {
        $('body,html').animate({scrollTop: 0}, 500);
      },
      toDetail(item) {
        let listName = ''
        switch (item.type) {
          case '2':
            listName = '美食';
            break;
          case '3':
            listName = '住宿';
            break;
          case '4':
            listName = '休闲娱乐';
            break;
          case '5':
            listName = '特色商品';
            break;
        }
        window.scrollTo(0, 0)
        this.$router.push({
          name: 'wzymg_Sec',
          params: {
            listName: listName,
            item: item
          }
        })
      },
      toPage(pathName, item) {
        if (item && item.viPath != undefined && item.viPath != '') {
          this.videoModal = true;
          this.videoModalPath = item.viPath
          return
        }


        $('body,html').animate({scrollTop: 0}, 500);
        $('.img-fluid').css('height', '200px')

        if (pathName === 'yzymg') $('.img-fluid').css('height', '0')

        if (pathName == 'LYGL') {
          this.$router.push({
            path: '/LYGL/0'
          })
          return
        }

        if (pathName === 'wzymg') {
          this.$router.push({
            path: '/wzymg/2'
          })
          return
        }

        if (item) {
          this.$router.push({
            name: pathName,
            params: {
              item: item
            }
          })
          return
        }

        this.$router.push({
          name: pathName
        })
      }
    }
  }
</script>

<style scoped>
  .topNav {
    height: 5rem;
    background-color: white;
    border-radius: 3%;
    top: -20px;
    box-shadow: 0px 1px 10px 0px rgba(222, 223, 211, 0.5);
  }

  .centerText {
    color: dimgray;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 15px;
  }

  .jqtjItem {
    padding: 0 5px 0 0;
  }

  .tabbutton {
    margin-right: 10px;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 5px;
    font-size: 15px;
  }

  .hoverd {
    color: white !important;
  }

  .tabbuttonClick {
    background-color: #60C3B7
  }

  @media (min-width: 992px) {

    .background {
      background-color: white !important;
    }

    /*.item {*/
      /*border-left: solid 10px white;*/
    /*}*/

    .pr {
      padding-right: 10px !important;
    }

    .qyymg {
      margin: 88px 0 4px 0 !important;
    }

    .newsText {
      height: 100% !important;
    }

    .newsMonth {
      height: 100% !important;
    }

    .bottomNav {
      height: 100%;
      flex-direction: column;
    }

    .photo {
      height: 500px;
      padding-left: 10px !important;
    }

    .photo1 {
      height: 100%;
    }
  }

  .titleBG {
    /*width:401px;*/
    height: 60px;
    background: rgba(100, 74, 35, 1);
    width: 22%;
    margin: 0 auto;
    display: flex;
    justify-content: space-around;
    align-items: center;
    font-size: 40px;
    font-family: MicrosoftYaHei;
    color: rgba(255, 255, 255, 1);
    position: relative;
  }

  .titleBG > span {
    font-size: 21px !important;
  }

  .titleBGBottom {
    height: 60px;
    width: 100%;
    border: 2px solid rgba(100, 74, 35, 1);
    position: absolute;
    left: 18px;
    top: 21px;
    z-index: 99;
  }

  .btn {
    /*padding: 2px;*/
    border-radius: 16px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 15px;
    border: solid 1px #E8E8E8;
    width: 100%;
  }

  .btnClick {
    border: solid 1px #FF6600;
    background-color: #FF6600;
    color: white;
  }

  .btnUnClick {
    border: solid 1px #E8E8E8;
  }

  .navRight {
    position: fixed;
    width: 50px;
    z-index: 999;
    /*height: 30px;*/
    right: 0;
    top: 50%;
    transform: translateY(-50%);
    visibility: hidden;
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }

  /deep/ .ivu-card {
    border-radius: 8px;
  }

  html, body {
    height: 100%;
    overflow: hidden;
  }

  .box1 {
    background-image: url("../assets/img/bgbg.png");
    background-repeat: no-repeat;
    background-size: cover;
  }


</style>
