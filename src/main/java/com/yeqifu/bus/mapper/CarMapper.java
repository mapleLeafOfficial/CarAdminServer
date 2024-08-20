package com.yeqifu.bus.mapper;

import com.yeqifu.bus.domain.Car;
import com.yeqifu.bus.domain.CarType;
import com.yeqifu.bus.vo.CarTypeVo;
import com.yeqifu.bus.vo.CarVo;
import com.yeqifu.sys.utils.DataGridView;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> queryAllCar(CarVo carVo);

    List<CarType> getAllCartype(CarTypeVo carTypeVo);
}