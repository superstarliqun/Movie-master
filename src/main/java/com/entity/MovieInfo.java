package com.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class MovieInfo {
    private Integer id;

    /**
     * 电影名称
     */
    private String movieName;

    /**
     * 导演
     */
    private String director;

    /**
     * 导演图片
     */
    private String directorImgUrl;

    /**
     * 电影详情
     */
    private String movieDetails;

    /**
     * 电影图片名称
     */
    private String movieImgName;

    /**
     * 电影图片文件
     */
    private MultipartFile movieFile;

    /**
     * 作者图片文件
     */
    private MultipartFile directorFile;

    /**
     * 电影图片路径
     */
    private String movieImgUrl;

    /**
     * 电影分类id
     */
    private Integer movieCategoryId;

    private String movieCategoryName;

    /**
     * 电影状态   0：普通电影   1：即将上映   2：正在热映
     */
    private String movieStauts;

    /**
     * 豆瓣评分
     */
    private String doubanScore;

    /**
     * 电影时长
     */
    private String movieDuration;

    /**
     * 上映时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 票房
     */
    private String boxOffice;

    public String getMovieCategoryName() {
        return movieCategoryName;
    }

    public void setMovieCategoryName(String movieCategoryName) {
        this.movieCategoryName = movieCategoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorImgUrl() {
        return directorImgUrl;
    }

    public void setDirectorImgUrl(String directorImgUrl) {
        this.directorImgUrl = directorImgUrl;
    }

    public String getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(String movieDetails) {
        this.movieDetails = movieDetails;
    }

    public String getMovieImgName() {
        return movieImgName;
    }

    public void setMovieImgName(String movieImgName) {
        this.movieImgName = movieImgName;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public Integer getMovieCategoryId() {
        return movieCategoryId;
    }

    public void setMovieCategoryId(Integer movieCategoryId) {
        this.movieCategoryId = movieCategoryId;
    }

    public String getMovieStauts() {
        return movieStauts;
    }

    public void setMovieStauts(String movieStauts) {
        this.movieStauts = movieStauts;
    }

    public String getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(String doubanScore) {
        this.doubanScore = doubanScore;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public MultipartFile getMovieFile() {
        return movieFile;
    }

    public void setMovieFile(MultipartFile movieFile) {
        this.movieFile = movieFile;
    }

    public MultipartFile getDirectorFile() {
        return directorFile;
    }

    public void setDirectorFile(MultipartFile directorFile) {
        this.directorFile = directorFile;
    }
}