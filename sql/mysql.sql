-- 权限表
CREATE TABLE `rights`
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    title     VARCHAR(20)  NOT NULL,
    path      VARCHAR(100) NOT NULL,
    icon      VARCHAR(100) NOT NULL,
    parent_id INT     DEFAULT 0, -- 父级菜单id
    is_leaf   TINYINT DEFAULT 0  -- 是否是叶子菜单：0-否，1-是
);

-- 清空表（可选，初始化时使用）
TRUNCATE TABLE rights;

-- 首页
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('首页', '/index', 'HomeFilled', 0, 0);
-- 用户管理 id=2
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('用户管理', '/user-manage', 'User', 0, 0);
-- 插入用户管理的子节点
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('用户列表', '/user-manage/list', 'List', 2, 1);
-- 权限管理 id=4
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('权限管理', '/right-manage', 'Key', 0, 0);
-- 插入权限管理的子节点
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('角色列表', '/right-manage/rolelist', 'List', 4, 1),
       ('权限列表', '/right-manage/rightlist', 'List', 4, 1);
-- 实验室管理 id=7
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('实验室管理', '/lab-manage', 'OfficeBuilding', 0, 0);
-- 插入实验室管理的子节点
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('实验室列表', '/lab-manage/lablist', 'List', 7, 1),
       ('添加实验室', '/lab-manage/addlab', 'List', 7, 1);
-- 预约管理 id=10
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('预约管理', '/book-manage', 'UploadFilled', 0, 0);
-- 插入预约管理的子节点
INSERT INTO rights (title, path, icon, parent_id, is_leaf)
VALUES ('审核列表', '/book-manage/auditlist', 'List', 10, 1),
       ('预约列表', '/book-manage/booklist', 'List', 10, 1),
       ('预约实验室', '/book-manage/addbook', 'List', 10, 1);


-- 角色表
CREATE TABLE roles
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    roleName VARCHAR(20) NOT NULL,
    roleType INT         NOT NULL,
    rights   JSON        NOT NULL
);

INSERT INTO roles(roleName, roleType, rights)
VALUES ('管理员',
        1,
        '[
          "/index",
          "/user-manage",
          "/user-manage/list",
          "/right-manage",
          "/right-manage/rolelist",
          "/right-manage/rightlist",
          "/lab-manage",
          "/lab-manage/lablist",
          "/lab-manage/addlab",
          "/book-manage",
          "/book-manage/auditlist",
          "/book-manage/booklist"
        ]');


INSERT INTO roles(roleName, roleType, rights)
VALUES ('教师',
        2,
        '[
          "/index",
          "/book-manage",
          "/book-manage/booklist",
          "/book-manage/addbook"
        ]');


-- 用户表
CREATE TABLE users
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(20) NOT NULL,
    password   VARCHAR(20) NOT NULL,
    roleId     INT         NOT NULL,
    is_default INT DEFAULT '0'
);
INSERT INTO users (username, password, roleId, is_default)
VALUES ('admin', '123', 1, 1);
INSERT INTO users (username, password, roleId)
VALUES ('jerry', '123', 2);

-- 实验室表
CREATE TABLE labs
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(20) NOT NULL,
    capacity    INT DEFAULT '0',
    labType     INT DEFAULT '0',
    collegeType INT DEFAULT '0',
    x           INT DEFAULT '0',
    y           INT DEFAULT '0'
);


-- 预约表
CREATE TABLE books
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    labId        INT DEFAULT '0',
    bookTime     DATE,
    bookClass    INT DEFAULT '0',
    bookReason   VARCHAR(100) NOT NULL,
    bookUsername VARCHAR(20)  NOT NULL,
    bookState    INT DEFAULT '0' COMMENT '0-审核中, 1-审核通过, 2-驳回'
)

