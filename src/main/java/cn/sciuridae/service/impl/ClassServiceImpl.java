package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Class;
import cn.sciuridae.dao.ClassMapper;
import cn.sciuridae.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public Page<Class> findByClass(int current, int limit) {
        PageHelper.startPage(current, limit);
        return classMapper.getclass();
    }
}
