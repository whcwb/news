<template>
  <div id="app">
    <div class="row" style="margin: 0;background-color: #595959;color: #FFCC00">
      <div class="col-xs-0 col-md-1"></div>
      <div class="col-xs-0 col-md-10">
        <div class="row" style="height: 30px;line-height: 30px;font-size: 13px">
          <div class="col-md-2 col-6">
            亚木沟——神仙度假地
          </div>
          <div class="col-md-2 d-none d-sm-block" style="text-align: center;color: white">
            武汉 <span style="color: #009944">25°</span>~<span style="color: red">33°</span>
          </div>
          <div class="col-md-4 d-none d-sm-block" style="text-align: center">
            景区服务热线：0898-38661116 0898-5412541
          </div>
          <div class="col-md-4 col-6" style="text-align: right">
            <span style="color: white" @click="changeLanuage">English</span>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="container-fluid" id="navAll" style="color: white;top: 30px;z-index: 9999">
      <div class="row" style="background-color: #EFE6D1">
        <!--大屏显示,小屏隐藏-->
        <div class="col-md-3 d-none d-sm-flex"
             style="left: 20px;width: 100%;justify-content: center;align-items: center">
          <img src="./assets/img/index/logo.png" style="width: 55%;z-index: 9999;top: 15px;left: 15px">
        </div>


        <div class="col-xs-24 col-md-8" style="padding: 0">

          <b-navbar id="nav" toggleable="sm" type="light" variant="light">
            <b-navbar-toggle target="nav-text-collapse"></b-navbar-toggle>
            <b-navbar-brand class="d-sm-none" @click="toPage('index')" style="color: white;font-size: 1rem">{{$t('m.index')}}</b-navbar-brand>
            <b-collapse id="nav-text-collapse" is-nav>
              <b-navbar-nav>

                <b-nav-item class="d-sm-none" v-for="item in navList" href="#">
                <span style="color: black" @click.native="toPage(item.path)">
                  {{$t(item.text)}}
                </span>
                </b-nav-item>

                <div style="display: flex;flex-direction: column">
                  <div class="row" style="display: flex;flex-direction: row;">
                    <b-nav-item-dropdown class="d-none d-sm-block"  v-for="item in navList" right>
                        <div slot="text" @click="toPage(item.path)" style="display: flex;flex-direction: column;align-items: center">
                          <img src="./assets/img/index/rightNav1.png" class="d-inline-block align-top"
                               style="width: 70px;height: 70px">
                          {{$t(item.text)}}
                        </div>
                      <b-dropdown-item v-if="item.child!=undefined" v-for="child in item.child" href="#">
                        {{$t(child.text)}}
                      </b-dropdown-item>
                    </b-nav-item-dropdown>
                  </div>
                </div>

              </b-navbar-nav>
            </b-collapse>
          </b-navbar>
        </div>
        <div class="col-xs-0 col-md-2"></div>
      </div>
    </div>

    <router-view/>

    <!--<div class="row yj" style="height: 400px;margin: 100px 0 0 0;color: white;background-color: #2D2F3C">-->
    <!--<div class="col-xs-0 col-md-2"></div>-->
    <!--<div class="col-xs-12 col-md-8">-->
    <!--<div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 60%">-->
    <!--<div class="col-xs-4 col-md-2 bottomNav" v-for="item in bottomNavList"-->
    <!--style="text-align: center;padding: 20px;display: flex;justify-content: space-between">-->
    <!--<div>-->
    <!--{{$t(item.head)}}-->
    <!--</div>-->
    <!--<div v-for="child in item.child" style="font-size: 15px;">-->
    <!--{{$t(child.title)}}-->
    <!--</div>-->
    <!--</div>-->
    <!--</div>-->
    <!--<div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 20%">-->
    <!--<img src="./assets/img/bottomlogo.png" style="width: 100%">-->
    <!--</div>-->
    <!--<div class="row" style="display: flex;justify-content: space-around;align-items: center;height: 20%">-->
    <!--2002-2019亚木沟风景名胜区管理局 贵ICP备15014791号-1-->
    <!--</div>-->
    <!--</div>-->
    <!--<div class="col-xs-0 col-md-2"></div>-->
    <!--</div>-->

    <div class="row" style="height: 200px;background-color: #BA8E51;margin: 0">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row" style="height: 100%">
          <div class="col-md-2" style="display: flex;align-items: center">
            <img src="./assets/img/index/logo.png" style="width: 100%">
          </div>
          <div class="col-md-5"
               style="color: white;font-size:17px;display: flex;justify-content: center;flex-direction: column">
            <div>
              精选攻略 | 核心资源 | 近期活动 | 绚丽美图 | 联系方式
            </div>
            <div>
              关于我们 | 企业文化 | 人才招聘
            </div>
            <div>
              亚木沟景区
            </div>
            <div>
              CopyRight 2002-2019亚木沟风景名胜区管理局 贵ICP备15014791号-1
            </div>
          </div>
          <div class="col-md-5"
               style="color: white;text-align: right;display: flex;justify-content: center;flex-direction: column">
            <span>
              全国统一服务热线: <span style="font-size: 25px">(0895)-54524512</span>
            </span>
            <span>
              关注我们
            </span>
            <span>
              公安部备案号:216552635
            </span>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

  </div>
