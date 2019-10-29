<template>
  <div style="background-color: #E8E0C5;font-family:MicrosoftYaHei;">

    <!--PC端-->
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" id="lygl" style="margin: 0">
        <div class="col-md-12" style="margin-top: 88px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">{{$t('m.TravelGuides')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <!--<div class="row tabChange" style="margin: 20% 0 0 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10">-->
      <!--<div class="row" style="display: flex;padding: 0 15%;justify-content: space-between;align-items: center;">-->
      <!--<div class="col-md-3" v-for="(item,index) in PlayYMG"-->
      <!--style="display: flex;flex-direction: column;align-items: center;justify-content: space-between;padding: 0;height: 100px">-->
      <!--<div @click="tabChangeCSS(index)" :class="item.clicked?'btn btnClick':'btn'"> {{$t(item.name)}}</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
      <!--</div>-->


      <div class="row" style="height: 1252px;margin: 100px 0 0 0;">
        <div class="col-md-1 d-none d-sm-block"></div>
        <div class="col-md-10">
          <div class="row jd" style="height: 670px;margin: 0 0 66px 0;">
            <div class="col-md-4 pr" v-for="item in tabPlayYMGList" :style="{visibility:item.isEmpty===1?'hidden':'visible'}"
                 style="margin-bottom: 30px;font-family:MicrosoftYaHei;padding: 0;max-width: 29%;flex: 0 0 29%;">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);overflow: hidden;white-space: nowrap;text-overflow: ellipsis">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.subTitle}}
                  </div>
                  <div class="btn" @click="toPage(item,false)"
                       style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                    {{$t('m.LJQW')}}
                  </div>
                </div>
              </Card>
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row pageLink" style="margin: 625% 0 0 0;padding: 0 0 180px 0">
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


    <!--移动端-->
    <div class="container-fluid d-sm-none" style="padding: 0;background:rgba(249,249,249,1);">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('index')">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              旅游攻略
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>


      <div class="row" style="margin: 0;height: 3rem;">
        <div class="col-4" v-for="(item,index) in PlayYMG" @click="tabChangeCSS(index)"
             :class="item.clicked?'phoneTab phoneTabClick':'phoneTab'">
          {{$t(item.name)}}
          <div v-if="item.clicked"
               style="left: 50%;transform: translateX(-50%);position: absolute;bottom: 0;width:24px;height:4px;background:rgba(19,218,167,1);border-radius:2px;"></div>
        </div>
      </div>

      <div class="row" style="margin: 0">
        <div class="col-12">
          <div class="row"
               style="border-radius: 0.5rem;margin:1rem 0;background-color: white;height: 8rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
               v-for="item in tabPlayYMGList1">
            <div class="col-5" style="padding: 0;">
              <img class="imgHeight" :src="item.img" style="border-radius:0.5rem 0 0 0.5rem;width: 100%;height: 100%">
            </div>
            <div class="col-7" style="padding: 0">
              <div style="height: 100%;position: relative">
                <div
                  style="font-weight:500;height: 30%;margin: 0.2rem 0 0.1rem 0;padding-left: 15px;font-size:1rem;color:rgba(51,51,51,1);white-space: nowrap;text-overflow: ellipsis;overflow-x: hidden">
                  {{item.title}}
                </div>
                <div  style="color:rgba(153,153,153,1);font-size:0.8rem;margin-bottom: 0.2rem;height: 30%;text-indent:0.3rem;overflow-y: hidden;">
                  {{item.subTitle}}
                </div>
                <div style="position: absolute;bottom: 0.5rem;right:0.5rem;display: flex">
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
    name: "LYGL",
    mixins: [mixins],
    watch: {
      '$route'(to, from) {
        if (this.$route.params.listName) {
          this.tabYMGindex = this.$route.params.listName
          this.getGL()
          this.PlayYMG.map((val, index) => {
            val.clicked = false
          })
          this.PlayYMG[this.tabYMGindex].clicked = true
        }
      },
      currentPage(val) {
        this.getGL()
      },
    },
    data() {
      return {
        perPage: 6,
        currentPage: 1,
        rows: 6,
        PlayYMG: [
          {
            name: '精选攻略',
            clicked: true
          },
          {
            name: '路线指南',
            clicked: false
          },
          {
            name: '自驾游线路',
            clicked: false
          }
        ],
        tabYMGindex: 0,
        tabPlayYMGList: [],
        tabPlayYMGList1: []
      }
    },
    created() {
      if (this.$route.params.isFix) {
        this.toFixPosition('#lygl')
      }

      if (this.$route.params.listName) {
        this.tabYMGindex = this.$route.params.listName
        this.getGL()
        this.PlayYMG.map((val, index) => {
          val.clicked = false
        })
        this.PlayYMG[this.tabYMGindex].clicked = true
        return
      }
      if (this.$route.params.tabYMGindex) {
        this.tabYMGindex = this.$route.params.tabYMGindex
        this.getGL()
        this.PlayYMG.map((val, index) => {
          val.clicked = false
        })
        this.PlayYMG[this.tabYMGindex].clicked = true
        return
      }
      this.getGL()
    },
    methods: {
      getGL() {
        this.$http.post(this.apis.GL, {pageNum: this.currentPage, pageSize: 6}).then(res => {
          if (res.code === 200) {
            window.scrollTo(0,0)
            this.tabPlayYMGList = res.page.list
            this.rows = res.page.total
            if(this.tabPlayYMGList%2!=0){
              this.tabPlayYMGList.push({isEmpty:1})
            }
          } else {

          }
        })

        this.$http.post(this.apis.GL, {type: Number(this.tabYMGindex) + 1}).then(res => {
          if (res.code === 200) {
            this.tabPlayYMGList1 = res.page.list
          } else {

          }
        })
      },
      tabChangeCSS(index) {
        this.tabYMGindex = index;
        this.getGL()
        this.PlayYMG.map((val, index, arr) => {
          val.clicked = false
        })
        this.PlayYMG[index].clicked = true
      },
      toPage(item) {
        $('body,html').animate({scrollTop: 0}, 500);
        if (item == 'index') {
          this.$router.push({
            name: item
          })
          return
        }

        this.$router.push({
          name: 'LYGL_Sec',
          params: {
            tabYMGindex: this.tabYMGindex,
            item: item
            // name: this.PlayYMG[this.tabYMGindex].name
          }
        })
      }
    }
  }
