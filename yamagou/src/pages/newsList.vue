<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="row" style="margin: 43px 0 0 0;">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row" style="font-size:20px;font-family:MicrosoftYaHei;margin: 10px 0 0 10px">
          <span @click="toPage('index',false)">首页></span><span @click="toPage('index',true)">新闻资讯></span>
          <span style="color:#644A23;" >更多</span>
        </div>

        <div class="row mar" v-for="item in newsList"
             style="margin-top: 61px;margin-bottom: 30px;height: 338px;display: flex;justify-content: space-between;">
          <div class="col-md-4" style="padding: 0">
            <img class="imgHeight" :src="item.src" style="width: 100%;height: 100%">
          </div>
          <div class="col-md-8" style="padding: 0;height: 100%">
            <div class="item">
              <div
                style="margin: 29px 0 15px 0;padding-left: 15px;font-size:28px;font-family:MicrosoftYaHei;color:rgba(51,51,51,1);">
                {{item.title}}
              </div>
              <div
                style="font-size:22px;font-family:MicrosoftYaHei;color:rgba(102,102,102,1);margin-bottom: 29px;height: 40%;text-indent:45px;overflow-x: hidden;text-overflow:ellipsis;">
                {{item.content}}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row pageLink" style="margin: 158px 0 0 0;padding: 0 0 180px 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="mt-3">
          <b-pagination v-model="currentPage" :total-rows="rows" align="center">
            <div slot="first-text" class="pageBtn">首页</div>
            <div slot="prev-text" class="pageBtn">上一页</div>
            <div slot="next-text" class="pageBtn">下一页</div>
            <div slot="last-text" class="pageBtn">尾页</div>
          </b-pagination>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "newsList",
    data() {
      return {
        currentPage: 3,
        rows: 100,
        newsList:[
          {
            src:require('../assets/img/WZYMG/gyjc.png'),
            title:'第一条新闻吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼',
            content:'这是新闻内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！'
          },
          {
            src:require('../assets/img/WZYMG/gyjc.png'),
            title:'第二条新闻吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼',
            content:'这是新闻内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！'
          },
          {
            src:require('../assets/img/WZYMG/gyjc.png'),
            title:'第三条新闻吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼',
            content:'这是新闻内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！'
          },
          {
            src:require('../assets/img/WZYMG/gyjc.png'),
            title:'第四条新闻吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼',
            content:'这是新闻内容啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！'
          }
        ]
      }
    },
    mounted(){
        $('.img-fluid').css('height', '200px')
    },
    created(){
      this.getData()
    },
    methods:{
      getData(){
        this.$http.post(this.apis.NEWS.GETNEWS,{pageSize:'4',pageNum:'1'}).then(res=>{
          if(res.code===200){
            this.newsList=res.page.list
          }else {

          }
        })
      },
      toPage(pathName, isFix) {
        if (isFix) {
          this.$router.push({
            name: pathName,
            params: {
              listName: 'news'
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
