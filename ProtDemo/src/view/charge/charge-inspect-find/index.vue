<template>
  <div class="box_col">
    <pager-tit title="视频中心"></pager-tit>
    <div class="box_row colCenter rowRight pageFindSty" style="border: none">
      <div>
        <Input v-model="param.gnmcLike"
               placeholder="请输入名称" style="width: 200px"
               @on-keyup.enter="v.util.getPageData(v)"></Input>
      </div>
      <Button type="primary" @click="v.util.getPageData(v)">
        <Icon type="md-search"></Icon>
        <!--查询-->
      </Button>
      <Button type="primary" @click="addvideo">
        <Icon type="md-add"></Icon>
      </Button>
    </div>
    <div style="display:flex;">
      <Row>
        <Col span="6" v-for="item in 8">
          <Card style="width:400px ;height: 300px;padding: 5px" >
            <p slot="title">
              <Icon type="ios-film-outline"></Icon>
              视屏名称
            </p>
            <a href="#" slot="extra" @click.prevent="">
              <Icon type="ios-loop-strong"></Icon>
              删除
            </a>
            <div style="text-align:center">
              <img src="">
              <video style="width: 350px;height: 200px" src="https://www.w3school.com.cn/example/html5/mov_bbb.mp4" controls="controls"></video>

            </div>
          </Card>
        </Col>
      </Row>
    </div>
    <div style="text-align: right;padding: 6px 0">
      <Page :total=total
            :current=param.pageNum
            :page-size=param.pageSize
            :page-size-opts=[8,10,20,30,40,50]
            show-total
            show-elevator
            show-sizer
            placement='top'
            @on-page-size-change='(n)=>{pageSizeChange(n)}'
            @on-change='(n)=>{pageChange(n)}'>
      </Page>
    </div>
    <component
      :is="compName"
    ></component>
  </div>
</template>

<script>
  import add from "./comp/add"
  export default {
    name: "index",
    components:{
      add
    },
    data() {
      return {
        compName:'',
        total:0,
        modal10:false,
        reason:'',
        show: '',
        headImg: null,
        userMsg: '',
        orgTree: [],//机构
        CascaderData: [],
        iconName: 'ios-search',
        iconColor: '#b3b3b3',
        message: '',
        stuMes: {
          managements: [{id: ''}]
        },
        param: {
          nameLike: '',
          idCardNo: '',
          orgPath: '',
          pageSize:8,
          pageNum:1
        },
        videoList:[]
      }
    },
    filters: {

    },
    watch: {

    },
    created() {
      this.getVideo()
    },
    computed: {

    },
    methods: {
      addvideo(){
        this.compName = 'add'
      },

      getVideo() {
        // viType: 1 是宣传片 2 是景区视频
        this.$http.post(this.apis.Video.GETVIDEO).then(res => {
          if (res.code === 200) {
            this.videoList = res.page.list
          } else {

          }
        })
      },

      change(vaule, key) {
        // console.log('//////', vaule);
        // console.log(key);
        this.param.orgPath = key[key.length - 1].value
      },
    }
  }
</script>

<style lang="less">
  .iconSty {
    cursor: pointer;
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
</style>
