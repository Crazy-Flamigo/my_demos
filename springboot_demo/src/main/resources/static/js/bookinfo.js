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


                    //查询
                    $.ajax("../../favor/iffavor?bookid="+bookid+"&userid="+userid,
                        {
                            type: "get",
                            success : function(data){
                                console.log(data);
                                if (data.flag== true){
                                    favor.style.color="#f7ff15";
                                }
                            }

                        });
                    $.ajax("../../readed/ifreaded?bookid="+bookid+"&userid="+userid,
                        {
                            type: "get",
                            success : function(data){
                                console.log(data);
                                if (data.flag== true){
                                    readed.style.color="#058fb6";
                                    check.style.color="#E73A3AFF"
                                    check.style.fontSize="50px"
                                }
                            }

                        });
                    $.ajax("../../like/iflike?bookid="+bookid+"&userid="+userid,
                        {
                            type: "get",
                            success : function(data){
                                console.log(data);
                                if (data.flag== true){
                                    like.style.color="#ff61b1";
                                }
                            }

                        });


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



    //功能按钮动画
    var readed = document.querySelector('.readed');
    var favor = document.querySelector('.favor');
    var like = document.querySelector('.like');
    var download = document.querySelector('.download');

    favor.addEventListener('mouseenter',function(){
        snabbt(favor, {
            position: [0, 0, 0],
            rotation: [Math.PI, 0, Math.PI],

        });});

    favor.addEventListener('mouseleave',function(){
        snabbt(favor, {
            position: [0, 0, 0],
            rotation: [0, 0, 0],
        });});

    like.addEventListener('mouseenter',function(){
        snabbt(like, {
            rotation: [0, -Math.PI, 0],
            easing: function(value) {
                return value + 0.1 * Math.sin(Math.PI * value);
            }
        }).snabbt({
            rotation: [0, Math.PI, 0],
            easing: 'easeOut'
        });});

    like.addEventListener('mouseleave',function(){
        snabbt(like, {
            rotation: [0, 0, 0]
        });});


    download.addEventListener('mouseenter',function(){
        snabbt(download, {
            position: [0, -100, 0],
            easing: function(value) {
                return value + 0.3 * Math.sin(2*Math.PI * value);
            }
        }).snabbt({
            position: [0, 0, 0],
            easing: 'easeOut'
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
                    //预处理
                    var readeds = data.data.readeds
                    var favors = data.data.favors
                    var likes = data.data.likes
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
                    document.querySelector('.readed_num').innerHTML = readeds;
                    document.querySelector('.favor_num').innerHTML = favors;
                    document.querySelector('.like_num').innerHTML = likes;
                }
            });
    }

    getBookInfo();


    ///////按钮功能
    favor.addEventListener('click',function(){
        if(userid==undefined){
            alert("请先登录再操作！");
            document.location.href="/pages/loginsignup.html?type=login";
        }



        $.ajax("../../favor/favor?bookid="+bookid+"&userid="+userid,
            {
                type: "get",
                success : function(data){
                    console.log(data);
                    getBookInfo();
                    if (data.flag== true){
                        favor.style.color="#f7ff15";
                    }else {
                        favor.style.color="#ffffff";
                    }

                }

            });});

    readed.addEventListener('click',function(){
        if(userid==undefined){
            alert("请先登录再操作！");
            document.location.href="/pages/loginsignup.html?type=login";
        }

        $.ajax("../../readed/readed?bookid="+bookid+"&userid="+userid,
            {
                type: "get",
                success : function(data){
                    console.log(data);
                    getBookInfo();
                    if (data.flag== true){
                        readed.style.color="#058fb6";
                        check.style.color="#E73A3AFF"
                        check.style.fontSize="50px"
                    }else {
                        readed.style.color="#ffffff";
                        check.style.color="#E73A3A00"
                        check.style.fontSize="0px"
                    }

                }

            });});

    like.addEventListener('click',function(){
        if(userid==undefined){
            alert("请先登录再操作！");
            document.location.href="/pages/loginsignup.html?type=login";
        }

        $.ajax("../../like/like?bookid="+bookid+"&userid="+userid,
            {
                type: "get",
                success : function(data){
                    console.log(data);
                    getBookInfo();
                    if (data.flag== true){
                        like.style.color="#ff61b1";
                    }else {
                        like.style.color="#ffffff";
                    }

                }

            });});

    download.addEventListener('click',function(){
        if(userid==undefined){
            alert("请先登录再操作！");
            document.location.href="/pages/loginsignup.html?type=login";
        }

        document.location.href="/pages/bookdownload.html?id="+bookid;
            });








});