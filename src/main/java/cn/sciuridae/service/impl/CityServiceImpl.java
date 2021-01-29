package cn.sciuridae.service.impl;

import cn.sciuridae.bean.City;
import cn.sciuridae.bean.Class;
import cn.sciuridae.dao.CityMapper;
import cn.sciuridae.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Autowired
    private CityMapper cityMapper;
    @Override
    public int addCity(String cityName) {
        Integer cityid = cityMapper.getCityid(cityName);
        if(cityid!=null){
            return -1;
        }
        try {
            City city=new City();
            city.setCity_time(LocalDateTime.now());
            city.setCity_name(cityName);
            cityMapper.insert(city);
        }catch (Exception e){
            return -2;
        }

        return 0;
    }

    @Override
    public Page<City> findByCity(int current, int limit) {
        PageHelper.startPage(current, limit);
        return cityMapper.getCity();
    }
}
