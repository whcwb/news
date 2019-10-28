import Main from '@/view/main'

/**
 * iview-admin中meta除了原生参数外可配置的参数:
 * meta: {
 *  hideInMenu: (false) 设为true后在左侧菜单不会显示该页面选项
 *  notCache: (false) 设为true后页面不会缓存
 *  access: (null) 可访问该页面的权限数组，当前路由设置的权限会影响子路由
 *  icon: (-) 该页面在左侧菜单、面包屑和标签导航处显示的图标，如果是自定义图标，需要在图标名称前加下划线'_'
 * }
 */

export default [
  {
    path: '/login',
    name: 'login',
    meta: {
      title: 'Login - 登录',
      hideInMenu: true
    },
    component: () => import('@/view/login/login.vue')
  },
  {
    path: '/',
    name: 'home',
    redirect: '/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: '/home',
        name: 'home',
        meta: {
          hideInMenu: true,
          title: '首页',
          notCache: true
        },
        component: () => import('@/view/single-page/home')
      }
    ]
  },
  {
    path: '/system',
    name: 'system',
    meta: {
      icon: 'logo-buffer',
      title: '系统设置'
    },
    component: Main,
    children: [
      {
        path: 'system-user',
        name: 'system-user',
        meta: {
          icon: 'md-trending-up',
          title: '用户管理'
        },
        component: () => import('@/view/system/system-user')
      },
      {
        path: 'system-role',
        name: 'system-role',
        meta: {
          icon: '_bear',
          title: '角色管理'
        },
        component: () => import('@/view/system/system-root')
      },
      {
        path: 'system-framework',
        name: 'system-framework',
        meta: {
          icon: '_bear',
          title: '机构管理'
        },
        component: () => import('@/view/system/system-framework')
      },
      {
        path: 'system-function',
        name: 'system-function',
        meta: {
          icon: '_bear',
          title: '功能管理'
        },
        component: () => import('@/view/system/system-function')
      },
      {
        path: 'system_Jurisdiction',
        name: 'system_Jurisdiction',
        meta: {
          icon: '_bear',
          title: '功能管理'
        },
        component: () => import('@/view/system/system-Jurisdiction')
      },
      {
        path: 'system-daily',
        name: 'system-daily',
        meta: {
          icon: '_bear',
          title: '日志管理'
        },
        component: () => import('@/view/system/system-daily')
      },
      {
        path: 'dictionaries',
        name: 'dictionaries',
        meta: {
          icon: '_bear',
          title: '字典管理'
        },
        component: () => import('@/view/system/dictionaries')
      }
    ]
  },
  {
    path: '/basicData',
    name: 'basicData',
    meta: {
      icon: 'logo-buffer',
      title: '基础数据'
    },
    component: Main,
    children: [
      {
        path: 'basicData-charge',
        name: 'basicData-charge',
        meta: {
          icon: 'md-trending-up',
          title: '收费项管理'
        },
        component: () => import('@/view/basicData/basicData-charge')
      },
      {
        path: 'basicData-paymoney',
        name: 'basicData-paymoney',
        meta: {
          icon: 'md-trending-up',
          title: '支出费管理'
        },
        component: () => import('@/view/basicData/basicData-paymoney')
      },
      {
        path: 'basicData-discount',
        name: 'basicData-discount',
        meta: {
          icon: '_bear',
          title: '优惠项管理'
        },
        component: () => import('@/view/basicData/basicData-discount')
      },
      {
        path: 'basicData-groupPurchase',
        name: 'basicData-groupPurchase',
        meta: {
          icon: '_bear',
          title: '团购管理'
        },
        component: () => import('@/view/basicData/basicData-groupPurchase')
      },
      {
        path: 'basicData-archives',
        name: 'basicData-archives',
        meta: {
          icon: '_bear',
          title: '档案柜管理'
        },
        component: () => import('@/view/basicData/basicData-archives')
      },
      // {
      //   path: 'basicData-Coach',
      //   name: 'basicData-Coach',
      //   meta: {
      //     icon: '_bear',
      //     title: '教练员管理'
      //   },
      //   component: () => import('@/view/basicData/basicData-Coach')
      // }
    ]
  },
  {
    path: '/charge',
    name: 'charge',
    meta: {
      icon: 'logo-buffer',
      title: '网站管理'
    },
    component: Main,
    children: [
      {
        path: 'wzymg',
        name: 'wzymg',
        meta: {
          icon: '_bear',
          title: '玩转亚木沟'
        },
        component: () => import('@/view/charge/wzymg')
      },
      {
        path: 'charge-examination',
        name: 'charge-examination',
        meta: {
          icon: '_bear',
          title: 'banner图管理'
        },
        component: () => import('@/view/charge/charge-examination')
      },
      {
        path: 'charge-inspect',
        name: 'charge-inspect',
        meta: {
          icon: '_bear',
          title: '体检收费'
        },
        component: () => import('@/view/charge/charge-inspect')
      },
      {
        path: 'charge-inspect-find',
        name: 'charge-inspect-find',
        meta: {
          icon: '_bear',
          title: '体检查询'
        },
        component: () => import('@/view/charge/charge-inspect-find')
      },
      {
        path: 'charge-inspect-out',
        name: 'charge-inspect-out',
        meta: {
          icon: '_bear',
          title: '新闻资讯'
        },
        component: () => import('@/view/charge/charge-inspect-out')
      },
      {
        path: 'mpgl',
        name: 'mpgl',
        meta: {
          icon: '_bear',
          title: '门票管理'
        },
        component: () => import('@/view/charge/mpgl')
      },
      {
        path: 'lygl',
        name: 'lygl',
        meta: {
          icon: '_bear',
          title: '旅游攻略'
        },
        component: () => import('@/view/charge/lygl')
      },
      {
        path: 'jd',
        name: 'jd',
        meta: {
          icon: '_bear',
          title: '景点管理'
        },
        component: () => import('@/view/charge/jd')
      },
      {
        path: 'photo',
        name: 'photo',
        meta: {
          icon: '_bear',
          title: '图片管理'
        },
        component: () => import('@/view/charge/photo')
      },
      {
        path: 'video',
        name: 'video',
        meta: {
          icon: '_bear',
          title: '视频管理'
        },
        component: () => import('@/view/charge/video')
      }
    ]
  },
  {
    path:'/wx',
    name:'wx',
    meta:{
      icon: 'logo-buffer',
      title: '微信管理'
    },
    component: Main,
    children:[
      {
        path: 'wx-Jurisdiction',
        name: 'wx-Jurisdiction',
        meta: {
          icon: '_bear',
          title: '权限管理'
        },
        component: () => import('@/view/wx/wx_Jurisdiction')
      },{
        path: 'wx-server',
        name: 'wx-server',
        meta: {
          icon: '_bear',
          title: '活动管理'
        },
        component: () => import('@/view/wx/wx_server')
      },{
        path: 'wx-opinion',
        name: 'wx-opinion',
        meta: {
          icon: '_bear',
          title: '意见反馈'
        },
        component: () => import('@/view/wx/wx_opinion')
      },{
        path: 'wx-pl',
        name: 'wx-pl',
        meta: {
          icon: '_bear',
          title: '评论管理'
        },
        component: () => import('@/view/wx/wx_pl')
      },{
        path: 'wx-ts',
        name: 'wx-ts',
        meta: {
          icon: '_bear',
          title: '投诉处理'
        },
        component: () => import('@/view/wx/wx_ts')
      },{
        path: 'wx-yqhy',
        name: 'wx-yqhy',
        meta: {
          icon: '_bear',
          title: '投诉处理'
        },
        component: () => import('@/view/wx/wx_yqhy')
      },{
        path: 'wx-news',
        name: 'wx-news',
        meta: {
          icon: '_bear',
          title: '消息管理'
        },
        component: () => import('@/view/wx/wx_news')
      }
    ]
  },
  // {
  //   path: '',
  //   name: 'doc',
  //   meta: {
  //     title: '文档',
  //     href: 'https://lison16.github.io/iview-admin-doc/#/',
  //     icon: 'ios-book'
  //   }
  // },
  // {
  //   path: '/join',
  //   name: 'join',
  //   component: Main,
  //   children: [
  //     {
  //       path: 'join_page',
  //       name: 'join_page',
  //       meta: {
  //         icon: '_qq',
  //         title: 'QQ群'
  //       },
  //       component: () => import('@/view/join-page.vue')
  //     }
  //   ]
  // },
  // {
  //   path: '/components',
  //   name: 'components',
  //   meta: {
  //     icon: 'logo-buffer',
  //     title: '组件'
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'count_to_page',
  //       name: 'count_to_page',
  //       meta: {
  //         icon: 'md-trending-up',
  //         title: '数字渐变'
  //       },
  //       component: () => import('@/view/components/count-to/count-to.vue')
  //     },
  //     {
  //       path: 'tables_page',
  //       name: 'tables_page',
  //       meta: {
  //         icon: 'md-grid',
  //         title: '多功能表格'
  //       },
  //       component: () => import('@/view/components/tables/tables.vue')
  //     },
  //     {
  //       path: 'split_pane_page',
  //       name: 'split_pane_page',
  //       meta: {
  //         icon: 'md-pause',
  //         title: '分割窗口'
  //       },
  //       component: () => import('@/view/components/split-pane/split-pane.vue')
  //     },
  //     {
  //       path: 'markdown_page',
  //       name: 'markdown_page',
  //       meta: {
  //         icon: 'logo-markdown',
  //         title: 'Markdown编辑器'
  //       },
  //       component: () => import('@/view/components/markdown/markdown.vue')
  //     },
  //     {
  //       path: 'editor_page',
  //       name: 'editor_page',
  //       meta: {
  //         icon: 'ios-create',
  //         title: '富文本编辑器'
  //       },
  //       component: () => import('@/view/components/editor/editor.vue')
  //     },
  //     {
  //       path: 'icons_page',
  //       name: 'icons_page',
  //       meta: {
  //         icon: '_bear',
  //         title: '自定义图标'
  //       },
  //       component: () => import('@/view/components/icons/icons.vue')
  //     }
  //   ]
  // },
  // {
  //   path: '/update',
  //   name: 'update',
  //   meta: {
  //     icon: 'md-cloud-upload',
  //     title: '数据上传'
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'update_table_page',
  //       name: 'update_table_page',
  //       meta: {
  //         icon: 'ios-document',
  //         title: '上传Csv'
  //       },
  //       component: () => import('@/view/update/update-table.vue')
  //     },
  //     {
  //       path: 'update_paste_page',
  //       name: 'update_paste_page',
  //       meta: {
  //         icon: 'md-clipboard',
  //         title: '粘贴表格数据'
  //       },
  //       component: () => import('@/view/update/update-paste.vue')
  //     }
  //   ]
  // },
  // {
  //   path: '/directive',
  //   name: 'directive',
  //   meta: {
  //     hide: true
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'directive_page',
  //       name: 'directive_page',
  //       meta: {
  //         icon: 'ios-navigate',
  //         title: '指令'
  //       },
  //       component: () => import('@/view/directive/directive.vue')
  //     }
  //   ]
  // },
  // {
  //   path: '/multilevel',
  //   name: 'multilevel',
  //   meta: {
  //     icon: 'md-menu',
  //     title: '多级菜单'
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'level_2_1',
  //       name: 'level_2_1',
  //       meta: {
  //         icon: 'arrow-graph-up-right',
  //         title: '二级-1'
  //       },
  //       component: () => import('@/view/multilevel/level-2-1.vue')
  //     },
  //     {
  //       path: 'level_2_2',
  //       name: 'level_2_2',
  //       meta: {
  //         access: ['super_admin'],
  //         icon: 'arrow-graph-up-right',
  //         showAlways: true,
  //         title: '二级-2'
  //       },
  //       component: parentView,
  //       children: [
  //         {
  //           path: 'level_2_2_1',
  //           name: 'level_2_2_1',
  //           meta: {
  //             icon: 'arrow-graph-up-right',
  //             title: '三级'
  //           },
  //           component: () => import('@/view/multilevel/level-2-2/level-3-1.vue')
  //         }
  //       ]
  //     },
  //     {
  //       path: 'level_2_3',
  //       name: 'level_2_3',
  //       meta: {
  //         icon: 'arrow-graph-up-right',
  //         title: '二级-3'
  //       },
  //       component: () => import('@/view/multilevel/level-2-3.vue')
  //     },
  //   ]
  // },
  {
    path: '/401',
    name: 'error_401',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/500',
    name: 'error_500',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/500.vue')
  },
  {
    path: '*',
    name: 'error_404',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/404.vue')
  }
]
