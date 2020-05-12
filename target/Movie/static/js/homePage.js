function home() {
    var html1="";
    var html2="";
    var high= "";
    var like=""
    $.ajax({
        url:"/Movie/movie/pageMainMovie",    //请求的url地址
        dataType:"json",   //返回格式为json
        type:"GET",   //请求方式
        success:function(data){
            //回显正在热映，以及正在上映
            $.each(data.data.index,function(i){
                if(this.movieStauts==1){
                    html1+='<li>'+
                        '<div class="movie-item">'+
                        '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self" data-act="playingMovie-click" data-val="'+this.doubanScore+'">'+
                        '<div class="movie-poster" style="cursor:default;">'+
                        '<img id="moive_picture" src="/Movie'+this.movieImgUrl+'">'+
                        '<div class="movie-overlay movie-overlay-bg">'+
                        '<div class="movie-info">'+
                        '<div class="movie-score">'+
                        '<i id="moive_score" class="integer">'+this.doubanScore+'</i></div>'+
                        '<div class="movie-title movie-title-padding" title="">'+this.movieName+'</div>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '</a>'+
                        '<div class="movie-detail movie-detail-strong movie-sale">'+
                        '<a href="/Movie/views/view/buyTickets.html?movie_id='+this.id+'" class="active" target="_self" data-act="salePlayingMovie-click" data-val="123">购 票</a>'+
                        '</div>'+
                        '</div>'+
                        '</li>';
                }
                if(this.movieStauts==2){
                    html2+='<li>'+
                        '<div class="movie-item">'+
                        '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self" data-act="playingMovie-click" data-val="">'+
                        '<div class="movie-poster" style="cursor:default;">'+
                        '<img id="moive_picture" src="/Movie'+this.movieImgUrl+'">'+
                        '<div class="movie-overlay movie-overlay-bg">'+
                        '<div class="movie-info">'+
                        '<div class="movie-score"><i id="moive_score" class="integer">'+this.doubanScore+'</i></div>'+
                        '<div class="movie-title movie-title-padding" title="">'+this.movieName+'</div>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '</a>'+
                        '<div class="movie-detail movie-detail-strong movie-presale">'+
                        '<a href="/Movie/views/view/detail.html?id='+this.id+'" id="movie-notice" class="movie-presale-sep movie-notice">预告片</a>'+
                        '<a href="/Movie/views/view/buyTickets.html?movie_id='+this.id+'" id="movie-sale" class="movie-presale-sep movie-sale">预 售</a>'+
                        '</div>'+
                        '</div>'+
                        '</li>';
                }
            })
            //回显总体票房
            $.each(data.data.high,function(i){
                if(i==0){
                    high+='<li class="ranking-item ranking-top ranking-index-'+i+1+'>'+
                        '<a href="\Movie" target="_blank">'+
                        '<div class="ranking-top-left">'+
                        '<i class="ranking-top-icon"></i>'+
                        '<img class="ranking-imgs  default-img" src="/Movie'+this.movieImgUrl+'">'+
                        '</div>'+
                        '<div class="ranking-top-right">'+
                        '<div class="ranking-top-right-main">'+
                        '<span class="ranking-top-moive-name">'+this.movieName+'</span>'+
                        '<p class="ranking-top-wish">'+
                        '<span class="stonefont">'+this.boxOffice+'</span>万'+
                        '</p>'+
                        '</div></div></a></li>';
                }else{
                    high+='<li class="ranking-item ranking-index-4">'+
                        '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self">'+
                        '<span class="normal-link">'+
                        '<i class="ranking-index ranking-index-'+(i+1)+'">'+(i+1)+'</i>'+
                        '<span class="ranking-movie-name">'+this.movieName+'</span>'+
                        '<span class="ranking-num-info">'+
                        '<span class="stonefont">'+this.boxOffice+'</span>万'+
                        '</span>'+
                        '</a>'+
                        '</li>';
                }
            })
            //猜你喜欢
             $.each(data.data.recommend,function (i) {
                 if(i==0){
                     like+='<li class="ranking-item ranking-top ranking-index-1">'+
                         '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self" data-act="mostExpect-movie-click" data-val="{movieid:1229534}">'+
                         '<div class="ranking-top-left">'+
                         '<i class="ranking-top-icon"></i>'+
                         '<img class="ranking-img default-img" src="/Movie'+this.movieImgUrl+'" style="height:193.99px;width:140px;">'+
                         '</div>'+
                         '<div class="ranking-top-right">'+
                         '<div class="ranking-top-right-main">'+
                         '<span class="ranking-top-moive-name">'+this.movieName+'</span>'+
                         '<p class="ranking-release-time">上映时间：'+this.releaseTime+'</p>'+
                         '<p class="ranking-top-wish">'+
                         '<span class="stonefont">'+this.boxOffice+'</span>票房'+
                         '</p></div></div></a></li>';
                 }else if(i==1||i==2){
                     like+='<li class="ranking-item ranking-index-'+(i+1)+'">'+
                         '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self" data-act="mostExpect-movie-click" data-val="{movieid:346210}">'+
                         '<i class="ranking-index">'+(i+1)+'</i>'+
                         '<span class="img-link"><img class="ranking-img default-img" src="/Movie'+this.movieImgUrl+'" style="height:117px;width:170px;"></span>'+
                         '<div class="name-link ranking-movie-name">'+this.movieName+'</div>'+
                         '<span class="ranking-num-info"><span class="stonefont">'+this.boxOffice+'</span>票房</span>'+
                         '</a>'+
                         '</li>';
                 }else{
                     like+='<li class="ranking-item ranking-index-'+(i+1)+'">'+
                         '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self" data-act="mostExpect-movie-click" data-val="{movieid:1215605}">'+
                         '<span class="normal-link">'+
                         '<i class="ranking-index">'+(i+1)+'</i>'+
                         '<span class="ranking-movie-name">'+this.movieName+'</span>'+
                         '<span class="ranking-num-info">'+
                         '<span class="stonefont">'+this.boxOffice+'</span>票房</span>'+
                         '</a>'+
                         '</li>';
                 }
             })
            $(".movie-hot").html(html1);
            $(".movie-on").html(html2);
            $(".boxOffice").html(high);
            $(".ranking-mostExpect").html(like);
        }
    });
}
//初始化电影数据
function initData(type,stauts) {
    var html="";
    $.ajax({
        url:"/Movie/movie/findTypeMovie",    //请求的url地址
        data:{
            "type":type,
            "stauts":stauts
        },
        dataType:"json",   //返回格式为json
        type:"GET",   //请求方式
        success:function(data){
            $.each(data.data,function (i) {
                html+='<li>'+
                    '<div class="movie-item">'+
                    '<a href="/Movie/views/view/detail.html?id='+this.id+'" target="_self">'+
                    '<div class="movie-poster">'+
                    '<img src="/Movie'+this.movieImgUrl+'">'+
                    '</div>'+
                    '</a>'+
                    '<div class="channel-action channel-action-sale">'+
                    '<a>购票</a>'+
                    '</div>'+
                    '</div>'+
                    '<div class="channel-detail movie-item-title" title="'+this.movieName+'">'+
                    '<a href="./movieDetail.jsp" target="_blank">'+this.movieName+'</a>'+
                    '</div>'+
                    '<div class="channel-detail channel-detail-orange">'+
                    '<i class="integer">'+this.doubanScore+'分</i>'+
                    '</div>'+
                    '</li>';
            });
            $(".movie-list").html(html)

        }
    });
}

