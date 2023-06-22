window.addEventListener('load',function(){

    /**
     * 根据变量名获取匹配值
     */
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    var bookid =getQueryString('id');
    var userid;
    var bookname;
    var check = document.querySelector(".check");
    //自动登录
    $.ajax("../../user/autologin",
        {
            type: "post",
            success : function(data){
                console.log(data);
                var loginsignup = document.querySelector('.loginsignup')
                console.log(data.flag)
                if(data.flag == true){
                    loginsignup.innerHTML = '<div style="text-decoration: none;color: white;font-size: 14px;text-align: center;width:80px; ">'+data.data.name+'<span style="color: greenyellow">，已登录</span>' +'</div>';
                    userid=data.data.id;
                }
            }
        });

    //登出
    document.querySelector('.logout').addEventListener('click',function(){
        $.ajax("../../user/logout",
            {
                type: "post",
                success : function(data){
                    document.location.href="/pages/books.html";
                }

            });
    });





    ///获取书籍信息


    function getBookInfo(){
        $.ajax("../../books/"+bookid,
            {
                type: "get",
                success : function(data){
                    var html='';
                    console.log(data);
                    bookname =data.data.name;


                    html+='<div class = "pic"> <img src="../img/books/'+ bookid +'.png" width="450" height="600">  </div>' +
                        '            <div class = "content">' +
                        '                <h1>'+data.data.name+'</h1>' +
                        '                <p>作者：'+data.data.author+'</p>\n' +
                        '                <p>出版社：'+data.data.publisher+'</p>\n' +
                        '                <p>分类：'+data.data.category+'</p>\n' +
                        '                <p>语言：'+data.data.language+'</p>\n' +
                        '                <p>描述：'+data.data.description+'</p>\n' +
                        '            </div>'
                    document.querySelector('.info').innerHTML =html;
                }
            });
    }

    getBookInfo();


    ///下载

    var zlib =document.querySelector(".zlib")
    zlib.addEventListener("click",function (){
        window.open("https://z-lib.is/s?q="+bookname);
    });

    var taobao =document.querySelector(".taobao")
    taobao.addEventListener("click",function (){
        window.open("https://s.taobao.com/search?q="+bookname);
    });

    var dushu =document.querySelector(".dushu")
    dushu.addEventListener("click",function (){
        window.open("https://www.dushu.com/search.aspx?wd="+bookname);
    });

    var douban =document.querySelector(".douban")
    douban.addEventListener("click",function (){
        window.open("https://www.douban.com/search?q="+bookname);
    });


});