package cn.sciuridae.service;

import cn.sciuridae.bean.Class;
import cn.sciuridae.bean.show.tagsShow;
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
public interface ClassService extends IService<Class> {
    Page<Class> findByClass(int current, int limit);
}
