<template>
  <div>
    <Modal
      v-model="showModal"
      height="600"
      width="800"
      :closable='false'
      :mask-closable="false"
      :title="operate+'视频'">
      <div class="desc">仅支持MP4格式H264编码的视频，且大小不要超过500M。视频格式转换方法</div>

      <div class="clearfix contentcss sales-statis">
        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <FormItem label="图片名称:" prop="templatename">
            <Input v-model="formValidate.templatename" placeholder="请输入名称" style="width:240px"></Input>
          </FormItem>
          <FormItem label="类别:" prop="templatetype">
            <Select v-model="formValidate.templatetype" placeholder="请选择类别" style='width:240px;'>
              <Option v-for="item in templateList" :value="item.templateCode" :key="item.templateCode">{{ item.templateName }}</Option>
            </Select>
          </FormItem>
          <FormItem label="上传图片:" prop="productlogo">
          </FormItem>
        </Form>
      </div>

      <!--<Row>-->
        <!--<Col :span="12">-->
          <!--<div class="demo-upload-list fl" v-for="(item,index) in uploadList" :key="index">-->
            <!--<template v-if="item.status === 'finished'">-->
              <!--<img :src="item.url"></img>-->
              <!--<div class="demo-upload-list-cover">-->
                <!--<Icon type="close" @click.native="Remove(item, index)" class="del-btn"></Icon>-->
              <!--</div>-->
            <!--</template>-->
            <!--<template v-else>-->
              <!--<i-circle v-if="item.showProgress" :percent="item.percentage" stroke-color="#e63b24" :stroke-width="7">-->
                <!--<span class="demo-Circle-inner" style="font-size:24px">{{ parseInt(item.percentage) }}%</span>-->
              <!--</i-circle>-->
              <!--&lt;!&ndash; <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress> &ndash;&gt;-->
            <!--</template>-->
          <!--</div>-->
          <!--<Upload-->
            <!--ref="upload"-->
            <!--:show-upload-list="false"-->
            <!--:format="['mp4']"-->
            <!--:max-size="512000"-->
            <!--:on-format-error="handleFormatError"-->
            <!--:on-exceeded-size="handleMaxSize"-->
            <!--:before-upload="handleBeforeUpload"-->
            <!--action=""-->
            <!--style="display: inline-block;width:195px;float:left;">-->
            <!--<div style="width: 195px;height:130px;line-height: 130px;text-align:center;border:1px solid #dddee1;cursor:pointer;">-->
              <!--<Icon type="plus" size="40" color="#dddee1"></Icon>-->
            <!--</div>-->
          <!--</Upload>-->
        <!--</Col>-->
      <!--</Row>-->
    </Modal>
  </div>
</template>

<script>

  export default {
    name: 'add',
    watch:{

    },
    props: {
      editVideo: {
        type: Array
      }
    },
    data() {
      return {
        showModal: true,
        showRoleTable: false,
        showTree: false,
        operate: "新增",
        //新增数据
        uploadList: [],
        uptoken: '',
        Upurl: this.$config.upload + 'mptup',
        params:{
          viLang:'',
          viType:'',
          viPath:'',
          viImg:''
        },
        templateList:[
          {templateCode:'1',templateName:'中文'},
          {templateCode:'2',templateName:'英文'}
        ],
        formValidate: {
          productlogo:'',
          templatename:'',
          templatetype:'1',
          openrange:'1',
          labelUrl: require("../../../../../static/img/timgw.jpg"),
          fileSize:0
        },
      }
    },
    props: {

    },
    created() {

    },
    methods: {
      Remove (item, index) {
        const fileList = this.$refs.upload.fileList;
        this.$refs.upload.fileList.splice(fileList.indexOf(item), 1);
        this.$emit('on-del-video', index)
      },
      // handleRemove (file) {
      //     const fileList = this.$refs.upload.fileList;
      //     this.$refs.upload.fileList.splice(fileList.indexOf(file), 1);
      // },
      handleSuccess (res, file) {
        console.log(res)
        console.log(file)
        file.url = res.data.fileurl
        res.data.name = file.name
        res.data.hash = res.data.filehash
        res.data.status = 'finished'
        res.data.width = '195'
        res.data.height = '110'
        this.$emit('on-add-video', res)
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
        this.$http.post(this.apis.upFile, formData, config)
          .then(resp => {
            if (resp.code == '200') {
              // this.formValidate.labelUrl = this.apis.Banner.baseURl+'/'+resp.message;
              // this.formValidate.productlogo = this.apis.Banner.baseURl+'/'+resp.message;
              // this.formValidate.fileSize=fileSize
            } else {
            }
          })
          .catch(() => {
          });
        return false;

        // const check = this.uploadList.length < 3;
        // if (!check) {
        //   this.$Notice.warning({
        //     title: '不能超过3个视频'
        //   });
        //   return false;
        // }
        // return this.getToken()
      },
      // 获取token
      getToken () {
        return new Promise((resolve, reject) => {
          this.axios.get(this.$config.uploadUrl + 'file/uptoken')
            .then(res => {
              let data = res.data;
              if (data.code === 200) {
                this.uptoken = data.data.uptoken;
                resolve()
              }
            })
            .catch(err => {
              reject(err)
            })
        })
      }
    },
    mounted () {
      // this.$refs.upload.fileList = this.$refs.upload.fileList.concat(this.editVideo)
      // this.uploadList = this.$refs.upload.fileList
    }
  }
</script>

<style scoped>
  .demo-upload-list{
    display: inline-block;
    width: 195px;
    height: 130px;
    text-align: center;
    line-height: 130px;
    border: 1px solid transparent;
    border-radius: 4px;
    overflow: hidden;
    background: #fff;
    position: relative;
    box-shadow: 0 1px 1px rgba(0,0,0,.2);
    margin-right: 4px;
  }
  .demo-upload-list img{
    width: 100%;
    height: 100%;
  }
  .demo-upload-list-cover{
    display: none;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0,0,0,.6);
  }
  .demo-upload-list:hover .demo-upload-list-cover{
    display: block;
  }
  .demo-upload-list-cover i{
    color: #fff;
    font-size: 20px;
    cursor: pointer;
    margin: 0 2px;
  }
  .del-btn{
    position: absolute;
    top: 5px;
    right: 10px;
  }
  .desc{
    color: #999
  }
</style>
