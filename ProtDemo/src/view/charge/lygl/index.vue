<template>
  <div class="box_col">
    <pager-tit title="新闻资讯"></pager-tit>
    <div class="box_row colCenter rowRight pageFindSty" style="border: none">
      <div>
        <Input v-model="param.title"
               placeholder="请输入标题" style="width: 200px"
               @on-keyup.enter="getGL"></Input>
      </div>
      <Button type="primary" @click="getGL">
        <Icon type="md-search"></Icon>
        <!--查询-->
      </Button>
      <Button type="primary" @click="addnews">
        <Icon type="md-add"></Icon>
      </Button>
    </div>
    <div>
      <Table :height="AF.getPageHeight()-320" stripe
             size="small"
             :columns="tabTit" :data="tableData"></Table>
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
      :operate="operate"
      :dataItem="dataItem"
      @changeCompName="changeCompName"
    ></component>
    <Modal title="查看大图" v-model="visible" class-name="fl-image-modal">
      <img :src="imgUrl" v-if="visible" style="width: 100%">
    </Modal>
  </div>
</template>

<script>
  import addnew from './comp/addnew'

  export default {
    name: "index",
    components: {
      addnew
    },
    data() {
      return {
        dataItem: {},
        visible: false,
        tabTit: [
          {
            type: 'index', align: 'center', minWidth: 80, fixed: 'left',
            // render: (h, p) => {
            //   return h('span', p.index + (this.param.pageNum - 1) * this.param.pageSize + 1);
            // }
          },
          {
            title: '标题',
            key: 'title',
            align: 'center',
            minWidth: 80
          },
          {
            title: '副标题',
            key: 'subTitle',
            align: 'center',
            minWidth: 80
          },
          {
            title: '封面',
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
            title: '创建时间',
            key: 'cjsj',
            align: 'center',
            minWidth: 160
          },
          {
            title: '类型',
            align: 'center',
            key: 'type',
            minWidth: 80,
            render: (h, p) => {
              let type = p.row.type === '1' ? '官方攻略' : p.row.type === '2' ?'达人攻略':'自驾游攻略'
              return h('div', type)
            },
            filters: [
              {
                label: '官方攻略',
                value: 1
              },
              {
                label: '达人攻略',
                value: 2
              },
              {
                label: '自驾游攻略',
                value: 3
              }
            ],
            filterMultiple: false,
            filterMethod(value, row) {
              return row.type == value.toString()
            }
          },
          {
            title: '阅读数',
            key: 'read',
            align: 'center',
            minWidth: 160
          },
          {
            title: '操作',
            width: 120,
            fixed: 'right',
            align: 'center',
            render: (h, p) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'warning',
                    size: 'small',
                    icon: 'md-create'
                  },
                  style: {
                    marginRight: '10px'
                  },
                  on: {
                    click: () => {
                      this.operate = '修改'
                      this.dataItem = p.row
                      this.compName = 'addnew'
                    }
                  }
                }),
                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small',
                    icon: 'md-close'
                  },
                  on: {
                    click: () => {
                      this.$Modal.confirm({
                        title: "温馨提示",
                        content: "<p>确认删除该攻略？</p>",
                        onOk: () => {
                          this.$http.post(this.apis.LYGL.DEL+p.row.id)
                            .then(data => {
                              if (data.code == '200') {
                                this.$Message.success('删除成功');
                                this.getGL()
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
        operate: '',
        tableData: [
          {}
        ],
        total: 0,
        param: {
          pageNum: 1,
          pageSize: 8,
        },
        compName: ''
      }
    },
    created() {
      this.getGL()
    },
    computed: {},
    methods: {
      handleView(url) {  //查看大图
        this.imgUrl = url;
        this.visible = true;
      },
      changeCompName() {
        this.compName = ''
        this.getGL()
        this.dataItem = {}
      },
      addnews() {
        this.operate = '新增'
        this.compName = 'addnew'
      },
      //分页点击事件按
      pageChange(n) {
        this.param.pageNum = n
        this.getGL()
      },
      pageSizeChange(n) {
        this.param.pageSize = n
        this.getGL()
      },
      getGL() {
        this.$http.post(this.apis.LYGL.GETGL, this.param)
          .then(res => {
            if (res.code == '200') {
              this.tableData = res.page.list
              this.total=res.page.total
            } else {
            }
          })
          .catch(() => {
          });
      }
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
