<template>
  <div class="box_col">
    <pager-tit title="相册管理"></pager-tit>
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
      <Button type="primary" @click="addAlbum">
        <Icon type="md-add"></Icon>
      </Button>
    </div>
    <Row type="flex" align="bottom" style="padding:20px 0 10px 0;">
      <!-- <Col span="4">
         <Input type="text" placeholder="流水号" size="large" v-model="param.serialNum" @on-enter="getUserInfo"/>
       </Col>-->
      <!--      <Col span="4" style="padding-left: 10px">-->
      <!--        <Input type="text" placeholder="证件号码" @on-change="find" clearable size="large" v-model="param.idCardNo"/>-->
      <!--      </Col>-->
      <!--      <Col span="2" style="padding-left: 10px">-->
      <!--        <Button type="primary" @click="find" size="large">-->
      <!--          <Icon type="md-search" style="font-size: 24px"></Icon>-->
      <!--        </Button>-->
      <!--      </Col>-->
    </Row>
    <div style="display:flex;">
      <Row>
        <Col span="6" v-for="item in 8">
          <Card style="width:400px ;height: 320px;padding: 5px" >
            <p slot="title">
              <Icon type="ios-film-outline"></Icon>
              相册名称
            </p>
            <a href="#" slot="extra" @click.prevent="">
              <Icon size="22" color="green" type="md-eye" />
              <Icon size="22" type="ios-add-circle" />
              <Icon size="22" color="red" type="ios-close-circle-outline" />
            </a>
            <div style="text-align:center">
              <img @click="value1 = true" style="width: 350px;height: 210px" src="http://img5.imgtn.bdimg.com/it/u=3434485511,2562179014&fm=26&gp=0.jpg">
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

    <Drawer
      v-for="item in pageData"
      :title="item.abName"
      width="600px"
      :closable="false"
      v-model="value1">
      <div>
        <viewer :images="tupians">
          <Row style="height: 210px">
            <Col span="20">
              <img @click="value1 = true" style="width: 100%;height: 210px" src="http://img5.imgtn.bdimg.com/it/u=3434485511,2562179014&fm=26&gp=0.jpg">

            </Col>
            <Col span="4" align="center" vertical-align="middle" >
              <Icon size="22" color="red" type="ios-close-circle-outline" />
            </Col>
          </Row>
        </viewer>
      </div>
    </Drawer>

    <Modal
      v-model="modal"
      title="新增相册"
      @on-ok="saveAlbum"
      >
      <div>
        请输入相册名称：
        <Input style="width: auto" v-model="albumName" />
      </div>
    </Modal>

  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      return {
        tupians:[
          {
            img:'http://img5.imgtn.bdimg.com/it/u=3434485511,2562179014&fm=26&gp=0.jpg'
          },
          {
            img:'http://img5.imgtn.bdimg.com/it/u=3434485511,2562179014&fm=26&gp=0.jpg'
          },
          {
            img:'http://img5.imgtn.bdimg.com/it/u=3434485511,2562179014&fm=26&gp=0.jpg'
          }
        ],
        value1:false,
        total:0,
        modal:false,
        albumName:'',
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
        pageData:[],
        compName: '',
        dataItem:{},
        operate:'',
        param: {
          // nameLike: '',
          // idCardNo: '',
          // orgPath: '',
          pageSize:8,
          pageNum:1
        }
      }
    },
    filters: {
      inZt: (val) => {
        if (val == '00') {
          return '已缴费'
        } else if (val == '10') {
          return '体检已驳回'
        } else if (val == '20') {
          return '体检退费'
        }
      }
    },
    watch: {
      'param': function (n, o) {
        // console.log('1236', n);
      }
    },
    created() {
      this.getData()
      // this.getOrgTree();
    },
    computed: {
      AutoReadCard() {
        if (window.vueObject.$data.card.CardNo) {
          this.param.idCardNo = window.vueObject.$data.card.CardNo;
          this.find();
        }
        return "";
      }
    },
    methods: {
      getData(){
        this.$http.post(this.apis.Ablum.GETABLUM,this.param).then(res=>{
              if(res.code=='200'){
                this.pageData=res.page.list
              }else {

              }
        })
      },
      addAlbum(){
        this.modal=true
      },
      saveAlbum(){
        this.$http.post(this.apis.Ablum.SAVE,{'abName':this.albumName}).then(res=>{
            if(res.code=='200'){
              this.getData()
            }else {

            }
        })
      },
      yichang(){
        // console.log('yichangchulidiankaosaolaoge');
        this.modal10 = true
      },
      ycok(){
        // console.log(this.reason);
        if(this.reason == ''){
          this.swal({
            title: '请填写异常原因!',
            type: "error"
          })
        }else {
          this.$http.post('/api/chargemanagement/warnInspect',{id:this.stuMes.managements[0].id,reason: this.reason}).then((res)=>{
            if(res.code == 200){
              this.swal({
                title: '异常处理成功!',
                type: "success"
              })
            }else{
              this.swal({
                title: res.message,
                type: "error"
              })
            }
          })
        }
      },
      yccancel(){
        this.modal10 = false
      },
      inOut() {
        if (this.stuMes.managements[0].id == '') {
          this.swal({
            title: '该学员为本校学员！',
            type: "error"
          })
        } else {
          this.$http.post('/api/chargemanagement/rejectInspect', {id: this.stuMes.managements[0].id}).then(res => {
            if (res.code == 200) {
              this.swal({
                title: "体检驳回成功",
                type: "success"
              })
              this.find()
            }else {
              this.swal({
                title: res.message,
                type: "error"
              })
            }
          }).catch(err => {
          })
        }
      },

      find() {
        if (this.param.idCardNo === '') {
          this.show = '1';
          this.message = "请先输入证件号码";
          return;
        }
        this.$http.post('/api/traineeinformation/checkInspect', this.param).then((res) => {
          if (res.code == 200) {
            this.message = '';
            this.iconName = "md-checkmark";
            this.iconColor = "#19be6b";
            if (res.result) {
              this.stuMes = res.result;
              this.show = '2';
              this.message = res.message + "    缴费时间：" + res.result.registrationTime;
            }
            if (res.result.managements[0].zt == '20') {
              this.show = '3';
              this.message = '该学员已退费';
            }
            if (res.result.managements[0].zt == '30') {
              this.show = '4';
              this.message = '该学员异常处理';
            }
            if (this.stuMes.headImg != null && this.stuMes.headImg != '') {
              this.headImg = this.apis.getImgUrl + this.stuMes.headImg;
            }
          } else {
            this.show = '1';
            this.iconName = "md-alert";
            this.iconColor = "#f90";
            this.message = res.message;
            this.headImg = null;
          }
          /* this.$Message.info(res.message)
           console.log(res);*/
        })
      },
      getOrgTree() {
        this.$http.get(this.apis.FRAMEWORK.getCurrentOrgTree, {timers: new Date().getTime()}).then((res) => {
          this.orgTree = res.result
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
