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
          <div class="row" style="font-size:20px;font-family:MicrosoftYaHei;margin: 10px 0 0 10px">
            <span style="cursor: pointer" @click="toPage('wzymg',false)">{{$t('m.Play')}}></span><span style="cursor: pointer" @click="toPage('wzymg',true)">{{$t('m.'+enListName)}}></span>
            <span style="color:#644A23;">{{item.title}}</span>
          </div>

          <div class="row" style="margin-top: 60px;font-size:40px;color:rgba(51,51,51,1);">
            <div class="col-md-12"
                 style="border-bottom: 1px solid #C3C4B2;padding: 0 0 26px 0;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;">
              {{item.title}}
              <div class="btn" v-if="item.booking!=''"
                   style="position: relative;margin-left: 20px;cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;font-size:15px;color:rgba(255,255,255,1);">
                <a :href="item.booking" style="color: white;top: 0;left: 0;position: absolute;width: 100%;height: 100%;display: flex;justify-content: center;align-items: center" target="_blank">{{$t('m.LJYD')}}</a>
              </div>
            </div>
          </div>

          <div class="row" style="margin-top: 26px;font-size:20px;color:rgba(102,102,102,1);">
            <div class="col-md-12" style="padding: 0;text-align: right">
              创建时间 {{item.cjsj|time}}
            </div>
          </div>

          <div class="row" style="display: flex;justify-content: center;margin-top: 50px;font-size:20px;color:rgba(51,51,51,1);">
            <div class="col-md-7">
              <img :src="item.img" style="width:100%;">
            </div>

          </div>

          <div class="row" v-html="item.content" style="margin-top: 50px;font-size:20px;color:rgba(51,51,51,1);">
            {{item.content}}
          </div>

          <!--<div class="row mar"-->
               <!--style="margin-top: 61px;margin-bottom: 30px;height: 500px;display: flex;justify-content: space-between;">-->
            <!--<div class="col-md-6" style="padding: 0">-->
              <!--<img class="imgHeight" :src="item.img" style="width: 100%;height: 100%">-->
            <!--</div>-->
            <!--<div class="col-md-6" style="padding: 0;height: 100%">-->
              <!--<div class="item">-->
                <!--<div-->
                  <!--style="margin: 29px 0 15px 0;padding-left: 15px;font-size:25px;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">-->
                  <!--{{item.title}}-->
                <!--</div>-->
                <!--<div-->
                  <!--style="font-size:20px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);margin-bottom: 29px;height: 55%;text-indent:45px;overflow-x: hidden;text-overflow:ellipsis;">-->
                  <!--{{item.content}}-->
                <!--</div>-->
                <!--<div-->
                  <!--style="font-size:20px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);margin-bottom: 29px;height: 20%;text-indent:15px;overflow-x: hidden;text-overflow:ellipsis;">-->
                  <!--<p>地址：{{item.address}}</p>-->
                  <!--<p>联系电话：{{item.phone}}</p>-->
                <!--</div>-->
              <!--</div>-->
            <!--</div>-->
          <!--</div>-->

        </div>
        <div class="col-md-1"></div>
      </div>
    </div>

    <div class="container-fluid d-sm-none" style="padding: 0">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('wzymg',false)">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              {{$t('m.'+enListName)}}
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="col-12" style="font-size: 1.3rem;font-weight: 500;text-align: center">
        {{item.title}}
      </div>
      <div class="col-12" style="font-size: 1.3rem;font-weight: 500;text-align: center">
        <img class="imgHeight" :src="item.img" style="width: 100%;height: 100%">
      </div>

      <div class="col-12"
           style="margin-bottom: 4rem;font-size:20px;color:rgba(102,102,102,1);height: 55%;text-indent:45px;overflow-x: hidden;text-overflow:ellipsis;">
        {{item.content}}
      </div>
      <!--<div class="col-12"-->
           <!--style="margin-bottom: 4rem;font-size:20px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);height: 20%;text-indent:15px;overflow-x: hidden;text-overflow:ellipsis;">-->
        <!--<p>地址：{{item.address}}</p>-->
        <!--<p>联系电话：{{item.phone}}</p>-->
      <!--</div>-->

      <div class="btn" v-if="listName==='住宿'"
           style="margin-bottom: 5rem;padding: 0.65rem;position: relative;cursor: pointer;height: 35px;width:75px;border-radius:10px;background-color: rgba(19,218,167,1);color:rgba(255,255,255,1);border: none;display: flex;justify-content: center;align-items: center;margin-left: 50%;transform: translateX(-50%);">
        <a :href="item.booking"
           style="font-size:0.8rem;font-weight:400;color: white;width: 100%;height: 100%;position: absolute;display: flex;justify-content: center;align-items: center;"
           target="_blank">在线预订</a>
      </div>
    </div>



  </div>
</template>

<script>
  import {mixins} from "../common/util/mixins";
  export default {
    name: "wzymg_Sec",
    mixins: [mixins],
    data() {
      return {
        listName: '',
        enListName:'',
        item:{}
      }
    },
    created() {
      this.listName = this.$route.params.listName
      this.item= this.$route.params.item
      switch (this.listName) {
        case '美食':this.enListName='MS';
        break;
        case '住宿':this.enListName='ZS';
          break;
        case '休闲娱乐':this.enListName='XXYL';
          break;
        case '特色商品':this.enListName='TSSP';
          break;
      }
    },
    methods: {
        /*@params:
        pathName:route名
        isFix:是否需要锚点定位*/
      toPage(pathName, isFix) {
        if(this.$route.params.GD){
          // {pathName:'',listName:'住宿'}
          $('body,html').animate({scrollTop: 0}, 500);
          this.$router.push({
            path: '/wzymg_more/' + this.listName
          })
          return
        }

        if (isFix) {
          this.$router.push({
            name: pathName,
            params: {
              listName: this.listName,
              type:this.item.type
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
  .row {
    margin-left: 0;
    margin-right: 0;
  }

  .item {
    width: 100%;
    height: 100%;
    background: rgba(255, 255, 255, 1);
    border: 1px solid rgba(151, 151, 151, 1);
    padding: 0 14px 0 45px;
  }

  .pageBtn {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 146px;
    height: 48px;
    color: white !important;
    background-color: #644A23;
  }

  /deep/ .page-item.active .page-link {
    background-color: #644A23 !important;
    color: white !important;
  }

  /deep/ .page-link {
    border: none !important;
    color: #644A23;
    background-color: white !important;
  }

  .pagination {
    align-items: center;
  }
</style>
