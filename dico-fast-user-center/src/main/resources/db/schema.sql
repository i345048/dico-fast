-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
drop table if exists SYS_RESOURCES;

/*==============================================================*/
/* Table: SYS_RESOURCES                                         */
/*==============================================================*/
create table SYS_RESOURCES
(
   ID                   varchar(32) not null,
   NAME                 varchar(20),
   TYPE                 varchar(2),
   URL                  varchar(100),
   ICON                 varchar(50),
   PRIORITY             bigint,
   PID                  varchar(32),
   primary key (ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table SYS_RESOURCES modify column ID varchar(32) comment 'ID';
alter table SYS_RESOURCES modify column NAME varchar(20) comment '资源名称';
alter table SYS_RESOURCES modify column TYPE varchar(2) comment '资源类型';
alter table SYS_RESOURCES modify column URL varchar(100) comment 'URL';
alter table SYS_RESOURCES modify column ICON varchar(50) comment '图标';
alter table SYS_RESOURCES modify column PRIORITY bigint comment '优先级';
alter table SYS_RESOURCES modify column PID varchar(32) comment '父级';

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO SYS_RESOURCES VALUES ('0', '导航菜单', '1', '/', '/', 1, null);
INSERT INTO SYS_RESOURCES VALUES ('063f50746a034e9b853677d9b91a490a', '留言板', '2', '/cms/guestbook/list', 'fa fa-comments', 30, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('08e27f9288d04c7a8839dc65f6cbd1fa', '用户管理', '2', '/users/list', 'fa fa-user', 10, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('09d5b978a1c64a45b69097219d28fdcf', '评价', '2', '/cms/comment/list', 'fa fa-heartbeat', 20, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('0a0bf010a2e54ee5a82d0d2fe3708d2f', '部门管理', '2', '/sysDepartment/list', 'fa fa-sitemap', 8, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('0f2e7296b02d4d01997fbe9a660aaa1f', '经销商', '2', '/distributor/list', 'fa fa-globe', 40, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('1439d292f9aa4dcf844bb7431b5749b6', '商品标签', '2', '/productLabel/productLabel/list', 'fa fa-cc', 32, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('172ca37c99c74c88be3d8a3d73022190', '流程定义', '2', '/actProcess/list', 'fa fa-share-alt', 20, '5c0c01825b124302aa131123178ec112');
INSERT INTO SYS_RESOURCES VALUES ('1935454d3dd5462284fdae6b8fa59009', '退货操作信息', '2', '/warehouse/olRejectLog/list', 'fa fa-list-alt', 12, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('1b21c59ab01846f59a7130b25303cdf7', '订单操作记录', '2', '/orderlang/orderLog/list', 'fa fa-hand-pointer-o', 20, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('1b57266d05aa492b858aa43efbd3ae60', '栏目', '1', '/cms/category/list', 'fa fa-th-list', 10, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('1b599b91cbd641af945f7a1e6444c108', '商品品牌', '1', '/distributor/product_brand', 'fa fa-plus-circle', 37, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('2371dd846ca8490eb56923737b687430', '支付记录', '2', '/orderlang/payLog/list', 'fa fa-pencil', 70, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('24cbf2319d1f49b394a28344a5d2d391', '考试管理', '1', '/exam/exam/list', 'fa fa-pencil', 3, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('267d1152ea67419982c075a98c9e9a47', '用户收藏', '1', '/collect/userCollect/list', 'fa fa-th-list', 1, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('26846f5ac89242fcb9bf31508898fc0d', '支付表', '1', '/orderlang/pay/list', 'fa fa-star', 40, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('27e2f648a1754c4daa507c9686d36c1a', '退款表', '1', '/orderlang/refund/list', 'fa fa-minus-circle', 50, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('28f7747012fa4609875bd6550d858856', '商品单位', '1', '/distributor/product_unit', 'fa fa-retweet', 38, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('2a2a2bb7d0134d378efb4ad675d0b99d', '标签云', '1', '/cms/tagcloud/list', 'fa fa-bookmark', 25, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('2ae792d4958e4cc9b1bea18f87228167', '商品管理', '1', '/product/product/list', 'fa fa-suitcase', 30, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('2d4974e5507643c4b1e14d3a68184f36', '退货商品', '1', '/warehouse/olRejectProduct/list', 'fa fa-database', 11, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('2d56ccacfd1b49bfa399832745b2b543', '收货地址', '', '/orderlang/userAddress/list', 'fa fa-building-o', 60, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('2db887eb47aa458d9d04d54489b0684f', 'DruidMonitor', '2', '/druid/index.html', 'fa fa-eye', 999, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('3157c245e0944b15877e4417c5f74134', '启动流程', '1', '/actTask/process', 'fa fa-skyatlas', 15, '665a638d8ba9446c8da9fae0d8dd50e2');
INSERT INTO SYS_RESOURCES VALUES ('316740ac2856437daad2c4ec194dcb21', '退货信息', '1', '/warehouse/reject/list', 'fa fa-level-down', 9, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('3287d7edd9bd405a965f13dbb1bcbb94', '库存管理', '1', '/distributor/distributor/inventory_list', 'fa fa-bitbucket-square', 3, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('33f2967a952d4de18922fc6d0ac8b94d', '活动文章关联', '1', '/cms/activityArticle/list', 'fa fa-share-square-o', 45, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('3a99c89d9147494baca8b639980195fd', '试卷管理', '1', '/exam/paper/list', 'fa fa-list-alt', 2, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('3c819e7e1a3d434b9e14e04fb7b5b6d4', '生成试题', '1', '/exam/paper/list', 'fa fa-keyboard-o', 4, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('3def9af46fe44b499df7b14ff3ab2079', '站点', '1', '/cms/site/list', 'fa fa-star-o', 5, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('480ea019fd1747ca8d6c628dabe8dec8', '城市管理', '1', '/sys/city/list', 'fa fa-globe', 14, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('4b82b6dfd7484855bd224f3e674b05d9', '统计图表', '2', '/ks/chartEngine/list', 'fa fa-area-chart', 20, 'b48d762c01c54dce95c31fb42204d126');
INSERT INTO SYS_RESOURCES VALUES ('4c0ae0db699247638586effd58f4edbb', '待办任务', '2', '/actTask/todo', 'fa fa-heartbeat', 5, '665a638d8ba9446c8da9fae0d8dd50e2');
INSERT INTO SYS_RESOURCES VALUES ('4fde67324b0d4fbfaff06ce28836482d', '发货管理', '1', '/warehouse/delivery/list', 'fa fa-upload', 4, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('59db9ca1a1ee496fa8e3fae559e30666', '组员管理', '1', '/exam/groupUser/list', 'fa fa-user', 6, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('5c0c01825b124302aa131123178ec112', '流程建模', '1', '/', 'fa fa-random', 30, 'b48d762c01c54dce95c31fb42204d126');
INSERT INTO SYS_RESOURCES VALUES ('62e818ed15e647bdad4bee8f199ba21f', '业务表建模', '1', '/sys/mod/db/list', 'fa fa-database', 11, 'b48d762c01c54dce95c31fb42204d126');
INSERT INTO SYS_RESOURCES VALUES ('665a638d8ba9446c8da9fae0d8dd50e2', '活动审批', '1', '/', 'fa fa-street-view', 77, '0');
INSERT INTO SYS_RESOURCES VALUES ('687747d2bd6d4edbbc2deff348469fbb', '学习考试', '1', '/', 'fa fa-book', 55, '0');
INSERT INTO SYS_RESOURCES VALUES ('69d0dbfe78684c19bc2200fe35e32685', '学习情况', '1', '/cms/study/list', 'fa fa-thumbs-o-up', 88, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('701d932d0ea74dbd989fd86e6f21c0b6', '物流信息', '1', '/warehouse/logisticsLog/list', 'fa fa-truck', 8, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('82591c22762c40d38579d0db5bd0343c', '订货郎', '1', '/', 'fa fa-glass', 1, '0');
INSERT INTO SYS_RESOURCES VALUES ('82aa90cb5a2b4b6e9592153e9fce6435', '已结束实例', '1', '/actProcess/history', 'fa fa-circle', 40, '5c0c01825b124302aa131123178ec112');
INSERT INTO SYS_RESOURCES VALUES ('837ec95e01614891b916650875d136de', '发票表', '1', '/orderlang/invoice/list', 'fa fa-list-alt', 60, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('87ed420bdd474d9fa164097eb14dccab', '商品规格', '1', '/productSpec/productSpec/list', 'fa fa-table', 34, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('8bf056fec564462e9f6dd02d89630b9d', '菜单管理', '2', '/sysMenu/list', 'fa fa-th-list', 1, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('8fb68d4012d34b6393c3d999dde478ad', '定时任务计划', '1', '/quartz/quartzConf/list', 'fa fa-hospital-o', 888, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('935acd7355634b278549b0ebbba01876', '角色管理', '2', '/roles/list', 'fa fa-user-md', 5, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('93ea441dfd154a0899ba58a8edc7fa64', '用户购物车', '1', '/orderlang/userCart/list', 'fa fa-truck', 50, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('95fee483e011455a822f9a9e6a483fce', '系统字典', '2', '/sys/dict/list', 'fa fa-indent', 99, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('9a7eb11ed94442a49d4d12b48f89b3b0', '已办任务', '1', '/actTask/historic', 'fa fa-sun-o', 10, '665a638d8ba9446c8da9fae0d8dd50e2');
INSERT INTO SYS_RESOURCES VALUES ('9ae54dbcde694559a3d4d3d1cb0d5c21', '经销商用户', '1', '/distributorUser/distributorUser/list', 'fa fa-list-alt', 28, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('9da3f80faa97407cbe4338b605a26176', '省份管理', '1', '/sys/province/list', 'fa fa-globe', 13, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('9fd6e4ab8e8646439447a2a1f6258737', '流程模型', '1', '/actModel/list', 'fa fa-tasks', 10, '5c0c01825b124302aa131123178ec112');
INSERT INTO SYS_RESOURCES VALUES ('a87cd2bddb744ef297e5e9bea6b3e1dc', '发布通知', '2', '/sysNotice/list', 'fa fa-bell', 16, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('aa199719178342a5a3e31c628de359ad', '模块', '1', '/cms/portlet/list', 'fa fa-file-text-o', 12, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('abf203a43a4c4f6eb4863e485db73087', '发货商品', '1', '/warehouse/deliveryProduct/list', 'fa fa-database', 5, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('ac7c384e32414444a1ca3dc48a1aaad7', '出库管理', '1', '/warehouse/outbound/list', 'fa fa-xing', 6, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('acb966356ffe47bda536c7ab5c2b8e5b', '用户浏览', '1', '/browse/userBrowse/list', 'fa fa-list', 10, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('ae68a473f4684d558a0235f1084513f9', '试题导入', '1', '/exam/questionImport/list', 'fa fa-upload', 0, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('afa54364390c4675b4c97a28663a28b7', '文章', '1', '/cms/article/list', 'fa fa-file-o', 15, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('b0e224e666be407f84c59410db2a0b3a', '商品价格', '1', '/productPrice/productPrice/list', 'fa fa-ellipsis-h', 35, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('b19335d14a0a4f57814cc54ad4fb4dc6', '采购商模块', '1', '/', 'fa fa-user', 10, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('b1af2ddcb4a14102890e90f338656df2', '模板', '1', '/cms/template/list', 'fa fa-file-text-o', 7, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('b2f8dab119ed493fb260d21b054a16bc', '分组管理', '1', '/exam/group/list', 'fa fa-sitemap', 5, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('b3d67c1d94d7408f878d9c0726d9f09c', '权限管理', '2', '/sysPermission/list', 'fa fa-tags', 7, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('b48d762c01c54dce95c31fb42204d126', '系统建模', '1', '/', 'fa fa-medium', 88, '0');
INSERT INTO SYS_RESOURCES VALUES ('b8aba593a73143018ca1942afa8936f6', '模块文章关联', '1', '/cms/portletArticle/list', 'fa fa-object-ungroup', 18, 'd63fb68c3af44a5a9bc93afc3edba378');
INSERT INTO SYS_RESOURCES VALUES ('beaf06596cb5490c9f16ef594ebeff37', '商品附件', '1', '/productAttachment/productAttachment/list', 'fa fa-folder-open-o', 33, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('bf7b7fb56f574cda8355fe5aa6e7735c', '数据库字典', '2', '/sys/db/list', 'fa fa-list', 90, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('c1b2318955ad4e64a71a43e5df359013', '商品分类', '1', '/productCategory/list', 'fa fa-indent', 37, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('c617ec2d6eee475ea05fbe779ab3b7c8', '系统管理', '1', '/', 'fa fa-th', 99, '0');
INSERT INTO SYS_RESOURCES VALUES ('c7f3c7ae92de43ae8b40b91ca5c9a2b6', '采购商用户关系', '1', '/orderlang/purchaserUser/list', 'fa fa-align-center', 70, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('cdec666c49a44d5a94e39fc858963138', '题库管理', '1', '/exam/questionLibrary/list', 'fa fa-database', 1, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('cfa08a6b59134ef885a1cab4ed74edef', '出库商品', '1', '/warehouse/outboundProduct/list', 'fa fa-database', 7, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('d63fb68c3af44a5a9bc93afc3edba378', '内容发布', '1', '/', 'fa fa-file-text-o', 66, '0');
INSERT INTO SYS_RESOURCES VALUES ('e293c0ce48354d1896934700e1f0282c', '模块管理', '2', '/sysModule/list', 'fa fa-cubes', 3, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('e6b3d6ce38f84862b1295ae0c55b0ddf', '订单模块', '1', '/', 'fa fa-list-alt', 10, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('f0e20585d58f430d97ccee086d6cd3f9', '试题管理', '1', '/exam/question/list', 'fa fa-database', 1, '687747d2bd6d4edbbc2deff348469fbb');
INSERT INTO SYS_RESOURCES VALUES ('f2b272cb01f84f29bb63a57cdff2e28f', '仓库管理', '1', '/distributor/distributor/warehouse_manage', 'fa fa-home', 2, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('f5b9037921aa4461b61cf002c2779499', '运行中实例', '1', '/actProcess/running', 'fa fa-history', 30, '5c0c01825b124302aa131123178ec112');
INSERT INTO SYS_RESOURCES VALUES ('f77af06593d34c79bc6f2c590de11dc9', '订单', '1', '/orderlang/order/list', 'fa fa-list-ul', 10, 'e6b3d6ce38f84862b1295ae0c55b0ddf');
INSERT INTO SYS_RESOURCES VALUES ('f9253401654549a7ab86d53edf2c0d5b', '系统皮肤', '2', '/sys/skins/list', 'fa fa-gift', 88, 'c617ec2d6eee475ea05fbe779ab3b7c8');
INSERT INTO SYS_RESOURCES VALUES ('f967becc13a540b1b3ba7ca2ac854fc1', '商品详情', '1', '/productDetail/productDetail/list', 'fa fa-file', 31, '82591c22762c40d38579d0db5bd0343c');
INSERT INTO SYS_RESOURCES VALUES ('f9ba9c0eb4ce4186b54195c2573d6381', '采购商', '1', '/purchaser/purchaser/list', 'fa fa-hand-lizard-o', 15, 'b19335d14a0a4f57814cc54ad4fb4dc6');
INSERT INTO SYS_RESOURCES VALUES ('fd294648697140789705349319eeebc5', '订单中的商品明细', '1', '/orderlang/orderProduct/list', 'fa fa-cubes', 30, 'e6b3d6ce38f84862b1295ae0c55b0ddf');


-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通用户');
INSERT INTO `sys_role` VALUES ('3', '超级管理员');
INSERT INTO `sys_role` VALUES ('4', '张三');
INSERT INTO `sys_role` VALUES ('5', '李四');
INSERT INTO `sys_role` VALUES ('6', '王武');
INSERT INTO `sys_role` VALUES ('7', '赵六');
INSERT INTO `sys_role` VALUES ('8', '普通用户');
INSERT INTO `sys_role` VALUES ('9', '超级管理员');
INSERT INTO `sys_role` VALUES ('10', '超级管理员');
INSERT INTO `sys_role` VALUES ('11', '管理员');
INSERT INTO `sys_role` VALUES ('12', '普通用户');
INSERT INTO `sys_role` VALUES ('13', '超级管理员');

-- ----------------------------
-- Table structure for `role_resources`
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources` (
  `roleId` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  PRIMARY KEY  (`roleId`,`resourcesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resources
-- ----------------------------
INSERT INTO `role_resources` VALUES ('1', '2');
INSERT INTO `role_resources` VALUES ('1', '3');
INSERT INTO `role_resources` VALUES ('1', '4');
INSERT INTO `role_resources` VALUES ('1', '5');
INSERT INTO `role_resources` VALUES ('1', '6');
INSERT INTO `role_resources` VALUES ('1', '7');
INSERT INTO `role_resources` VALUES ('1', '8');
INSERT INTO `role_resources` VALUES ('1', '9');
INSERT INTO `role_resources` VALUES ('1', '10');
INSERT INTO `role_resources` VALUES ('1', '11');
INSERT INTO `role_resources` VALUES ('1', '13');
INSERT INTO `role_resources` VALUES ('2', '2');
INSERT INTO `role_resources` VALUES ('2', '3');
INSERT INTO `role_resources` VALUES ('2', '4');
INSERT INTO `role_resources` VALUES ('2', '9');
INSERT INTO `role_resources` VALUES ('3', '2');
INSERT INTO `role_resources` VALUES ('3', '3');
INSERT INTO `role_resources` VALUES ('3', '4');
INSERT INTO `role_resources` VALUES ('3', '5');
INSERT INTO `role_resources` VALUES ('3', '7');
INSERT INTO `role_resources` VALUES ('3', '8');
INSERT INTO `role_resources` VALUES ('3', '9');
INSERT INTO `role_resources` VALUES ('3', '10');
INSERT INTO `role_resources` VALUES ('9', '9');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(33) default NULL,
  `password` varchar(33) default NULL,
  `enable` int(10) default '1' COMMENT '是否启用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '1');
INSERT INTO `sys_user` VALUES ('2', 'user1', '90e66e36e3135a91d298177d4389851e', '1');
INSERT INTO `sys_user` VALUES ('3', 'user2', '121', '0');
INSERT INTO `sys_user` VALUES ('4', 'user3', 'user3', '1');
INSERT INTO `sys_user` VALUES ('5', 'user4', 'user4', '1');
INSERT INTO `sys_user` VALUES ('6', 'user5', 'user5', '1');
INSERT INTO `sys_user` VALUES ('7', 'user6', 'user6', '1');
INSERT INTO `sys_user` VALUES ('8', 'user7', 'user7', '1');
INSERT INTO `sys_user` VALUES ('9', 'user8', 'user8', '1');
INSERT INTO `sys_user` VALUES ('10', 'user9', 'user9', '1');
INSERT INTO `sys_user` VALUES ('11', 'user10', 'user10', '1');
INSERT INTO `sys_user` VALUES ('12', 'user11', 'user11', '1');
INSERT INTO `sys_user` VALUES ('13', 'user12', 'user12', '1');
INSERT INTO `sys_user` VALUES ('14', 'user13', 'user13', '1');
INSERT INTO `sys_user` VALUES ('15', 'user14', 'user14', '1');
INSERT INTO `sys_user` VALUES ('16', 'user15', 'user15', '1');
INSERT INTO `sys_user` VALUES ('17', 'user16', 'user16', '1');
INSERT INTO `sys_user` VALUES ('18', 'user17', 'user17', '1');
INSERT INTO `sys_user` VALUES ('19', 'user18', 'user18', '1');
INSERT INTO `sys_user` VALUES ('21', 'user20', 'user20', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) default NULL,
  `roleId` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('23', '2');
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
