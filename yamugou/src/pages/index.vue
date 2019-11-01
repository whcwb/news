<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
    >
      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          width="1024"
          height="480"
          src="../assets/img/index/banner.png"
        >
      </b-carousel-slide>

      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          width="1024"
          height="480"
          src="../assets/img/index/banner.png"
        >
      </b-carousel-slide>

      <b-carousel-slide>
        <img
          slot="img"
          class="d-block img-fluid w-100"
          width="1024"
          height="480"
          src="../assets/img/index/banner.png"
        >
      </b-carousel-slide>
      <!--<b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">-->
      <!--</b-carousel-slide>-->

      <!--<b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>-->
    </b-carousel>

    <div class="row" style="margin: 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row" style="line-height: 50px;height: 50px;">
          <div class="col-md-2" style="color: red">
            景区公告:
          </div>
          <marquee class="col-md-10">
            新闻滚动啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
          </marquee>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row kuang" style="margin: 30% 0 0 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row">
          <div class="col-md-9">
            <div class="row" style="margin: 0 0 30px 0;line-height: 50px;height: 50px;">
              <div class="col-md-5" style="text-align: center;border: 2px solid #A25F00">
                <img src="../assets/img/index/img5.png" style="width: 30%;margin-top: -20px;">
                <span style="font-size: 20px;color:#A25F00">景区介绍  最美视频</span>
              </div>
            </div>
            <div class="row newsScroll"
                 style="display: flex;justify-content: space-between;margin: 0;overflow-x: scroll;flex-wrap: nowrap">
              <div class="col-md-3 col-12 news"
                   style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 400px;">
                <img src="../assets/img/index/img4.png" style="width: 100%;height: 80%">
                <div style="height: 20%;display: flex;justify-content: center;align-items: center">
                  亚木沟宣传大片
                </div>
              </div>
              <div class="col-md-3 col-12 news"
                   style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 400px;">
                <img src="../assets/img/index/img4.png" style="width: 100%;height: 80%">
                <div style="height: 20%;display: flex;justify-content: center;align-items: center">
                  亚木沟宣传大片
                </div>
              </div>
              <div class="col-md-3 col-12 news"
                   style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 400px;">
                <img src="../assets/img/index/img4.png" style="width: 100%;height: 80%">
                <div style="height: 20%;display: flex;justify-content: center;align-items: center">
                  亚木沟宣传大片
                </div>
              </div>
            </div>
            <div class="row" style="margin-top: 15px;display: flex;justify-content: center">
              左右按钮
            </div>
          </div>
          <div class="col-md-3" style="">
            <div class="row" style="margin: 0;font-size: 20px;color:#A25F00">
              微博动态
            </div>
            <div class="row" style="margin: 0;height: 300px;border: 1px solid navy">

            </div>
            <div class="row"
                 style="margin: 0;padding: 0;width: 100%;display: flex;align-items: center;justify-content: center">
              <img src="../assets/img/index/newsRT.png" style="width:100%">
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row" style="margin: 30px 0 0 0;">
      <div class="col-md-1"></div>
      <div class="col-md-10" style="position: relative">
        <!--<img src='../assets/img/index/z9.png' style="width: 100%"/>-->
        <div class="row"
             style="top: 28px;padding: 0 15px;right: 17px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

        <div class="row"
             style="top: 20%;left: 0;padding-left: 35px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

        <div class="row"
             style="top: 51%;left: 0;padding-left: 35px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

        <div class="row"
             style="top: 35%;right: 17px;padding: 0 15px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

        <div class="row"
             style="top: 66%;right: 17px;padding: 0 15px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

        <div class="row"
             style="top: 82%;left: 0;padding-left: 35px;display: flex;justify-content: space-around;width: 50%;height: 120px;position: absolute;">
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
          <div class="col-md-3">
            <img src="../assets/img/index/img1.png" style="width: 100%">
          </div>
        </div>

      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row" style="margin: 30px 0 0 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="embed-responsive embed-responsive-16by9">
          <iframe height=498 width=510
                  src='http://player.youku.com/embed/XNTg3NjE4Mzg4'
                  frameborder="0" allowfullscreen></iframe>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row" style="margin: 30px 0 0 0">
      <div class="col-md-1"></div>
      <div class="col-md-10" style="">
        <div class="row"
             style="display: flex;justify-content: center;margin: 0 0 30px 0;line-height: 50px;height: 50px;">
          <div class="col-md-3" style="text-align: center;border: 2px solid #A25F00">
            <img src="../assets/img/index/img5.png" style="width: 30%;margin-top: -20px;">
            <span style="font-size: 30px;color:#A25F00;">
                  聚焦亚木沟
                </span>
          </div>
        </div>

        <div class="row" style="display: flex;justify-content: space-between;margin: 0">
          <div class="col-md-3 news"
               style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 500px;">
            <img src="../assets/img/index/img4.png" style="width: 100%;height: 60%">
            <div
              style="font-size: 20px;color: black;font-weight: 600;height: 10%;display: flex;justify-content: center;align-items: center">
              亚木沟的新闻啊这是亚木沟的新闻啊
            </div>
            <div style="overflow: auto;height: 30%;text-indent: 35px">
              这是具体新闻啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
            </div>
          </div>
          <div class="col-md-3 news"
               style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 500px;">
            <img src="../assets/img/index/img4.png" style="width: 100%;height: 60%">
            <div
              style="font-size: 20px;color: black;font-weight: 600;height: 10%;display: flex;justify-content: center;align-items: center">
              这是亚木沟的新闻啊啊
            </div>
            <div style="height: 30%;text-indent: 35px">
              这是具体新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
            </div>
          </div>
          <div class="col-md-3 news"
               style="background-color: #FFFBF1;border: 1px solid black;padding: 5px;height: 500px;">
            <img src="../assets/img/index/img4.png" style="width: 100%;height: 60%">
            <div
              style="font-size: 20px;color: black;font-weight: 600;height: 10%;display: flex;justify-content: center;align-items: center">
              这是亚木沟的新闻啊啊
            </div>
            <div style="height: 30%;text-indent: 35px">
              这是具体新闻啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
            </div>
          </div>
        </div>

      </div>
      <div class="col-md-1"></div>
    </div>


    <div class="row" style="margin: 30px 0 0 0">
      <div class="col-md-1"></div>
      <div class="col-md-10" style="">
        <div class="row"
             style="display: flex;justify-content: center;margin: 0 0 30px 0;line-height: 50px;height: 50px;">
          <div class="col-md-3" style="text-align: center;border: 2px solid #A25F00">
            <img src="../assets/img/index/img5.png" style="width: 30%;margin-top: -20px;">
            <span style="font-size: 30px;color:#A25F00;">
                  名人明星
                </span>
          </div>
        </div>

        <div class="row"
             style="padding: 15px 0;margin: 0;display: flex;justify-content: center;height: 232px;background-color:#EEEEEE">
          <div class="col-md-1" style="z-index: 999;display: flex;justify-content: center;align-items: center">
            <button @click="moveImg('prev')">左</button>
          </div>
          <div class="col-md-10" style="overflow: hidden;padding: 0;height: 100%;">
            <div class="row" id="imgMove" style="transition: all 0.3s;width: 100%;flex-wrap: nowrap;">
              <div class="col-md-3 imgAll" v-for="(item,index) in imgListAll">
                <img :src="item.src" style="width: 100%;">
              </div>
            </div>
          </div>
          <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
            <button @click="moveImg('next')">右</button>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>


    <div class="row" style="margin: 100px 0 0 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row">
          <div class="col-md-2" style="height: 50px;line-height:50px;color: #A25F00;font-size: 25px">
            友情链接
          </div>
          <div class="col-md-6" style="padding-left: 0;height: 50px;">
            <div style="width: 100%;height: 50%;border-bottom: 2px solid #A25F00"></div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-7" style="height: 100px;display: flex;flex-direction: row;align-items: center">
            <div v-for="item in urlList" style="margin-right: 10px">
              {{item}}
            </div>
          </div>
          <div class="col-md-5" style="height: 180px;display: flex;align-items: center">
            <div class="row" style="margin: 0;width: 100%">
              <div class="col-md-6" style="width: 100%">
                <div class="row">
                  <div class="col-md-7" style="width: 100%;padding: 0">
                    <img src="../assets/img/index/rightNav2.png" style="width: 100%">
                  </div>
                  <div class="col-md-5"
                       style="width: 100%;padding: 0;display: flex;flex-direction: column;justify-content: center">
                    <div>扫码关注</div>
                    <div>亚木沟景区官方微博</div>
                  </div>
                </div>
              </div>
              <div class="col-md-6" style="width: 100%">
                <div class="row">
                  <div class="col-md-7" style="width: 100%;padding: 0">
                    <img src="../assets/img/index/rightNav2.png" style="width: 100%">
                  </div>
                  <div class="col-md-5"
                       style="width: 100%;padding: 0;display: flex;flex-direction: column;justify-content: center">
                    <div>扫码关注</div>
                    <div>亚木沟景区官方微信</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>


  </div>
