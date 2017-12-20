INSERT INTO `j_permission` VALUES (1, 0, 0, '系统组织管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 1, 1, NULL);
INSERT INTO `j_permission` VALUES (2, 1, 1, '系统管理', 2, 'upms:system:read', '/manage/system/index', 'glyphicon glyphicon-apple', 1, 2, 2, NULL);
INSERT INTO `j_permission` VALUES (3, 1, 1, '组织管理', 2, 'upms:organization:read', '/manage/organization/index', 'glyphicon glyphicon-apple', 1, 3, 3, NULL);
INSERT INTO `j_permission` VALUES (4, 0, 0, '角色用户管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 4, 4, NULL);
INSERT INTO `j_permission` VALUES (5, 4, 4, '角色管理', 2, 'upms:role:read', '/manage/role/index', 'glyphicon glyphicon-apple', 1, 6, 6, NULL);
INSERT INTO `j_permission` VALUES (6, 4, 4, '用户管理', 2, 'upms:user:read', '/manage/user/index', 'glyphicon glyphicon-apple', 1, 5, 5, NULL);
INSERT INTO `j_permission` VALUES (7, 0, 0, '权限资源管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 7, 7, NULL);
INSERT INTO `j_permission` VALUES (12, 0, 0, '其他数据管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 12, 12, NULL);
INSERT INTO `j_permission` VALUES (14, 12, 12, '会话管理', 2, 'upms:session:read', '/manage/session/index', 'glyphicon glyphicon-apple', 1, 14, 14, NULL);
INSERT INTO `j_permission` VALUES (15, 12, 12, '日志记录', 2, 'upms:log:read', '/manage/log/index', 'glyphicon glyphicon-apple', 1, 15, 15, NULL);
INSERT INTO `j_permission` VALUES (17, 0, 0, '标签类目管理', 1, NULL, NULL, 'glyphicon glyphicon-apple', 1, 17, 17, NULL);
INSERT INTO `j_permission` VALUES (18, 17, 17, '标签管理', 2, 'cms:tag:read', '/manage/tag/index', 'glyphicon glyphicon-apple', 1, 18, 18, NULL);
INSERT INTO `j_permission` VALUES (19, 17, 17, '类目管理', 2, 'cms:category:read', '/manage/category/index', 'glyphicon glyphicon-apple', 1, 19, 19, NULL);
INSERT INTO `j_permission` VALUES (20, 0, 0, '文章评论管理', 1, NULL, NULL, 'glyphicon glyphicon-apple', 1, 20, 20, NULL);
INSERT INTO `j_permission` VALUES (21, 20, 20, '文章管理', 2, 'cms:article:read', '/manage/article/index', 'glyphicon glyphicon-apple', 1, 21, 21, NULL);
INSERT INTO `j_permission` VALUES (22, 20, 20, '回收管理', 2, 'cms:article:read', '/manage/article/recycle', 'glyphicon glyphicon-apple', 1, 22, 22, NULL);
INSERT INTO `j_permission` VALUES (24, 2, 2, '新增系统', 3, 'upms:system:create', '/manage/system/create', 'glyphicon glyphicon-apple', 1, 24, 24, NULL);
INSERT INTO `j_permission` VALUES (25, 2, 2, '编辑系统', 3, 'upms:system:update', '/manage/system/update', 'glyphicon glyphicon-apple', 1, 25, 25, NULL);
INSERT INTO `j_permission` VALUES (26, 2, 2, '删除系统', 3, 'upms:system:delete', '/manage/system/delete', 'glyphicon glyphicon-apple', 1, 26, 26, NULL);
INSERT INTO `j_permission` VALUES (27, 3, 3, '新增组织', 3, 'upms:organization:create', '/manage/organization/create', 'glyphicon glyphicon-apple', 1, 27, 27, NULL);
INSERT INTO `j_permission` VALUES (28, 3, 3, '编辑组织', 3, 'upms:organization:update', '/manage/organization/update', 'glyphicon glyphicon-apple', 1, 28, 28, NULL);
INSERT INTO `j_permission` VALUES (29, 3, 3, '删除组织', 3, 'upms:organization:delete', '/manage/organization/delete', 'glyphicon glyphicon-apple', 1, 29, 29, NULL);
INSERT INTO `j_permission` VALUES (30, 6, 6, '新增用户', 3, 'upms:user:create', '/manage/user/create', 'glyphicon glyphicon-apple', 1, 30, 30, NULL);
INSERT INTO `j_permission` VALUES (31, 6, 6, '编辑用户', 3, 'upms:user:update', '/manage/user/update', 'glyphicon glyphicon-apple', 1, 31, 31, NULL);
INSERT INTO `j_permission` VALUES (32, 6, 6, '删除用户', 3, 'upms:user:delete', '/manage/user/delete', 'glyphicon glyphicon-apple', 1, 32, 32, NULL);
INSERT INTO `j_permission` VALUES (33, 5, 5, '新增角色', 3, 'upms:role:create', '/manage/role/create', 'glyphicon glyphicon-apple', 1, 33, 33, NULL);
INSERT INTO `j_permission` VALUES (34, 5, 5, '编辑角色', 3, 'upms:role:update', '/manage/role/update', 'glyphicon glyphicon-apple', 1, 34, 34, NULL);
INSERT INTO `j_permission` VALUES (35, 5, 5, '删除角色', 3, 'upms:role:delete', '/manage/role/delete', 'glyphicon glyphicon-apple', 1, 35, 35, NULL);
INSERT INTO `j_permission` VALUES (36, 39, 39, '新增权限', 3, 'upms:permission:create', '/manage/permission/create', 'glyphicon glyphicon-apple', 1, 36, 36, NULL);
INSERT INTO `j_permission` VALUES (37, 39, 39, '编辑权限', 3, 'upms:permission:update', '/manage/permission/update', 'glyphicon glyphicon-apple', 1, 37, 37, NULL);
INSERT INTO `j_permission` VALUES (38, 39, 39, '删除权限', 3, 'upms:permission:delete', '/manage/permission/delete', 'glyphicon glyphicon-apple', 1, 38, 38, NULL);
INSERT INTO `j_permission` VALUES (39, 7, 7, '权限管理', 2, 'upms:permission:read', '/manage/permission/index', 'glyphicon glyphicon-apple', 1, 39, 39, NULL);
INSERT INTO `j_permission` VALUES (46, 5, 5, '角色权限', 3, 'upms:role:permission', '/manage/role/permission', 'glyphicon glyphicon-apple', 1, 1488091928257, 1488091928257, NULL);
INSERT INTO `j_permission` VALUES (48, 6, 6, '用户组织', 3, 'upms:user:organization', '/manage/user/organization', 'glyphicon glyphicon-apple', 1, 1488120011165, 1488120011165, NULL);
INSERT INTO `j_permission` VALUES (50, 6, 6, '用户角色', 3, 'upms:user:role', '/manage/user/role', 'glyphicon glyphicon-apple', 1, 1488120554175, 1488120554175, NULL);
INSERT INTO `j_permission` VALUES (51, 6, 6, '用户权限', 3, 'upms:user:permission', '/manage/user/permission', 'glyphicon glyphicon-apple', 1, 1488092013302, 1488092013302, NULL);
INSERT INTO `j_permission` VALUES (53, 14, 14, '强制退出', 3, 'upms:session:forceout', '/manage/session/forceout', 'glyphicon glyphicon-apple', 1, 1488379514715, 1488379514715, NULL);
INSERT INTO `j_permission` VALUES (54, 18, 18, '新增标签', 3, 'cms:tag:create', '/manage/tag/create', 'glyphicon glyphicon-apple', 1, 1489417315159, 1489417315159, NULL);
INSERT INTO `j_permission` VALUES (55, 18, 18, '编辑标签', 3, 'cms:tag:update', 'zmdi zmdi-edit', 'glyphicon glyphicon-apple', 1, 1489417344931, 1489417344931, NULL);
INSERT INTO `j_permission` VALUES (56, 18, 18, '删除标签', 3, 'cms:tag:delete', '/manage/tag/delete', 'glyphicon glyphicon-apple', 1, 1489417372114, 1489417372114, NULL);
INSERT INTO `j_permission` VALUES (57, 15, 15, '删除权限', 3, 'upms:log:delete', '/manage/log/delete', 'glyphicon glyphicon-apple', 1, 1489503867909, 1489503867909, NULL);
INSERT INTO `j_permission` VALUES (58, 19, 19, '编辑类目', 3, 'cms:category:update', '/manage/category/update', 'glyphicon glyphicon-apple', 1, 1489586600462, 1489586600462, NULL);
INSERT INTO `j_permission` VALUES (59, 19, 19, '删除类目', 3, 'cms:category:delete', '/manage/category/delete', 'glyphicon glyphicon-apple', 1, 1489586633059, 1489586633059, NULL);
INSERT INTO `j_permission` VALUES (60, 19, 19, '新增类目', 3, 'cms:category:create', '/manage/category/create', 'glyphicon glyphicon-apple', 1, 1489590342089, 1489590342089, NULL);
INSERT INTO `j_permission` VALUES (61, 0, 0, '其他数据管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 1489835455359, 1489835455359, NULL);
INSERT INTO `j_permission` VALUES (62, 20, 20, '评论管理', 2, 'cms:comment:read', '/manage/comment/index', 'glyphicon glyphicon-apple', 1, 1489591408224, 1489591408224, NULL);
INSERT INTO `j_permission` VALUES (63, 62, 62, '删除评论', 3, 'cms:comment:delete', '/manage/comment/delete', 'glyphicon glyphicon-apple', 1, 1489591449614, 1489591449614, NULL);
INSERT INTO `j_permission` VALUES (64, 79, 79, '单页管理', 2, 'cms:page:read', '/manage/page/index', 'glyphicon glyphicon-apple', 1, 1489591332779, 1489591332779, NULL);
INSERT INTO `j_permission` VALUES (65, 64, 64, '新增单页', 3, 'cms:page:create', '/manage/page/create', 'glyphicon glyphicon-apple', 1, 1489591614473, 1489591614473, NULL);
INSERT INTO `j_permission` VALUES (66, 64, 64, '编辑单页', 3, 'cms:page:update', '/manage/page/update', 'glyphicon glyphicon-apple', 1, 1489591653000, 1489591653000, NULL);
INSERT INTO `j_permission` VALUES (67, 64, 64, '删除单页', 3, 'cms:page:delete', '/manage/page/delete', 'glyphicon glyphicon-apple', 1, 1489591683552, 1489591683552, NULL);
INSERT INTO `j_permission` VALUES (68, 61, 61, '菜单管理', 2, 'cms:menu:read', '/manage/menu/index', 'glyphicon glyphicon-apple', 1, 1489591746846, 1489591746846, NULL);
INSERT INTO `j_permission` VALUES (69, 68, 68, '新增菜单', 3, 'cms:menu:create', '/manage/menu/create', 'glyphicon glyphicon-apple', 1, 1489591791747, 1489591791747, NULL);
INSERT INTO `j_permission` VALUES (70, 68, 68, '编辑菜单', 3, 'cms:menu:update', '/manage/menu/update', 'glyphicon glyphicon-apple', 1, 1489591831878, 1489591831878, NULL);
INSERT INTO `j_permission` VALUES (71, 68, 68, '删除菜单', 3, 'cms:menu:delete', '/manage/menu/delete', 'glyphicon glyphicon-apple', 1, 1489591865454, 1489591865454, NULL);
INSERT INTO `j_permission` VALUES (72, 61, 61, '系统设置', 2, 'cms:setting:read', '/manage/setting/index', 'glyphicon glyphicon-apple', 1, 1489591981165, 1489591981165, NULL);
INSERT INTO `j_permission` VALUES (73, 72, 72, '新增设置', 3, 'cms:setting:create', '/manage/setting/create', 'glyphicon glyphicon-apple', 1, 1489592024762, 1489592024762, NULL);
INSERT INTO `j_permission` VALUES (74, 72, 72, '编辑设置', 3, 'cms:setting:update', '/manage/setting/update', 'glyphicon glyphicon-apple', 1, 1489592052582, 1489592052582, NULL);
INSERT INTO `j_permission` VALUES (75, 72, 72, '删除设置', 3, 'cms:setting:delete', '/manage/setting/delete', 'glyphicon glyphicon-apple', 1, 1489592081426, 1489592081426, NULL);
INSERT INTO `j_permission` VALUES (76, 21, 21, '新增文章', 3, 'cms:article:create', '/manage/article/create', 'glyphicon glyphicon-apple', 1, 1489820150404, 1489820150404, NULL);
INSERT INTO `j_permission` VALUES (77, 21, 21, '编辑文章', 3, 'cms:article:update', '/manage/article/update', 'glyphicon glyphicon-apple', 1, 1489820178269, 1489820178269, NULL);
INSERT INTO `j_permission` VALUES (78, 21, 21, '删除文章', 3, 'cms:article:delete', '/manage/article/delete', 'glyphicon glyphicon-apple', 1, 1489820207607, 1489820207607, NULL);
INSERT INTO `j_permission` VALUES (79, 0, 0, '单页专题管理', 1, '', '', 'glyphicon glyphicon-apple', 1, 1489835320327, 1489835320327, NULL);
INSERT INTO `j_permission` VALUES (80, 79, 79, '专题管理', 2, 'cms:topic:read', '/manage/topic/index', 'glyphicon glyphicon-apple', 1, 1489591507566, 1489591507566, NULL);
INSERT INTO `j_permission` VALUES (81, 80, 80, '新增专题', 3, 'cms:topic:create', '/manage/topic/create', 'glyphicon glyphicon-apple', 1, 1489843327028, 1489843327028, NULL);
INSERT INTO `j_permission` VALUES (82, 80, 80, '编辑专题', 3, 'cms:topic:update', '/manage/topic/update', 'glyphicon glyphicon-apple', 1, 1489843351513, 1489843351513, NULL);
INSERT INTO `j_permission` VALUES (83, 80, 80, '删除专题', 3, 'cms:topic:delete', '/manage/topic/delete', 'glyphicon glyphicon-apple', 1, 1489843379953, 1489843379953, NULL);
INSERT INTO `j_permission` VALUES (84, 68, 68, '上移菜单', 3, 'cms:menu:up', '/manage/menu/up', 'glyphicon glyphicon-apple', 1, 1489846486548, 1489846486548, NULL);
INSERT INTO `j_permission` VALUES (85, 68, 68, '下移菜单', 3, 'cms:menu:down', '/manage/menu/down', 'glyphicon glyphicon-apple', 1, 1489846578051, 1489846578051, NULL);