<template>
  <div style="font-family:MicrosoftYaHei;">
    <!--<div class="row" style="margin: 0;">-->
      <!--<div class="col-md-12" style="padding: 0">-->
        <!--<img src="../assets/img/banner.png" style="width: 100%">-->
      <!--</div>-->
    <!--</div>-->

    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" style="margin: 43px 0 90px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="font-size:20px;font-family:MicrosoftYaHei;margin: 10px 0 0 10px">
            <span @click="toPage('onlineBooking',false)">{{$t('m.Booking')}}></span><span @click="toPage('onlineBooking',true)">{{$t('m.CKXQ')}}></span>
            <span style="color:#644A23;">{{item.title}}</span>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row" style="margin: 50px 0 10px 0;padding: 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="padding: 0">
          <div style="margin-bottom: 30px;height: 338px;display: flex;justify-content: space-between;">
            <img :src="item.img" style="width: 40%;height: 100%;">
            <div class="item">
              <div
                style="margin: 29px 0 10px 0;font-size:20px;color:rgba(51,51,51,1);">
                {{item.title}}
              </div>
              <p style="font-size:16px;margin-bottom: 10px">景点地址 铜仁市江口县太平镇寨抱村</p>
              <p style="font-size:16px;margin-bottom: 10px">开放时间 全年 08:00-18:00。</p>
              <p style="font-size:16px;margin-bottom: 10px;height: 40%;overflow: hidden">亚木沟风景区位于贵州省铜仁市江口县境内梵净山脚下，是梵净山生态文化旅游的重点卫星景点。景区分为生态停车场、四星级酒店（待建）、乡村风情长廊（目前规划中）、购物街、亚木沟原始生态峡谷、土家风情园、明朝古寨（待建）等几大板块，满足旅游者吃、住、行、游、购、娱各方面需求。游客既可以欣赏原始的自然风光，又可以领略原生态的土家文化诸如原生态歌舞表演、民间绝技、土家风俗等。</p>
              <div style="display: flex">
                <div onclick="window.open('https://piao.ctrip.com/ticket/dest/t1408206.html?allianceid=866656&sid=1435004')" style="margin-right: 28px;bottom: 0;text-align: center;font-size:15px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);line-height:40px;width:100px;height:40px;background-color: #644A23;">
                  {{$t('m.LJYD')}}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row" style="margin: 0 0 30px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10"
             style="padding-left: 31px;display: flex;height:160px;border:1px solid rgba(151,151,151,1);">
          <div style="width: 106px;height: 106px;position: relative;font-size:22px;color:rgba(255,255,255,1);letter-spacing:1px;height: 106px;margin-right: 21px;">
            <div style="left: 50%;top: 10px;transform: translateX(-50%);width: 48px;position: absolute;text-align: center">门票价格</div>
            <img src="../assets/img/onlineBookingDetail/bg3.png" style="width: 106px;height: 106px">
          </div>
          <div style="display: flex;flex-direction: column;justify-content: space-evenly;height: 100%;font-size:20px;color:rgba(51,51,51,1);letter-spacing:1px;">
            <div style="border-left:7px solid #644A23;padding-left: 20px">
              门票价格 <span style="color: red">￥{{item.price}}</span>元
            </div>
            <div style="">
              该景区可能有存在高风险的游玩项目，携程建议您购买相关保险。出行前，建议您仔细阅读旅游安全的相关内容。抵达景区后，也请您不要忽略景区内的游玩提示或安全提示类信息。
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row" style="margin: 0 0 147px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10"
             style="padding-left: 31px;;border:1px solid rgba(151,151,151,1);">
          <div style="display: flex;">
            <div style="width: 106px;height: 106px;position: relative;font-size:22px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;margin-right: 21px;">
              <div style="left: 50%;top: 10px;transform: translateX(-50%);width: 48px;position: absolute;text-align: center">门票说明</div>
              <img src="../assets/img/onlineBookingDetail/bg3.png" style="width: 100%">
            </div>
            <div style="width: 80%;margin: 21px 0 30px 0;font-size:20px;font-family:MicrosoftYaHei,serif;color:rgba(51,51,51,1);letter-spacing:1px;">
              <div style="position: absolute;height:30px;;border-left:7px solid #644A23;padding-left: 24px">
              </div>
              <div v-html="item.content" style="text-indent:30px;">
                {{item.content}}
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>

    <div class="container-fluid d-sm-none" style="padding: 0;margin-bottom: 4rem">
      <!--<div class="row" style="margin: 0">-->
        <!--<div class="col-12" style="padding: 0;position: relative">-->
          <!--<img src="../assets/img/index/banner.png" style="width: 100%">-->
          <!--<img src="../assets/img/back.png" @click="toPage('onlineBooking')" style="top: 20%;left: 5px;position: absolute;width: 30px;height: 30px;border-radius: 50%">-->
        <!--</div>-->
      <!--</div>-->

      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;"  @click="toPage('onlineBooking')">
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
        <div class="col-12" style="position: relative;height: 4rem;border-bottom: 1px solid #E3E3E3;display: flex;flex-direction: column;justify-content: center">
          <div class="row" style="margin: 0;font-size:18px;font-weight:600;color:rgba(51,51,51,1);background-color: white;">
            {{item.title}}
          </div>
          <div class="row" style="margin: 0;color:rgba(102,102,102,1);font-size:15px;">
            开放时间：{{item.kfsj}};
          </div>

          <div onclick="window.open('https://piao.ctrip.com/ticket/dest/t1408206.html?allianceid=866656&sid=1435004')" style="position: absolute;right: 0;top: 50%;transform: translateY(-50%);margin-right: 1rem;display: flex;justify-content: center;align-items: center;font-size:0.6rem;font-weight:400;color:rgba(255,255,255,1);height: 40%;width:59px;background:rgba(19,218,167,1);border-radius:10px;">
            立即预定
          </div>
        </div>

        <div class="col-12" style="margin-top: 1rem">
          <img :src="item.img" style="width: 100%;height: 100%;">
        </div>

        <div class="col-12" style="margin-top: 1rem;font-size:16px;font-weight:500;">
          景区介绍
        </div>

        <div  class="col-12" v-html="item.content" style="text-indent:30px;">
          {{item.content}}
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: "onlineBookingDetail",
    data(){
      return{
        name:'',
        item:{}
      }
    },
    mounted(){
      this.item=this.$route.params.item
    },
    methods: {
      /*@params:
      pathName:route名
      isFix:是否需要锚点定位*/
      toPage(pathName, isFix) {
        if (isFix) {
          this.$router.push({
            name: pathName,
            params: {
              id:this.$route.params.item.id
            }
          })
        } else {
          $('body,html').animate({scrollTop: 0}, 500);
          this.$router.push({
            name: pathName,
          })
        }
      }
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
</style>
