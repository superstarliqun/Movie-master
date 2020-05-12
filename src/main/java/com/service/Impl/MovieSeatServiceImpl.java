package com.service.Impl;

import com.entity.AlreadyPurchased;
import com.mapper.AlreadyPurchasedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mapper.MovieSeatMapper;
import com.entity.MovieSeat;
import com.service.MovieSeatService;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MovieSeatServiceImpl implements MovieSeatService{

    @Autowired
    private MovieSeatMapper movieSeatMapper;

    @Autowired
    AlreadyPurchasedMapper alreadyPurchasedMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return movieSeatMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MovieSeat record) {
        return movieSeatMapper.insert(record);
    }

    @Override
    public int insertSelective(MovieSeat record) {
        return movieSeatMapper.insertSelective(record);
    }

    @Override
    public MovieSeat selectByPrimaryKey(Integer id) {
        return movieSeatMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MovieSeat record) {
        return movieSeatMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MovieSeat record) {
        return movieSeatMapper.updateByPrimaryKey(record);
    }

    @Override
    public HashMap<String, Object> findMovieSeat(Integer id) {
        HashMap<String,Object> map = new HashMap<>();
        String[] strArr;
        ArrayList list = new ArrayList();
        MovieSeat movieSeat = movieSeatMapper.selectByPrimaryKey(id);
        list.add(movieSeat.getOneRow());
        list.add(movieSeat.getTwoRow());
        list.add(movieSeat.getThreeRow());
        list.add(movieSeat.getFourRow());
        list.add(movieSeat.getFiveRow());
        list.add(movieSeat.getSixRow());
        list.add(movieSeat.getSevneRow());
        list.add(movieSeat.getEightRow());
        list.add(movieSeat.getNineRow());
        list.add(movieSeat.getTenRow());
        AlreadyPurchased alreadyPurchased = alreadyPurchasedMapper.selectByPrimaryKey(id);
        if(alreadyPurchased!=null){
            String arry = alreadyPurchased.getArray();
            if(arry!=""&&arry!=null){
                if(arry.indexOf(",")!=-1){
                    strArr= alreadyPurchased.getArray().split(",");
                }else{
                    strArr=new String[]{arry};
                }
            }else{
                strArr =new String [1];
            }
        }else{
            strArr =new String [1];
        }
        //整个座位号排列
        map.put("seatList",list);
        //已经购买的座位号数组
        map.put("buyList",strArr);
        return map;
    }

}
