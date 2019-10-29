<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="d-none d-sm-block">
      <div class="row" style="margin: 0 0 52px 0">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="row"
               style="margin: 80px 0 90px 0;display: flex;justify-content: center;font-size:40px;color:rgba(51,51,51,1);">
            {{$t('m.DLT')}}
          </div>
          <img src="../assets/img/yzymg11.png" style="width: 100%">
        </div>
        <div class="col-md-1"></div>
      </div>

      <div class="row" style="margin: 0 0 52px 0">
        <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
          <img src="../assets/img/leftBtn.png" @click="moveImg('prev')"
               style="width: 50px;height: 50px;cursor: pointer;">
        </div>
        <div class="col-md-10" style="overflow: hidden">
          <div class="row" id="imgMove" style="margin: 0;transition: all 0.3s;width: 100%;flex-wrap: nowrap;">
            <div class="col-md-4 imgAll" style="max-width: 29%;flex: 0 0 29%;margin-right:70px;padding: 0;height: 100%;position: relative"
                 v-for="(item,index) in jdList">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 300px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.text}}
                  </div>
                  <div class="btn" @click="toPage('Detail',item)"
                       style="cursor: pointer;width:100px;height:40px;border-radius:0;background-color: #644A23;margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);">
                    {{$t('m.LJQW')}}
                  </div>
                </div>
              </Card>
            </div>
          </div>
        </div>
        <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
          <img src="../assets/img/rightBtn.png" @click="moveImg('next')"
               style="width: 50px;height: 50px;cursor: pointer">
        </div>
      </div>
    </div>

    <div class="container-fluid d-sm-none" style="padding: 0">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;height: 3rem;background:rgba(19,218,167,1);">
          <div class="row" style="margin: 0;height: 100%;">
            <div class="col-3" style="padding: 0;height: 100%;display: flex;align-items: center">
              <!--<img src="../assets/img/index/left.png" style="margin-left: 22px;width: 1rem;height: 80%" @click="toPage('index')">-->
            </div>
            <div class="col-6"
                 style="display: flex;align-items: center;justify-content: center;padding: 0;height: 100%;font-size:1rem;font-weight:400;color:rgba(255,255,255,1);">
              游在亚木沟
            </div>
            <div class="col-3" style="padding: 0;height: 100%"></div>
          </div>
        </div>
      </div>

      <img src="../assets/img/yzymg11.png" style="width: 100%;">

      <div class="row" style="margin: 20px 0 4rem 0">
        <div class="col-md-1" style="display: flex;justify-content: center;align-items: center">
        </div>
        <div class="col-md-10" style="overflow: hidden">
          <div class="row" style="margin: 0;transition: all 0.3s;width: 100%;flex-wrap: nowrap;overflow-x: scroll">
            <div class="col-md-12 imgAll" style="margin-right: 20px;max-width: 100%;flex: 0 0 100%;padding: 0;height: 100%;position: relative"
                 v-for="(item,index) in jdList">
              <Card>
                <div slot="title">
                  <img :src="item.img" style="width: 100%;height: 230px">
                </div>
                <div style="width: 100%;height: 250px;">
                  <div
                    style="text-align: center;font-size:22px;color:rgba(51,51,51,1);">
                    {{item.title}}
                  </div>
                  <div
                    style="text-indent: 38px;font-size:17px;margin-top: 10px;height: 70%;overflow-y: hidden">
                    {{item.text}}
                  </div>
                  <!--<div class="btn" @click="toPage('phoneJDDetail',item)"-->
                       <!--style="cursor: pointer;width:100px;height:40px;background-color: rgba(19,218,167,1);margin: 10px 0 0 0;font-size:15px;color:rgba(255,255,255,1);border-radius: 10px">-->
                    <!--{{$t('m.LJQW')}}-->
                  <!--</div>-->
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
    name: "yzymg",
    data() {
      return {
        jdList: [],
        num:0
      }
    },
    mounted() {
      $('.img-fluid').css('display', 'none')
    },
    methods: {
      getJD() {
        this.$http.post(this.apis.JD.GETJD, {type: 1}).then(res => {
          if (res.code === 200) {
            this.jdList = res.page.list
          } else {

          }
        })
      },
      toPage(pathName, item) {
        this.$router.push({
          name: pathName,
          params: {
            item: item,
            listName:'m.PlayInYMG'
          }
        })
      },
      moveImg(dir) {
        if(this.num==this.jdList.length-3&&dir == 'next'){
          return
        }

        if(this.num==0&&dir !== 'next'){
          return
        }

        let imgWidth = $('.imgAll').width() + 70         //这个是图片宽度+padding值=移动值
        let marginLeft = 0
        if (dir == 'next') {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) - imgWidth
        } else {
          marginLeft = parseInt($('#imgMove').css('marginLeft')) + imgWidth
        }
        $('#imgMove').css('marginLeft', marginLeft + 'px')

        if (dir == 'next')
          this.num += 1
        else this.num -= 1

        console.log(this.num)


        // if (this.num > this.imgList.length + (this.imgList.length - 3) && dir == 'next') {
        //   let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 12)
        //   $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
        //   this.num = 0
        // }
        // if (this.num < -this.imgList.length && dir != 'next') {
        //   let imgWidthAll = this.imgList.length * ($('.imgAll').width() + 12)
        //   $('#imgMove').css('marginLeft', '-' + imgWidthAll + 'px')
        //   this.num = 0
        // }

      },
    },
    created() {
      this.getJD()
    }
  }
</script>

<style scoped>
  .jd {
    display: flex;
    justify-content: space-between;
    flex-wrap: nowrap;
    overflow-x: hidden;
    margin: 20px 0 0 0;
  }

  /deep/ .ivu-card-head {
    padding: 0;
  }
</style>
