<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        $("form.loginForm").submit(function () {
            if (0 == $("#name").val().length || 0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });

        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });

        var left = window.innerWidth / 2 + 162;
        $("div.loginSmallDiv").css("left", left);
    })
</script>

<div id="loginDiv" style="position: relative">

    <div class="simpleLogo">
        <a href="${contextPath}"><img src="img/site/simpleLogo.png"></a>
    </div>

    <img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackground.png">

    <form class="loginForm" action="admin_login" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv">
            <div class="loginErrorMessageDiv">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>

            <div class="login_acount_text">后台账户登录</div>
            <div class="loginInput ">
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-user"></span>
                </span>
                <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
            </div>

            <div class="loginInput ">
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-lock"></span>
                </span>
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>
            <div class="loginInput " style="height: auto">

                <input id="checks" name="checks" class="input-text size-L" type="text" value="验证码:" style="width:150px;"/>
                <img id="imgVerify" src=""/><a href="" rel="nofollow">看不清，换一张</a>

            </div>
            <span class="text-danger">不要输入真实的天猫账号密码</span><br><br>

            <div>
                <a class="notImplementLink" href="#nowhere">忘记登录密码</a>
                <a href="registerPage" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit">登录</button>
            </div>
        </div>
    </form>

</div>
<script type="text/javascript">
    $(document.body).ready(function () {
        //首次获取验证码
        $("#imgVerify").attr("src","/admin_getVerify?"+Math.random());
    });
    //获取验证码
    function getVerify(){
        var src1=document.getElementById('imgVerify')
        src1.src = "/user/getVerify?"+Math.random();
    }
    //校验验证码
    function checkSum(){
        var html1=document.getElementById('loginingForm');
        var inputStr = $("#checks").val();
        if(inputStr!=null && inputStr!="" && inputStr!="验证码:"){
            inputStr = inputStr.toUpperCase();//将输入的字母全部转换成大写
            html1.action="/user/login?inputStr="+inputStr;//提交表单
        }else{
            alert("验证码不能为空!")
        }
    }
    //登录验证
    function doLogin() {
        var userName=document.getElementById('name').value;
        var password=document.getElementById('password').value;
        if(null==userName||null==password||""==userName||""==password){
            alert('用户名或密码不能为空!');
        }else {
            //校验验证码
            checkSum();
        }
    }
</script>