//影院列表查询
function cinemaList() {
    var html ="";
    $.ajax({
        url:"/Movie/Cinema/getAllCinema",    //请求的url地址
        dataType:"json",   //返回格式为json
        type:"GET",   //请求方式
        success:function(data){
            $.each(data.data,function (i) {
                html+='<div class="cinema-cell">'+
                    '<div class="cinema-info">'+
                    '<a class="cinema-name">'+this.cinemaName+'</a>'+
                    '<p class="cinema-address">地址：'+this.address+'</p>'+
                    '</div>'+
                    '<div class="buy-btn">'+
                    '<a href="#">进入影院</a>'+
                    '</div>'+
                    '<div class="price" style="width: 120px">'+
                    '<span style="margin-left:5px;">城区：</span>'+
                    '<span class="price-num red"><span class="stonefont">'+this.region+'</span></span>'+
                    '</div>'+
                    '</div>';
            })
            $(".cinemas-list").html(html)
        }
    });
}


//获取影院详情信息
function initMovieDetail(id,movieName) {
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
        data:{
            "id":id,
            "movieName":movieName
        },
        dataType:"json",
        type:"GET",
        success:function(data){
            if(JSON.stringify(data.data)!="{}"){
                if(data.data.movieInfo){
                    html+='<h3 class="name">'+data.data.movieInfo.movieName+'</h3>'+
                        '<div class="ename ellipsis">Movie Title</div>'+
                        '<ul>'+
                        '<li class="ellipsis">'+data.data.movieInfo.movieCategoryName+'</li>'+
                        '<li class="ellipsis">'+data.data.movieInfo.movieDuration+'分钟</li>'+
                        '<li class="ellipsis">'+data.data.movieInfo.releaseTime+'</li>'+
                        '</ul>';
                    movieDatailTop.html(html)
                    stonefont.html('<span class="stonefont">'+data.data.movieInfo.doubanScore+'</span>');
                    stonefontNum.html('<span class="stonefont">'+data.data.movieInfo.boxOffice+'</span>');
                    dra.html(data.data.movieInfo.movieDetails)
                    $(".stylo").html('<a class="wish " data-wish="false" href="/Movie/views/view/buyTickets.html?movie_id='+data.data.movieInfo.id+'"><div><i class="icon wish-icon"></i><span class="wish-msg" data-act="wish-click">购票</span></div></a>')
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
            }else{
                // console.log(JSON.stringify(data.data)="{}")
                window.location.href="/Movie/index.html"
            }
            }
    });

    
}

