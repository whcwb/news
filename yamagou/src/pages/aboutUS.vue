<template>
  <div style="font-family:MicrosoftYaHei;">

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


      <div class="row" style="margin-top: 60px;margin-bottom: 30px">
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

          <div class="row" style="display: flex;justify-content: space-around;margin-top: 20px">
            <div class="col-md-12">
              <video :src="video[0].viPath" style="width: 100%" controls="controls"></video>
            </div>
          </div>


          <div class="row" style="margin: 0;">
            <div class="col-md-12" style="margin-top: 88px;text-align: center">
              <div class="titleBG" style="width: 250px">
                <img src="../assets/img/index/logo.png"
                     style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                <span style="position: static;z-index: 100">自驾游</span>
                <div class="titleBGBottom"></div>
              </div>
            </div>
          </div>

          <div class="row photo" style="height: 130px;margin: 60px 0 66px 0;">
            <div class="col-md-12">
              <div class="row" style="height: 100%">
                <Card style="font-size: 20px;width: 100%">
                  <p style="padding: 10px 0">亚木沟公路交通因为杭瑞高速（G56）而非常便利，驾驶到江口收费站下高速，经县城走县道X508，出县城大约十分钟能到云舍，再十多分钟能到亚木沟，又十分钟到寨沙侗寨，又五分钟到梵净山。一路都有路牌指示。</p>
                </Card>
              </div>
            </div>
          </div>

          <div class="row photo" style="margin: 60px 0 30px 0;">
            <div class="col-md-12">
              <div class="row jd">
                <div class="col-md-4 pr" v-for="item in zjyList"
                     style="font-family:MicrosoftYaHei;padding: 0;max-width: 31%;flex: 0 0 31%;">
                  <Card>
                    <div slot="title" style="font-size: 20px;padding: 10px 15px">
                      {{item.title}}
                    </div>
                    <div style="width: 100%;height: 300px;">
                      <div
                        style="font-size:17px;margin-top: 10px;height: 100%;overflow-y:scroll">
                        {{item.content}}
                      </div>
                    </div>
                  </Card>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin: 0;">
            <div class="col-md-12" style="margin-top: 0;text-align: center">
              <div class="titleBG" style="width: 250px">
                <img src="../assets/img/index/logo.png"
                     style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                <span style="position: static;z-index: 100">自助游</span>
                <div class="titleBGBottom"></div>
              </div>
            </div>
          </div>

          <div class="row photo" style="height: 200px;margin: 60px 0 66px 0;">
            <div class="col-md-12">
              <div class="row" style="height: 100%">
                <Card style="font-size: 20px;width: 100%">
                  <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">普通列车</span>可查询全国至铜仁、怀化、玉屏三站点列车时刻。
                  </p>

                  <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">贵广高铁</span>已全线贯通，两广方向游客可高铁直达贵阳。
                  </p>

                  <p style="padding: 10px 0"><span style="color: #1c7430;font-weight: 600">沪昆高铁</span>上海至贵阳段已通车，湖南湖北山东安徽江西及江浙地区沿线游客可高铁直达铜仁。
                  </p>
                </Card>
              </div>
            </div>
          </div>

          <div class="row photo" style="margin: 60px 0 30px 0;">
            <div class="col-md-12">
              <div class="row jd">
                <div class="col-md-4 pr" v-for="item in xlList"
                     style="font-family:MicrosoftYaHei;padding: 0;max-width: 31%;flex: 0 0 31%;">
                  <Card>
                    <div slot="title" style="font-size: 20px;padding: 10px 15px">
                      {{item.title}}
                    </div>
                    <div style="width: 100%;height: 300px;">
                      <div v-html="item.content"
                        style="font-size:17px;margin-top: 10px;height: 100%;overflow-y: scroll">
                        {{item.content}}
                      </div>
                    </div>
                  </Card>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="margin: 0;padding: 0 0 100px 0">
            <div class="col-md-12" style="margin-top: 88px;text-align: center">
              <div class="titleBG" style="width: 250px">
                <img src="../assets/img/index/logo.png"
                     style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                <span style="position: static;z-index: 100">公司简介</span>
                <div class="titleBGBottom"></div>
              </div>
            </div>
          </div>

          <div class="row" style="font-size: 18px;">
            <header style="margin: 0 auto;font-size: 25px;font-weight: 500;margin-bottom: 20px">江口金奥旅游开发有限公司简介</header>

            <article style="text-indent: 50px">
              <p>江口金奥旅游开发有限公司于2011年6月9日在贵州省铜仁市江口县成立，注册资本4960万元。公司现有职工76人，其中本科以上学历有18人，专科以上学历的有26人，高级注册会计师1人。主营旅游景区开发及管理、餐饮、中药材种植及销售、民俗文化展示及表演、旅游纪念品销售等，目前已按照国家AAAA级标准独资开发亚木沟风景区，计划投资1.6亿。</p>

              <p>截至目前，公司成立了相对完善的组织架构及管理制度景区制度建设，设置了行政部、工程开发部、旅游部、营销部、财务部、安保部、环卫部等机构，建立起经营管理制度、财会管理制度、工程管理制度、安全管理制度、导游管理制度、游客投诉及处理反馈制度、游客中心管理制度、岗位责任制度等。</p>

              <p>在旅游景区开发方面，一直走“自然风光和人文风情有机结合”的路线，坚持“软硬件建设兼顾，两手都要硬”的发展方针，在经营管理逐渐走入正轨的同时，公司着力于配备旅游文化产业专业人才和团队，广泛吸取当地文化研究成果的精华，不断深入挖掘当地土家族文化和民俗风情。土家风情园、民俗博物馆、蜡染体验馆、土王楼、民俗演艺厅、“土家四坊”等景点，都是公司发展旅游文化产业的典型代表。结合亚木沟原始生态峡谷，景区在人文方面着重开发江口本土文化，包括土家风俗、土家族历史遗迹、土家族歌舞艺术、土家族传统技艺（如印染、纺织、酿酒、造纸、榨油等）、土家农耕文化等等，力求把景区打造成江口土家族文化对外展示的窗口。
              </p>
            </article>
          </div>


          <div class="row" style="margin: 0;">
            <div class="col-md-12" style="margin-top: 88px;text-align: center">
              <div class="titleBG" style="width: 250px">
                <img src="../assets/img/index/logo.png"
                     style="width: 110px;height:40px;padding: 0 15px;position: static;z-index: 100">
                <span style="position: static;z-index: 100">{{$t('m.honor')}}</span>
                <div class="titleBGBottom"></div>
              </div>
            </div>
          </div>

          <div class="row" style="margin-top: 102px;display: flex;justify-content: space-between">
            <div class="col-md-3">
              <img src="../assets/img/contactUS/1.png" style="width: 100%">
            </div>
            <div class="col-md-3">
              <img src="../assets/img/contactUS/2.png" style="width: 100%">
            </div>
            <div class="col-md-3">
              <img src="../assets/img/contactUS/3.png" style="width: 100%">
            </div>
          </div>

          <div class="row" style="display: flex;justify-content: center;margin-top: 13px">
            <div class="col-md-3">
              <img src="../assets/img/contactUS/4.png" style="width: 100%">
            </div>
          </div>


          <!--<div class="row" style="margin: 0;padding: 0 0 121px 0">-->
          <!--<div class="col-md-12" style="margin-top: 88px;text-align: center">-->
          <!--<div class="titleBG" style="width: 30%">-->
          <!--<img src="../assets/img/index/logo.png"-->
          <!--style="width: 40%;height: 70%;padding: 0 15px;position: static;z-index: 100">-->
          <!--<span style="position: static;z-index: 100">景区简介</span>-->
          <!--<div class="titleBGBottom"></div>-->
          <!--</div>-->
          <!--</div>-->
          <!--</div>-->

          <!--<div class="row" style="font-size: 18px;">-->
          <!--<img src="http://13375556.s21i.faiusr.com/2/ABUIABACGAAg2PugxwUo8MGEwgcwgA84kAk.jpg" style="width: 400px;height: 243px;margin: 0 auto;margin-bottom: 20px">-->
          <!--亚木沟风景区位于贵州省铜仁市江口县境内，毗邻梵净山。景区地处江梵公路中段，距杭瑞高速（大思段）梵净山匝道口5公里，距梵净山山门6公里，铜仁站约60公里，距铜仁机场约80公里，交通非常便利，景区大门外设有大型免费停车场，可同时容纳300余辆车。-->

          <!--景区总面积26平方公里，分为亚木沟原始生态峡谷和土家风情园两大板块，景区周边可满足旅游者吃、住、行、游、购、娱各方面需求。游客既可以欣赏原始的自然风光，又可以领略原生态的土家文化诸如原生态歌舞表演、民间绝技等。-->

          <!--据相关文献记载，亚木沟在唐代以前名为“鬼谷”，又叫“隐龙沟”，后因谷中长出一株神树，似石似木，通体碧透，花有异香，能驱邪治病，食其果实，可使多年未育的夫妇得子，引得远近无数土民对其顶礼膜拜，取名为“亚木”，在古土家语里就是“树神”的意思，因而得名“亚木沟”，一直沿用至今。亚木沟自古就被誉为“贵州第一沟”。“贵州第一”源于古籍：唐《蛮志》有“行遍蛮境，未闻有如一也”的说法，而《思州府志》更有“亚木其神，莫可言传；其沟之妙，实甲黔境”的记载。-->

          <!--亚木沟总长18公里，沟里气候宜人，冬无严寒，夏无酷暑，年平均气温在17°C左右。空气负离子浓度含量在每立方米10万-12万，无愧于天然氧吧的美誉。曾有著名诗人在游览亚木沟后挥毫写下“冬暖夏凉神仙谷，山青水秀亚木沟”的赞语。-->

          <!--亚木沟之美，得益于亚木沟之水，水是亚木沟的灵魂。亚木沟之水发源于“武陵之巅”梵净山顶峰，总落差2100米，巨大的落差造就了亚木沟独特、珍稀的自然生态环境。山上物种丰富，有金丝猴、猕猴、黑熊、虎斑碟等珍稀动物，有楠木、红豆衫、桫椤、珙桐（鸽子花）等世界珍稀树种。沟里的水清澈见底，四季常流，山泉叮咚，飞瀑扬花；沟中奇石各异，五彩缤纷，似人似物，似鸟似兽，情态各异，栩栩如生；古木、清水、奇石和谐连缀在一起，在这条狭长曲折的谷里描摹出一幅百里画廊。-->

          <!--谷内有诸多景点如雄关漫道、峡谷飞索、龙洞、亚木飞瀑等，无处不美，无处不奇，游客可以随处取景拍照，也可以坐在沟边亭子中小憩，有时候还能见到各种珍奇动物。每当山顶狂风呼啸，沟中却静谧如常、阴阳和谐，而在雨过天晴后，谷内又霞光万道，动静相宜。当游客朋友在这里甘泉掬水，清流濯足，穿越原始森林时，不由发出“梵净归来不看山，亚木归来不看水”的感叹。-->

          <!--土家风情园，占地1.8万平方米，包括图腾广场、中国第一玉牛、民俗博物馆、蜡染体验坊、土王楼、民俗演艺厅、天下第一大鼓等人文景观亚木沟不仅是一个洗心涤虑、修身养性的寻景探幽妙处，更是一个流淌着传说的文化胜境。游客来到亚木沟，不但可以满足预期的吃、住、游、玩，还能听到很多感人至深的故事，诸如亚木神树、鬼谷神府、龙凤呈祥、情人谷、刘翰林抗匪等，同时游客也可以学习到很多土家文化，亲身体验土家风俗。亚木沟，一个足以让游客流连忘返的好地方。-->
          <!--</div>-->


          <!--<div class="row bg" style="background: none;height: 894px;margin: 30% 0 66px 0;">-->
          <!--<div class="col-md-12 bgP"-->
          <!--style="width:100%;padding:0;height:100%;background:#644A23;border:1px solid rgba(96,195,183,1);">-->
          <!--<div class="row" style="height: 50%;margin: 0">-->
          <!--<div class="col-md-1 d-none d-sm-block" style="height: 100%;"></div>-->
          <!--<div class="col-md-4 heightZ">-->
          <!--<div-->
          <!--style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">-->
          <!--{{$t('m.XM')}}-->
          <!--</div>-->
          <!--<input type="text" v-model="params.name"-->
          <!--style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">-->

          <!--<div class="address"-->
          <!--style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">-->
          <!--{{$t('m.DZ')}}-->
          <!--</div>-->
          <!--<input type="text" v-model="params.addr"-->
          <!--style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">-->

          <!--</div>-->
          <!--<div class="col-md-2 d-none d-sm-block" style="height: 100%;"></div>-->
          <!--<div class="col-md-4" style="height: 100%;">-->
          <!--<div-->
          <!--style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">-->
          <!--{{$t('m.YX')}}-->
          <!--</div>-->
          <!--<input type="text" v-model="params.mail"-->
          <!--style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">-->

          <!--<div class="address"-->
          <!--style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">-->
          <!--{{$t('m.LXDH')}}-->
          <!--</div>-->
          <!--<input type="text" v-model="params.phone"-->
          <!--style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">-->


          <!--</div>-->
          <!--<div class="col-md-1 d-none d-sm-block" style="height: 100%;"></div>-->
          <!--</div>-->
          <!--<div class="row" style="height: 50%;margin: 0">-->
          <!--<div class="col-md-1 d-none d-sm-block"></div>-->
          <!--<div class="col-md-10">-->
          <!--<div style="width: 100%;height: 100%">-->
          <!--<div-->
          <!--style="margin: 0 0 18px 27px;font-size:26px;font-family:MicrosoftYaHei;color:rgba(255,255,255,1);letter-spacing:1px;">-->
          <!--{{$t('m.FKJY')}}-->
          <!--</div>-->
          <!--<textarea class="form-control" style="min-height: 266px;max-height: 266px" v-model="params.advice"-->
          <!--id="exampleFormControlTextarea1" rows="3"></textarea>-->
          <!--<div @click="send"-->
          <!--style="float: right;display: flex;justify-content: center;align-items: center;margin-top: -5%;margin-right: 2%;width:10%;height:8%;background:rgba(100,74,35,1);font-size:18px;color:rgba(255,255,255,1);">-->
          <!--{{$t('m.FX')}}-->
          <!--</div>-->
          <!--</div>-->
          <!--</div>-->
          <!--<div class="col-md-1 d-none d-sm-block"></div>-->
          <!--</div>-->
          <!--</div>-->
          <!--</div>-->
        </div>
        <div class="col-md-1"></div>
      </div>

    </div>
    <div class="container-fluid d-sm-none"
         style="height: 90vh;background:rgba(249,249,249,1);padding: 0;margin-bottom: 4rem">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <!--<img src="../assets/img/index/left.png" style="margin-left: 22px;width: 1rem;height: 80%" @click="toPage('index')">-->
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              关于我们
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <div class="row" style="margin: 0;background: white">
        <div class="col-12">
          <div class="row" style="font-size:14px;font-weight:500;color:rgba(51,51,51,1);margin-top: 22px">
            公司简介
          </div>

          <p style="margin: 10px 0;font-size:14px;font-weight:400;color:rgba(102,102,102,1);text-indent: 30px">
            江口金奥旅游开发有限公司于2011年6月9日在贵州省铜仁市江口县成立，注册资本4960万元。主营旅游景区开发及管理、餐饮、中药材种植及销售、民俗文化展示及表演、旅游纪念品销售等。
          </p>
          <div>

          </div>

        </div>
      </div>

      <div class="row" style="margin: 10px 0 0 0">
        <div class="col-12">
          <div class="row" style="font-size:14px;font-weight:500;color:rgba(51,51,51,1);margin-top: 22px">
            意见反馈
          </div>
          <div class="row">
            <textarea class="form-control" placeholder="有任何意见或者建议请反馈给我们，谢谢！"
                      style="background:rgba(255,255,255,1);border-radius: 0.1rem;margin:1rem 0;background-color: white;height: 12rem;box-shadow:0px 1px 10px 0px rgba(222,223,211,0.5);"
                      v-model="params.advice" id="exampleFormControlTextarea2" rows="3"></textarea>
          </div>

          <div>
            <input type="text" v-model="params.phone" placeholder="请留下您的联系方式"
                   style="width:100%;height:36px;background:rgba(255,255,255,1);border:1px solid rgba(96,195,183,1);">
          </div>

          <div class="row" style="display: flex;justify-content: center;margin: 3rem 0 0 0">
            <div @click="send" class="col-12"
                 style="display: flex;justify-content: center;align-items: center;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);height:2rem;background:rgba(0,216,160,1);border-radius:2px;">
              提交
            </div>
          </div>

        </div>
      </div>

      <div class="row" style="margin: 10px 0 4rem 0">
        <div class="col-12">
          <div class="row" style="font-size:14px;font-weight:500;color:rgba(51,51,51,1);margin-top: 22px">
            联系方式
          </div>

          <p style="margin: 10px 0 0 0;font-size:14px;font-weight:400;color:rgba(102,102,102,1);">
          亚木沟风景区
          </p>

          <p style="font-size:14px;font-weight:400;color:rgba(102,102,102,1);">
            地址：铜仁市江口县太平镇寨抱村
          </p>

          <p style="font-size:14px;font-weight:400;color:rgba(102,102,102,1);margin-bottom: 4rem">
          电话：0856-6622222
          </p>

        </div>
      </div>

    </div>

  </div>
