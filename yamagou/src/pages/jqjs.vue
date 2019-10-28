<template>
  <div style="font-family:MicrosoftYaHei;">
    <!--PC-->
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0">
        <div class="col-md-12" style="padding: 0">
          <img src="../assets/img/banner.png" style="width: 100%">
        </div>
      </div>

      <div class="row" style="margin: 0;">
        <div class="col-md-12" style="margin-top: 88px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">{{$t('m.aboutUS')}}</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>


      <div class="row" style="margin: 60px 0 0 0">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row"
               style="margin-bottom: 30px;display: flex;justify-content: center;font-size:30px;color:rgba(51,51,51,1);">
            了解亚木沟
          </div>

          <div class="row"
               style="padding: 0 60px;display: flex;justify-content: center;font-size:20px;color:rgba(102,102,102,1);">
            <article style="text-indent: 50px">
              <p>亚木沟风景区位于贵州省铜仁市江口县境内的太平河（贵州省著名风景名胜区）岸边，毗邻梵净山（国家级自然保护区、中国十大避暑名山），是梵净山生态文化旅游的重点卫星景点。景区地处江梵公路中段，距江口县城19公里，距渝怀铁路江口站约30公里，铜仁站约60公里，距湘黔铁路玉屏站140公里，距铜仁机场约80公里，交通非常便利。</p>
              <p>景区大门外设有大型免费停车场（公路旁），可同时容纳400余辆车。景区总面积26平方公里，分为生态停车场、四星级酒店、乡村风情廊、购物街、亚木沟原始峡谷、土家风情园、明朝古寨等几大板块，满足旅游者吃、住、行、游、购、娱各方面需求。游客既可以欣赏原始的
                自然风光，又可以领略原生态的土家文化诸如原生态歌舞表演、民间绝技、嫁娶风俗等。</p>
              <p>据记载，亚木沟在唐代以前名为“鬼谷”，又叫“隐龙沟”，后因谷中长出一株神树，似石似木，通体碧透，花有异香，能驱邪治病，食其果实，可使多年未育的夫妇得子，引得远近无数土民对其顶礼膜拜，取名为“亚木”，在古土家语里就是“树神”的意思，因而得名“亚木沟”，一直沿用至今。亚木沟自古就被誉为“贵州第一沟”。“贵州第一”源于古籍：唐《蛮志》有“行遍蛮境，未闻有如一也”的说法，而《思州府志》更有“亚木其神，莫可言传；其沟之妙，实甲黔境”的记载。</p>
            </article>
          </div>
        </div>
      </div>


      <div class="row" style="margin: 0;">
        <div class="col-md-12" style="margin-top: 88px;text-align: center">
          <div class="titleBG" style="width: 250px">
            <img src="../assets/img/index/logo.png"
                 style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
            <span style="position: static;z-index: 100">景区介绍</span>
            <div class="titleBGBottom"></div>
          </div>
        </div>
      </div>

      <!--<div class="row" style="margin: 60px 0 0 0">-->
      <!--<div class="col-md-1"></div>-->
      <!--<div class="col-md-10">-->
      <!--<div class="row"-->
      <!--style="margin: 0;padding: 10px;">-->
      <!--<div class="col-md-12" style="padding: 0;height: 40px;color: white;display: flex;">-->
      <!--<div :class="item.clicked?'tabbutton tabbuttonClick':'tabbutton'"-->
      <!--@click="tabChangeCSS(index)" v-for="(item,index) in tabList">-->
      <!--{{item.title}}-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="col-md-12"-->
      <!--style="padding: 0;margin-top: 10px;background-color: white;height: 600px">-->
      <!--<img :src="tabList[tabIndex].img" style="width: 100%;height: 100%">-->
      <!--</div>-->
      <!--<div class="col-md-12" style="font-size: 25px;color: #BF9E6D;margin: 20px 0 10px 0">-->
      <!--{{tabList[tabIndex].title}}-->
      <!--</div>-->
      <!--<div class="col-md-12" v-html="tabList[tabIndex].content" style="font-size: 18px;text-indent: 38px">-->
      <!--{{tabList[tabIndex].content}}-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->

      <div class="row" style="margin: 60px 0 0 0">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" v-for="(item,index) in tabList"
               style="margin: 0 0 50px 0;padding: 10px;height: 300px">
            <div class="col-md-6" v-if="index%2==0">
              <!--<img :src="item.img" style="width: 100%;height: 100%">-->
              <b-carousel
                class="row yj d-none d-sm-flex"
                id="carousel-1"
                v-model="slide"
                :interval="4000"
                controls
                indicators
                background="#ababab"
                img-width="1024"
                img-height="480"
                style="text-shadow: 1px 1px 2px #333;margin: 0"
              >
                <b-carousel-slide v-for="img in item.imgList">
                  <img
                    slot="img"
                    class="d-block img-fluid w-100"
                    :interval="100000"
                    width="1024"
                    height="480"
                    :src="img"
                  >
                </b-carousel-slide>

              </b-carousel>
            </div>
            <div class="col-md-6" v-if="index%2==0" style="overflow: hidden">
              <h3>{{item.title}}</h3>
              <div v-html="item.content" style="text-indent: 30px;font-size: 18px;margin: 10px 0 0 0;overflow: hidden">
                {{item.content}}
              </div>
            </div>

            <div class="col-md-6" v-if="index%2!=0" style="height: 100%;overflow: hidden">
              <h3>{{item.title}}</h3>
              <div v-html="item.content" style="text-indent: 30px;font-size: 18px;margin: 10px 0 0 0;overflow: hidden">
                {{item.content}}
              </div>
            </div>
            <div class="col-md-6" v-if="index%2!=0">
              <!--<img :src="item.img" style="width: 100%;height: 100%">-->
              <b-carousel
                class="row yj d-none d-sm-flex"
                id="carousel-1"
                v-model="slide"
                :interval="4000"
                controls
                indicators
                background="#ababab"
                img-width="1024"
                img-height="480"
                style="text-shadow: 1px 1px 2px #333;margin: 0"
              >
                <b-carousel-slide v-for="img in item.imgList">
                  <img
                    slot="img"
                    class="d-block img-fluid w-100"
                    :interval="100000"
                    width="1024"
                    height="480"
                    :src="img"
                  >
                </b-carousel-slide>

              </b-carousel>
            </div>
            <!--<div class="col-md-12"-->
            <!--style="padding: 0;margin-top: 10px;background-color: white;height: 600px">-->
            <!--<img :src="tabList[tabIndex].img" style="width: 100%;height: 100%">-->
            <!--</div>-->
            <!--<div class="col-md-12" style="font-size: 25px;color: #BF9E6D;margin: 20px 0 10px 0">-->
            <!--{{tabList[tabIndex].title}}-->
            <!--</div>-->
            <!--<div class="col-md-12" v-html="tabList[tabIndex].content" style="font-size: 18px;text-indent: 38px">-->
            <!--{{tabList[tabIndex].content}}-->
            <!--</div>-->
          </div>
        </div>
      </div>
    </div>

    <!--移动-->
    <div class="container-fluid d-sm-none" style="background:white;padding: 0;margin-bottom: 4rem">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <img src="../assets/img/tabBack.png" style="margin-left: 22px;width: 1rem;" @click="toPage('index')">
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              景区介绍
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="col-12" style="margin-bottom: 3rem;font-size: 1rem;font-weight: 500;text-indent: 30px">
        亚木沟风景区位于贵州省铜仁市江口县境内，毗邻梵净山。景区地处江梵公路中段，距杭瑞高速（大思段）梵净山匝道口5公里，距梵净山山门6公里，铜仁站约60公里，距铜仁机场约80公里，交通非常便利。
        游客既可以欣赏原始的自然风光，又可以领略原生态的土家文化诸如原生态歌舞表演、民间绝技等。
        据相关文献记载，亚木沟在唐代以前名为“鬼谷”，又叫“隐龙沟”，后因谷中长出一株神树，似石似木，通体碧透，花有异香，能驱邪治病，食其果实，可使多年未育的夫妇得子，引得远近无数土民对其顶礼膜拜，取名为“亚木”，在古土家语里就是“树神”的意思，因而得名“亚木沟”，一直沿用至今。
      </div>

      <div class="row" style="margin: 20px 0 52px 0">
        <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
        </div>
        <div class="col-md-10" style="overflow: hidden">
          <div class="row" style="margin: 0;transition: all 0.3s;width: 100%;flex-wrap: nowrap;overflow-x: scroll">
            <div class="col-md-12 imgAll" style="margin-right: 20px;max-width: 100%;flex: 0 0 100%;padding: 0;height: 100%;position: relative"
                 v-for="(item,index) in tabList">
              <Card>
                <div slot="title">
                  <img :src="item.imgList[0]" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);">
                    {{item.title}}
                  </div>
                  <div v-html="item.content"
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.content}}
                  </div>
                </div>
              </Card>
            </div>
          </div>
        </div>
        <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
        </div>
      </div>

    </div>
  </div>
