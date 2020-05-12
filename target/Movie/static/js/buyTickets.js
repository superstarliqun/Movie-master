function initCinema(movieId,region) {
    var html = "";
    $.ajax({
        url:"/Movie/Cinema/findMovieByCinema",
        data:{
            "movieId":movieId,
            "region":region
        },
        dataType:"json",   //返回格式为json
        async:false,
        type:"GET",   //请求方式
        success:function(data) {
            $.each(data.data,function (i) {
                html+='<div class="cinema-cell">'+
                    '<div class="cinema-info">'+
                    '<a class="cinema-name">'+this.cinemaName+'</a>'+
                    '<p class="cinema-address">地址：'+this.address+'</p>'+
                    '</div>'+
                    '<div class="buy-btn">'+
                    '<a href="/Movie/views/view/selectSeat.html?movie_id='+movieId+'&Cinema='+this.id+'">选座购票</a>'+
                    '</div>'+
                    '<div class="price" style="width: 120px">'+
                    '<span style="margin-left:5px;">城区：</span>'+
                    '<span class="price-num red"><span class="stonefont">'+this.region+'</span></span>'+
                    '</div></div>';
            });
            $(".styad").html(html)
        }
    });
}
function initDetail(id) {
    var movieDatailTop=$(".movie-brief-container");
    var stonefont =  $(".info-num");
    var stonefontNum = $(".stonefont-num");
    var dra = $(".dra")
    var style = $(".stylq")
    var performerOne= $(".performer")
    var avatarShadow = $(".avatar-shadow")
    var html ="";
    var performer ="";
    $.ajax({
        url:"/Movie/movie/findOneMovie",
        data:{"id":id},
        dataType:"json",
        type:"GET",
        success:function(data){

            if(data.data.movieInfo){
                html+='<h3 class="name">'+data.data.movieInfo.movieName+'</h3>'+
                    '<div class="ename ellipsis">Movie Title</div>'+
                    '<ul>'+
                    '<li class="ellipsis">'+data.data.movieInfo.movieCategoryName+'</li>'+
                    '<li class="ellipsis">'+data.data.movieInfo.movieDuration+'分钟</li>'+
                    '<li class="ellipsis">'+data.data.movieInfo.releaseTime+'</li>'+
                    '</ul>';
                movieDatailTop.html(html)
                $(".moreMovie").html('<a class="btn buy" href="/Movie/views/view/detail.html?id='+data.data.movieInfo.id+'" data-act="more-detail-click">查看更多电影详情</a>')
                stonefont.html('<span class="stonefont">'+data.data.movieInfo.doubanScore+'</span>');
                stonefontNum.html('<span class="stonefont">'+data.data.movieInfo.boxOffice+'</span>');
                dra.html(data.data.movieInfo.movieDetails)
                avatarShadow.html('<img class="avatar" src="/Movie'+data.data.movieInfo.movieImgUrl+'" >');
                style.html('<li class="celebrity"><a class="portrait"><img class="default-img" alt="" src="/Movie'+data.data.movieInfo.directorImgUrl+'"></a><div><a style="text-decoration: none;" class="name">'+data.data.movieInfo.director+'</a></div></li>');
            }
            if(data.data.performers){
                $.each(data.data.performers,function (i) {
                    performer+='<li class="celebrity">'+
                        '<a class="portrait">'+
                        '<img class="default-img" src="/Movie'+this.performerUrl+'">'+
                        '</a><div>'+
                        '<a style="text-decoration: none;" class="name">'+this.performerName+'  饰  '+this.performerRole+'</a>'+
                        '</div>'+
                        '</li>';
                })
                performerOne.html(performer)
            }
        }
    });

}



