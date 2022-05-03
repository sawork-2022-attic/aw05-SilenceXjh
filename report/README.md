### 微服务架构
将eureka的注册服务放在1111端口，gateway放在8080端口，pos-product服务放在2222端口，pos-cart服务放在3333端口。gateway负责接受用户的服务请求并将相应的请求转发至2222或3333端口上。
![image](images/eureka.png)

### 服务功能
查看全部商品信息
![image](images/product1.png)

查看特定商品信息
![image](images/product2.png)

添加购物车
![image](images/cart1.png)
![image](images/cart2.png)

查看购物车信息
![image](images/cart3.png)

给某一购物车加入商品
![image](images/cart4.png)

查看某一购物车的总价
![image](images/cart5.png)