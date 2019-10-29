<template>
  <div id="app" style="font-family:MicrosoftYaHei;">
    <div class="row d-none d-sm-flex" style="margin: 0;background-color: #595959;color: #FFCC00">
      <div class="col-xs-0 col-md-1"></div>
      <div class="col-xs-0 col-md-10">
        <div class="row" style="height: 30px;line-height: 30px;font-size: 13px">
          <div class="col-md-2 col-6">
            亚木沟——神仙度假地
          </div>
          <div class="col-md-2 d-none d-sm-block" style="text-align: center;color: white;padding-top: 5px">
            <iframe scrolling="no"  src="https://tianqiapi.com/api.php?style=te&skin=pitaya&color=FFCC00&city=铜仁" frameborder="0" width="200" height="100%" allowtransparency="true"></iframe>
          </div>
          <div class="col-md-4 d-none d-sm-block" style="text-align: center">
            {{$t('m.JQFWRX')}}：0856-6622222
          </div>
          <div class="col-md-4 col-6" style="text-align: right">
            <span style="color: white;cursor: pointer" @click="changeLanuage">{{lang}}</span>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>


    <div class="container-fluid" id="navAll" style="color: white;top: 30px;z-index: 9999">

      <div class="row bg" style="display: flex;align-items: center;">
        <!--大屏显示,小屏隐藏-->
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row" style="justify-content: space-between">
            <div class="col-md-3 d-none d-sm-flex"
                 style="left: 20px;width: 100%;justify-content: left;align-items: center">
              <!--<img src="./assets/img/index/logo.png" style="width: 55%;z-index: 9999;top: 15px;left: 15px">-->
            </div>

            <!--顶部导航栏移动端隐藏-->
            <div class="col-md-8 d-none d-sm-block" style="padding: 0;">

              <b-navbar id="nav" toggleable="sm" type="light" variant="light">
                <b-navbar-toggle target="nav-text-collapse"></b-navbar-toggle>
                <b-navbar-brand class="d-sm-none" @click="toPage('index')" style="color: white;font-size: 1rem">
                  {{$t('m.index')}}
                </b-navbar-brand>
                <b-collapse id="nav-text-collapse" is-nav>
                  <b-navbar-nav>

                    <b-nav-item class="d-sm-none" v-for="item in navList" href="#">
                <span style="color: black" @click.native="toPage(item.path)">
                  {{$t(item.text)}}
                </span>
                    </b-nav-item>

                    <div style="display: flex;flex-direction: column">
                      <div class="row" style="display: flex;flex-direction: row;">
                        <b-nav-item-dropdown class="d-none d-sm-block"  v-for="(item,index) in navList" right>
                          <div slot="text" @click="toPage(item.path)" style="position: relative;display: flex;flex-direction: column;align-items: center">
                            <img :src="item.img" class="d-inline-block align-top"
                                 style="width: 80px;height: 80px;">
                            <span style="position: absolute;bottom: -5px;font-size: 15px">{{$t(item.text)}}</span>
                          </div>
                          <b-dropdown-item @click.native="toPage(child.path,child.listName,child.type)" v-if="item.child!=undefined" v-for="child in item.child" href="#">
                            {{$t(child.text)}}
                          </b-dropdown-item>
                        </b-nav-item-dropdown>
                      </div>
                    </div>

                    <!--<div style="display: flex;flex-direction: column">-->
                    <!--<div class="row" style="display: flex;flex-direction: row;justify-content: space-around">-->
                    <!--<b-nav-item-dropdown class="d-none d-sm-block" v-for="item in navList" :text="$t(item.text)" right>-->
                    <!--<b-dropdown-item v-if="item.child!=undefined" v-for="child in item.child" href="#"-->
                    <!--@click.native="toPage(child.path,child.listName)">-->
                    <!--{{$t(child.text)}}-->
                    <!--</b-dropdown-item>-->
                    <!--</b-nav-item-dropdown>-->
                    <!--<b-nav-item href="#" @click="changeLanuage">-->
                    <!--<img src="./assets/img/index/lanauage.png" style="width: 25px">-->
                    <!--</b-nav-item>-->
                    <!--</div>-->
                    <!--</div>-->

                  </b-navbar-nav>
                </b-collapse>
              </b-navbar>
            </div>
          </div>

        </div>
        <div class="col-md-1"></div>


        <!--<div class="col-md-1">-->
        <!--</div>-->
      </div>
    </div>

    <!--<b-carousel-->
      <!--class="row yj d-none d-sm-flex"-->
      <!--id="carousel-1"-->
      <!--v-model="slide"-->
      <!--:interval="4000"-->
      <!--controls-->
      <!--indicators-->
      <!--background="#ababab"-->
      <!--img-width="1024"-->
      <!--img-height="480"-->
      <!--style="text-shadow: 1px 1px 2px #333;margin: 0"-->
    <!--&gt;-->
      <!--<b-carousel-slide v-for="item in bannerList">-->
        <!--<img-->
          <!--slot="img"-->
          <!--class="d-block img-fluid w-100"-->
          <!--width="1024"-->
          <!--height="480"-->
          <!--:src="item.banImg"-->
        <!--&gt;-->
      <!--</b-carousel-slide>-->

    <!--</b-carousel>-->

    <router-view v-if="reload"/>

    <!--PC端页脚-->
    <div class="row yj d-none d-sm-flex" style="height:250px;margin: 0;color: white;background-color: #644A23">
      <div class="col-md-2"></div>
      <div class="col-md-8">
        <div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 60%">
          <div class="col-xs-4 col-md-2 bottomNav" v-for="item in bottomNavList"
               style="text-align: center;padding: 20px;display: flex;justify-content: space-between">
            <!--<div style="font-size: 17px;">-->
              <!--{{$t(item.head)}}-->
            <!--</div>-->
            <div v-for="child in item.child" style="cursor: pointer;font-size: 15px;">
              <span v-if="!child.link" @click="toPage(child.path,child.listName,child.type)">{{$t(child.title)}}</span>
              <a v-else :href="child.path" target="_blank" style="color: white;">{{$t(child.title)}}</a>
            </div>
          </div>
        </div>
        <!--<div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 20%">-->
          <!--<img src="./assets/img/bottomlogo.png" style="width: 100%">-->
        <!--</div>-->
        <div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 20%">
          贵公网安备 52062102001023号
          ©2019 亚木沟风景区 版权所有
          黔ICP备12003888号
        </div>
      </div>
      <div class="col-md-2"></div>
    </div>

    <!--移动端页脚-->
    <div class="row d-sm-none" style="margin: 0">
      <div class="col-12 phoneYJ">
        <div class="row" style="height: 100%;margin: 0">
          <div class="col-3 phoneNavItem" v-for="(item,index) in phoneNavList" @click="tabChange(index,item)" style="padding: 5px 10px;display: flex;flex-direction: column;align-items: center">
            <img v-if="item.clicked" :src="item.clickedSrc" style="width: 2.3rem;height: 2.3rem">
            <img v-else :src="item.src" style="width: 2.3rem;height: 2.3rem">
            <div :class="item.clicked?'tabbtn tabbtnbtnClick':'tabbtn'">
              {{item.text}}
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  $(document).ready(function () {
    // navbar的样式修改
    $(".b-nav-dropdown").hover(function (e) {
      var $b = $($(this).children("ul")[0])               //$b为ul的jquery对象
      // var $c = $($b.prev().children("span")[0])
      $b.addClass("show")
      // $c.css('color', 'black')
      $b.prev().css('backgroundColor', 'white')
      $b.prev().css('boxShadow', '0 2px 7px #707070')

      if($(".b-nav-dropdown").index(this)==0||$(".b-nav-dropdown").index(this)==2||$(".b-nav-dropdown").index(this)==$(".b-nav-dropdown").length-1||$(".b-nav-dropdown").index(this)==$(".b-nav-dropdown").length-2||$(".b-nav-dropdown").index(this)==$(".b-nav-dropdown").length-3){
        $($(this).children("a")[0]).css('borderRadius', '6px')
      }else {
        $($(this).children("a")[0]).css('borderRadius', '6px 6px 0 0')
      }

      $b.css('top','98%')
      $b.css('border','none')
      $b.css('borderRadius', '6px 0 6px 6px')
      $b.css('boxShadow', '-3px 6px 7px #707070')
    }, function () {
      var $b = $($(this).children("ul")[0])
      // var $c = $($b.prev().children("span")[0])
      // $c.css('color', 'black')
      $b.removeClass("show")
      $b.prev().css('background', 'none')
      $b.prev().css('boxShadow', 'none')
      $b.prev().css('borderRadius', '0')
    });

    $(".dropdown-toggle").addClass("gg");       //去除下拉列表的三角符号

    $(".navbar-toggler").css('backgroundColor', 'white')
    $($(".dropdown-menu-right")[0]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[0]).css('display', 'none')
    $($(".dropdown-menu-right")[0]).removeClass('dropdown-menu-right')


    $($(".dropdown-menu-right")[1]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[1]).css('display', 'none')
    $($(".dropdown-menu-right")[1]).removeClass('dropdown-menu-right')

    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).css('display', 'none')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu-right')

    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).css('display', 'none')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu-right')

    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).css('display', 'none')
    $($(".dropdown-menu-right")[$(".dropdown-menu-right").length-1]).removeClass('dropdown-menu-right')

  });

  export default {
    name: 'App',
    mounted() {
      var v = this
      var navHeight = 0;


      // PC端导航栏一级标题的点击事件
      $(".dropdown-toggle").click(function () {
        let index = $('.navbar-nav .b-nav-dropdown').index($(this).parent())
        v.toPage(v.navList[index].path)
      })


      // 导航栏固定定位
      $(document).scroll(function () {
        navHeight = $("#nav").outerHeight(true)
        if ($(this).scrollTop() > navHeight + 30) {
          $('#navAll').css('position', 'fixed').css('top', '0')
        }
        else $('#navAll').css('position', 'static')
      })

    },
    methods: {
      changeLanuage() {
        if (this.$i18n.locale === 'zh-CN') {
          this.$i18n.locale = 'en-US';
          this.lang='中文'
        } else {
          this.$i18n.locale = 'zh-CN';
          this.lang='English'
        }
      },
      toPage(pathName, listName,type) {
        // 首页banner全屏，其他的banner高度为200px
        if (pathName !== 'index') {
          $('.img-fluid').css('height', '200px')

        }
        else {
          $('.img-fluid').css('height', 'auto')
        }

        if(pathName==='yzymg') $('.img-fluid').css('height', '0')

        // 回到顶部
        $('body,html').animate({scrollTop: 0}, 500);

        if(pathName==='LYGL'&&!listName){
          this.$router.push({
            path:'/LYGL/0'
          })
          return
        }

        if(pathName==='wzymg'&&!type){
          this.$router.push({
            path:'/wzymg/2'
          })
          return
        }

        if (type) {
          this.$router.push({
            path:'/'+pathName+'/'+type
          })
        } else {
          this.$router.push({
            name: pathName
          })
        }

        // 如果点击的是二级标题
        if (listName) {
          this.$router.push({
            path:'/'+pathName+'/'+listName
          })
        } else {
          this.$router.push({
            name: pathName
          })
        }
      },
      tabChange(index, item) {
        this.phoneNavList.map((val, index, arr) => {
          val.clicked = false
        })
        this.phoneNavList[index].clicked = true
        this.toPage(item.pathName)
      },
      getBanner(){
        this.$http.post(this.apis.Banner.GETBANNER,this.params).then(res=>{
            if(res.code===200){
              this.bannerList=res.page.list
            }else {

            }
        })
      },
    },
    created(){
      this.getBanner()
    },
    data() {
      return {
        params:{
          pageSize:5,
          pageNum:1
        },
        bannerList:[],
        slide: 0,
        lang:'English',               //语言切换提示文字
        reload: true,
        bottomNavList: [
          {
            head: 'm.aboutUS',
            child: [
              {
                title: 'm.aboutUS',
                path: 'aboutUS'
              },
              {
                title: 'm.JXGL',
                path: 'LYGL'
              },
              {
                title: 'm.JTXL',
                path: 'wzymg',
                type:6
              }
            ]
          },
          {
            head: 'm.JQGK',
            child: [
              {
                title: 'm.JQJS',
                path: 'jqjs'
              },

              {
                title: 'm.JQLX',
                path: 'yzymg'
              },
              {
                title: 'm.MPYD',
                path: 'onlineBooking'
              }
            ]
          },
          {
            head: 'm.TJJX',
            child: [
              {
                title: 'm.JXMS',
                path: 'wzymg',
                type:2
              },
              {
                title: 'm.JDRZ',
                path: 'wzymg',
                type:3
              },
              {
                title: 'm.TSSP',
                path: 'wzymg',
                type:5
              }
            ]
          },
          {
            head: 'm.YWZN',
            child: [
              {
                title: 'm.GZZF',
                link:true,
                path: 'http://www.guizhou.gov.cn/'
              },
              {
                title: 'm.TRZF',
                link:true,
                path: 'http://www.trs.gov.cn/'
              },
              {
                title: 'm.JKZF',
                link:true,
                path: 'http://www.jiangkou.gov.cn/'
              }
            ]
          }
        ],
        navList: [
          {
            text: 'm.index',
            img:require('./assets/img/index/nav1.png'),
            path: 'index'
          },
          {
            text: 'm.Activity',
            img:require('./assets/img/index/nav2.png'),
            path: 'localNews',
            child: [
              {
                text: 'm.news',
                path: 'localNews'
              },
              {
                text: 'm.XWZW',
                path: 'ZWXW'
              }
            ]
          },
          {
            text: 'm.PlayInYMG',
            img:require('./assets/img/index/nav3.png'),
            path: 'yzymg',
            // child: [
            //   {
            //     text: 'm.YMGDXG',
            //     path: ''
            //   },
            //   {
            //     text: 'm.MCGZ',
            //     path: ''
            //   },
            //   {
            //     text: 'm.MSBWG',
            //     path: ''
            //   },
            //   {
            //     text: 'm.NMG',
            //     path: ''
            //   }
            //   ,
            //   {
            //     text: 'm.YYT',
            //     path: ''
            //   }
            //   ,
            //   {
            //     text: 'm.TWL',
            //     path: ''
            //   }
            //   ,
            //   {
            //     text: 'm.LRF',
            //     path: ''
            //   }
            // ]
          },
          {
            text: 'm.Play',
            img:require('./assets/img/index/nav4.png'),
            path: 'wzymg',
            child: [
              {
                text: 'm.TSMS',
                path: 'wzymg',
                // listName: '美食',
                type:2
              },
              {
                text: 'm.JDSS',
                path: 'wzymg',
                // listName: '住宿',
                type:3
              },
              {
                text: 'm.XXYL',
                path: 'wzymg',
                // listName: '休闲娱乐',
                type:4
              },
              {
                text: 'm.TSSP',
                path: 'wzymg',
                // listName: '特色商品',
                type:5
              }
              ,
              {
                text: 'm.jtxl',
                path: 'wzymg',
                type:6
              }
              // {
              //   text: 'm.JTXL',
              //   path: 'wzymg_more',
              //   listName: '交通'
              // }
              // ,
              // {
              //   text: 'm.JCHD',
              //   path: 'wzymg_more',
              //   listName: '精彩活动'
              // }
            ]
          },
          {
            text: 'm.TravelGuides',
            img:require('./assets/img/index/nav5.png'),
            path: 'LYGL',
            // child: [
            //   {
            //     text: 'm.GFGL',
            //     path: 'LYGL',
            //     listName: '0'
            //   },
            //   {
            //     text: 'm.DRGL',
            //     path: 'LYGL',
            //     listName: '1'
            //   },
            //   {
            //     text: 'm.ZJYXL',
            //     path: 'LYGL',
            //     listName: '2'
            //   }
            // ]
          },
          {
            text: 'm.Booking',
            img:require('./assets/img/index/nav6.png'),
            path: 'onlineBooking',
            // child: [
            //   {
            //     text: 'm.JQMP',
            //     path: ''
            //   },
            //   {
            //     text: 'm.ZXYD',
            //     path: ''
            //   }
            // ]
          },
          // {
          //   text: 'm.ContactUS',
          //   path:'contactUS',
          //   child: [
          //     {
          //       text: 'm.LXFS',
          //       path: ''
          //     },
          //     {
          //       text: 'm.ZNDT',
          //       path: ''
          //     },
          //     {
          //       text: 'm.ZXLY',
          //       path: ''
          //     },
          //     {
          //       text: 'm.TSJY',
          //       path: ''
          //     }
          //   ]
          // },
          {
            text: 'm.aboutUS',
            img:require('./assets/img/index/nav7.png'),
            path: 'aboutUS',
          },
        ],
        phoneNavList: [
          {
            src: require('./assets/img/UNbottomTab1.png'),
            clickedSrc: require('./assets/img/bottomTab1.png'),
            pathName: 'index',
            text: '首页',
            clicked: true
          },
          {
            src: require('./assets/img/UNbottomTab2.png'),
            clickedSrc: require('./assets/img/bottomTab2.png'),
            pathName: 'yzymg',
            text: '游在亚木沟',
            clicked: false
          },
          {
            src: require('./assets/img/UNbottomTab3.png'),
            clickedSrc: require('./assets/img/bottomTab3.png'),
            pathName: 'wzymg',
            text: '玩转亚木沟',
            clicked: false
          },
          {
            src: require('./assets/img/UNbottomTab4.png'),
            clickedSrc: require('./assets/img/bottonTab4.png'),
            pathName: 'aboutUS',
            text: '关于我们',
            clicked: false
          }
        ]
      }
    }
  }
