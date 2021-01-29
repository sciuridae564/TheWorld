package cn.sciuridae.service;

import cn.sciuridae.bean.City;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
public interface CityService extends IService<City> {
    Integer addCity(String cityName);

    Integer getCityId(String cityName);

    Page<City> findByCity(int current, int limit);
}
