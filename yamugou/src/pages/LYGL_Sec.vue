<template>
  <div style="font-family:MicrosoftYaHei;">
    <div  class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" style="margin: 43px 0 0 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="font-size:20px;">
            <span style="cursor: pointer" @click="toPage('LYGL',false)">{{$t('m.TravelGuides')}}></span>
            <span style="color:#644A23;">{{item.title}}</span>
          </div>

          <div class="row" style="margin-top: 60px;font-size:40px;color:rgba(51,51,51,1);">
            <div class="col-md-12"
                 style="border-bottom: 1px solid #C3C4B2;padding: 0 0 26px 0;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;">
              {{item.title}}
            </div>
          </div>

          <div class="row" style="margin-top: 26px;font-size:20px;color:rgba(102,102,102,1);">
            <div class="col-md-12" style="padding: 0;text-align: right">
              自由行攻略 {{time}} 阅读{{item.read}}
            </div>
          </div>

          <div class="row de" v-html="item.content" style="margin-top: 120px;font-size:20px;color:rgba(51,51,51,1);">
            {{item.content}}
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>

    <!--移动端-->
    <div class="container-fluid d-sm-none" style="padding: 0;">
      <!--<div class="row" style="margin: 0">-->
        <!--<div class="col-12" style="padding: 0;position: relative">-->
          <!--<img src="../assets/img/index/banner.png" style="width: 100%">-->
          <!--<img src="../assets/img/back.png" @click="toPage('LYGL',false)"  style="top: 20%;left: 5px;position: absolute;width: 30px;height: 30px;border-radius: 50%">-->
        <!--</div>-->
      <!--</div>-->

      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('LYGL',false)">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              {{listName}}
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="col-12" style="margin-top: 1rem;font-size: 1.3rem;font-weight: 500">
        {{item.title}}
      </div>

      <div class="col-12 phoneImg" v-html="item.content" style="margin-bottom: 80px">
        {{item.content}}
      </div>
    </div>

  </div>
</template>

<script>
  var moment = require('moment')
  export default {
    name: "LYGL_Sec",
    data() {
      return {
        listName: '',
        enListName: '',
        time: '',
        item: {}
      }
    },
    created() {
      this.item = this.$route.params.item
      this.time = moment(this.item.cjsj).format('YYYY-MM-DD');
      switch (this.item.type) {
        case '1':
          this.listName = '官方攻略';
          break;
        case '2':
          this.listName = '达人攻略',
          this.enListName = 'DRGL';
          break;
        case '3':
          this.listName = '自驾游攻略',
          this.enListName = 'ZJYXL';
          break;
      }

      switch (this.listName) {
        case '官方攻略':this.enListName='GFGL';
          break;
        case '达人攻略':this.enListName='DRGL';
          break;
        case '自驾游攻略':this.enListName='ZJYXL';
          break;
      }

    },
    methods: {
      toPage(pathName, isFix) {
        if (isFix) {
          this.$router.push({
            path: '/LYGL/' + this.$route.params.tabYMGindex
          })
        } else {
          $('body,html').animate({scrollTop: 0}, 500);
          this.$router.push({
            path: '/LYGL/0'
          })
        }
      }
    }
  }
</script>

<style scoped>
  .row {
    margin-left: 0;
    margin-right: 0;
  }

  .phoneImg>>>img{
    width: 100%!important;
  }

  .de>>>p{
    width: 100%;
  }

  .de>>>p>img{
    display: block;
    margin: 0 auto;
  }
</style>
