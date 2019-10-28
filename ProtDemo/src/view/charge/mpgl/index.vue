<template>
  <div class="box_col" style="position: relative">
    <pager-tit title="门票管理"></pager-tit>
    <Row>
      <div class="box_row colCenter rowRight pageFindSty" style="border: none">
        <!--<div>-->
          <!--<Input v-model="param.gnmcLike"-->
                 <!--placeholder="请输入名称" style="width: 200px"-->
                 <!--@on-keyup.enter="v.util.getPageData(v)"></Input>-->
        <!--</div>-->
        <!--<Button type="primary" @click="getData">-->
          <!--<Icon type="md-search"></Icon>-->
          <!--&lt;!&ndash;查询&ndash;&gt;-->
        <!--</Button>-->
        <Button type="primary" @click="addbanner">
          <Icon type="md-add"></Icon>
        </Button>
      </div>
    </Row>


    <div class="box_col_100" style="padding-top: 8px">

      <Table size="small" :height="AF.getPageHeight()-320" stripe
             :columns="tabTitS" :data="tableData"></Table>
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
    </div>
    <component
      :is="compName"
      :dataItem="dataItem"
      :operate="operate"
      @getData="getData"
      @changeCompName="changeCompName"
    ></component>
    <Modal title="查看大图" v-model="visible" class-name="fl-image-modal">
      <img :src="imgUrl" v-if="visible" style="width: 100%">
    </Modal>
  </div>
</template>

<script>
  import add from "./comp/add"

  export default {
    name: "index",
    components: {
      add
    },
    data: function () {
      return {
        compName: '',
        dark: "light",
        activeName: '1',
        imgUrl: '',
        visible: false,
        dataItem:{},
        operate:'',
        tabTitS: [
          {
            type: 'index2', align: 'center', width: 80, fixed: 'left',
            render: (h, p) => {
              return h('span', p.index + (this.param.pageNum - 1) * this.param.pageSize + 1);
            }
          },
          {
            title: '标题',
            align: 'center',
            minWidth: 180,
            key: 'title'
          },
          {
            title: '副标题',
            align: 'center',
            minWidth: 180,
            key: 'subTitle'
          },
          {
            title: '价格',
            align: 'center',
            minWidth: 180,
            key: 'price'
          },
          {
            title: '图片',
            minWidth: 120,
            align: "center",
            render: (h, params) => {
              return h('div', [
                  h('img', {
                    style: {
                      'margin-top': '10px',
                      'margin-bottom': '10px',
                      'border-radius': '4px',
                      width: '80px',
                      height: '50px',
                      cursor: 'pointer',
                    },
                    attrs: {
                      'src': params.row.img,
                      onerror: 'this.src="https://goss.veer.com/creative/vcg/veer/800water/veer-133632476.jpg"'
                    },
                    on: {
                      click: (e) => {
                        this.handleView(e.srcElement.currentSrc)
                      }
                    }
                  }),
                ]
              )
            },

          },
          {
            title: '操作',
            align: 'center',
            key: 'cz',
            minWidth: 90,
            fixed: 'right',
            render: (h, p) => {
              return h('div',[
                h('Button',{
                  props: {
                    type: 'warning',
                    size: 'small',
                    icon: 'md-create'
                  },
                  style:{
                    marginRight: '10px'
                  },
                  on: {
                    click: () => {
                      this.dataItem=p.row
                      this.operate='修改'
                      this.compName = 'add'
                    }
                  }
                }),
                h('Button',{
                  props: {
                    type: 'error',
                    size: 'small',
                    icon: 'md-close'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: "温馨提示",
                        content: "<p>确认删除该门票？</p>",
                        onOk: () => {
                          this.$http.post(this.apis.MP.DEL+p.row.id)
                            .then(data => {
                              if (data.code == '200') {
                                this.$Message.success('删除成功');
                                this.getData()
                              } else {
                                this.$Message.error('删除失败')
                              }
                            }).catch(err => {
                          })
                        },
                        onCancel: () => {
                        }
                      });
                    }
                  }
                })
              ])
            }
          }
        ],


        tableData: [
          {},
        ],
        total: 0,//总数量
        param: {
          pageNum: 1,//当前页码
          pageSize: 20,//每页显示数,
        },
        total1: 0,//总数量
        param1Time: '',
        kmMoney: 0,
        chargeCode: '9998',
        CascaderList: [],
        jx: [],
        bmdT: [],
        bmdB: []
      }
    },
    created() {
        this.getData()
    },
    computed: {},
    methods: {
      changeCompName(){
        this.compName=''
        this.dataItem={}
      },
      addbanner() {
        this.operate='新增'
        this.compName = 'add'
      },
      pageSizeChange(n) {
        this.param.pageSize=n
        this.getData()
      },
      pageChange(n){
        this.param.pageNum=n
        this.getData()
      },

      MenuClick(name) {
        this.activeName = name
        if (name == '1') {

        } else if (name == '2') {

        }
      },
      getJTjx() {
        this.jx = this.dictUtil.getByCode(this, 'ZDCLK1019');
      },
      CasChange(val) {
        this.getPagerList()
      },
      handleView(url) {  //查看大图
        this.imgUrl = url;
        this.visible = true;
      },
      getData() {
        this.$http.post(this.apis.MP.GETMP,this.param).then(res=>{
            if(res.code=='200'){
              this.tableData=res.page.list
              this.total=res.page.total
            }else {
              this.$Message.success('数据获取失败');
            }
        })
      }
    }
  }
</script>

<style scoped>

</style>
