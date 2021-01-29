package cn.sciuridae.service.impl;

import cn.sciuridae.bean.City;
import cn.sciuridae.dao.CityMapper;
import cn.sciuridae.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
