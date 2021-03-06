package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.bean.show.tagsShow;
import cn.sciuridae.dao.TagsMapper;
import cn.sciuridae.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public Integer getTags(String tags) {
        return tagsMapper.getTegid(tags);
    }

    @Override
    public Page<tagsShow> findByPaging(int current, int limit) {
        PageHelper.startPage(current, limit);
        return tagsMapper.getTeg();
    }
}
