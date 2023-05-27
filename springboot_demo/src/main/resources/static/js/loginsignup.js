var signup_avilable = false;

function nameChange(){
    //判断注册登录
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

    var type;
    if( getQueryString('type') === 'login'){
        type=document.querySelector('.login');

    }else if( getQueryString('type') === 'signup'){
        type=document.querySelector('.signup');

    }


    var name = type.querySelector('.name').value;
    var h1 = type.querySelector('h1');
    if(type.className=='mainbox login'){

        if (name.value != ""){
            h1.innerHTML = "欢迎您，"+ name;
        }
        else {
            h1.innerHTML = "欢迎";
        }
    }else {
        if (name.value != ""){
            h1.innerHTML = "欢迎您，"+ name;

            //判断是否有同名用户
            $.ajax("../../user?name="+name,
                {
                    type: "get",
                    success : function(data){
                        if(data.flag == true){
                            h1.innerHTML = '<font color=#ff2222>该用户名已经被注册过了</font>'
                            signup_avilable=false;
                        }
                        else {
                            signup_avilable=true;
                        }
                    }
                });
        }
        else {
            h1.innerHTML = "您好，请先注册";
        }
    }

}










window.addEventListener('load',function(){

    //判断注册登录
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

    if( getQueryString('type') === 'login'){
        document.querySelector('.signup').style.display='none';
        document.querySelector('.login').style.display='block';

    }else if( getQueryString('type') === 'signup'){
        document.querySelector('.signup').style.display='block';
        document.querySelector('.login').style.display='none';

    }




    //注册
    var signup_btn = document.querySelector('.signup_btn');

    signup_btn.addEventListener('click',function (){
        var name = document.querySelector('.name').value;
        var password = document.querySelector('.password').value;
        var password2 = document.querySelector('.password2').value;
        var h1 = document.querySelector('.signup').querySelector('h1');

        var password_same=false;

        if (password2!=password){
            password_same=false;
            h1.innerHTML = '<font color=#ff2222>两次密码输入的不一样</font>'
        }else {
            password_same=true;
        }

        if (signup_avilable && password_same){
            var user = new Object();
            user.name = name;
            user.password = password;
            user.authority = "user";

            $.ajax("../../user/signup",
                {
                    data:user,
                    type: "post",
                    success : function(data){
                        console.log(data);
                    }
                });
        }
        });



    //登录
    var login_btn = document.querySelector('.login_btn');


    login_btn.addEventListener('click',function (){

        var login = document.querySelector('.login')
        var name = login.querySelector('.name').value;
        var password = login.querySelector('.password').value;
        var h1 = login.querySelector('h1');


        $.ajax("../../user/login",
            {
                data: {'name':name,'password':password},
                type: "post",
                success : function(data){
                    console.log(data);
                    var loginsignup = document.querySelector('.loginsignup')
                    console.log(data.flag)
                    if(data.flag == true){
                        loginsignup.innerHTML = '<a style="text-decoration: none;color: white;font-size: 14px;">'+name+'</a>';
                    }
                    else {
                        h1.innerHTML='<font color=#ff2222>您输入的用户名或密码有误</font>'
                    }


                }

            });});



});