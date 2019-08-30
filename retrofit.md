### form-encoder 和 multipart data
`Form-encoder`
当方法中出现 @FormUrlEncoded 时表单被发送 ，每一个key -value使用@Field注解

```
@FormUrlEncoded
@Post("user/eidt")
Call<User> updateUser(@Field("first_name") String first,@Field("last_name") String last);
```

`Multipart`
当方法中出现`@Multipart`注解时 ，Multipart请求被使用。使用`@Part`注解声明Parts
```
@Multipart
@Post("user/photo")
Call<User> updateUser(@Part("photo") RequestBody photo , @Part("description") RequestBody description)
```

### Header操作
可以通过`@Headers`注解去设置静态headers
```
@Headers("Cache-Control":max-age=640000)
@GET("widget/list")
Call<List<Widget>> widgetList()
```

```
@Headers({
  "Accept:application/nvd.github.v3full+json",
  "User-Agent:Retrogit-Sample-APP"
  })
  @GET（""）....
```
注意：Header不会相互覆盖，所有相同名字的Headers都被添加在request中

一个request Header可以被动态的更新，通过使用`@Header`注解
```
@GET（"user"）
Call<User> getUser(@Header("Authorization") String Authorization)
```

复杂的Header组合，可以使用Map
```
@GET("user")
Call<User> getUser(@HeaderMap Map<String,String> headers)
```
如果需要为每一个request添加headers，可以使用`OkHttp interceptor`



#### 同步和异步

### Retorift 配置
#### Converters
默认情况下，Retrofit仅仅只能将HTTP bodies反序列化为OkHttp的ResponseBody类型，它可以接受`RequestBody`类型通过@Body注解
Converter 被添加为了去支持返回其他类型， Gson Jsckson Moshi Protobuf Wire SimpleXML
eg:
```
Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://aoi.github.com")
      .addConverterFactory(GsonConverterFactory.creater())
      .build();
GitHubService service = retrofit.create(GitHubService.class);
```
