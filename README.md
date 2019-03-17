# SpringBootMovie
基于Spring Boot的电影网站



**项目使用的技术**：

- 框架：Spring Boot 2.0.5.RELEASE、Mybatis
- 模板：Thymeleaf
- 数据库：MySQL
- 缓存：Spring Cache
- 安全控制：Spring Security
- 插件：Druid连接池、Mybatis Generator、通用Mapper、PageHelper分页插件、Lombok、Spring Boot Devtools热部署

**项目运行方式**：

1. 创建数据库spring_boot_movie。
2. 在数据库中运行src/main/resources下的spring_boot_movie.sql文件。
3. 修改src/main/resources的application.properties配置文件中的的数据库用户名和密码。
4. 启动redis服务器。
5. 运行AwesomeVideoAdminApplication.java启动项目。
6. 在浏览器中访问http://localhost:8080/index ，进入电影首页。
7. 在浏览器中访问http://localhost:8080/login ，输入用户名admin，密码123456，进入后台管理系统。