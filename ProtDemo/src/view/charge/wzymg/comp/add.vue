<template>
  <div>
    <Modal
      v-model="showModal"
      height="600"
      width="800"
      :closable='false'
      :mask-closable="false"
      :title="operate+'内容'"
      @on-ok="handleSubmit('formValidate')"
      @on-cancel="handleReset('formValidate')"
    >
      <div class="clearfix contentcss sales-statis">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <FormItem label="上传图片:" prop="productlogo">
            <Upload
              action=""
              :size="ll"
              :before-upload="handleUploadicon"
              :show-upload-list="false"
              :format="['jpg','jpeg','png', 'gif']"
              :on-format-error="handleFormatError1">
              <img class="iconlabelUrl" :src="formValidate.labelUrl" alt="">
              <Input v-model="formValidate.productlogo" disabled style="width: 120px;margin-top:24px" class="left ml5 hidden"></Input>
              <!-- <Button type="ghost" icon="ios-cloud-upload-outline">上传文件</Button> -->
            </Upload>
          </FormItem>
          <FormItem label="标题:" prop="templatename">
            <Input v-model="formValidate.templatename" placeholder="请输入名称" style="width:240px"></Input>
          </FormItem>
          <FormItem label="类别:" prop="templatetype">
            <Select v-model="formValidate.templatetype" placeholder="请选择类别" style='width:240px;'>
              <Option v-for="item in templateList" :value="item.templateCode" :key="item.templateCode">{{ item.templateName }}</Option>
            </Select>
          </FormItem>
          <FormItem v-if="formValidate.templatetype==2" label="预定链接:">
            <Input v-model="formValidate.booking" placeholder="请输入该酒店预定链接" style="width:240px"></Input>
          </FormItem>
          <FormItem label="电话:" prop="templatephone">
            <Input v-model="formValidate.templatephone" placeholder="请输入电话" style="width:240px"></Input>
          </FormItem>
          <FormItem label="地址:" prop="templateaddress">
            <Input v-model="formValidate.templateaddress" placeholder="请输入地址" style="width:240px"></Input>
          </FormItem>
          <FormItem label="描述:" prop="templatecontent">
            <Input v-model="formValidate.content" type="textarea" :autosize="{minRows: 4, maxRows: 4 }" placeholder="请输入描述" />
          </FormItem>
          <!--<FormItem label="排序:" prop="openrange">-->
            <!--<Select v-model="formValidate.openrange" placeholder="请选择排序" style='width:240px;'>-->
              <!--<Option v-for="item in openrangeList" :value="item.openrangeCode" :key="item.openrangeCode">{{ item.openrangeName }}</Option>-->
            <!--</Select>-->
          <!--</FormItem>-->
          <!--<FormItem>-->
            <!--<Button type="primary" @click="handleSubmit('formValidate')" style='width:100px'>保存</Button>-->
            <!--<Button @click="handleReset('formValidate')" style="margin-left: 8px;width:100px">返回</Button>-->
          <!--</FormItem>-->
        </Form>
      </div>
    </Modal>
  </div>
</template>

