<<template>
  <div style="font-family:MicrosoftYaHei;">
    <div class="container-fluid d-sm-none de" style="padding: 0;">
      <div class="row" style="margin: 0">
        <div class="col-12" style="padding: 0;position: relative">
          <img src="../assets/img/index/banner.png" style="width: 100%">
          <img src="../assets/img/back.png" @click="toPage('localNews',false)"
               style="top: 20%;left: 5px;position: absolute;width: 30px;height: 30px;border-radius: 50%">
        </div>
      </div>

      <div class="col-12" style="margin-top: 1rem;font-size: 1.3rem;font-weight: 500">
        {{item.title}}
      </div>

      <div class="col-12" style="margin: 1rem 0 10px 0;font-size:0.8rem;font-weight: 500;text-align: right;padding-right: 22px">
        {{item.cjsj|time}}
      </div>

      <div class="col-12" v-html="item.content" style="margin-bottom: 4rem">
        {{item.content}}
      </div>
    </div>

  </div>
</template>

<script>
  import {mixins} from "../common/util/mixins";

  export default {
    name: "LYGL_Sec",
    mixins: [mixins],
    data() {
      return {
        time: '',
        item: {}
      }
    },
    mounted() {
      $('.img-fluid').css('height', '200px')
      this.item = this.$route.params.item
    },
    methods: {
      toPage(pathName) {
        $('body,html').animate({scrollTop: 0}, 500);


        if (pathName == 'index') {
          $('.img-fluid').css('height', 'auto')
        }

        this.$router.push({
          name: pathName
        })
      }
    }
  }
</script>

<style scoped>
  .row {
    margin-left: 0;
    margin-right: 0;
  }

  .de>>>p{
    width: 100%;
  }

  .de>>>p>img{
    display: block;
    margin: 0 auto;
    width: 100%;
  }

</style>
