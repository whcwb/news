<template>
  <div>
    <Modal
      v-model="showModal"
      height="600"
      width="800"
      :closable='false'
      :mask-closable="false"
      :title="operate+'视频'"
      @on-ok="handleSubmit('formValidate')"
      @on-cancel="handleReset('formValidate')"
    >
      <div class="clearfix contentcss sales-statis">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <FormItem label="类别:" prop="templatetype">
            <Select v-model="formValidate.templatetype" placeholder="请选择类别" style='width:240px;'>
              <Option v-for="item in templateList" :value="item.templateCode" :key="item.templateCode">{{ item.templateName }}</Option>
            </Select>
          </FormItem>

          <FormItem label="语言:" prop="templateLangType">
            <Select v-model="formValidate.templateLangType" placeholder="请选择类别" style='width:240px;'>
              <Option v-for="item in templateList1" :value="item.templateCode" :key="item.templateCode">{{ item.templateName }}</Option>
            </Select>
          </FormItem>

          <FormItem label="上传封面:" prop="productlogo">
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

          <FormItem label="上传方式:" prop="templatetype">
            <Select v-model="uploadTypeValue" placeholder="请选择上传方式" style='width:240px;'>
              <Option v-for="item in uploadType" :value="item.templateCode" :key="item.templateCode">{{ item.templateName }}</Option>
            </Select>
          </FormItem>

          <FormItem label="视频地址" prop="title" v-if="uploadTypeValue=='0'">
            <Input v-model="params.viPath" placeholder="请输入网络视频地址"></Input>
          </FormItem>

          <FormItem label="上传视频:" v-else>
            <Upload
              ref="upload"
              :show-upload-list="false"
              :format="['mp4']"
              :max-size="512000"
              :on-format-error="handleFormatError"
              :on-exceeded-size="handleMaxSize"
              :before-upload="handleBeforeUpload"
              action=""
              style="display: inline-block;width:195px;float:left;">
              <img class="iconlabelUrl" :src="formValidate.videoUrl" alt="">
              </Upload>
          </FormItem>
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
          {templateCode:'1',templateName:'宣传视频'},
          {templateCode:'2',templateName:'景区视频'}
        ],
        templateList1:[
          {templateCode:'0',templateName:'中文'},
          {templateCode:'1',templateName:'英文'}
        ],
        uploadType:[
          {templateCode:'0',templateName:'网络'},
          {templateCode:'1',templateName:'本地'}
        ],
        uploadTypeValue:'0',
        formValidate: {
          productlogo:'',
          videoUrl:require("../../../../../static/img/timgw.jpg"),
          templatetype:'1',
          templateLangType:'1',
          openrange:'1',
          labelUrl: require("../../../../../static/img/timgw.jpg"),
          fileSize:0
        },
        params:{
          viLang:'',
          viType:'',
          viPath:'',
          viImg:''
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
        this.formValidate.videoUrl=require('../../../../assets/images/ok.jpg')
        this.formValidate.labelUrl=this.formValidate.productlogo=this.dataItem.viImg
        this.formValidate.templatetype=this.dataItem.viType
        this.formValidate.templateLangType=this.dataItem.viLang==='CN'?'0':'1'
        this.params.viPath=this.dataItem.viPath
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
          formData.append('targetPath','video');
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
        let LangType=this.formValidate.templateLangType==='0'?'CN':'EN'

        this.$refs[name].validate((valid) => {
          if (valid) {
            if (this.operate === '新增') {
              this.$Modal.confirm({
                title: "温馨提示",
                content: "<p>确认添加该视频？</p>",
                onOk: () => {
                  let data = {
                      viLang:LangType,
                      viType:this.formValidate.templatetype,
                      viPath:this.params.viPath,
                      viImg:this.formValidate.labelUrl
                  }
                  this.$http.post(this.apis.Video.SAVE, data)
                    .then(data => {
                      if (data.code == '200') {
                        this.$Message.success('添加成功');
                        this.$emit('changeCompName')
                        this.$emit('getData')
                        // this.$router.push('/exhibition')
                      } else {
                        this.$Message.error('添加失败')
                        this.$emit('changeCompName')
                      }
                    }).catch(err => {
                    this.$emit('changeCompName')
                    this.$emit('getData')
                    console.log(err)
                  })
                },
                onCancel: () => {
                }
              });
            } else {
              this.$Modal.confirm({
                title: "温馨提示",
                content: "<p>确认修改该视频？</p>",
                onOk: () => {
                  let data = {
                    viLang:LangType,
                    viType:this.formValidate.templatetype,
                    viPath:this.params.viPath,
                    viImg:this.formValidate.labelUrl,
                    id:this.formValidate.id
                  }
                  this.$http.post(this.apis.Video.UPDATE, data)
                    .then(data => {
                      if (data.code == '200') {
                        this.$Message.success('修改成功');
                        this.$emit('changeCompName')
                        // this.$router.push('/exhibition')
                      } else {
                        this.$Message.error('修改失败')
                        this.$emit('changeCompName')
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
      },


      handleFormatError (file) {
        this.$Notice.warning({
          title: '文件格式不正确',
          desc: '文件' + file.name + '格式不正确，请上传mp4格式'
        });
      },
      handleMaxSize (file) {
        this.$Notice.warning({
          title: '超出文件大小范围',
          desc: '文件' + file.name + ' 太大了, 不允许超过 500M.'
        });
      },
      handleBeforeUpload (file) {
        let formData = new FormData();
        formData.append("file", file);
        let fileSize=(file.size/1024).toFixed(2)
        formData.append('targetPath','video');
        let config = {
          headers: {
            "Content-Type": "multipart/form-data"
          }
        };
        this.$Spin.show({
          render: (h) => {
            return h('div', [
              h('Icon', {
                'class': 'demo-spin-icon-load',
                props: {
                  type: 'ios-loading',
                  size: 18
                }
              }),
              h('div', 'Loading')
            ])
          }
        });

        this.$http.post(this.apis.upFile, formData, config)
          .then(resp => {
            if (resp.code == '200') {
              this.$Spin.hide();
                this.formValidate.videoUrl=require('../../../../assets/images/ok.jpg')
                this.params.viPath=this.apis.Banner.baseURl+'/'+resp.message;
            } else {
            }
          })
          .catch(() => {
          });
        return false;
      },
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
