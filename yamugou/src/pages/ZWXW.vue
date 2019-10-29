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
          <div class="row" style="font-size:20px;margin: 10px 0 0 10px">
            <span @click="toPage('index',false)">{{$t('m.index')}}></span>
            <span style="color:#644A23;">{{$t('m.XWZW')}}</span>
          </div>

          <!--<div class="row" style="margin-top: 50px;display: flex;justify-content: space-between;">-->
          <!--<div class="col-md-6 pr" v-for="item in newsList"-->
          <!--style="margin-top:30px;font-family:MicrosoftYaHei;padding: 0;max-width: 40%;flex: 0 0 40%">-->
          <!--<Card>-->
          <!--<div slot="title">-->
          <!--<img :src="item.bz" style="width: 100%;height: 250px">-->
          <!--</div>-->
          <!--<div style="width: 100%;height: 100px;text-align: center">-->
          <!--<div-->
          <!--style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">-->
          <!--{{item.title}}-->
          <!--</div>-->
          <!--<div class="btn" @click="toPage('Detail',item)"-->
          <!--style="margin-top: 20px;cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;font-size:15px;color:rgba(255,255,255,1);">-->
          <!--{{$t('m.LJQW')}}-->
          <!--</div>-->
          <!--</div>-->
          <!--</Card>-->
          <!--</div>-->
          <!--</div>-->


          <div class="row" style="justify-content: space-between;margin-top: 30px">
            <div class="col-md-2" style="padding: 0;display: flex;flex-direction: column;align-items: flex-end">
              <div v-for="(item,index) in tabNews" @click="tabChangeCSS(index)"
                   :class="item.clicked?'tabBtn tabBtnClick':'tabBtn'">
                <span>{{$t(item.name)}}</span>
                <img src="../assets/img/choose.png" v-if="item.clicked" style="width: 15px;height: 15px">
              </div>
            </div>
            <div class="col-md-10" style="max-width: 80%;flex: 0 0 80%;">
              <div class="row jd" style="margin-top: 0">
                <div class="col-md-12" v-for="item in newsList" @click="toPage('Detail',item)"
                     style="cursor: pointer;height: 202px;padding: 0;;margin-bottom: 10px;background:rgba(255,255,255,1);border:1px solid rgba(151,151,151,1);">
                  <div class="row" style="margin: 0">
                    <div class="col-4" style="padding: 0">
                      <img :src="item.bz" style="width: 100%;height: 200px">
                    </div>
                    <div class="col-8" style="padding: 28px 37px">
                      <div class="row"
                           style="display: block;font-size: 18px;margin: 0;text-overflow: ellipsis;overflow-x: hidden;white-space: nowrap">
                        {{item.title}}
                      </div>
                      <div class="row"
                           style="display: block;font-size: 16px;margin: 25px 0 0 0;text-indent: 30px">
                        {{item.subTitle}}
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
               v-for="item in newsListPhone">
            <div class="col-4" style="padding: 0;">
              <img class="imgHeight" :src="item.bz" style="border-radius:0.5rem 0 0 0.5rem;width: 100%;height: 100%">
            </div>
            <div class="col-8" style="padding: 0">
              <div style="height: 100%;position: relative">
                <div
                  style="overflow-x: hidden;text-overflow: ellipsis;white-space: nowrap;font-weight:500;height: 30%;margin: 0.2rem 0 0.1rem 0;padding-left: 15px;font-size:1rem;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">
                  {{item.title}}
                </div>
                <div v-html="item.content"
                     style="color:rgba(153,153,153,1);font-size:0.7rem;font-family:MicrosoftYaHei;margin-bottom: 0.2rem;height: 55%;text-indent:0.3rem;overflow-x: hidden;text-overflow:ellipsis;">
                  {{item.content}}
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
    name: "localNews",
    mixins: [mixins],
    data() {
      return {
        perPage: 6,
        currentPage: 1,
        rows: 5,
        newsList: [],
        newsListPhone: [],
        tabYMGindex: 0,
        tabNews: [
          {
            name: 'm.gjgnsx',
            clicked: true
          },
          {
            name: 'm.jkxw',
            clicked: false
          }
        ]
      }
    },
    created() {
      this.getData()
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
      getData() {
        var v = this
        let type=this.tabYMGindex===0?1:3
        this.$http.post(this.apis.NEWS.GETNEWS, {pageSize: '6', pageNum: this.currentPage, type: type}).then(res => {
          if (res.code === 200) {
            v.newsList = res.page.list
            v.rows = res.page.total
            window.scrollTo(0,0)
          } else {

          }
        })

        this.$http.post(this.apis.NEWS.GETNEWS, {type: 1}).then(res => {
          if (res.code === 200) {
            v.newsListPhone = res.page.list
          } else {

          }
        })
      },
      tabChangeCSS(index) {
        this.tabYMGindex = index;
        this.currentPage=1
        this.getData()
        this.tabNews.map((val, index, arr) => {
          val.clicked = false
        })
        this.tabNews[index].clicked = true
      },
      toPage(pathName, item) {
        $('body,html').animate({scrollTop: 0}, 500);

        if (item) {
          this.$router.push({
            name: pathName,
            params: {
              item: item,
              listName: 'm.XWZW'
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

  /deep/ .page-link {
    font-size: 17px !important;
  }

  /deep/ .page-item.active .page-link {
    background-color: #644A23 !important;
    color: white !important;
    border-color: #644A23 !important
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }

  .list {
    display: flex;
    align-items: center;
    margin: 0 0 15px 0;
    padding: 5px 0;
  }
</style>
