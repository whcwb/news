<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" id="food" style="margin: 0;">

        <div class="row" style="margin: 68px  0 50px 0;">
          <div class="col-md-1"></div>
          <div class="col-md-10">


            <div class="row">
              <div class="col-md-2" style="padding: 0;display: flex;flex-direction: column;align-items: flex-end">
                <div v-for="(item,index) in tabYMG" @click="tabChangeCSS(index)"
                     :class="item.clicked?'tabBtn tabBtnClick':'tabBtn'">
                  <span>{{$t(item.name)}}</span>
                  <img src="../assets/img/choose.png" v-if="item.clicked" style="width: 15px;height: 15px">
                </div>
              </div>
              <div class="col-md-10">
                <div class="row jd" style="margin-top: 0" v-if="tabYMGindex!=tabYMG.length-1">
                  <div class="col-md-4" v-for="item in pcList"
                       style="padding: 0;max-width: 32%;flex: 0 0 32%;margin-bottom: 30px">
                    <Card style="background: white">
                      <div slot="title">
                        <img :src="item.img" style="width: 100%;height: 230px">
                      </div>
                      <div style="width: 100%;height: 200px;">
                        <div
                          style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                          {{item.title}}
                        </div>
                        <div
                          style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 100px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp:4;overflow: hidden;">
                          {{item.content}}
                        </div>
                        <div style="margin: 10px 0 0 0;display: flex;">
                          <div class="btn" v-if="tabYMGindex==1"
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

                <div class="col-md-12" v-else
                     style="padding: 0;margin-bottom: 30px">

                  <div class="row" style="height: 130px;margin: 0 0 30px 0;">
                    <div class="col-md-12">
                      <div class="row">
                        <Card style="font-size: 20px;width: 100%">
                          <p style="padding: 10px 0">
                            亚木沟公路交通因为杭瑞高速（G56）而非常便利，驾驶到江口收费站下高速，经县城走县道X508，出县城大约十分钟能到云舍，再十多分钟能到亚木沟，又十分钟到寨沙侗寨，又五分钟到梵净山。一路都有路牌指示。</p>
                        </Card>
                      </div>
                    </div>
                  </div>

                  <div class="row" style="margin: 60px 0 30px 0;">
                    <div class="col-md-12">
                      <div class="row jd">
                        <div class="col-md-4 pr" v-for="item in zjyList"
                             style="font-family:MicrosoftYaHei;padding: 0;max-width: 31%;flex: 0 0 31%;">
                          <Card>
                            <div slot="title" style="font-size: 20px;padding: 10px 15px">
                              {{item.title}}
                            </div>
                            <div style="width: 100%;height: 300px;">
                              <div
                                style="font-size:17px;margin-top: 10px;height: 100%;overflow-y:hidden;">
                                {{item.content}}
                              </div>
                            </div>
                          </Card>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="row photo" style="height: 200px;margin: 60px 0 66px 0;">
                    <div class="col-md-12">
                      <div class="row" style="height: 100%">
                        <Card style="font-size: 20px;width: 100%">
                          <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">普通列车</span>可查询全国至铜仁、怀化、玉屏三站点列车时刻。
                          </p>

                          <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">贵广高铁</span>已全线贯通，两广方向游客可高铁直达贵阳。
                          </p>

                          <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">沪昆高铁</span>上海至贵阳段已通车，湖南湖北山东安徽江西及江浙地区沿线游客可高铁直达铜仁。
                          </p>
                        </Card>
                      </div>
                    </div>
                  </div>

                  <div class="row photo" style="margin: 60px 0 30px 0;">
                    <div class="col-md-12">
                      <div class="row jd">
                        <div class="col-md-4 pr" v-for="item in xlList"
                             style="font-family:MicrosoftYaHei;padding: 0;max-width: 31%;flex: 0 0 31%;">
                          <Card>
                            <div slot="title" style="font-size: 20px;padding: 10px 15px">
                              {{item.title}}
                            </div>
                            <div style="width: 100%;height: 300px;">
                              <div v-html="item.content"
                                   style="font-size:17px;margin-top: 10px;height: 100%;overflow-y: hidden">
                                {{item.content}}
                              </div>
                            </div>
                          </Card>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>


            </div>

          </div>
          <div class="col-md-1"></div>
        </div>
      </div>

      <div class="row pageLink" style="margin: 0 0 0 0;padding: 0 0 80px 0">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="mt-3">
            <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center">
              <div slot="first-text" class="pageBtn">{{$t('m.DYY')}}</div>
              <div slot="prev-text" class="pageBtn">{{$t('m.SYY')}}</div>
              <div slot="next-text" class="pageBtn">{{$t('m.XYY')}}</div>
              <div slot="last-text" class="pageBtn">{{$t('m.WY')}}</div>
            </b-pagination>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
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
        pcList: [],
        phoneList: [],
        tabYMGindex: 0,
        tabYMG: [
          {
            name: 'm.TSMS',
            clicked: true
          },
          {
            name: 'm.JDSS',
            clicked: false
          },
          {
            name: 'm.XXYL',
            clicked: false
          },
          {
            name: 'm.TSSP',
            clicked: false
          },
          {
            name: 'm.JTXL',
            clicked: false
          }
        ],
        perPage: 6,
        currentPage: 1,
        rows: 6,
        zjyList: [
          {
            title: '贵阳出发',
            content: '沿贵阳环城高速绕行一小段贵遵高速复线进入贵瓮高速，行驶约71公里经瓮安后转入安江高速往江口方向行驶144公里后进入杭瑞高速G56梵净山东下高速，继续沿X508直行5公里即可抵达亚木沟景区。全程约3小时。'
          },
          {
            title: '重庆出发',
            content: '经兰海高速抵达遵义后经观音寺隧道，遵义一环线驶入杭瑞高速G56向铜仁方向行驶，过湄潭、德江、思南、印江后从梵净山东下高速，继续沿X508直行5公里即可抵达亚木沟景区。全程约6.5小时。'
          },
          {
            title: '长沙出发',
            content: '沿长张高速/G5513行驶（经长沙西收费站），抵达常德后由进入G56杭瑞高速吉首方向行驶，（经凤凰收费站）后继续往铜仁方向行驶，（经铜仁收费站）后往遵义方向行驶，在江口出口下高速，右转进入梵净山大道行驶约5公里到达景区门口。全程约6.5个小时。（距离凤凰古城约1.5小时车程）'
          }
        ],
        xlList: [
          {
            title: '客车',
            content: '1、铜仁客车站\n<br>' +
              '铜仁—江口县，二十分钟一班，全程48公里，车程半个多小时。\n <br>' +
              '车站地址：大庆中路，锦江兴市桥附近\n<br>' +
              '公交车：4路；5路\n' +
              '<br>2、江口县汽车站\n<br>' +
              '江口—亚木沟，可乘坐江口到梵净山的班车，在亚木沟或者寨抱村下，全程大约20公里，车程大约二十分钟。\n<br>' +
              '车站地址：江口县三星西路\n'
          },
          {
            title: '火车',
            content: '铜仁火车站\n<br>' +
              '经过铜仁火车站列车共有十趟，多为K字头\n' +
              '<br>地址：位于碧江区环北街道办事处桐梓坳（东太大道、清水大道、南岳路三条道路的交叉路口）。\n' +
              '<br>公交车：4路；7路；9路\n'
          },
          {
            title: '飞机',
            content: '铜仁凤凰机场\n<br>' +
              '铜仁凤凰机场距铜仁市城区21公里，距凤凰县城34公里，为铜仁市和湘西州共享的机场。\n'
          }
        ],
      }
    },
    watch: {
      '$route'(to, from) {
        if (this.$route.params.type) {
          this.tabYMGindex = this.$route.params.type - 2;
          this.tabYMG.map((val, index, arr) => {
            val.clicked = false
          })
          this.tabYMG[this.tabYMGindex].clicked = true
          this.currentPage = 1
          this.rows = 1
          this.getData()
          this.getList()
        }
      },
      currentPage(val) {
        this.getData()
      },
    },
    methods: {
      getData() {
        let type = this.tabYMGindex + 2
        this.$http.post(this.apis.JD.GETJD, {pageNum: this.currentPage, pageSize: 6, type: type}).then(res => {
          if (res.code === 200) {
            this.pcList = res.page.list
            this.rows = res.page.total
            window.scrollTo(0, 0)
          } else {

          }
        })
      },
      getFood() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 6, type: 2}).then(res => {
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
        // this.tabYMGindex = index;
        // this.tabYMG.map((val, index, arr) => {
        //   val.clicked = false
        // })
        // this.tabYMG[index].clicked = true
        // if(index!=this.tabYMG.length-1) this.getData()
        // else {
        //   this.currentPage=1
        //   this.rows=1
        // }

        let type = index + 2
        this.$router.push({
          path: '/' + 'wzymg' + '/' + type
        })
        // this.getList()
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
      if (this.$route.params.type) {
        // this.tabChangeCSS(this.$route.params.type-2)
        this.tabYMGindex = this.$route.params.type - 2;
        this.tabYMG.map((val, index, arr) => {
          val.clicked = false
        })
        this.tabYMG[this.tabYMGindex].clicked = true
        // if(this.$route.params.type-2!=this.tabYMG.length-1) this.getData()
      }
      // else
      this.getData()
      this.getList()

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


      // var map = new BMap.Map("container");
      // var point = new BMap.Point(108.746929, 27.787269);
      // map.centerAndZoom(point, 15);
      // var marker = new BMap.Marker(point);        // 创建标注
      // map.addOverlay(marker);
      // var opts = {anchor: BMAP_ANCHOR_TOP_LEFT}
      // map.addControl(new BMap.NavigationControl(opts));
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
    margin: 20px 0 0 0;
  }

  .tabBtn {
    cursor: pointer;
    margin-bottom: 10px;
    font-size: 17px;
    color: rgba(255, 255, 255, 1);
    width: 80%;
    height: 50px;
    background: rgba(100, 74, 35, 1);
    opacity: 0.5019;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .tabBtnClick {
    opacity: 1;
    width: 100%;
    height: 60px;
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

  /deep/ .page-link {
    font-size: 17px !important;
  }
</style>