</script>

<style>
  @import '../static/css/font.css';

  #app {
    /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
    /*-webkit-font-smoothing: antialiased;*/
    /*-moz-osx-font-smoothing: grayscale;*/
    /*text-align: center;*/
    /*color: #2c3e50;*/
    /*margin-top: 60px;*/
    /*height: 3000px;*/
  }

  .tabbtn {
    height: 45%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 0.7rem;
    color: black;
    padding: 0;
    border: none;
  }

  .tabbtnbtnClick {
    color: #20DDAC !important;
  }

  .phoneYJ {
    height: 4rem;
    position: fixed !important;
    bottom: 0;
    padding: 0;
    background-color: white;
  }

  .phoneNavItem {
    height: 100%;
  }

  #nav {
    background: none !important;
    /*background-color:rgba(11,20,2,0.5)!important*/
  }

  .bg {
    background-image: url("./assets/img/index/top.png");
    background-repeat: no-repeat;
    background-size: cover;
  }

  .navbar-collapse {
    justify-content: space-around !important;
  }

  .navbar-brand {
    margin-right: 0 !important;
    font-size: 20px !important;
  }

  a span, li a {
    color: black !important;
    font-size: 17px;
  }

  .navbar .nav > li:hover .dropdown-menu {
    display: block;
  }

  .gg:after {
    display: none !important;
  }

  .dropdown-menu{
    min-width: 8rem !important;
  }

  /deep/ .navbar{
    padding: 0.2rem 0.5rem !important;
  }

  /deep/ .navbar-toggler {
    color:  white;
    background-color: white !important;
    border: 1px solid white !important;
  }

  @media (min-width: 992px) {
    /*.overflowWidth {*/
    /*max-width: 55%;*/
    /*flex: 0 0 55%;*/
    /*}*/
    .nav {
      background: none !important
    }

    .qyymg {
      margin: 88px 0 4px 0 !important;
    }

    .newsText {
      height: 100% !important;
    }

    .newsMonth {
      height: 100% !important;
    }

    .bottomNav {
      height: 100%;
      flex-direction: column;
    }

    .photo {
      height: 500px;
    }

    .photo1 {
      height: 100%;
    }
  }


</style>
