<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="container-fluid d-sm-none" style="padding: 0">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('yzymg',false)">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
                景点介绍
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

      <div class="col-12" v-html="item.content"
           style="margin-bottom: 4rem;font-size:20px;color:rgba(102,102,102,1);height: 55%;text-indent:45px;overflow-x: hidden;text-overflow:ellipsis;">
        {{item.content}}
      </div>
      <!--<div class="col-12"-->
           <!--style="margin-bottom: 4rem;font-size:20px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);height: 20%;text-indent:15px;overflow-x: hidden;text-overflow:ellipsis;">-->
        <!--<p>地址：{{item.address}}</p>-->
        <!--<p>联系电话：{{item.phone}}</p>-->
      <!--</div>-->
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
              listName: this.listName
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