</template>

<script>
  export default {
    name: "jqjs",
    data() {
      return {
        tabList: [
          {
            title: "亚木沟",
            content: '古有神木，似石似木。源于“武陵之巅”，誉为“七彩峡谷”。前人膜拜，后人瞻仰。',
            imgList: [
              require('../assets/img/jqjs/4.png'),
              require('../assets/img/jqjs/1.png'),
              require('../assets/img/jqjs/2.png'),
              require('../assets/img/jqjs/3.png')
            ]
          },
          {
            title: "玉带石",
            content: '多情的微波，柔情的抚摸。如丝如缕，不见踪迹。佛石吻岸，浅吟低唱。星罗棋布，点缀溪涧。五颜六色，各有千秋',
            imgList: [
              require('../assets/img/jqjs/21.png'),
              require('../assets/img/jqjs/22.png'),
              require('../assets/img/jqjs/23.png'),
              require('../assets/img/jqjs/24.png'),
            ]
          },
          {
            title: "亚木沟的水",
            content: '山谷清溪犹如玉。蜿蜒涓涓流不息。泛出涟漪四周荡。点点滴滴进心里。缕缕微风，丝丝凉意。森林深处，悠悠水声。又拨动了谁的心弦？',
            imgList: [
              require('../assets/img/jqjs/31.png'),
              require('../assets/img/jqjs/32.png'),
              require('../assets/img/jqjs/33.png'),
              require('../assets/img/jqjs/34.png'),
            ]
          },
        ],
        tabIndex: 0,
        slide: 0
      }
    },
    created() {
      // this.getJD()
    },
    methods: {
      tabChangeCSS(index) {
        this.tabIndex = index;
        this.tabList.map((val, index, arr) => {
          val.clicked = false
        })
        this.tabList[index].clicked = true
      },
      toPage(pathName){
          window.scrollTo(0,0)

          if (pathName == 'index') {
            $('.img-fluid').css('height', 'auto')
          }

          this.$router.push({
            name: pathName
          })
      },
      getJD() {
        this.$http.post(this.apis.JD.GETJD, {pageNum: 1, pageSize: 6, type: 1}).then(res => {
          if (res.code === 200) {
            this.tabList = res.page.list
            this.tabList.map((val, index, arr) => {
              // if (this.$route.params.item) {
              //   if (val.id === this.$route.params.item.id) {
              //     val.clicked = true
              //     this.tabIndex = index
              //   } else val.clicked = false
              // } else {
              //   if (index === 0) {
              //     this.tabIndex = 0
              //     val.clicked = true
              //   } else val.clicked = false
              // }
            })
          } else {

          }
        })
      },
    }
  }
</script>

<style scoped>
  .titleBG {
    /*width:401px;*/
    height: 60px;
    max-width: 32% !important;
    flex: 0 0 32% !important;
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
    height: 60px;
    width: 100%;
    border: 2px solid rgba(100, 74, 35, 1);
    position: absolute;
    left: 18px;
    top: 21px;
    z-index: 99;
  }

  .tabbutton {
    margin-right: 10px;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 5px;
    font-size: 18px;
    color: black;
  }

  .tabbuttonClick {
    background-color: #60C3B7;
    color: white;
  }

  ::-webkit-scrollbar {
    width: 0 !important;
  }

  ::-webkit-scrollbar {
    width: 0 !important;
    height: 0;
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }
</style>
