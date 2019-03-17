# 基于Spring Boot的电影网站

## 项目功能
**普通用户**
- 浏览电影列表
- 查看电影预告与详情
- 查看收录的电影网站
- 查看最新电影动态

**管理员**
- 管理电影预告与详情
- 管理收录的电影网站
- 管理最新电影动态
- 管理网址信息
- 管理友情链接


## 项目使用的技术

- 框架：Spring Boot 2.0.5.RELEASE、Mybatis
- 模板：Thymeleaf
- 数据库：MySQL、Redis
- 缓存：Spring Cache
- 安全控制：Spring Security
- 插件：Druid连接池、Mybatis Generator、通用Mapper、PageHelper分页插件、Lombok、Spring Boot Devtools热部署

## 项目运行方式

1. 创建数据库spring_boot_movie。
2. 在数据库中运行src/main/resources下的spring_boot_movie.sql文件。
3. 修改src/main/resources的application.properties配置文件中的的数据库用户名和密码。
4. 启动Redis服务器。
5. 运行SpringBootMovieApplication.java启动项目。
6. 在浏览器中访问http://localhost:8080/index ，进入电影首页。
7. 在浏览器中访问http://localhost:8080/login ，输入用户名admin，密码123456，进入后台管理系统。

## 项目界面截图

<img src="https://raw.githubusercontent.com/lkmc2/SpringBootMovie/master/picture/%E7%94%B5%E5%BD%B1%E9%A6%96%E9%A1%B5.png"/>

<img src="https://raw.githubusercontent.com/lkmc2/SpringBootMovie/master/picture/%E7%94%B5%E5%BD%B1%E8%AF%A6%E6%83%85%E9%A1%B5.png"/>

<img src="https://raw.githubusercontent.com/lkmc2/SpringBootMovie/master/picture/%E5%90%8E%E5%8F%B0%E6%B7%BB%E5%8A%A0%E7%94%B5%E5%BD%B1%E4%BF%A1%E6%81%AF.png"/>

<img src="https://raw.githubusercontent.com/lkmc2/SpringBootMovie/master/picture/%E5%90%8E%E5%8F%B0%E7%94%B5%E5%BD%B1%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86.png"/>