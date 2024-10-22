package com.zayaan_parak.advancedcruddemo.dao;

import com.zayaan_parak.advancedcruddemo.entity.Instructor;
import com.zayaan_parak.advancedcruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
