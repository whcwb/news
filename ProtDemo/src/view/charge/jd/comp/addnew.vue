<template>
  <div>
    <Modal
      v-model="showModal"
      height="600"
      width="800"
      :closable='false'
      :mask-closable="false"
      @on-ok="submit"
      @on-cancel="cancel"
      :title="operate+'景点'">
      <Form :model="formItem" :label-width="80">
        <FormItem label="标题">
          <Input v-model="formItem.title" placeholder="请输入标题"></Input>
        </FormItem>
        <FormItem label="副标题">
          <Input v-model="formItem.text" placeholder="请输入副标题"></Input>
        </FormItem>
        <FormItem label="开放时间段">
          <Input v-model="formItem.kfsj" placeholder="请输入本景点开放时间段"></Input>
        </FormItem>
        <FormItem label="上传封面:" prop="productlogo">
          <Upload
            action=""
            :size="0"
            :before-upload="uploadImg"
            :show-upload-list="false"
            :format="['jpg','jpeg','png', 'gif']"
            :on-format-error="handleFormatError1">
            <img class="iconlabelUrl" :src="formValidate.labelUrl" alt="">
            <Input v-model="formValidate.productlogo" disabled style="width: 120px;margin-top:24px" class="left ml5 hidden"></Input>
            <!-- <Button type="ghost" icon="ios-cloud-upload-outline">上传文件</Button> -->
          </Upload>
        </FormItem>
        <FormItem label="上传图片:">
          <Upload
            action=""
            :size="0"
            :before-upload="uploadPhoto"
            :show-upload-list="false"
            :format="['jpg','jpeg','png', 'gif']"
            :on-format-error="handleFormatError1">
            <img class="iconlabelUrl" :src="formValidate.xx" alt="">
            <Input v-model="formValidate.xx" disabled style="width: 120px;margin-top:24px" class="left ml5 hidden"></Input>
            <!-- <Button type="ghost" icon="ios-cloud-upload-outline">上传文件</Button> -->
          </Upload>
        </FormItem>
        <FormItem label="内容">
          <div id="wangeditor">
            <div ref="editorElem" style="text-align:left;"></div>
          </div>
        </FormItem>
        <!--<FormItem>-->
          <!--<Button type="primary" @click="submit">提交</Button>-->
          <!--<Button style="margin-left: 8px">重置</Button>-->
        <!--</FormItem>-->
      </Form>
    </Modal>
  </div>
</template>

<script>
  import E from "wangeditor";

  export default {
    name: "addnew",
    props: ['catchData'],
    data() {
      return {
        editor: null,
        editorContent: '',
        showModal: true,
        text:'',
        formItem: {
          text:'',      //副标题
          title:'',
          type:1,
          content:'',
          kfsj:'',
          photo:''
        },
        formValidate: {
          productlogo:'',
          templatename:'',
          xx:'',
          templatetype:'1',
          openrange:'1',
          labelUrl: require("../../../../../src/assets/images/timgw.jpg"),
          fileSize:0
        },
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
    methods:{
      richText(){
        this.editor = new E(this.$refs.editorElem);
        // 编辑器的事件，每次改变会获取其html内容
        this.editor.customConfig.onchange = html => {
          this.formItem.content=this.editorContent = html;
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
            formData.append('targetPath','jd');
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
      uploadPhoto(file){
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
          formData.append('targetPath','jd');
          let config = {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          };
          this.$http.post(this.apis.upFile, formData, config)
            .then(resp => {
              if (resp.code == '200') {
                this.formValidate.xx=this.formItem.photo= this.apis.Banner.baseURl+'/'+resp.message;
              } else {
              }
            })
            .catch(() => {
            });
          return false;
        }
      },
      uploadImg(file){
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
          formData.append('targetPath','jd');
          let config = {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          };
          this.$http.post(this.apis.upFile, formData, config)
            .then(resp => {
              if (resp.code == '200') {
                this.formValidate.labelUrl=this.formItem.img= this.apis.Banner.baseURl+'/'+resp.message;
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
      submit(){
        if(this.operate==='新增') {
          this.$http.post(this.apis.JD.SAVE, this.formItem)
            .then(res => {
              if (res.code == '200') {
                this.$Message.success('添加成功');
                this.$emit('changeCompName')
              } else {
                this.$emit('changeCompName')
                this.$Message.error('添加失败')
              }
            })
            .catch(() => {
            });
        }else {
          this.$http.post(this.apis.JD.UPDATE, this.formItem)
            .then(res => {
              if (res.code == '200') {
                this.$Message.success('修改成功');
                this.$emit('changeCompName')
              } else {
                this.$emit('changeCompName')
                this.$Message.error('修改失败')
              }
            })
            .catch(() => {
            });
        }
      },
      cancel(){
        this.$emit('changeCompName')
      }
    },
    mounted() {
      this.richText()
      if(Object.keys(this.dataItem).length!=0){
        this.formItem.title=this.dataItem.title
        this.formItem.content=this.dataItem.content
        this.formItem.kfsj=this.dataItem.kfsj
        this.formItem.text=this.dataItem.text
        this.formItem.id=this.dataItem.id
        this.editor.txt.html( this.formItem.content)
        this.formValidate.labelUrl=this.formValidate.productlogo=this.dataItem.img
        this.formValidate.xx=this.formItem.photo=this.dataItem.photo
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
