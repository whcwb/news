<template>
  <div style="background-color: #E8E0C5;font-family:MicrosoftYaHei;">

    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" style="margin: 0;padding: 0 0 121px 0">
        <div class="col-md-12" style="margin-top: 88px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100;font-size: 20px">{{$t('m.Booking')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <div class="row" style="margin: 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row jd">
            <div class="col-md-4 pr" v-for="item in goodsList" :style="{visibility:item.isEmpty===1?'hidden':'visible'}"
                 style="margin-bottom: 30px;padding: 0;max-width: 29%;flex: 0 0 29%;">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 170px;">
                  <div
                    style="font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                    {{item.title}}
                  </div>
                  <div v-html="item.content"
                    style="font-size:17px;margin-top: 5px;height: 50px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;">
                    {{item.content}}
                  </div>
                  <div
                    style="margin: 5px 0;font-size:20px;color:#FF721C">
                    ￥{{item.price}}
                  </div>
                  <div style="display: flex">
                    <div class="btn"
                         style="position: relative;margin-right: 10px;cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;font-size:15px;color:rgba(255,255,255,1);">
                      <a :href="item.booking" style="color: white;top: 0;left: 0;position: absolute;width: 100%;height: 100%;display: flex;justify-content: center;align-items: center" target="_blank">{{$t('m.LJYD')}}</a>
                    </div>
                    <div @click="toPage('onlineBookingDetail',item)"
                         style="cursor: pointer;width:100px;line-height: 40px;text-align: center;height:40px;border:1px solid #644A23;">
                      {{$t('m.CKXQ')}}
                    </div>
                  </div>
                </div>
              </Card>
            </div>
          </div>

        </div>
        <div class="col-md-1"></div>
      </div>

      <!--<div class="row" style="margin: 0 0 0 0;padding: 0 0 180px 0">-->
        <!--<div class="col-md-1"></div>-->
        <!--<div class="col-md-10">-->
          <!--<div class="mt-3">-->
            <!--<b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center">-->
              <!--<div slot="first-text" class="pageBtn">{{$t('m.DYY')}}</div>-->
              <!--<div slot="prev-text" class="pageBtn">{{$t('m.SYY')}}</div>-->
              <!--<div slot="next-text" class="pageBtn">{{$t('m.XYY')}}</div>-->
              <!--<div slot="last-text" class="pageBtn">{{$t('m.WY')}}</div>-->
            <!--</b-pagination>-->
          <!--</div>-->
        <!--</div>-->
        <!--<div class="col-md-1"></div>-->
      <!--</div>-->
    </div>

    <!--移动端-->
    <div class="container-fluid d-sm-none" style="background:rgba(249,249,249,1);padding: 0;margin-bottom: 4rem">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('index')">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              在线预订
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>


      <div class="row" style="margin: 0">
        <div class="col-12">
          <div class="row"
               style="border-radius: 0.5rem;margin:1rem 0;background-color: white;height: 8rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
               v-for="item in goodsListPhone">
            <div class="col-5" style="padding: 0;">
              <img class="imgHeight" :src="item.img" style="border-radius:0.5rem 0 0 0.5rem;width: 100%;height: 100%">
            </div>
            <div class="col-7" style="padding: 0">
              <div style="height: 100%;position: relative">
                <div
                  style="font-weight:500;height: 30%;margin: 0.2rem 0 0.1rem 0;padding-left: 15px;font-size:1rem;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">
                  {{item.title}}
                </div>
                <div v-html="item.content"
                  style="color:rgba(153,153,153,1);font-size:0.7rem;margin-bottom: 0.2rem;height: 30%;text-indent:0.3rem;overflow-y: hidden;">
                  {{item.content}}
                </div>
                <div style="position: absolute;bottom: 0.5rem;right:0.5rem;display: flex">
                  <!--<div-->
                    <!--onclick="window.open(item.booking)"-->
                    <!--style="padding: 4px 5px;margin-right: 1rem;display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;color:rgba(255,255,255,1);height: 20%;width:59px;background:rgba(19,218,167,1);border-radius:10px;">-->
                    <!--立即预定-->
                  <!--</div>-->
                  <div style="position: relative;margin-right: 1rem;width:59px;height:25px;border-radius:10px;background-color: rgba(19,218,167,1);font-size:0.6rem;font-weight:400;">
                    <a :href="item.booking" style="color:white;top: 0;left: 0;position: absolute;width: 100%;height: 100%;display: flex;justify-content: center;align-items: center" target="_blank">{{$t('m.LJYD')}}</a>
                  </div>
                  <div @click="toPage('onlineBookingDetail',item)"
                       style="padding: 3px 5px;color:rgba(19,218,167,1);display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;height: 25px;width:65px;border: 1px solid rgba(19,218,167,1);border-radius:10px;">
                    查看详情
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
    name: "onlineBooking",
    mixins: [mixins],
    data() {
      return {
        perPage: 6,
        currentPage: 1,
        rows: 6,
        goodsList: [],
        goodsListPhone: []
      }
    },
    watch: {
      currentPage(val) {
        this.getJD()
      },
    },
    methods: {
      toPage(pathName, item) {
        $('body,html').animate({scrollTop: 0}, 500);
        this.$router.push({
          name: pathName,
          params: {
            item: item
          }
        })
      },
      getJD() {
          this.$http.post(this.apis.MP.GETMP).then(res => {
          if (res.code === 200) {
            this.goodsListPhone=JSON.parse(JSON.stringify(res.page.list))
            this.goodsList = JSON.parse(JSON.stringify(res.page.list))
            this.rows = res.page.total
            if(this.goodsList.length%2!=0&&this.goodsList.length%3!=0){
              this.goodsList.push({isEmpty:1})
            }
          } else {

          }
        })
      }
    },
    created() {
      this.getJD()
    },
    mounted() {
    }
  }
</script>

<style scoped>
  .item {
    width: 100%;
    height: 100%;
    background: rgba(255, 255, 255, 1);
    border: 1px solid rgba(151, 151, 151, 1);
    padding: 0 14px 0 45px;
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
    border-color:  #644A23 !important;
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

  /deep/ .page-link{
    font-size: 17px !important;
  }

  @media (min-width: 992px) {
    .mar {
      margin-top: 0 !important;
    }

    .imgHeight {
      height: 100%;
      width: unset;
    }
  }

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

</style>
