package cn.sciuridae.service;

import cn.sciuridae.bean.Tags;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
