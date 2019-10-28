<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>

      <div class="row" style="margin: 43px 0 0 0;">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="font-size:20px;font-family:MicrosoftYaHei;margin: 10px 0 0 10px">
            <span @click="toPage('index',false)">{{$t('m.index')}}></span>
            <span style="color:#644A23;">{{$t('m.news')}}</span>
          </div>

          <div style="border: 1px solid #EBECEE;border-radius: 10px;padding: 15px;margin-top: 20px">
            <div class="row list" v-for="(item,index) in newsList" :style="{background:index%2==0?'#EBECEE':'none'}">
              <div class="col-md-9" @click="toPage('Detail',item)" style="font-size:18px;cursor: pointer">
                {{item.title}}
              </div>
              <div class="col-md-3" style="font-size:18px;">
                {{item.cjsj|time}}
              </div>
            </div>
          </div>
          <!--<div class="row mar" v-for="item in newsList"-->
          <!--style="margin-top: 30px;margin-bottom: 30px;height: 330px;display: flex;justify-content: space-between;">-->
          <!--<div class="col-md-4" style="padding: 0">-->
          <!--<img class="imgHeight" :src="item.bz" style="width: 100%;height: 100%">-->
          <!--</div>-->
          <!--<div class="col-md-8" style="padding: 0">-->
          <!--<div class="item">-->
          <!--<div-->
          <!--style="margin: 29px 0 15px 0;padding-left: 15px;font-size:22px;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">-->
          <!--{{item.title}}-->
          <!--</div>-->
          <!--<div v-html="item.content"-->
          <!--style="font-size:17px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);margin-bottom: 29px;height: 60%;text-indent:45px;overflow-x: hidden;text-overflow:ellipsis;">-->
          <!--{{item.content}}-->
          <!--</div>-->
          <!--</div>-->
          <!--</div>-->
          <!--</div>-->
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row pageLink" style="margin: 80px 0 0 0;padding: 0 0 180px 0">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="mt-3">
            <b-pagination
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              align="center">
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
    <div class="container-fluid d-sm-none" style="background:rgba(249,249,249,1);padding: 0;margin-bottom: 4rem">

      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('index')">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              活动资讯
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="row" style="margin: 0">
        <div class="col-12">
          <div class="row"
               style="border-radius: 0.5rem;margin:1rem 0;background-color: white;height: 6rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
               v-for="item in newsListPhone" @click="toPage('phoneLocalnewsDetail',item)">

            <div class="col-4" style="padding: 0;">
              <img class="imgHeight" :src="item.bz" style="border-radius:0.5rem 0 0 0.5rem;width: 100%;height: 100%">
            </div>
            <div class="col-8" style="padding: 0">
              <div style="height: 100%;position: relative;overflow-y: hidden;">
                <div
                  style="font-weight:500;height: 30%;margin: 0.2rem 0 0.1rem 0;padding-left: 15px;font-size:1rem;color:rgba(51,51,51,1);">
                  {{item.title}}
                </div>
              </div>
            </div>


          </div>
        </div>
      </div>

      <div class="row" style="margin: 20px 0 0 0;">
        <div class="col-12" style="margin-bottom: 20px;display: flex;font-size: 1rem;justify-content: center">
          <div style="margin-right: 3rem" @click="changePage('prev')">上一页</div>
          <div style="margin-right: 3rem">{{currentPage}}</div>
          <div @click="changePage('next')">下一页</div>
        </div>
      </div>

      <div v-show="showTip" style="text-align: center;padding-bottom: 1.3rem;font-size: 1rem">
        无更多数据
      </div>

    </div>

  </div>
</template>

<script>
  import {mixins} from "../common/util/mixins";

  export default {
    name: "localNews",
    mixins: [mixins],
    data() {
      return {
        perPage: 12,
        pages:0,
        currentPage: 1,
        rows: 5,
        newsList: [],
        newsListPhone: [],
        showTip:false
      }
    },
    created() {
      this.getData()
      this.getnews()
    },
    mounted() {
      $('.img-fluid').css('height', '200px')
    },
    watch: {
      currentPage(val) {
        this.getData()
      }
    },
    methods: {
      changePage(change){
        if(change==='next'){
          if(this.pages===this.currentPage) {
            return
          }
          this.currentPage+=1
        }else {
          if(this.currentPage===1) return
          this.currentPage-=1
        }
      },
      getData() {
        var v = this
        this.$http.post(this.apis.NEWS.GETNEWS, {pageSize: '12', pageNum: this.currentPage, type: 2}).then(res => {
          if (res.code === 200) {
            v.pages=res.page.pages
            v.newsList = res.page.list
            v.newsListPhone = res.page.list
            v.rows = res.page.total
            if(this.currentPage===this.pages) this.showTip=true
            else this.showTip=false
            window.scrollTo( 0, 0 );
          } else {

          }
        })


      },
      getnews(){
        var v = this
        this.$http.post(this.apis.NEWS.GETNEWS, {type: 2}).then(res => {
          if (res.code === 200) {
            v.newsListPhone = res.page.list
          } else {

          }
        })
      },
      toPage(pathName, item) {
        $('body,html').animate({scrollTop: 0}, 500);

        if (item) {
          this.$router.push({
            name: pathName,
            params:{
              item:item,
              listName:'m.news'
            }
          })
        }

        this.$router.push({
          name: pathName,
        })
      }
    }
  }
</script>

<style scoped>
  .item {
    width: 100%;
    height: 330px;
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
    color: white !important;
    border-color:#644A23 !important;
  }

  /deep/ .page-link{
    font-size: 17px !important;
  }

  /*/deep/ .page-link {*/
    /*border: none !important;*/
    /*color: #644A23;*/
    /*background-color: white !important;*/
  /*}*/

  /*.pagination {*/
    /*align-items: center;*/
  /*}*/

  .list {
    display: flex;
    align-items: center;
    margin: 0 0 15px 0;
    padding: 5px 0;
  }

  .newsPhoto>>>img{
    width: 100%!important;
  }
</style>
