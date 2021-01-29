package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.dao.TagsMapper;
import cn.sciuridae.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {
    @Autowired
    TagsMapper tagsMapper;

    @Override
    public List<Tags> getTags(boolean type) {
        return tagsMapper.getTegs(type);
    }
}
