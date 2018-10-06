<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/4
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#upload").click(function () {
                console.log("lll");
                $("#imgWait").show();
                var formData = new FormData();
                console.log( document.getElementById("file1").files[0])
                formData.append("uploadFile",$("#file1")[0].files[0]);
                $.ajax({
                    url: "file/upload",
                    type: "POST",
                    data: formData,
                    /**
                     *必须false才会自动加上正确的Content-Type
                     */
                    contentType: false,
                    /**
                     * 必须false才会避开jQuery对 formdata 的默认处理
                     * XMLHttpRequest会对 formdata 进行正确的处理
                     */
                    processData: false,
                    success: function (data) {
                        if (data.toString() != null) {
                            $("#imgSrc").attr("src","http://39.107.81.205/"+data.toString());
                            $("#imgSrc").show();
                            alert("上传成功！");
                        }

                    },
                    error: function () {
                        alert("上传失败！");
                        $("#imgSrc").hide();
                    }
                });
            });
        });
    </script>
</head>
<body>
选择文件:<input type="file" id="file1"/><br/>
<input type="button" id="upload" value="上传"/>
<img style="display:none" id="imgSrc"/>
</body>
</html>