</template>

<script>
  export default {
    name: "index2.0",
    data() {
      return {
        num: 0,
        imgListAll: [],
        imgList: [
          {
            src: require('../assets/img/index/img1.png')
          },
          {
            src: require('../assets/img/index/img2.png')
          },
          {
            src: require('../assets/img/index/img1.png')
          },
          {
            src: require('../assets/img/index/img2.png')
          }
        ],
        urlList:['中国旅游网','中国旅游网','中国旅游网']
      }
    },
    created() {
      this.imgListAll = this.imgList.concat(this.imgList).concat(this.imgList)
    },
    mounted() {
      let imgWidthAll = 4 * ($('.imgAll').width() + 30)
      $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
    },
    methods: {
      moveImg(dir) {
        let imgWidth = $('.imgAll').width() + 30          //这个是图片宽度+padding值=移动值
        let marginLeft = 0
        if (dir == 'next') {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) - imgWidth
        } else {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) + imgWidth
        }
        $('#imgMove').css('marginLeft', marginLeft + 'px')
        this.num += 1
        if (this.num == this.imgList.length) {
          //删除第一个数组，移动到最后
          let imgWidthAll = 4 * ($('.imgAll').width() + 30)
          $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
          this.num = 0
        }
      }
    }
  }
</script>

<style scoped>
  @media (min-width: 992px) {
    .kuang {
      margin: 50px 0 0 !important
    }

    .news {
      max-width: 32% !important;
      flex: 0 0 32% !important;
    }

    .newsScroll {
      overflow-x: unset !important;
      flex-wrap: wrap !important;
    }
  }
</style>
