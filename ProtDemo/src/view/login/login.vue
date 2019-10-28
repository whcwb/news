<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <img src="./bg.png" style="width: 100%;height: 100%">
    <!--<div class="login-con">-->
      <!--<Card icon="log-in" title="欢迎登录" :bordered="false">-->
        <!--<div class="form-con">-->
          <!--<login-form @on-success-valid="handleSubmit"></login-form>-->
        <!--</div>-->
      <!--</Card>-->
    <div class="login-bg">
      <div style="height: 20%;display: flex;justify-content: center;align-items: center;font-size: 20px;color: #29C3CC">用户登录</div>
      <div class="form-con" style="width: 80%;height: 60%;margin: 0 auto">
        <login-form @on-success-valid="handleSubmit"></login-form>
      </div>
    </div>
    <!--</div>-->
    <div class="copyRight" style="color: #fff;padding-bottom: 80px">
      <div>
        亚木沟官网管理服务平台
        <!--版本号-->
        v1.1.1.1
        <!--2018-1121-->
      </div>
      <div class="messItem" style="font-size: 16px">
        Copyright@2019 武汉创伟博科技有限公司
      </div>
    </div>

  </div>
</template>

<script>
  import LoginForm from '_c/login-form'
  import {mapActions} from 'vuex'

  export default {
    data() {
      return {
        num: 0
      }
    },
    created(){
      this.num = Math.floor(this.AF.getRandom(1)/2)
      this.$store.commit('setTagNavList',[])
    },
    components: {
      LoginForm
    },
    methods: {
      ...mapActions([
        'handleLogin',
        'getUserInfo'
      ]),
      handleSubmit(mess) {
        // console.log('', mess);
      }
    }
  }
</script>

<style>

</style>
