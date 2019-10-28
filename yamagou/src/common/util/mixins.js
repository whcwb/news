var moment = require('moment')
export const mixins = {
  methods:{
    // 锚点定位
    toFixPosition(sel) {
      const returnEle = document.querySelector(sel);
      if (!!returnEle) {
        returnEle.scrollIntoView(true);
      }
    }
  },
  filters:{
    time:function (val) {
      return moment(val).format('YYYY-MM-DD HH:mm:ss')
    }
  }
}
