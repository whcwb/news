<template>
  <div class="box_col">
    <pager-tit title="景点管理"></pager-tit>
    <div class="box_row colCenter rowRight pageFindSty" style="border: none">
      <div>
        <Input v-model="param.title"
               placeholder="请输入标题" style="width: 200px"
               @on-keyup.enter="getData"></Input>
      </div>
      <Button type="primary" @click="getData">
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
            key: 'text',
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
                      'src': params.row.photo,
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
            title: '开放时间',
            key: 'kfsj',
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
                        content: "<p>确认删除该景点？</p>",
                        onOk: () => {
                          this.$http.post(this.apis.JD.DEL+p.row.id)
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
        operate: '',
        tableData: [
          {}
        ],
        total: 0,
        param: {
          pageNum: 1,
          pageSize: 8,
          type:'1'
        },
        compName: ''
      }
    },
    created() {
      this.getData()
    },
    computed: {},
    methods: {
      handleView(url) {  //查看大图
        this.imgUrl = url;
        this.visible = true;
      },
      changeCompName() {
        this.compName = ''
        this.getData()
        this.dataItem = {}
      },
      addnews() {
        this.operate = '新增'
        this.compName = 'addnew'
      },
      //分页点击事件按
      pageChange(n) {
        this.param.pageNum = n
        this.getData()
      },
      pageSizeChange(n) {
        this.param.pageSize = n
        this.getData()
      },
      getData() {
        this.$http.post(this.apis.JD.GETJD, this.param)
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
