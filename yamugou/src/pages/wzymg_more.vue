<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="row" style="margin: 0">
      <div class="col-md-12" style="padding: 0">
        <img src="../assets/img/banner.png" style="width: 100%">
      </div>
    </div>
    <div class="row" style="margin: 43px 0 0 0;">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="row" style="font-size:20px;margin: 10px 0 0 10px">
          <span @click="toPage('wzymg',false)">{{$t('m.Play')}}></span><span style="color:#644A23;" @click="toPage('wzymg',true)">{{$t('m.'+enListName)}}</span>
        </div>

        <div class="row" style="margin: 0 0 66px 0;">
          <div class="col-md-12">

            <div class="row jd">
              <div class="col-md-4 pr" v-for="item in itemList" :style="{visibility:item.isEmpty===1?'hidden':'visible'}">
                <Card style="background: white">
                  <div slot="title">
                    <img :src="item.img" style="width: 100%;height: 230px">
                  </div>
                  <div style="width: 100%;height: 300px;">
                    <div
                      style="text-align: center;font-size:22px;color:rgba(51,51,51,1);text-overflow: ellipsis;overflow: hidden;white-space: nowrap">
                      {{item.title}}
                    </div>
                    <div
                      style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                      {{item.content}}
                    </div>
                    <div class="btn" @click="toPage('wzymg_Sec',false,item)"
                         style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                      {{$t('m.LJQW')}}
                    </div>
                  </div>
                </Card>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>

    <div class="row pageLink" style="margin: 50px 0 0 0;padding: 0 0 180px 0">
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
</template>

<script>
  export default {
    name: "wzymg_more",
    data() {
      return {
        perPage: 6,
        currentPage: 1,
        rows:5,
        listName: '',
        enListName:'',
        itemList:[]
      }
    },
    created() {
      this.listName = this.$route.params.listName
      this.getData()
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
    watch: {
      '$route' (to, from) {
        this.listName = this.$route.params.listName
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
        this.getData()
      },
      currentPage(val){
        this.getData()
      }
    },
    methods: {
      getData(){
        let type=''
        switch (this.listName) {
          case '美食':type='2';
            break;
          case '住宿':type='3';
            break;
          case '休闲娱乐':type='4';
            break;
          case '特色商品':type='5';
            break;
        }

        this.$http.post(this.apis.JD.GETJD, {pageNum: this.currentPage, pageSize: 6, type: type}).then(res => {
          if (res.code === 200) {
            this.itemList = res.page.list
            this.rows=res.page.total

            if(this.itemList.length%2!=0&&this.itemList.length%3!=0){
              this.itemList.push({isEmpty:1})
            }

          } else {

          }
        })

      },
      /*@params:
      pathName:route名
      isFix:是否需要锚点定位*/
      toPage(pathName, isFix,item) {
        if (isFix) {
          this.$router.push({
            name: pathName,
            params: {
              listName: this.listName
            }
          })
        } else {
          $('body,html').animate({scrollTop: 0}, 500);

          if(pathName==='wzymg_Sec'){
            this.$router.push({
              name: 'wzymg_Sec',
              params: {
                listName: this.listName,
                item: item,
                GD:true
              }
            })
            return
          }



          this.$router.push({
            name: pathName,
          })
        }
      }
    }
  }
</script>

<style scoped>
  /*.pageBtn {*/
    /*display: flex;*/
    /*justify-content: center;*/
    /*align-items: center;*/
    /*width: 146px;*/
    /*height: 48px;*/
    /*color: white !important;*/
    /*background-color: #644A23;*/
  /*}*/

  .pr{
    margin-bottom: 30px;
    padding: 0;
    max-width: 29%;
    flex: 0 0 29%;
  }

  /*.jd::after{*/
    /*flex: auto;*/
    /*content: "";*/
  /*}*/

  /deep/ .page-item.active .page-link {
    background-color: #644A23 !important;
    border-color: #644A23 !important;
    color: white !important;
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

  .item {
    width: 100%;
    height: 100%;
    /*background: rgba(255, 255, 255, 1);*/
    /*border-bottom: 1px solid rgba(151, 151, 151, 1);*/
    padding: 0 14px 0 45px;
  }

  .jd{
    display: flex;
    justify-content: space-between;
    margin: 20px 0 0 0;
  }

  /deep/ .ivu-card-head{
    padding: 0;
  }

</style>
