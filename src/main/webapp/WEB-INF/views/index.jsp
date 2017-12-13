<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2017/12/11
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
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
    <script src="<%=contexPath%>/src/layer/layer.js"></script>
    <script>
        $(function () {
            Vue.http.options.emulateJSON = true;
            var vue = new Vue({
                el: "#app",
                data: {
                    name: "",
                    key: "",
                    description: "",
                    modeList: [],
                    layer: null
                }, created: function () {
                    var inner_url = '/flowDefine/list';
                    this.$http.get(inner_url, {params: {}}).then(function (res) {
                        this.modeList = res.body;
                        /*$("#dbtime").datetimepicker({format: 'yyyy-mm-dd hh:ii:ss', language:  'zh-CN'});*/
                    }, function (res) {
                        // 处理失败的结果
                    });
                }
                , methods: {
                    submit: function () {
                        var inner_url = "/flowDefine/create";
                        this.$http.post(inner_url, {
                            name: this.name,
                            key: this.key,
                            description: this.description
                        }).then(
                            function (res) {

                                if (200 === res.body.state) {

                                    $("#myModal").modal("hide");
                                    var myurl = "http://localhost:8081/modeler.html?modelId=" + res.body.bizdata;
                                    this.edit(myurl)
                                } else if (500 === res.body.state) {
                                    alert(res.body.description);

                                }
                            }, function (res) {
                            }
                        )

                    },
                    edit: function (url) {
                        var index = layer.open({
                            type: 2,
                            content: url,
                            area: ['1024px', '760px'],
                            maxmin: true
                        });
                        this.layer = index;
                        layer.full(this.layer);
                    }, deploy: function (modelid, index) {
                        var inner_url = "/flowDefine/deploy/" + modelid;
                        this.$http.post(inner_url, {}).then(
                            function (res) {
                                if (200 === res.body.state) {
                                    alert(res.body.description);
                                } else if (500 === res.body.state) {
                                    alert(res.body.description);

                                }
                            }, function (res) {
                            })
                    }, deleteModel: function (modelid, index) {
                        var inner_url = "/flowDefine/delete/" + modelid;
                        this.$http.post(inner_url, {}).then(
                            function (res) {

                                this.modeList.splice(index, 1)
                                if (200 === res.body.state) {
                                    this.docomfirm();
                                } else if (500 === res.body.state) {
                                    alert(res.body.description);
                                }
                            }, function (res) {
                            })
                    }, exportModel: function (modelid, filename,type) {

                        var inner_url = '/flowDefine/export/'+modelid+'/'+type;
                       /* window.location.href=inner_url;*/
                        var a = document.createElement('a');
                      /* var url =(window.URL || window.webkitURL).createObjectURL(inner_url); */
                        var filename = filename;
                        a.href = inner_url;
                        a.download = filename;
                        a.click();
                        window.URL.revokeObjectURL(inner_url);

                    },
                    docomfirm: function () {
                        $("#myAlert").slideDown("fast");
                        var inertime = window.setTimeout(function () {
                            $("#myAlert").slideUp("fast");
                            window.clearTimeout(inertime)
                        }, 1000);

                    }
                }, filters: {
                    DateFormat: function (cellval) {
                        if (cellval != null) {
                            var date = new Date(parseInt(cellval, 10));
                            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                            return date.getFullYear() + "-" + month + "-" + currentDate;
                        }
                    }
                }
            });
        })

    </script>
</head>
<body>
<div id="app">

    <%--list--%>
    <div class="panel panel-default">
        <div id="myAlert" style="display: none;margin-bottom:0" class="alert alert-success">
            <%-- <a href="#" class="close" data-dismiss="alert">&times;</a>--%>
            <strong>操作成功！</strong>
        </div>
        <div class="panel-heading text-right">
            <button type="button" id="create" class="btn btn-default btn-sm" data-toggle="modal"
                    data-target="#myModal">
                创建流程
            </button>
        </div>

        <table class="table">
            <tr style="display: flex;">
                <th style="flex:1">id</th>
                <th style="flex:1">name</th>
                <th style="flex: 1">key</th>
                <th style="flex: 1"> 创建时间</th>
                <th style="flex: 1" class="text-center">操作</th>
            </tr>
            <tr v-for="(item,index) in modeList" style="display: flex">
                <td style="flex: 1">{{item.id}}</td>
                <td style="flex: 1">{{item.name}}</td>
                <td style="flex: 1">{{item.key}}</td>
                <td style="flex: 1">{{item.createTime|DateFormat}}</td>
                <td style="flex: 1">
                    <button class="btn btn-primary btn-xs" v-on:click="edit('/modeler.html?modelId='+item.id)">编辑
                    </button>
                    <button class="btn btn-success btn-xs" v-on:click="deploy(item.id,index)">部署
                    </button>
                    <button class="btn btn-info btn-xs" v-on:click="exportModel(item.id, item.name+'.bpmn','bpmn')">xml
                    </button>
                    <button class="btn btn-info btn-xs" v-on:click="exportModel(item.id, item.name+'.json','json')">json
                    </button>
                    <%-- <button class="btn btn-info btn-xs" v-on:click="edit('/modeler.html?modelId='+item.id)">svg
                     </button>--%>
                    <button class="btn btn-danger btn-xs" v-on:click="deleteModel(item.id,index)">删除
                    </button>

                </td>
            </tr>
        </table>
        <div class="panel-footer text-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

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
