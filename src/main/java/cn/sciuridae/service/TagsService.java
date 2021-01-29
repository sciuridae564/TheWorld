package cn.sciuridae.service;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.bean.show.tagsShow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
public interface TagsService extends IService<Tags> {
    List<Tags> getTags(boolean type);
    Integer getTags(String tags);
    Page<tagsShow> findByPaging(int current, int limit);
}
