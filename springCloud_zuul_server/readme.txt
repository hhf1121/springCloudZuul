1.zuul_server端
2.作为config的Client端

动态网关：（集成到config码云）
eureka
+springCloud_disconfServer
+springCloud_zuul_server（configClient）
+user
+vip


网关集群：（使用ngix拦截、然后分发到不同的网关）
ngix：映射81、82
分别启动81、82的zuul网关

