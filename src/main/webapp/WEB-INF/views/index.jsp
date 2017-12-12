<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2017/12/11
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contexPath = request.getContextPath();%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>jvue</title>
    <script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=contexPath%>/src/vue/vue.js"></script>
    <script src="<%=contexPath%>/src/vue/vue-resource.js"></script>
    <script src="<%=contexPath%>/src/vue/vue-router.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <script>
        $(function () {
            Vue.http.options.emulateJSON = true;
            var vue = new Vue({
                el: "#app",
                data: {
                    hellostr: "流程定义",
                    name: "",
                    key: "",
                    description: ""
                }, methods: {
                    submit: function () {
                        var inner_url = "/flowDefine/create";
                        this.$http.post(inner_url, {name: this.name, key: this.key, description: this.description}).then(
                            function (res) {

                                if (200 === res.body.state) {
                                    alert(res.body.description);
                                    $("#myModal").modal("hide");
                                } else if (500 === res.body.state) {
                                    alert(res.body.description);
                                   /* router.push({name: 'list', params: {}, query: {loginname: this.loginname}})*/
                                }
                            }, function (res) {
                            }
                        )

                    }
                }
            });
        })

    </script>
</head>
<body>
<div id="app"><h3>{{hellostr}}</h3>
    <!-- Button trigger modal -->
    <button type="button" id="create" class="btn btn-primary" data-toggle="modal"
            data-target="#myModal">
        创建流程
    </button>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">创建新流程</h4>
                </div>
                <div class="modal-body">
                    <form id="modelform">
                        <div class="form-group">
                            <label for="name">名称</label>
                            <input type="text" class="form-control" id="name" v-model="name" name="name"
                                   placeholder="名称">
                        </div>
                        <div class="form-group">
                            <label for="key">流程key</label>
                            <input type="text" class="form-control" id="key" v-model="key" name="key" placeholder="key">
                        </div>
                        <div class="form-group">
                            <label for="description">描述</label>
                            <textarea class="form-control" id="description" v-model="description" name="description"
                                      rows="3"
                                      placeholder="描述"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" v-on:click="submit">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
