<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" id="food" style="margin: 0;background:#E8E0C5">
        <div class="col-md-12">
          <div class="row" style="margin: 0">
            <div class="col-md-12" style="margin-top: 60px;text-align: center">
              <div class="titleBG" style="width: 250px">
                <img src="../assets/img/index/logo.png"
                     style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                <span style="position: static;z-index: 100">{{$t('m.MS')}}</span>
                <div class="titleBGBottom"></div>
              </div>
            </div>
          </div>
        </div>

        <div class="row photo" style="height: 670px;margin: 30% 0 66px 0;">
          <div class="col-md-1"></div>
          <div class="col-md-10">


            <div class="row jd">
              <div class="col-md-4 pr" v-for="item in foodList"
                   style="font-family:MicrosoftYaHei;padding: 0;max-width: 29%;flex: 0 0 29%;">
                <Card style="background: white">
                  <div slot="title">
                    <img :src="item.img" style="width: 100%;height: 230px">
                  </div>
                  <div style="width: 100%;height: 300px;">
                    <div
                      style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                      {{item.title}}
                    </div>
                    <div
                      style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                      {{item.content}}
                    </div>
                    <div class="btn" @click="toPage(item,false)"
                         style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                      {{$t('m.LJQW')}}
                    </div>
                  </div>
                </Card>
              </div>
            </div>


            <!--<div class="row" style="height: 500px;display: flex;justify-content: space-between;">-->
            <!--<div class="col-md-4 photoItem" v-for="item in foodList"-->
            <!--style="max-width: 32%;flex: 0 0 32%;margin-bottom: 0;padding: 0;">-->
            <!--<img :src="item.img" style="width: 100%;height: 40%">-->
            <!--<div style="border:1px solid rgba(151,151,151,1);height: 271px;">-->
            <!--<div-->
            <!--style="margin-top: 10px;padding-left: 15px;border-left:solid 5px #644A23;font-size:20px;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">-->
            <!--{{item.title}}-->
            <!--</div>-->
            <!--<div-->
            <!--style="font-size:15px;margin-top: 10px;padding-left: 25px;height:50%;overflow-x: hidden;text-overflow:ellipsis;">-->
            <!--{{item.content}}-->
            <!--</div>-->
            <!--<div class="btn" @click="toPage(item,false)"-->
            <!--style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 30px 25px;font-size:15px;color:rgba(255,255,255,1);">-->
            <!--{{$t('m.LJQW')}}-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->

            <div class="row" style="margin: 0;margin-top: 30px">
              <div class="col-md-12 centerText">
                <div @click="toPage({pathName:'wzymg_more',listName:'美食'},true)"
                     style="cursor: pointer;margin: 0 auto;font-size: 20px;width: 90px;display: flex;justify-content: center;align-items: center;color:white;padding: 5px;background-color: #745D3A">
                  {{$t('m.GD')}}>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-1"></div>
        </div>
      </div>


      <!--住宿-->
      <!--<div class="row itemMar" style="margin: 300% 0 0 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10" style="position: relative;text-align: center">-->
      <!--<img src="../assets/img/WZYMG/zs.png" style="top: -15%;left: 50%;transform: translateX(-50%);position: absolute;width:20%;">-->
      <!--<div style="top:30%;left: 50%;transform: translateX(-50%);position: absolute;font-size:30px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);letter-spacing:2px;">-->
      <!--住在亚木沟 感受美景-->
      <!--</div>-->
      <!--<img src="../assets/img/LYGL/bg.png" style="width:35%;">-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
      <!--</div>-->

      <div class="row" id="hotel" style="margin: 0">
        <div class="col-md-12" style="margin-top: 60px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">{{$t('m.ZS')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row photo" style="height: 670px;margin: 30% 0 66px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row jd">
            <div class="col-md-4 pr" v-for="item in hotelList"
                 style="font-family:MicrosoftYaHei;padding: 0;max-width: 28%;flex: 0 0 28%;">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.content}}
                  </div>
                  <div style="margin: 10px 0 0 0;display: flex;">
                    <div class="btn"
                         style="position: relative;margin-right: 10px;cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;font-size:15px;color:rgba(255,255,255,1);">
                      <a :href="item.booking"
                         style="color: white;position: absolute;width: 100%;height: 100%;display: flex;justify-content: center;align-items: center"
                         target="_blank">{{$t('m.LJYD')}}</a>
                    </div>
                    <div class="btn" @click="toPage(item,false)"
                         style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;font-size:15px;color:rgba(255,255,255,1);">
                      {{$t('m.LJQW')}}
                    </div>
                  </div>

                </div>
              </Card>
            </div>
          </div>

          <div class="row" style="margin: 0;margin-top: 30px">
            <div class="col-md-12 centerText">
              <div @click="toPage({pathName:'wzymg_more',listName:'住宿'},true)"
                   style="cursor: pointer;margin: 0 auto;font-size: 20px;width: 90px;display: flex;justify-content: center;align-items: center;color:white;padding: 5px;background-color: #745D3A">
                {{$t('m.GD')}}>
              </div>
            </div>
          </div>

        </div>
        <div class="col-md-1"></div>
      </div>


      <!--休闲娱乐-->
      <div class="row" id="play" style="margin: 0">
        <div class="col-md-12" style="margin-top: 60px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">{{$t('m.XXYL')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row photo" style="height: 670px;margin: 30% 0 66px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row jd">
            <div class="col-md-4 pr" v-for="item in playList"
                 style="font-family:MicrosoftYaHei;padding: 0;max-width: 29%;flex: 0 0 29%;">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.content}}
                  </div>
                  <div class="btn" @click="toPage(item,false)"
                       style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                    {{$t('m.LJQW')}}
                  </div>
                </div>
              </Card>
            </div>
          </div>

          <div class="row" style="margin: 0;margin-top: 30px">
            <div class="col-md-12 centerText">
              <div @click="toPage({pathName:'wzymg_more',listName:'休闲娱乐'},true)"
                   style="cursor: pointer;margin: 0 auto;font-size: 20px;width: 90px;display: flex;justify-content: center;align-items: center;color:white;padding: 5px;background-color: #745D3A">
                {{$t('m.GD')}}>
              </div>
            </div>
          </div>

        </div>
        <div class="col-md-1"></div>
      </div>


      <!--特色商品-->
      <div class="row" id="goods" style="margin: 0">
        <div class="col-md-12" style="margin-top: 60px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">{{$t('m.TSSP')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row photo" style="height: 670px;margin: 30% 0 66px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row jd">
            <div class="col-md-4 pr" v-for="item in goodsList"
                 style="font-family:MicrosoftYaHei;padding: 0;max-width: 29%;flex: 0 0 29%;">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.content}}
                  </div>
                  <div class="btn" @click="toPage(item,false)"
                       style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                    {{$t('m.LJQW')}}
                  </div>
                </div>
              </Card>
            </div>
          </div>

          <div class="row" style="margin: 0;margin-top: 30px">
            <div class="col-md-12 centerText">
              <div @click="toPage({pathName:'wzymg_more',listName:'特色商品'},true)"
                   style="cursor: pointer;margin: 0 auto;font-size: 20px;width: 90px;display: flex;justify-content: center;align-items: center;color:white;padding: 5px;background-color: #745D3A">
                {{$t('m.GD')}}>
              </div>
            </div>
          </div>

        </div>
        <div class="col-md-1"></div>
      </div>


      <!--交通-->
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="margin-top: 60px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100;">{{$t('m.JTXL')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row photo" style="height: 383px;margin: 30% 0 66px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="height: 100%">
            <div class="col-md-7" style="padding: 0">
              <div id="container" style="height: 100%"></div>
            </div>
            <div class="col-md-5" style="padding: 0">
              <div style="width:100%;height:100%;background:rgba(255,255,255,1);border:1px solid rgba(151,151,151,1);">
                <div
                  style="background-color: #644A23;text-align: center;font-size:25px;font-family:MicrosoftYaHei;color:white;line-height:80px;width:100%;height:80px;">
                  {{$t('m.JTZY')}}
                </div>
                <div style="padding: 30px 56px;font-size:20px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);">
                  <div>
                    {{$t('m.ZJ')}}:
                  </div>
                  <div>
                    {{$t('m.XL')}}
                  </div>
                  <div style="margin-top: 30px">
                    {{$t('m.KFSJ')}}:
                  </div>
                  <div>
                    {{$t('m.SJ')}}
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>


      <!--<div class="row" style="margin: 0">-->
      <!--<div class="col-md-12" style="margin-top: 60px;text-align: center">-->
      <!--<div class="titleBG" style="width: 250px">-->
      <!--<img src="../assets/img/index/logo.png"-->
      <!--style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">-->
      <!--<span style="position: static;z-index: 100;">自驾游</span>-->
      <!--<div class="titleBGBottom"></div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->

      <!--<div class="row photo" style="margin: 30% 0 36px 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10">-->
      <!--<div class="row jd">-->
      <!--<div class="col-md-4 pr" v-for="item in zjyList" style="font-family:MicrosoftYaHei;padding: 0;max-width: 31%;flex: 0 0 31%;">-->
      <!--<Card>-->
      <!--<div slot="title" style="font-size: 20px;padding: 10px 15px">-->
      <!--{{item.title}}-->
      <!--</div>-->
      <!--<div style="width: 100%;height: 300px;">-->
      <!--<div-->
      <!--style="font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">-->
      <!--{{item.content}}-->
      <!--</div>-->
      <!--</div>-->
      <!--</Card>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
      <!--</div>-->


      <!--<div class="row" style="margin: 0">-->
      <!--<div class="col-md-12" style="margin-top: 0;text-align: center">-->
      <!--<div class="titleBG" style="width: 250px">-->
      <!--<img src="../assets/img/index/logo.png"-->
      <!--style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">-->
      <!--<span style="position: static;z-index: 100;">自助游</span>-->
      <!--<div class="titleBGBottom"></div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->

      <!--<div class="row" style="margin: 0; ">-->
      <!--<div class="col-md-12" style="margin-top: 88px;text-align: center">-->
      <!--<div class="titleBG" style="width: 250px">-->
      <!--<img src="../assets/img/index/logo.png"-->
      <!--style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">-->
      <!--<span style="position: static;z-index: 100">{{$t('m.JCHD')}}</span>-->
      <!--<div class="titleBGBottom"></div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->

      <!--<div class="row" style="margin: 97px 0 66px 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10" style="padding: 0">-->
      <!--<img src="../assets/img/WZYMG/jchd.png" style="width: 100%">-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
      <!--</div>-->
    </div>


    <div class="container-fluid d-sm-none" style="padding: 0">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%;">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <!--<img src="../assets/img/index/left.png" style="margin-left: 22px;width: 1rem;height: 80%" @click="toPage('index')">-->
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              玩转亚木沟
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="row"
           style="margin: 0;width: 100%;overflow-x: scroll;height: 3rem;display: flex;flex-wrap: nowrap !important;">
        <div class="col-4" v-for="(item,index) in tabYMG" @click="tabChangeCSS(index)"
             :class="item.clicked?'phoneTab phoneTabClick':'phoneTab'">
          {{$t(item.name)}}
          <div v-if="item.clicked"
               style="position: absolute;bottom: 0;left: 50%;transform: translateX(-50%);width:24px;height:4px;background:rgba(19,218,167,1);border-radius:2px;"></div>
        </div>
      </div>


      <div class="row" style="margin: 0;margin-bottom: 5rem">
        <div class="col-12">
          <div class="row"
               style="border-radius: 0.5rem;margin:1rem 0;background-color: white;height: 8rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
               v-for="item in phoneList">
            <div class="col-5" style="padding: 0;">
              <img class="imgHeight" :src="item.img" style="border-radius:0.5rem 0 0 0.5rem;width: 100%;height: 100%">
            </div>
            <div class="col-7" style="padding: 0">
              <div style="height: 100%;position: relative">
                <div
                  style="font-weight:500;height: 30%;margin: 0.2rem 0 0.1rem 0;padding-left: 15px;font-size:1rem;color:rgba(51,51,51,1);white-space: nowrap;text-overflow: ellipsis;overflow-x: hidden">
                  {{item.title}}
                </div>
                <div v-html="item.content"
                     style="color:rgba(153,153,153,1);font-size:0.8rem;margin-bottom: 0.2rem;height: 30%;text-indent:0.3rem;overflow-y: hidden;">
                  {{item.content}}
                </div>
                <div style="position: absolute;bottom: 0.5rem;right:0.5rem;display: flex">
                  <div class="btn" v-if="tabYMGindex===1"
                       style="padding: 0.65rem;position: relative;margin-right: 10px;cursor: pointer;width: 59px;height: 20%;border-radius:10px;background-color: rgba(19,218,167,1);font-size:15px;color:rgba(255,255,255,1);border: none">
                    <a :href="item.booking"
                       style="font-size:0.6rem;font-weight:400;color: white;width: 100%;height: 100%;position: absolute;display: flex;justify-content: center;align-items: center;"
                       target="_blank">在线预订</a>
                  </div>
                  <div @click="toPage(item)"
                       style="padding: 3px 5px;display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;color:rgba(255,255,255,1);height: 20%;width:59px;background:rgba(19,218,167,1);border-radius:10px;">
                    立即前往
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
  import {mixins} from "../common/util/mixins";

  export default {
    name: "wzymg",
    mixins: [mixins],
    data() {
      return {
        foodList: [],
        hotelList: [],
        playList: [],
        goodsList: [],
        phoneList: [],
        tabYMGindex: 0,
        tabYMG: [
          {
            name: '特色美食',
            clicked: true
          },
          {
            name: '酒店设施',
            clicked: false
          },
          {
            name: '休闲娱乐',
            clicked: false
          },
          {
            name: '特色商品',
            clicked: false
          }
        ]
      }
    },
    created() {
      this.getFood()
      this.getHotel()
      this.getGoods()
      this.getPlay()
      this.getList()
    },
    methods: {
      getFood() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 2}).then(res => {
          if (res.code === 200) {
            this.foodList = res.page.list
          } else {

          }
        })
      },
      getHotel() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 3}).then(res => {
          if (res.code === 200) {
            this.hotelList = res.page.list
          } else {

          }
        })
      },
      getPlay() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 4}).then(res => {
          if (res.code === 200) {
            this.playList = res.page.list
          } else {

          }
        })
      },
      getGoods() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 3, type: 5}).then(res => {
          if (res.code === 200) {
            this.goodsList = res.page.list
          } else {

          }
        })
      },
      getList() {
        let type = Number(this.tabYMGindex) + 2
        this.$http.post(this.apis.JD.GETJD, {type: type}).then(res => {
          if (res.code === 200) {
            this.phoneList = res.page.list
          } else {

          }
        })
      },
      tabChangeCSS(index) {
        this.tabYMGindex = index;
        this.getList()
        this.tabYMG.map((val, index, arr) => {
          val.clicked = false
        })
        this.tabYMG[index].clicked = true
      },
      // isChange:跳转页面是否为动态路由页面
      toPage(item, isChange) {
        $('body,html').animate({scrollTop: 0}, 500);
        if (isChange) {
          this.$router.push({
            path: '/' + item.pathName + '/' + item.listName
          })
        }
        else {
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
          this.$router.push({
            name: 'wzymg_Sec',
            params: {
              listName: listName,
              item: item
            }
          })
        }
      }
    },
    mounted() {
      if (this.$route.params.listName) {
        let positionId = '';
        switch (this.$route.params.listName) {
          case '美食':
            positionId = 'food';
            break;
          case '住宿':
            positionId = 'hotel';
            break;
          case '休闲娱乐':
            positionId = 'play';
            break;
          case '特色商品':
            positionId = 'goods';
            break;
        }
        this.toFixPosition('#' + positionId)
      }


      var map = new BMap.Map("container");
      var point = new BMap.Point(108.746929, 27.787269);
      map.centerAndZoom(point, 15);
      var marker = new BMap.Marker(point);        // 创建标注
      map.addOverlay(marker);
      var opts = {anchor: BMAP_ANCHOR_TOP_LEFT}
      map.addControl(new BMap.NavigationControl(opts));
    }
  }
</script>

<style scoped>
  .btn {
    /*padding: 2px;*/
    /*border-radius:29px;*/
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 15px;
    border: solid 1px #644A23;
    width: 80%;
    height: 58px;
    /*height: 25px;*/
  }

  .jd {
    display: flex;
    justify-content: space-between;
    flex-wrap: nowrap;
    overflow-x: auto;
    margin: 20px 0 0 0;
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }

  @media (min-width: 992px) {
    .photo {
      margin: 70px 0 0 0 !important;
    }

    .photoItem {
      padding-right: 10px !important;
    }

    .itemMar {
      margin: 144px 0 0 0 !important;
    }

    .jt {
      height: 100% !important;
    }
  }

  .titleBG {
    /*width:401px;*/
    height: 60px;
    max-width: 32% !important;
    flex: 0 0 32% !important;
    background: rgba(100, 74, 35, 1);
    width: 25%;
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
    font-size: 30px;
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

  .phoneTab {
    position: relative;
    font-size: 14px;
    font-weight: 400;
    color: rgba(102, 102, 102, 1);
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center
  }

  .phoneTabClick {
    font-size: 16px;
    font-weight: 600;
    color: rgba(51, 51, 51, 1);
  }
</style>
