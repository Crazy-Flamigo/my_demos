window.addEventListener('load',function(){
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


});