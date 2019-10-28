<template>
  <div>
    <!--<div class="row" style="margin: 0;">-->
      <!--<div class="col-md-12" style="padding: 0">-->
        <!--<img src="../assets/img/banner.png" style="width: 100%">-->
      <!--</div>-->
    <!--</div>-->

    <!--<div class="row" style="margin: 43px 0 0 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10">-->
        <!--<div class="row" style="font-size:20px;font-family:MicrosoftYaHei;margin: 10px 0 0 10px">-->
          <!--首页>-->
          <!--<span style="color:rgba(255,102,0,1);">联系我们</span>-->
        <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
    <!--</div>-->

    <!--<div class="row" style="margin: 144px 0 0 0;">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10" style="position: relative;text-align: center">-->
        <!--<img src="../assets/img/contactUS/lxwm.png" style="top: -15%;left: 50%;transform: translateX(-50%);position: absolute;width:35%;">-->
        <!--<div style="top:30%;left: 50%;transform: translateX(-50%);position: absolute;font-size:30px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);letter-spacing:2px;">-->
          <!--您的建议 我们用心倾听-->
        <!--</div>-->
        <!--<img src="../assets/img/LYGL/bg.png" style="width:35%;">-->
      <!--</div>-->
      <!--<div class="col-md-1"></div>-->
    <!--</div>-->

    <div class="row" style="margin: 0;padding: 0 0 121px 0">
      <div class="col-md-12" style="margin-top: 88px;text-align: center">
        <div class="titleBG">
          <img src="../assets/img/index/logo.png" style="width: 50%;height: 90%;padding: 0 15px;position: static;z-index: 100">
          <span style="position: static;z-index: 100">联系我们</span>
          <div class="titleBGBottom"></div>
        </div>
      </div>
    </div>

    <div class="row bg" style="background: none;height: 894px;margin: 30% 0 66px 0;">
      <div class="col-md-1 d-none d-sm-block"></div>
      <div class="col-md-10 bgP"
           style="width:100%;padding:0;height:100%;background:#644A23;border:1px solid rgba(96,195,183,1);">
        <div class="row" style="height: 50%;margin: 0">
          <div class="col-md-1 d-none d-sm-block" style="height: 100%;"></div>
          <div class="col-md-4 heightZ">
              <div style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">
                姓名
              </div>
            <input type="text" style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">

            <div class="address" style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">
              地址
            </div>
            <input type="text" style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">

          </div>
          <div class="col-md-2 d-none d-sm-block" style="height: 100%;"></div>
          <div class="col-md-4" style="height: 100%;">
            <div style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">
              邮箱
            </div>
            <input type="text" style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">

            <div class="address" style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">
               联系方式
            </div>
            <input type="text" style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">


          </div>
          <div class="col-md-1 d-none d-sm-block" style="height: 100%;"></div>
        </div>
        <div class="row" style="height: 50%;margin: 0">
          <div class="col-md-1 d-none d-sm-block"></div>
          <div class="col-md-10">
            <div style="width: 100%;height: 100%">
              <div style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">
                您的反馈建议
              </div>
              <textarea class="form-control" style="min-height: 266px;max-height: 266px" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
          </div>
          <div class="col-md-1 d-none d-sm-block"></div>
        </div>
      </div>
      <div class="col-md-1 d-none d-sm-block"></div>
    </div>

    <div class="row" style="margin: 0;">
      <div class="col-md-12" style="padding: 0">
        <img src="../assets/img/contactUS/jt.png" style="width: 100%">
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: "contactUS",
  }
</script>

<style scoped>
  @media (min-width: 992px) {
    .bg{
      margin: 0 0 66px 0 !important;
    }

    .bgP{
      padding: 89px 0 !important;
    }

    .address{
      margin: 89px 0 18px 27px !important;
    }

    .heightZ{
      height: 100% !important;
    }
  }

  .titleBG {
    /*width:401px;*/
    height: 113px;
    background: rgba(100, 74, 35, 1);
    width: 35%;
    margin: 0 auto;
    display: flex;
    justify-content: space-around;
    align-items: center;
    font-size: 40px;
    font-family: MicrosoftYaHei;
    color: rgba(255, 255, 255, 1);
    position: relative;
  }

  .titleBGBottom{
    height: 113px;
    width: 100%;
    border:2px solid rgba(100,74,35,1);
    position: absolute;
    left: 18px;
    top: 21px;
    z-index: 99;
  }

</style>