</template>

<script>
  export default {
    name: "aboutUS",
    data() {
      return {
        video: [],
        zjyList: [
          {
            title: '贵阳出发',
            content: '沿贵阳环城高速绕行一小段贵遵高速复线进入贵瓮高速，行驶约71公里经瓮安后转入安江高速往江口方向行驶144公里后进入杭瑞高速G56梵净山东下高速，继续沿X508直行5公里即可抵达亚木沟景区。全程约3小时。'
          },
          {
            title: '重庆出发',
            content: '经兰海高速抵达遵义后经观音寺隧道，遵义一环线驶入杭瑞高速G56向铜仁方向行驶，过湄潭、德江、思南、印江后从梵净山东下高速，继续沿X508直行5公里即可抵达亚木沟景区。全程约6.5小时。'
          },
          {
            title: '长沙出发',
            content: '沿长张高速/G5513行驶（经长沙西收费站），抵达常德后由进入G56杭瑞高速吉首方向行驶，（经凤凰收费站）后继续往铜仁方向行驶，（经铜仁收费站）后往遵义方向行驶，在江口出口下高速，右转进入梵净山大道行驶约5公里到达景区门口。全程约6.5个小时。（距离凤凰古城约1.5小时车程）'
          }
        ],
        xlList: [
          {
            title: '客车',
            content: '1、铜仁客车站\n<br>' +
              '铜仁—江口县，二十分钟一班，全程48公里，车程半个多小时。\n <br>' +
              '车站地址：大庆中路，锦江兴市桥附近\n<br>' +
              '公交车：4路；5路\n' +
              '<br>2、江口县汽车站\n<br>' +
              '江口—亚木沟，可乘坐江口到梵净山的班车，在亚木沟或者寨抱村下，全程大约20公里，车程大约二十分钟。\n<br>' +
              '车站地址：江口县三星西路\n'
          },
          {
            title: '火车',
            content: '铜仁火车站\n<br>' +
              '经过铜仁火车站列车共有十趟，多为K字头\n' +
              '<br>地址：位于碧江区环北街道办事处桐梓坳（东太大道、清水大道、南岳路三条道路的交叉路口）。\n' +
              '<br>公交车：4路；7路；9路\n'
          },
          {
            title: '飞机',
            content: '铜仁凤凰机场\n<br>' +
              '铜仁凤凰机场距铜仁市城区21公里，距凤凰县城34公里，为铜仁市和湘西州共享的机场。\n'
          }
        ],
        params: {
          name: '',
          mail: '',
          addr: '',
          phone: '',
          advice: ''
        }
      }
    },
    created() {
      this.getVideo()
    },
    mounted() {
      var map = new BMap.Map("container");
      var point = new BMap.Point(108.746929, 27.787269);
      map.centerAndZoom(point, 14);
      var marker = new BMap.Marker(point);        // 创建标注
      map.addOverlay(marker);
      var opts = {anchor: BMAP_ANCHOR_TOP_LEFT}
      map.addControl(new BMap.NavigationControl(opts));
    },
    watch: {
      '$i18n.locale': function () {
        this.getVideo()
      }
    },
    methods: {
      send() {
        if(this.params.phone==''||this.params.advice==''){
          alert('信息不完整')
          return
        }

        this.$http.post(this.apis.ADVICE, this.params).then(res => {
          if (res.code === 200) {
            alert('提交成功')
          } else {
            alert(res.message)
          }
        })
      },
      getVideo() {
        // viType: 1 是宣传片 2 是景区视频
        let lang = this.$i18n.locale === 'zh-CN' ? 'CN' : 'EN'
        this.$http.post(this.apis.Video.GETVIDEO, {viLang: lang, viType: 2}).then(res => {
          if (res.code === 200) {
            this.video = res.page.list
          } else {
            alert(res.message)
          }
        })
      },
      toPage(pathName) {
        this.$router.push({
          name: pathName,
        })

      }
    }
  }
</script>

<style scoped>
  .row {
    margin: 0;
  }

  .titleBG {
    /*width:401px;*/
    height: 70px;
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
    height: 70px;
    width: 100%;
    border: 2px solid rgba(100, 74, 35, 1);
    position: absolute;
    left: 18px;
    top: 21px;
    z-index: 99;
  }

  @media (min-width: 992px) {
    .bg {
      margin: 0 0 66px 0 !important;
    }

    .bgP {
      padding: 89px 0 !important;
    }

    .address {
      margin: 89px 0 18px 27px !important;
    }

    .heightZ {
      height: 100% !important;
    }

    .jd {
      display: flex;
      justify-content: space-between;
      margin: 20px 0 0 0;
    }

  }

  /deep/ .ivu-card-head {
    padding: 0;
  }

  ::-webkit-scrollbar {
    width: 0 !important;
  }

  ::-webkit-scrollbar {
    width: 0 !important;
    height: 0;
  }
</style>