</script>

<style scoped>
  @media (min-width: 992px) {
    .tabChange {
      margin: 94px 0 0 0 !important;
    }

    .itemList {
      padding-right: 10px !important;
    }

    .pageLink {
      margin: 0 !important;
    }
  }

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

  .btnClick {
    background-color: #644A23;
    color: white;
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

  /*.pageBtn {*/
    /*display: flex;*/
    /*justify-content: center;*/
    /*align-items: center;*/
    /*width: 146px;*/
    /*height: 48px;*/
    /*color: white !important;*/
    /*background-color: #644A23;*/
  /*}*/

  /deep/ .page-item.active .page-link {
    background-color: #644A23 !important;
    border-color: #644A23 !important;
    color: white !important;
  }

  /*/deep/ .page-link {*/
    /*border: none !important;*/
    /*color: #644A23;*/
    /*background-color: #E8E0C5 !important;*/
  /*}*/

  /*.pagination {*/
    /*align-items: center;*/
  /*}*/

  .titleBG {
    /*width:401px;*/
    height: 70px;
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
    height: 70px;
    width: 100%;
    border: 2px solid rgba(100, 74, 35, 1);
    position: absolute;
    left: 18px;
    top: 21px;
    z-index: 99;
  }

  .jd {
    display: flex;
    justify-content: space-between;
    margin: 20px 0 0 0;
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }

  /deep/ .page-link{
    font-size: 17px !important;
  }

</style>
