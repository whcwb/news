<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>
      <div class="row" style="margin: 43px 0 30px 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="font-size:20px;">
            <span @click="toPage('index')" style="cursor: pointer">{{$t('m.index')}}></span>
            <span v-if="listName" @click="toPage(listName)" style="cursor: pointer">{{$t(listName)}}></span>
            <span style="color:#644A23;">{{item.title}}</span>
            <span style="color:#644A23;" v-if="!item.title">景区视频</span>
          </div>

          <div class="row" style="margin-top: 60px;font-size:40px;color:rgba(51,51,51,1);">
            <div class="col-md-12"
                 style="border-bottom: 1px solid #C3C4B2;padding: 0 0 26px 0;">
              {{item.title}}
            </div>
          </div>

          <div class="row" style="margin-top: 26px;font-size:20px;color:rgba(102,102,102,1);">
            <div class="col-md-12" style="padding: 0;text-align: right">
              创建时间 {{item.cjsj|time}}
            </div>
          </div>


          <div class="row" v-if="item.viPath" style="margin-top:96px">
            <div class="col-md-1"></div>
            <div class="col-md-10" style="padding: 0">
              <div class="embed-responsive embed-responsive-16by9">
                <video :src="item.viPath" style="width: 100%" controls="controls"></video>
              </div>
            </div>
            <div class="col-md-1"></div>
          </div>

          <div class="row" v-if="item.img" style="margin-top:96px">
            <div class="col-md-1"></div>
            <div class="col-md-10" style="padding: 0">
              <img :src="item.img" style="width: 100%;height: 600px">
            </div>
            <div class="col-md-1"></div>
          </div>

          <div class="row de" v-html="item.content" style="margin-top: 90px;font-size:20px;color:rgba(51,51,51,1);">
            {{item.content}}
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>

    <!--移动端-->
    <div class="container-fluid d-sm-none" style="padding: 0;">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;position: relative">
          <img src="../assets/img/index/banner.png" style="width: 100%">
          <img src="../assets/img/back.png" @click="toPage('LYGL',false)"
               style="top: 20%;left: 5px;position: absolute;width: 30px;height: 30px;border-radius: 50%">
        </div>
      </div>

      <div class="col-12" style="margin-top: 1rem;font-size: 1.3rem;font-weight: 500">
        {{item.title}}
      </div>

      <div class="col-12" v-html="item.content">
        {{item.content}}
      </div>
    </div>

  </div>
</template>

<script>
  import {mixins} from "../common/util/mixins";

  export default {
    name: "LYGL_Sec",
    mixins: [mixins],
    data() {
      return {
        listName: '',
        enListName: '',
        time: '',
        item: {}
      }
    },
    mounted() {
      this.$route.params.item
      this.item = this.$route.params.item
      if (this.$route.params.listName) {
        this.listName = this.$route.params.listName
      }
    },
    methods: {
      toPage(pathName) {
        $('body,html').animate({scrollTop: 0}, 500);

        if (this.listName != '') {
          let name = ''
          switch (pathName) {
            case 'm.PlayInYMG':name='yzymg';
            break;
            case 'm.XWZW':name='ZWXW';
              break;
            case 'm.news':name='localNews';
              break;
          }
          this.$router.push({
            name: name
          })
          return
        }

        if (pathName == 'index') {
          $('.img-fluid').css('height', 'auto')
        }

        this.$router.push({
          name: pathName
        })
      }
    }
  }
</script>

<style scoped>
  .row {
    margin-left: 0;
    margin-right: 0;
  }

  .de>>>p{
    width: 100%;
  }

  .de>>>div{
    width: 100%;
  }

  .de>>>img{
    display: block;
    margin: 0 auto;
    width: 50%;
    height: auto;
  }

</style>
