package com.jin321.wx.service.imp;

import com.jin321.wx.dao.SubjectMapper;
import com.jin321.wx.model.Subject;
import com.jin321.wx.model.SubjectExample;
import com.jin321.wx.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hao
 * @Date 2017/9/19 0:04
 * @Description :
 */
@Service("subjectService")
public class SubjectServiceImp implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    public Subject select() {
        List<Subject> subjects = subjectMapper.selectByExample(new SubjectExample());
        return subjects.get(0);
    }
}
