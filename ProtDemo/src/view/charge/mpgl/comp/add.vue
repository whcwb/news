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
        <Form ref="formValidate" :model="formValidate" :label-width="80">
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
          <FormItem label="标题:" >
            <Input v-model="formValidate.title" placeholder="请输入标题" style="width:240px"></Input>
          </FormItem>
          <FormItem label="副标题:" >
            <Input v-model="formValidate.subTitle" placeholder="请输入副标题" style="width:240px"></Input>
          </FormItem>
          <FormItem label="预定链接:">
            <Input v-model="formValidate.booking" placeholder="请输入预定链接" style="width:240px"></Input>
          </FormItem>
          <FormItem label="价格:">
            <Input v-model="formValidate.price" placeholder="请输入价格" style="width:240px"></Input>
          </FormItem>
          <!--<FormItem label="描述:">-->
            <!--<Input v-model="formValidate.content" type="textarea" :autosize="{minRows: 4, maxRows: 4 }" placeholder="请输入描述" />-->
          <!--</FormItem>-->
          <FormItem label="Text">
            <div id="wangeditor">
              <div ref="editorElem" style="text-align:left;"></div>
            </div>
          </FormItem>
        </Form>
      </div>
    </Modal>
  </div>
</template>

<script>
  import E from "wangeditor";

  export default {
    name: 'add',
    props: ['catchData'],
    data() {
      return {
        showModal: true,
        showRoleTable: false,
        showTree: false,
        ll:0,
        //新增数据
        title:'',
        formValidate: {
          productlogo:'',
          title:'',
          subTitle:'',
          price:'',
          booking:'',
          labelUrl: require("../../../../../static/img/timgw.jpg"),
          fileSize:0,
          content:''
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
    mounted() {
      this.richText()
      if(Object.keys(this.dataItem).length!=0){
        this.formValidate.labelUrl=this.formValidate.productlogo=this.dataItem.img
        this.formValidate.title=this.dataItem.title
        this.formValidate.subTitle=this.dataItem.subTitle
        this.formValidate.booking=this.dataItem.booking
        this.formValidate.price=this.dataItem.price
        this.editor.txt.html(this.dataItem.content)
        this.formValidate.id=this.dataItem.id
      }
    },
    methods: {
      richText(){
        this.editor = new E(this.$refs.editorElem);
        // 编辑器的事件，每次改变会获取其html内容
        this.editor.customConfig.onchange = html => {
          this.formValidate.content=this.editorContent = html;
          // console.log(this.text)
          // this.catchData(this.editorContent); // 把这个html通过catchData的方法传入父组件
        };
        this.editor.customConfig.menus = [
          // 菜单配置
          'head', // 标题
          'bold', // 粗体
          'fontSize', // 字号
          'fontName', // 字体
          'italic', // 斜体
          'underline', // 下划线
          'strikeThrough', // 删除线
          'foreColor', // 文字颜色
          'backColor', // 背景颜色
          'link', // 插入链接
          'list', // 列表
          'justify', // 对齐方式
          'quote', // 引用
          'emoticon', // 表情
          'image', // 插入图片
          'table', // 表格
          'undo', // 撤销
          'redo' // 重复
        ];
        var v=this
        this.editor.customConfig.showLinkImg = false
        // 这是自定义上传图片
        this.editor.customConfig.customUploadImg = function (files, insert) {
          files=files[0]
          let formData = new FormData();
          formData.append("file", files);
          let fileSize=(files.size/1024).toFixed(2)
          formData.append('targetPath','mp');
          let config = {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          };
          v.$http.post(v.apis.upFile, formData, config)
            .then(resp => {
              if (resp.code == '200') {
                insert(v.apis.Banner.baseURl+'/'+resp.message)
              } else {
              }
            })
            .catch(() => {
            });
          return false;
        }
        this.editor.create(); // 创建富文本实例
      },
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
          formData.append('targetPath','ticket');
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

        this.$refs[name].validate((valid) => {
          if (valid) {
            if (this.operate === '新增') {
              this.$Modal.confirm({
                title: "温馨提示",
                content: "<p>确认添加该信息？</p>",
                onOk: () => {
                  let data = {
                    title:this.formValidate.title,
                    subTitle:this.formValidate.subTitle,
                    price:this.formValidate.price,
                    booking:this.formValidate.booking,
                    img:this.formValidate.productlogo,
                    content:this.formValidate.content,
                  }
                  this.$http.post(this.apis.MP.SAVE, data)
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
                    title:this.formValidate.title,
                    subTitle:this.formValidate.subTitle,
                    price:this.formValidate.price,
                    booking:this.formValidate.booking,
                    img:this.formValidate.productlogo,
                    content:this.formValidate.content,
                    id:this.formValidate.id
                  }
                  this.$http.post(this.apis.MP.UPDATE, data)
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