</template>

<script>
  $(document).ready(function () {
    // navbar的样式修改
    $(".b-nav-dropdown").hover(function () {
      var $b = $($(this).children("ul")[0])               //$b为ul的jquery对象
      var $c = $($b.prev().children("span")[0])
      $b.addClass("show")
      $c.css('color', '#A60002')
      // $b.prev().css('backgroundColor', 'white')
    }, function () {
      var $b = $($(this).children("ul")[0])
      var $c = $($b.prev().children("span")[0])
      $c.css('color', 'black')
      $b.removeClass("show")
      // $b.prev().css('background', 'none')
    });

    $(".dropdown-toggle").addClass("gg");       //去除下拉列表的三角符号

    $(".navbar-toggler").css('backgroundColor', 'white')
    $($(".dropdown-menu-right")[0]).removeClass('dropdown-menu')
    $($(".dropdown-menu-right")[0]).css('display','none')
    $($(".dropdown-menu-right")[0]).removeClass('dropdown-menu-right')
  });

  export default {
    name: 'App',
    created() {
    },
    mounted() {
      var v = this
      var navHeight = 0;

      // 移动端导航栏一级标题的点击事件
      $(".d-sm-none").click(function () {
        let index1 = $('.navbar-nav .d-sm-none').index($(this))
        v.toPage(v.navList[index1].path)
        // console.log(index1)
      })

      $(document).scroll(function () {
        navHeight = $("#nav").outerHeight(true)
        if ($(this).scrollTop() > navHeight+30) {
          $('#navAll').css('position', 'fixed').css('top','0')
        }
        else $('#navAll').css('position', 'static')
      })

    },
    methods: {
      changeLanuage() {
        if (this.$i18n.locale === 'zh-CN') {
          this.$i18n.locale = 'en-US';
        } else {
          this.$i18n.locale = 'zh-CN';
        }
      },
      toPage(pathName) {
        $('body,html').animate({scrollTop: 0}, 500);
        this.$router.push({
          name: pathName
        })
      }
    },
    data() {
      return {
        bottomNavList: [
          {
            head: 'm.aboutUS',
            child: [
              {
                title: 'm.company',
                path: ''
              },
              {
                title: 'm.group',
                path: ''
              },
              {
                title: 'm.honor',
                path: ''
              },
              {
                title: 'm.position',
                path: ''
              }
            ]
          },
          {
            head: 'm.ContactUS',
            child: [
              {
                title: 'm.LXFS',
                path: ''
              },
              {
                title: 'm.ZNDT',
                path: ''
              },
              {
                title: 'm.ZXLY',
                path: ''
              },
              {
                title: 'm.TSJY',
                path: ''
              }
            ]
          },
          {
            head: 'm.ContactUS',
            child: [
              {
                title: 'm.LXFS',
                path: ''
              },
              {
                title: 'm.ZNDT',
                path: ''
              },
              {
                title: 'm.ZXLY',
                path: ''
              },
              {
                title: 'm.TSJY',
                path: ''
              }
            ]
          },
          {
            head: 'm.ContactUS',
            child: [
              {
                title: 'm.LXFS',
                path: ''
              },
              {
                title: 'm.ZNDT',
                path: ''
              },
              {
                title: 'm.ZXLY',
                path: ''
              },
              {
                title: 'm.TSJY',
                path: ''
              }
            ]
          },
          {
            head: 'm.ContactUS',
            child: [
              {
                title: 'm.LXFS',
                path: ''
              },
              {
                title: 'm.ZNDT',
                path: ''
              },
              {
                title: 'm.ZXLY',
                path: ''
              },
              {
                title: 'm.TSJY',
                path: ''
              }
            ]
          }
        ],
        navList: [
          {
            text: 'm.index',
            path: 'index',
          },
          {
            text: 'm.aboutUS',
            path: '',
            child: [
              {
                text: 'm.company',
                path: ''
              },
              {
                text: 'm.group',
                path: ''
              },
              {
                text: 'm.honor',
                path: ''
              },
              {
                text: 'm.position',
                path: ''
              },
              {
                text: 'm.videoCenter',
                path: ''
              }
            ]
          },
          {
            text: 'm.Activity',
            path: '',
            child: [
              {
                text: 'm.news',
                path: ''
              },
              {
                text: 'm.dynamic',
                path: ''
              },
              {
                text: 'm.Event',
                path: ''
              },
              {
                text: 'm.TourismPolicy',
                path: ''
              }
            ]
          },
          {
            text: 'm.PlayInYMG',
            path: '',
            child: [
              {
                text: 'm.YMGDXG',
                path: ''
              },
              {
                text: 'm.MCGZ',
                path: ''
              },
              {
                text: 'm.MSBWG',
                path: ''
              },
              {
                text: 'm.NMG',
                path: ''
              }
              ,
              {
                text: 'm.YYT',
                path: ''
              }
              ,
              {
                text: 'm.TWL',
                path: ''
              }
              ,
              {
                text: 'm.LRF',
                path: ''
              }
            ]
          },
          {
            text: 'm.Play',
            path: 'WZYMG',
            child: [
              {
                text: 'm.TSMS',
                path: ''
              },
              {
                text: 'm.JDSS',
                path: ''
              },
              {
                text: 'm.XXYL',
                path: ''
              },
              {
                text: 'm.TSSP',
                path: ''
              }
              ,
              {
                text: 'm.JTXL',
                path: ''
              }
              ,
              {
                text: 'm.JCHD',
                path: ''
              }
            ]
          },
          {
            text: 'm.TravelGuides',
            path: 'LYGL',
            child: [
              {
                text: 'm.GFGL',
                path: ''
              },
              {
                text: 'm.DRGL',
                path: ''
              },
              {
                text: 'm.ZJYXL',
                path: ''
              }
            ]
          },
          {
            text: 'm.Booking',
            path: 'onlineBooking',
            child: [
              {
                text: 'm.JQMP',
                path: ''
              },
              {
                text: 'm.ZXYD',
                path: ''
              }
            ]
          },
          {
            text: 'm.ContactUS',
            path: 'contactUS',
            child: [
              {
                text: 'm.LXFS',
                path: ''
              },
              {
                text: 'm.ZNDT',
                path: ''
              },
              {
                text: 'm.ZXLY',
                path: ''
              },
              {
                text: 'm.TSJY',
                path: ''
              }
            ]
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

  #nav {
    /*background: none !important;*/
    background-color: #EFE6D1 !important;
    color: black !important;
  }

  .navbar-collapse {
    justify-content: space-around !important;
  }

  .navbar-brand {
    margin-right: 0 !important;
    font-size: 20px !important;
  }

  a span, li a {
    color: black;
    font-size: 20px;
  }

  .navbar .nav > li:hover .dropdown-menu {
    display: block;
  }

  .gg:after {
    display: none !important;
  }

  /deep/ .navbar-toggler {
    color: white;
    background-color: white !important;
    border: 1px solid white !important;
  }

  @media (min-width: 992px) {
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