<script>

  export default {
    name: 'add',
    watch:{

    },
    data() {
      return {
        showModal: true,
        showRoleTable: false,
        showTree: false,
        ll:0,
        //新增数据
        title:'',
        openrangeList:[
          {openrangeCode:'1',openrangeName:'1'},
          {openrangeCode:'2',openrangeName:'2'},
        ],
        templateList:[
          {templateCode:'1',templateName:'美食'},
          {templateCode:'2',templateName:'住宿'},
          {templateCode:'3',templateName:'休闲娱乐'},
          {templateCode:'4',templateName:'特色商品'}
        ],
        formValidate: {
          productlogo:'',
          templatename:'',
          templatetype:'1',
          templatephone:'',
          templateaddress:'',
          booking:'',
          openrange:'1',
          labelUrl: require("../../../../../static/img/timgw.jpg"),
          fileSize:0,
          content:''
        },
        ruleValidate:{
          templatename:[
            {required: true, message: '请输入模板名称', trigger: 'change'},
          ],
          productlogo:[
            { required: true, message: "请上传图片", trigger: "blur" }
          ]
        }

      }
    },
    props: {
      dataItem: {
        type: Object,
        default: {}
      },
      operate: {
        type: String,
        default: "新增"
      },
    },
    created() {
      if(Object.keys(this.dataItem).length!=0){
        this.formValidate.labelUrl=this.formValidate.productlogo=this.dataItem.img
        this.formValidate.templatename=this.dataItem.title
        this.formValidate.templatetype=(Number(this.dataItem.type)-1).toString()
        this.formValidate.templatephone=this.dataItem.phone
        this.formValidate.templateaddress=this.dataItem.address
        this.formValidate.booking=this.dataItem.booking
        this.formValidate.content=this.dataItem.content
        this.formValidate.id=this.dataItem.id
      }
    },
    methods: {
      handleUploadicon(file) {
        let splic = file.name.split(".");
        if (
          splic[splic.length - 1] == "png" ||
          splic[splic.length - 1] == "jpg" ||
          splic[splic.length - 1] == "gif" ||
          splic[splic.length - 1] == "jpeg"
        ) {
          let formData = new FormData();
          formData.append("file", file);
          let fileSize=(file.size/1024).toFixed(2)
          formData.append('targetPath','banner');
          let config = {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          };
          this.$http.post(this.apis.upFile, formData, config)
            .then(resp => {
              if (resp.code == '200') {
                this.formValidate.labelUrl = this.apis.Banner.baseURl+'/'+resp.message;
                this.formValidate.productlogo = this.apis.Banner.baseURl+'/'+resp.message;
                this.formValidate.fileSize=fileSize
              } else {
              }
            })
            .catch(() => {
            });
          return false;
        }
      },
      handleFormatError1(file) {
        this.$Message.info("图片格式不正确,请上传正确的图片格式");
      },
      handleSubmit(name) {
        var v=this
        let type= 1+Number(this.formValidate.templatetype)

        this.$refs[name].validate((valid) => {
          if (valid) {
            if (this.operate === '新增') {
              this.$Modal.confirm({
                title: "温馨提示",
                content: "<p>确认添加该信息？</p>",
                onOk: () => {
                  let data = {
                    title:this.formValidate.templatename,
                    type:type,
                    booking:this.formValidate.booking,
                    phone:this.formValidate.templatephone,
                    address:this.formValidate.templateaddress,
                    img:this.formValidate.productlogo,
                    content:this.formValidate.content,
                  }
                  this.$http.post(this.apis.JD.SAVE, data)
                    .then(data => {
                      if (data.code == '200') {
                        this.$Message.success('添加成功');
                        this.$emit('changeCompName')
                        this.$emit('getData')
                        // this.$router.push('/exhibition')
                      } else {
                        this.$Message.error('添加失败')
                      }
                    }).catch(err => {
                    console.log(err)
                  })
                },
                onCancel: () => {
                }
              });
            } else {
              this.$Modal.confirm({
                title: "温馨提示",
                content: "<p>确认修改该信息？</p>",
                onOk: () => {
                  let data = {
                    title:this.formValidate.templatename,
                    type:type,
                    booking:this.formValidate.booking,
                    phone:this.formValidate.templatephone,
                    address:this.formValidate.templateaddress,
                    img:this.formValidate.productlogo,
                    content:this.formValidate.content,
                    id:this.formValidate.id
                  }
                  this.$http.post(this.apis.JD.UPDATE, data)
                    .then(data => {
                      if (data.code == '200') {
                        this.$Message.success('修改成功');
                        this.$emit('changeCompName')
                        this.$emit('getData')
                        // this.$router.push('/exhibition')
                      } else {
                        this.$Message.error('修改失败')
                      }
                    }).catch(err => {
                    console.log(err)
                  })
                },
                onCancel: () => {
                }
              });
            }
          }
        })
      },
      handleReset(name) {
        this.$emit('changeCompName')
        this.$refs[name].resetFields()
        // this.$router.push('/exhibition')
      }
    },

  }
</script>

<style lang="less" scoped>
  .title{
    height:60px;line-height:60px;background:#fff;
    font-size: 20px;text-indent: 20px;
  }
  .ivu-form .ivu-form-item-label{
    text-align: justify !important
  }
  .iconlabelUrl {
    width: 240px;
    height: 120px;
  }
</style>
